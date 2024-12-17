<%@ page import="java.util.*, Items.*, user.DatabaseConnectionUtil" %>
<%@ page session="false" %>
<%
    // Set default category to 'Men' if no category is passed in the request
    String category = request.getParameter("category");
    if (category == null) {
        category = "Men"; // Default to 'Men' category if no category is selected
    }

    ItemDAO itemDAO = new ItemDAO();
    List<Item> menItems = new ArrayList<>();

    // Get all items under 'Men' category if the category is 'Men'
    if ("Men".equals(category)) {
        menItems = itemDAO.getItemsByCategory("Men");
    } else {
        // If a specific item name is selected under the 'Men' category (e.g., t-shirt), fetch those items
        menItems = itemDAO.getItemsByName(category);
    }

    
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Men's Items</title>
    <link rel="stylesheet" href="css/Category.css">
</head>
<body>
<!-- header -->
    <jsp:include page="header.jsp" />

    <div class="sidebar">
        <h2>Categories</h2>
        <ul>
        <li><a href="Men.jsp?category=Men" <% if ("Men".equals(category)) { out.print("class='active'"); } %> >All Items</a></li>
            <li><a href="Men.jsp?category=t shirt" <% if ("t shirt".equals(category)) { out.print("class='active'"); } %> >T-Shirt</a></li>
            <li><a href="Men.jsp?category=denim" <% if ("denim".equals(category)) { out.print("class='active'"); } %> >Denim</a></li>
            <li><a href="Men.jsp?category=trouser" <% if ("trouser".equals(category)) { out.print("class='active'"); } %> >Trouser</a></li>
            
        </ul>
    </div>

    <div class="content">
        <h1>Men's</h1>
        <div class="items">
            <%
                if (menItems.isEmpty()) {
            %>
                <p>No items found for this category.</p>
            <%
                } else {
                    for (Item item : menItems) {
            %>
            <div class="item">
                <img src="<%= item.getImage() %>" alt="<%= item.getI_name() %>" />
                <h3><%= item.getI_name() %></h3>
                <p>Price: $<%= item.getPrice() %></p>
                <p><%= item.getDescription() %></p>
                
                <form action="AddToCartServlet" method="post">
			        <input type="hidden" name="itemId" value="<%= item.getId() %>" />
			        <input type="hidden" name="category" value="Men"> <!-- Pass category -->
			        <input type="number" name="quantity" value="1" min="1" max="10" /> <!-- Quantity input -->
			        <button type="submit">Add to Cart</button>
		    	</form>
                
                
            </div>
            
            
            
            <%
                    }
                }
            %>
        </div>
    </div>
    
    <!-- footer -->
    <jsp:include page="footer.jsp" />
    
</body>
</html>
