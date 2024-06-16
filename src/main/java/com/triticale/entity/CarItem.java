package com.triticale.entity;


import java.io.Serializable;

public class CarItem implements Serializable {
    private String cakeId;
    private String uid;
    private String productDesc;
    private String Price;
    private String detail;
    private int count;
    private String name;
    private int status;

    @Override
    public String toString() {
        return "CarItem{" +
                "cakeId='" + cakeId + '\'' +
                ", uid='" + uid + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", Price='" + Price + '\'' +
                ", detail='" + detail + '\'' +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CarItem(){

    }

    public CarItem(String cakeId, String uid, String productDesc, String price, String detail, int count, String name,int status) {
        this.cakeId = cakeId;
        this.uid = uid;
        this.productDesc = productDesc;
        Price = price;
        this.detail = detail;
        this.count = count;
        this.name = name;
        this.status = status;
    }

    public String getCakeId() {
        return cakeId;
    }

    public void setCakeId(String cakeId) {
        this.cakeId = cakeId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
