<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test include</title>
</head>
<body bgcolor="white">
    <font color="red">
        The current date and time are:
        <%@ include file="date.jsp"%>
        <jsp:include page="date.jsp" flush="true"/>
    </font>
</body>
</html>
