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

import Domain.Category;
import Managers.CategoryManager;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet({ "/CategoryServlet", "/category" })
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/MyDB")
	DataSource ds;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String url = "index.jsp";
		
		CategoryManager cm = new CategoryManager(ds);
		
		ArrayList<Category> theCategory = null;
		String url = "/WEB-INF/viewcategory.jsp";
		
		try {
			theCategory = cm.getCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}
			
		System.out.println(theCategory);
		request.setAttribute("categoryList", theCategory);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
