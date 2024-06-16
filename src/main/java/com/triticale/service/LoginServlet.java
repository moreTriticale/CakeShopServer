package com.triticale.service;

import com.triticale.Constants;
import com.triticale.dao.LoginVerify;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
        String[] userData = reqInfo.split(";");
        int status = LoginVerify.loginVerify(userData[0], userData[1]);
        System.out.println(userData[0]+ ";" + userData[1]);
        System.out.println(status);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));

        if (status == Constants.SUCCESS_LOGIN){
            bw.write("登录成功");
        }else {
            bw.write("用户名不存在或密码错误");
        }
        bw.flush();
        bw.close();
    }
}