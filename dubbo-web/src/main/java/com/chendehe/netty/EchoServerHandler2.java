package com.chendehe.netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author CDH
 * @since 2019.8.20 020 0:42
 */
public class EchoServerHandler2 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            System.out.println(((ByteBuf)msg).toString(Charset.defaultCharset()));
        }

        // 发送给客户端
        ctx.channel().writeAndFlush("2server is ok\n");
    }

}
