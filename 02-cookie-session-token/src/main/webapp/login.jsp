<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/login" method="post">
    <label for="name">
        Username:
        <input id="name" type="text" name="username">
    </label>
    <label for="pwd">
        Password:
        <input id="pwd" type="password" name="password">
    </label>
    <input type="submit" value="提交">
</form>
</body>
</html>
