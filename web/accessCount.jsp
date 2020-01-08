<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-08
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 声明</title>
</head>
<body>
<h1>JSP Declarations</h1>
<%!
    int accessCount = 0;
%>
<%
   int accessCount2 = 0;
%>
<h2>Access to page since Server Reboot:<%= ++accessCount%></h2>
<h2>Access Count 2(局部变量):<%= ++accessCount2%></h2>
</body>
</html>
