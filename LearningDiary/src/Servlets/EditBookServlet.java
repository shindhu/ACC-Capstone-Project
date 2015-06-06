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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.derby.client.am.SqlException;

import Domain.Books;
import Exceptions.DBErrorException;
import Managers.BooksManager;

@WebServlet({ "/EditBookServlet", "/editBook" })
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
   
    public EditBookServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = new Integer(request.getParameter("id"));
		
		request.setAttribute("id", id);
		BooksManager bm = new BooksManager(ds);
		try {
			ArrayList<Books> bookToEdit = bm.getBookWithBookID(id);
			request.setAttribute("book", bookToEdit);
			String url = "/WEB-INF/editbook.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			return;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/viewbooks.jsp").forward(request, response);
			return;
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   	
		int id= new Integer(request.getParameter("id"));
		int category_id = new Integer(request.getParameter("category_id"));
		//String category_id = request.getParameter("category_id");
		String category_name = request.getParameter("category_name");
		String image = request.getParameter("image");
		String name = request.getParameter("name");
		String book_format = request.getParameter("book_fromat");
		String notes = request.getParameter("notes");
		
		Books updatedBook = new Books(id, category_id, category_name, image, name, book_format, notes);
		BooksManager bm = new BooksManager(ds);
		
		try {
			if(bm.updateBook(updatedBook)) {
				System.out.println("updated item is "+ updatedBook);
				response.sendRedirect("/books");
				return;
			} else {
				// if book didn't save, go to viewbooks page
				System.out.println("Did not update" + updatedBook);
				request.setAttribute("error_update", "book did not update in teh database! Try again");
				request.getRequestDispatcher("/WEB-INF/viewbooks.jsp").forward(request, response);
				
			}
			
		} catch (DBErrorException | SQLException e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/viewbooks.jsp").forward(request, response);
			return;
			
		}
		
	}

}
		
		