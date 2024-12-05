package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int id = Integer.parseInt(request.getParameter("id"));

        userDAO userDAO = new userDAO();

        // Only the id is required for deletion
        user deleteUser = new user();
        deleteUser.setId(id);

        boolean delete = userDAO.deleteUser(deleteUser);

        if (delete) {
            // Redirect to the register page after successful deletion
            response.sendRedirect("home.jsp");
        } else {
            // Redirect back to profile page with error message
            response.sendRedirect("profile.jsp?error=Deletion failed");
        }
	}

}
