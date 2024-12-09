package Cart;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Items.Item;
import Items.ItemDAO;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");  // Get the category from the form

        // Fetch items from the database
        ItemDAO itemDAO = new ItemDAO();
        List<Item> items = itemDAO.getItemsByCategory(category);

        // Set the items as a request attribute
        request.setAttribute("items", items);

        // Dynamically forward to the correct JSP
        String targetPage = category + ".jsp";  // e.g., "kids.jsp" for "kids" category
        request.getRequestDispatcher(targetPage).forward(request, response);
    }
}