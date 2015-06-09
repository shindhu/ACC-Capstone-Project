package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Domain.Books;
import Managers.BooksManager;

@WebServlet({ "/BooksByKeyword", "/booksByKeyword" })
public class BooksByKeyword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MyDB")
	DataSource ds;
       
   public BooksByKeyword() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/WEB-INF/index.jsp";
		List<Books> filteredBooks = new ArrayList<>();
		BooksManager bm = new BooksManager(ds);
		Books b = null;
		String theKeyword = null;
		String category_name  = request.getParameter(b.getLowerCategory_name());
		String name = request.getParameter(b.getLowerName());
		String notes = request.getParameter(b.getLowerNotes());
		
		try {
			theKeyword = request.getParameter("search");
			if(theKeyword != null) {
				filteredBooks = bm.getBooksByKeyword(category_name, name, notes);
				System.out.println(filteredBooks);
				request.setAttribute("theFilteredBook", filteredBooks);
				url="/WEB-INF/booksbykeyword.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			} 
				
		} catch (SQLException e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/dberror.jsp").forward(request, response);
			
		}
		
	}

}
