<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="user.user" %>
<%@ page import="user.userDAO" %>

<%

Integer id = (Integer) session.getAttribute("user_id");
if (id == null) {
    response.sendRedirect("login.jsp"); // Redirect to login if user is not logged in
    return; // Prevent further execution
}

userDAO usDAO = new userDAO();
user user = usDAO.getUserById(id);

if (user == null) {
    response.sendRedirect("login.jsp"); // Redirect if user not found
    return; // Prevent further execution
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/updateProfile.css">

<title>Update profile</title>
</head>
<body>




<form action="updateUserServlet" method="post">
    <input type="hidden" name="id" value="<%= user.getId() %>">
    <span>Name: </span><input type="text" name="name" placeholder="Name" value="<%= user.getName() %>" required><br>
    <span>Email: </span><input type="email" name="email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" value="<%= user.getEmail() %>" required><br>
    <span>Password: </span><input type="password" name="password" placeholder="Password" value="<%= user.getPassword() %>" required><br>
    <span>Phone: </span><input type="text" name="phone" placeholder="Phone" pattern="[0-9]{10}" value="<%= user.getPhone() %>" required><br>
    <span>Address: </span><input type="text" name="address" placeholder="Address" value="<%= user.getAddress() %>" required><br>
    <input type="submit" value="Update">
</form>



</body>
</html>