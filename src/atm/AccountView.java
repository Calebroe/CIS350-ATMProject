package atm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

/*************************************************
 * Front end JPanel for displaying Account Overview Screen
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class AccountView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField pinField, confirmField;
	private JButton returnButton, btnUpdateAccount;
	private JLabel accountBnr, firstNameLbl, lastNameLbl, accountIdLbl, acctChkLbl, acctSvgLbl, changePinLbl,
			confirmNewPinLbl, acctSvgLblResult, acctChkLblResult, accountIdLblResult, lastNameLblResult,
			firstNameLblResult, UserPinLbl, userPinLblResult;
	private static User currentUser;

	Database database = new Database();
	private JLabel balance1;
	private JLabel balance2;
	
	/**
	 * Initialize the frame.
	 */
	public AccountView(User currentUser) {
		getContentPane().setBackground(Color.GRAY);
		setTitle("Atlas ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 458);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 397);
		panel.setLayout(null);
		getContentPane().add(panel);

		accountBnr = new JLabel("Account Details");
		accountBnr.setBounds(42, 11, 226, 25);
		accountBnr.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(accountBnr);

		firstNameLbl = new JLabel("First Name:");
		firstNameLbl.setBounds(25, 60, 94, 20);
		firstNameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(firstNameLbl);

		lastNameLbl = new JLabel("Last Name:");
		lastNameLbl.setBounds(25, 91, 92, 20);
		lastNameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lastNameLbl);

		accountIdLbl = new JLabel("Account ID:");
		accountIdLbl.setBounds(25, 164, 110, 20);
		accountIdLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(accountIdLbl);

		acctChkLbl = new JLabel("Checking Account #:");
		acctChkLbl.setBounds(25, 218, 168, 20);
		acctChkLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(acctChkLbl);

		acctSvgLbl = new JLabel("Savings Account #:");
		acctSvgLbl.setBounds(25, 249, 165, 20);
		acctSvgLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(acctSvgLbl);

		changePinLbl = new JLabel("Change Pin:");
		changePinLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		changePinLbl.setBounds(69, 294, 98, 20);
		panel.add(changePinLbl);

		confirmNewPinLbl = new JLabel("Confirm New Pin:");
		confirmNewPinLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		confirmNewPinLbl.setBounds(25, 325, 142, 20);
		panel.add(confirmNewPinLbl);

		returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnButton.setBounds(10, 356, 98, 29);
		returnButton.addActionListener(new ButtonListener());
		panel.add(returnButton);

		btnUpdateAccount = new JButton("Update Account");
		btnUpdateAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateAccount.setBounds(250, 357, 160, 27);
		btnUpdateAccount.addActionListener(new ButtonListener());
		panel.add(btnUpdateAccount);
		
		ArrayList<Account> a = currentUser.getAllAccounts();
		Account account1 = a.get(0);
		Account account2 = a.get(1);
		
		acctSvgLblResult = new JLabel(Integer.toString(account1.getacctId()));
		acctSvgLblResult.setFont(new Font("Tahoma", Font.ITALIC, 18));
		acctSvgLblResult.setBounds(191, 249, 108, 20);
		panel.add(acctSvgLblResult);

		acctChkLblResult = new JLabel(Integer.toString(account2.getacctId()));
		acctChkLblResult.setFont(new Font("Tahoma", Font.ITALIC, 18));
		acctChkLblResult.setBounds(203, 218, 96, 20);
		panel.add(acctChkLblResult);

		accountIdLblResult = new JLabel(Integer.toString(currentUser.getUserId()));
		accountIdLblResult.setFont(new Font("Tahoma", Font.ITALIC, 16));
		accountIdLblResult.setBounds(130, 164, 108, 20);
		panel.add(accountIdLblResult);

		lastNameLblResult = new JLabel(currentUser.getLastName());
		lastNameLblResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastNameLblResult.setBounds(146, 91, 92, 20);
		panel.add(lastNameLblResult);

		firstNameLblResult = new JLabel(currentUser.getFirstName());
		firstNameLblResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameLblResult.setBounds(146, 60, 94, 20);
		panel.add(firstNameLblResult);

		pinField = new JTextField();
		pinField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pinField.setBounds(177, 296, 157, 20);
		pinField.setColumns(10);
		panel.add(pinField);

		confirmField = new JTextField();
		confirmField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirmField.setColumns(10);
		confirmField.setBounds(177, 327, 157, 20);
		panel.add(confirmField);

		UserPinLbl = new JLabel("User Pin:");
		UserPinLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		UserPinLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		UserPinLbl.setBounds(25, 190, 95, 20);
		panel.add(UserPinLbl);
		
		userPinLblResult = new JLabel(Integer.toString(currentUser.getUserPin()));
		userPinLblResult.setFont(new Font("Tahoma", Font.ITALIC, 16));
		userPinLblResult.setBounds(130, 190, 108, 20);
		panel.add(userPinLblResult);
		
		balance1 = new JLabel("$" + Integer.toString(account1.gettotalBalance()));
		balance1.setFont(new Font("Tahoma", Font.BOLD, 16));
		balance1.setBounds(309, 249, 95, 20);
		panel.add(balance1);
		
		balance2 = new JLabel("$" + Integer.toString(account2.gettotalBalance()));
		balance2.setFont(new Font("Tahoma", Font.BOLD, 16));
		balance2.setBounds(309, 218, 95, 20);
		panel.add(balance2);
		AccountView.currentUser = currentUser;
	}

	 /**************************************************************
    Respond to either button clicks
    @param e the action event that was just fired
    **************************************************************/
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == returnButton) {
				new Main(currentUser).setVisible(true);
				dispose();
			} else if (event.getSource() == btnUpdateAccount) {
				int pin1 = Integer.parseInt(pinField.getText());
				int pin2 = Integer.parseInt(confirmField.getText());
				if(pin1 == pin2) {
					currentUser.updatePin(Integer.parseInt(pinField.getText()));
					JOptionPane.showMessageDialog(null, "Your Pin has been successfully updated to:" + pin1);
				}
				else {
					JOptionPane.showMessageDialog(null, "Pin does not match, please try again");
				}
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountView frame = new AccountView(currentUser);
					frame.setVisible(true);
					frame.setResizable(false);
					// AccountView.updateFields(currentUser);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
