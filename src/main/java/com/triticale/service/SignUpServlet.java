package com.triticale.service;

import com.triticale.Constants;
import com.triticale.dao.SignUp;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
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
        System.out.println("注册的账号:" + userData[0] + ";密码:" + userData[1]);
        //调用signUp()方法
        int status = SignUp.signUp(userData[0], userData[1]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
        System.out.println("注册的返回值:" + status);
        if (status == Constants.HAVING_USER_NAME){
            bw.write("用户名已存在");
            bw.close();
        }else {
            bw.write("注册成功");
            bw.close();
        }
    }
}