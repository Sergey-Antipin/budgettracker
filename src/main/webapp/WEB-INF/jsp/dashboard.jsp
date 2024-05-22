<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<jsp:include page="fragments/header.jsp"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<head>
    <title>Dashboard</title>
    <script src="webjars/jquery/jquery.min.js"></script>
    <script src="webjars/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="webjars/datatables/js/jquery.dataTables.min.js"></script>
    <script src="webjars/datatables/css/dataTables.bootstrap5.min.css"></script>
    <style>
        .col-md-2to3 {
            flex: 0 0 auto;
            width: 20%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <!-- Left section for accounts -->
        <div class="col-md-2to3 account-list border-end border-5">
            <h2>Accounts</h2>
            <ul class="list-group mb-3">
                <c:forEach var="account" items="${accounts}">
                    <li class="list-group-item">${account.description}</li>
                </c:forEach>
            </ul>
            <a href="${contextPath}/accounts">
                <button type="button" class="btn btn-primary w-100 mb-3" id="addAccountButton">
                    Accounts
                </button>
            </a>
        </div>
        <!-- Right section for operations and form -->
        <div class="col-md-9">
            <h1>Account Operations</h1>
            <div class="row mb-3">
                <div class="col">
                    <button type="button" class="btn btn-primary" id="showExpenseFormButton" data-type="expense">
                        Add expense
                    </button>
                    <button type="button" class="btn btn-primary" id="showIncomeFormButton" data-type="income">
                        Add income
                    </button>
                </div>
            </div>
            <div class="row mb-3" id="addOperationForm" style="display: none;">
                <div class="col">
                    <form action="${contextPath}/dashboard" method="post">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="accountId" class="form-label">Account</label>
                                    <select id="accountId" class="form-select" name="accountId" required>
                                        <c:forEach items="${accounts}" var="account">
                                            <option value="${account.id}">${account.description}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="date" class="form-label">Date</label>
                                    <input id="date" type="date" class="form-control" name="date" required/>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <label for="amount" class="form-label">Money</label>
                                    <input id="amount" type="number" step="0.01" class="form-control" name="amount"
                                           required/>
                                </div>
                            </div>
                            <div class="col-md-3" id="expenseCategoryField">
                                <div class="form-group">
                                    <label for="expenseCategory" class="form-label">Category</label>
                                    <select id="expenseCategory" class="form-select" name="category">
                                        <c:forEach items="${expenseCategories}" var="category">
                                            <option value="${category}">${category}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3" id="incomeCategoryField">
                                <div class="form-group">
                                    <label for="incomeCategory" class="form-label">Category</label>
                                    <select id="incomeCategory" class="form-select" name="category">
                                        <c:forEach items="${incomeCategories}" var="category">
                                            <option value="${category}">${category}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="description" class="form-label">Description</label>
                                    <textarea class="form-control" id="description" name="description"
                                              rows="2"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col">
                                <button type="button" class="btn btn-secondary" id="hideFormButton">
                                    Cancel
                                </button>
                                <button type="submit" class="btn btn-primary">Add Operation</button>
                            </div>
                        </div>
                        <input id="operationType" name="operationType" type="hidden">
                    </form>
                </div>
            </div>
            <table id="operations-table" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Money</th>
                    <th>Category</th>
                    <th>Account</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${operations}" var="op">
                    <tr>
                        <td>${op.date}</td>
                        <td>${op.money}</td>
                        <td>${op.category}</td>
                        <td>${accountDescriptions[op.accountId]}</td>
                        <td>${op.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#showExpenseFormButton').on("click", function () {
            $('#addOperationForm').show();
            $('#showExpenseFormButton').hide();
            $('#showIncomeFormButton').hide();
            $('#expenseCategoryField').show();
            $('#incomeCategoryField').hide().empty();
            $('#operationType').val('expense');
        });

        $('#showIncomeFormButton').on("click", function () {
            $('#addOperationForm').show();
            $('#showExpenseFormButton').hide();
            $('#showIncomeFormButton').hide();
            $('#expenseCategoryField').hide().empty();
            $('#incomeCategoryField').show();
            $('#operationType').val('income');
        });

        $('#hideFormButton').on("click", function () {
            $('#addOperationForm').hide();
            $('#showExpenseFormButton').show();
            $('#showIncomeFormButton').show();
            $('#operationType').val('');
        });

        $('#operations-table').DataTable();
    });
</script>

</body>
</html>
