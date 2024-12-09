package Items;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String i_name = request.getParameter("i_name");
        String category = request.getParameter("category");
        String priceStr = request.getParameter("price");
        String description = request.getParameter("description");
        String image = request.getParameter("image");

        // Validate price to ensure it's greater than 0
        double price = 0;
        try {
            price = Double.parseDouble(priceStr);
            if (price <= 0) {
                request.setAttribute("error", "Price must be greater than zero");
                request.getRequestDispatcher("AddItem.jsp").forward(request, response);
                return; // Stop further processing if price is invalid
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid price format");
            request.getRequestDispatcher("AddItem.jsp").forward(request, response);
            return;
        }

        // If price is valid, proceed with adding the item
        Item newItem = new Item(0, i_name, category, price, description, image);
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.addItem(newItem);

        // Now that the item is added, fetch the updated list of items
        List<Item> items = itemDAO.getAllItems(); // Get updated list of items
        request.setAttribute("items", items); // Set items as request attribute

        // Forward to items.jsp to display the updated item list
        request.getRequestDispatcher("items.jsp").forward(request, response);
    }
}
