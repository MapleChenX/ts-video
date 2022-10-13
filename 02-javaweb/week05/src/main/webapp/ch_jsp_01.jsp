<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2022/9/26
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chapter JSP 01</title>
</head>
<body>
<%!
  private final String outside = "global variable";

  private void speak(String msg) {
    System.out.println(msg);
  }
%>
<%
  String msg = "Hello World";
  speak(msg);
%>

<%=msg%>
</body>
</html>
