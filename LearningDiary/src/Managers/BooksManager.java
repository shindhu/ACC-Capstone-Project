package Managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Domain.Books;


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
	
	public ArrayList<Books> getBooksByID(String theID) 
	{
		ArrayList<Books> booksByID = new ArrayList<>();
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id, category_id, category_name, image, name, book_format, notes from books where category_id = ?");
			ps.setString(1, theID);
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
		}
		
		return booksByID;
		
	}
	
}
