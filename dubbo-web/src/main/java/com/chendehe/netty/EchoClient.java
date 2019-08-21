package com.chendehe.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author CDH
 * @since 2019.8.20 020 0:51
 */
public class EchoClient {

    public static void main(String[] args) throws InterruptedException {
        // 1. 创建 Bootstrap 实例
        Bootstrap bootstrap = new Bootstrap();
        // 2. 创建处理客户端连接、IO 读写的 Reactor 线程组 NioEventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
            // 3. 设置并绑定客户端 Channel，反射创建此对象
            .channel(NioSocketChannel.class)
            // 4. 创建 ChannelPipeline，添加并设置 ChannelHandler
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new EchoClientHandler());
                    // 编码
                    ch.pipeline().addLast(new StringEncoder());
                    ch.pipeline().addLast(new LengthFieldPrepender(4, false));
                }
            })
            // 5. 异步发起 TCP 连接
            .remoteAddress(new InetSocketAddress(8888))
            .option(ChannelOption.TCP_NODELAY, true);

        ChannelFuture future = bootstrap.connect();
        ChannelFuture sync = future.sync();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!"no".equals(line)) {
            sync.channel().writeAndFlush(line);
            sc = new Scanner(System.in);
            line = sc.nextLine();
        }

        sync.channel().closeFuture().sync();
        System.out.println("client end");
    }
}
