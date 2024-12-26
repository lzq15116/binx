//package com.liyuan.binx.mq;
//
//import com.liyuan.binx.entity.Orders;
//import com.liyuan.binx.mapper.OrderMapper;
//import com.liyuan.binx.service.OrderService;
//import lombok.AllArgsConstructor;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Component
//@AllArgsConstructor
//public class OrderConsumer {
//
//    private final OrderService orderService;
//
//    private final RabbitTemplate rabbitTemplate;
//
//    @RabbitListener(queues = "orderQueue")
//    public void order(String msg) {
//        System.out.println("receive order : " + msg);
//
//
//        orderService.save(Orders.builder().amount(BigDecimal.valueOf(999)).createTime(System.currentTimeMillis()).build());
//
//
//        String blog = "blog" + Math.random();
//        rabbitTemplate.convertAndSend("blog_exchange", "blog_key", blog);
//
////        System.out.println(1/0);
//    }
//
//}
