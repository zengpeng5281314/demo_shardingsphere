package com.zengpeng.shardingsphere.demo_shardingsphere;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderService;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
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
        for (int i = 1; i < 1000; i++) {
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
        Long s = 712615701344419840L;
        System.out.println(s%8);

        Long ss = 712615701625438209L;
        System.out.println(ss%8);

    }

}
