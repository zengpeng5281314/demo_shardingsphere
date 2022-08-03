package com.zengpeng.shardingsphere.demo_shardingsphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableJpaRepositories("com.zengpeng.shardingsphere.demo_shardingsphere.repository")
@EnableFeignClients
@EnableDiscoveryClient
@RestController
public class DemoShardingsphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShardingsphereApplication.class, args);
    }

    @GetMapping("/status/health")
    public int healthCheck(){
        return 1;
    }
}
