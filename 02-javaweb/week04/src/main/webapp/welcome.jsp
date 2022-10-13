<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2022/9/19
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>
</head>
<body>
<h1>Welcome 页面</h1>
<h4>登录成功，欢迎登录
  <%=
    request.getAttribute("username").toString()
  %>
</h4>
</body>
</html>
