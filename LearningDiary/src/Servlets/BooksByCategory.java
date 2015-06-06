package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.derby.client.am.SqlException;

import Domain.Books;
import Exceptions.DBErrorException;
import Managers.BooksManager;

/**
 * Servlet implementation class BooksByCategory
 */
@WebServlet({ "/BooksByCategory", "/booksByCategory" })
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

		
		//HttpSession mySession = request.getSession();
		
		String url = "/WEB-INF/viewcategory.jsp";
		int id = new Integer(request.getParameter("id"));
		
		BooksManager bm = new BooksManager(ds);
		ArrayList<Books> booksByCategory = null;
		try {
			booksByCategory = bm.getBookByID(id);
		} catch (SqlException | DBErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
