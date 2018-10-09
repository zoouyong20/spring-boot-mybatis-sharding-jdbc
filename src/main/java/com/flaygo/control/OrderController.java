package com.flaygo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flaygo.entity.OrderEntity;
import com.flaygo.enums.UserSexEnum;
import com.flaygo.service.OrderService;

@Service
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getUsers")
    public List<OrderEntity> getOrderEntitys(@RequestParam(value = "start") Integer start,
            @RequestParam(value = "size") Integer size) {
        
        List<OrderEntity> users=orderService.getUsers(start,size);
        return users;
    }

    //测试
    @RequestMapping(value="update")
    public String updateTransactional(@RequestParam(value = "id") Long id,
                                    @RequestParam(value = "userId") Long userId,
                                    @RequestParam(value = "orderId") Long orderId,
                                    @RequestParam(value = "nickName") String nickName,
                                    @RequestParam(value = "passWord") String passWord,
                                    @RequestParam(value = "userName") String userName
                                    ) {
        OrderEntity user2 = new OrderEntity();
        user2.setId(id);
        user2.setUserId(userId);
        user2.setOrderId(orderId);
        user2.setNickName(nickName);
        user2.setPassWord(passWord);
        user2.setUserName(userName);
        user2.setUserSex(UserSexEnum.WOMAN);
        orderService.updateTransactional(user2);
        return "test";
    }
}