<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
  
</head>
<body>
    

    <!-- Main content -->
    <div class="main-content">
        <form action="LoginServlet" method="post" class="login-form">
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

    
</body>
</html>
