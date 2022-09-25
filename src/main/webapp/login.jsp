
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/api/login">
        <h5>User login:</h5>
        <input type="text" name="login">
        <h5>Password:</h5>
        <input type="password" name="password">
        <input type="submit" class="btn btn-dark" value="Login">
</form>
</body>
</html>
