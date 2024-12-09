package Items;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.user;
import user.userDAO;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		adminDAO adDAO = new adminDAO();
		admin admin = adDAO.validate(username, password);
		
		if (admin != null) {
            // Login successful, set user in session
            HttpSession session = request.getSession();
            session.setAttribute("admin_id", admin.getId());
            //session.setAttribute("user_name", admin.getName());
            response.sendRedirect("home.jsp"); // Redirect to the menu or home page
        } else {
            // Login failed, redirect back to login page
            response.sendRedirect("login.jsp?error=Invalid username or password");
        }
		
	}

}
