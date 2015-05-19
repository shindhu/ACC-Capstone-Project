package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Domain.Books;
import Managers.BooksManager;

/**
 * Servlet implementation class BooksByCategory
 */
@WebServlet({ "/BooksByCategory", "/booksbycategory" })
public class BooksByCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MyDB")
	DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksByCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession mySession = request.getSession();
		
		String url = "/WEB-INF/viewcategory.jsp";
		String idString = request.getParameter("id");
		
		BooksManager bm = new BooksManager(ds);
		ArrayList<Books> booksByCategory = bm.getBooksByID(idString);
		
		request.setAttribute("theBooksByCategory",booksByCategory);
		url = "/WEB-INF/booksbycategory.jsp";
		System.out.println(booksByCategory);
				
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
