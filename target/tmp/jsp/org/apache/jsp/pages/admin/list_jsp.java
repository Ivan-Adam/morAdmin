/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.14.v20181114
 * Generated at: 2019-04-20 08:24:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"UTF-8\">\n");
      out.write("\t\t<title>管理员列表 - morAdmin 1.0</title>\n");
      out.write("\t\t<meta name=\"renderer\" content=\"webkit\">\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../../css/font.css\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"../../css/weadmin.css\">\n");
      out.write("\t\t<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->\n");
      out.write("\t\t<!--[if lt IE 9]>\n");
      out.write("\t      <script src=\"https://cdn.staticfile.org/html5shiv/r29/html5.min.js\"></script>\n");
      out.write("\t      <script src=\"https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("\t    <![endif]-->\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body>\n");
      out.write("\t\t<div class=\"weadmin-nav\">\n");
      out.write("\t\t\t<span class=\"layui-breadcrumb\">\n");
      out.write("        <a href=\"\">首页</a>\n");
      out.write("        <a href=\"\">管理员管理</a>\n");
      out.write("        <a>\n");
      out.write("          <cite>管理员列表</cite></a>\n");
      out.write("      </span>\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn-sm\" style=\"line-height:1.6em;margin-top:3px;float:right\" href=\"javascript:location.replace(location.href);\" title=\"刷新\">\n");
      out.write("\t\t\t\t<i class=\"layui-icon\" style=\"line-height:30px\">ဂ</i></a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"weadmin-body\">\n");
      out.write("\t\t\t<div class=\"layui-row\">\n");
      out.write("\t\t\t\t<form class=\"layui-form layui-col-md12 we-search\">\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t\t\t\t<input class=\"layui-input\" placeholder=\"开始日\" name=\"start\" id=\"start\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t\t\t\t<input class=\"layui-input\" placeholder=\"截止日\" name=\"end\" id=\"end\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"username\" placeholder=\"请输入用户名\" autocomplete=\"off\" class=\"layui-input\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<button class=\"layui-btn\" lay-submit=\"\" lay-filter=\"sreach\"><i class=\"layui-icon\">&#xe615;</i></button>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"weadmin-block\">\n");
      out.write("\t\t\t\t<button class=\"layui-btn layui-btn-danger\" onclick=\"delAll()\"><i class=\"layui-icon\"></i>批量删除</button>\n");
      out.write("\t\t\t\t<button class=\"layui-btn\" onclick=\"WeAdminShow('添加用户','./add.jsp')\"><i class=\"layui-icon\"></i>添加</button>\n");
      out.write("\t\t\t\t<span class=\"fr\" style=\"line-height:40px\">共有数据：88 条</span>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<table class=\"layui-table\">\n");
      out.write("\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<th>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"layui-unselect header layui-form-checkbox\" lay-skin=\"primary\"><i class=\"layui-icon\">&#xe605;</i></div>\n");
      out.write("\t\t\t\t\t\t</th>\n");
      out.write("\t\t\t\t\t\t<th>头像</th>\n");
      out.write("\t\t\t\t\t\t<th>账号</th>\n");
      out.write("\t\t\t\t\t\t<th>用户名</th>\n");
      out.write("                        <th>性别</th>\n");
      out.write("\t\t\t\t\t\t<th>手机</th>\n");
      out.write("\t\t\t\t\t\t<th>邮箱</th>\n");
      out.write("\t\t\t\t\t\t<th>生日</th>\n");
      out.write("\t\t\t\t\t\t<th>状态</th>\n");
      out.write("\t\t\t\t\t\t<th>操作</th>\n");
      out.write("\t\t\t\t</thead>\n");
      out.write("\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div>\n");
      out.write("\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t<td>1</td>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.loginName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.sex}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.mail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.birthday}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t<td class=\"td-status\">\n");
      out.write("\t\t\t\t\t\t\t<span class=\"layui-btn layui-btn-normal layui-btn-xs\">已启用</span></td>\n");
      out.write("\t\t\t\t\t\t<td class=\"td-manage\">\n");
      out.write("\t\t\t\t\t\t\t<a onclick=\"member_stop(this,'10001')\" href=\"javascript:;\" title=\"启用\">\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"layui-icon\">&#xe601;</i>\n");
      out.write("\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t<a title=\"编辑\" onclick=\"WeAdminShow('编辑','./edit.html')\" href=\"javascript:;\">\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"layui-icon\">&#xe642;</i>\n");
      out.write("\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t<a title=\"删除\" onclick=\"member_del(this,'要删除的id')\" href=\"javascript:;\">\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"layui-icon\">&#xe640;</i>\n");
      out.write("\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t</tbody>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<div class=\"page\">\n");
      out.write("\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t<a class=\"prev\" href=\"\">&lt;&lt;</a>\n");
      out.write("\t\t\t\t\t<a class=\"num\" href=\"\">1</a>\n");
      out.write("\t\t\t\t\t<span class=\"current\">2</span>\n");
      out.write("\t\t\t\t\t<a class=\"num\" href=\"\">3</a>\n");
      out.write("\t\t\t\t\t<a class=\"num\" href=\"\">489</a>\n");
      out.write("\t\t\t\t\t<a class=\"next\" href=\"\">&gt;&gt;</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<script src=\"../../layui-v2.4.5/layui/layui.js\" charset=\"utf-8\"></script>\n");
      out.write("    \t<script src=\"../../js/eleDel.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n");
      out.write("\t</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
