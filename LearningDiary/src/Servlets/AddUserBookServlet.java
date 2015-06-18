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

import Managers.UserBooksManager;

@WebServlet({ "/AddUserBookServlet", "/addUserBook" })
public class AddUserBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MyDB")
	DataSource ds;
   
    public AddUserBookServlet() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	getServletContext().getRequestDispatcher("/WEB-INF/adduserbook.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getContextPath() + "/userBooks";
		boolean addedUserBook = false;
		HttpSession session = request.getSession();
		
		int user_id = (Integer)session.getAttribute("user_id");
		String image = request.getParameter("image");
		String name = request.getParameter("name");
		String book_format = request.getParameter("book_format");
		String notes = request.getParameter("notes");
		
		try {
			addedUserBook = new UserBooksManager(ds).addUserBook(user_id, image, name, book_format, notes);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(addedUserBook != true) {
			request.setAttribute("error", "database failed to update the book");
			url = "/WEB-INF/addUserBook";
			request.setAttribute("user_id", user_id);
			request.setAttribute("image", image);
			request.setAttribute("name", name);
			request.setAttribute("book_format", book_format);
			request.setAttribute("notes", notes);
			
			getServletContext().getRequestDispatcher(url).forward(request, response);
			return;
			
		}
		
		response.sendRedirect(url);
		
	}

}
