package com.grich.hsnp.service.log.impl;


import com.grich.hsnp.core.AbstractService;
import com.grich.hsnp.dao.log.SysLogMapper;
import com.grich.hsnp.model.log.SysLog;
import com.grich.hsnp.service.log.SysLogService;
import com.grich.hsnp.utils.IpUtil;
import com.grich.hsnp.utils.MyUUID;
import com.grich.hsnp.utils.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * SysLog Service实现类，Created on 2020-05-11.
 * @author William
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SysLogServiceImpl extends AbstractService<SysLog> implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void saveSysLog(Integer logType, String action, String target) {
        try {
            String operatorIp = IpUtil.getRemoteIp(RequestHolder.getCurrentRequest());
            SysLog sysLog = new SysLog();
            sysLog.setId(MyUUID.randomUUID());
            sysLog.setLogType(logType);
            sysLog.setOperatorId(target);
            sysLog.setOperateIp(operatorIp);
            sysLog.setAction(action);
            sysLog.setTarget(target);
            this.save(sysLog);
        } catch (Exception e) {
            log.error("写日志失败！");
            e.printStackTrace();
        }
    }

}
