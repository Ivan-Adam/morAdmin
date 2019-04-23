package com.webapp.lay.mor.dao.impl;


import com.webapp.lay.mor.dao.IUserDao;
import com.webapp.lay.mor.entity.User;

import java.io.*;
import java.sql.Blob;
import java.util.ArrayList;
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
        BC BC=new BC();
        BC.loadDiver();
        BC.setConn();
        List<User> list = new ArrayList<User>();
        try {
            BC.sql="select *from user";
            BC.pstmt=BC.conn.prepareStatement(BC.sql);
            BC.rs=BC.pstmt.executeQuery();
            while (BC.rs.next()){
                User user1=new User();
                user1.setLoginName(BC.rs.getString("loginName"));
                user1.setLoginPwd(BC.rs.getString("loginPwd"));
                user1.setUserName(BC.rs.getString("userName"));
                user1.setSex(BC.rs.getInt("sex"));
                user1.setJoinTime(BC.rs.getDate("joinTime"));
                user1.setPhone(BC.rs.getString("phone"));
                user1.setMail(BC.rs.getString("mail"));
                user1.setPrim(BC.rs.getInt("prim"));
                user1.setUserFace(BC.rs.getString("userFace"));
                list.add(user1);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        BC.close();
        return list;
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
                user.setSex(BC.rs.getInt("sex"));
                user.setJoinTime(BC.rs.getDate("joinTime"));
                user.setPhone(BC.rs.getString("phone"));
                user.setMail(BC.rs.getString("mail"));
                user.setPrim(BC.rs.getInt("prim"));
                user.setUserFace(BC.rs.getString("userFace"));
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
