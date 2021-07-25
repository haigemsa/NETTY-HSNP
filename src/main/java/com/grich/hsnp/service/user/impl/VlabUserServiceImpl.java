package com.grich.hsnp.service.user.impl;


import com.grich.hsnp.core.AbstractService;
import com.grich.hsnp.dao.user.VlabUserMapper;
import com.grich.hsnp.model.user.VlabUser;
import com.grich.hsnp.service.user.VlabUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * VlabUser Service实现类，Created on 2020-05-11.
 * @author William
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VlabUserServiceImpl extends AbstractService<VlabUser> implements VlabUserService {
    @Resource
    private VlabUserMapper vlabUserMapper;

}
