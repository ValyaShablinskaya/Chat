
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signUp';" value="Register" /></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signIn';" value="Enter" /></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/api/message';" value="Send message" /></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/chats';" value="Messages" /></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/admin/statistics';" value="Statistic" /></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/logOut';" value="Exit" /></p>

</body>
</html>
