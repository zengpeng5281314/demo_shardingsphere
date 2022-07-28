package com.zengpeng.shardingsphere.demo_shardingsphere.util;

import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

public final class LeftGenerator implements ShardingKeyGenerator {


    @Override
    public Comparable<?> generateKey() {

        return null;
    }

    @Override
    public String getType() {
        return "LEFTSNOWFLAKE";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
