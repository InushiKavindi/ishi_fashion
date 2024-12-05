package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDAO {

	public user validate(String email,String password) {
		
		 user user = null;
	        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
	        try (Connection connection = DatabaseConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                user = new user(
	                    resultSet.getInt("id"),
	                    resultSet.getString("name"),
	                    resultSet.getString("email"),
	                    resultSet.getString("password"),
	                    resultSet.getString("phone"),
	                    resultSet.getString("address")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	}       
		

	 public boolean registerUser(String name,String email,String password,String phone,String address) {
		 
	        String sql = "INSERT INTO user (name, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
	        try (Connection connection = DatabaseConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, email);
	            preparedStatement.setString(3, password);
	            preparedStatement.setString(4, phone);
	            preparedStatement.setString(5, address);

	          
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	            
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		  
		 return false;
	        
	        
	}
	 
	 public boolean updateUser(user user) {
		 

		 String sql = "UPDATE user SET name = ?, email = ?, password = ?, phone = ?, address = ? WHERE id = ?";
	        try (Connection connection = DatabaseConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	        	preparedStatement.setString(1, user.getName());
	        	preparedStatement.setString(2, user.getEmail());
	        	preparedStatement.setString(3, user.getPassword());
	        	preparedStatement.setString(4, user.getPhone());
	        	preparedStatement.setString(5, user.getAddress());
	        	preparedStatement.setInt(6, user.getId());
	           
	          
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	            
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		  
		 return false;
		 
	 }
	 
	 public user getUserById(int id) {
		 
		 user user = null;
	        String sql = "SELECT * FROM user WHERE id = ?";
	        try (Connection connection = DatabaseConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	            preparedStatement.setInt(1, id);
	            

	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                user = new user(
	                    resultSet.getInt("id"),
	                    resultSet.getString("name"),
	                    resultSet.getString("email"),
	                    resultSet.getString("password"),
	                    resultSet.getString("phone"),
	                    resultSet.getString("address")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
		 
	 }
	 
	 public boolean deleteUser(user user) {
		 

		 String sql = "DELETE from user WHERE id = ?";
	        try (Connection connection = DatabaseConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	        	
	        	preparedStatement.setInt(1, user.getId());
	           
	          
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	            
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		  
		 return false;
		 
	 }
}
