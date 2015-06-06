package Managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Domain.Category;

public class CategoryManager {

	DataSource ds;

	public CategoryManager(DataSource ds) {
		this.ds = ds;
	}

	public ArrayList<Category> getCategory() throws SQLException {
		ArrayList<Category> theCategory = new ArrayList<>();
		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select id, name from category");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				theCategory.add(new Category(resultSet.getInt("id"), resultSet
						.getString("name")));
			}

			resultSet.close();
			ps.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return theCategory;
	}

	public Category getCategoryByID(int id) throws SQLException {
		
		Category categoryByID = null;
		Connection connection = ds.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select id, name from category where id=?");
			ps.setInt(1, id);
			
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				categoryByID = new Category(resultSet.getInt("id"),
												resultSet.getString("name"));
					
			}
			resultSet.close();
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return categoryByID;
		
	}
	
	
	public List<Category> getCategoryTotals() throws SQLException
	{
		List<Category> bookCounts = new ArrayList<>();
		
		Connection connection = null;
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select category.id, category.name, count(books.category_id) as bookcounts from category left outer join books on category.id = books.category_id  group by category.id,category.name");
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				int idString = resultSet.getInt("id");
				String categoryNameString = resultSet.getString("name");
				int  bookcountsString = resultSet.getInt("bookcounts");
				
				bookCounts.add(new Category(idString,categoryNameString,bookcountsString));
				
			}
			
			resultSet.close();
			ps.close();
			connection.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return bookCounts;
		
	}

	public boolean addCategory(String name) throws SQLException
	{
		boolean addedCategory = false;
		Connection connection = null;
		
		try { 
			connection = ds.getConnection();
			String theQueryString = "INSERT INTO CATEGORY (NAME) values (?)";
			
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setString(1, name);
			
			int updatedCount = ps.executeUpdate();
			if(updatedCount >= 1) {
				addedCategory = true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return addedCategory;
		
	}
	
	// edit and update category in database
	public boolean updateCategory(Category c) throws SQLException {
		
		boolean updatedCategory = false;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("update category set name=? where id=?");
			ps.setString(1, c.getName());
			
			ps.execute();
			updatedCategory = true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		return updatedCategory;
		
	}
	
	// delete category with ID from the database
	public boolean deleteCategoryWithID(int id) throws SQLException {
		
		boolean deletedCategory = false;
		Connection connection = null;
		
		try { 
			connection = ds.getConnection();
			String theQueryString = "delete from category where id =?";
			
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setInt(1, id);
			
			int updatedCount = ps.executeUpdate();
			if (updatedCount >= 1) {
				deletedCategory = true;
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return deletedCategory;
		
	}
	
}
