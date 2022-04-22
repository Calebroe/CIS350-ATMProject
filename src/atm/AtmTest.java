package atm;

import static org.junit.Assert.*;
import org.junit.*;

/*************************************************
 * Class for JUnit Testing
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class AtmTest {

	/**
	 * JUnit test
	 */
	@Test
	public void testLastName() {
		User user = null;
		User user1 = user.getUserAccount(9999, 9999);
		user1.setFirstName("Test1");
		assertTrue(user1.getLastName() == "Test1");
	}

	/**
	 * JUnit test
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDigitPinThatIsNotCorrectDigits() {
		User user = null;
		User user1 = user.getUserAccount(9999, 9999);
		user1.getUserPin();
		assertTrue(user1.getUserPin() == 8888);
	}

	/**
	 * JUnit test
	 */
	@Test
	public void testChangePin() {
		User user = null;
		User user1 = user.getUserAccount(9999, 9999);
		user1.updatePin(9998);
		assertTrue(user1.getUserPin() == 9998);
	}

	/**
	 * JUnit test
	 */
	@Test
	public void testGetFirstName() {
		User user = null;
		User user1 = user.getUserAccount(9999, 9999);
		assertTrue(user1.getFirstName() == "test");
	}

	/**
	 * JUnit test
	 */
	@Test
	public void testGetAccount() {
		User user = null;
		User user1 = user.getUserAccount(9999, 9999);
		Account account = user1.getAccount(11111);
		assertTrue(account.getacctId() == 11111);
	}

//	/**
//	 * Junit test
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void testInvalidBalance() {
//		User u = new User("Alec", "Doe", 2028, 2000, 208);
//		u.setTotalBalance(-3000);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testChangeBalance() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setTotalBalance(4000);
//		assertTrue(u.getTotalBalance() == 4000);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testgetBalance() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		int balance;
//		balance = u.getTotalBalance();
//		assertTrue(balance == 2000);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testSetFirstName() {
//		User u = new User("S", "s", 0, 0, 0);
//		u.setFirstName("Alec");
//		assertTrue(u.getFirstName().equals("Alec"));
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void testSetNullFirstName() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setFirstName(null);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void testSetEmptyStringFirstName() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setFirstName("");
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testChangeFirstName() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setFirstName("Luke");
//		assertTrue(u.getFirstName().equals("Luke"));
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testgetFirstName() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		String firstName;
//		firstName = u.getFirstName();
//		assertTrue(firstName.equals("Alec"));
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testsetLastName() {
//		User u = new User("S", "s", 0, 0, 0);
//		u.setLastName("Doe");
//		assertTrue(u.getLastName().equals("Doe"));
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void testSetNullLastName() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setLastName(null);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void testSetEmptyStringLastName() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setLastName("");
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testChangeLastName() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setLastName("Barne");
//		// assertequals(u.getLastName());
//		assertTrue(u.getLastName().equals("Barne"));
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testgetLastName() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		String lastName;
//		lastName = u.getLastName();
//		assertTrue(lastName.equals("Doe"));
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testSetAccountNumber() {
//		User u = new User("S", "s", 0, 0, 0);
//		u.setAccountNumber(20284048);
//
//		assertTrue(u.getAccountNumber() == 20284048);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test(expected = IllegalArgumentException.class)
//	public void testSetAccountNumberNotDigits() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setAccountNumber(3);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testChangeAccountNumber() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setAccountNumber(3001);
//		assertTrue(u.getAccountNumber() == 3001);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testGetAccountNumber() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		u.setAccountNumber(2001);
//		assertTrue(u.getAccountNumber() == 2001);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testDeposited() {
//		User u = new User("Alec", "Doe", 2028, 2000, 20284048);
//		BankingSys b = new BankingSys("Alec", "Doe", 2028, 2000, 20284048);
//		b.depositMoney(200);
//	}
//
//	/**
//	 * Junit test
//	 */
//	@Test
//	public void testWithdrawlMoney() {
//		User u = new User("Alec", "Doe", 2028, 200, 20284048);
//		BankingSys b = new BankingSys("Alec", "Doe", 2028, 2000, 20284048);
//		b.withdrawlMoney(200);
//	}

}