package com.liyuan.binx;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.math.BigDecimal;

@SpringBootTest
class BinxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void name() {
        BigDecimal bigDecimal = BigDecimal.valueOf(3.14159262732723232321312312312);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(3.14159262732723232321312312312);

        System.out.println(bigDecimal.multiply(bigDecimal2));
    }

    @Test
    void ee() {

        String a = null;
        assert a != null;
        System.out.println(1111);
    }

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    void rabbit() {
        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("fcm","fcm","fcm");
        }
    }

    @Test
    void date() {
        System.out.println(DateUtil.parse("2024-04-01 00:00:00").getTime());
        System.out.println(DateUtil.parse("2024-06-17 00:00:00").getTime());
    }
}
