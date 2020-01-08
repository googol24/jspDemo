<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-08
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Directive include</title>
</head>
<body>
<table width="100%">
    <tr>
        <td>
            <%@ include file="IncludeFile.jsp"%>
        </td>
    </tr>
    <tr>
        <td>
            <% out.println("用户显示区"); %>
        </td>
    </tr>
</table>
</body>
</html>
