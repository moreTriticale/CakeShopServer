package com.triticale.dao;

import java.sql.*;

public class QueryNameByUid {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String queryNameByUid(String uid){
        Connection conn = null;
        ResultSet rs = null;
        String name = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "yaojinlun");
            String sql = "select * from user where uid = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,uid);
            rs = ps.executeQuery();
            while (rs.next()){
                name = rs.getString("name");
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
        return name;
    }
}
