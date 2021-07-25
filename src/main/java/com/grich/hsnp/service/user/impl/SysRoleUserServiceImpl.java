package com.grich.hsnp.service.user.impl;


import com.grich.hsnp.core.AbstractService;
import com.grich.hsnp.dao.user.SysRoleUserMapper;
import com.grich.hsnp.model.user.SysRoleUser;
import com.grich.hsnp.service.user.SysRoleUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * SysRoleUser Service实现类，Created on 2020-05-11.
 * @author William
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleUserServiceImpl extends AbstractService<SysRoleUser> implements SysRoleUserService {
    @Resource
    private SysRoleUserMapper sysRoleUserMapper;

}
