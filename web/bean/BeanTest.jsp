<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--相当于 om.googol24.jsp.bean.CounterBean cb = new om.googol24.jsp.bean.CounterBean();--%>
<jsp:useBean id="cb" class="com.googol24.jsp.bean.CounterBean">
</jsp:useBean>

<%--相当于 cb.setCount(23);--%>
<jsp:setProperty name="cb" property="count" value="23"/>

<%--相当于out.write(cb.getCount())--%>
<jsp:getProperty name="cb" property="count"/>