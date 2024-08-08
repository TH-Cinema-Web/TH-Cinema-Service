<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/6/2024
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
</head>
<body>
<h2>Add New Customer</h2>
<form action="customers?action=create" method="post">
    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" required><br><br>

    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="userName">Username:</label>
    <input type="text" id="userName" name="userName" required><br><br>

    <input type="submit" value="Add Customer">
</form>
<a href="customers?action=list">Back to Customer List</a>
</body>
</html>
