package com.triticale.dao;

import com.triticale.Constants;

import java.sql.*;

public class SignUp {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int signUp(String username, String password){
        Connection conn = null;
        ResultSet rs = null;
        try {
            //先查询数据库，没有则插入
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "yaojinlun");
            String sql = "select * from user where uid = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            String uid = null;
            while (rs.next()){
                uid = rs.getString("uid");
            }
            System.out.println("注册uid:" + uid);
            //如果有该账号，则返回账号已存在
            if (uid != null){
                return Constants.HAVING_USER_NAME;
            }
            //没有该账号，插入数据库
            if (uid == null){
                String sqlOfInsert = "insert into user(uid,pwd) values(?,?);";
                PreparedStatement psOfInsert = conn.prepareStatement(sqlOfInsert);
                psOfInsert.setString(1,username);
                psOfInsert.setString(2,password);
                psOfInsert.executeUpdate();
                return Constants.SUCCESS_INSERT;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return 0;
    }

}
