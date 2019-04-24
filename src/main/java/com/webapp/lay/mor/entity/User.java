package com.webapp.lay.mor.entity;



import java.util.Date;

public class User {
    private String loginName;
    private String loginPwd;
    private String userName;
    private String userFace;
    private String sex;
    private Date joinTime;
    private String phone;
    private String mail;
    private String prim;
    private String onUse;

    public User() {
    }

    public User(String loginName, String loginPwd, String userName, String userFace, String sex, Date joinTime, String phone, String mail, String prim, String onUse) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.userName = userName;
        this.userFace = userFace;
        this.sex = sex;
        this.joinTime = joinTime;
        this.phone = phone;
        this.mail = mail;
        this.prim = prim;
        this.onUse = onUse;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
    }

    public String getOnUse() {
        return onUse;
    }

    public void setOnUse(String onUse) {
        this.onUse = onUse;
    }
}
