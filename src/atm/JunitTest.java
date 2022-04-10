package atm;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Assert.*;

public class JunitTest {
    
    @Test
    public void testSetPin() {
        User u = new User(null, null, 0, 0, 0);
        u.setPin(2028);
        assertTrue(u.getPin() == 2028);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testDigitPinThatIsNotCorrectDigits() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setPin(3);
    }
    
    @Test
    public void testChangePin() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setPin(4048);
        assertTrue(u.getPin() == 4048);
    }
    
    @Test
    public void testgetPin() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        int pin;
        pin = u.getPin();
        assertTrue(pin == 2028);
    }
    
    @Test
    public void testSetBalance() {
        User u = new User(null, null, 0, 0, 0);
        u.setTotalBalance(2000);
        assertTrue(u.getTotalBalance() == 2000);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidBalance() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setTotalBalance(-200);
    }
    
    @Test
    public void testChangeBalance() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setTotalBalance(4000);
        assertTrue(u.getTotalBalance() == 4000);
    }
    
    @Test
    public void testgetBalance() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        int balance;
        balance = u.getTotalBalance();
        assertTrue(balance == 2000);
    }
    
    @Test
    public void testSetFirstName() {
        User u = new User(null, null, 0, 0, 0);
        u.setFirstName("Alec");
        assertTrue(u.getFirstName().equals("Alec"));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetNullFirstName() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setFirstName(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetEmptyStringFirstName() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setFirstName("");
    }
    
    @Test
    public void testChangeFirstName() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setFirstName("Luke");
        assertTrue(u.getFirstName().equals("Luke"));
    }
    
    @Test
    public void testgetFirstName() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        String firstName;
        firstName = u.getFirstName();
        assertTrue(firstName.equals("Alec"));
    }
    
    @Test
    public void testsetLastName() {
        User u = new User(null, null, 0, 0, 0);
        u.setLastName("Doe");
        
        assertTrue(u.getLastName().equals("Doe"));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetNullLastName() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setLastName(null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetEmptyStringLastName() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setLastName("");
    }
    
    @Test
    public void testChangeLastName() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setLastName("Barne");
        assertTrue(u.getLastName().equals("Barne"));
    }
    
    @Test
    public void testgetLastName() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        String lastName;
        lastName = u.getLastName();
        assertTrue(lastName.equals("Doe"));
    }
    
    @Test
    public void testSetAccountNumber() {
        User u = new User(null, null, 0, 0, 0);
        u.setAccountNumber(20284048);
        
        assertTrue(u.getAccountNumber() == 20284048);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testSetAccountNumberNotDigits() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setAccountNumber(3);
    }
    
    @Test
    public void testChangeAccountNumber() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        u.setAccountNumber(40482028);
        assertTrue(u.getAccountNumber() == 40482028);
    }
    
    @Test
    public void testGetAccountNumber() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        int accountNumber;
        accountNumber = u.getAccountNumber();
        assertTrue(accountNumber == 20284048);
    }
    
    @Test
    public void testDeposited() {
        User u = new User("Alec", "Doe", 2028, 2000, 20284048);
        BankingSys b = new BankingSys("Alec", "Doe", 2028, 2000, 20284048);
        b.depositMoney(200);
    }
    
    
    @Test
    public void testWithdrawlMoney() {
        User u = new User("Alec", "Doe", 2028, 200, 20284048);
        BankingSys b = new BankingSys("Alec", "Doe", 2028, 2000, 20284048);
        b.withdrawlMoney(200);
    }
}


