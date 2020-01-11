<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-11
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet Use JSP</title>
</head>
<body bgcolor="gray">
<h2>Servlet 使用 JSP 的例子</h2>
<h2>这个页面是被 Servlet 调用的</h2>
<h2>
    <%--从Servlet跳转过来的，能获取到请求的参数--%>
    servletName:<%= request.getAttribute("servletName")%>
</h2>
</body>
</html>
