package com.liyuan.binx.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.stereotype.Component;

@Component("rabbitMqErrorHandler")
public class RabbitMqErrorHandler implements RabbitListenerErrorHandler {
    @Override
    public Object handleError(Message amqpMessage, org.springframework.messaging.Message<?> message, ListenerExecutionFailedException exception) throws Exception {

        System.out.println("报错啦报错啦报错啦报错啦报错啦报错啦报错啦报错啦报错啦报错啦报错啦报错啦报错啦报错啦");
        Channel channel = message.getHeaders().get(AmqpHeaders.CHANNEL, Channel.class);
        Long deliveryTag = message.getHeaders().get(AmqpHeaders.DELIVERY_TAG, Long.class);
        if (channel != null && deliveryTag != null) {
            channel.basicNack(deliveryTag, false, false);
        }
        System.out.println("报错啦报错啦报错啦报错啦报错啦！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
        return null;
    }
}
