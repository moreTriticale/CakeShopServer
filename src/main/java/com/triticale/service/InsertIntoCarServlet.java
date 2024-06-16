package com.triticale.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.triticale.dao.InsertIntoShoppingCar;
import com.triticale.entity.CarItem;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet("/InsertIntoCar")
public class InsertIntoCarServlet extends HttpServlet {
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
        String s = br.readLine();
        Gson gson = new Gson();
        Type listType=new TypeToken<CarItem>(){}.getType();
        CarItem carItem = (CarItem)gson.fromJson(s, listType);
        InsertIntoShoppingCar.insertIntoShoppingCar(carItem);
    }
}