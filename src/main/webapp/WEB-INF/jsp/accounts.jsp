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
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1>Accounts</h1>
            <table id="operations-table" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Description</th>
                    <th>Currency</th>
                    <th>Amount</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${accounts}" var="acc">
                    <tr>
                        <td hidden="hidden">${acc.id}</td>
                        <td>${acc.description}</td>
                        <td>${acc.balance.currencyUnit.code}</td>
                        <td>${acc.balance.amount}</td>
                        <td>
                            <button>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-trash" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"></path>
                                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"></path>
                                </svg>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button type="button" class="btn btn-primary w-25 mb-3" id="addAccountButton"
                    data-bs-toggle="modal" data-bs-target="#addAccountModal">Add account
            </button>
        </div>
    </div>
</div>

<div class="modal fade" id="addAccountModal" tabindex="-1" aria-labelledby="addAccountModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addAccountModalLabel">Add Account</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="addAccountForm" action="${contextPath}/accounts" method="post">
                    <div class="mb-3">
                        <label for="description" class="form-label">Description</label>
                        <input type="text" class="form-control" id="description" name="description" required>
                    </div>
                    <div class="mb-3">
                        <label for="currency" class="form-label">Currency</label>
                        <select class="form-select" id="currency" name="currency" required>
                            <option value="RUB">RUB</option>
                            <option value="USD">USD</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="amount" class="form-label">Amount</label>
                        <input type="number" step="0.01" class="form-control" id="amount" name="amount" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Account</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#showFormButton').on('click', function () {
            $('#addOperationForm').show();
            $('#showFormButton').hide();
        });

        $('#hideFormButton').on('click', function () {
            $('#addOperationForm').hide();
            $('#showFormButton').show();
        });
    });
</script>
</body>
</html>
