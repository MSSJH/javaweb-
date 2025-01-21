package com.xxxx.controller;

import com.xxxx.entity.vo.MessageModel;
import com.xxxx.service.UserService;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uname = request.getParameter("uname2");
        String upwd = request.getParameter("upwd2");


        MessageModel messageModel = userService.logoutUser(uname, upwd);
        if (messageModel.getCode() == 1) {
            request.getSession().setAttribute("user", messageModel.getObject());
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script> alert('用户注销成功'); location='login.jsp'</script>");
            // response.sendRedirect("login.jsp");
        } else {
            //失败
            //将消息模型中的用户信息设置到session作用域中，重定向跳转到index.jsp
            request.setAttribute("messageModel", messageModel);
            request.getRequestDispatcher("logout.jsp").forward(request, response);
        }
    }
}
