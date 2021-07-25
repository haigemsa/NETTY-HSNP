package com.grich.hsnp.server;

import com.grich.hsnp.core.ResultGenerator;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.Charset;

/**
 * @author lucas
 */
@Component
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    //最大socket连接数量
    private static final int MAX_CONNECT_NUMBER = 50;
    //最大设备注册数量
    private static final int MAX_ADVICE_NUMBER = 10;

    @Resource
    MyServerHandler myServerHandler;

    @Override
    protected void initChannel(SocketChannel channel) {
        //判断socket是否超过最大连接数，超过则不处理
        if (limitSocketNumber()){
            channel.writeAndFlush(ResultGenerator.genFailResult("已超过服务器最多连接Socket数量：" + MAX_CONNECT_NUMBER).toStringForSocket());
            channel.close();
            return;
        }if (limitAdviceNumber()){
            channel.writeAndFlush(ResultGenerator.genFailResult("已超过服务器最多注册设备数量：" + MAX_ADVICE_NUMBER).toStringForSocket());
            channel.close();
            return;
        }
        // 基于换行符号
        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        // 解码转String，注意调整自己的编码格式GBK、UTF-8
        channel.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
        // 在管道中添加我们自己的接收数据实现方法
        channel.pipeline().addLast(myServerHandler);
    }
    /**  判断是否大于最大连接数，大于返回true
     *
     * @return boolean
     */
    private boolean limitSocketNumber(){
        return ChannelHandler.CHANNEL_MAP.size() > MAX_CONNECT_NUMBER;
    }

    /**  判断是否大于最大连接数，大于返回true
     *
     * @return boolean
     */
    private boolean limitAdviceNumber(){
        return ChannelHandler.SOCKET_ID_ID.size() > MAX_ADVICE_NUMBER;
    }
}
