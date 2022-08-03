package com.zengpeng.shardingsphere.demo_shardingsphere.feign;

import com.xhl.feignserviceapi.feigndto.Result;
import com.xhl.feignserviceapi.feigndto.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestFeignFallbackFactory implements FallbackFactory<TestFeign> {

    @Override
    public TestFeign create(Throwable cause) {
        log.info("获取id报错："+cause.getMessage());
        return new TestFeign() {
            @Override
            public Result getSegmentPrimaryKey(String key) {
                return ResultUtil.error("-2","获取主键id失败 失败原因："+cause.getMessage());
            }

            @Override
            public Result getSegmentPrimaryKeys(String key, int size) {
                return ResultUtil.error("-2","获取主键id失败 失败原因："+cause.getMessage());
            }

            @Override
            public Result getSnowflakePrimaryKey(String key) {
                return ResultUtil.error("-2","获取主键id失败 失败原因："+cause.getMessage());
            }

            @Override
            public Result getSnowflakePrimaryKeys(String key, int size) {
                return ResultUtil.error("-2","获取主键id失败 失败原因："+cause.getMessage());
            }

            @Override
            public Result decodeSnowflakeId(String snowflakeIdStr) {
                return ResultUtil.error("-2","解析id失败 失败原因："+cause.getMessage());
            }
        };
    }
}
