package com.zengpeng.shardingsphere.demo_shardingsphere.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfoDTO implements Serializable {

    private Long id;
    private String orderName;
    private Long orderId;
    private Long userId;
    private Long businessId;

}
