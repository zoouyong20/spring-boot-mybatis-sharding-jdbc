package com.flaygo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flaygo.entity.OrderEntity;
import com.flaygo.mapper.OrderMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper ;

    public List<OrderEntity> getUsers() {
        List<OrderEntity> users=orderMapper.getAll();
        return users;
    }
    
    public List<OrderEntity> getUsers(int start,int pageSize) {
        List<OrderEntity> users=orderMapper.querypage(start, pageSize);
        return users;
    }

    public void updateTransactional(OrderEntity orderEntity) {
        try{
            orderMapper.insert(orderEntity);
            log.error(String.valueOf(orderEntity));
        }catch(Exception e){
            log.error("find exception!");
            throw e;   
        }

    }
}