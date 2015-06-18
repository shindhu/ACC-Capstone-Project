package Servlets;

import java.io.IOException;
import java.sql.SQLException;
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
import Managers.CategoryManager;

@WebServlet({ "/CategoryServlet", "/category" })
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
    public CategoryServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/WEB-INF/viewcategory.jsp";
		CategoryManager cm = new CategoryManager(ds);
		List<Category> theCategory = null;
		
		HttpSession session = request.getSession();
		Boolean loggedInBoolean = (Boolean) session.getAttribute("isLoggedIn");
		
		if( loggedInBoolean != null) {
			boolean loggedIn = loggedInBoolean.booleanValue();
			if (loggedIn) {
			
				try {
					
					theCategory = cm.getCategoryTotals();
					System.out.println(theCategory);
					
				} catch (SQLException e) {
				
					e.printStackTrace();
					getServletContext().getRequestDispatcher(url).forward(request, response);
					
				}
				
			}
		}
		
		if(theCategory != null) {
			request.setAttribute("categoryList", theCategory);
			url = "/WEB-INF/viewcategory.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}

}
