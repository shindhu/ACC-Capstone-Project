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
import Managers.UserBooksManager;

@WebServlet({ "/DeleteUserBookServlet", "/deleteUserBook" })
public class DeleteUserBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
	public DeleteUserBookServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getContextPath() + "/userBooks";
    	
    	boolean updateSucceeded = false;
    	
    	int id = new Integer(request.getParameter("id"));
    	int user_id = new Integer(request.getParameter("user_id"));
    	
    	try {
    		updateSucceeded = new UserBooksManager(ds).deleteUserBookWithID(id);
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	if(updateSucceeded != true) {
    		request.setAttribute("error", "Delete of databse record failed");
    		response.sendRedirect("/LearningDiary/userBooks?user_id=" + user_id);

    	} else {
    		response.sendRedirect("/LearningDiary/userBooks?user_id=" + user_id);
    	}
    	
	}
	
}
