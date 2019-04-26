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
        <a>用户管理</a>
        <a>
          <cite>实时访客</cite></a>
      </span>
			<a class="layui-btn layui-btn-sm" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
				<i class="layui-icon" style="line-height:30px">ဂ</i></a>
		</div>
		<div class="weadmin-body">
			<div class="weadmin-block">
                <span style="line-height:30px;margin-left: 20px;">当前有 ${applicationScope.visitorNumber} 个人正在浏览网站</span>
			</div>
			<table class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
						</th>
						<th>编号</th>
						<th>SessionID</th>
						<th>访问IP</th>
						<th>访问时间</th>
				</thead>
				<c:forEach items="${applicationScope.visitorList}" var="visitor" varStatus="sta">
					<tbody>
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
						</td>
						<td>${sta.index+1}</td>
						<td>${visitor.sessionIdString}</td>
						<td>${visitor.ipString}</td>
						<td>${visitor.firstTimeString}</td>
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