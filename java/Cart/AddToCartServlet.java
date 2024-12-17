package Cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Items.Item;
import Items.ItemDAO;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        String category = request.getParameter("category"); // Get category from request

        // Get the item from the database using the itemId
        ItemDAO itemDAO = new ItemDAO();
        Item item = itemDAO.getItemById(itemId);

        // Get the session and retrieve the cart (if it exists)
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // If cart doesn't exist, create a new one
        if (cart == null) {
            cart = new Cart();
        }

        // Add the item to the cart
        cart.addItem(item);

        // Save cart and current category in session
        session.setAttribute("cart", cart);
        session.setAttribute("currentCategory", category);

        // Redirect to the cart page
        response.sendRedirect("Cart.jsp");
    }
}
