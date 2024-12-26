package com.liyuan.binx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("orders")
public class Orders implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private String orderId;

    private BigDecimal amount;

    private Long createTime;
}
