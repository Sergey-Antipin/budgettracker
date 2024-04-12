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

        table {
            width: 50%;
            border-collapse: collapse;
            font-weight: bold;
        }

        table th, td {
            border: black solid 2px;
            padding: 8px;
        }

        .excess {
            background-color: rgba(255, 182, 193, 0.5);
        }

    </style>
</head>
<body>
<table class="table">
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
    <jsp:useBean id="user" scope="request" type="com.example.budgettracker.dto.UserDto"/>
    <jsp:useBean id="account" scope="request" class="com.example.budgettracker.dto.AccountDto"/>
    <jsp:useBean id="operation" scope="request" class="com.example.budgettracker.dto.OperationDto"/>
    <c:forEach items="${requestScope.operationlist}" var="op">
        <tr class="${op.money.positive ? 'income' : 'expense'} ${op.excess ? ' excess' : ''}">
            <td>${op.date}</td>
            <td>${op.money}</td>
            <td>${op.description}</td>
            <td>${op.operationCategory}</td>
            <td>${op.excess}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>
</body>
</html>