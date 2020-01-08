<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Divide</title>
</head>
<body>
    <h1>
        <%
            try {
                float dividend = Float.parseFloat(request.getParameter("v1"));
                float divisor = Float.parseFloat(request.getParameter("v2"));
                double result = dividend / divisor;
        %>
        <%= result %>
        <%
            } catch (Exception e) {
                out.print("不合法的计算");
            }
        %>
    </h1>
</body>
</html>
