package com.zengpeng.shardingsphere.demo_shardingsphere;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderDetailEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.repository.TOrderDetailRepository;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.OrderService;
import org.apache.commons.collections4.keyvalue.DefaultKeyValue;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class DemoShardingsphereApplicationTests {

    @Autowired
    OrderService orderService;
    @Autowired
    TOrderDetailRepository tOrderDetailRepository;

    @Test
    void contextLoads() {
//        748252925360345089
//        748252925721055232
        for (int i = 1; i < 1001; i++) {
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
        System.out.println("------：" + orderService.selectById(742354717409017857L));
//        System.out.println("------："+orderService.selectById(742351195191902208L));
//
//        System.out.println("------："+orderService.selectByBId(742351195716190208L,7L));
//
//        System.out.println("------："+orderService.listByBusinessId(7L));
    }

    @Test
    void getOrderDetalById() {
        System.out.println("------：" + tOrderDetailRepository.findById(1L).orElse(null));
    }

    @Test
    void saveOrderDetal() {
        TOrderDetailEntity tOrderDetailEntity = new TOrderDetailEntity();
        tOrderDetailEntity.setOrderId(4L);
        tOrderDetailEntity.setOrderName("赵六");
        System.out.println("------：" + tOrderDetailRepository.save(tOrderDetailEntity));
    }

    @Test
    void getId(){
        SnowflakeShardingKeyGenerator ssk=new SnowflakeShardingKeyGenerator();
        Properties properties = ssk.getProperties();
        for (int i =0;i<100;i++){
            Long id = Long.parseLong(ssk.generateKey().toString());

            System.out.println(id+"      "+id%8);
        }



        //        748252925360345089
//        748252925721055232
    }


    public static void main(String[] args) {
        Long s = 748543553042886656L;
        System.out.println(s % 8);

        Long s1 = 748543553525231617L;
        System.out.println(s1 % 8);
        Long s2 = 748543557379796992L;
        System.out.println(s2 % 8);
        Long s3 = 748543558415790081L;
        System.out.println(s3 % 8);




        System.out.println(9840 % 16);

        Long ss = 712615701625438209L;
        System.out.println(ss % 16);
        System.out.println(8209 % 16);

        System.out.println(4516113513L % 16);
        System.out.println(3513 % 16);

        System.out.println(4516113514L % 16);
        System.out.println(3514 % 16);

    }

}
