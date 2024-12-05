<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/register.css">
    <title>Register</title>
</head>
<body>
    

    <!-- Main content wrapper -->
    <div class="content-container">
        <div class="modal-background">
            <form action="RegisterServlet" method="post" class="register-form">
                <input type="text" name="name" placeholder="Name" required>
                <input type="email" name="email" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="text" name="phone" placeholder="Phone" pattern="[0-9]{10}" required>
                <input type="text" name="address" placeholder="Address" required>
                <input type="submit" value="Sign up">
                <!-- Registration Text and Link -->
                <div class="login-text">
                    Already have an account? 
                    <a href="login.jsp" class="login-link">Login</a>
                </div>
            </form>
        </div>
    </div>

    
</body>
</html>
