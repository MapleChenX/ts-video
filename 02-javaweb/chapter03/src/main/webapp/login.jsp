<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>登录页面</title>
</head>
<body>
<form action="login.do" method="post">
  <label>
    用户名：
    <input name="username" type="text">
  </label>
  <label>
    密码：
    <input name="password" type="password">
  </label>
  <label>
    <button type="submit">登录</button>
  </label>
</form>
<div style="color: red">${error}</div>
</body>
</html>
