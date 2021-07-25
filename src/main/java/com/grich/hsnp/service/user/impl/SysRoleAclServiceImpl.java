package com.grich.hsnp.service.user.impl;


import com.grich.hsnp.core.AbstractService;
import com.grich.hsnp.dao.user.SysRoleAclMapper;
import com.grich.hsnp.model.user.SysRoleAcl;
import com.grich.hsnp.service.user.SysRoleAclService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * SysRoleAcl Service实现类，Created on 2020-05-11.
 * @author William
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleAclServiceImpl extends AbstractService<SysRoleAcl> implements SysRoleAclService {
    @Resource
    private SysRoleAclMapper sysRoleAclMapper;

}
