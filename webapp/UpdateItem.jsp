<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Items.Item" %>
<%@ page import="Items.ItemDAO" %>

<%
    String idParam = request.getParameter("id");
    Item item = null;

    if (idParam != null && !idParam.isEmpty()) {
        int id = Integer.parseInt(idParam);
        ItemDAO itemDAO = new ItemDAO();
        item = itemDAO.getItemById(id); // Fetch item details
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/UpdateItem.css">
    <link rel="stylesheet" href="css/dashboard.css">
    <title>Update Item</title>
    
    
    
</head>
<body>

<div class="side-menu">
        <div class="Dashboard-name">
            <h1>Dashboard</h1>
        </div>
        <ul>
            <li><a href="AddItem.jsp">Add Items</a></li>
            <li><a href="home.jsp">Men</a></li>
            <li><a href="home.jsp">Women</a></li>
            <li><a href="home.jsp">Kids</a></li>
        </ul>
    </div>
    
    <div class="form-container">
    <form action="UpdateItemServlet" method="post">
    <h2>Update Item</h2>
        <input type="hidden" name="id" value="<%= item != null ? item.getId() : "" %>">
        <input type="text" name="i_name" placeholder="Item Name" value="<%= item != null ? item.getI_name() : "" %>" required><br>
        <select name="category" required>
            <option value="Men" <%= item != null && "Men".equals(item.getCategory()) ? "selected" : "" %>>Men</option>
            <option value="Women" <%= item != null && "Women".equals(item.getCategory()) ? "selected" : "" %>>Women</option>
        </select><br>
        <input type="number" step="0.01" name="price" placeholder="Price" value="<%= item != null ? item.getPrice() : "" %>" required min="0.01" oninvalid="this.setCustomValidity('Price must be greater than zero.')" oninput="this.setCustomValidity('')"><br>

        <textarea name="description" placeholder="Description" required><%= item != null ? item.getDescription() : "" %></textarea><br>
        <input type="url" name="image" placeholder="Image URL" value="<%= item != null ? item.getImage() : "" %>" required><br>
        <input type="submit" value="Update Item">
    </form>
    </div>
</body>
</html>
