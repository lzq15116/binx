package com.liyuan.binx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liyuan.binx.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
