package com.zengpeng.shardingsphere.demo_shardingsphere.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name="mail_box_test")
@Data
@Entity
public class TMailBoxTestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long orgId;

}
