package com.webapp.lay.mor.controler.listener;

import com.webapp.lay.mor.entity.User;
import com.webapp.lay.mor.entity.Visitor;
import com.webapp.lay.mor.util.SessionUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        Integer visitorNumber = (Integer)httpSessionEvent.getSession().getServletContext().getAttribute("visitorNumber");
        if(visitorNumber==null){
            visitorNumber=0;
        }
        visitorNumber++;
        httpSessionEvent.getSession().getServletContext().setAttribute("visitorNumber",visitorNumber);
        System.out.println("sessionCreated:"+httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        Integer visitorNumber = (Integer)httpSessionEvent.getSession().getServletContext().getAttribute("visitorNumber");
        visitorNumber--;
        httpSessionEvent.getSession().getServletContext().setAttribute("visitorNumber",visitorNumber);

        ArrayList<Visitor> visitorList=(ArrayList<Visitor>)httpSessionEvent.getSession().getServletContext().getAttribute("visitorList") ;
        if(SessionUtil.getVisitorBySessionId(visitorList,httpSessionEvent.getSession().getId())!=null){
            visitorList.remove(SessionUtil.getVisitorBySessionId(visitorList,httpSessionEvent.getSession().getId()));
            httpSessionEvent.getSession().getServletContext().setAttribute("visitorList", visitorList);
        }

        User delUser=(User) httpSessionEvent.getSession().getAttribute("user");//有可能是空的
        List<User> onlineUsers = (List<User>)httpSessionEvent.getSession().getServletContext().getAttribute("onlineUsers");//有可能是空的
        Integer onlineCount = (Integer)httpSessionEvent.getSession().getServletContext().getAttribute("onlineCount");
        if(onlineUsers!=null && delUser!=null){
            for(User user:onlineUsers){
                if(user.getLoginName().equals(delUser.getLoginName())) {//NullPointerException
                    /*
                    * 销毁没有绑定User的Session时会报错
                     */
                    onlineUsers.remove(user);
                    onlineCount--;
                    break;
                }
            }
        }
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineUsers",onlineUsers);
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineCount",onlineCount);
        System.out.println("sessionDestroyed:"+httpSessionEvent.getSession().getId());
    }
}
