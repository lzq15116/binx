//package com.liyuan.binx.mq;
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.ExchangeTypes;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class DeadQueueConsumer {
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(
//                    value = "deadLetterQueue",
//                    durable = "true"
//            ),
//            exchange = @Exchange(
//                    value = "deadLetterExchange",
//                    durable = "true",
//                    type = ExchangeTypes.TOPIC
//            ),
//            key = "deadLetter"
//    ))
//    public void deadQueueConsumer(String msg, Channel channel, Message message) throws IOException {
//        System.out.println("死信队列：" + msg);
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//    }
//}
