package com.webapp.lay.mor.controler.user;

import com.webapp.lay.mor.entity.User;
import com.webapp.lay.mor.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/onlineList")
public class OnlineListControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = request.getSession().getAttribute("user");
        UserService service = new UserService();
        if(obj!=null){
            request.getRequestDispatcher("../WEB-INF/views/user/onlineList.jsp").forward(request,response);
            return;
        }else {
            response.sendRedirect("../main");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
