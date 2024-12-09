package Items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.DatabaseConnectionUtil;
import user.user;

public class adminDAO {
	
	public admin validate(String username,String password) {
		
		admin admin = null;
	        String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
	        try (Connection connection = DatabaseConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	            	admin = new admin(
	                    resultSet.getInt("id"),	                  
	                    resultSet.getString("username"),
	                    resultSet.getString("password")
	                    );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return admin;
	}

}
