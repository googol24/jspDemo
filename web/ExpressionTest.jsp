<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-08
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 表达式测试</title>
</head>
<body>
    <h2>JSP EXPRESSIONS</h2>
    <ul>
        <li>Current Time: <%= new java.util.Date() %>></li>
        <%--request是JSP内置的HttpServletRequest对象--%>
        <li>Your HostName(客户端IP): <%= request.getRemoteHost() %></li>
        <%--session是JSP内置的HttpSession对象--%>
        <li>Your Session ID: <%= session.getId() %></li>
        <li>The <code>testParam</code> from parameter: <%= request.getParameter("testParam") %></li>
    </ul>
</body>
</html>
