package com.liyuan.binx;

import com.amazonaws.services.s3.AmazonS3;
import com.liyuan.binx.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void future() throws ExecutionException, InterruptedException, TimeoutException {

        CorrelationData correlationData = new CorrelationData();
        rabbitTemplate.convertAndSend("fcm","fcm","foo");

    }

    @Test
    void send() throws InterruptedException {
        Order order = Order.builder().orderId("1111").amount(BigDecimal.valueOf(777)).build();
        System.out.println("发送消息线程：" +  Thread.currentThread().getName());
        rabbitTemplate.convertAndSend("fcm","fcm","foo");
        rabbitTemplate.convertAndSend("binx.exchange","binx.key",order);
        Thread.sleep(1000000);
    }
}
