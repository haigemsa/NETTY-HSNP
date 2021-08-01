package com.grich.hsnp.entity;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * @author lucas
 */
@Data
public class SocketDataDto {

    /**
     *  设备ID
     */
    private String id;

    /**
     *  用户ID
     */
    private String userId;

    /**
     *  业务数据json
     */
    private String data;

    /**
     *  用户数据json
     */
    private JSONObject userData;



}
