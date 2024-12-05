<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%@ page import="user.user" %>
<%@ page import="user.userDAO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/profile.css">
    <title>Profile</title>
</head>
<body>
<%
    Integer id = (Integer) session.getAttribute("user_id");
    userDAO usDAO = new userDAO();
    user user = usDAO.getUserById(id);
%>



<!-- Main content -->
<div class="main-content">
    <div class="profile-container">
        <div class="profile-header">
            <h1>Welcome</h1>
        </div>
        <div class="profile-details">
            <p><span>Name:</span> <%= user.getName() %></p>
            <p><span>Email:</span> <%= user.getEmail() %></p>
            <p><span>Phone:</span> <%= user.getPhone() %></p>
            <p><span>Address:</span> <%= user.getAddress() %></p>
        </div>
        <div class="button-container">
            <div class="Update-button">
                <form action="updateProfile.jsp" method="post">
                    <input type="hidden" name="id" value="<%= user.getId() %>">
                    <button type="submit" class="Update-link">Update</button>
                </form>
            </div>
            <div class="Delete-button">
                <form action="DeleteAccountServlet" method="post">
                    <input type="hidden" name="id" value="<%= user.getId() %>">
                    <button type="submit" class="Delete-link" 
                        onclick="return confirm('Are you sure you want to delete this account?');">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
