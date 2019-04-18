<%--
  Created by IntelliJ IDEA.
  User: 豆子
  Date: 2019/4/17
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页 - morAdmin 1.0</title>
</head>
<body>
${sessionScope.user.userName}
<hr>
${sessionScope.user.loginName}
<hr>
${sessionScope.user.loginPwd}
<hr>${sessionScope.user.sex}
<hr>
${sessionScope.user.birthday}
</body>
</html>
