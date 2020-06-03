package com.lover.service.impl;

import com.lover.mapper.ItUserPublishMapper;
import com.lover.model.ItUserPublish;
import com.lover.service.ItUserPublishService;
import com.laiai.core.abstractbean.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @description:
 * @author Jack
 * @date 2020-06-03 15:56:23
 */
@Service
@Transactional
public class ItUserPublishServiceImpl extends AbstractService<ItUserPublish> implements ItUserPublishService {
    @Resource
    private ItUserPublishMapper itUserPublishMapper;

}
