package com.webapp.lay.mor.controler;

import com.webapp.lay.mor.entity.User;
import com.webapp.lay.mor.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("user");
        boolean flag = false;
        if(obj!=null){
            flag = true;
            request.getRequestDispatcher("./WEB-INF/views/welcome.jsp").forward(request,response);
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
                        request.getRequestDispatcher("./WEB-INF/views/welcome.jsp").forward(request,response);
                    }else {
                        //提示找不到用户
                        response.sendRedirect("login");
                        return;
                    }
                    return;
                }
            }
        }
        if(!flag){
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
