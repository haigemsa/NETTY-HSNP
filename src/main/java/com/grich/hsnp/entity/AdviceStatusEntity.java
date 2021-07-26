package com.grich.hsnp.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;

/**
 * 设备信息
 *
 * @author lucas
 */
@Data
public class AdviceStatusEntity {

    public AdviceStatusEntity() {
    }

    public AdviceStatusEntity(String channelId) {
        this.channelId = channelId;
    }

    /**
     *  信道ID
     */
    private volatile String channelId;




    /**
     * 目前在店人数
     */
    private volatile HashSet<String> userIds;


    /**
     * 返回结果
     */
    private volatile Integer code;

    /**
     * 是否在运行
     */
    private volatile boolean isRunning;

}
