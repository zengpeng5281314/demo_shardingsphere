package com.zengpeng.shardingsphere.demo_shardingsphere.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDesInfoDTO implements Serializable {

    private Long id;
    private Long orderId;
    private Long userId;
    private Long businessId;
    private String orderDes;

}
