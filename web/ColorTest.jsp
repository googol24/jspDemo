<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-08
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bgColor Test</title>
</head>
<!--HTML注释-->
<%--JSP注释1--%>
<%
    // JSP注释2
    /*
    JSP注释3
    abc
    */
    String bgColor = request.getParameter("bg_color");
    boolean hasExplictColor;
    if (bgColor == null) {
        hasExplictColor = false;
        bgColor = "WHITE";
    } else {
        hasExplictColor = true;
    }
%>
<body bgcolor="<%= bgColor %>">
<h2 align="center">Color Test</h2>
<%
    if (hasExplictColor) {
        // out是JSP内置的JspWriter对象
        out.print("设置了自定义背景颜色：" + bgColor);
    } else {
        out.print("没有设置自定义背影颜色，默认为" + bgColor);
    }
%>
</body>
</html>
