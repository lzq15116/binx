package com.liyuan.binx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liyuan.binx.entity.Orders;
import com.liyuan.binx.mapper.OrderMapper;
import  com.liyuan.binx.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
}
