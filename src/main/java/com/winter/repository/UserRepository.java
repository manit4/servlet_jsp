package com.winter.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.winter.db.DBConnection;
import com.winter.to.UserTO;

public class UserRepository {

	public void saveuser(UserTO to) {

		try {

			Connection conn = DBConnection.getConnection();
			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?)");
			
			statement.setString(1, to.getUsername());
			statement.setString(2, to.getPassword());
			statement.setString(3, to.getName());
			statement.setString(4, to.getEmail());
			
			statement.executeUpdate();
			
			
		} catch (Exception e) {

			System.out.println("inside catch of saveUser() of UserRepository");
			e.printStackTrace();
		}
	}
	
	
//	public void saveuser(String username, String password, String name, String email) {
//
//		try {
//
//			Connection conn = DBConnection.getConnection();
//			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?)");
//			
//			statement.setString(1, username);
//			statement.setString(2, password);
//			statement.setString(3, name);
//			statement.setString(4, email);
//			
//			statement.executeUpdate();
//			
//			
//		} catch (Exception e) {
//
//			System.out.println("inside catch of saveUser() of UserRepository");
//			e.printStackTrace();
//		}
//	}

}
