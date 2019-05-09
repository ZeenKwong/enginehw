package com.unicom.springboot.service.impl;

import com.unicom.springboot.entity.Orders;
import com.unicom.springboot.entity.OrdersExample;
import com.unicom.springboot.mapper.OrdersMapper;
import com.unicom.springboot.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @ClassName：OrderServiceImpl
 * @Author：kuangzy
 * @Time：2019/5/9 17:15
 * @Discription:discription
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public List<Orders> findOrders(int userId) {
        OrdersExample ordersExample = new OrdersExample();
        if (userId != 0){
            OrdersExample.Criteria criteria = ordersExample.createCriteria();
            criteria.andOrderUseridEqualTo(userId);
        };
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        return orders;
    }

    @Override
    public int addOrder(Orders orders) {
        return ordersMapper.insert(orders);
    }

    @Override
    public int delOrder(int OrderId) {
        return ordersMapper.deleteByPrimaryKey(OrderId);
    }

    @Override
    public int updateOrder(Orders orders) {
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }
}
