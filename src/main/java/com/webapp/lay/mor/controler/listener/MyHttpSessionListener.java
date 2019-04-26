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

    private int visitorNumber = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        visitorNumber++;
        httpSessionEvent.getSession().getServletContext().setAttribute("visitorNumber",visitorNumber);
        System.out.println("sessionCreated:"+httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        visitorNumber--;
        httpSessionEvent.getSession().getServletContext().setAttribute("visitorNumber",visitorNumber);

        ArrayList<Visitor> visitorList=null;
        visitorList=(ArrayList<Visitor>)httpSessionEvent.getSession().getServletContext().getAttribute("visitorList") ;
        if(SessionUtil.getVisitorBySessionId(visitorList,httpSessionEvent.getSession().getId())!=null){
            visitorList.remove(SessionUtil.getVisitorBySessionId(visitorList,httpSessionEvent.getSession().getId()));
        }

        User delUser=(User) httpSessionEvent.getSession().getAttribute("user");
        List<User> onlineUsers = (List<User>)httpSessionEvent.getSession().getServletContext().getAttribute("onlineUsers");
        if(onlineUsers!=null){
            for(User user:onlineUsers){
                if(user.getLoginName().equals(delUser.getLoginName())) {
                    onlineUsers.remove(user);
                    break;
                }
            }
        }
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineUsers",onlineUsers);

        Integer onlineCount = (Integer)httpSessionEvent.getSession().getServletContext().getAttribute("onlineCount");
        if(onlineCount!=null)
        {
            onlineCount--;
        }
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineCount",onlineCount);
        System.out.println("sessionDestroyed:"+httpSessionEvent.getSession().getId());
    }
}
