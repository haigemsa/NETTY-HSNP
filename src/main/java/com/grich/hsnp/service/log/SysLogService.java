package com.grich.hsnp.service.log;


import com.grich.hsnp.core.Service;
import com.grich.hsnp.model.log.SysLog;
import org.springframework.scheduling.annotation.Async;

/**
 * SysLog Service接口，Created on 2020-05-11.
 * @author William 
 */
public interface SysLogService extends Service<SysLog> {

    @Async
    void saveSysLog(Integer logType, String action, String target);
}
