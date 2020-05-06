package com.HelthCare.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Item {
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1_paf", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String readItems() {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {

				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed

			output = "<table border='1'><tr><th>First Name</th><th>Last Name</th>"
					+ "<th>Age</th>" + "<th>Address</th><th>Sex</th>" + "<th>Email</th><th>Username</th>" + "<th>Password</th><th>Type</th>" + "<th>Contact</th>" + "<th>Update</th><th>Remove</th></tr>";

			String query = "select * from user";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String u_id = Integer.toString(rs.getInt("u_id"));
				String u_fname = rs.getString("u_fname");
				String u_lname = rs.getString("u_lname");
				String u_age = rs.getString("u_age");
				String u_address = rs.getString("u_address");
				String u_sex = rs.getString("u_sex");
				String u_email = rs.getString("u_email");
				String u_username = rs.getString("u_username");
				String u_password = rs.getString("u_password");
				String u_type = rs.getString("u_type");
				String u_contact = rs.getString("u_contact");
				
				
				// Add into the html table
				output += "<tr><td><input id='hidItemIDUpdate'" + "name='hidItemIDUpdate'" + "type='hidden' value='"
						+ u_id + "'>" + u_fname + "</td>";
				
				output += "<td>" + u_lname + "</td>";
				output += "<td>" + u_age + "</td>";
				output += "<td>" + u_address + "</td>";
				output += "<td>" + u_sex + "</td>";
				output += "<td>" + u_email + "</td>";
				output += "<td>" + u_username + "</td>";
				output += "<td>" + u_password + "</td>";
				output += "<td>" + u_type + "</td>";
				output += "<td>" + u_contact + "</td>";
				// buttons
				output += "<td><input name='btnUpdate'" + "type='button' value='Update'"
						+ "class='btnUpdate btn btn-secondary'></td>" + "<td><input name='btnRemove'"
						+ "type='button' value='Remove'" + "class='btnRemove btn btn-danger'" + "data-u_id='" + u_id
						+ "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertItem(String u_fname, String u_lname, String u_age, String u_address, String u_sex, String u_email, String u_username, String u_password, String u_type, String u_contact) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into user(`u_id`,`u_fname`,`u_lname`,`u_age`,`u_address`,`u_sex`,`u_email`,`u_username`,`u_password`,`u_type`,`u_contact`)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, u_fname);
			preparedStmt.setString(3, u_lname);
			preparedStmt.setString(4, u_age);
			preparedStmt.setString(5, u_address);
			preparedStmt.setString(6, u_sex);
			preparedStmt.setString(7, u_email);
			preparedStmt.setString(8, u_username);
			preparedStmt.setString(9, u_password);
			preparedStmt.setString(10, u_type);
			preparedStmt.setString(11, u_contact);

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":" + " \"Error while inserting the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateItem(String u_id, String u_fname, String u_lname, String u_age, String u_address, String u_sex, String u_email, String u_username, String u_password, String u_type, String u_contact) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE user SET u_fname=?,u_lname=?,u_age=?,u_address=?,u_sex=?,u_email=?,u_username=?,u_password=?,u_type=?,u_contact=? WHERE u_id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
			preparedStmt.setString(1, u_fname);
			preparedStmt.setString(2, u_lname);
			preparedStmt.setString(3, u_age);
			preparedStmt.setString(4, u_address);
			preparedStmt.setString(5, u_sex);
			preparedStmt.setString(6, u_email);
			preparedStmt.setString(7, u_username);
			preparedStmt.setString(8, u_password);
			preparedStmt.setString(9, u_type);
			preparedStmt.setString(10, u_contact);
			preparedStmt.setInt(11, Integer.parseInt(u_id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":" + "\"Error while updating the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteItem(String u_id) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from user where u_id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(u_id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newItems = readItems();
			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":" + "\"Error while deleting the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
