<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String value1 = request.getParameter("value1");
    String value2 = request.getParameter("value2");
%>

<% if (value1 != null && value2 != null && request.getParameter("compute") != null && request.getParameter("compute").equals("division")) { %>
    <jsp:include page="divide.jsp">
        <jsp:param name="v1" value="<%= value1 %>"/>
        <jsp:param name="v2" value="<%= value2 %>"/>
    </jsp:include>
<% } else { %>
    <%@ include file="multiply.jsp" %>
<% } %>