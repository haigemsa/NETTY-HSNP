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
     * 目前使用用户ID
     */
    private volatile String userId;
    /**
     * 设备使用时间
     */
    private volatile Integer useTime;
    /**
     * 设备使用开始时间
     */
    private volatile Date startTime;
    /**
     * 设备使用金额
     */
    private volatile BigDecimal money;

    /**
     * 设备类型：DS：洗浴区   DM：烘干区(小中)  DD：烘干区(大)  DA：造型区
     */
    private volatile String type;

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


    public void clear(){
        this.userId = null;
        this.useTime = null;
        this.code = null;
        this.money = null;
        this.startTime = null;
        this.isRunning = false;
    }

    public void init(){
        this.userId = null;
        this.useTime = 0;
        this.code = null;
        this.money = BigDecimal.ZERO;
        this.startTime = null;
        this.isRunning = false;
    }

}
