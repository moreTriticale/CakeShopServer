package com.triticale.dao;

import com.triticale.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditName {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int editName(String uid, String name){
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "yaojinlun");

                String sqlOfName = "update user set name = ? where uid = ?;";
                PreparedStatement psOfName = conn.prepareStatement(sqlOfName);
                psOfName.setString(1,name);
                psOfName.setString(2,uid);
                psOfName.executeUpdate();
                return Constants.SUCCESS_UPDATE_NAME;

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
