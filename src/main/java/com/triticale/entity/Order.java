package com.triticale.entity;

import java.io.Serializable;

public class Order implements Serializable {
    //感觉可以用表连接，代码质量好低呜呜呜
    int id;
    String cakeId;
    String Uid;
    String productDesc;
    String price;
    String detail;
    int count;
    String name;
    int status;
    String createTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cakeId='" + cakeId + '\'' +
                ", Uid='" + Uid + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", price='" + price + '\'' +
                ", detail='" + detail + '\'' +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCakeId() {
        return cakeId;
    }

    public void setCakeId(String cakeId) {
        this.cakeId = cakeId;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
