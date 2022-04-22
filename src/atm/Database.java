package atm;

import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Random;
//import atm.JDBCMySQLConnection;
//import atm.User;

/*************************************************
 * Back-end Database Class for manipulating account and user
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class Database {

	/*********************************************************
	 * method for creating User
	 * 
	 * @param firstName first name of the user
	 * @param lastName  last name of the user
	 * @param userId    account number of the user
	 * @param userPin   pin of the user
	 * @param dob       date of birth of the user
	 *********************************************************/
	public void createUserAccount(String firstName, String lastName, int userId, int userPin, java.sql.Date dob) {
		Connection connection = JDBCMySQLConnection.getConnection();

		try {
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(
					"INSERT INTO user(user_id, user_pin, user_firstname, user_lastname, user_dob)VALUES(?,?,?,?,?)");
			statement.setInt(1, userId);
			statement.setInt(2, userPin);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setDate(5, dob);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*********************************************************
	 * Method for creating an account tied to a User
	 * 
	 * @param acctId      account number for account
	 * @param userId      account number for user
	 * @param accountType type of the account
	 *********************************************************/
	public void createAccount(int acctId, int userId, String accountType) {
		Connection connection = JDBCMySQLConnection.getConnection();
		int balance = 0;
		try {
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement("INSERT INTO account(account_id, user_id, balance, account_type)VALUES(?,?,?,?)");
			statement.setInt(1, acctId);
			statement.setInt(2, userId);
			statement.setInt(3, balance);
			statement.setString(4, accountType);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*********************************************************
	 * Method for creating a 6 digit random integer for user account number
	 * 
	 * @return number number for user account
	 *********************************************************/
	public static int getRandomNumberString() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		number = Integer.parseInt(String.format("%06d", number));
		return number;
	}

	/*********************************************************
	 * Method for creating a 8 digit random integer for an account number
	 * 
	 * @return number number for account
	 *********************************************************/
	public static int getRandomAcctString() {
		Random rnd = new Random();
		int number = rnd.nextInt(99999999);
		number = Integer.parseInt(String.format("%08d", number));
		return number;
	}

}