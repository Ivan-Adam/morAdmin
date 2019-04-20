package com.webapp.lay.mor.servlets;

import com.webapp.lay.mor.entity.User;
import com.webapp.lay.mor.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Object obj = request.getSession().getAttribute("loginUser");
        boolean flag = false;
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("loginInfo".equals(cookie.getName())){
                    flag = true;
                    UserService service = new UserService();
                    User user = service.autoLogin(cookie.getValue());
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                        String onlineUsers = (String) request.getServletContext().getAttribute("onlineUsers");
                        onlineUsers = onlineUsers+","+cookie.getValue();
                        Integer onlineCount = (Integer)request.getServletContext().getAttribute("onlineCount");
                        if(onlineCount==null){
                            onlineCount=0;
                        }
                        onlineCount++;
                        request.getServletContext().setAttribute("onlineCount",onlineCount);
                        request.getServletContext().setAttribute("onlineUsers",onlineUsers);
                        response.sendRedirect("main");
                    }else {
                        response.sendRedirect("login.jsp");
                    }
                    return;
                }
            }
        }
        if(obj!=null){
            flag = true;
            response.sendRedirect("main");
        }
        if(!flag){
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //从login.html提交的表单取
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        String captche = request.getParameter("captche").toLowerCase();
        String remember = request.getParameter("remember");

        //用Session读取验证码
        String saveCode = "";
        saveCode = (String) request.getSession().getAttribute("code");

        String onlineUsers = (String) request.getServletContext().getAttribute("onlineUsers");
        if(onlineUsers!=null){
            if(onlineUsers.indexOf(loginName)>=0){
                //用户已在别处登录
                response.sendRedirect("login.jsp");
                return;
            }
        }

        if (saveCode.equals(captche)) {
            UserService service = new UserService();
            User user;
            user = service.login(loginName,loginPwd);
            if(user!=null){
                if("1".equals(remember)){
                    Cookie cookie = new Cookie("loginInfo",user.getLoginName());
                    cookie.setMaxAge(7*24*3600);
                    response.addCookie(cookie);
                }
                request.getSession().setAttribute("user",user);
                onlineUsers = onlineUsers+","+loginName;
                Integer onlineCount = (Integer)request.getServletContext().getAttribute("onlineCount");
                if(onlineCount==null){
                    onlineCount=0;
                }
                onlineCount++;
                request.getServletContext().setAttribute("onlineCount",onlineCount);
                request.getServletContext().setAttribute("onlineUsers",onlineUsers);
                response.sendRedirect("main");
            }else {
                response.sendRedirect("login.jsp");
            }
        } else {
            //提示验证码错误
            response.sendRedirect("login.jsp");
        }
    }
}