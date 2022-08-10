package com.zengpeng.shardingsphere.demo_shardingsphere;

import com.alibaba.fastjson.JSONObject;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderDesEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderDetailEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.feign.TestFeign;
import com.zengpeng.shardingsphere.demo_shardingsphere.repository.TOrderDetailRepository;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderDesService;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderService;
import com.zengpeng.shardingsphere.demo_shardingsphere.util.LeftGenerator;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class OrderAndOrderDesTests {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderDesService orderDesService;


    @Test
    void testLeftJoin(){
        //测试leftjoin
        System.out.println("----"+orderService.getListLeftJoin(1554793079033036840L));
    }

    @Test
    void insert() {
        List<TOrderEntity> list = new ArrayList<>();
        List<TOrderDesEntity> listTOrderDesEntity = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            TOrderEntity tOrderEntity = new TOrderEntity();
            tOrderEntity.setBusinessId(Long.valueOf(i));
            tOrderEntity.setOrderId(Long.valueOf(i));
            tOrderEntity.setUserId(Long.valueOf(i));
            list.add(tOrderEntity);
            TOrderDesEntity tOrderDesEntity = new TOrderDesEntity();
            tOrderDesEntity.setBusinessId(Long.valueOf(i));
            tOrderDesEntity.setUserId(Long.valueOf(i));
            tOrderDesEntity.setOrderDes("订单描述："+i);
            tOrderDesEntity.setOrderId(Long.valueOf(i));
            listTOrderDesEntity.add(tOrderDesEntity);
        }
        orderService.saveOrderList(list);
        orderDesService.saveOrderList(listTOrderDesEntity);
    }

    @Test
    void getListLeftJoin(){
        orderService.getListLeftJoin(1L,1L);
    }

    @Test
    void selectByBIdAndUserID(){
        orderDesService.selectByBIdAndUserID(1L,1L);
    }


    public static void main(String[] args) {
        Long id = 1L;
        System.out.println("------"+Math.abs(id.hashCode()) % 4);
    }

}
