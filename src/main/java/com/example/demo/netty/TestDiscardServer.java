package com.example.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

public class TestDiscardServer {

    public void listen(int port){
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            sc.pipeline().addLast(
                                    new HttpResponseDecoder())
                                    .addLast(new HttpRequestDecoder())
                                    .addLast(new OutBondsServiceHandler())
//                                    .addLast(new DiscardServiceHandler())
//                                    .addLast(new DiscardMessageHandler())
                                    .addLast(new CustomTextFrameHandler())
                                    .addLast(new HttpRequestHandler("/ws"))
                                    .addLast("ws", new WebSocketServerProtocolHandler("/ws")) //webSocket数据支持
                                    .addLast(new HttpObjectAggregator(65536));//限制数据大小
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 65536)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true);

            ChannelFuture sync = bootstrap.bind(port).sync();

            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new TestDiscardServer().listen(8080);

    }
}
