package com.triticale.service;

import com.triticale.Constants;
import com.triticale.dao.EditName;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet("/EditName")
public class EditNameServlet extends HttpServlet {
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
        System.out.println("修改个人信息servlet");
        System.out.println(data);
        String[] userData = data.split(";");
        System.out.println("uid:" + userData[0] + ";" + "名称" + userData[1]);
        int status = EditName.editName(userData[0], userData[1]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
        if (status == Constants.SUCCESS_UPDATE_NAME){
            bw.write("更新名称成功");
            bw.flush();
            bw.close();
        }
    }
}