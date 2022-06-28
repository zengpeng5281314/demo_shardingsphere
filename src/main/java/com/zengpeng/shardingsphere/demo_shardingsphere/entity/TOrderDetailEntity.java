package com.zengpeng.shardingsphere.demo_shardingsphere.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name = "t_order_detail")
@Data
@Entity
public class TOrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_name")
    private String orderName;

}
