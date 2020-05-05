package com.HelthCare.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseClass {

	public DatabaseClass() {
		
	}
	
	public static Connection getDBconnection() throws ClassNotFoundException, SQLException{
		
		//Server connection parameters
		String driver="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/healthcare";
		String username = "root";
		String password = "";
		
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		if(con!=null) {
			System.out.println("Connected No Errors");
		}
		
		else {
			System.out.println("Errors With Connection");
		}
		return con;
	}
}