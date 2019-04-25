package com.webapp.lay.mor.controler.user;

import com.webapp.lay.mor.entity.User;
import com.webapp.lay.mor.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/user/add")
public class add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("user");
        if(obj!=null){
            request.getRequestDispatcher("../WEB-INF/views/user/add.jsp").forward(request,response);
            return;
        }else {
            response.sendRedirect("../main");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLoginName(request.getParameter("loginName"));
        user.setLoginPwd(request.getParameter("loginPwd"));
        user.setUserName(request.getParameter("userName"));
        user.setUserFace("userFace/001.jpg");
        user.setSex(request.getParameter("sex"));
        user.setJoinTime(new Date());
        user.setMail(request.getParameter("mail"));
        user.setPhone(request.getParameter("phone"));
        user.setPrim(request.getParameter("prim"));
        user.setOnUse("1");
        UserService service = new UserService();
        if(service.addUser(user)){
            request.setAttribute("user",user);
            request.getRequestDispatcher("../WEB-INF/views/index.jsp").forward(request,response);
        }
    }
}
