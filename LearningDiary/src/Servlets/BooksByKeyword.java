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
		
		//HttpSession mySession = request.getSession();
		BooksManager bm = new BooksManager(ds);
		
		List<Books> theBooks = new ArrayList<>();
		//List<Books> filteredBooks = new ArrayList<>();
		
		
		try {
			theBooks = bm.getBooks();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
