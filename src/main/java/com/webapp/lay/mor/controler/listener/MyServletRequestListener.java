package com.webapp.lay.mor.controler.listener;

import com.webapp.lay.mor.entity.Visitor;
import com.webapp.lay.mor.util.SessionUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        /*
        * 就是为什么要在requestListener里面进行visitorList的添加呢
        * 如果是session
        * 你打开浏览器，访问，创建一个session，把浏览器关了，session还在
        * 你再打开浏览器，又创建一个session
        * 好像也可以啊
        *
        * 但好像就得不到访问的IP
         */
        ArrayList<Visitor> visitorList  = (ArrayList<Visitor>)servletRequestEvent.getServletContext().getAttribute("visitorList");

        if(visitorList==null)
            visitorList = new ArrayList<Visitor>();

        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String sessionIdString = request.getSession().getId();

        if(SessionUtil.getVisitorBySessionId(visitorList,sessionIdString)==null){//就是说你这个session在列表里面没有visitor
            Visitor visitor = new Visitor();
            visitor.setSessionIdString(sessionIdString);
            visitor.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            visitor.setIpString(request.getRemoteAddr());
            visitorList.add(visitor);
        }
        servletRequestEvent.getServletContext().setAttribute("visitorList", visitorList);
    }
}
