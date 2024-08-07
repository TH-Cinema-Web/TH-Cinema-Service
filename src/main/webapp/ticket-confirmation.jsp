<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/7/2024
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ticket Confirmation - TH Cinema</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <i class="fas fa-home"></i> Home
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="home-page.jsp">List Films</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="book-tickets.jsp">Tickets <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${sessionScope.username != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="logout">
                            <i class="fas fa-sign-out-alt"></i> Logout
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">
                            <i class="fas fa-sign-in-alt"></i> Login
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h1>Ticket Confirmation</h1>
    <div class="alert alert-success" role="alert">
        Your ticket(s) have been successfully booked!
    </div>
    <a href="home-page.jsp" class="btn btn-primary">Back to Home</a>
</div>
</body>
</html>


