//package com.zengpeng.shardingsphere.demo_shardingsphere.feign;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.openfeign.FallbackFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class GetPrimaryKeyFeignFallbackFactory implements FallbackFactory<GetPrimaryKeyFeign> {
//
//
//    @Override
//    public GetPrimaryKeyFeign create(Throwable cause) {
//        log.info("fallback; reason was: {}", cause.getMessage());
//        return new GetPrimaryKeyFeign() {
//            @Override
//            public String getSegmentPrimaryKey() {
//                return null;
//            }
//
//            @Override
//            public String getSnowflakePrimaryKey() {
//                return null;
//            }
//        };
//    }
//}
