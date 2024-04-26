<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="fragments/headTag.jsp"/>
<head>
    <title>Budgettracker</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/sign-in.css">
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
    <script src="webjars/bootstrap/5.3.3/css/bootstrap.min.css"></script>
</head>
<body class="d-flex align-items-center py-4 bg-body-tertiary">

<main class="form-signin w-100 m-auto">
    <form id="login_form" method="post">
        <img class="mb-4" src="${contextPath}/resources/images/logo.svg" alt="" width="72" height="57">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <input type="email" class="form-control" id="email" placeholder="name@example.com">
            <label for="email">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" placeholder="Password">
            <label for="password">Password</label>
        </div>

        <%--<div class="form-check text-start my-3">
            <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
            <label class="form-check-label" for="flexCheckDefault">
                Remember me
            </label>
        </div>--%>
        <button class="btn btn-primary w-100 py-2" type="submit">Sign in</button>
        <br/>
        <p>Don't have an account?
        <a href="#" data-bs-toggle="modal" data-bs-target="#registrationModal">Signup</a>
        </p>
        <p class="mt-5 mb-3 text-body-secondary">&copy; Budget Tracker</p>
    </form>

    <div class="modal fade" id="registrationModal" tabindex="-1" aria-labelledby="registrationModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="registrationModalLabel">Registration</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="registrationForm" method="post" action="${contextPath}/profile/register">
                        <div class="mb-3">
                            <label for="regEmail" class="form-label">Email address</label>
                            <input type="email" class="form-control" id="regEmail" required>
                        </div>
                        <div class="mb-3">
                            <label for="regPassword" class="form-label">Password</label>
                            <input type="password" class="form-control" id="regPassword" required>
                        </div>
                        <div class="mb-3">
                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" required>
                            <div id="passwordMismatch" class="invalid-feedback">Passwords do not match</div>
                        </div>
                        <input type="hidden" name="action" value="register">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

<script>
    document.getElementById('registrationForm').addEventListener('submit', function(event) {
        var password = document.getElementById('regPassword').value;
        var confirmPassword = document.getElementById('confirmPassword').value;
        if (password !== confirmPassword) {
            document.getElementById('confirmPassword').classList.add('is-invalid');
            document.getElementById('passwordMismatch').style.display = 'block';
            event.preventDefault(); // Предотвращаем отправку формы
        } else {
            document.getElementById('confirmPassword').classList.remove('is-invalid');
            document.getElementById('passwordMismatch').style.display = 'none';
        }
    });
</script>
</body>
</html>
