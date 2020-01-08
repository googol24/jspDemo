<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>

<%= DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()) %>
