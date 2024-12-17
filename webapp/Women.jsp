<%@ page import="java.util.*, Items.*, user.DatabaseConnectionUtil" %>
<%@ page session="false" %>
<%
    // Set default category to 'Women' if no category is passed in the request
    String category = request.getParameter("category");
    if (category == null) {
        category = "Women"; // Default to 'Women' category if no category is selected
    }

    ItemDAO itemDAO = new ItemDAO();
    List<Item> womenItems = new ArrayList<>();

    // Get all items under 'Women' category if the category is 'Women'
    if ("Women".equals(category)) {
        womenItems = itemDAO.getItemsByCategory("Women");
    } else {
        // If a specific item name is selected under the 'Women' category (e.g., skirt), fetch those items
        womenItems = itemDAO.getItemsByName(category);
    }

    
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Women's Items</title>
    <link rel="stylesheet" href="css/Category.css">
</head>
<body>

	<!-- header -->
    <jsp:include page="header.jsp" />
    
    
    <div class="sidebar">
        <h2>Categories</h2>
        <ul>
        <li><a href="Women.jsp?category=Women" <% if ("Women".equals(category)) { out.print("class='active'"); } %> >All Items</a></li>
            <li><a href="Women.jsp?category=skirt" <% if ("skirt".equals(category)) { out.print("class='active'"); } %> >Skirt</a></li>
            <li><a href="Women.jsp?category=frock" <% if ("frock".equals(category)) { out.print("class='active'"); } %> >Frocks</a></li>
            <li><a href="Women.jsp?category=blouse" <% if ("blouse".equals(category)) { out.print("class='active'"); } %> >Blouse</a></li>
            
        </ul>
    </div>

    <div class="content">
        <h1>Women's</h1>
        <div class="items">
            <%
                if (womenItems.isEmpty()) {
            %>
                <p>No items found for this category.</p>
            <%
                } else {
                    for (Item item : womenItems) {
            %>
            <div class="item">
                <img src="<%= item.getImage() %>" alt="<%= item.getI_name() %>" />
                <h3><%= item.getI_name() %></h3>
                <p>Price: $<%= item.getPrice() %></p>
                <p><%= item.getDescription() %></p>
                
                
                <!-- Add to Cart button -->
		    <form action="AddToCartServlet" method="post">
		        <input type="hidden" name="itemId" value="<%= item.getId() %>" />
		        <input type="hidden" name="category" value="Women"> <!-- Pass category -->
		        <input type="number" name="quantity" value="1" min="1" max="99" /> <!-- Quantity input -->
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
