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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;










import Domain.Category;
import Domain.UserBooks;
import Managers.BooksManager;
import Managers.CategoryManager;
import Managers.UserBooksManager;


@WebServlet({ "/UserBooksServlet", "/userBooks" })
public class UserBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Resource(name="jdbc/MyDB")
    DataSource ds;
    
    public UserBooksServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/WEB-INF/userbooks.jsp";
		ArrayList<UserBooks> userBooksWithUserID = null;
		//List<Category> adminCategory = null;
		UserBooksManager ubm = new UserBooksManager(ds);
		//CategoryManager cm = new CategoryManager(ds);
		HttpSession session = request.getSession();
	
		Boolean loggedInBoolean = (Boolean) session.getAttribute("isLoggedIn");
		
		if(loggedInBoolean != null) {
			boolean loggedIn = loggedInBoolean.booleanValue();
			if(loggedIn) {
				//int user_id = session.getAttribute("user_id");
				int id = (Integer)session.getAttribute("user_id");
				if(id != 1) {
					try {
						userBooksWithUserID = ubm.getUserBooksByUserID(id);
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} 
			}
		}
		//request.setAttribute("categoryList", adminCategory);		
		request.setAttribute("userBooks", userBooksWithUserID);
		//System.out.println(adminCategory);
		System.out.println(userBooksWithUserID);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	
}
