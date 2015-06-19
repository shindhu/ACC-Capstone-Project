package Managers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.derby.client.am.SqlException;

import Domain.Books;
import Exceptions.DBErrorException;


public class BooksManager {
	
	DataSource ds;

	public BooksManager(DataSource ds) {
		this.ds = ds;
	}

	public ArrayList<Books> getBooks(int theUserID) throws SQLException {
		ArrayList<Books> theBooks = new ArrayList<>();
		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id, category_id, image, name, book_format, notes from books where user_id=?");
			ps.setInt(1, theUserID);
			
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				theBooks.add(new Books(resultSet.getInt("id"),
										resultSet.getInt("category_id"),
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

		return theBooks;
	}
	
	// get books order by id where id=1,2,3,4,.......
	public ArrayList<Books> getBooksOrderByID() throws SQLException {
		ArrayList<Books> theBooksOrderByID = new ArrayList<>();
		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select id,category_id, image, name, book_format, notes from books order by id asc");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				theBooksOrderByID.add(new Books(resultSet.getInt("id"),
										resultSet.getInt("category_id"),
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

		return theBooksOrderByID;
	}

	//get books ordered by name in A to Z
	public ArrayList<Books> getBooksOrderByName() throws SQLException {
		ArrayList<Books> theBooksOrderByName = new ArrayList<>();
		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select id,category_id, image, name, book_format, notes from books order by name asc");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				theBooksOrderByName.add(new Books(resultSet.getInt("id"),
										resultSet.getInt("category_id"),
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

		return theBooksOrderByName;
	}
	
	// find books by keyword
	public List<Books> getBooksByKeyword( String theName, String theNotes) throws IOException, SQLException {
		
		List<Books> theFilteredBooks = new ArrayList<Books>();
		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select id, image, name, book_format, notes from books where  name like ? or notes like ?");
			ps.setString(1, "%" + theName + "%");
			ps.setString(2, "%" + theNotes + "%");
			
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				theFilteredBooks.add(new Books(resultSet.getInt("id"),
											resultSet.getString("image"),
											resultSet.getString("name"),
											resultSet.getString("book_fromat"),
											resultSet.getString("notes") ));
			}
			resultSet.close();
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return theFilteredBooks;
	}

	// get books using book_id
	public Books getBookWithBookID (int theID) throws SQLException {
		
		Books bookByBookID = null;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id, category_id, image, name, book_format, notes from books where id=? ");
			ps.setInt(1, theID);
			ResultSet resultSet = ps.executeQuery();

			while(resultSet.next()) {
				int idString = resultSet.getInt("id");
				int category_idString = resultSet.getInt("category_id");
				String imageString = resultSet.getString("image");
				String nameString = resultSet.getString("name");
				String book_formatString = resultSet.getString("book_format");
				String notesString = resultSet.getString("notes");
				
				bookByBookID = new Books(idString, category_idString, 
						imageString, nameString, book_formatString, notesString);
				
			}
			
			resultSet.close();
			ps.close();
				
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return bookByBookID;
		
	}
	
	// get books with category_id
	public ArrayList<Books> getBookByID(int theID) throws SqlException, DBErrorException
	{
		ArrayList<Books> booksByID = new ArrayList<>();
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id, category_id,  image, name, book_format, notes from books where category_id = ? ");
			ps.setInt(1, theID);
			ResultSet resultSet = ps.executeQuery();

			while(resultSet.next()) {
				int idString = resultSet.getInt("id");
				int category_idString = resultSet.getInt("category_id");
				String imageString = resultSet.getString("image");
				String nameString = resultSet.getString("name");
				String book_formatString = resultSet.getString("book_format");
				String notesString = resultSet.getString("notes");
				
				booksByID.add(new Books(idString, category_idString, 
						imageString, nameString, book_formatString, notesString));
				
			}
			
			resultSet.close();
			ps.close();
				
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DBErrorException();
		}
		
		return booksByID;
		
	}
	
	// add book in the database
	public boolean addBook(int user_id, int category_id, String image,String name, String book_format, String notes) throws SqlException {
		
		boolean addedBook = false;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			
			String theQueryString = "INSERT INTO BOOKS(USER_ID, CATEGORY_ID, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setInt(1, user_id);
			ps.setInt(2, category_id);
			ps.setString(3, image);
			ps.setString(4, name);
			ps.setString(5, book_format);
			ps.setString(6, notes);
			
			int theUpdatedCount = ps.executeUpdate();
			if (theUpdatedCount >= 1) {
				addedBook = true;
				
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
		
		return addedBook;
		
	}
	
	// edit and update the book in database
	public boolean updateBook(Books b) throws  SQLException, DBErrorException {
		
		boolean updatedBook = false;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			
			String theQueryString = "update books set user_id=?, category_id=?,  image=?, name=?, book_format=?, notes=? where id=?";
			
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setInt(1, b.getUser_id());
			ps.setInt(2, b.getCategory_id());
			ps.setString(3, b.getImage());
			ps.setString(4, b.getName());
			ps.setString(5, b.getBook_format());
			ps.setString(6, b.getNotes());
			ps.setInt(7, b.getId());
			
			int updatedCount = ps.executeUpdate();
			if(updatedCount >= 1) {
				updatedBook = true;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if( connection != null) {
				try {
					connection.close();
				} catch(SQLException e){
					e.printStackTrace();
					throw  new DBErrorException();
				}
			}
		}
		
		return updatedBook;
		
	}
	
	// delete book with ID from database 
	public boolean deleteBookWithID(int id) throws SQLException {
		
		boolean deletedBook = false;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			
			String theQueryString = "delete from books where id =?";
			
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setInt(1, id);
			
			int updatedCount = ps.executeUpdate();
			if (updatedCount >= 1) {
				deletedBook = true;
				
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
		
		return deletedBook;
		
	}
	
	
}
