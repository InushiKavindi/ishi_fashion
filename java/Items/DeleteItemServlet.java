package Items;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemId = request.getParameter("id");

        if (itemId != null) {
            try {
                int id = Integer.parseInt(itemId);

                // Delete the item from the database
                ItemDAO itemDAO = new ItemDAO();
                itemDAO.deleteItem(id);
                
                // After deletion, retrieve the updated list of items
                List<Item> items = itemDAO.getAllItems();  // Make sure you have a method like this in your DAO
                request.setAttribute("items", items);
                
                // Forward to the items.jsp page to display the updated list
                request.getRequestDispatcher("items.jsp").forward(request, response);
                
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
