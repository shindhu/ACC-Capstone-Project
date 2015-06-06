package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Managers.BooksManager;


@WebServlet({ "/DeleteBookServlet", "/deleteBook" })
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MyDB")
	DataSource ds;
   
    public DeleteBookServlet() {
        super();
       
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String url = request.getContextPath() + "/books";
    	
    	boolean updateSucceeded = false;
    	
    	int id = new Integer(request.getParameter("id"));
    	
    	try {
    		updateSucceeded = new BooksManager(ds).deleteBookWithID(id);
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	if(updateSucceeded != true) {
    		request.setAttribute("error", "Delete of databse record failed");
    		url = "WEB-INF/books";
    		
    		getServletContext().getRequestDispatcher(url).forward(request, response);
    		
    	}
    	
    	response.sendRedirect(url);
    	
	}

}
