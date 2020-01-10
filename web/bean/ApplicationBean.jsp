<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application Bean</title>
</head>
<jsp:useBean id="cb" class="com.googol24.jsp.bean.CounterBean" scope="application"/>
<%
    // 相当于
//    com.googol24.jsp.bean.CounterBean cb = application.getAttribute("counterBean");
//    if (cb == null) {
//        application.setAttribute("counterBean", new com.googol24.jsp.bean.CounterBean());
//    }
%>
<body>
<h3>CounterBean scope="application"</h3>
count:<%= cb.getCount() %>
</body>
</html>
