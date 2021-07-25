package com.grich.hsnp.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

/**
 * @author lucas
 */
@Component("nettyServer")
public class NettyServer {

    private Logger logger = LoggerFactory.getLogger(NettyServer.class);

    @Resource
    MyChannelInitializer myChannelInitializer;

    //配置服务端NIO线程组
    private final EventLoopGroup parentGroup = new NioEventLoopGroup();// // 这个是Acceptor的线程组
    private final EventLoopGroup childGroup = new NioEventLoopGroup();// 这个是用来处理已接收连接的线程组
    private Channel channel;

    public ChannelFuture bing(InetSocketAddress address) {
        ChannelFuture channelFuture = null;
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(parentGroup, childGroup)
                    .channel(NioServerSocketChannel.class)    //非阻塞模式(指定channel的类型)
                    .option(ChannelOption.SO_BACKLOG, 5)//设置最大请求数，超过请求数则会拒绝连接
                    .childHandler(myChannelInitializer)//指定每个worker channel需要进行哪些处理
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // 连接保活

            channelFuture = b.bind(address).syncUninterruptibly(); //绑定服务器端口，启动从这开始
            channel = channelFuture.channel();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if (null != channelFuture && channelFuture.isSuccess()) {
                logger.info("netty-socket server start done. {预祝不宕机！！！}");
            } else {
                logger.error("netty--socket server start error. {预祝不宕机！！！}");
            }
        }
        return channelFuture;
    }

    public void destroy() {
        if (null == channel){
            return;
        }
        channel.close();
        parentGroup.shutdownGracefully();
        childGroup.shutdownGracefully();
    }

    public Channel getChannel() {
        return channel;
    }

}
