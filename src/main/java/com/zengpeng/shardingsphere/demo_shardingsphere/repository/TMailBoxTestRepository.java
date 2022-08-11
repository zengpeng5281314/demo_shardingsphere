package com.zengpeng.shardingsphere.demo_shardingsphere.repository;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TMailBoxTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TMailBoxTestRepository extends JpaRepository<TMailBoxTestEntity,Long> {


}
