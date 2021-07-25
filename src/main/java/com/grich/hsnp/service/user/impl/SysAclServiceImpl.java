package com.grich.hsnp.service.user.impl;


import com.grich.hsnp.core.AbstractService;
import com.grich.hsnp.dao.user.SysAclMapper;
import com.grich.hsnp.model.user.SysAcl;
import com.grich.hsnp.service.user.SysAclService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * SysAcl Service实现类，Created on 2020-05-11.
 * @author William
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysAclServiceImpl extends AbstractService<SysAcl> implements SysAclService {
    @Resource
    private SysAclMapper sysAclMapper;

}
