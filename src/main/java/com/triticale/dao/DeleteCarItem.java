package com.triticale.dao;

import java.sql.*;

public class DeleteCarItem {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteCarItem(String cakeId, String uid){
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake", "root", "yaojinlun");
            String sql = "delete from shopping_car where cake_id = ? and uid = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,cakeId);
            ps.setString(2,uid);
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
