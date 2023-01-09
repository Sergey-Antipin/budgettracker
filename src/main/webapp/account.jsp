<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<table>
    <thead>
    <tr>
        <th scope="col">Date</th>
        <th scope="col">Sum</th>
        <th scope="col">Description</th>
        <th scope="col">Expense Category</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${user.email}</td>
        <td>${testing}</td>
    </tr>
    <c:forEach var="acc" items="${user.accounts}">
        <c:forEach var="op" items="${acc.operations}">
            <tr>
                <td>${op.date}</td>
                <td>${op.amount}</td>
                <td>${op.description}</td>
            </tr>
        </c:forEach>
    </c:forEach>
    </tbody>
</table>
<h3><a href="index.html">Home</a></h3>
<hr>
</body>
<head>
    <title>Account</title>
</head>
</html>
