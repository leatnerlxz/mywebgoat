<%--
  Created by IntelliJ IDEA.
  User: lxz
  Date: 2022/6/2
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SQL注入——登录</title>
    </script>
</head>
<body>
<div align="center">
    <form action="loginServlet" method="post">
<%--       "用户名：1' or 1 = 1;-- "记得--之后需要空格 --%>
        用户名：<input type="text" placeholder="请输入用户名" name="userName"><br>
        密码：<input type="password" placeholder="请输入密码" name="userPwd">
        <button type="submit" name="submit" id="register_button">登录</button>
    </form>
</div>
<div>
    <p align="center">
        <% String str = " "+ request.getAttribute("users");%>
        <%= "您的登录信息为："+str%>
    </p>
</div>
</body>
</html>
