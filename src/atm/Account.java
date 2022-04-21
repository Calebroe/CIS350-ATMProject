package atm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
	private int acctId;
	private int totalBalance;
	private String acctType;

	public int depositIntoAccount(int value) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		int oldVal = totalBalance;
		int newBalance = totalBalance + value;
		String query = "UPDATE account SET balance ="+newBalance+" WHERE account_id=" +acctId;
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
	
	public int withdrawFromAccount(int value) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		int oldVal = totalBalance;
		int newBalance = totalBalance - value;
		//need this to return an error if value being pulled is greater than amount.
		String query = "UPDATE account SET balance ="+newBalance+" WHERE account_id=" +acctId;
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
	
	public boolean canWithdrawAmount(int value) {
		if( value <= totalBalance ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Account(int acctId, int totalBalance, String acctType) {
	        this.acctId = acctId;
	        this.totalBalance = totalBalance;
	        this.acctType = acctType;
	}

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
	@Override
	public String toString() {
		return "Account [acctId = " + acctId + ", Account Type = " + acctType + ", Total balance = " + totalBalance + "]";
	}
}

