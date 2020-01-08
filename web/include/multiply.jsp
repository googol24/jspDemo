<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multiply</title>
</head>
<body>
<%
    try {
        float v1 = Float.parseFloat(request.getParameter("value1"));
        float v2 = Float.parseFloat(request.getParameter("value2"));
        double result = v1 * v2;
        out.println(v1 + "*" + v2 + "=" + result);
    } catch (Exception e) {
        out.print("不合法的计算");
    }
%>
</body>
</html>
