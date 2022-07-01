package com.zengpeng.shardingsphere.demo_shardingsphere.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestDto {

    private String name;
    private List<String> url;

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public void setUrl(String url) {

        List<String> list = new ArrayList<>();
        list.add(url);
        this.url = list;
    }
}
