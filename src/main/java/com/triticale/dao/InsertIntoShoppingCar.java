package com.triticale.dao;

import com.triticale.entity.CarItem;

import java.sql.*;

public class InsertIntoShoppingCar {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertIntoShoppingCar(CarItem carItem){
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "yaojinlun");
            String sql = "insert into shopping_car values(?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,carItem.getCakeId());
            ps.setString(2,carItem.getUid());
            ps.setString(3,carItem.getProductDesc());
            ps.setString(4, carItem.getPrice());
            ps.setString(5, carItem.getDetail());
            ps.setInt(6,carItem.getCount());
            ps.setString(7, carItem.getName());
            ps.setInt(8,carItem.getStatus());
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
