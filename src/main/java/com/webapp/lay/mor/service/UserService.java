package com.webapp.lay.mor.service;

import com.webapp.lay.mor.dao.IUserDao;
import com.webapp.lay.mor.dao.impl.UserDao;
import com.webapp.lay.mor.entity.User;

import java.util.List;

public class UserService {
    private IUserDao userDao = new UserDao();
    public User login(String loginName, String loginPwd){
        User user = userDao.findByLoginName(loginName);
        if(user!=null){
            if(!user.getLoginPwd().equals(loginPwd)){
                user = null;
            }
        }
        return user;
    }
    public User autoLogin(String loginName){
        return userDao.findByLoginName(loginName);
    }

    public List<User> findAll(){
        return userDao.find(null);
    }
}
