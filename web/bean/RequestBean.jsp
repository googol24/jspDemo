<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request Bean</title>
</head>
<jsp:useBean id="cb" class="com.googol24.jsp.bean.CounterBean" scope="request"/>
<%
    // 相当于：
//    com.googol24.jsp.bean.CounterBean cb = (com.googol24.jsp.bean.CounterBean)request.getAttribute("counterBean");
//    if (cb == null) {
//        request.setAttribute("counterBean", new com.googol24.jsp.bean.CounterBean());
//    }
%>
<body>
<h3>CounterBean Scope="request"</h3>
<%
    cb.setCount(100);
%>
<%--<jsp:forward page="RequestBean2.jsp"/>--%>
<%
    response.sendRedirect("RequestBean2.jsp");
%>
</body>
</html>
