package com.unicom.springboot.controller;

import com.unicom.springboot.entity.Orderdetail;
import com.unicom.springboot.service.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName：OrderdetailController
 * @Author：kuangzy
 * @Time：2019/5/9 23:05
 * @Discription:discription
 */
@RestController
public class OrderdetailController {
    @Autowired
    OrderdetailService orderdetailService;
    @RequestMapping(value = "/addorderdetail",method = RequestMethod.POST)
    public int addOrderdetail(@RequestBody Orderdetail orderdetail){
        Orderdetail orderdetails = new Orderdetail();
        orderdetails.setDetailItemid(orderdetail.getDetailItemid());
        orderdetails.setDetailItemnum(orderdetail.getDetailItemnum());
        orderdetails.setDetailOrderid(orderdetail.getDetailOrderid());
        return orderdetailService.addOrderDetail(orderdetails);
    }
    @RequestMapping("/delorderdetail/{orderId}")
    public int delOrderdetail(@PathVariable int orderId){
        return orderdetailService.delOrderDetail(orderId);
    }
    @RequestMapping("/findorderdetail/{orderId}")
    public List<Orderdetail> findOrderdetail(@PathVariable int orderId ){
        return orderdetailService.findOrderdetail(orderId);
    }
    @RequestMapping(value = "/updateorderdetail",method = RequestMethod.POST)
    public int updateOrderdetail(@RequestBody Orderdetail orderdetail){
        Orderdetail orderdetails = new Orderdetail();
        orderdetails.setDetailId(orderdetail.getDetailId());
        orderdetails.setDetailItemid(orderdetail.getDetailItemid());
        orderdetails.setDetailItemnum(orderdetail.getDetailItemnum());
        orderdetails.setDetailOrderid(orderdetail.getDetailOrderid());
        return orderdetailService.addOrderDetail(orderdetails);
    }
}
