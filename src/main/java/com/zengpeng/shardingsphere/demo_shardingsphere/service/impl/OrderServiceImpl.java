package com.zengpeng.shardingsphere.demo_shardingsphere.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zengpeng.shardingsphere.demo_shardingsphere.dto.OrderInfoDTO;
import com.zengpeng.shardingsphere.demo_shardingsphere.dto.ParamRequest;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.repository.TOrderRepository;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TOrderRepository torderRepository;

    @Override
    public void addOrder(TOrderEntity tOrderEntity) {
        torderRepository.save(tOrderEntity);
    }

    @Override
    public void saveOrderList(List<TOrderEntity> tOrderEntities) {
        torderRepository.saveAll(tOrderEntities);
    }

    @Override
    public TOrderEntity selectById(Long id) {
        return torderRepository.findById(id).orElse(null);
    }

    @Override
    public TOrderEntity selectByBId(Long id, Long bid) {
        TOrderEntity orderEntity = new TOrderEntity();
        orderEntity.setBusinessId(bid);
        orderEntity.setId(id);
        Example<TOrderEntity> example = Example.of(orderEntity);
        List<TOrderEntity> list = torderRepository.findAll(example);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<TOrderEntity> listByBusinessId(Long listByBusinessId) {
        TOrderEntity orderEntity = new TOrderEntity();
        orderEntity.setBusinessId(listByBusinessId);
        Example<TOrderEntity> example = Example.of(orderEntity);
        return torderRepository.findAll(example);
    }

    @Override
    public List<OrderInfoDTO> getListLeftJoin(Long id) {
        List<OrderInfoDTO> listOrderInfoDTO = new ArrayList<>();
        List<Object[]> list = torderRepository.getListLeftJoin(id);
        //TODO 把list的数据取出来放入 OrderInfoDTO 中
        return listOrderInfoDTO;
    }

}
