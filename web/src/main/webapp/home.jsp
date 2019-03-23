<%@ page import="com.educacionit.mysocials.beans.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User us = (User)session.getAttribute ("user");
    out.println (us.getEmail());
%>
</body>
</html>
