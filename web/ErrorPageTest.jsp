<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-08
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="ErrorPage.jsp" %>
<html>
<head>
    <title>Error Page Test</title>
</head>
<body>
<%
    String s = "123s";
    int i = Integer.parseInt(s);
    out.print("s=" + s + ",i=" + i);
%>
</body>
</html>
