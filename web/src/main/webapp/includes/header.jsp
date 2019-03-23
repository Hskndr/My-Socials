<%@ page import="com.educacionit.mysocials.beans.User" %>
<%
    User us = (User)session.getAttribute ("user");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println (String.format ("Welcome %s %s from %s", us.getFirstName (), us.getLastName (), us.getCountry().getName ()));
%>