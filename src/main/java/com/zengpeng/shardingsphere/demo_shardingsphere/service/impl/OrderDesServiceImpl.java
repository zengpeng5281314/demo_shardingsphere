package com.zengpeng.shardingsphere.demo_shardingsphere.service.impl;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderDesEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.repository.TOrderDesRepository;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderDesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDesServiceImpl implements OrderDesService {

    @Autowired
    private TOrderDesRepository tOrderDesRepository;

    @Override
    public void saveOrderList(List<TOrderDesEntity> tOrderDesEntities) {
        tOrderDesRepository.saveAll(tOrderDesEntities);
    }

    @Override
    public List<TOrderDesEntity> selectByBIdAndUserID(Long bid, Long userID) {
        TOrderDesEntity orderEntity = new TOrderDesEntity();
        orderEntity.setBusinessId(bid);
        orderEntity.setUserId(userID);
        Example<TOrderDesEntity> example = Example.of(orderEntity);
        return tOrderDesRepository.findAll(example);
    }
}
