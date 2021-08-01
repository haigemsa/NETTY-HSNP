package com.grich.hsnp;

import com.grich.hsnp.annotation.SocketRequestScan;
import com.grich.hsnp.hsnp.ClassHandle;
import com.grich.hsnp.server.NettyServer;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Springboot运行主类
 * @author william
 */
@Slf4j
@SpringBootApplication
@SocketRequestScan("com.grich.hsnp")
public class HsnpApplication implements CommandLineRunner{
    @Value("${netty.host}")
    private String host;
    @Value("${netty.port}")
    private int port;
    @Autowired
    private NettyServer nettyServer;


    public static void main(String[] args) {
        SpringApplication.run(HsnpApplication.class, args);

    }
    @Override
    public void run(String... args) {
        try {
            //扫描项目的class文件
            ClassHandle.componentScanInit(HsnpApplication.class);
            //加载初始化处理器的类和方法
            ClassHandle.initSocketRequestMappingMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        InetSocketAddress address = new InetSocketAddress(host, port);
        ChannelFuture channelFuture = nettyServer.bing(address);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> nettyServer.destroy()));
        channelFuture.channel().closeFuture().syncUninterruptibly();

    }
}

