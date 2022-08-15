package com.zengpeng.shardingsphere.demo_shardingsphere.threads;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TMailBoxTestEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.MailBoxTestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MailBoxTestRunnal implements Runnable {

    private String threadName;
    private JSONArray data;
    private MailBoxTestService mailBoxTestService;



    public MailBoxTestRunnal(String threadName, JSONArray data, MailBoxTestService mailBoxTestService1) {
        this.threadName = threadName;
        this.data = data;
        this.mailBoxTestService = mailBoxTestService1;
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(MailBoxTestService.class);
//        mailBoxTestService = ctx.getBean(MailBoxTestService.class);

    }

    @Override
    public void run() {
        for (int i = 0; i < data.size(); i++) {
            List<TMailBoxTestEntity> list = new ArrayList();
            JSONObject de = data.getJSONObject(i);
            String orgId = de.getString("o");
            Long userId = de.getLong("u");
            int num = de.getIntValue("m");
            if (Integer.parseInt(orgId) < 0 || userId < 0)
                continue;
            for (int j = 0; j < num; j++) {
                TMailBoxTestEntity tMailBoxTestEntity = new TMailBoxTestEntity();
                tMailBoxTestEntity.setOrgId(Long.parseLong(orgId));
                tMailBoxTestEntity.setUserId(userId);
                list.add(tMailBoxTestEntity);
            }
            mailBoxTestService.saveMailBoxTestEntityList(list);
            System.out.println("threadName:"+threadName+ " insert");
        }
        System.out.println("threadName:"+threadName+ " is over!");
    }
}
