package com.unicom.springboot.service.service;

import com.unicom.springboot.entity.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @ClassName：OrderService
 * @Author：kuangzy
 * @Time：2019/5/9 17:13
 * @Discription:discription
 */
public interface OrderService {
    //新增一张订单
    int addOrder(Orders orders);
    //删除一张订单
    int delOrder(int userId);
    // 查询全部订单
    List<Orders> findOrders(int OrderId);
    // 修改订单信息
    int updateOrder(Orders orders);


}
