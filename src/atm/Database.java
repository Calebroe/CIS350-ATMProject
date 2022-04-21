package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import atm.JDBCMySQLConnection;
import atm.User;

public class Database {

	//JDBCMySQLConnection connection = new JDBCMySQLConnection();

	// method that checks database, and returns user if user_ID has a match
	

//	// method that takes current user and populates database
//	//public User pushUserId(int userId) {
//	//	ResultSet rs = null;
//	//	Connection connection = null;
//	//	Statement statement = null;

//	//	User user = null;
//	String query = "SELECT * FROM user WHERE user_id=" + userId;	
//	//	try {
//	//		connection = JDBCMySQLConnection.getConnection();
//	// = connection.createStatement();
//	//		rs = statement.executeQuery(query);
//
//	//		if (rs.next()) {
//	//			user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getInt("user_pin"),
//	//					rs.getInt("user_id"), rs.getDate("user_dob"));
//                user.setUserId(rs.getInt("emp_id"));
//                user.setFirstName(rs.getString("emp_name"));
//                user.setDob(rs.getDate("dob"));
//                user.setLastName(rs.getDouble("salary"));
//                user.setUserId((rs.getInt("dept_id")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return user;
//	}
	
	//method that checks if first name and last name are in the database
	
	//method to deposit amount into account number: should grab the account from the dropdown menu, then grab the integer amount from the text field, then it should
	//insert into the account if its greater than zero, will need a print statement to the stmtfield that declares it was successful
	
	//method to withdraw amount from account number: should grab the account from the dropdown menu, then grab the integer amount and check to see if its less than the current amount in that account, then it should withdraw
	
	//method to transfer amount from either your savings account to checking account, or from either your savings account or checking, to another account at the atm.
	//it should grab the amount to transfer and call deposit on the account to deposit, and withdraw on the account to withdraw
	
	
	
	public void createUserAccount(String firstName, String lastName, int userId, int userPin, java.sql.Date dob) { 
		ResultSet rs = null;
		Connection connection = JDBCMySQLConnection.getConnection();
		//User user = null;
		//String query = "SELECT * FROM user WHERE user_id=" + userId;
		try {
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement("INSERT INTO user(user_id, user_pin, user_firstname, user_lastname, user_dob)VALUES(?,?,?,?,?)");
			PreparedStatement statement1 = (PreparedStatement) connection.prepareStatement("INSERT INTO account(user_id, user_pin, user_firstname, user_lastname, user_dob)VALUES(?,?,?,?,?)");
			statement.setInt(1, userId);
			statement.setInt(2, userPin);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setDate(5, dob);
			statement.executeUpdate();
			statement.close();
			connection.close();
			//user_id, user_pin, user_firstname, user_lastname, user_dob
			//if (rs == null) {
				// throw new illegal arguement no account found
			//}
			//if (userPin != rs.getInt("user_pin")) {
				// throw new illegal arguement does not match
			//}
			//if (rs.next()) {
			//	userPin = rs.getInt("user_pin");
			//	userId = rs.getInt("emp_id");
			//	firstName = rs.getString("user_firstname");
			//	lastName = rs.getString("user_lastname");
			//	dob = rs.getDate("dob");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void createAccount(String firstName, String lastName, int userId, int userPin, java.sql.Date dob) { 
		ResultSet rs = null;
		Connection connection = JDBCMySQLConnection.getConnection();
		//User user = null;
		//String query = "SELECT * FROM user WHERE user_id=" + userId;
		try {
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement("INSERT INTO user(user_id, user_pin, user_firstname, user_lastname, user_dob)VALUES(?,?,?,?,?)");
			PreparedStatement statement1 = (PreparedStatement) connection.prepareStatement("INSERT INTO account(user_id, user_pin, user_firstname, user_lastname, user_dob)VALUES(?,?,?,?,?)");
			statement.setInt(1, userId);
			statement.setInt(2, userPin);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setDate(5, dob);
			statement.executeUpdate();
			statement.close();
			connection.close();
			//user_id, user_pin, user_firstname, user_lastname, user_dob
			//if (rs == null) {
				// throw new illegal arguement no account found
			//}
			//if (userPin != rs.getInt("user_pin")) {
				// throw new illegal arguement does not match
			//}
			//if (rs.next()) {
			//	userPin = rs.getInt("user_pin");
			//	userId = rs.getInt("emp_id");
			//	firstName = rs.getString("user_firstname");
			//	lastName = rs.getString("user_lastname");
			//	dob = rs.getDate("dob");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static int getRandomNumberString() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		number = Integer.parseInt(String.format("%06d", number));
		return number;
	}
	
	public static int getRandomAcctString() {
		Random rnd = new Random();
		int number = rnd.nextInt(99999999);
		number = Integer.parseInt(String.format("%08d", number));
		return number;
	}

	
	
}