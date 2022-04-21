package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atm.Main.ButtonListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AccountView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField pinField, confirmField;
	private JButton returnButton, btnUpdateAccount;
	private JLabel accountBnr, firstNameLbl, lastNameLbl, dobLbl, accountIdLbl, acctChkLbl, acctSvgLbl, changePinLbl,
			confirmNewPinLbl, acctSvgLblResult, acctChkLblResult, accountIdLblResult, dobLblResult, lastNameLblResult,
			firstNameLblResult;
	private static User currentUser;

	Database database = new Database();

	public AccountView(User currentUser) {
		getContentPane().setBackground(Color.GRAY);
		setTitle("Atlas ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 560);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 499);
		panel.setLayout(null);
		getContentPane().add(panel);

		accountBnr = new JLabel("Account Details");
		accountBnr.setBounds(10, 11, 157, 25);
		accountBnr.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(accountBnr);

		firstNameLbl = new JLabel("First Name:");
		firstNameLbl.setBounds(25, 60, 94, 20);
		firstNameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(firstNameLbl);

		lastNameLbl = new JLabel("Last Name:");
		lastNameLbl.setBounds(25, 91, 92, 20);
		lastNameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lastNameLbl);

		dobLbl = new JLabel("Date of Birth:");
		dobLbl.setBounds(25, 122, 111, 20);
		dobLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(dobLbl);

		accountIdLbl = new JLabel("Account ID:");
		accountIdLbl.setBounds(25, 164, 95, 20);
		accountIdLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(accountIdLbl);

		acctChkLbl = new JLabel("Checking Account #:");
		acctChkLbl.setBounds(25, 195, 168, 20);
		acctChkLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(acctChkLbl);

		acctSvgLbl = new JLabel("Savings Account #:");
		acctSvgLbl.setBounds(25, 226, 156, 20);
		acctSvgLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(acctSvgLbl);

		changePinLbl = new JLabel("Change Pin:");
		changePinLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		changePinLbl.setBounds(25, 294, 98, 20);
		panel.add(changePinLbl);

		confirmNewPinLbl = new JLabel("Confirm New Pin:");
		confirmNewPinLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		confirmNewPinLbl.setBounds(25, 350, 142, 20);
		panel.add(confirmNewPinLbl);

		returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnButton.setBounds(10, 459, 98, 29);
		returnButton.addActionListener(new ButtonListener());
		panel.add(returnButton);

		btnUpdateAccount = new JButton("Update Account");
		btnUpdateAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateAccount.setBounds(250, 460, 154, 27);
		btnUpdateAccount.addActionListener(new ButtonListener());
		panel.add(btnUpdateAccount);

		acctSvgLblResult = new JLabel("Savings Account #:");
		acctSvgLblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		acctSvgLblResult.setBounds(191, 226, 156, 20);
		panel.add(acctSvgLblResult);

		acctChkLblResult = new JLabel("Checking Account #:");
		acctChkLblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		acctChkLblResult.setBounds(203, 195, 168, 20);
		panel.add(acctChkLblResult);

		accountIdLblResult = new JLabel("Account ID:");
		accountIdLblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		accountIdLblResult.setBounds(130, 164, 95, 20);
		panel.add(accountIdLblResult);

		dobLblResult = new JLabel("Date of Birth:");
		dobLblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dobLblResult.setBounds(146, 122, 111, 20);
		panel.add(dobLblResult);

		lastNameLblResult = new JLabel("Last Name:");
		lastNameLblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameLblResult.setBounds(146, 91, 92, 20);
		panel.add(lastNameLblResult);

		firstNameLblResult = new JLabel("First Name:");
		firstNameLblResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameLblResult.setBounds(146, 60, 94, 20);
		panel.add(firstNameLblResult);

		pinField = new JTextField();
		pinField.setBounds(146, 296, 157, 20);
		pinField.setColumns(10);
		panel.add(pinField);

		confirmField = new JTextField();
		confirmField.setColumns(10);
		confirmField.setBounds(177, 352, 157, 20);
		panel.add(confirmField);

		AccountView.currentUser = currentUser;
		// acctSvgLblResult.setText(Integer.toString(currentUser.getAllAccounts()));
		// acctChkLblResult.setText(Integer.toString(currentUser.getUserId()));
		accountIdLblResult.setText(String.valueOf(currentUser.getUserId()));
		//dobLblResult.setText(currentUser.getDob());
		lastNameLblResult.setText(currentUser.getLastName());
		firstNameLblResult.setText(currentUser.getFirstName());
	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == returnButton) {
				new Main(currentUser).setVisible(true);
				dispose();
			} else if (event.getSource() == btnUpdateAccount) {
				// call method from database to push new pin information to database
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
