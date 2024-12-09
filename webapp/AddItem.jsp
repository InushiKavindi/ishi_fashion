<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/AddItem.css">
    
    <title>Add New Item</title>

    <script>
        // Function to validate the price field
        function validatePrice() {
            var price = document.getElementById("price").value;
            if (parseFloat(price) <= 0 || isNaN(price)) {
                alert("Please enter a price greater than zero.");
                return false; // Prevent form submission
            }
            return true; // Allow form submission
        }
    </script>

</head>
<body>

<jsp:include page="dashboard.jsp" />

    <!-- Add Item Form -->
    <div class="add-item">
        <h2>Add New Item</h2>
        <form action="AddItemServlet" method="post" onsubmit="return validatePrice()">
            <input type="text" name="i_name" placeholder=" Item Name" required><br>
            
            <!-- Category dropdown -->
           <select name="category" id="category" required>
			    <option value=""disabled selected>Choose a Category</option>
			    <option value="Men">Men</option>
			    <option value="Women">Women</option>
			</select><br>

           
            <input type="number" step="0.01" id="price" name="price" placeholder=" Price" required><br>
            <textarea name="description" placeholder="Description" required></textarea><br>
            <input type="url" name="image" placeholder=" Image URL" required><br>
            <input type="submit" value="Add Item">
        </form>
    </div>

    

</body>
</html>
