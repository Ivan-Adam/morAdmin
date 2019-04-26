package com.webapp.lay.mor.service;

import com.webapp.lay.mor.dao.IUserDao;
import com.webapp.lay.mor.dao.impl.UserDao;
import com.webapp.lay.mor.entity.User;

import java.util.List;

public class UserService {
    private IUserDao userDao = new UserDao();
    public User login(String loginName, String loginPwd){
        User user = userDao.findByLoginName(loginName);
        if(user==null){
            return user;
        }
        if(user!=null){
            if(!user.getLoginPwd().equals(loginPwd)){
                user = null;
            }
        }
        return user;
    }

    public List<User> findAll(){
        return userDao.find(null);
    }

    public boolean addUser(User user){return userDao.add(user);}
    public boolean upFace(String loginName,String fileName){return userDao.upFace(loginName,fileName);}
}
