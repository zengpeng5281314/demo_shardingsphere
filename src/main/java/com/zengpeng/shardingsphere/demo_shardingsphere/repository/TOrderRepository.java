package com.zengpeng.shardingsphere.demo_shardingsphere.repository;

import com.zengpeng.shardingsphere.demo_shardingsphere.dto.OrderInfoDTO;
import com.zengpeng.shardingsphere.demo_shardingsphere.entity.TOrderEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TOrderRepository extends JpaRepository<TOrderEntity,Long> {


    @Query(value = "select t.id,t.order_id orderId,t.user_id userId,t.business_id businessId,b.order_name orderName from t_order t left join t_order_detail b on t.id = b.order_id where t.id = :id and t.business_id=32",nativeQuery = true)
    List<Object[]>  getListLeftJoin(@Param("id") Long id);

}
