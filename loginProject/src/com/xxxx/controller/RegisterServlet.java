package com.xxxx.controller;

import com.xxxx.entity.vo.MessageModel;
import com.xxxx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uname1 = request.getParameter("uname1");
        String upwd1 = request.getParameter("upwd1");
        String upwd2 = request.getParameter("upwd2");

        MessageModel messageModel = userService.userregister(uname1, upwd1, upwd2);
        if (messageModel.getCode() == 1) {

            request.getSession().setAttribute("user", messageModel.getObject());
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script> alert('用户注册成功，请登录'); location='login.jsp'</script>");

           // response.sendRedirect("login.jsp");
        } else {
            //失败
            //将消息模型中的用户信息设置到session作用域中，重定向跳转到index.jsp
            request.setAttribute("messageModel", messageModel);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
