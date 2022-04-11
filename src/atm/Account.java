package atm;

public class Account {
	private int acctId;
	private int totalBalance;
	private String acctType;
	//setup random number generator for account type, string of eight numbers, need to see if the database already has that number

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

