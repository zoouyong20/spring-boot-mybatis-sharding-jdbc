package com.flaygo.mapper;

import java.util.List;

import com.flaygo.entity.OrderEntity;

public interface OrderMapper {

    List<OrderEntity> getAll();

    void update(OrderEntity orderEntity);

    void insert(OrderEntity orderEntity);
}
