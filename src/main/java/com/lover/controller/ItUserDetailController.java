package com.lover.controller;

import com.laiai.core.Result;
import com.laiai.core.BaseController;
import com.lover.model.ItUserDetail;
import com.lover.service.ItUserDetailService;
import com.lover.swagger.ItUserDetailSwagger;
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
@RequestMapping("/it/user/detail")
public class ItUserDetailController extends BaseController implements ItUserDetailSwagger {
    @Resource
    private ItUserDetailService itUserDetailService;

    @PostMapping
    @Override
    public Result add(@RequestBody @Valid ItUserDetail itUserDetail,BindingResult result) throws IOException  {
    	ValidatorHelper.validate(result);
        itUserDetailService.save(itUserDetail);
        return success();
    }

    @DeleteMapping("/{id}")
    @Override
    public Result delete(@PathVariable Long id) {
        itUserDetailService.deleteById(id);
        return success();
    }

    @PutMapping
    @Override
    public Result update(@RequestBody ItUserDetail itUserDetail) {
        ValidatorHelper.notEmpty("id",itUserDetail.getId());
        itUserDetailService.update(itUserDetail);
        return success();
    }

    @GetMapping("/{id}")
    @Override
    public Result<ItUserDetail> view(@PathVariable Long id) {
        ItUserDetail itUserDetail = itUserDetailService.findById(id);
        return success(itUserDetail);
    }


    @PostMapping("/page")
    @Override
    public Result<PageInfo<List<ItUserDetail>>> pageList(@RequestBody ItUserDetail model, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(current, pageSize);
        List<ItUserDetail> list = itUserDetailService.findList(model);
        PageInfo pageInfo = new PageInfo(list);
        return success(pageInfo);
    }
}
