package com.zengpeng.shardingsphere.demo_shardingsphere.repository;

import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TOrderRepository extends JpaRepository<TOrderEntity,Long> {

}
