package com.triticale.service;

import com.triticale.dao.QueryCar;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet("/QueryCar")
public class QueryCarServlet extends HttpServlet {
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
        ServletInputStream is = request.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
        String reqInfo = br.readLine();
        String[] data = reqInfo.split(";"); //data[0]为蛋糕id，data[1]为用户名
        boolean isHavingThisCake = QueryCar.queryCar(Integer.parseInt(data[0]),data[1]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
        System.out.println("isHavingThisCake为" + isHavingThisCake);
        if (isHavingThisCake == true){
            bw.write("该蛋糕已存在于购物车");
        }else {
            bw.write("该蛋糕不存在于购物车");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}