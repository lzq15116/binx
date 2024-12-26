//package com.liyuan.binx.mq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.ExchangeTypes;
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class EchoConsumer {
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(
//                    value = "echo_queue",
//                    durable = "true"
//            )
//            ,
//            exchange = @Exchange(
//                    value = "echo_exchange",
//                    durable = "true",
//                    type = ExchangeTypes.TOPIC
//            ),
//            key = "echo_key"
//    ))
//    public void echo(String msg) {
//        System.out.println(msg);
//
//    }
//}
