package com.webapp.lay.mor.controler;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("user");
        if(obj!=null){
            response.sendRedirect("main");
            return;
        }else {
            request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从login.html提交的表单取
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        String captche = request.getParameter("captche").toLowerCase();
        String remember = request.getParameter("remember");

        //用Session读取验证码
        String saveCode = (String) request.getSession().getAttribute("code");
        if(saveCode==null){
            saveCode = "";
        }

        List<User> onlineUsers = (List<User>) request.getServletContext().getAttribute("onlineUsers");
        if(onlineUsers!=null){
            for(User user : onlineUsers){
                if(user.getLoginName().equals(loginName)){
                    request.setAttribute("errerMsg","用户已在别处登录");
                    request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
                    return;
                }
            }
        }

        if (saveCode.equals(captche)) {
            UserService service = new UserService();
            User user;
            user = service.login(loginName,loginPwd);
            if(user!=null){
                if("1".equals(remember)){
                    String autoLogin = loginName + "-" +loginPwd;
                    Cookie cookie = new Cookie("autoLogin",autoLogin);
                    cookie.setMaxAge(7*24*3600);
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }
                request.getSession().setAttribute("user",user);
                if(onlineUsers == null){
                    onlineUsers = new ArrayList<User>();
                }
                onlineUsers.add(user);
                request.getSession().getServletContext().setAttribute("onlineUsers",onlineUsers);

                Integer onlineCount = (Integer)request.getSession().getServletContext().getAttribute("onlineCount");
                if(onlineCount==null){
                    onlineCount=0;
                }
                onlineCount++;
                request.getSession().getServletContext().setAttribute("onlineCount",onlineCount);
                response.sendRedirect("/main");
            }else {
                request.setAttribute("errerMsg","用户名或密码错误");
                request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
            }
        } else {
            //提示验证码错误
            request.setAttribute("errerMsg","验证码错误");
            request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
        }
    }
}