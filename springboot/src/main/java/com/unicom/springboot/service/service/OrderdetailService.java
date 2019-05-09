package com.unicom.springboot.service.service;

import com.unicom.springboot.entity.Orderdetail;

import java.util.List;

/**
 * @ClassName：OrderdetailService
 * @Author：kuangzy
 * @Time：2019/5/9 22:05
 * @Discription:discription
 */
public interface OrderdetailService {
    //增
    int addOrderDetail(Orderdetail orderdetail);
    //删
    int delOrderDetail(int orderId);
    //查
    List<Orderdetail> findOrderdetail(int orderId);
    //改
    int updateOrderdetail(Orderdetail orderdetail);
}
