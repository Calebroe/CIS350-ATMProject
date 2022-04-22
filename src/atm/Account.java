package atm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*************************************************
 * Account Class
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class Account {
	private int acctId;
	private int totalBalance;
	private String acctType;

	/*********************************************************
	 * Method that deposits a value into the account specified of a specific user in
	 * the SQL database
	 * 
	 * @param value the value added to the total balance
	 * @return oldVal the value of the account before balance update
	 *********************************************************/
	public int depositIntoAccount(int value) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		int oldVal = totalBalance;
		int newBalance = totalBalance + value;
		String query = "UPDATE account SET balance =" + newBalance + " WHERE account_id=" + acctId;
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			totalBalance = newBalance;
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
		return oldVal;
	}

	/*********************************************************
	 * Method that withdraws a value from the account specified of a specific user
	 * in the SQL database
	 * 
	 * @param value the value subtracted from the total balance
	 * @return oldVal the value of the account before balance update
	 *********************************************************/
	public int withdrawFromAccount(int value) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		int oldVal = totalBalance;
		int newBalance = totalBalance - value;
		// need this to return an error if value being pulled is greater than amount.
		String query = "UPDATE account SET balance =" + newBalance + " WHERE account_id=" + acctId;
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			totalBalance = newBalance;
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
		return oldVal;
	}

	/*********************************************************
	 * Method that returns true of the value passed in is less than or equal to the
	 * current balance of the account, else false
	 * 
	 * @param value checked against balance
	 * @return boolean
	 *********************************************************/
	public boolean canWithdrawAmount(int value) {
		if (value <= totalBalance) {
			return true;
		} else {
			return false;
		}
	}

	/*********************************************************
	 * Default constructor method to populate account
	 * 
	 * @param acctId       the id of the account
	 * @param totalBalance the balance of the account
	 * @param acctType     the type of the account
	 *********************************************************/
	public Account(int acctId, int totalBalance, String acctType) {
		this.acctId = acctId;
		this.totalBalance = totalBalance;
		this.acctType = acctType;
	}

	/*********************************************************
	 * Getter and setters for the User
	 * 
	 *********************************************************/
	public int getacctId() {
		return acctId;
	}

	public void setacctId(int acctId) {
		this.acctId = acctId;
	}

	public int gettotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	// toString()
//	@Override
//	public String toString() {
//		return "Account [acctId = " + acctId + ", Account Type = " + acctType + ", Total balance = " + totalBalance
//				+ "]";
//	}
}
