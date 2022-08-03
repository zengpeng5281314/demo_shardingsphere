package com.zengpeng.shardingsphere.demo_shardingsphere.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "leaf" , fallback = GetPrimaryKeyFeignFallback.class)
public interface GetPrimaryKeyFeign {

    @RequestMapping("/leaf/api/segment/get/tes")
    String getSegmentPrimaryKey();

    @RequestMapping("/leaf/api/snowflake/get/id")
    String getSnowflakePrimaryKey();



}
