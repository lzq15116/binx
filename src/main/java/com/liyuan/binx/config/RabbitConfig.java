package com.liyuan.binx.config;

import com.alibaba.fastjson.JSONArray;
import com.liyuan.binx.entity.Order;
import com.rabbitmq.client.Channel;
import io.micrometer.observation.annotation.Observed;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerEndpoint;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost", 5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        CachingConnectionFactory publisherConnectionFactory = (CachingConnectionFactory)connectionFactory.getPublisherConnectionFactory();
        publisherConnectionFactory.setChannelCacheSize(1);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate amqpTemplate() {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    System.out.println("消息确认成功:" + correlationData);
                } else {
                    System.out.println("消息确认失败:" + cause);
                }
            }
        });

        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returned) {
                System.out.println(returned.getMessage());
                System.out.println(returned.getReplyCode());
            }
        });

        rabbitTemplate.setMessageConverter(jsonMessageConverter());

        return rabbitTemplate;

    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory) {
        SimpleRabbitListenerEndpoint endpoint = new SimpleRabbitListenerEndpoint();
        endpoint.setQueueNames("binx.queue");
//        endpoint.setMessageConverter(jsonMessageConverter());
        endpoint.setMessageListener(d -> {
            System.out.println(d);
//            Order order = JSONArray.parseObject(d.getBody(), Order.class);
//            System.out.println(order.getOrderId());
//            System.out.println(order.getAmount());
        });

        return rabbitListenerContainerFactory.createListenerContainer(endpoint);
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer2(SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory) {
        SimpleRabbitListenerEndpoint endpoint = new SimpleRabbitListenerEndpoint();
        endpoint.setQueueNames("fcm");
//        endpoint.setMessageConverter(jsonMessageConverter());
        endpoint.setMessageListener(
                new ChannelAwareMessageListener() {
                    @Override
                    public void onMessage(Message message, Channel channel) throws Exception {
                        System.out.println(message);
                        System.out.println(channel.getChannelNumber());
                    }
                }
//            Order order = JSONArray.parseObject(d.getBody(), Order.class);
//            System.out.println(order.getOrderId());
//            System.out.println(order.getAmount());
        );

        return rabbitListenerContainerFactory.createListenerContainer(endpoint);
    }



    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
//
//    @Bean
//    public Queue fcmQueue() {
//        return new Queue("fcm",true);
//    }
//
//    @Bean
//    public TopicExchange fcmTopicExchange() {
//        return new TopicExchange("fcm");
//    }
//
//    @Bean
//    public Binding fcmBinding() {
//        return BindingBuilder.bind(fcmQueue()).to(fcmTopicExchange()).with("fcm");
//    }
}
