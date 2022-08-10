package com.zengpeng.shardingsphere.demo_shardingsphere;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderDesEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderDesService;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderServiceTests {

    @Autowired
    OrderService orderService;


    @Test
    void getByBidAndUserID(){
        System.out.println("----"+orderService.selectByBIdAndUserID(1L,1L));

    }




}
