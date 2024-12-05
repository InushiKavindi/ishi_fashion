package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		
		user updatedUser = new user(id, name, email, password, phone, address);
        userDAO userDAO = new userDAO();

        boolean success = userDAO.updateUser(updatedUser);
		
		if(success) {
			response.sendRedirect("profile.jsp"); // Redirect to the update Profile page
		}
		else {
			response.sendRedirect("register.jsp?error=Invalid email or password");
		}
	}

}
