package atm;

import java.awt.EventQueue;

/*************************************************
 * Class for a User
 *
 * @author Caleb Roe
 * @version March 2, 2022
 *************************************************/
public class User {
	public int pin;
    public String firstName;
    public String lastName;
    public int totalBalance;
    public int accountNumber;
    
    /***********************************************************************
	 * Constructor that initializes User
	 * 
	 * @param firstName     string of first name 
	 * @param lastName      string of last name 
	 * @param pin           integer of pin 
	 * @param totalBalance  integer of total balance 
	 * @param accountNumber integer of account number 
	 ***********************************************************************/
    public User(String firstName, String lastName, int pin, int totalBalance, int accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.totalBalance = totalBalance;
        this.accountNumber = accountNumber;
    }
    
    /***********************************************************************
	 * Method that sets pin of User
	 * @param pin integer of pin
	 * @throws IllegalArgumentException()
	 ***********************************************************************/
    public void setPin(int pin) {
        int length = String.valueOf(pin).length();
        if (length != 4) {
            throw new IllegalArgumentException();
        }
        this.pin = pin;
    }
    
    /***********************************************************************
	 * Method that returns pin of User
	 * @return pin
	 ***********************************************************************/
    public int getPin() {
        return pin;
    }
    
    /***********************************************************************
   	 * Method that sets firstName of User
   	 * @param firstName string of first name
   	 * @throws IllegalArgumentException()
   	 ***********************************************************************/
    public void setFirstName(String firstName) {
        int length = String.valueOf(firstName).length();
        if (firstName == null || length <= 0) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }
    
    /***********************************************************************
	 * Method that returns firstName of User
	 * @return firstName
	 ***********************************************************************/
    public String getFirstName() {
        return firstName;
    }
    
    /***********************************************************************
   	 * Method that sets last name of User
   	 * @param lastName string of last name
   	 * @throws IllegalArgumentException()
   	 ***********************************************************************/
    public void setLastName(String lastName) {
        int length = String.valueOf(lastName).length();
        if (lastName == null || lastName.length() <= 0) {
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }
    
    /***********************************************************************
	 * Method that returns lastName of User
	 * @return lastName
	 ***********************************************************************/
    public String getLastName() {
        return lastName;
    }
    
    /***********************************************************************
   	 * Method that sets total balance of User
   	 * @param totalBalance integer of balance
   	 * @throws IllegalArgumentException()
   	 ***********************************************************************/
    public void setTotalBalance(int totalBalance) {
        if (totalBalance < 0) {
            throw new IllegalArgumentException();
        }
        this.totalBalance = totalBalance;
    }
    
    /***********************************************************************
	 * Method that returns totalBalance of User
	 * @return totalBalance
	 ***********************************************************************/
    public int getTotalBalance() {
        return totalBalance;
    }
    
    /***********************************************************************
   	 * Method that sets account number of User
   	 * @param accountNumber integer of balance
   	 * @throws IllegalArgumentException()
   	 ***********************************************************************/
    public void setAccountNumber(int accountNumber) {
        int length = String.valueOf(accountNumber).length();
        if (length != 10) {
            throw new IllegalArgumentException();
        }
        this.accountNumber = accountNumber;
    }
    
    /***********************************************************************
	 * Method that returns account number of User
	 * @return accountNumber
	 ***********************************************************************/
    public int getAccountNumber() {
        return accountNumber;
    }
    
    //logic for banking system
    public int withdrawlMoney(int moneyWithdrawn){
    	if(moneyWithdrawn > this.totalBalance) {
    		throw new IllegalArgumentException();
    	}
        this.totalBalance = this.totalBalance - moneyWithdrawn;
        return totalBalance;
    }
    
    public int depositMoney(int moneyDeposited) {
        this.totalBalance = this.totalBalance + moneyDeposited;
        return totalBalance;
    }
    
    public boolean correctLogin(int accountNumber, int pin) {
	if (this.accountNumber == accountNumber && this.pin == pin) {
		return true;
    }
        return false;
    }

    public static void main(String[] args) {
    	//User user1 = new User("Caleb", "Roe", 1111, 1400, 1001);
    }
}
	


