
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>message</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/message">
    <p class="select">
        Message  <br> <br> <br>

    <table>
        <tr>
            <th>Message messageSendingDate</th>
            <th>Message fromWhom</th>
            <th>Message toWhom</th>
            <th>Message text</th>


        </tr>
        <c:forEach items="${messages}" var="message">
            <tr>
                <td>
                    <c:out value="${message.getMessageSendingDate()}"/>
                </td>
                <td>
                    <c:out value="${message.getFromWhom().login}"/>
                </td>
                <td>
                    <c:out value="${message.getToWhom().login}"/>
                </td>
                <td>
                    <c:out value="${message.getText()}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<br>
<form method="post" action="${pageContext.request.contextPath}/api/message">
        Write a message  <br>
    <h5>User login:</h5>
    <input type="text" name="login">
    <h5>Text:</h5>
    <input type="text" name="message">

    <p><input type="submit" name="submit_btn" value="Send message"></p>
</form>
</body>
</html>
