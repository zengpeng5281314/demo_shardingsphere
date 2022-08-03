package com.zengpeng.shardingsphere.demo_shardingsphere.feign;


import com.xhl.feignserviceapi.feignapi.PrimaryKeyService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "leaf",fallbackFactory = TestFeignFallbackFactory.class)
public interface TestFeign extends PrimaryKeyService {
}
