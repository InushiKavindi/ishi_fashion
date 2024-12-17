<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Cart.Cart" %>
<%@ page import="Items.Item" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="css/Cart.css"> <!-- Link to your CSS file -->
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        String currentCategory = (String) session.getAttribute("currentCategory");
    %>

    <%
        if (cart != null && !cart.getItems().isEmpty()) {
    %>
    <table border="1">
        <thead>
            <tr>
                <th>Image</th>
                <th>Item</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Item item : cart.getItems()) {
            %>
            <tr>
                <td><img src="<%= item.getImage() %>" alt="<%= item.getI_name() %>" style="width: 50px; height: 50px;"></td>
                <td><%= item.getI_name() %></td>
                <td>$<%= item.getPrice() %></td>
                <td>
                    <form action="UpdateQuantityServlet" method="post">
                        <input type="hidden" name="itemId" value="<%= item.getId() %>">
                        <input type="number" name="quantity" value="<%= cart.getItemQuantity(item) %>" min="1">
                        <button type="submit">Update</button>
                    </form>
                </td>
                <td>$<%= item.getPrice() * cart.getItemQuantity(item) %></td>
                <td>
				    <form action="RemoveItemServlet" method="post" onsubmit="return confirmRemoval();">
				        <input type="hidden" name="itemId" value="<%= item.getId() %>">
				        <button type="submit">Remove</button>
				    </form>
				</td>

            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <p><strong>Total Price:</strong> $<%= cart.getTotalPrice() %></p>

    <!-- Continue Shopping Button -->
    <%
        if (currentCategory != null) {
    %>
    <form action="<%= currentCategory %>.jsp" method="get" style="margin-top: 20px;">
        <button type="submit">Continue Shopping</button>
    </form>
    <%
        } else {
    %>
    <p><a href="index.jsp">Continue Shopping</a></p>
    <%
        }
    %>

    <!-- Place Order Button -->
    <form action="PlaceOrderServlet" method="post" style="margin-top: 20px;">
        <button type="submit">Place Order</button>
    </form>
    <%
        } else {
    %>
        <p>Your cart is empty.</p>
    <%
        }
    %>
    <script>
    function confirmRemoval() {
        return confirm("Are you sure you want to remove this item from your cart?");
    }
</script>
    
    
</body>
</html>
