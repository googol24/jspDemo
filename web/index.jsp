<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-04
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>My First JSP</title>
  </head>
  <body>
    Hello World JSP!
  <%
      out.println("This is a JSP Page<br>");
      out.println("current time:" + new java.util.Date());
  %>
  </body>
</html>
