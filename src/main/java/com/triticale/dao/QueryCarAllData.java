package com.triticale.dao;

import com.triticale.entity.Cake;
import com.triticale.entity.CarItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryCarAllData {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List queryCarAllData(String username){
        Connection conn = null;
        ResultSet rs = null;
        List<CarItem> carItems = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "yaojinlun");
            String sql = "select * from shopping_car where uid = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()){
                CarItem carItem = new CarItem();
                String cakeId = rs.getString("cake_id");
                String uid = rs.getString("uid");
                String productDesc = rs.getString("product_desc");
                String price = rs.getString("price");
                String detail = rs.getString("detail");
                int anInt = rs.getInt("count");
                String name = rs.getString("name");
                int status = rs.getInt("status");
                carItem.setCakeId(cakeId);
                carItem.setUid(uid);
                carItem.setProductDesc(productDesc);
                carItem.setPrice(price);
                carItem.setDetail(detail);
                carItem.setCount(anInt);
                carItem.setName(name);
                carItem.setStatus(status);
                carItems.add(carItem);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return  carItems;
    }
}
