package com.zengpeng.shardingsphere.demo_shardingsphere.service;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderDesEntity;

import java.util.List;

public interface OrderDesService {

    void saveOrderList(List<TOrderDesEntity> tOrderDesEntities);

    List<TOrderDesEntity> selectByBIdAndUserID(Long bid, Long userID);
}
