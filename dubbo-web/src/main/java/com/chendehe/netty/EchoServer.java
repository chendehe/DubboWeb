package com.chendehe.netty;

import io.netty.channel.ChannelOption;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author CDH
 * @since 2019.8.20 020 0:23
 */
public class EchoServer {

    public static void main(String[] args) throws InterruptedException {
        // 1. 创建 ServerBootstrap 实例
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 2. 创建并绑定 Reactor 线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        bootstrap.group(bossGroup, workerGroup)
            // 3. 设置并绑定服务端 Channel，反射创建此对象
            .channel(NioServerSocketChannel.class)
            // 4. TCP 链路建立时创建 ChannelPipeline
            // 5. 添加并设置 ChannelHandler
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new EchoServerHandler());
                    // 编码
                    ch.pipeline().addLast(new StringEncoder());
                    ch.pipeline().addLast(new LengthFieldPrepender(4, false));
                }
            })
            // 6. 绑定监听端口并启动服务器
            .localAddress(new InetSocketAddress(8888))
            // 此 handler 在 ServerBootstrap 初始化的时候执行
            .handler(new LoggingHandler(LogLevel.INFO))
            .option(ChannelOption.SO_BACKLOG, 100);
        // 类似第 3 步
//        bootstrap.channelFactory(new ReflectiveChannelFactory<>(NioServerSocketChannel.class));
//        bootstrap.channelFactory(new ChannelFactory<ServerChannel>() {
//            @Override
//            public ServerChannel newChannel() {
//                return new NioServerSocketChannel();
//            }
//        });
        // .option()
        // .childOption()
        // .attr()
        // .childAttr()
        // .config() 获取配置信息

        ChannelFuture future = bootstrap.bind();
        ChannelFuture sync = future.sync();
        // 7. Selector 轮询
        // 8. 网络事件通知
        // 9. 执行 Netty 系统和业务 HandlerChannel

        sync.channel().closeFuture().sync();

    }
}