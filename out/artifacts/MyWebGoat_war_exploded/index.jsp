<%--
  Created by IntelliJ IDEA.
  User: lxz
  Date: 2022/6/2
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>小哲的个人靶场</title>
  </head>
  <!-- 新 Bootstrap4 核心 CSS 文件 -->
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">

  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

  <!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>

  <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>

  <body>
  <!--顶部-->
  <div class="jumbotron text-center" style="margin-bottom:0">
    <h1>小哲的个人靶场</h1>
<%--    <p>重置浏览器窗口大小查看效果！</p>--%>
  </div>

  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">漏洞</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">漏洞</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">漏洞</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">漏洞</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">漏洞</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">漏洞</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="clientPhone.jsp">SSRF-httpclient方式</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="upload.jsp">任意文件上传漏洞</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="XSS_Register.jsp">XSS反射(注册)</a>
        </li>
        <li class="nav-item" >
          <a class="nav-link" href="login.jsp">SQL注入(登录)</a>
        </li>
      </ul>
    </div>
  </nav>
  <!--中部主体-->
  <div class="container" style="margin-top:30px">
    <div class="col-sm-6">
      1. Server info: <%= application.getServerInfo() %><br>
      2. Servlet version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
      3. JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
      4. Java version: <%= System.getProperty("java.version") %><br>
    </div>
  </div>
  <div class="jumbotron text-center" style="margin-bottom:0">
    <p>底部内容</p>
  </div>
  </div>
  </body>
</html>
