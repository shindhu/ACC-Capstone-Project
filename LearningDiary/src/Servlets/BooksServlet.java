package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Domain.Books;
import Managers.BooksManager;

/**
 * Servlet implementation class BooksServlet
 */
@WebServlet({ "/BooksServlet", "/books" })
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BooksManager bm = new BooksManager(ds);
		ArrayList<Books> theBooks = null;
		
		String url = "/WEB-INF/viewbooks.jsp";
		
		try {
			theBooks = bm.getBooks();
		} catch (SQLException e) {
			
			e.printStackTrace();
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}
		
		System.out.println(theBooks);
		request.setAttribute("booksList", theBooks);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
