<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="basePath" scope="page"/>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>添加管理员-morAdmin 1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${basePath}/static/css/font.css">
		<link rel="stylesheet" href="${basePath}/static/css/weadmin.css">
      <link rel="stylesheet" href="${basePath}/layui-v2.4.5/layui/css/layui.css">
      <script src="${basePath}/static/js/HashEncrypt.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>

    <div class="weadmin-body">
        <form class="layui-form" action="/user/add" method="post" onsubmit="return md5()">
          <div class="layui-form-item">
              <label for="loginName" class="layui-form-label">
                  <span class="we-red">*</span>账号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="loginName" name="loginName" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>将会成为您唯一的登入名
              </div>
          </div>
            <div class="layui-form-item">
                <label for="userName" class="layui-form-label"><span class="we-red">*</span>
                    用户名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="userName" name="userName" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="we-red">*</span>性别</label>
                <div class="layui-input-block" style="width: 100px">
                    <select name="sex">
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </div>
            </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="we-red">*</span>手机
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" name="phone" required="" lay-verify="phone"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="mail" class="layui-form-label">
                  邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="mail" name="mail" required="" lay-verify="email"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>
              </div>
          </div>
            <div class="layui-form-item">
              <label class="layui-form-label"><span class="we-red">*</span>角色</label>
              <div class="layui-input-block" style="width: 200px">
                  <select name="prim" id="">
                      <option value="1">超级管理员</option>
                      <option value="2">管理员</option>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="loginPwd" class="layui-form-label">
                  <span class="we-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" placeholder="请输入登录密码" autocomplete="off" id="loginPwd" class="layui-input" lay-verify="required">
                  <input type="hidden" name="loginPwd" id="md5_pwd">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>6到16个字符
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label"></label>
              <button type="submit"  class="layui-btn">增加</button>
          </div>
      </form>
    </div>
		<script src="${basePath}/layui-v2.4.5/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript">

        function md5(){
            var loginPwd= document.getElementById('loginPwd');
            var md5_pwd=document.getElementById('md5_pwd');
            md5_pwd.value = HashEncrypt.MD5(loginPwd.value,false,false);
            return true;
        }
        //Demo
        layui.use('form', function(){
            var form = layui.form;

        });
    </script>
  </body>

</html>