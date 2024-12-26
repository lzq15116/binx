package com.liyuan.binx.service.biz;

import com.alibaba.fastjson.JSONObject;
import com.liyuan.binx.entity.Orders;
import com.liyuan.binx.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class TransactionService {

    private final OrderService orderService;
    private final RabbitTemplate rabbitTemplate;


    @Transactional(rollbackFor = Exception.class)
    public void transactionSendAndSave() throws InterruptedException {

        Orders orders = Orders.builder().amount(BigDecimal.valueOf(777)).createTime(System.currentTimeMillis()).build();
        orderService.save(orders);
        System.out.println(orders.getOrderId());

        rabbitTemplate.convertAndSend("test_exchange", "test_key", JSONObject.toJSONString(orders));
        System.out.println("方法执行完毕");

        Thread.sleep(3000L);

//        System.out.println(1/0);

    }
}
