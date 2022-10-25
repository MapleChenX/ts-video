<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html charset=gb2312">
  <title>首页</title>
</head>
<body>
<form action="register.do" method="post">
  <label>
    用户名：
    <input type="text" name="username"/>
  </label><br>
  <label>
    密码：
    <input type="password" name="password"/>
  </label><br>
  <label>
    性别：
    <input type="radio" name="sex" value="male"/>男
    <input type="radio" name="sex" value="famle"/>女
  </label><br>
  <label>
    年龄：<input type="text" name="age">
  </label><br>
  <label>
    兴趣：<input type="checkbox" name="hobby" value="read">文学
    <input type="checkbox" name="hobby" value="sport">体育
    <input type="checkbox" name="hobby" value="computer">电脑
  </label><br>
  <label>
    学历：
    <select name="education">
      <option value="bachelor">学士</option>
      <option value="master">硕士</option>
      <option value="doctor">博士</option>
    </select>
  </label><br>
  <label>
    邮箱地址：<input type="text" name="email" size="20">
  </label><br>
  <label>
    简历：<textarea name="resume" rows="5" cols="30"></textarea>
  </label><br>
  <input type="submit" name="submit" value="提交">
  <input type="reset" name="reset" value="重置">
</form>
</body>
</html>
