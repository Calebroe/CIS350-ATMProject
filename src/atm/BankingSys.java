package atm;

/*************************************************
 * Class for a CountDownTimer
 *
 * @author Caleb Roe
 * @version March 2, 2022
 *************************************************/
public class BankingSys extends User {
	User users;

	/***********************************************************************
	 * Constructor that initializes the variables *
	 * 
	 * @param firstName     string of first name *
	 * @param lastName      string of last name *
	 * @param pin           integer of pin *
	 * @param totalBalance  integer of total balance *
	 * @param accountNumber integer of account number *
	 ***********************************************************************/
	public BankingSys(String lastName, String firstName, int pin, int totalBalance, int accountNumber) {
		super(lastName, firstName, pin, totalBalance, accountNumber);
	}

	/***********************************************************************
	 * Method that deducts the value of passed integer from total Balance *
	 * 
	 * @param moneyWithdrawn integer of money to withdraw *
	 * @return totalBalance
	 ***********************************************************************/
	public int withdrawlMoney(int moneyWithdrawn) {
		this.totalBalance = this.totalBalance - moneyWithdrawn;
		return totalBalance;
	}

	/***********************************************************************
	 * Method that adds the value of passed integer to total Balance
	 * 
	 * @param moneyDeposited integer of money to be added
	 * @return totalBalance
	 ***********************************************************************/
	public int depositMoney(int moneyDeposited) {
		this.totalBalance = this.totalBalance + moneyDeposited;
		return totalBalance;
	}

	/***********************************************************************
	 * Method that returns true if the account number and pin match user, else false
	 * @param accountNumber integer of account number
	 * @param pin integer of pin
	 * @return boolean
	 ***********************************************************************/
	public boolean correctLogin(int accountNumber, int pin) {
		if (this.accountNumber == accountNumber && this.pin == pin) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
