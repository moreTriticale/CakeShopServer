package com.triticale.service;

import com.triticale.dao.InsertIntoOrder;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/SaveOrder")
public class SaveOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码
        request.setCharacterEncoding("utf-8");
        // 设置响应编码
        response.setContentType("text/html;charset=utf-8");
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String data = br.readLine();
        //这里偷懒了
        String[] userData = data.split(";");
        /*
        userData[0]是cakeId
        userData[1]是Uid
        userData[2]是count
        userData[3]是detail
        userData[4]是status
        userData[5]是name
        userData[6]是price
        userData[7]是desc
        userData[8]是time
         */
        System.out.println("cakeId:" + userData[0] + " " + "uid:" + userData[1] + " " + "count:" + userData[2]
        + " " + "detail:" + userData[3] + " " + "status:" + userData[4] + " " + "name:" + userData[5] + " "
        + "price:" + userData[6] + " " + "desc:" + userData[7] + " " + "time:" + userData[8]);

        //插入数据库
        InsertIntoOrder.insertIntoOrder(userData[0],userData[1],userData[7],userData[6],userData[3],Integer.parseInt(userData[2]),userData[5],Integer.parseInt(userData[4]),userData[8]);

    }
}