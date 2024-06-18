package com.liyuan.binx.service.consumer;

import com.liyuan.binx.entity.Order;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FcmConsumer {

//    @RabbitListener(queues = "fcm")
//    public void fcm(String message) {
//        System.out.println( Thread.currentThread().getName() + "取出消息" +  message);
//    }


//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(
//                    value = "binx.queue",
//                    durable = "true"
//            ),
//            exchange = @Exchange(
//                    value = "binx.exchange",
//                    ignoreDeclarationExceptions = "true"
//            ),
//            key = "binx.key"
//    ))
//    public void  binx(Order order) {
//        System.out.println( Thread.currentThread().getName() +"  binx:" + order.getOrderId());
//        System.out.println( Thread.currentThread().getName() + "  binx:" + order.getAmount());
//    }
}
