/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.14.v20181114
 * Generated at: 2019-04-20 12:00:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path", basePath);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>后台管理 - morAdmin 1.0</title>\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0\">\r\n");
      out.write("    <meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bassPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("images/fly.png\" type=\"image/x-icon\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bassPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("css/font.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bassPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("css/weadmin.css\">\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bassPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("layui-v2.4.5/layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 顶部开始 -->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("        <a href=\"./index.jsp\">morAdmin 1.0</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"left_open\">\r\n");
      out.write("        <i title=\"展开左侧栏\" class=\"iconfont\">&#xe699;</i>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"layui-nav left fast-add\" lay-filter=\"\">\r\n");
      out.write("        <li class=\"layui-nav-item\">\r\n");
      out.write("            <a href=\"javascript:;\">+新增</a>\r\n");
      out.write("            <dl class=\"layui-nav-child\">\r\n");
      out.write("                <!-- 二级菜单 -->\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <a onclick=\"WeAdminShow('资讯','https://www.youfa365.com/')\"><i class=\"iconfont\">&#xe6a2;</i>资讯</a>\r\n");
      out.write("                </dd>\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <a onclick=\"WeAdminShow('图片','http://www.baidu.com')\"><i class=\"iconfont\">&#xe6a8;</i>图片</a>\r\n");
      out.write("                </dd>\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <a onclick=\"WeAdminShow('用户','https://www.youfa365.com/')\"><i class=\"iconfont\">&#xe6b8;</i>用户</a>\r\n");
      out.write("                </dd>\r\n");
      out.write("            </dl>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    <ul class=\"layui-nav right\" lay-filter=\"\">\r\n");
      out.write("        <li class=\"layui-nav-item\">\r\n");
      out.write("            <a href=\"javascript:;\"><img src=\"./images/bg.png\" class=\"layui-nav-img\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a>\r\n");
      out.write("\r\n");
      out.write("            <dl class=\"layui-nav-child\">\r\n");
      out.write("                <!-- 二级菜单 -->\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <a onclick=\"WeAdminShow('个人信息','http://www.baidu.com')\">个人信息</a>\r\n");
      out.write("                </dd>\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <a onclick=\"WeAdminShow('切换帐号','./login.html')\">切换帐号</a>\r\n");
      out.write("                </dd>\r\n");
      out.write("                <dd>\r\n");
      out.write("                    <a class=\"loginout\" href=\"login.html\">退出</a>\r\n");
      out.write("                </dd>\r\n");
      out.write("            </dl>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"layui-nav-item to-index\">\r\n");
      out.write("            <a href=\"/\">前台首页</a>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 顶部结束 -->\r\n");
      out.write("<!-- 中部开始 -->\r\n");
      out.write("<!-- 左侧菜单开始 -->\r\n");
      out.write("<div class=\"left-nav\">\r\n");
      out.write("    <div id=\"side-nav\">\r\n");
      out.write("        <ul id=\"nav\">\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"javascript:;\">\r\n");
      out.write("                    <i class=\"iconfont\">&#xe6b8;</i>\r\n");
      out.write("                    <cite>会员管理</cite>\r\n");
      out.write("                    <i class=\"iconfont nav_right\">&#xe697;</i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"sub-menu\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a _href=\"./pages/member/list.jsp\">\r\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\r\n");
      out.write("                            <cite>会员列表</cite>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a _href=\"./pages/member/del.jsp\">\r\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\r\n");
      out.write("                            <cite>会员删除</cite>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"javascript:;\">\r\n");
      out.write("                    <i class=\"iconfont\">&#xe726;</i>\r\n");
      out.write("                    <cite>管理员管理</cite>\r\n");
      out.write("                    <i class=\"iconfont nav_right\">&#xe697;</i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <ul class=\"sub-menu\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a _href=\"./pages/admin/list.jsp\">\r\n");
      out.write("                            <i class=\"iconfont\">&#xe6a7;</i>\r\n");
      out.write("                            <cite>管理员列表</cite>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- <div class=\"x-slide_left\"></div> -->\r\n");
      out.write("<!-- 左侧菜单结束 -->\r\n");
      out.write("<!-- 右侧主体开始 -->\r\n");
      out.write("<div class=\"page-content\">\r\n");
      out.write("    <div class=\"layui-tab tab\" lay-filter=\"wenav_tab\" id=\"WeTabTip\" lay-allowclose=\"true\">\r\n");
      out.write("        <ul class=\"layui-tab-title\" id=\"tabName\">\r\n");
      out.write("            <li>我的桌面</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"layui-tab-content\">\r\n");
      out.write("            <div class=\"layui-tab-item layui-show\">\r\n");
      out.write("                <iframe src='./pages/welcome.jsp' frameborder=\"0\" scrolling=\"yes\" class=\"weIframe\"></iframe>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"page-content-bg\"></div>\r\n");
      out.write("<!-- 右侧主体结束 -->\r\n");
      out.write("<!-- 中部结束 -->\r\n");
      out.write("<!-- 底部开始 -->\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("    <div class=\"copyright\">Copyright ©2018 WeAdmin v1.0 All Rights Reserved</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 底部结束 -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    //\t\t\tlayui扩展模块的两种加载方式-示例\r\n");
      out.write("    //\t\t    layui.extend({\r\n");
      out.write("    //\t\t\t  admin: '{/}../../static/js/admin' // {/}的意思即代表采用自有路径，即不跟随 base 路径\r\n");
      out.write("    //\t\t\t});\r\n");
      out.write("    //\t\t\t//使用拓展模块\r\n");
      out.write("    //\t\t\tlayui.use('admin', function(){\r\n");
      out.write("    //\t\t\t  var admin = layui.admin;\r\n");
      out.write("    //\t\t\t});\r\n");
      out.write("    layui.config({\r\n");
      out.write("        base: './js/'\r\n");
      out.write("        ,version: '101100'\r\n");
      out.write("    }).use('admin');\r\n");
      out.write("    // layui.use(['jquery','admin'], function(){\r\n");
      out.write("    //     var $ = layui.jquery;\r\n");
      out.write("    //     $(function(){\r\n");
      out.write("    //         var login = JSON.parse(localStorage.getItem(\"login\"));\r\n");
      out.write("    //         if(login){\r\n");
      out.write("    //             if(login=0){\r\n");
      out.write("    //                 window.location.href='./login.jsp';\r\n");
      out.write("    //                 return false;\r\n");
      out.write("    //             }else{\r\n");
      out.write("    //                 return false;\r\n");
      out.write("    //             }\r\n");
      out.write("    //         }else{\r\n");
      out.write("    //             window.location.href='./pages/login.jsp';\r\n");
      out.write("    //             return false;\r\n");
      out.write("    //         }\r\n");
      out.write("    //     });\r\n");
      out.write("    // });\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("<!--Tab菜单右键弹出菜单-->\r\n");
      out.write("<ul class=\"rightMenu\" id=\"rightMenu\">\r\n");
      out.write("    <li data-type=\"fresh\">刷新</li>\r\n");
      out.write("    <li data-type=\"current\">关闭当前</li>\r\n");
      out.write("    <li data-type=\"other\">关闭其它</li>\r\n");
      out.write("    <li data-type=\"all\">关闭所有</li>\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
