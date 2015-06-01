package Servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.derby.client.am.SqlException;

import Managers.BooksManager;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet({ "/AddBookServlet", "/addBook" })
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/addbook.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getContextPath() + "/books";
		boolean addedBook = false;
		
		int category_id = new Integer( request.getParameter("category_id"));
		String category_name = request.getParameter("category_name");
		String image = request.getParameter("image");
		String name = request.getParameter("name");
		String book_format = request.getParameter("book_format");
		String notes = request.getParameter("notes");
		
		try {
			addedBook = new BooksManager(ds).addBook(category_id, category_name, image, name, book_format, notes);
		} catch(SqlException e) {
			e.printStackTrace();
		}
		
		if(addedBook != true) {
			request.setAttribute("error", "database failed to update the book");
			url = "/WEB-INF/addBook";
			request.setAttribute("category_id", category_id);
			request.setAttribute("category_name", category_name);
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
