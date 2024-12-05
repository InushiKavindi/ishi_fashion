<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>

<!-- header -->
    <jsp:include page="header.jsp" />

    <!-- Main content -->
    <div class="main-content">
        <form action="AdminLoginServlet" method="post" class="login-form">
            <input type="email" name="email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Login">
            <!-- Registration Text and Link -->
            <div class="register-text">
                Don't have an account? 
                <a href="register.jsp" class="register-link">Register here</a>
            </div>
        </form>
    </div>

    <!-- footer -->
    <jsp:include page="footer.jsp" />

</body>
</html>