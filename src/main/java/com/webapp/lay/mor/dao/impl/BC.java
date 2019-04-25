package com.webapp.lay.mor.dao.impl;

import com.webapp.lay.mor.dao.IBC;
import java.sql.*;

public class BC implements IBC {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql=null;
    @Override
    public void loadDiver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.println("无法找到驱动类");
        }
    }

    @Override
    public void setConn() {
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/*****?useUnicode=true&characterEncoding=UTF-8","******","******");
            System.out.println("数据库已连接");
        }catch(SQLException e) {
            System.out.println("数据库连接失败");
        }
    }

    @Override
    public void close() {
        try {
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
            System.out.println("数据库连接已关闭!");
        }catch(SQLException e) {
            System.out.println("数据库连接无法正常关闭");
        }
    }
}
