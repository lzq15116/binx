//package com.liyuan.binx.mq;
//
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TestConsumer {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(
//                    value = "test_queue",
//                    durable = "true"
//            ),
//            exchange = @Exchange(
//                    value = "test_exchange",
//                    durable = "true"
//            ),
//            key = "test_key"
//    ))
////    @SendTo("test2_queue")
//    public void consume(String msg) {
//        System.out.println("test received: " + msg);
////        return "test1 send to test2 , test1's message: " + msg;
//        rabbitTemplate.convertAndSend("test2_exchange", "test2_key", msg);
//    }
//}
