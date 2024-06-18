package com.liyuan.binx.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Order {

    private String orderId;

    private BigDecimal amount;
}
