<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 在使用之前设定编码
    // 设置对客户端请求和数据库取值时的编码，不指定的话默认使用iso-8859-1
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="hello" class="com.googol24.jsp.bean.HelloBean" scope="request">
    <%--相当于前面页面form里面的值分别调用setXXX方法--%>
    <jsp:setProperty name="hello" property="*"/>
</jsp:useBean>

<html>
<head>
    <title>Say Hello Bean</title>
    <meta charset="UTF-8"/>
</head>
<body>
<p align="center">
    <font size="4">欢迎</font>
</p>
<p>
    <%--未设定编码时--%>
    <%--<%= new String(hello.getName().getBytes("ISO-8859-1"), "UTF-8")%>--%>
    <%= hello.getName() %>

    <%--未设定编码时--%>
    <%--<%= new String(hello.getSex().getBytes("ISO-8859-1"), "UTF-8")%>--%>
    <%= hello.getSex() %>
</p>
<p>
    <jsp:getProperty name="hello" property="name"/>
    <jsp:getProperty name="hello" property="sex"/>
</p>
</body>
</html>
