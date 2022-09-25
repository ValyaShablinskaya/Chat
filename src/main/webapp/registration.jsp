<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<p>Welcome, please fill out the form to continue.</p>
<form method="post" action="${pageContext.request.contextPath}/api/user">
    <ul>
        <li class="text-info">Login: </li>
        <li><input type="text" name="login"></li>
    </ul>
    <ul>
        <li class="text-info">Password: </li>
        <li><input type="password" name="password"></li>
    </ul>
    <ul>
        <li class="text-info">Full name: </li>
        <li><input type="text" name="fullName"></li>
    </ul>
    <ul>
        <li class="text-info">Birthday: </li>
        <li><input type="date" name="birthday" pattern="yyyy-MM-dd"></li>
    </ul>
    <input type="submit" class="btn btn-dark" value="Register Now">
</form>
</body>
</html>