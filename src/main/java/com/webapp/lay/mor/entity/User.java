package com.webapp.lay.mor.entity;

import java.awt.*;
import java.sql.Blob;
import java.util.Date;

public class User {
    private String loginName;
    private String loginPwd;
    private String userName;
    private Image userFace;
    private String sex;
    private Date birthday;
    private String phone;
    private String mail;
    private Blob face;

    public Blob getFace() {
        return face;
    }

    public void setFace(Blob face) {
        this.face = face;
    }

    public User() {
    }

    public User(String loginName, String loginPwd, String userName, Image userFace, String sex, Date birthday,String phone,String mail) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.userName = userName;
        this.userFace = userFace;
        this.sex = sex;
        this.birthday = birthday;
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

    public Image getUserFace() {
        return userFace;
    }

    public void setUserFace(Image userFace) {
        this.userFace = userFace;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date bitthday) {
        this.birthday = bitthday;
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
}
