package com.example.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;

public class OutBondsServiceHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ByteBuf in = (ByteBuf) msg;

//        String str = in.toString(CharsetUtil.UTF_8);
        System.out.println(msg);
//        ctx.write(msg, promise);
        DefaultChannelGroup channelGroup = ChannelGroupUtil.getChannelGroup();
        int size = channelGroup.size();
        channelGroup.forEach(ch -> {
            ch.writeAndFlush("用户" + ctx.channel().remoteAddress() + "发送了消息" );
        });
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
