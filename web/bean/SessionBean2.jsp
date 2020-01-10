<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session Bean 2</title>
</head>
<jsp:useBean id="cb" class="com.googol24.jsp.bean.CounterBean" scope="session"/>
<body>
<h3>CounterBean scope="session" (another page)</h3>
<b>count:</b>
<jsp:getProperty name="cb" property="count"/>
</body>
</html>
