package com.liyuan.binx;

import com.alibaba.fastjson.JSONObject;
import com.liyuan.binx.entity.Orders;
import com.liyuan.binx.service.OrderService;
import com.liyuan.binx.service.biz.TransactionService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.*;

@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void future() throws ExecutionException, InterruptedException, TimeoutException {

        CorrelationData correlationData = new CorrelationData();
        rabbitTemplate.convertAndSend("fcm", "fcm", "foo");

    }

    @Test
    void send() throws InterruptedException {
        Orders order = Orders.builder().orderId("1111").amount(BigDecimal.valueOf(777)).build();
        System.out.println("发送消息线程：" + Thread.currentThread().getName());
        rabbitTemplate.convertAndSend("fcm", "fcm", "foo");
        rabbitTemplate.convertAndSend("binx.exchange", "binx.key", order);
        Thread.sleep(1000000);
    }

    @Autowired
    private Executor executor;

    @Test
    void sen2() throws InterruptedException {

//        Message message = MessageBuilder
//                .withBody("coin2".getBytes())
//                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
//                .setMessageId("123")
//                .build();

        Orders order = new Orders("2321", BigDecimal.valueOf(12), System.currentTimeMillis());

        for (int i = 0; i < 10; i++) {

            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                rabbitTemplate.convertAndSend("orderExchange", "orderRoutingKey", JSONObject.toJSONString(order));
            });
        }


        Thread.sleep(1000000);

    }

    @Test
    void sen3() throws InterruptedException {
        Orders order = new Orders("2321", BigDecimal.valueOf(12), System.currentTimeMillis());

        for (int i = 0; i < 1; i++) {

            executor.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
                rabbitTemplate.convertAndSend("orderExchange", "orderRoutingKey", JSONObject.toJSONString(order));
            });
        }

        Thread.sleep(1000000L);
    }

    @Autowired
    private TransactionService transactionService;

    @Test
    void sen4() throws InterruptedException {
        transactionService.transactionSendAndSave();

        Thread.sleep(1000000L);
    }


//    @Transactional
//    public void test() throws InterruptedException {
//        Orders orders = Orders.builder().amount(BigDecimal.valueOf(777)).createTime(System.currentTimeMillis()).build();
//        orderService.save(orders);
//
//        rabbitTemplate.convertAndSend("test_exchange", "test_key", orders);
//
//        Thread.sleep(3000L);
//        System.out.println(1/0);
//    }
}
