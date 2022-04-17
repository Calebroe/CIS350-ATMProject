package atm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import atm.JDBCMySQLConnection;

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

	public User() {
		userPin = 0;
		firstName = null;
		lastName = null;
		dob = null;
		userId = 0;
		accounts = new ArrayList<Account>();
	}

	public User getUserAccount(int userPin, int userId) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		User user = null;
		String query = "SELECT * FROM user WHERE user_id=" + userId;
		String query1 = "SELECT * FROM account WHERE user_id=" + userId;
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
//			if (rs == null) {
//				// throw new illegal arguement no account found
//				System.out.print("invalid , is null");
//			}
//			if (userPin != rs.getInt("user_pin")) {
//				// throw new illegal arguement does not match
//				System.out.print("invalid Pin");
//			}
			if (rs.next()) {
				userPin = rs.getInt("user_pin");
				userId = rs.getInt("user_id");
				firstName = rs.getString("user_firstName");
				dob = rs.getDate("user_dob");
				lastName = rs.getString("user_lastName");
			}
			rs = statement.executeQuery(query1);
//			if (rs == null) {
//				// throw new illegal arguement no accounts found
//			}
			if (rs.next()) {
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

	public User createUserAccount(String firstName, String lastName, int userId, int userPin, Date dob) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		User user = null;
		String query = "SELECT * FROM user WHERE user_id=" + userId;
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs == null) {
				// throw new illegal arguement no account found
			}
			if (userPin != rs.getInt("user_pin")) {
				// throw new illegal arguement does not match
			}
			if (rs.next()) {
				userPin = rs.getInt("user_pin");
				userId = rs.getInt("emp_id");
				firstName = rs.getString("user_firstname");
				lastName = rs.getString("user_lastname");
				dob = rs.getDate("dob");
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

	public ArrayList<Account> getAllAccounts() {
		return accounts;
	}

	public Account getAccount(int account_Id) {
		for (Account a : accounts) {
			if (a.getacctId() == account_Id) {
				return a;
			}
		}
		return null; // could throw an exception
	}

	public void setUserPin(int userPin) {
		int length = String.valueOf(userPin).length();
		if (length != 4) {
			throw new IllegalArgumentException();
		}
		this.userPin = userPin;
	}

	public int getUserPin() {
		return userPin;
	}

	public void setFirstName(String firstName) {
		int d = Integer.parseInt(firstName);
		int length = String.valueOf(d).length();
		if (firstName == null || firstName.length() == 0) {
			throw new IllegalArgumentException();
		}
		if (length >= 0) {
			throw new IllegalArgumentException();
		}
		if (firstName == null) {
			throw new IllegalArgumentException();
		}
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		int d = Integer.parseInt(lastName);
		int length = String.valueOf(d).length();
		if (lastName == null || lastName.length() == 0) {
			throw new IllegalArgumentException();
		}
		if (length >= 0) {
			throw new IllegalArgumentException();
		}
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

//    public void setAccountNumber(int accountNumber) {
//        int length = String.valueOf(accountNumber).length();
//        if (length != 10) {
//            throw new IllegalArgumentException();
//        }
//        this.accountNumber = accountNumber;
//    }

	// toString()
	@Override
	public String toString() {
		return "User [userId = " + userId + ", userPin = " + userPin + ", dob = " + dob + ", First Name = " + firstName
				+ "Last Name = " + lastName + "]";
	}
}
