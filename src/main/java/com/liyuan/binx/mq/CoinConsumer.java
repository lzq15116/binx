package com.liyuan.binx.mq;

import com.alibaba.fastjson.JSONObject;
import com.liyuan.binx.constant.MqConstant;
import com.liyuan.binx.entity.Order;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CoinConsumer {

    @RabbitListener(id = "CoinConsumer", bindings = @QueueBinding(
            value = @Queue(
                    value = MqConstant.COIN_QUEUE,
                    durable = "true"
            ),
            exchange = @Exchange(
                    value = MqConstant.COIN_EXCHANGE,
                    durable = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = MqConstant.COIN_KEY
    ))
    @SendTo("echo_exchange")
    public String coin(String msg, Channel channel, CorrelationData correlationData, @Header(AmqpHeaders.DELIVERY_TAG) long tag, @Header(AmqpHeaders.APP_ID) String contentType) throws IOException {
        Order order = JSONObject.parseObject(msg, Order.class);
        System.out.println("coin收到消息：{}" + order);
//        channel.basicNack(tag,false,true);
        System.out.println(channel);
        System.out.println(tag);
        System.out.println(contentType);
        return "success";
    }

}
