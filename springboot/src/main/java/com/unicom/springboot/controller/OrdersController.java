package com.unicom.springboot.controller;

import com.unicom.springboot.entity.Orders;
import com.unicom.springboot.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName：OrdersController
 * @Author：kuangzy
 * @Time：2019/5/9 17:55
 * @Discription:discription
 */
@RestController
public class OrdersController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/addorder",method = RequestMethod.POST)
    public int addOrder(@RequestBody Orders orders){
        Orders order = new Orders();
        order.setCreatetime(orders.getCreatetime());
        order.setOrderGoodscount(orders.getOrderGoodscount());
        order.setOrderNote(orders.getOrderNote());
        order.setOrderUserid(orders.getOrderUserid());
        return orderService.addOrder(order);
    }

    @RequestMapping("/deleteorder/{orderId}")
    public int deleteOrder(@PathVariable int orderId){
        return orderService.delOrder(orderId);
    }

    @RequestMapping("/findorder/{userId}")
    public List<Orders> findOrder(@PathVariable int userId){
        return orderService.findOrders(userId);
    }

    @RequestMapping(value = "/updateorder",method = RequestMethod.POST)
    public int updateOrder(@RequestBody Orders orders){
        Orders order = new Orders();
        order.setOrderId(orders.getOrderId());
        order.setCreatetime(orders.getCreatetime());
        order.setOrderGoodscount(orders.getOrderGoodscount());
        order.setOrderNote(orders.getOrderNote());
        order.setOrderUserid(orders.getOrderUserid());
        return orderService.updateOrder(order);
    }


}
