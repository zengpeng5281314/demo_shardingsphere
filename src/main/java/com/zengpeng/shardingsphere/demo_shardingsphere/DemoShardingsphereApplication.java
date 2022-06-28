package com.zengpeng.shardingsphere.demo_shardingsphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableJpaRepositories("com.zengpeng.shardingsphere.demo_shardingsphere.repository")
public class DemoShardingsphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShardingsphereApplication.class, args);
    }

}
