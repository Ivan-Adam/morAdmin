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
public class AddControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("user");
        if(obj!=null){
            request.getRequestDispatcher("../WEB-INF/views/user/add.jsp").forward(request,response);
            return;
        }else {//怎么让他跳出层显示
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
        user.setPhone(request.getParameter("phone").substring(0,10));//还没有手机号检验业务，截取十一位以防数据库错误
        user.setPrim(request.getParameter("prim"));
        user.setOnUse("1");
        UserService service = new UserService();
        if(service.addUser(user)){
            //完了给你提示添加成功，关闭页面，而不是跳转
            request.getRequestDispatcher("../WEB-INF/views/index.jsp").forward(request,response);
        }
    }
}
