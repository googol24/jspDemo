<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-01-08
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <tr>
        <td>

        </td>
        <td>
            <%
                out.println("Hi: " + request.getParameter("name"));
            %>
        </td>
    </tr>
</table>
