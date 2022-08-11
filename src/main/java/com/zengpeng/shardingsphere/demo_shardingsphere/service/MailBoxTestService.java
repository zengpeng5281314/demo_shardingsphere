package com.zengpeng.shardingsphere.demo_shardingsphere.service;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TMailBoxTestEntity;

import java.util.List;

public interface MailBoxTestService {

    void saveMailBoxTestEntityList(List<TMailBoxTestEntity> tMailBoxTestEntityList);

    TMailBoxTestEntity selectById(Long orgId, Long userId, Long id);

    List<TMailBoxTestEntity> selectByBIdAndUserID(Long orgId, Long userId);

}
