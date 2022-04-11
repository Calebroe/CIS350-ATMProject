package atm;

import java.util.Date;

public class User {
	private int userPin;
	private String firstName;
    private String lastName;
    private Date dob;
    private int userId;
    
    //setup random number for userId, string of eight numbers, it needs a check to see if the database already has that number
    
    public User(String firstName, String lastName, int userPin, int userId, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPin = userPin;
        this.userId = userId;
        this.dob = dob;
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

  //toString()
    @Override
    public String toString() {
        return "User [userId = " + userId + ", userPin = " + userPin + ", dob = "
                + dob + ", First Name = " + firstName + "Last Name = " + lastName + "]";
    } 
}
	


