package com.zengpeng.shardingsphere.demo_shardingsphere.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name="t_order")
@Data
@Entity
public class TOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  Long orderId;

    private Long userId;

    private Long businessId;

}
