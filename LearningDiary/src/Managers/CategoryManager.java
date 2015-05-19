package Managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	
	
	
	
	
	

}
