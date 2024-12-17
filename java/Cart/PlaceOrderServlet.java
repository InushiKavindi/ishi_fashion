package Cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the session and retrieve the cart
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart != null && !cart.getItems().isEmpty()) {
            // Process the order (e.g., save order details to the database)
            // This is where you can integrate order storage logic
            
            // For now, simulate order processing
            System.out.println("Order placed successfully!");

            // Clear the cart after placing the order
            session.removeAttribute("cart");

            // Redirect to a confirmation page
            response.sendRedirect("OrderConfirmation.jsp");
        } else {
            // If the cart is empty, redirect back to the cart page
            response.sendRedirect("Cart.jsp");
        }
    }
}
