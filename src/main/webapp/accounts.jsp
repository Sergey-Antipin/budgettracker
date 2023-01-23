<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Account</title>
    <style>
        .income {
            color: green;
        }
        .expense {
            color: red;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th scope="col">Date</th>
        <th scope="col">Sum</th>
        <th scope="col">Description</th>
        <th scope="col">Operation Category</th>
        <th scope="col">Excess</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="user" scope="request" type="com.example.budgettracker.model.dto.UserDTO"/>
    <c:forEach var="acc" items="${user.accounts}">
        <jsp:useBean id="acc" class="com.example.budgettracker.model.dto.AccountDTO"/>
        <c:forEach var="op" items="${acc.operations}">
            <jsp:useBean id="op" class="com.example.budgettracker.model.dto.OperationDTO"/>
            <tr class="${op.amount.positive ? 'income' : 'expense'}">
                <td>${op.date}</td>
                <td>${op.amount}</td>
                <td>${op.description}</td>
                <td>${op.operationCategory}</td>
                <td>${op.excess}</td>
            </tr>
        </c:forEach>
    </c:forEach>
    </tbody>
</table>
<h3><a href="index.html">Home</a></h3>
<hr>
</body>
</html>