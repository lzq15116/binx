package com.liyuan.binx.mq;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.liyuan.binx.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class DeadMessageConsumer {

//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "orderQueue", durable = "true",
//                    arguments = {
//                            @Argument(
//                                    name = "x-dead-letter-exchange",
//                                    value = "deadLetterExchange"
//                            ), @Argument(
//                            name = "x-dead-letter-routing-key",
//                            value = "deadLetterRoutingKey"
//                    )
//                            , @Argument(
//                            name = "x-message-ttl",
//                            value = "5000",
//                            type = "java.lang.Integer"
//                    )
//
//                    }),
//            exchange = @Exchange(value = "orderExchange", type = "topic"),
//            key = "orderRoutingKey"
//    ))
//    public void deadMessage(String msg, Channel channel, Message message) throws IOException {
////        Order order = JSONObject.parseObject(msg, Order.class);
//        System.out.println(StrUtil.format("订单：{},间隔时间：{}", msg));
//
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//
//    }
//
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "deadLetterQueue", durable = "true"),
//            exchange = @Exchange(value = "deadLetterExchange", type = "topic"),
//            key = "deadLetterRoutingKey"
//    ))
//    public void handleDeadLetter(String order) {
//        // 处理超时订单消息
//        System.out.println("Order timed out: " + order);
//        // 模拟订单超时处理逻辑，例如取消订单或通知用户
//    }

//    @RabbitListener(queues = "deadLetterQueue")
//    public void handleDeadLetter(String order) {
//        // 处理超时订单消息
//        System.out.println("Order timed out: " + order);
//        // 模拟订单超时处理逻辑，例如取消订单或通知用户
//    }

    @RabbitListener(queues = "orderDeadLetterQueue")
    public void deadMessage(String mes,Channel channel, Message message) throws IOException {
        System.out.println("死信： " + mes);
    }
}
