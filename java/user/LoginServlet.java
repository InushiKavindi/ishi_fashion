package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		userDAO usDAO = new userDAO();
		user user = usDAO.validate(email, password);
//		
//		if(user != null) {
//			request.setAttribute(password, user);
//			request.setAttribute(email, user);
//			response.sendRedirect("home.jsp");
//		}
//		else {
//			response.sendRedirect("login.jsp");
//		}
		if (user != null) {
            // Login successful, set user in session
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getId());
            session.setAttribute("user_name", user.getName());
            response.sendRedirect("profile.jsp"); // Redirect to the menu or home page
        } else {
            // Login failed, redirect back to login page
            response.sendRedirect("login.jsp?error=Invalid email or password");
        }

	}

}
