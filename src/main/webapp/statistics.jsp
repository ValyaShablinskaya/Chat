
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Statistics</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/admin/statistics">
    Statistics  <br> <br> <br>
        <c:forEach items="${requestScope.data}"
                   var="data">
        <tr>
            <td>${data.key}</td>
            <td>${data.value}</td>
        </tr>
            <br>
        </c:forEach>

    </table>
</form>
</body>
</html>
