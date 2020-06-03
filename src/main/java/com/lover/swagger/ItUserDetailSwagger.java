package com.lover.swagger;

import com.laiai.core.Result;
import com.lover.model.ItUserDetail;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import java.io.IOException;

/**
 * @description:
 * @author Jack
 * @date 2020-06-03 15:56:23
 */
@Api(tags = "用户详情表管理")
public interface ItUserDetailSwagger {

     @ApiOperation(value="新增", notes="新增ItUserDetail")
     public Result add(ItUserDetail itUserDetail, BindingResult result) throws IOException;


     @ApiOperation(value="删除", notes="以主键id删除ItUserDetail")
     public Result delete(@PathVariable Long id);


     @ApiOperation(value="更新", notes="更新itUserDetail")
     public Result update(@RequestBody ItUserDetail itUserDetail);


     @ApiOperation(value="详情", notes="获取详情")
     public Result view(@PathVariable Long id);


     @ApiOperation(value="按条件及分页查找", notes="按条件及分页查找")
     public Result pageList(@RequestBody ItUserDetail obj, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer pageSize);
}
