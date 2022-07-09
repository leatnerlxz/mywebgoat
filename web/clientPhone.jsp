<%--
  Created by IntelliJ IDEA.
  User: lxz
  Date: 2022/6/20
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内容获取</title>
</head>
<body>
<form action="phoneClientServlet" method="post">
    IP地址：<input type="text" name="userUrl"><br>
    <button type="submit" name="submit">进入</button>
</form>
<%--<input type="button" value="jumpweb" onclick="window.location.href='register.jsp'">--%>
<div><% String str = " "+ request.getAttribute("users");%>
    <%= "网页内容为："+str%>
</div>
</body>
</html>
