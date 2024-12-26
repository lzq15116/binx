package com.liyuan.binx.config.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitBeanConfig {

//
//
//    // 正常队列
//    public static final String ORDER_QUEUE = "orderQueue";
//    // 死信队列
//    public static final String DEAD_LETTER_QUEUE = "orderDeadLetterQueue";
//    // 正常交换机
//    public static final String ORDER_EXCHANGE = "orderExchange";
//    // 死信交换机
//    public static final String DEAD_LETTER_EXCHANGE = "orderDeadLetterExchange";
//    public static final String ORDER_ROUTING_KEY = "orderRoutingKey";
//    public static final String DEAD_LETTER_ROUTING_KEY = "orderDeadLetterRoutingKey";
//
//
//    @Bean
//    public Queue orderQueue() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
//        map.put("x-dead-letter-routing-key", DEAD_LETTER_ROUTING_KEY);
//        map.put("x-message-ttl", 5000);
//
//        return new Queue(ORDER_QUEUE, true, false, false, map);
//    }
//
//    @Bean
//    public Queue deadLetterQueue() {
//        return new Queue(DEAD_LETTER_QUEUE, true);
//    }
//
//    @Bean
//    public DirectExchange orderExchange() {
//        return new DirectExchange(ORDER_EXCHANGE);
//    }
//
//    @Bean
//    public DirectExchange deadLetterExchange() {
//        return new DirectExchange(DEAD_LETTER_EXCHANGE);
//    }
//
//    @Bean
//    public Binding orderBinding(Queue orderQueue, DirectExchange orderExchange) {
//        return BindingBuilder.bind(orderQueue).to(orderExchange).with(ORDER_ROUTING_KEY);
//    }
//
//    @Bean
//    public Binding deadLetterBinding(Queue deadLetterQueue, DirectExchange deadLetterExchange) {
//        return BindingBuilder.bind(deadLetterQueue).to(deadLetterExchange).with(DEAD_LETTER_ROUTING_KEY);
//    }
//
//    @Bean
//    public Queue blogQueue() {
//        return new Queue("blog_queue",true);
//    }
//
//    @Bean
//    public TopicExchange blogExchange() {
//        return new TopicExchange("blog_exchange");
//    }
//
//    @Bean
//    public Binding blogBinding(Queue blogQueue, TopicExchange blogExchange) {
//        return BindingBuilder.bind(blogQueue).to(blogExchange).with("blog_key");
//    }
//
////    @Bean
////    public Queue test2Queue() {
////        return QueueBuilder.durable("test2_queue")
////                .withArgument("x-dead-letter-exchange", "deadLetterExchange") // 配置死信交换机
////                .withArgument("x-dead-letter-routing-key", "deadLetterRoutingKey") // 配置死信路由键
////                .build();
////    }


}
