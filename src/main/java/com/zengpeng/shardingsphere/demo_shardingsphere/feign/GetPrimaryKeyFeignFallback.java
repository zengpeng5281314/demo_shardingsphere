package com.zengpeng.shardingsphere.demo_shardingsphere.feign;

import org.springframework.stereotype.Service;

@Service
public class GetPrimaryKeyFeignFallback implements GetPrimaryKeyFeign {


    @Override
    public String getSegmentPrimaryKey() {
        return null;
    }

    @Override
    public String getSnowflakePrimaryKey() {
        return null;
    }
}
