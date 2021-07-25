package com.grich.hsnp.service.log.impl;


import com.grich.hsnp.core.AbstractService;
import com.grich.hsnp.dao.log.SysAclLogMapper;
import com.grich.hsnp.model.log.SysAclLog;
import com.grich.hsnp.service.log.SysAclLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * SysAclLog Service实现类，Created on 2020-05-11.
 * @author William
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysAclLogServiceImpl extends AbstractService<SysAclLog> implements SysAclLogService {
    @Resource
    private SysAclLogMapper sysAclLogMapper;

}
