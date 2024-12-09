<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="Items.Item" %>
<%@ page import="Items.ItemDAO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/items.css">
    
    <title>Item List</title>
</head>

<%
    // Fetch the list of items
    ItemDAO itemDAO = new ItemDAO();
    List<Item> items = itemDAO.getAllItems(); // Declare and populate items only once
%>

<body>
    
    <jsp:include page="dashboard.jsp" />

    <div class="main-content">
        <h2>Item List</h2>    

        <!-- Item Table -->
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Item Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Image</th>
                    
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    // Use the declared "items" list here without redeclaring
                    if (items != null && !items.isEmpty()) {
                        for (Item item : items) {
                %>
                    <tr>
                        <td><%= item.getId() %></td>
                        <td><%= item.getI_name() %></td>
                        <td><%= item.getCategory() %></td>
                        <td><%= item.getPrice() %></td>
                        <td><%= item.getDescription() %></td>
                        <td>
                            <img src="<%= item.getImage() %>" alt="Item Image" width="100" height="100">
                        </td>
                        <td>
                            <!-- Delete Button -->
                            <form id="deleteForm-<%= item.getId() %>" action="DeleteItemServlet" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="<%= item.getId() %>">
                                <button type="button" class="delete-btn" onclick="confirmDelete(<%= item.getId() %>)">Delete</button>
                            </form>

                            <!-- Update Action -->
                            <button type="button" class="update-btn" onclick="window.location.href='UpdateItem.jsp?id=<%= item.getId() %>'">Update</button>
                        </td>
                    </tr>
                <% 
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="6">No items found</td>
                    </tr>
                <% 
                    }
                %>
            </tbody>
        </table>

        <script>
            // Confirmation popup for delete action
            function confirmDelete(itemId) {
                console.log("Delete button clicked for item ID: " + itemId); // Debugging
                if (confirm("Are you sure you want to delete this item?")) {
                    document.getElementById("deleteForm-" + itemId).submit();
                }
            }
        </script>

    </div>
</body>
</html>
