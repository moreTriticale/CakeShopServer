package com.triticale.dao;

import java.sql.*;

public class InsertIntoOrder {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertIntoOrder(String cakeId, String uid, String ProductDesc, String price, String detail, int count, String name, int status, String createTime){
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "yaojinlun");
            String sql = "insert into order_tb(cake_id,uid,product_desc,price,detail,count,name,status,create_time) values(?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cakeId);
            ps.setString(2,uid);
            ps.setString(3,ProductDesc);
            ps.setString(4,price);
            ps.setString(5,detail);
            ps.setInt(6,count);
            ps.setString(7,name);
            ps.setInt(8,status);
            ps.setString(9,createTime);
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
