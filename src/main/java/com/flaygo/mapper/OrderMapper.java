package com.flaygo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flaygo.entity.OrderEntity;

public interface OrderMapper {

    List<OrderEntity> getAll();

    void update(OrderEntity orderEntity);

    void insert(OrderEntity orderEntity);
    
    List<OrderEntity> querypage(@Param("start") int start, @Param("pageSize") int pageSize);
}
