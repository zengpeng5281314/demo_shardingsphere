package com.zengpeng.shardingsphere.demo_shardingsphere;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest

class DemoShardingsphereApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
        for (int i = 150; i < 200; i++) {
            TOrderEntity tOrderEntity = new TOrderEntity();
            tOrderEntity.setBusinessId(Long.valueOf(i));
//            tOrderEntity.setId(Long.valueOf(i));
            tOrderEntity.setOrderId(Long.valueOf(i));
            tOrderEntity.setUserId(Long.valueOf(i));
            orderService.addOrder(tOrderEntity);
        }

    }

    @Test
    void search() {
        System.out.println("------："+orderService.selectById(1L));
        System.out.println("------："+orderService.selectById(100L));

    }

    public static void main(String[] args) {
        Long s = 711642890467540993L;
        System.out.println(s%4);
    }

}
