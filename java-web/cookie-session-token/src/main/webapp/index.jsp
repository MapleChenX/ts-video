<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Java Server Page Tag Language</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/first" method="post">
    <input type="submit" value="First">
</form>

<form action="${pageContext.request.contextPath}/second" method="post">
    <input type="submit" value="Second">
</form>

</body>
</html>