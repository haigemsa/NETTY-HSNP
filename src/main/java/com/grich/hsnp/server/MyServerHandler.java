package com.grich.hsnp.server;

import com.grich.hsnp.core.ResultGenerator;
import com.grich.hsnp.hsnp.HsnpRequest;
import com.grich.hsnp.hsnp.HsnpRequestDispatch;
import com.grich.hsnp.hsnp.HsnpResponse;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lucas
 */
@Slf4j
@Component
@io.netty.channel.ChannelHandler.Sharable
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(MyServerHandler.class);



    /**
     * 当客户端主动链接服务端的链接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        SocketChannel channel = (SocketChannel) ctx.channel();
        logger.info("有一客户端链接到本服务端 === 链接报告IP:{} Port:{}", channel.localAddress().getHostString(),channel.localAddress().getPort());
        ctx.writeAndFlush(ResultGenerator.genSuccessResult("链接建立成功！").toStringForSocket());
    }

    /**
     * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx){
        logger.info("客户端断开链接{}", ctx.channel().localAddress().toString());
        clearChannelCache(ctx);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String data =  msg.toString();

        //hnsp请求对象
        HsnpRequest hsnpRequest = new HsnpRequest(ctx,data);
        //hnsp响应对象
        HsnpResponse hsnpResponse = new HsnpResponse(ctx);
        //uri处理器
        HsnpRequestDispatch hsnpRequestDispatch = new HsnpRequestDispatch(hsnpRequest, hsnpResponse);
        hsnpRequestDispatch.doDispatch();
    }



    /**
     * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.writeAndFlush(ResultGenerator.genFailResult(cause.getMessage()).toStringForSocket());
        logger.info("异常信息：\r\n" + cause, cause);
    }

    /**
     * 清除map中对应关闭的信道
     *
     * @param ctx 信道
     */
    public static void clearChannelCache(ChannelHandlerContext ctx) {
        if (ctx == null){
            return;
        }
        Channel channel = ctx.channel();
        //信道ID
        String channelId = channel.id().asShortText();
        if (!channel.isActive() && !channel.isOpen() && !channel.isWritable()) {
            channel.close();
        }
    }




}
