package com.webapp.lay.mor.entity;

import java.awt.*;
import java.sql.Blob;
import java.util.Date;

public class User {
    private String loginName;
    private String loginPwd;
    private String userName;
    private String userFace;
    private int sex;
    private Date joinTime;
    private String phone;
    private String mail;
    private int prim;

    public User() {
    }

    public User(String loginName, String loginPwd, String userName, String userFace, int sex, Date joinTime, String phone, String mail, int prim) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.userName = userName;
        this.userFace = userFace;
        this.sex = sex;
        this.joinTime = joinTime;
        this.phone = phone;
        this.mail = mail;
        this.prim = prim;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPrim() {
        return prim;
    }

    public void setPrim(int prim) {
        this.prim = prim;
    }
}
