package atm;

import static org.junit.Assert.*;
import org.junit.*;

/*************************************************
 * Class for JUnit Testing
 *
 * @author Caleb Roe
 * @version March 2, 2022
 *************************************************/
public class AtmTest {
	
	/**
	 * Junit test
	 */
	@Test
	public void testSetPin() {
		User u = new User(null, null, 0, 0, 0);
		u.setPin(2028);
		assertTrue(u.getPin() == 2028);
	}

	/**
	 * Junit test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDigitPinThatIsNotCorrectDigits() {
		User u = new User("Alec", "Doe", 2028, 2000, 202);
		u.setPin(3456);
		assertTrue(u.getPin() == 3456);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testChangePin() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setPin(4048);
		assertTrue(u.getPin() == 4048);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testgetPin() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		int pin;
		pin = u.getPin();
		assertTrue(pin == 2028);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testSetBalance() {
		User u = new User(null, null, 0, 0, 0);
		u.setTotalBalance(2000);
		assertTrue(u.getTotalBalance() == 2000);
	}

	/**
	 * Junit test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidBalance() {
		User u = new User("Alec", "Doe", 2028, 2000, 208);
		u.setTotalBalance(-3000);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testChangeBalance() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setTotalBalance(4000);
		assertTrue(u.getTotalBalance() == 4000);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testgetBalance() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		int balance;
		balance = u.getTotalBalance();
		assertTrue(balance == 2000);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testSetFirstName() {
		User u = new User("S", "s", 0, 0, 0);
		u.setFirstName("Alec");
		assertTrue(u.getFirstName().equals("Alec"));
	}

	/**
	 * Junit test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetNullFirstName() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setFirstName(null);
	}

	/**
	 * Junit test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyStringFirstName() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setFirstName("");
	}

	/**
	 * Junit test
	 */
	@Test
	public void testChangeFirstName() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setFirstName("Luke");
		assertTrue(u.getFirstName().equals("Luke"));
	}

	/**
	 * Junit test
	 */
	@Test
	public void testgetFirstName() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		String firstName;
		firstName = u.getFirstName();
		assertTrue(firstName.equals("Alec"));
	}

	/**
	 * Junit test
	 */
	@Test
	public void testsetLastName() {
		User u = new User("S", "s", 0, 0, 0);
		u.setLastName("Doe");
		assertTrue(u.getLastName().equals("Doe"));
	}

	/**
	 * Junit test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetNullLastName() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setLastName(null);
	}

	/**
	 * Junit test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyStringLastName() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setLastName("");
	}

	/**
	 * Junit test
	 */
	@Test
	public void testChangeLastName() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setLastName("Barne");
		//assertequals(u.getLastName());
		assertTrue(u.getLastName().equals("Barne"));
	}

	/**
	 * Junit test
	 */
	@Test
	public void testgetLastName() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		String lastName;
		lastName = u.getLastName();
		assertTrue(lastName.equals("Doe"));
	}

	/**
	 * Junit test
	 */
	@Test
	public void testSetAccountNumber() {
		User u = new User("S", "s", 0, 0, 0);
		u.setAccountNumber(20284048);

		assertTrue(u.getAccountNumber() == 20284048);
	}

	/**
	 * Junit test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetAccountNumberNotDigits() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setAccountNumber(3);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testChangeAccountNumber() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setAccountNumber(3001);
		assertTrue(u.getAccountNumber() == 3001);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testGetAccountNumber() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		u.setAccountNumber(2001);
		assertTrue(u.getAccountNumber() == 2001);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testDeposited() {
		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
		BankingSys b = new BankingSys("Alec", "Doe", 2028, 2000, 20284048);
		b.depositMoney(200);
	}

	/**
	 * Junit test
	 */
	@Test
	public void testWithdrawlMoney() {
		User u = new User("Alec", "Doe", 2028, 200, 20284048);
		BankingSys b = new BankingSys("Alec", "Doe", 2028, 2000, 20284048);
		b.withdrawlMoney(200);
	}

}