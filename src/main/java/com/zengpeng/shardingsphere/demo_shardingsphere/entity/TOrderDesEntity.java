package com.zengpeng.shardingsphere.demo_shardingsphere.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name="t_order_des")
@Data
@Entity
public class TOrderDesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long businessId;

    private String orderDes;

    private Long orderId;

}
