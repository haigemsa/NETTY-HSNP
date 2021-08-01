package com.grich.hsnp.server;

import com.grich.hsnp.entity.AdviceStatusEntity;
import com.grich.hsnp.hsnp.HsnpResponse;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ConcurrentHashMap;


/**
 * @author lucas
 */
public class ChannelHandler {

    /**
     * 客户端ID对应的HsnpResponse
     */
    public final static ConcurrentHashMap<String, HsnpResponse> ID_RESPONSE = new ConcurrentHashMap<>();


}
