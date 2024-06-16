package com.triticale.service;

import com.google.gson.Gson;
import com.triticale.dao.QueryCake;
import com.triticale.dao.QueryCarAllData;
import com.triticale.entity.Cake;
import com.triticale.entity.CarItem;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.List;

@WebServlet("/QueryCarAllData")
public class QueryCarAllDataServlet extends HttpServlet {
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
        List<CarItem> list = QueryCarAllData.queryCarAllData(reqInfo);
        System.out.println("请求所有购物车内容的id为" + reqInfo);

        Gson gson = new Gson();
        String js = gson.toJson(list);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
        bw.write(js);
        bw.flush();
        bw.close();
    }
}