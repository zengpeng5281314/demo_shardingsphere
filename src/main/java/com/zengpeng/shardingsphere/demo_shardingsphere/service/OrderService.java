package com.zengpeng.shardingsphere.demo_shardingsphere.service;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;

import java.util.List;

public interface OrderService {

    void addOrder(TOrderEntity tOrderEntity);

    TOrderEntity selectById(Long id);

    TOrderEntity selectByBId(Long id,Long bid);

    List<TOrderEntity> listByBusinessId(Long listByBusinessId);

}
