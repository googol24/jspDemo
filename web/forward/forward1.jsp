<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward1.jsp</title>
</head>
<body bgcolor="#bdb76b">
    <h2>Here is forward1.jsp</h2>
    <jsp:forward page="forforward1.jsp">
        <jsp:param name="name" value="Alice"/>
        <jsp:param name="oldName" value='<%= request.getParameter("name") %>'/>
        <jsp:param name="roles" value="manager"/>
    </jsp:forward>
</body>
</html>
