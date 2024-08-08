<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="${pageContext.request.contextPath}/image/background1.jpg" width="1200" height="300">
        </a>
    </div>
</nav>

<div class="container mt-5">
    <h2>Customer List</h2>
    <form action="/customers" method="get" class="mb-3">
        <input type="hidden" name="action" value="search">
        <div class="input-group">
            <input type="text" name="name" class="form-control" placeholder="Search by name">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Phone Number</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Username</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.phoneNumber}</td>
                <td>${customer.fullName}</td>
                <td>${customer.email}</td>
                <td>${customer.userName}</td>
                <td>
                    <a href="/customers?action=edit&phoneNumber=${customer.phoneNumber}" class="btn btn-warning">Edit</a>
                    <a href="/customers?action=delete&phoneNumber=${customer.phoneNumber}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/admin-page.jsp" class="btn btn-secondary mt-3">Back to Admin Page</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9zOMhb4NqV3O9MefR2WmtwYmPIt2p6z4d8BQ69y3L+cR6V7TkT+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-hfXyPTLcbm5T1g2c2vCw3kI6+enDZpBihk1oCmB7Zn5QybzZJShclF4h6xY0G9X8+" crossorigin="anonymous"></script>
</body>
</html>