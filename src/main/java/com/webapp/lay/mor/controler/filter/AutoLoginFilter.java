package com.webapp.lay.mor.controler.filter;


import com.webapp.lay.mor.entity.User;
import com.webapp.lay.mor.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = {"/*"})
public class AutoLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        Object obj = request.getSession().getAttribute("user");
        if(obj!=null){
            filterChain.doFilter(request,response);
            return;
        }
        String autoLogin = null;
        if (cookies != null) { //如果本地cookie有自动登录信息，则自动登录
            for (Cookie cookie : cookies) {
                if ("autoLogin".equals(cookie.getName())) {
                    autoLogin = cookie.getValue();
                    break;
                }
            }
            if (autoLogin != null) {
                String[] parts = autoLogin.split("-");
                String loginName = parts[0];
                String loginPwd = parts[1];
                UserService service = new UserService();
                User user = service.login(loginName, loginPwd);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    List<User> onlineUsers = (List<User>) request.getServletContext().getAttribute("onlineUsers");
                    if(onlineUsers == null){
                        onlineUsers = new ArrayList<User>();
                    }
                    onlineUsers.add((User) request.getSession().getAttribute("user"));
                    request.getSession().getServletContext().setAttribute("onlineUsers",onlineUsers);

                    Integer onlineCount = (Integer)request.getSession().getServletContext().getAttribute("onlineCount");
                    if(onlineCount==null){
                        onlineCount=0;
                    }
                    onlineCount++;
                    request.getSession().getServletContext().setAttribute("onlineCount",onlineCount);
                    response.sendRedirect("main");
                }
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
