package Items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.DatabaseConnectionUtil;
import user.user;

public class adminDAO {
	
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

}
