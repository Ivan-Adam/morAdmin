package com.webapp.lay.mor.controler;

import com.webapp.lay.mor.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先删除session
        User user=(User)request.getSession().getAttribute("user");
        List<User> onlineUsers = (List<User>)request.getSession().getServletContext().getAttribute("onlineUsers");
        onlineUsers.remove(request.getSession().getAttribute("user"));
        request.getSession().getServletContext().setAttribute("onlineUsers",onlineUsers);
        request.getSession().removeAttribute("user");
        //再删除cookie
        Cookie cookie = new Cookie("autoLogin","msg");
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect("main");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
