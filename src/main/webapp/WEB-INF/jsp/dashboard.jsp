<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Accounts</title>
    <script src="webjars/jquery/jquery.min.js"></script>
    <script src="webjars/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="webjars/datatables/js/jquery.dataTables.min.js"></script>
    <script src="webjars/datatables/css/dataTables.bootstrap5.min.css"></script>
</head>
<body>
<div class="container">
    <h1>Account Operations</h1>
    <div class="row">
        <div class="col">
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    Select Account
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <li><a class="dropdown-item" href="#">Account 1</a></li>
                    <li><a class="dropdown-item" href="#">Account 2</a></li>
                    <li><a class="dropdown-item" href="#">Account 3</a></li>
                </ul>
            </div>
        </div>
    </div>
    <table id="operations-table" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Date</th>
            <th>Money</th>
            <th>Category</th>
            <th>Description</th>
            <th>Account</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function () {
        $('#dataTable').DataTable();
    });
</script>
</body>
</html>
