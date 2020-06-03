package com.lover.controller;

import com.laiai.core.Result;
import com.laiai.core.BaseController;
import com.lover.model.ItUserInfo;
import com.lover.service.ItUserInfoService;
import com.lover.swagger.ItUserInfoSwagger;
import org.springframework.validation.BindingResult;
import com.laiai.core.validator.ValidatorHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.io.IOException;
import javax.validation.Valid;



/**
 * @description:
 * @author Jack
 * @date 2020-06-03 15:56:23
 */
@RestController
@RequestMapping("/it/user/info")
public class ItUserInfoController extends BaseController implements ItUserInfoSwagger {
    @Resource
    private ItUserInfoService itUserInfoService;

    @PostMapping
    @Override
    public Result add(@RequestBody @Valid ItUserInfo itUserInfo,BindingResult result) throws IOException  {
    	ValidatorHelper.validate(result);
        itUserInfoService.save(itUserInfo);
        return success();
    }

    @DeleteMapping("/{id}")
    @Override
    public Result delete(@PathVariable Long id) {
        itUserInfoService.deleteById(id);
        return success();
    }

    @PutMapping
    @Override
    public Result update(@RequestBody ItUserInfo itUserInfo) {
        ValidatorHelper.notEmpty("id",itUserInfo.getId());
        itUserInfoService.update(itUserInfo);
        return success();
    }

    @GetMapping("/{id}")
    @Override
    public Result<ItUserInfo> view(@PathVariable Long id) {
        ItUserInfo itUserInfo = itUserInfoService.findById(id);
        return success(itUserInfo);
    }


    @PostMapping("/page")
    @Override
    public Result<PageInfo<List<ItUserInfo>>> pageList(@RequestBody ItUserInfo model, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(current, pageSize);
        List<ItUserInfo> list = itUserInfoService.findList(model);
        PageInfo pageInfo = new PageInfo(list);
        return success(pageInfo);
    }
}
