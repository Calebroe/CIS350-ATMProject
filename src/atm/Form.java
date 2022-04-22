package atm;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/*************************************************
 * Front end JPanel for displaying Account Creation Screen
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class Form extends JFrame {

	private JPanel contentPane, panel1;
	private JTextField firstNameField, lastNameField, pinField1, pinField2, stmtField, dobField;
	private JLabel formlbl1, formBanner1, firstNamelbl, lastNamelbl, lblLastName_1, formlbl3, formlbl4, pinlbl1,
			pinlbl2, dobLbl;
	private JButton createbtn, returnButton;

	Database database = new Database();

	/**
	 * Initialize the frame.
	 */
	public Form() {
		setBackground(Color.WHITE);
		setTitle("Atlas ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 510);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(10, 11, 405, 449);
		contentPane.add(panel1);
		panel1.setLayout(null);

		formBanner1 = new JLabel("Account Creation Form");
		formBanner1.setFont(new Font("Tahoma", Font.BOLD, 20));
		formBanner1.setBounds(80, 21, 242, 24);
		panel1.add(formBanner1);

		formlbl1 = new JLabel("Please Enter the following Information:");
		formlbl1.setBounds(33, 56, 225, 24);
		panel1.add(formlbl1);

		formlbl3 = new JLabel("Please enter account pin:");
		formlbl3.setBounds(31, 176, 154, 24);
		panel1.add(formlbl3);

		formlbl4 = new JLabel("must have 4 -- 12 digits");
		formlbl4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		formlbl4.setBounds(31, 192, 154, 24);
		panel1.add(formlbl4);

		firstNamelbl = new JLabel("First Name:");
		firstNamelbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		firstNamelbl.setBounds(67, 81, 69, 24);
		panel1.add(firstNamelbl);

		lastNamelbl = new JLabel("Last Name:");
		lastNamelbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lastNamelbl.setBounds(67, 110, 68, 24);
		panel1.add(lastNamelbl);

		pinlbl1 = new JLabel("Pin:");
		pinlbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		pinlbl1.setBounds(13, 219, 55, 24);
		panel1.add(pinlbl1);

		pinlbl2 = new JLabel("Confirm Pin:");
		pinlbl2.setBounds(10, 250, 58, 24);
		panel1.add(pinlbl2);

		firstNameField = new JTextField();
		firstNameField.setColumns(10);
		firstNameField.setBounds(146, 83, 137, 20);
		panel1.add(firstNameField);

		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(146, 112, 137, 20);
		panel1.add(lastNameField);

		pinField1 = new JTextField();
		pinField1.setColumns(10);
		pinField1.setBounds(78, 221, 109, 20);
		panel1.add(pinField1);

		pinField2 = new JTextField();
		pinField2.setColumns(10);
		pinField2.setBounds(78, 252, 109, 20);
		panel1.add(pinField2);

		createbtn = new JButton("Create Account");
		createbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		createbtn.setBounds(244, 411, 154, 27);
		createbtn.addActionListener(new ButtonListener());
		panel1.add(createbtn);

		returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnButton.setBounds(10, 410, 98, 29);
		returnButton.addActionListener(new ButtonListener());
		panel1.add(returnButton);

		stmtField = new JTextField();
		stmtField.setBackground(Color.LIGHT_GRAY);
		stmtField.setBounds(10, 281, 385, 118);
		panel1.add(stmtField);
		stmtField.setEditable(false);
		stmtField.setFont(new Font("Tahoma", Font.ITALIC, 13));

		dobLbl = new JLabel("Date of Birth:");
		dobLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		dobLbl.setBounds(55, 141, 80, 24);
		panel1.add(dobLbl);

		dobField = new JTextField();
		dobField.setColumns(10);
		dobField.setBounds(145, 143, 137, 20);
		panel1.add(dobField);
	}

	 /**************************************************************
    Respond to either button clicks
    @param e the action event that was just fired
    **************************************************************/
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == returnButton) {
				new Welcome().setVisible(true);
				dispose();
			} else if (event.getSource() == createbtn) {
					int validPin = 0;
					
					String extractedDate = dobField.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date textFieldAsDate = null;
					int tempPin = Integer.parseInt(pinField1.getText());
					int tempPin2 = Integer.parseInt(pinField2.getText());
					int userId = database.getRandomNumberString();
					int acctId1 = database.getRandomAcctString();
					int acctId2 = database.getRandomAcctString();
					String tempLast = lastNameField.getText();
					String tempFirst = firstNameField.getText();
					try {
						textFieldAsDate = sdf.parse(extractedDate);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				try {
					if (tempPin == tempPin2) {
						String acctType = "Savings";
						validPin = tempPin;
						sdf = new SimpleDateFormat("yyyy-MM-dd");
						java.sql.Date date = java.sql.Date.valueOf(sdf.format(textFieldAsDate));
						database.createUserAccount(tempFirst, tempLast, userId, tempPin, date);
						database.createAccount(acctId1, userId, acctType);
						acctType = "Checking";
						database.createAccount(acctId2, userId, acctType);
						stmtField.setText("New Account Holder:" + tempFirst + " " + tempLast + " was successfully created!/n" + "Account Number: "
								+ userId + "Savings Account #: " + acctId1 + "Checking Account #: " + acctId2);
					} else {
						stmtField.setText("Pin does not match, please retry");
					}
				} catch (Exception e) {
					stmtField.setText("There was a problem setting up your account, please confirm information");
				}
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
