<%--
  Created by IntelliJ IDEA.
  User: 豆子
  Date: 2019/4/26
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="basePath" scope="page"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${basePath}/layui-v2.4.5/layui/css/layui.css">
</head>
<body>
头像：<img src="${basePath}/static/${sessionScope.user.userFace}" class="layui-nav-img"> <br>
登录名：${sessionScope.user.loginName}<br>
用户名：${sessionScope.user.userName}<br>
性别：
<c:choose>
    <c:when test="${sessionScope.user.sex == '1'}">男</c:when>
    <c:when test="${sessionScope.user.sex == '2'}">女</c:when>
    <c:otherwise>未知</c:otherwise>
</c:choose><br>
手机：${sessionScope.user.phone}<br>
邮箱：${sessionScope.user.mail}<br>
加入时间：${sessionScope.user.joinTime}<br>
用户权限：
<c:choose>
    <c:when test="${sessionScope.user.prim == '1'}">超级管理员</c:when>
    <c:when test="${sessionScope.user.prim == '2'}">管理员</c:when>
    <c:otherwise>未知</c:otherwise>
</c:choose><br>
账号状态：
<c:choose>
    <c:when test="${sessionScope.user.onUse == '1'}">可用</c:when>
    <c:when test="${sessionScope.user.onUse == '0'}">封锁</c:when>
    <c:otherwise>未知</c:otherwise>
</c:choose><br>
</body>
</html>
