package com.chendehe.netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author CDH
 * @since 2019.8.20 020 0:58
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            System.out.print("服务端发来消息：");
            System.out.println(((ByteBuf)msg).toString(Charset.defaultCharset()));
        }
        // 通知下一个 ChannelHandler
        ctx.fireChannelRead(msg);
    }

}
