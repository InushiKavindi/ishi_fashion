<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>Admin</title>
</head>
<body>



    <!-- Main content -->
    <div class="main-content">
        <form action="AdminLoginServlet" method="post" class="login-form">
            <input type="text" name="username" placeholder="Username"  required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Login">
            <!-- Registration Text and Link -->
            <div class="register-text">
                Don't have an account? 
                <a href="register.jsp" class="register-link">Register here</a>
            </div>
        </form>
    </div>

    

</body>
</html>