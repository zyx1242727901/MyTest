package com.example.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestDiscard {

    public void run(int port){
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel sc) throws Exception {
                            sc.pipeline().addLast(new OutBondsServiceHandler());
                            sc.pipeline().addLast(new DiscardServiceHandler()).addLast(new DiscardMessageHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 1024).option(ChannelOption.SO_KEEPALIVE,true);

            ChannelFuture sync = bootstrap.connect("localhost",port).sync();
            Channel channel = sync.channel();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String s = input.readLine();
                System.out.println("发送"+s);
                channel.writeAndFlush(s + "\n");
            }
//            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new TestDiscard().run(8080);

    }
}
