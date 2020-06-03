package com.lover.service.impl;

import com.lover.mapper.ItUserDetailMapper;
import com.lover.model.ItUserDetail;
import com.lover.service.ItUserDetailService;
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
public class ItUserDetailServiceImpl extends AbstractService<ItUserDetail> implements ItUserDetailService {
    @Resource
    private ItUserDetailMapper itUserDetailMapper;

}
