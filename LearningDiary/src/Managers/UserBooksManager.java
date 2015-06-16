package Managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Domain.UserBooks;

public class UserBooksManager {

	DataSource ds;

	public UserBooksManager(DataSource ds) {
		this.ds = ds;

	}

	public ArrayList<UserBooks> getUserBooks() throws SQLException {

		ArrayList<UserBooks> userBooks = new ArrayList<UserBooks>();
		Connection connection = null;

		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select id, user_id, image, name, book_format, notes from userbooks");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				userBooks.add(new UserBooks(resultSet.getInt("id"), 
						resultSet.getInt("user_id"), 
						resultSet.getString("image"),
						resultSet.getString("name"), 
						resultSet.getString("book_format"),
						resultSet.getString("notes")));
			}
			resultSet.close();
			ps.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return userBooks;

	}

	public ArrayList<UserBooks> getUserBooksByUserID(int theID) throws SQLException {
		
		ArrayList<UserBooks> bookByUserID = new ArrayList<UserBooks>();
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from userbooks where user_id=?");
			ps.setInt(1, theID);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				bookByUserID.add(new UserBooks(resultSet.getInt("id"),
						resultSet.getInt("user_id"),
						resultSet.getString("image"),
						resultSet.getString("name"),
						resultSet.getString("book_format"),
						resultSet.getString("notes") ));
			}
			resultSet.close();
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookByUserID;
	
	}
	
	public boolean addUserBook(int user_id, String image,String name, String book_format, String notes) throws SQLException {
		
		boolean addedUserBook = false;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			String theQueryString = "INSERT INTO USERBOOKS(USER_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setInt(1, user_id);
			ps.setString(2, image);
			ps.setString(3, name);
			ps.setString(4, book_format);
			ps.setString(5, notes);
			
			int theUpdatedCount = ps.executeUpdate();
			if (theUpdatedCount >= 1) {
				addedUserBook = true;
				
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
		
		return addedUserBook;
		
	}
	
	public boolean deleteUserBookWithID(int theID) throws SQLException {
		
		boolean deletedUserBook = false;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			
			String theQueryString = "delete from userbooks where id =?";
			
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setInt(1, theID);
			
			int updatedCount = ps.executeUpdate();
			if (updatedCount >= 1) {
				deletedUserBook = true;
				
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
		
		return deletedUserBook;
	}
	
	

}
