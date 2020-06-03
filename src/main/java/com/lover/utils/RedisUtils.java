package com.lover.utils;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author zheng.shk
 * @Date 10:25 2018/4/23
 */
@Component
public class RedisUtils {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public void set(String key, String value, long expire) {
		redisTemplate.opsForValue().set(key, value);
		redisTemplate.expire(key, expire, TimeUnit.SECONDS);
	}

	public void remove(String key) {
		redisTemplate.delete(key);
	}

	public <T> List<T> batchGet(List<String> keys, Class<T> cls) {
		List<Object> cacheStringList = redisTemplate.opsForValue().multiGet(keys);
		if (Collections.isEmpty(cacheStringList)) {
			return null;
		}
		return cacheStringList.stream().filter(cacheString -> cacheString != null).map(cacheString -> {
			return JSONObject.parseObject(cacheString.toString(), cls);
		}).collect(Collectors.toList());
	}

	public <T> Map<String, T> batchGet(List<String> queryKeys, String resultKey, Class<T> cls) {
		Map<String, T> resultMap = new ConcurrentHashMap<String, T>();
		List<Object> cacheStringList = redisTemplate.opsForValue().multiGet(queryKeys);
		if (!Collections.isEmpty(cacheStringList)) {
			cacheStringList.stream().filter(cacheString -> cacheString != null).forEach(cacheString -> {
				JSONObject jsonObject = JSONObject.parseObject(cacheString.toString());
				resultMap.put(jsonObject.get(resultKey).toString(), JSONObject.toJavaObject(jsonObject, cls));
			});
		}
		return resultMap;
	}

	public String get(String key) {
		Object object = redisTemplate.opsForValue().get(key);
		if (null != object) {
			return object.toString();
		} else {
			return null;
		}
	}
	
	public void hset(String key, String field, Object value, int expire) {
		redisTemplate.opsForHash().put(key, field, value);
		redisTemplate.expire(key, expire, TimeUnit.SECONDS);
	}
	
	public void hset(String key, String field, Object value) {
		redisTemplate.opsForHash().put(key, field, value);
	}

	public void hset(String key, Map map) {
		redisTemplate.opsForHash().putAll(key, map);
	}
	
	public void hset(String key, Map map, long expire) {
		redisTemplate.opsForHash().putAll(key, map);
		redisTemplate.expire(key, expire, TimeUnit.SECONDS);
	}

	public <T> Map<String, Map<String, T>> batchHgetAll(List<String> queryKeys, String resultKey, Class<T> cls) {
		Map<String, Map<String, T>> responseMap = new ConcurrentHashMap<String, Map<String, T>>();
		RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
		List<Object> resultList = redisTemplate.execute(new RedisCallback<List<Object>>() {
			@Override
			public List<Object> doInRedis(RedisConnection connection) throws DataAccessException {
				connection.openPipeline();
				for (String keys : queryKeys) {
					byte[] key = redisSerializer.serialize(keys);
					connection.hGetAll(key);
				}
				return connection.closePipeline();
			}
		});
		if (!Collections.isEmpty(resultList)) {
			resultList.stream().filter(cacheObj -> cacheObj != null).forEach(cacheObj -> {
				Map<byte[], byte[]> cacheMap = (Map<byte[], byte[]>) cacheObj;
				Map<String, T> resultMap = new ConcurrentHashMap<String, T>();
				Iterator<byte[]> iterator = cacheMap.keySet().iterator();
				String outerKey = null;
				while (iterator.hasNext()) {
					byte[] key = iterator.next();
					byte[] value = cacheMap.get(key);
					String stringKey = redisSerializer.deserialize(key);
					String stringVal = redisSerializer.deserialize(value);
					stringVal = stringVal.replaceAll("\\\\", "");
					stringVal = stringVal.substring(1, stringVal.length() - 1);
					JSONObject jsonObject = JSONObject.parseObject(stringVal);
					outerKey = jsonObject.get(resultKey).toString();
					resultMap.put(stringKey, JSONObject.toJavaObject(jsonObject, cls));
				}
				if(resultMap.size() > 0)
				{
					responseMap.put(outerKey, resultMap);
				}
			});
		}
		return responseMap;
	}

	public <T> Map<String, T> batchHget(List<String[]> queryKeys, String resultKey, Class<T> cls) {
		Map<String, T> resultMap = new ConcurrentHashMap<String, T>();
		RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
		List<Object> resultList = redisTemplate.execute(new RedisCallback<List<Object>>() {
			@Override
			public List<Object> doInRedis(RedisConnection connection) throws DataAccessException {
				connection.openPipeline();
				for (String[] keys : queryKeys) {
					byte[] key = redisSerializer.serialize(keys[0]);
					byte[] field = redisSerializer.serialize(keys[1]);
					connection.hGet(key, field);
				}
				return connection.closePipeline();
			}
		});
		if (!Collections.isEmpty(resultList)) {
			resultList.stream().filter(cacheObj -> cacheObj != null).forEach(cacheObj -> {
				String cacheStr = redisSerializer.deserialize((byte[]) cacheObj);
				cacheStr = cacheStr.replaceAll("\\\\", "");
				cacheStr = cacheStr.substring(1, cacheStr.length() - 1);
				JSONObject jsonObject = JSONObject.parseObject(cacheStr);
				resultMap.put(jsonObject.get(resultKey).toString(), JSONObject.toJavaObject(jsonObject, cls));
			});
		}
		return resultMap;
	}

	public String hget(String key, String field) {
		Object obj = redisTemplate.opsForHash().get(key, field);
		return obj == null ? null : obj.toString();
	}

	public Object hkeys(String key) {
		return redisTemplate.opsForHash().keys(key);
	}

	public Map hentries(String key) {
		return redisTemplate.opsForHash().entries(key);
	}

	public void hremove(String key, Object... fields) {
		redisTemplate.opsForHash().delete(key, fields);
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 判断缓存中是否有对应的value
	 *
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}
}
