package com.triticale.dao;

import com.triticale.Constants;

import java.sql.*;

public class EditFormation {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int editFormation(String uid, String newPassword){
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "yaojinlun");

            if (newPassword != null){
                String sqlOfPassword = "update user set pwd = ? where uid = ?;";
                PreparedStatement psOfPassword = conn.prepareStatement(sqlOfPassword);
                psOfPassword.setString(1,newPassword);
                psOfPassword.setString(2,uid);
                psOfPassword.executeUpdate();
                return Constants.SUCCESS_UPDATE_PASSWORD;
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
        return 0;
    }
}
