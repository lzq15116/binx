package com.liyuan.binx;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.s3.AmazonS3;
import com.liyuan.binx.constant.MqConstant;
import com.liyuan.binx.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
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
        rabbitTemplate.convertAndSend("fcm", "fcm", "foo");

    }

    @Test
    void send() throws InterruptedException {
        Order order = Order.builder().orderId("1111").amount(BigDecimal.valueOf(777)).build();
        System.out.println("发送消息线程：" + Thread.currentThread().getName());
        rabbitTemplate.convertAndSend("fcm", "fcm", "foo");
        rabbitTemplate.convertAndSend("binx.exchange", "binx.key", order);
        Thread.sleep(1000000);
    }

    @Test
    void sen2() throws InterruptedException {

//        Message message = MessageBuilder
//                .withBody("coin2".getBytes())
//                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
//                .setMessageId("123")
//                .build();

        Order order = new Order("2321", BigDecimal.valueOf(12));

        rabbitTemplate.convertAndSend(MqConstant.COIN_EXCHANGE, MqConstant.COIN_KEY, JSONObject.toJSONString(order), new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties messageProperties = message.getMessageProperties();
                messageProperties.setAppId("2323232323");

                return message;
            }
        });
        Thread.sleep(1000000);

    }
}
