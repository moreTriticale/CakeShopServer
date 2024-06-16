package com.triticale.dao;

import com.triticale.entity.Cake;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryCake {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //查询所有蛋糕
    public static List queryCake(){
        Connection conn = null;
        ResultSet rs = null;
        List<Cake> cakes = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "yaojinlun");
            String sql = "select * from cake_tb;";
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                //每次循环是一个蛋糕对象
                Cake cake = new Cake();
                int id = rs.getInt("id");
                String image = rs.getString("image");
                String productDesc = rs.getString("product_desc");
                String price = rs.getString("price");
                String detail = rs.getString("detail");
                int count = rs.getInt("product_count");
                String name = rs.getString("name");
                cake.setId(id);
                cake.setImg(image);
                cake.setDetail(detail);
                cake.setDesc(productDesc);
                cake.setPrice(price);
                cake.setCount(count);
                cake.setName(name);
                cakes.add(cake);
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
        return cakes;
    }
}
