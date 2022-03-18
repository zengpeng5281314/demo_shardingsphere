package com.zengpeng.shardingsphere.demo_shardingsphere.service;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;

public interface OrderService {

    void addOrder(TOrderEntity tOrderEntity);

    TOrderEntity selectById(Long id);

}
