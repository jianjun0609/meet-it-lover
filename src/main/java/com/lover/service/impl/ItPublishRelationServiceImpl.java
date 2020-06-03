package com.lover.service.impl;

import com.lover.mapper.ItPublishRelationMapper;
import com.lover.model.ItPublishRelation;
import com.lover.service.ItPublishRelationService;
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
public class ItPublishRelationServiceImpl extends AbstractService<ItPublishRelation> implements ItPublishRelationService {
    @Resource
    private ItPublishRelationMapper itPublishRelationMapper;

}
