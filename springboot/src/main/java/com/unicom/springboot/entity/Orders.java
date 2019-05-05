package com.unicom.springboot.entity;

import java.util.Date;

public class Orders {
    private Integer orderId;

    private Integer orderUserid;

    private String orderGoodscount;

    private Date createtime;

    private String orderNote;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
    }

    public String getOrderGoodscount() {
        return orderGoodscount;
    }

    public void setOrderGoodscount(String orderGoodscount) {
        this.orderGoodscount = orderGoodscount == null ? null : orderGoodscount.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote == null ? null : orderNote.trim();
    }
}