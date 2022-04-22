package atm;

import java.awt.EventQueue;
//import java.sql.SQLException;
//import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/*************************************************
 * Front end JPanel for displaying Login Screen
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class Welcome extends JFrame {

	/*************************************************
	 * Front end JPanel for displaying Deposit Screen
	 *
	 * @author Caleb Roe
	 * @version April 21, 2022
	 *************************************************/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	private JLabel titleBanner, titleBanner2, titleBanner3, userBanner, acctBanner, acctLbl, pinLbl;
	private JButton loginBtn, CreateAcctBtn;
	private JTextField acctField;
	private JPasswordField pinField;
	private static User currentUser;

	/**
	 * Initialize the frame.
	 */
	public Welcome() {
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("Atlas ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 363, 446);
		contentPane.add(panel);
		panel.setLayout(null);

		titleBanner = new JLabel("Atlas");
		titleBanner.setHorizontalAlignment(SwingConstants.CENTER);
		titleBanner.setFont(new Font("Tahoma", Font.BOLD, 35));
		titleBanner.setBounds(125, 48, 89, 43);
		panel.add(titleBanner);

		titleBanner2 = new JLabel("Automated Telling");
		titleBanner2.setHorizontalAlignment(SwingConstants.CENTER);
		titleBanner2.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleBanner2.setBounds(82, 93, 185, 25);
		panel.add(titleBanner2);

		titleBanner3 = new JLabel("Machine");
		titleBanner3.setHorizontalAlignment(SwingConstants.CENTER);
		titleBanner3.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleBanner3.setBounds(125, 129, 85, 25);
		panel.add(titleBanner3);

		loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginBtn.setBounds(125, 279, 89, 23);
		loginBtn.addActionListener(new ButtonListener());
		panel.add(loginBtn);

		userBanner = new JLabel("Existing User?");
		userBanner.setFont(new Font("Tahoma", Font.BOLD, 15));
		userBanner.setBounds(123, 181, 128, 19);
		panel.add(userBanner);

		acctBanner = new JLabel("Become an Account Holder");
		acctBanner.setFont(new Font("Tahoma", Font.BOLD, 15));
		acctBanner.setBounds(81, 335, 220, 14);
		panel.add(acctBanner);

		CreateAcctBtn = new JButton("Create Account");
		CreateAcctBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		CreateAcctBtn.setBounds(103, 360, 148, 23);
		CreateAcctBtn.addActionListener(new ButtonListener());
		panel.add(CreateAcctBtn);

		acctField = new JTextField();
		acctField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		acctField.setColumns(10);
		acctField.setBounds(145, 213, 122, 20);
		panel.add(acctField);

		acctLbl = new JLabel("Account #:");
		acctLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		acctLbl.setBounds(81, 216, 54, 14);
		panel.add(acctLbl);

		pinLbl = new JLabel("PIN #:");
		pinLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		pinLbl.setBounds(103, 241, 32, 14);
		panel.add(pinLbl);

		pinField = new JPasswordField();
		pinField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pinField.setBounds(145, 238, 122, 20);
		panel.add(pinField);

		currentUser = new User();
	}

	/**************************************************************
	 * Respond to either button clicks
	 * 
	 * @param e the action event that was just fired
	 **************************************************************/
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == loginBtn) {
				int userId = Integer.parseInt(acctField.getText());
				int userPin = Integer.parseInt(pinField.getText());
				// call method in database
				try {
					currentUser.getUserAccount(userPin, userId);
					new Main(currentUser).setVisible(true);
					dispose();

				} catch (Exception e) {
					// create unique exceptions and check exception e to see which error was thrown
				}
			} else if (event.getSource() == CreateAcctBtn) {
				new Form().setVisible(true);
				dispose();
			}
		}
	}

	/**
	 * main method to call class initialize
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
