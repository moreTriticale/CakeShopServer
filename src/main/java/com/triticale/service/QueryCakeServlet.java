package com.triticale.service;

import com.google.gson.Gson;
import com.triticale.dao.QueryCake;
import com.triticale.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet("/QueryCake")
public class QueryCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cake> list = QueryCake.queryCake();
        Gson gson = new Gson();
        String js = gson.toJson(list);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
        bw.write(js);
        bw.flush();
        bw.close();
    }
}