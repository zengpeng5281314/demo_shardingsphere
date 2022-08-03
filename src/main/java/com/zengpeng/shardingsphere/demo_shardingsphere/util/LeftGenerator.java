package com.zengpeng.shardingsphere.demo_shardingsphere.util;


import com.alibaba.fastjson.JSONObject;
import com.zengpeng.shardingsphere.demo_shardingsphere.feign.TestFeign;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Slf4j
@Component
public final class LeftGenerator implements ShardingKeyGenerator, ApplicationContextAware {


    private static TestFeign testFeign;

    @Override
    public Comparable<?> generateKey() {
       JSONObject jsonObject =  JSONObject.parseObject(JSONObject.toJSONString(testFeign.getSnowflakePrimaryKey("LEFTSNOWFLAKE")));
        log.info(jsonObject.toJSONString());
       Long id = null;
        if(jsonObject.getString("code").equals("1")){
            String primaryKey = jsonObject.getJSONObject("data").getString("primaryKey");
            id = Long.parseLong(primaryKey);
        }
        return id;
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        testFeign = applicationContext.getBean(TestFeign.class);
    }
}
