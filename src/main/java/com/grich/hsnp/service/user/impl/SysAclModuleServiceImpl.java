package com.grich.hsnp.service.user.impl;


import com.grich.hsnp.core.AbstractService;
import com.grich.hsnp.dao.user.SysAclModuleMapper;
import com.grich.hsnp.model.user.SysAclModule;
import com.grich.hsnp.service.user.SysAclModuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * SysAclModule Service实现类，Created on 2020-05-11.
 * @author William
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysAclModuleServiceImpl extends AbstractService<SysAclModule> implements SysAclModuleService {
    @Resource
    private SysAclModuleMapper sysAclModuleMapper;

}
