<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>注册页面</title>
</head>
<body>
<form action="register.do" method="post">
  <label>
    用户名：
    <input name="username" type="text">
  </label>
  <label>
    密码：
    <input name="password" type="password">
  </label>
  <label>
    性别：
    <input name="sex" type="text">
  </label>
  <label>
    手机号：
    <input name="mobilephone" type="text">
  </label>
  <label>
    学历：
    <input name="education" type="text">
  </label>
  <label>
    <button type="submit">登录</button>
  </label>
</form>
<div style="color: red">${error}</div>
</body>
</html>
