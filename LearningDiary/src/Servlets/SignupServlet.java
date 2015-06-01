package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Domain.Users;
import Managers.UsersManager;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet({ "/SignupServlet", "/signup" })
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "/WEB-INF/signup.jsp";
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String url = "/WEB-INF/signup.jsp";
		if (action.equalsIgnoreCase("signup")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String verify_password = request.getParameter("verify_password");
			String email = request.getParameter("email");
			
			if( ! password.equalsIgnoreCase(verify_password) ) {
				url = "/WEB-INF/signup.jsp";
				request.setAttribute("error", "Passwords did not match. Please Try again!");
			} else {
				Users newUser =  new Users(username, verify_password, email);
				UsersManager um = new UsersManager(ds);
				request.getSession().setAttribute("isLoggedIn", true);
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("email", email);
				
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				response.sendRedirect("/main.jsp");
				try {
					 new UsersManager(ds).addUser(newUser);
					 
				} catch(SQLException e) {
					url = "/dberror.jsp";
					getServletContext().getRequestDispatcher(url).forward(request, response);
					return;
				}
				
		}
		response.sendRedirect(request.getContextPath() + "/addcategory");
		return;
			
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
