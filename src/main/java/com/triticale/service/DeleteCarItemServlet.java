package com.triticale.service;

import com.triticale.dao.DeleteCarItem;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/DeleteCarItem")
public class DeleteCarItemServlet extends HttpServlet {
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
        String[] userData = data.split(";");
        System.out.println("删除的蛋糕id" + userData[0] + "删除的用户id" + userData[1]);
        DeleteCarItem.deleteCarItem(userData[0],userData[1]);
    }
}