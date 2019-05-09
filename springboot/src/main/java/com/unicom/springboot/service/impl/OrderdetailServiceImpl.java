package com.unicom.springboot.service.impl;

import com.unicom.springboot.entity.Orderdetail;
import com.unicom.springboot.entity.OrderdetailExample;
import com.unicom.springboot.mapper.OrderdetailMapper;
import com.unicom.springboot.service.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName：OrderdetailServiceImpl
 * @Author：kuangzy
 * @Time：2019/5/9 22:25
 * @Discription:discription
 */
@Service
public class OrderdetailServiceImpl implements OrderdetailService {
    @Autowired
    OrderdetailMapper orderdetailMapper;
    @Override
    public int addOrderDetail(Orderdetail orderdetail) {
        return orderdetailMapper.insert(orderdetail);
    }

    @Override
    public int delOrderDetail(int orderId) {
        return orderdetailMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public List<Orderdetail> findOrderdetail(int orderId) {
        OrderdetailExample orderdetailExample = new OrderdetailExample();
        if (orderId != 0){
            OrderdetailExample.Criteria criteria = orderdetailExample.createCriteria();
            criteria.andDetailOrderidEqualTo(orderId);
        }
        List<Orderdetail> orderdetails = orderdetailMapper.selectByExample(orderdetailExample);
        return orderdetails;
    }

    @Override
    public int updateOrderdetail(Orderdetail orderdetail) {
        return orderdetailMapper.updateByPrimaryKeySelective(orderdetail);
    }
}
