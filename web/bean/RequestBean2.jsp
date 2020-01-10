<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request Bean2</title>
</head>
<jsp:useBean id="cb" scope="request" class="com.googol24.jsp.bean.CounterBean"/>
<body>
    <h3>CounterBean scope="request"</h3>
    count:<%= cb.getCount() %>
</body>
</html>
