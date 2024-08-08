<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/7/2024
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Customer</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="home-page.jsp">
        <img src="images/logoTH.png" alt="Logo" style="height: 40px;"> MyApp
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="home-page.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="customers?action=list">Customers</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">
                    <i class="fas fa-sign-in-alt"></i> Login
                </a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h2 class="mb-4">Edit Customer</h2>
    <form action="customers?action=edit" method="post">
        <input type="hidden" name="phoneNumber" value="${customer.phoneNumber}">

        <div class="mb-3">
            <label for="fullName" class="form-label">Full Name:</label>
            <input type="text" id="fullName" name="fullName" class="form-control" value="${customer.fullName}" required>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" id="email" name="email" class="form-control" value="${customer.email}" required>
        </div>

        <div class="mb-3">
            <label for="userName" class="form-label">Username:</label>
            <input type="text" id="userName" name="userName" class="form-control" value="${customer.userName}" required>
        </div>

        <button type="submit" class="btn btn-primary">Update Customer</button>
    </form>
    <a href="customers?action=list" class="btn btn-secondary mt-3">Back to Customer List</a>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9zOMhb4NqV3O9MefR2WmtwYmPIt2p6z4d8BQ69y3L+cR6V7TkT+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-hfXyPTLcbm5T1g2c2vCw3kI6+enDZpBihk1oCmB7Zn5QybzZJShclF4h6xY0G9X8+" crossorigin="anonymous"></script>
</body>
</html>