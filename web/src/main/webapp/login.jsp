<%@  page contentType="text/html;charset=UTF-8" language="java" session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form method="post" action="login">
        <input type="text" name="user">
        <br>
        <input type="password" name="pw">
        <br>
        <input type="submit" value="Login">
    </form>
    <%
        if (request.getParameter ("msg") != null && request.getParameter ("msg").equals ("ERR001")) {

            out.println ("<h2>User and Password invalid !!!</h2>");

        } else if (request.getParameter ("msg") != null && request.getParameter ("msg").equals ("ERR000")) {

            out.println ("<h2>Sorry... there is a problem...Try Again !!!</h2>");
        }
    %>
</body>
</html>