package atm;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;

/*************************************************
 * User Class
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class User {
	private int userPin;
	private String firstName;
	private String lastName;
	private Date dob;
	private int userId;
	private ArrayList<Account> accounts;
	JDBCMySQLConnection connection = new JDBCMySQLConnection();

	// setup random number for userId, string of eight numbers, it needs a check to
	// see if the database already has that number

	/**
	 * Default Constructor for testing
	 */
	public User() {
		userPin = 0;
		firstName = "test";
		lastName = "test";
		dob = null;
		userId = 1200;
		accounts = new ArrayList<Account>();
	}

	/*********************************************************
	 * Method that returns a User object from SQL database
	 * 
	 * @param userpin the user_pin associated with the user_id
	 * @param userid  the user_id associated with a specific user
	 * @return user
	 *********************************************************/
	public User getUserAccount(int userpin, int userid) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		User user = null;
		String query = "SELECT * FROM user WHERE user_id=" + userid + " AND user_pin=" + userpin;
		String query1 = "SELECT * FROM account WHERE user_id=" + userid;
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				userPin = rs.getInt("user_pin");
				userId = rs.getInt("user_id");
				firstName = rs.getString("user_firstName");
				dob = rs.getDate("user_dob");
				lastName = rs.getString("user_lastName");
			}
			rs = statement.executeQuery(query1);

			while (rs.next()) {
				Account a1 = new Account(rs.getInt("account_id"), rs.getInt("balance"), rs.getString("account_type"));
				accounts.add(a1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	/*********************************************************
	 * Method that updates the user_pin of the User object in SQL database
	 * 
	 * @param newPin the new user_pin associated with the user_id
	 *********************************************************/
	public void updatePin(int newPin) {

		Connection connection = null;
		Statement statement = null;

		String query = "UPDATE user SET user_pin =" + newPin + " WHERE user_id=" + userId;
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*********************************************************
	 * Method that returns an ArrayList of Accounts from the SQL database that are
	 * associated with the User object
	 * 
	 * @return accounts
	 *********************************************************/
	public ArrayList<Account> getAllAccounts() {
		return accounts;
	}

	/*********************************************************
	 * Method that returns an account from the SQL database that is associated with
	 * the User object
	 * 
	 * @return account
	 *********************************************************/
	public Account getAccount(int account_Id) {
		for (Account a : accounts) {
			if (a.getacctId() == account_Id) {
				return a;
			}
		}
		return null; // could throw an exception
	}

	/*********************************************************
	 * Getter and setters for the User
	 * 
	 *********************************************************/
	public void setUserPin(int userPin) {
		this.userPin = userPin;
	}

	public int getUserPin() {
		return userPin;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	// toString()
//	@Override
//	public String toString() {
//		return "User [userId = " + userId + ", userPin = " + userPin + ", dob = " + dob + ", First Name = " + firstName
//				+ "Last Name = " + lastName + "]";
//	}
}
