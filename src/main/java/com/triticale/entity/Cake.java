package com.triticale.entity;

import java.io.Serializable;

public class Cake  implements Serializable {
    private int id;
    private String img;
    private String desc;
    private String price;
    private String detail;
    private int count;
    private String name;

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", desc='" + desc + '\'' +
                ", price='" + price + '\'' +
                ", detail='" + detail + '\'' +
                ", count=" + count +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}
