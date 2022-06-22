<%--
  Created by IntelliJ IDEA.
  User: lxz
  Date: 2022/6/13
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>任意文件上传</title>
</head>
<body>
<form action="uploadFileServlet" method="post" enctype="multipart/form-data">
    上传文件：<input type="file" name="EveFile"><br>
    <input type="submit" value="上传">
</form>

<%=request.getAttribute("patha")%>
</body>
</html>
