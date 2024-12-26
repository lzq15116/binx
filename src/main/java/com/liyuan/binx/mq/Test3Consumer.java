//package com.liyuan.binx.mq;
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.*;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Test3Consumer {
//
//    private static final Boolean hasError = true;
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(
//                    value = "test3_queue",
//                    durable = "true"
//            ),
//            exchange = @Exchange(
//                    value = "test3_exchange",
//                    durable = "true"
//            ),
//            key = "test3_key",
//            arguments = {
//                    @Argument(name = "x-dead-letter-exchange",value = "deadLetterExchange"),
//                    @Argument(name = "x-dead-letter-routing-key",value = "deadLetterRoutingKey"),
//
//            }
//    ))
//    public void consume(String msg, Message amqpMessage, Channel channel) {
//        System.out.println("test3 received: " + msg);
//    }
//}
