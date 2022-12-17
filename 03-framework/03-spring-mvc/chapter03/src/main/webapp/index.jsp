<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
  <title>测试 JSON 交互</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
  <script>
    function testJson() {
      let username = $("#username").val()
      let password = $("#password").val()

      $.ajax({
        url: "${pageContext.request.contextPath}/test/json",
        type: "post",
        data: JSON.stringify({username: username, password: password}),
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        success: (data) => {
          if (data != null) {
            alert("您输入的用户名为：" + data.username + "密码为：" + data.password)
          }
        }
      })
    }
  </script>
</head>
<body>
<form>
  用户名：<input type="text" name="username" id="username"><br/>
  密码：<input type="password" name="password" id="password"><br/>
  <input type="button" value="测试 JSON 交互" onclick="testJson()"/>
</form>
</body>
</html>
