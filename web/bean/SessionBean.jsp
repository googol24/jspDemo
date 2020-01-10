<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session Bean</title>
</head>
<jsp:useBean id="cb" class="com.googol24.jsp.bean.CounterBean" scope="session"/>
<%
    // 相当于
//    com.googol24.jsp.bean.CounterBean cb = session.getAttribute("counterBean");
//    if (cb == null) {
//        session.setAttribute("counterBean", new com.googol24.jsp.bean.CounterBean());
//    }
%>
<body>
<h3>CounterBean scope="session"</h3>
<b>count:</b>
<jsp:getProperty name="cb" property="count"/>
<%--<% cb.getCount() %>--%>
</body>
</html>
