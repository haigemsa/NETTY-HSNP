package com.grich.hsnp.server;

import com.grich.hsnp.entity.AdviceStatusEntity;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ConcurrentHashMap;


/**
 * @author lucas
 */
public class ChannelHandler {

    /**
     * 用于存放用户Channel信息，也可以建立map结构模拟不同的消息群
     */

    //public final static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public final static ConcurrentHashMap<String, ChannelHandlerContext> CHANNEL_MAP = new ConcurrentHashMap<String, ChannelHandlerContext>();

    /**
     * socket对应的设备的ID的MAP
     */
    public final static ConcurrentHashMap<String, AdviceStatusEntity> SOCKET_ID_ID = new ConcurrentHashMap<String, AdviceStatusEntity>();

}
