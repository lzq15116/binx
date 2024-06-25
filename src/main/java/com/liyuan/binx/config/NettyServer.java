//package com.liyuan.binx.config;
//
//import com.liyuan.binx.service.ws.EchoServerHandler;
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.*;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class NettyServer implements InitializingBean {
//
//
//
//    public void run() throws InterruptedException {
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        public void initChannel(SocketChannel ch) throws Exception {
//                            ChannelPipeline pipeline = ch.pipeline();
//                            pipeline.addLast(new EchoServerHandler());
//                        }
//                    })
//                    .option(ChannelOption.SO_BACKLOG, 128)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//
//            // 绑定端口，开始接收进来的连接
//            ChannelFuture f = b.bind(8888).sync();
//
//            // 等待服务器 socket 关闭 。
//            f.channel().closeFuture().sync();
//        } finally {
//            workerGroup.shutdownGracefully();
//            bossGroup.shutdownGracefully();
//        }
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        run();
//    }
//}
