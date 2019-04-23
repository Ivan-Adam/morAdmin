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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("user");
        boolean flag = false;
        if(obj!=null){
            flag = true;
            response.sendRedirect("main");
            return;
        }
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){//如果本地cookie有自动登录信息，并且能在数据库中找到用户，则自动登录
            for(Cookie cookie:cookies){
                if("loginInfo".equals(cookie.getName())){
                    flag = true;
                    UserService service = new UserService();
                    User user = service.autoLogin(cookie.getValue());
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                        String onlineUsers = (String) request.getServletContext().getAttribute("onlineUsers");//有可能为空
                        if(onlineUsers == null){
                            onlineUsers = "";
                        }
                        onlineUsers = onlineUsers+","+cookie.getValue();
                        Integer onlineCount = (Integer)request.getServletContext().getAttribute("onlineCount");//有可能为空
                        if(onlineCount==null){
                            onlineCount=0;
                        }
                        onlineCount++;
                        request.getServletContext().setAttribute("onlineCount",onlineCount);//存到application
                        request.getServletContext().setAttribute("onlineUsers",onlineUsers);//存到application
                        response.sendRedirect("main");
                    }else {
                        //提示找不到用户
                        request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
                        return;
                    }
                    return;
                }
            }
        }
        if(!flag){
            request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
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
                /*
                * 用于弹窗提示
                * 根据本次请求返回的数据
                * 1：别处登录
                * 2：用户名密码错误
                * 3：验证码错误
                 */
                request.setAttribute("loginWrong",'1');
                request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
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
                if(onlineUsers == null){
                    onlineUsers = "";
                }
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
                request.setAttribute("loginWrong",'2');
                request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
            }
        } else {
            //提示验证码错误
            request.setAttribute("loginWrong",'3');
            request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
        }
    }
}