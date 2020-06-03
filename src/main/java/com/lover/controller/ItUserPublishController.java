package com.lover.controller;

import com.laiai.core.Result;
import com.laiai.core.BaseController;
import com.lover.model.ItUserPublish;
import com.lover.service.ItUserPublishService;
import com.lover.swagger.ItUserPublishSwagger;
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
@RequestMapping("/it/user/publish")
public class ItUserPublishController extends BaseController implements ItUserPublishSwagger {
    @Resource
    private ItUserPublishService itUserPublishService;

    @PostMapping
    @Override
    public Result add(@RequestBody @Valid ItUserPublish itUserPublish,BindingResult result) throws IOException  {
    	ValidatorHelper.validate(result);
        itUserPublishService.save(itUserPublish);
        return success();
    }

    @DeleteMapping("/{id}")
    @Override
    public Result delete(@PathVariable Long id) {
        itUserPublishService.deleteById(id);
        return success();
    }

    @PutMapping
    @Override
    public Result update(@RequestBody ItUserPublish itUserPublish) {
        ValidatorHelper.notEmpty("id",itUserPublish.getId());
        itUserPublishService.update(itUserPublish);
        return success();
    }

    @GetMapping("/{id}")
    @Override
    public Result<ItUserPublish> view(@PathVariable Long id) {
        ItUserPublish itUserPublish = itUserPublishService.findById(id);
        return success(itUserPublish);
    }


    @PostMapping("/page")
    @Override
    public Result<PageInfo<List<ItUserPublish>>> pageList(@RequestBody ItUserPublish model, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(current, pageSize);
        List<ItUserPublish> list = itUserPublishService.findList(model);
        PageInfo pageInfo = new PageInfo(list);
        return success(pageInfo);
    }
}
