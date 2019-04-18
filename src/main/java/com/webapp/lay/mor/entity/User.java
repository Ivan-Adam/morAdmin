package com.webapp.lay.mor.entity;

import java.awt.*;
import java.util.Date;

public class User {
    private String loginName;
    private String loginPwd;
    private String userName;
    private Image userFace;
    private String sex;
    private Date bitthday;

    public User() {
    }

    public User(String loginName, String loginPwd, String userName, Image userFace, String sex, Date birthday) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.userName = userName;
        this.userFace = userFace;
        this.sex = sex;
        this.bitthday = birthday;
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
        return bitthday;
    }

    public void setBirthday(Date bitthday) {
        this.bitthday = bitthday;
    }
}
