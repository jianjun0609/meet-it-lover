package com.lover.swagger;

import com.laiai.core.Result;
import com.lover.model.ItUserPublish;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import java.io.IOException;

/**
 * @description:
 * @author Jack
 * @date 2020-06-03 15:56:23
 */
@Api(tags = "用户招友信息表管理")
public interface ItUserPublishSwagger {

     @ApiOperation(value="新增", notes="新增ItUserPublish")
     public Result add(ItUserPublish itUserPublish, BindingResult result) throws IOException;


     @ApiOperation(value="删除", notes="以主键id删除ItUserPublish")
     public Result delete(@PathVariable Long id);


     @ApiOperation(value="更新", notes="更新itUserPublish")
     public Result update(@RequestBody ItUserPublish itUserPublish);


     @ApiOperation(value="详情", notes="获取详情")
     public Result view(@PathVariable Long id);


     @ApiOperation(value="按条件及分页查找", notes="按条件及分页查找")
     public Result pageList(@RequestBody ItUserPublish obj, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer pageSize);
}
