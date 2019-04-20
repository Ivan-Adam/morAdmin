<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>权限管理-WeAdmin Frame型后台管理系统-WeAdmin 1.0</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="../../css/font.css">
		<link rel="stylesheet" href="../../css/weadmin.css">
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>

	<body>
		<div class="weadmin-nav">
			<span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">管理员管理</a>
        <a>
          <cite>权限管理</cite></a>
      </span>
			<a class="layui-btn layui-btn-sm" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
				<i class="layui-icon" style="line-height:30px">ဂ</i></a>
		</div>
		<div class="weadmin-body">
			<div class="layui-row">
				<form class="layui-form layui-col-md12 we-search layui-form-pane">
					<div class="layui-input-inline">
						<select name="cateid">
							<option>规则分类</option>
							<option>文章</option>
							<option>会员</option>
							<option>权限</option>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="contrller">
							<option>请控制器</option>
							<option>Index</option>
							<option>Goods</option>
							<option>Cate</option>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="action">
							<option>请方法</option>
							<option>add</option>
							<option>login</option>
							<option>checklogin</option>
						</select>
					</div>
					<div class="layui-inline">
						<input class="layui-input" placeholder="权限名" name="cate_name">
					</div>
					<button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>
				</form>
			</div>
			<div class="weadmin-block">
				<button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
				<span class="fr" style="line-height:40px">共有数据：88 条</span>
			</div>
			<table class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
						</th>
						<th>ID</th>
						<th>权限规则</th>
						<th>权限名称</th>
						<th>所属分类</th>
						<th>操作</th>
				</thead>
				<tbody>
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
						</td>
						<td>1</td>
						<td>admin/user/userlist</td>
						<td>会员列表</td>
						<td>会员相关</td>
						<td class="td-manage">
							<a title="编辑" onclick="WeAdminShow('编辑','../404.html')" href="javascript:;">
								<i class="layui-icon">&#xe642;</i>
							</a>
							<a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
								<i class="layui-icon">&#xe640;</i>
							</a>
						</td>
					</tr>
				</tbody>
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
		<script src="../../lib/layui/layui.js" charset="utf-8"></script>
		<script src="../../static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>