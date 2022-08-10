package com.zengpeng.shardingsphere.demo_shardingsphere.service;

import com.zengpeng.shardingsphere.demo_shardingsphere.dto.OrderDesInfoDTO;
import com.zengpeng.shardingsphere.demo_shardingsphere.dto.OrderInfoDTO;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;

import java.util.List;

public interface OrderService {

    void addOrder(TOrderEntity tOrderEntity);

    void saveOrderList(List<TOrderEntity> tOrderEntities);

    TOrderEntity selectById(Long id);

    TOrderEntity selectByBId(Long id,Long bid);

    List<TOrderEntity> selectByBIdAndUserID(Long bid,Long userID);

    List<TOrderEntity> listByBusinessId(Long listByBusinessId);

    List<OrderInfoDTO> getListLeftJoin(Long id);

    List<OrderDesInfoDTO> getListLeftJoin(Long bid, Long userId);

}
