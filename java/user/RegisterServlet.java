package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		userDAO usDAO = new userDAO();
		boolean regUser = usDAO.registerUser(name, email, password, phone, address);
		
		if(regUser == true) {
			response.sendRedirect("login.jsp"); // Redirect to the menu or home page
		}
		else {
			response.sendRedirect("register.jsp?error=Invalid email or password");
		}
		
	}

}
