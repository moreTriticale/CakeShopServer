package com.triticale.dao;

import com.triticale.Constants;

import java.sql.*;

public class LoginVerify {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询user表，登录验证
    public static int loginVerify(String name, String pwd){
        Connection conn = null;
        ResultSet rs = null;
        try {
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "yaojinlun");
             String sql = "select * from user where uid = ?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,name);
             rs = ps.executeQuery();
             String uid = null;
             String password = null;
             while (rs.next()){
                 uid = rs.getString("uid");
                 password = rs.getString("pwd");
             }
             if(password.equals(pwd)){
                 return Constants.SUCCESS_LOGIN; //用户名存在且密码正确
             }
             else{
                 return Constants.ERROR_PASSWORD;//用户名不存在或密码错误
             }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
}
