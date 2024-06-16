package com.triticale.dao;

import java.sql.*;

public class QueryCar {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean queryCar(int id, String uid){
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "yaojinlun");
            String sqlOfQuery = "select * from shopping_car where cake_id = ? and uid = ?;";
            PreparedStatement ps = conn.prepareStatement(sqlOfQuery);
            ps.setString(1,id + "");
            ps.setString(2,uid);
            rs = ps.executeQuery();
            String name = null;
            while (rs.next()){
                name = rs.getString("name");
            }
            if (name != null){
                return true;
            }
            if(name == null){
                return  false;
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
        return false;
    }
}
