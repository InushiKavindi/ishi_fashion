<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<!-- header -->
    <jsp:include page="header.jsp" />
    <header>
        <h1>Welcome to Our Website!</h1>
        <nav>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="services.jsp">Services</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section>
            <h2>Featured Content</h2>
            <p>Explore our latest offerings and updates.</p>
            <img src="images/featured.jpg" alt="Featured Image" />
        </section>
        
        <section>
            <h2>Latest News</h2>
            <p>Stay updated with our recent news and articles.</p>
            <ul>
                <li><a href="news1.jsp">News Article 1</a></li>
                <li><a href="news2.jsp">News Article 2</a></li>
                <li><a href="news3.jsp">News Article 3</a></li>
            </ul>
        </section>
    </main>

    
    
    <!-- footer -->
    <jsp:include page="footer.jsp" />
    
</body>
</html>
