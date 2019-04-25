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
        BC BC = new BC();
        BC.loadDiver();
        BC.setConn();
        try {
            BC.sql = "insert into user (loginName,loginPwd,userName,sex,joinTime,phone,mail,prim,onUse,userFace) values(?,?,?,?,?,?,?,?,?,?)";
            BC.pstmt = BC.conn.prepareStatement(BC.sql);
            BC.pstmt.setString(1, user.getLoginName());
            BC.pstmt.setString(2, user.getLoginPwd());
            BC.pstmt.setString(3, user.getUserName());
            BC.pstmt.setString(4, user.getSex());
            BC.pstmt.setDate(5, new java.sql.Date(user.getJoinTime().getTime()));
            BC.pstmt.setString(6, user.getPhone());
            BC.pstmt.setString(7, user.getMail());
            BC.pstmt.setString(8, user.getPrim());
            BC.pstmt.setString(9, user.getOnUse());
            BC.pstmt.setString(10, user.getUserFace());
            BC.pstmt.executeUpdate();
            BC.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            BC.close();
            return false;
        }
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
        BC BC = new BC();
        BC.loadDiver();
        BC.setConn();
        List<User> list = new ArrayList<User>();
        try {
            BC.sql = "select *from user";
            BC.pstmt = BC.conn.prepareStatement(BC.sql);
            BC.rs = BC.pstmt.executeQuery();
            while (BC.rs.next()) {
                User user1 = new User();
                user1.setLoginName(BC.rs.getString("loginName"));
                user.setLoginPwd(BC.rs.getString("loginPwd"));
                user1.setUserName(BC.rs.getString("userName"));
                user1.setSex(BC.rs.getString("sex"));
                user1.setJoinTime(BC.rs.getDate("joinTime"));
                user1.setPhone(BC.rs.getString("phone"));
                user1.setMail(BC.rs.getString("mail"));
                user1.setPrim(BC.rs.getString("prim"));
                user1.setOnUse(BC.rs.getString("onUse"));
                user1.setUserFace(BC.rs.getString("userFace"));
                list.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BC.close();
        return list;
    }

    @Override
    public User findByLoginName(String loginName) {
        BC BC = new BC();
        BC.loadDiver();
        BC.setConn();
        User user = new User();
        try {
            BC.sql = "select *from user where loginName=?";
            BC.pstmt = BC.conn.prepareStatement(BC.sql);
            BC.pstmt.setString(1, loginName);
            BC.rs = BC.pstmt.executeQuery();
            if (BC.rs.next()) {
                user.setLoginName(BC.rs.getString("loginName"));
                user.setLoginPwd(BC.rs.getString("loginPwd"));
                user.setUserName(BC.rs.getString("userName"));
                user.setSex(BC.rs.getString("sex"));
                user.setJoinTime(BC.rs.getDate("joinTime"));
                user.setPhone(BC.rs.getString("phone"));
                user.setMail(BC.rs.getString("mail"));
                user.setPrim(BC.rs.getString("prim"));
                user.setOnUse(BC.rs.getString("onUse"));
                user.setUserFace(BC.rs.getString("userFace"));
            } else {
                user = null;
            }
        } catch (Exception e) {
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

    @Override
    public boolean upFace(String loginName, String fileName) {
        BC BC = new BC();
        BC.loadDiver();
        BC.setConn();
        User user = new User();
        try {
            BC.sql = "update user set userFace=? where loginName=?";
            BC.pstmt = BC.conn.prepareStatement(BC.sql);
            BC.pstmt.setString(1, "userFace/" + fileName);
            BC.pstmt.setString(2, loginName);
            BC.pstmt.executeUpdate();
            BC.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            BC.close();
            return false;
        }
    }
}
