<%@ page import="com.webapp.lay.mor.service.UserService" %>
<%@ page import="com.webapp.lay.mor.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set value="${pageContext.request.contextPath}" var="basePath" scope="page"/>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>管理员列表 - morAdmin 1.0</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${basePath}/static/css/font.css">
		<link rel="stylesheet" href="${basePath}/static/css/weadmin.css">
        <script src="${basePath}/layui-v2.4.5/layui/layui.js" charset="utf-8"></script>
        <script src="${basePath}/static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>

	<body>
		<div class="weadmin-nav">
			<span class="layui-breadcrumb">
        <a>首页</a>
        <a>管理员管理</a>
        <a>
          <cite>管理员列表</cite></a>
      </span>
			<a class="layui-btn layui-btn-sm" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
				<i class="layui-icon" style="line-height:30px">ဂ</i></a>
		</div>
		<div class="weadmin-body">
			<div class="layui-row">
				<form class="layui-form layui-col-md12 we-search">
					<div class="layui-inline">
						<input class="layui-input" placeholder="开始日" name="start" id="start">
					</div>
					<div class="layui-inline">
						<input class="layui-input" placeholder="截止日" name="end" id="end">
					</div>
					<div class="layui-inline">
						<input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
					</div>
					<button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
				</form>
			</div>
			<div class="weadmin-block">
                <c:choose>
                    <c:when test="${sessionScope.user.prim == '1'}">
                        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                        <button class="layui-btn" onclick="WeAdminShow('添加用户','/user/add')"><i class="layui-icon"></i>添加</button>
                    </c:when>
                    <c:when test="${sessionScope.user.prim == '2'}">
                        <button class="layui-btn layui-btn-danger"  style="background-color: #999999"><i class="layui-icon"></i>批量删除</button>
                        <button class="layui-btn"  style="background-color: #999999"><i class="layui-icon"></i>添加</button>
                    </c:when>
                    <c:otherwise>
                        <button class="layui-btn layui-btn-danger"  style="background-color: #999999"><i class="layui-icon"></i>批量删除</button>
                        <button class="layui-btn"  style="background-color: #999999"><i class="layui-icon"></i>添加</button>
                    </c:otherwise>
                </c:choose>
                <span class="fr" style="line-height:40px">共有数据：${fn:length(users)} 条</span>
			</div>
			<table class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
						</th>
						<th>编号</th>
						<th>头像</th>
						<th>账号</th>
						<th>用户名</th>
                        <th>性别</th>
						<th>手机</th>
						<th>邮箱</th>
						<th>加入时间</th>
						<th>状态</th>
                        <th>权限</th>
						<th>操作</th>
				</thead>
				<c:forEach items="${users}" var="user" varStatus="sta">
					<tbody>
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
						</td>
						<td>${sta.index+1}</td>
						<td><img src="${basePath}/static/${user.userFace}" class="layui-nav-img"></td>
						<td>${user.loginName}</td>
						<td>${user.userName}</td>
						<td>
							<c:choose>
								<c:when test="${user.sex == '1'}">男</c:when>
								<c:when test="${user.sex == '2'}">女</c:when>
								<c:otherwise>未知</c:otherwise>
							</c:choose>
						</td>
						<td>${user.phone}</td>
						<td>${user.mail}</td>
						<td>${user.joinTime}</td>
						<td class="td-status">
							<span class="layui-btn layui-btn-normal layui-btn-xs">已启用</span>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${user.prim == '1'}">超级管理员</c:when>
                                <c:when test="${user.prim == '2'}">管理员</c:when>
                                <c:otherwise>未知</c:otherwise>
                            </c:choose>
                        </td>
						<td class="td-manage">
                            <c:choose>
                                <c:when test="${sessionScope.user.prim == '1'}">
                                    <a onclick="member_stop(this,'10001');" href="javascript:;" title="启用">
                                        <i class="layui-icon">&#xe601;</i>
                                    </a>
                                    <a title="编辑" onclick="WeAdminShow('编辑','./edit.html')" href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                    </a>
                                    <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i>
                                    </a>
                                </c:when>
                                <c:when test="${sessionScope.user.prim == '2'}">
                                    <span class="layui-btn layui-btn-normal layui-btn-xs" style="background-color: #999999">无权限</span>
                                </c:when>
                                <c:otherwise>未知</c:otherwise>
                            </c:choose>
						</td>
					</tr>
					</tbody>
				</c:forEach>
			</table>
			<div class="page">
				<div>
					<a class="prev" href="">&lt;&lt;</a>
					<a class="num" href="">1</a>
					<span class="current">2</span>
					<a class="num" href="">3</a>
					<a class="num" href="">489</a>
					<a class="next" href="">&gt;&gt;</a>
				</div>
			</div>
		</div>
	</body>

</html>