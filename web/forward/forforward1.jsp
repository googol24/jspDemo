<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forforward1.jsp</title>
</head>
<body>
    <h2>Here is forforward1.jsp</h2>
    <p>Request Params:</p>
    name : <%= request.getParameter("name") %><br>
    oldName: <%= request.getParameter("oldName") %><br>
    roles: <%= request.getParameter("roles") %><br>
    <%--因为是同一个request，这里可以接收到forforward.jsp里请求的参数--%>
    abc: <%= request.getParameter("abc") %><br>
</body>
</html>
