<%--
  Created by IntelliJ IDEA.
  User: 豆子
  Date: 2019/4/17
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="basePath" scope="page"/>
<html>
<head>
    <title>管理员登录 - morAdmin 1.0</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="shortcut icon" href="${basePath}/static/images/fly.png" type="image/x-icon" />
    <link rel="stylesheet" href="${basePath}/static/css/login.css">
    <script src="${basePath}/layui-v2.4.5/layui/layui.js" charset="utf-8"></script>
    <script src="${basePath}/static/js/login.js" charset="utf-8"></script>
    <script src="${basePath}/static/js/HashEncrypt.js"></script>
    <style>
        .layui-form-onswitch{
            border-color: #189F92;
            background-color: #189F92;
        }
    </style>
</head>
<body>
<script type="text/javascript">
    function test() {
        layer.msg('别闹，让神仙给你注册一个去', {
            time: 2000,
        });
    }
    test();
    var func = function() {
        alert("你好，程序员");
    };
    func();
</script>
    <div class="login">
        <div class="message">morAdmin 1.0 - 管理员登录</div>
        <div id="dark"></div>
        <form action="../../login" method="post" class="layui-form" onsubmit="return md5()">
            <div class="layui-form-item input-item">
                <label for="loginName">账号</label>
                <input type="text" placeholder="请输入登录账号" autocomplete="off" id="loginName" name="loginName" class="layui-input" lay-verify="required">
            </div>
            <hr>
            <div class="layui-form-item input-item">
                <label for="loginPwd">密码</label>
                <input type="password" placeholder="请输入登录密码" autocomplete="off" id="loginPwd" class="layui-input" lay-verify="required">
                <input type="hidden" name="loginPwd" id="md5_pwd">
            </div>
            <hr>
            <div class="layui-form-item input-item" style="display: inline-block">
                <label for="captche">验证码</label>
                <input type="text" placeholder="请输入图片中的验证码" autocomplete="off" id="captche" name="captche" class="layui-input" style="width: 230px; display: inline-block">
            </div>
            <a href="javascript:reloadCode();" style="border: silver 1px solid; width: 80px; height: 36px; display: inline-block;vertical-align: top"><img id="imageCode" src="captche" alt=""></a>
            <a href="javascript:reloadCode();" style="width: 38px;height: 38px;line-height: 38px; vertical-align: top"><i class="layui-icon layui-icon-refresh-1" style="font-size: 16px; color: #666666;"></i></a>
            <div class="layui-form-item">
                <div class="layui-input-block" style="display: inline-block;margin-left: 10px;width: 100%">
                    <input type="checkbox" lay-skin="switch" value="1" name="remember"><span style="margin-top: 8px;margin-left: 5px;display: inline-block;vertical-align: middle">记住我</span>
                    <a href="javascript:register()"><span style="float: right;margin-top: 8px;display: inline-block;vertical-align: middle;margin-right: 20px">没有账号？</span></a>
                </div>
            </div>
            <div class="layui-form-item">
                <button type="submit" id="submit" class="layui-btn layui-block" lay-filter="login" style="width: 100%;height: 38px">立&nbsp&nbsp即&nbsp&nbsp登&nbsp&nbsp录</button>
            </div>
        </form>
    </div>

    <c:choose>
        <c:when test="${requestScope.loginWrong == '1'}">
            <script type="text/javascript">register();</script>
        </c:when>
        <c:when test="${requestScope.loginWrong == '2'}">
            <script type="text/javascript">register();</script>
        </c:when>
        <c:when test="${requestScope.loginWrong == '3'}">
            <script type="text/javascript">register();</script>
        </c:when>
        <c:otherwise></c:otherwise>
    </c:choose>

</body>

<script type="text/javascript">
    //客户端加密
    function md5(){
        var loginPwd= document.getElementById('loginPwd');
        var md5_pwd=document.getElementById('md5_pwd');
        md5_pwd.value = HashEncrypt.MD5(loginPwd.value,false,false);
        return true;
    }
    <!--重新加载验证码-->
    function reloadCode() {
        var time = new Date().getTime();
        document.getElementById("imageCode").src="captche?d="+time;
    }
    function register() {
        layer.msg('别闹，让神仙给你注册一个去', {
            time: 2000,
        });
    }
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</html>
