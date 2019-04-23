<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set value="${pageContext.request.contextPath}" var="basePath" scope="page"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>欢迎页面 - morAdmin 1.0</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="${basePath}/static/css/font.css">
		<link rel="stylesheet" href="${basePath}/static/css/weadmin.css">
	</head>
	<body>
		<div class="weadmin-body">
			<blockquote class="layui-elem-quote">欢迎使用 morAdmin 1.0.0 开发版</blockquote>
			<div class="layui-fluid" style="overflow: hidden;">
				<div class="layui-row layui-col-space15">
					<div class="layui-col-md8">
						<div class="layui-card">
							<div class="layui-card-header">快捷方式</div>
							<div class="layui-card-body">
								<div class="layui-carousel weadmin-shortcut" lay-filter="shortcut" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
									<div carousel-item="">
										<ul class="layui-row layui-col-space10 layui-this">
											<li class="layui-col-xs3">
												<a href="http://www.layui.com/doc/" target="_blank">
													<i class="layui-icon">&#xe705;</i>
													<cite>Layui文档</cite>
													<p><span></span></p>
												</a>
											</li>
											<li class="layui-col-xs3">
												<a href="http://www.layui.com/admin/" target="_blank">
													<i class="layui-icon">&#xe735;</i>
													<cite>LayuiAdmin</cite>
													<p><span>Layui官方出品的专业后台管理模板</span></p>
												</a>
											</li>
											<li class="layui-col-xs3">
												<a href="https://lovetime.gitee.io/weadmin/" target="_blank">
													<i class="layui-icon">&#xe606;</i>
													<cite>WeAdmin</cite>
													<p><span>一款基于Layui的前端模板</span></p>
												</a>
											</li>
                                            <li class="layui-col-xs3">
                                                <a href="https://github.com/mdz3201/morAdmin" target="_blank">
                                                    <i class="layui-icon">&#xe600;</i>
                                                    <cite>Github下载</cite>
                                                    <p><span>欢迎Fork和Star</span></p>
                                                </a>
                                            </li>
										</ul>
										<ul class="layui-row layui-col-space10">
                                            <li class="layui-col-xs3">
                                                <a href="javascript:;" target="_blank">
                                                    <i class="layui-icon layui-icon-set"></i>
                                                    <cite>设置</cite>
                                                    <p><span>快捷方式示例</span></p>
                                                </a>
                                            </li>

                                            <li class="layui-col-xs3">
                                                <a href="javascript:;" target="_blank">
                                                    <i class="layui-icon layui-icon-set"></i>
                                                    <cite>设置</cite>
                                                    <p><span>快捷方式示例</span></p>
                                                </a>
                                            </li>
											<li class="layui-col-xs3">
												<a href="javascript:;" target="_blank">
													<i class="layui-icon layui-icon-set"></i>
													<cite>设置</cite>
                                                    <p><span>快捷方式示例</span></p>
												</a>
											</li>
											<li class="layui-col-xs3">
												<a href="javascript:;" target="_blank">
													<i class="layui-icon layui-icon-set"></i>
													<cite>设置</cite>
                                                    <p><span>快捷方式示例</span></p>
												</a>
											</li>
											
										</ul>
									</div>
									<div class="layui-carousel-ind">
										<ul>
											<li class="layui-this"></li>
											<li></li>
										</ul>
									</div>
									<!--<button class="layui-icon layui-carousel-arrow" lay-type="sub"></button>
									<button class="layui-icon layui-carousel-arrow" lay-type="add"></button>-->
								</div>

							</div>
						</div>
					</div>
					<div class="layui-col-md4">
						<div class="layui-card">
							<div class="layui-card-header">
								作者叨叨
								<i class="layui-icon" style="color: #FF5722;">&#xe756;</i>
							</div>
							<div class="layui-card-body layui-text weadmin-text">
								<p>这学期学习Java Web开发，把做的练习放到这里分享，第一次尝试，代码有些粗糙，如果有感兴趣的同学欢迎一起学习</p>
                                <p>感谢<a href="https://lovetime.gitee.io/weadmin/" target="_blank">WeAdmin</a>提供前端模板</p>
                                <p>源码开放，移步<a href="https://github.com/mdz3201/morAdmin">GitHub</a>，仅供学习</p>
								<p>更完善的商业使用，强烈建议移步<a href="http://www.layui.com/admin/" target="_blank">layuiAdmin</a>和<a href="https://lovetime.gitee.io/weadmin/" target="_blank">WeAdmin</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="layui-col-lg12 layui-collapse" style="border: none;">
				<div class="layui-col-lg6 layui-col-md12">
						
					
					<!--统计信息展示-->
					<fieldset class="layui-elem-field" style="padding: 5px;">
						<!--WeAdmin公告-->
						<div class="layui-card">
							<div class="layui-card-header layui-elem-quote">morAdmin公告</div>
							<div class="layui-card-body">
								<div class="layui-carousel weadmin-notice" lay-filter="notice" lay-indicator="inside" lay-arrow="none" style="width: 100%; height: 280px;">
									<div carousel-item="">
										<div class="">
											<a href="https://www.daxuecheng.fun" target="_blank" class="layui-bg-red">2019年4月22日，morAdmin 1.0 上线</a>
										</div>
										<div class="">
											<a href="http://www.layui.com/admin/" target="_blank" class="layui-bg-blue">首款 layui 官方后台模板系统正式发布</a>
										</div>
										<div class="">
											<a href="http://fly.layui.com/jie/24231/" target="_blank" class="layui-bg-green">Layui 官方发布 layuiAdmin iframe 多标签页版本</a>
										</div>

									</div>
									<div class="layui-carousel-ind">
										<ul>
											<li class="layui-this"></li>
											<li></li>
										</ul>
									</div>
									<!--<button class="layui-icon layui-carousel-arrow" lay-type="sub"></button>
									<button class="layui-icon layui-carousel-arrow" lay-type="add"></button>-->
								</div>

							</div>
						</div>
						<!--<legend>信息统计</legend>-->
						<blockquote class="layui-elem-quote font16">信息统计</blockquote>
						<div class="">
                            <table class="layui-table">
                                <thead>
                                <tr>
                                    <th colspan="2" scope="col">服务器信息</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th width="30%">服务器计算机名</th>
                                    <td><span id="lbServerName">http://127.0.0.1/</span></td>
                                </tr>
                                <tr>
                                    <td>服务器IP地址</td>
                                    <td>47.112.119.243</td>
                                </tr>
                                <tr>
                                    <td>服务器域名</td>
                                    <td>www.daxuecheng.fun</td>
                                </tr>
                                <tr>
                                    <td>服务器端口 </td>
                                    <td>80</td>
                                </tr>
                                <tr>
                                    <td>本文件所在文件夹 </td>
                                    <td>C:\webapp\morAdmin\</td>
                                </tr>
                                <tr>
                                    <td>morAdmin时间 </td>
                                    <td>
                                        <div id="datetime">
                                            <script>
                                                setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000);
                                            </script>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <hr style="background: #fff 0 0 no-repeat;height: 9px;border: none;margin: 0px;padding: 0px;width: 100%;">
							<table class="layui-table" lay-even>
								<thead>
									<tr>
										<th>统计</th>
										<th>资讯库</th>
										<th>图片库</th>
										<th>产品库</th>
										<th>用户</th>
										<th>管理员</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>总数</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>在线</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
                                    <tr>
                                        <td>今日</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>昨日</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
									<tr>
										<td>本周</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>本月</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</div>
					</fieldset>
				</div>
				<div class="layui-col-lg6 layui-col-md12">
					<fieldset class="layui-elem-field we-changelog" style="padding: 5px;">
						<!--更新日志-->
						<blockquote class="layui-elem-quote font16">发展历程&amp;更新日志</blockquote>
						<ul class="layui-timeline" style="height: 729px; overflow-y: auto;">
							<li class="layui-timeline-item">
								<i class="layui-icon layui-timeline-axis" style="color: #FF5722;">&#xe756;</i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">
										<h3>代码更新</h3>
										<span class="layui-badge-rim">2019-04-23</span>
									</div>
									<ul>
										<li>实现 管理员管理>管理员列表 页面，根据权限显示功能</li>
										<li>增加对管理员的操作</li>
									</ul>
								</div>
							</li>
							<li class="layui-timeline-item">
								<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">
										<h3>代码更新</h3>
										<span class="layui-badge-rim">2019-04-21</span>
									</div>
									<ul>
                                        <li>改写登录界面，增加自动登录，验证码，表单输入效果</li>
                                        <li>增加登录和自动登录业务</li>
                                        <li>创建数据库，详情查询文档 Database_readme.md</li>
                                        <li>对用户提交的密码采用MD5算法进行单向加密</li>
									</ul>
								</div>
							</li>
							<li class="layui-timeline-item">
								<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">
										<h3>morAdmin 1.0.0 开发版 上线</h3>
										<span class="layui-badge-rim">2019-04-20</span>
									</div>
                                    <ul>
                                        <li>前端框架基于Layui</li>
                                        <li>界面显示基于WeAdmin</li>
                                        <li>后端设计采用MVC结构</li>
                                    </ul>
								</div>
							</li>
							<li class="layui-timeline-item">
								<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
								<div class="layui-timeline-content layui-text">
									<div class="layui-timeline-title">
										<h3>morAdmin立项</h3>
										<span class="layui-badge-rim">2019-04-18</span>
									</div>
                                    <p>
                                        一次 siift+del 让我心有余悸，以后要把代码多备份几份，还是放线上更安全
                                    </p>
								</div>
							</li>
						</ul>
					</fieldset>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="../../layui-v2.4.5/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript">
		layui.extend({
			admin: '{/}../js/admin',
		});
		layui.use(['jquery', 'element','util', 'admin', 'carousel'], function() {
			var element = layui.element,
				$ = layui.jquery,
				carousel = layui.carousel,
				util = layui.util,
				admin = layui.admin;
			//建造实例
			carousel.render({
				elem: '.weadmin-shortcut'
				,width: '100%' //设置容器宽度				
				,arrow: 'none' //始终显示箭头	
				,trigger: 'hover'
				,autoplay:false
			});
			
			carousel.render({
				elem: '.weadmin-notice'
				,width: '100%' //设置容器宽度				
				,arrow: 'none' //始终显示箭头	
				,trigger: 'hover'
				,autoplay:true
			});
			
			$(function(){
				setTimeAgo(2018,0,1,13,14,0,'#firstTime');
				setTimeAgo(2018,2,28,16,0,0,'#lastTime');
			});
			function setTimeAgo(y, M, d, H, m, s,id){
			    var str = util.timeAgo(new Date(y, M||0, d||1, H||0, m||0, s||0));
			    $(id).html(str);
			    console.log(str);
			 };
		});
	</script>

</html>