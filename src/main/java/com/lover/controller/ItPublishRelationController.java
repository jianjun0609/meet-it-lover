package com.lover.controller;

import com.laiai.core.Result;
import com.laiai.core.BaseController;
import com.lover.model.ItPublishRelation;
import com.lover.service.ItPublishRelationService;
import com.lover.swagger.ItPublishRelationSwagger;
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
@RequestMapping("/it/publish/relation")
public class ItPublishRelationController extends BaseController implements ItPublishRelationSwagger {
    @Resource
    private ItPublishRelationService itPublishRelationService;

    @PostMapping
    @Override
    public Result add(@RequestBody @Valid ItPublishRelation itPublishRelation,BindingResult result) throws IOException  {
    	ValidatorHelper.validate(result);
        itPublishRelationService.save(itPublishRelation);
        return success();
    }

    @DeleteMapping("/{id}")
    @Override
    public Result delete(@PathVariable Long id) {
        itPublishRelationService.deleteById(id);
        return success();
    }

    @PutMapping
    @Override
    public Result update(@RequestBody ItPublishRelation itPublishRelation) {
        ValidatorHelper.notEmpty("id",itPublishRelation.getId());
        itPublishRelationService.update(itPublishRelation);
        return success();
    }

    @GetMapping("/{id}")
    @Override
    public Result<ItPublishRelation> view(@PathVariable Long id) {
        ItPublishRelation itPublishRelation = itPublishRelationService.findById(id);
        return success(itPublishRelation);
    }


    @PostMapping("/page")
    @Override
    public Result<PageInfo<List<ItPublishRelation>>> pageList(@RequestBody ItPublishRelation model, @RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(current, pageSize);
        List<ItPublishRelation> list = itPublishRelationService.findList(model);
        PageInfo pageInfo = new PageInfo(list);
        return success(pageInfo);
    }
}
