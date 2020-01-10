<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageBean.jsp</title>
</head>
<jsp:useBean id="counterBean" class="com.googol24.jsp.bean.CounterBean" scope="page">
</jsp:useBean>
<%
    // 相当于：
    //com.googol24.jsp.bean.CounterBean counterBean = new com.googol24.jsp.bean.CounterBean();
%>

<body>
    <h3>CounterBean scope="page"</h3>
    <b>count:</b>
    <%= counterBean.getCount() %>
    <jsp:getProperty name="counterBean" property="count"/>
</body>
</html>
