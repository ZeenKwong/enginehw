package com.unicom.springboot.entity;

public class Orderdetail {
    private Integer detailId;

    private Integer detailOrderid;

    private Integer detailItemid;

    private String detailItemnum;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getDetailOrderid() {
        return detailOrderid;
    }

    public void setDetailOrderid(Integer detailOrderid) {
        this.detailOrderid = detailOrderid;
    }

    public Integer getDetailItemid() {
        return detailItemid;
    }

    public void setDetailItemid(Integer detailItemid) {
        this.detailItemid = detailItemid;
    }

    public String getDetailItemnum() {
        return detailItemnum;
    }

    public void setDetailItemnum(String detailItemnum) {
        this.detailItemnum = detailItemnum == null ? null : detailItemnum.trim();
    }
}