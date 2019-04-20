package com.webapp.lay.mor.dao.impl;


import com.webapp.lay.mor.dao.IUserDao;
import com.webapp.lay.mor.entity.User;

import java.io.*;
import java.sql.Blob;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public List<User> find(User user) {
        return null;
    }

    @Override
    public User findByLoginName(String loginName) {
        BC BC=new BC();
        BC.loadDiver();
        BC.setConn();
        User user = new User();
        try {
            BC.sql="select *from user where loginName=?";
            BC.pstmt=BC.conn.prepareStatement(BC.sql);
            BC.pstmt.setString(1, loginName);
            BC.rs=BC.pstmt.executeQuery();
            if(BC.rs.next()){
                user.setLoginName(BC.rs.getString("loginName"));
                user.setLoginPwd(BC.rs.getString("loginPwd"));
                user.setUserName(BC.rs.getString("userName"));
                user.setSex(BC.rs.getString("sex"));
                user.setBirthday(BC.rs.getDate("birthday"));
                user.setPhone(BC.rs.getString("phone"));
                user.setMail(BC.rs.getString("mail"));

                user.setFace(BC.rs.getBlob("userFace"));

            }else {
                user = null;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        BC.close();
        return user;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findWithPage(User user, int page, int pageSize) {
        return null;
    }
}
