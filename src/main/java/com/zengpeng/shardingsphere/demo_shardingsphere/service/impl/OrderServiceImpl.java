package com.zengpeng.shardingsphere.demo_shardingsphere.service.impl;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.repository.TOrderRepository;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TOrderRepository torderRepository;

    @Override
    public void addOrder(TOrderEntity tOrderEntity) {
        torderRepository.save(tOrderEntity);
    }

    @Override
    public TOrderEntity selectById(Long id) {
        return torderRepository.findById(id).orElse(null);
    }
}
