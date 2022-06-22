<%--
  Created by IntelliJ IDEA.
  User: lxz
  Date: 2022/6/9
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XSS反射型漏洞--注册</title>
    <script>
        function myFunction(){
            window.location.href = 'register.jsp';
        }
    </script>
</head>
<body>
<div align="center">
<%--    用户名输入：<script>alert(1)</script>
        密码任意
--%>
    <form action="registerServlet" method="post">
        <p>man,what's your name?</p>
        <input type="text" placeholder="your name,man!" name="XSSName">
        <input type="password" placeholder="you password,man!" name="XSSPwd">
        <button type="submit" name="xssShowRegister">注册</button>
    </form>
</div>
</body>
</html>
