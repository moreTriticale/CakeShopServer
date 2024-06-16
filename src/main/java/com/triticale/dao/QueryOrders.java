package com.triticale.dao;


import com.triticale.entity.Cake;
import com.triticale.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryOrders {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Order> queryOrders(String username){
        Connection conn = null;
        ResultSet rs = null;
        List<Order> orders = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "yaojinlun");
            String sql = "select * from order_tb where uid = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()){
                Order order = new Order();
                int id = rs.getInt("id");
                String cakeId = rs.getString("cake_id");
                String uid = rs.getString("uid");
                String productDesc = rs.getString("product_desc");
                String price = rs.getString("price");
                String detail = rs.getString("detail");
                int count = rs.getInt("count");
                String name = rs.getString("name");
                int status = rs.getInt("status");
                String createTime = rs.getString("create_time");
                order.setId(id);
                order.setCakeId(cakeId);
                order.setUid(uid);
                order.setProductDesc(productDesc);
                order.setPrice(price);
                order.setDetail(detail);
                order.setCount(count);
                order.setName(name);
                order.setStatus(status);
                order.setCreateTime(createTime);
                orders.add(order);
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
        return orders;
    }
}
