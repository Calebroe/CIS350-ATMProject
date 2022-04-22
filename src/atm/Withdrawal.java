package atm;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*************************************************
 * Front end JPanel for displaying Withdraw Screen
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class Withdrawal extends JFrame {

	private JPanel contentPane, withdrawalPanel;
	private JTextField withdrawField, currBalanceField, prevBalanceField, stmtField;
	private JLabel amtBnner, towthdrwBnr, currentBnnr, previousBnnr, userInfo;
	private JButton returnButton, confirmBtn, clearBtn, oneDollarBtn, fiveDollarBtn, tenDollarBtn, twentyDollarBtn, fiftyDollarBtn, hundredDollarBtn;
	private static User currentUser;
	private int withdrawVal;
	
	Database database = new Database();
	JComboBox comboBox = new JComboBox();
	private JLabel lblPleaseSelectAccount;
	private JLabel depositLbl;
	
	/**
	 * Initialize the frame.
	 */
	public Withdrawal(User currentUser) {
		setTitle("ATLAS ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		withdrawalPanel = new JPanel();
		withdrawalPanel.setLayout(null);
		withdrawalPanel.setBackground(Color.WHITE);
		withdrawalPanel.setBounds(10, 11, 554, 411);
		contentPane.add(withdrawalPanel);
		
		oneDollarBtn = new JButton("$1");
		oneDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		oneDollarBtn.setBackground(Color.LIGHT_GRAY);
		oneDollarBtn.setBounds(51, 140, 116, 37);
		oneDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(oneDollarBtn);
		
		fiveDollarBtn = new JButton("$5");
		fiveDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		fiveDollarBtn.setBackground(Color.LIGHT_GRAY);
		fiveDollarBtn.setBounds(51, 188, 116, 37);
		fiveDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(fiveDollarBtn);
		
		tenDollarBtn = new JButton("$10");
		tenDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		tenDollarBtn.setBackground(Color.LIGHT_GRAY);
		tenDollarBtn.setBounds(51, 236, 116, 37);
		tenDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(tenDollarBtn);
		
		twentyDollarBtn = new JButton("$20");
		twentyDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		twentyDollarBtn.setBackground(Color.LIGHT_GRAY);
		twentyDollarBtn.setBounds(177, 140, 116, 37);
		twentyDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(twentyDollarBtn);
		
		fiftyDollarBtn = new JButton("$50");
		fiftyDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		fiftyDollarBtn.setBackground(Color.LIGHT_GRAY);
		fiftyDollarBtn.setBounds(177, 188, 116, 37);
		fiftyDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(fiftyDollarBtn);
		
		hundredDollarBtn = new JButton("$100");
		hundredDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		hundredDollarBtn.setBackground(Color.LIGHT_GRAY);
		hundredDollarBtn.setBounds(177, 236, 116, 37);
		hundredDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(hundredDollarBtn);
		
		amtBnner = new JLabel("Please Specify Amount to Withdrawal");
		amtBnner.setFont(new Font("Tahoma", Font.ITALIC, 16));
		amtBnner.setBounds(39, 92, 292, 37);
		withdrawalPanel.add(amtBnner);
		
		returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnButton.setBounds(10, 377, 116, 23);
		returnButton.addActionListener(new ButtonListener());
		withdrawalPanel.add(returnButton);
		
		towthdrwBnr = new JLabel("Amount to Withdrawal:");
		towthdrwBnr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		towthdrwBnr.setBounds(24, 281, 143, 37);
		withdrawalPanel.add(towthdrwBnr);
		
		withdrawField = new JTextField();
		withdrawField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		withdrawField.setEditable(false);
		withdrawField.setColumns(10);
		withdrawField.setBounds(187, 284, 116, 31);
		withdrawField.setText("0.00");
		withdrawalPanel.add(withdrawField);
		
		clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearBtn.setBounds(95, 326, 116, 23);
		clearBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(clearBtn);
		
		confirmBtn = new JButton("Confirm");
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmBtn.setBounds(428, 363, 116, 37);
		confirmBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(confirmBtn);
		
		currentBnnr = new JLabel("Previous Account Balance:");
		currentBnnr.setFont(new Font("Tahoma", Font.BOLD, 15));
		currentBnnr.setBounds(327, 174, 206, 37);
		withdrawalPanel.add(currentBnnr);
		
		previousBnnr = new JLabel("Current Account Balance:");
		previousBnnr.setFont(new Font("Tahoma", Font.BOLD, 15));
		previousBnnr.setBounds(327, 78, 206, 37);
		withdrawalPanel.add(previousBnnr);
		
		currBalanceField = new JTextField();
		currBalanceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currBalanceField.setEditable(false);
		currBalanceField.setColumns(10);
		currBalanceField.setBounds(353, 225, 161, 27);
		withdrawalPanel.add(currBalanceField);
		
		prevBalanceField = new JTextField();
		prevBalanceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prevBalanceField.setEditable(false);
		prevBalanceField.setColumns(10);
		prevBalanceField.setBounds(353, 125, 161, 27);
		//prevBalanceField.setText("$  "+ currentUser.getTotalBalance() +".00");
		withdrawalPanel.add(prevBalanceField);
		
		userInfo = new JLabel("New label");
		userInfo.setBounds(327, 11, 206, 14);
		userInfo.setText("Welcome back " + currentUser.getFirstName() + " " + currentUser.getLastName());
		withdrawalPanel.add(userInfo);
		
		for (Account a : currentUser.getAllAccounts()) {
			comboBox.addItem(a.getacctId());
			// + "-" + a.getAcctType() + "($" + a.gettotalBalance() + ")"
		}
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(39, 58, 247, 23);
		withdrawalPanel.add(comboBox);
		
		lblPleaseSelectAccount = new JLabel("Please Select Account");
		lblPleaseSelectAccount.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPleaseSelectAccount.setBounds(39, 11, 292, 37);
		withdrawalPanel.add(lblPleaseSelectAccount);
		
		depositLbl = new JLabel("$");
		depositLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositLbl.setBounds(175, 281, 13, 37);
		withdrawalPanel.add(depositLbl);
		
		stmtField = new JTextField();
		stmtField.setEditable(false);
		stmtField.setFont(new Font("Tahoma", Font.ITALIC, 13));
		stmtField.setBounds(10, 433, 554, 105);
		contentPane.add(stmtField);
		
		Withdrawal.currentUser = currentUser;
	}
	
	 /**************************************************************
    Respond to either button clicks
    @param e the action event that was just fired
    **************************************************************/
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == returnButton) {
				new Main(currentUser).setVisible(true);
				dispose();
			}
			else if(event.getSource() == confirmBtn) {
				try {
					int acctId = (Integer) comboBox.getSelectedItem();
					int value = Integer.parseInt(withdrawField.getText());
					Account account = currentUser.getAccount(acctId);
					
					if(account.canWithdrawAmount(value) != true) {
						stmtField.setText("Unable to deposit amount into account. deposit amount exceeds current account balance"); 
					}
					else if(value > 0) {
						int oldVal = account.withdrawFromAccount(value);
						prevBalanceField.setText(Integer.toString(oldVal));
						currBalanceField.setText(Integer.toString(account.gettotalBalance()));
						stmtField.setText("Successfully withdrew $" + value + "From Account:" + account); 
					}
					else {
						JOptionPane.showMessageDialog(null, "Unable to deposit $0.00 into an account");
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Amount to withdraw exceeds current Balance");
				}
			}
			else if(event.getSource() == clearBtn) {
				withdrawVal = 0;
				withdrawField.setText(Integer.toString(withdrawVal));
			}
			else if(event.getSource() == oneDollarBtn) {
				withdrawVal++;
				withdrawField.setText(Integer.toString(withdrawVal));
				
			}
			else if(event.getSource() == fiveDollarBtn) {
				withdrawVal = withdrawVal + 5;
				withdrawField.setText(Integer.toString(withdrawVal));
			}
			else if(event.getSource() == tenDollarBtn) {
				withdrawVal = withdrawVal + 10;
				withdrawField.setText(Integer.toString(withdrawVal));
			}
			else if(event.getSource() == twentyDollarBtn) {
				withdrawVal = withdrawVal + 20;
				withdrawField.setText(Integer.toString(withdrawVal));
			}
			else if(event.getSource() == fiftyDollarBtn) {
				withdrawVal = withdrawVal + 50;
				withdrawField.setText(Integer.toString(withdrawVal));
			}
			else if(event.getSource() == hundredDollarBtn) {
				withdrawVal = withdrawVal + 100;
				withdrawField.setText(Integer.toString(withdrawVal));
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawal frame = new Withdrawal(currentUser);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
