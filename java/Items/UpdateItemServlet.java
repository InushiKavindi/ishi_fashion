package Items;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateItemServlet")
public class UpdateItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get parameters from the form
            int id = Integer.parseInt(request.getParameter("id"));
            String i_name = request.getParameter("i_name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String image = request.getParameter("image");

            // Server-side validation for price
            if (price <= 0) {
                response.sendRedirect("UpdateItem.jsp?id=" + id + "&error=Price must be greater than zero");
                return;
            }

            // Create an updated Item object
            Item updatedItem = new Item(id, i_name, category, price, description, image);

            // Update item in the database
            ItemDAO itemDAO = new ItemDAO();
            itemDAO.updateItem(updatedItem);

            // Redirect to ItemListServlet to refresh the item list on items.jsp
            response.sendRedirect("ItemListServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("UpdateItem.jsp?id=" + request.getParameter("id") + "&error=Update failed");
        }
    }

}
