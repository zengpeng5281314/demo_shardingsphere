package com.zengpeng.shardingsphere.demo_shardingsphere.service.impl;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TMailBoxTestEntity;
import com.zengpeng.shardingsphere.demo_shardingsphere.repository.TMailBoxTestRepository;
import com.zengpeng.shardingsphere.demo_shardingsphere.service.MailBoxTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxTestServiceImpl implements MailBoxTestService {

    @Autowired
    private TMailBoxTestRepository tMailBoxTestRepository;

    @Override
    public void saveMailBoxTestEntityList(List<TMailBoxTestEntity> tMailBoxTestEntityList) {
        tMailBoxTestRepository.saveAll(tMailBoxTestEntityList);
    }

    @Override
    public TMailBoxTestEntity selectById(Long orgId, Long userId, Long id) {
        TMailBoxTestEntity tMailBoxTestEntity = new TMailBoxTestEntity();
        tMailBoxTestEntity.setOrgId(orgId);
        tMailBoxTestEntity.setUserId(userId);
        tMailBoxTestEntity.setId(id);
        Example<TMailBoxTestEntity> example = Example.of(tMailBoxTestEntity);
        List<TMailBoxTestEntity> list = tMailBoxTestRepository.findAll(example);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

    @Override
    public List<TMailBoxTestEntity> selectByBIdAndUserID(Long orgId, Long userId) {
        TMailBoxTestEntity tMailBoxTestEntity = new TMailBoxTestEntity();
        tMailBoxTestEntity.setOrgId(orgId);
        tMailBoxTestEntity.setUserId(userId);
        Example<TMailBoxTestEntity> example = Example.of(tMailBoxTestEntity);
        return tMailBoxTestRepository.findAll(example);
    }
}
