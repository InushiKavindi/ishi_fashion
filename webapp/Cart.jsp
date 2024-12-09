<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Cart.Cart" %>
<%@ page import="Items.Item" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <%
        // Get the cart from the session
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null && !cart.getItems().isEmpty()) {
    %>
        <ul>
            <%
                // Display each item in the cart
                for (Item item : cart.getItems()) {
            %>
                <li>
                    <%= item.getI_name() %> - $<%= item.getPrice() %>
                </li>
            <%
                }
            %>
        </ul>
        <p><strong>Total Price:</strong> $<%= cart.getTotalPrice() %></p>
    <%
        } else {
    %>
        <p>Your cart is empty.</p>
    <%
        }
    %>
</body>
</html>
