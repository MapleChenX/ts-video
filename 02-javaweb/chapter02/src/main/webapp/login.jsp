<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2022/9/19
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<form action="user_login_2" method="post">
  <div class="username">
    <label>
      用户名：
      <input name="username" type="text"/>
    </label>
  </div>
  <div class="password">
    <div class="password">
      <label>
        密码：
        <input name="password" type="password"/>
      </label>
    </div>
  </div>
  <div class="submit">
    <button type="submit">登录</button>
  </div>
</form>
</body>
</html>
