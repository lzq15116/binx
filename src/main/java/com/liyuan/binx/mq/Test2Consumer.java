//package com.liyuan.binx.mq;
//
//import com.rabbitmq.client.Channel;
//import lombok.AllArgsConstructor;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.*;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Component
//public class Test2Consumer {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    private AtomicInteger atomicInteger = new AtomicInteger(0);
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(
//                    value = "test2_queue",
//                    durable = "true"
//            ),
//            exchange = @Exchange(
//                    value = "test2_exchange",
//                    durable = "true",
//                    type = "topic"
//            ),
//            key = "test2_key",
//            arguments = {
//                    @Argument(name = "x-dead-letter-exchange", value = "deadLetterExchange"),
//                    @Argument(name = "x-dead-letter-routing-key", value = "deadLetterRoutingKey"),
//            }
//    ))
////    @Transactional(rollbackFor = Exception.class)
//    public void consume(String mes, Channel channel, Message message) throws IOException {
//        try {
//            System.out.println("test2 receive: " + mes);
//            throw new RuntimeException("test2 抛出异常！！！！！！");
//        } catch (Exception e) {
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
//        }
//
//
////        rabbitTemplate.convertAndSend("test3_exchange", "test3_key", mes);
//
////        System.out.println(1 / 0);
//
//    }
//}
