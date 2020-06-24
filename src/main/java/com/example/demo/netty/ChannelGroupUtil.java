package com.example.demo.netty;

import io.netty.channel.Channel;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChannelGroupUtil {
    private static DefaultChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void add(Channel channel){
        if (channel != null) {
            synchronized (channelGroup) {
                channelGroup.add(channel);
            }
        }
    }

    public static DefaultChannelGroup getChannelGroup(){
        return channelGroup;
    }
}
