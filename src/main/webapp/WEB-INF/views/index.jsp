<%--
  Created by IntelliJ IDEA.
  User: 豆子
  Date: 2019/4/17
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="basePath" scope="page"/>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理 - morAdmin 1.0</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="shortcut icon" href="${basePath}/static/images/fly.png" type="image/x-icon" />
    <link rel="stylesheet" href="${basePath}/static/css/font.css">
    <link rel="stylesheet" href="${basePath}/static/css/weadmin.css">
    <script src="${basePath}/layui-v2.4.5/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="/main">morAdmin 1.0</a>
    </div>
    <c:if test="${sessionScope.user != null}">
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
    </c:if>
    <ul class="layui-nav left fast-add" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">联系作者</a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd>
                    <a onclick="WeAdminShow('来啊，快活啊','https://github.com/mdz3201')"><i class="iconfont">&#xe6a2;</i>GitHub</a>
                </dd>
                <dd>
                    <a href="javascript:wechat()"><i class="iconfont">&#xe6a8;</i>微信</a>
                </dd>
                <dd>
                    <a href="javascript:qq()"><i class="iconfont">&#xe6b8;</i>QQ</a>
                </dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <c:choose>
        <c:when test="${sessionScope.user == null}">
            <li class="layui-nav-item">
                <a href="/login">请登录</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:register()">没有账号？</a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${basePath}/static/${sessionScope.user.userFace}" class="layui-nav-img">
                        ${sessionScope.user.userName}
                </a>

                <dl class="layui-nav-child">
                    <!-- 二级菜单 -->
                    <dd>
                        <a onclick="WeAdminShow('个人信息','${basePath}/user/userInfo')">个人信息</a>
                    </dd>
                    <dd>
                        <a onclick="WeAdminShow('更换头像','${basePath}/user/upFace')">更换头像</a>
                    </dd>
                    <dd>
                        <a class="loginout" href="/logout">退出</a>
                    </dd>
                </dl>
            </li>
        </c:otherwise>
        </c:choose>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
    <div class="left-nav" style="left: -221px;">
        <div id="side-nav">
            <ul id="nav">
                <li>
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6b8;</i>
                        <cite>用户管理</cite>
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a _href="/member/visitor">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>实时访客</cite>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">
                        <i class="iconfont">&#xe726;</i>
                        <cite>管理员管理</cite>
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a _href="/user/list">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>管理员列表</cite>
                            </a>
                        </li>
                        <li>
                            <a _href="/user/onlineList">
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>在线管理员</cite>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content" style="left: 0;">
    <div class="layui-tab tab" lay-filter="wenav_tab" id="WeTabTip" lay-allowclose="true">
        <c:if test="${sessionScope.user != null}">
            <ul class="layui-tab-title" id="tabName">
                <li>首页</li>
            </ul>
        </c:if>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/welcome' frameborder="0" scrolling="yes" class="weIframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2019 morAdmin v1.0 All Rights Reserved</div>
</div>
<!-- 底部结束 -->
<script type="text/javascript">
    //			layui扩展模块的两种加载方式-示例
    // 		    layui.extend({
    // 			  admin: '{/}../../static/js/admin' // {/}的意思即代表采用自有路径，即不跟随 base 路径
    // 			});
    // 			//使用拓展模块
    // 			layui.use('admin', function(){
    // 			  var admin = layui.admin;
    // 			});
    layui.config({
        base: '${basePath}/static/js/'
        ,version: '101100'
    }).use('admin');
    // layui.use(['jquery','admin'], function(){
    //     var $ = layui.jquery;
    //     $(function(){
    //         var login = JSON.parse(localStorage.getItem("login"));
    //         if(login){
    //             if(login=0){
    //                 window.location.href='./login.jsp';
    //                 return false;
    //             }else{
    //                 return false;
    //             }
    //         }else{
    //             window.location.href='./pages/login.jsp';
    //             return false;
    //         }
    //     });
    // });
    function register() {
        layer.msg('别闹，你见过哪个后台可以注册的？<br>找管理员要账号去', {
            time: 3000,
        });
    }
    function qq() {
        layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'qq_qq' //设定一个id，防止重复弹出
            ,btn: [ '残忍拒绝']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 30px; text-align: center; background-color: #393D49; "><img src="${basePath}/static/qq.jpg" alt="" style="width: 150px;height: 200px"></div>'
        });
    }
    function wechat() {
        layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'qq_qq' //设定一个id，防止重复弹出
            ,btn: [ '残忍拒绝']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 30px; text-align: center; background-color: #393D49; "><img src="${basePath}/static/wechat.jpg" alt="" style="width: 150px;height: 150px"></div>'
        });
    }
</script>
</body>
<!--Tab菜单右键弹出菜单-->
<ul class="rightMenu" id="rightMenu">
    <li data-type="fresh">刷新</li>
    <li data-type="current">关闭当前</li>
    <li data-type="other">关闭其它</li>
    <li data-type="all">关闭所有</li>
</ul>

</html>
