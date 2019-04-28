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
        //先看看当前有没有用户，有，下一个
        Object obj = request.getSession().getAttribute("user");
        if(obj!=null){
            filterChain.doFilter(request,response);
            //这个return不能少啊！！！不然的话它会继续执行下去，我吃了这个很大的亏
            return;
        }
        //没有，这就要调用自动登录的业务了
        Cookie[] cookies = request.getCookies();
        String autoLogin = null;
        if (cookies != null) { //如果本地cookie有自动登录信息，则自动登录，否则，那就下一个
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
                    //看下能不能找到用户信息，找不到，下一个
                    List<User> onlineUsers = (List<User>) request.getServletContext().getAttribute("onlineUsers");
                    Integer onlineCount = (Integer)request.getSession().getServletContext().getAttribute("onlineCount");
                    if(onlineUsers == null){
                        onlineUsers = new ArrayList<User>();
                    }
                    /*
                    * 如果再让他登录，他再记住我一下，这就会变成两个cookie
                    * 所以还是让他登录的好
                    * 虽然会变成两处同时登录
                    * 暂时还是留着
                     */
                    for(User user1:onlineUsers){
                        if(user.getLoginName().equals(user1.getLoginName())){
                            request.setAttribute("errerMsg","用户已在别处登录");
                            filterChain.doFilter(request,response);
                            return;
                        }
                    }
                    //如果没有在别处登录，那就可以给他登录
                    request.getSession().setAttribute("user", user);
                    onlineUsers.add(user);
                    if(onlineCount==null){
                        onlineCount=0;
                    }
                    onlineCount++;
                    request.getSession().getServletContext().setAttribute("onlineUsers",onlineUsers);
                    request.getSession().getServletContext().setAttribute("onlineCount",onlineCount);
                }
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
