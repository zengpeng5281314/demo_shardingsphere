package com.zengpeng.shardingsphere.demo_shardingsphere.controller;

import com.alibaba.fastjson.JSONObject;
import com.zengpeng.shardingsphere.demo_shardingsphere.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.Charset;

@RequestMapping("/test")
@Slf4j
@RestController
public class TestController {

    @PostMapping("/test")
    public String saveTask(HttpServletRequest request) {
        TestDto json =new TestDto();
        try {
            InputStream in = request.getInputStream();
            String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
             json = JSONObject.parseObject(body,TestDto.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSONObject.toJSONString(json);
    }

}
