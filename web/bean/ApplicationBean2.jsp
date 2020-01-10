<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application Bean 2</title>
</head>
<jsp:useBean id="cb" class="com.googol24.jsp.bean.CounterBean" scope="application"/>
<body>
<h3>CounterBean scope="application"(another page)</h3>
count:
<%= cb.getCount() %>
</body>
</html>
