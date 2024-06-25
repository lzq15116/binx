package com.liyuan.binx.service.ws;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(111111);
        System.out.println(msg.toString());
        ByteBuf in = (ByteBuf) msg;

        System.out.println("连接成功！！！！！！！！");
        try {
            while (in.isReadable()) {
                System.out.print((char) in.readByte());
                System.out.flush();
            }
//            ctx.write(msg); // 将接收到的消息写回给发送者，而不冲刷出站消息
            ctx.write("感恩的心"); // 将接收到的消息写回给发送者，而不冲刷出站消息
            ctx.flush();
        } finally {
            // ByteBuf是一个引用计数对象，这个对象必须显示地调用release()方法来释放。
            in.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 出现异常时关闭连接。
        cause.printStackTrace();
        ctx.close();
    }

}
