package Managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Domain.Users;

public class UsersManager {
	
	DataSource ds;

	public UsersManager(DataSource ds) {
		super();
		this.ds = ds;
	}
	
	public ArrayList<Users> getUsers() throws SQLException {
				
		ArrayList<Users> usersList = new ArrayList<>();
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id, username, password, email from users");
			
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				usersList.add(new Users(resultSet.getInt("id"),
											resultSet.getString("username"),
											resultSet.getString("password"),
											resultSet.getString("email")));
			}
			
			resultSet.close();
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return usersList;
		
	}

	
	public boolean addUser(Users theUser) throws SQLException {
		
		boolean addedUser = false;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			
			String uname = theUser.getUsername();
			String upassword = theUser.getPassword();
			String uemail = theUser.getEmail();
			
			
			String theQueryString = "insert into users (username, password, email) values (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(theQueryString);
			
			ps.setString(1, uname);
			ps.setString(2, upassword);
			ps.setString(3, uemail);
			
			ps.execute();
			ps.close();
			connection.close();
			
			addedUser = true;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return addedUser;
		
	}
	
	public Users getUserByID(String idString) throws SQLException {
		Users userByID = null;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement("select id, username, password, email from users where id = ?");
			ps.setString(1, idString);
			
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				userByID = new Users(resultSet.getString("username"),
										resultSet.getString("password"),
										resultSet.getString("email"));
				
			}
			
			resultSet.close();
			ps.close();
			
		} catch (SQLException e) {
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
		return userByID;
		
	}
	
	
	public Users findUserWithNameAndPassword(String username, String password) throws SQLException {
		Users foundUser = null;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();
			
			PreparedStatement ps = connection.prepareStatement("select id, username, password, email from Users where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				foundUser = new Users(	resultSet.getInt("id"),
										resultSet.getString("username"),
										resultSet.getString("password"),
										resultSet.getString("email"));
			}
			
			resultSet.close();
			ps.close();
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
		
		return foundUser;
	}
	
	
}
