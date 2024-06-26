//package com.liyuan.binx.mq;
//
//import cn.hutool.core.util.StrUtil;
//import com.alibaba.fastjson.JSONObject;
//import com.liyuan.binx.constant.MqConstant;
//import com.liyuan.binx.entity.Order;
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.ExchangeTypes;
//import org.springframework.amqp.rabbit.annotation.*;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.support.AmqpHeaders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.retry.support.RetryTemplate;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@Slf4j
//public class CoinConsumer {
//
//    @Autowired
//    private RetryTemplate retryTemplate;
//
//    @RabbitListener(id = "CoinConsumer",
//            bindings = @QueueBinding(
//                    value = @Queue(
//                            value = MqConstant.COIN_QUEUE,
//                            durable = "true",
//                            arguments =
//                                    {@Argument(
//                                            name = "x-dead-letter-exchange",
//                                            value = "deadLetterExchange"
//                                    ), @Argument(
//                                            name = "x-dead-letter-routing-key",
//                                            value = "deadLetter"
//                                    ), @Argument(
//                                            name = "x-message-ttl",
//                                            value = "50000",
//                                            type = "java.lang.Integer"
//                                    )
//                                    }
//
//                    ),
//                    exchange = @Exchange(
//                            value = MqConstant.COIN_EXCHANGE,
//                            durable = "true",
//                            type = ExchangeTypes.TOPIC
//                    ),
//                    key = MqConstant.COIN_KEY
//            )
//            ,
//            errorHandler = "rabbitMqErrorHandler"
//    )
//    @SendTo("echo_exchange")
//    public void coin(String msg, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException, InterruptedException {
//
//        try {
//            retryTemplate.execute(context -> {
//                try {
//                    System.out.println("Received Message: " + msg);
////                    channel.basicAck(tag, false);
//                    System.out.println(1 / 0);
//                } catch (Exception e) {
//                    throw new RuntimeException("Failed to process message", e);
//                }
//                return null;
//            });
//        } catch (Exception e) {
//            channel.basicNack(tag, false, false);
//        }
//    }
//
//}
