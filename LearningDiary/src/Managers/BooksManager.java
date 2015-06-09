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

	public ArrayList<Books> getBooks() throws SQLException {
		ArrayList<Books> theBooks = new ArrayList<>();
		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select id,category_id,category_name, image, name, book_format, notes from books");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				theBooks.add(new Books(resultSet.getInt("id"),
										resultSet.getInt("category_id"),
										resultSet.getString("category_name"),
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
	
	// get books order by id
	public ArrayList<Books> getBooksOrderByID() throws SQLException {
		ArrayList<Books> theBooksOrderByID = new ArrayList<>();
		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select id,category_id,category_name, image, name, book_format, notes from books order by id asc");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				theBooksOrderByID.add(new Books(resultSet.getInt("id"),
										resultSet.getInt("category_id"),
										resultSet.getString("category_name"),
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
					.prepareStatement("select id,category_id,category_name, image, name, book_format, notes from books order by name asc");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				theBooksOrderByName.add(new Books(resultSet.getInt("id"),
										resultSet.getInt("category_id"),
										resultSet.getString("category_name"),
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
	
	
	public List<Books> getBooksByKeyword(String theCategory_name, String theName, String theNotes) throws IOException, SQLException {
		
		List<Books> theFilteredBooks = new ArrayList<Books>();
		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select id, category_name, image, name, book_format, notes from books where category_name like ? or name like ? or notes like ?");
			ps.setString(1, "%" + theCategory_name + "%");
			ps.setString(2, "%" + theName + "%");
			ps.setString(3, "%" + theNotes + "%");
			
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				theFilteredBooks.add(new Books(resultSet.getInt("id"),
											resultSet.getString("category_name"),
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

	// get books using id of it 
	public Books getBookWithBookID (int theID) throws SQLException {
		
		Books bookByBookID = null;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id, category_id, category_name, image, name, book_format, notes from books where id=? ");
			ps.setInt(1, theID);
			ResultSet resultSet = ps.executeQuery();

			while(resultSet.next()) {
				int idString = resultSet.getInt("id");
				int category_idString = resultSet.getInt("category_id");
				String category_nameString = resultSet.getString("category_name");
				String imageString = resultSet.getString("image");
				String nameString = resultSet.getString("name");
				String book_formatString = resultSet.getString("book_format");
				String notesString = resultSet.getString("notes");
				
				bookByBookID = new Books(idString, category_idString, category_nameString, 
						imageString, nameString, book_formatString, notesString);
				
			}
			
			resultSet.close();
			ps.close();
				
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return bookByBookID;
		
	}
	
	public ArrayList<Books> getBookByID(int theID) throws SqlException, DBErrorException
	{
		ArrayList<Books> booksByID = new ArrayList<>();
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id, category_id, category_name, image, name, book_format, notes from books where category_id = ? ");
			ps.setInt(1, theID);
			ResultSet resultSet = ps.executeQuery();

			while(resultSet.next()) {
				int idString = resultSet.getInt("id");
				int category_idString = resultSet.getInt("category_id");
				String category_nameString = resultSet.getString("category_name");
				String imageString = resultSet.getString("image");
				String nameString = resultSet.getString("name");
				String book_formatString = resultSet.getString("book_format");
				String notesString = resultSet.getString("notes");
				
				booksByID.add(new Books(idString, category_idString, category_nameString, 
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
	public boolean addBook(int category_id,String category_name,String image,String name, String book_format, String notes) throws SqlException {
		
		boolean addedBook = false;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			
			String theQueryString = "INSERT INTO BOOKS(CATEGORY_ID,CATEGORY_NAME, IMAGE, NAME, BOOK_FORMAT, NOTES) VALUES(?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setInt(1, category_id);
			ps.setString(2, category_name);
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
			
			String theQueryString = "update books set category_id=?, category_name=?, image=?, name=?, book_format=?, notes=? where id=?";
			
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			ps.setInt(1, b.getCategory_id());
			ps.setString(2, b.getCategory_name());
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
