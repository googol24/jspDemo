<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-09
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using jsp:setProperty</title>
</head>
<body>
<table border="5" align="center">
    <tr>
        <th>Using jsp:setProperty</th>
    </tr>
</table>
<jsp:useBean id="entry" class="com.googol24.jsp.bean.SaleEntry"/>

<jsp:setProperty name="entry" property="itemId" value='<%= request.getParameter("itemId") %>'/>

<jsp:setProperty name="entry" property="numItems" param="numItem"/>
<%--等价于 <jsp:setProperty name="entry" property="numItems" value="<%= request.getParameter("numItem")%>"--%>

<jsp:setProperty name="entry" property="discountCode" param="discountCode"/>
<br>
<table align="center" border="1">
    <tr>
        <th>Item Id</th>
        <th>Unit Price</th>
        <th>Number Ordered</th>
        <th>Total Price</th>
    </tr>
    <tr align="right">
        <td><jsp:getProperty name="entry" property="itemId"/></td>

        <td>$<jsp:getProperty name="entry" property="itemCost"/></td>

        <td><jsp:getProperty name="entry" property="numItems"/></td>
        <%-- out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.googol24.jsp.bean.SaleEntry)_jspx_page_context.findAttribute("entry")).getNumItems()))); --%>

        <td>$<jsp:getProperty name="entry" property="totalCost"/></td>
    </tr>
</table>
</body>
</html>
