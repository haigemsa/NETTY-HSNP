package com.grich.hsnp.service.user.impl;


import com.grich.hsnp.core.AbstractService;
import com.grich.hsnp.dao.user.SysRoleMapper;
import com.grich.hsnp.model.user.SysRole;
import com.grich.hsnp.service.user.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * SysRole Service实现类，Created on 2020-05-11.
 * @author William
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}
