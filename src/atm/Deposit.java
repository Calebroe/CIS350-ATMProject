package atm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/*************************************************
 * Front end JPanel for displaying Deposit Screen
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class Deposit extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, depositPanel;
	private JButton returnButton, confirmBtn, clearBtn, oneDollarBtn, fiveDollarBtn, tenDollarBtn, twentyDollarBtn, fiftyDollarBtn, hundredDollarBtn;
	private JTextField depositField, currBalanceField, prevBalanceField, stmtField;
	private JLabel userInfo, amtBnner, todepositBnr, currentBnnr, previousBnnr, depositLbl, lblPleaseSelectAccount;
	private static User currentUser;
	private int depositVal;
	
	Database database = new Database();
	JComboBox comboBox = new JComboBox();
	
	/**
	 * Initialize the frame.
	 */
	public Deposit(User currentUser) {
		
		setTitle("ATLAS ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		depositPanel = new JPanel();
		depositPanel.setBounds(10, 11, 554, 411);
		depositPanel.setBackground(Color.WHITE);
		contentPane.add(depositPanel);
		depositPanel.setLayout(null);
		
		depositLbl = new JLabel("$");
		depositLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositLbl.setBounds(165, 266, 13, 37);
		depositPanel.add(depositLbl);
		
		oneDollarBtn = new JButton("$1");
		oneDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		oneDollarBtn.setBackground(Color.LIGHT_GRAY);
		oneDollarBtn.setBounds(50, 125, 116, 37);
		oneDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(oneDollarBtn);
		
		fiveDollarBtn = new JButton("$5");
		fiveDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		fiveDollarBtn.setBackground(Color.LIGHT_GRAY);
		fiveDollarBtn.setBounds(50, 173, 116, 37);
		fiveDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(fiveDollarBtn);
		
		tenDollarBtn = new JButton("$10");
		tenDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		tenDollarBtn.setBackground(Color.LIGHT_GRAY);
		tenDollarBtn.setBounds(50, 221, 116, 37);
		tenDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(tenDollarBtn);
		
		twentyDollarBtn = new JButton("$20");
		twentyDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		twentyDollarBtn.setBackground(Color.LIGHT_GRAY);
		twentyDollarBtn.setBounds(176, 125, 116, 37);
		twentyDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(twentyDollarBtn);
		
		fiftyDollarBtn = new JButton("$50");
		fiftyDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		fiftyDollarBtn.setBackground(Color.LIGHT_GRAY);
		fiftyDollarBtn.setBounds(176, 173, 116, 37);
		fiftyDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(fiftyDollarBtn);
		
		hundredDollarBtn = new JButton("$100");
		hundredDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		hundredDollarBtn.setBackground(Color.LIGHT_GRAY);
		hundredDollarBtn.setBounds(176, 221, 116, 37);
		hundredDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(hundredDollarBtn);
		
		amtBnner = new JLabel("Please Specify Amount to Deposit");
		amtBnner.setFont(new Font("Tahoma", Font.ITALIC, 16));
		amtBnner.setBounds(50, 94, 253, 20);
		depositPanel.add(amtBnner);
		
		returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnButton.setBounds(10, 377, 116, 23);
		returnButton.addActionListener(new ButtonListener());
		depositPanel.add(returnButton);
		
		todepositBnr = new JLabel("Amount to Deposit:");
		todepositBnr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		todepositBnr.setBounds(34, 266, 132, 37);
		depositPanel.add(todepositBnr);
		
		depositField = new JTextField();
		depositField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		depositField.setEditable(false);
		depositField.setBounds(176, 269, 116, 31);
		depositField.setText("0.00");
		depositPanel.add(depositField);
		
		clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearBtn.setBounds(95, 314, 116, 23);
		clearBtn.addActionListener(new ButtonListener());
		depositPanel.add(clearBtn);
		
		confirmBtn = new JButton("Confirm");
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmBtn.setBounds(428, 363, 116, 37);
		confirmBtn.addActionListener(new ButtonListener());
		depositPanel.add(confirmBtn);
		
		currentBnnr = new JLabel("Previous Account Balance:");
		currentBnnr.setFont(new Font("Tahoma", Font.BOLD, 15));
		currentBnnr.setBounds(348, 174, 206, 37);
		depositPanel.add(currentBnnr);
		
		previousBnnr = new JLabel("Current Account Balance:");
		previousBnnr.setFont(new Font("Tahoma", Font.BOLD, 15));
		previousBnnr.setBounds(348, 78, 197, 37);
		depositPanel.add(previousBnnr);
		
		currBalanceField = new JTextField();
		currBalanceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currBalanceField.setEditable(false);
		currBalanceField.setBounds(358, 229, 161, 27);
		depositPanel.add(currBalanceField);
		currBalanceField.setColumns(10);
		
		prevBalanceField = new JTextField();
		prevBalanceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prevBalanceField.setEditable(false);
		prevBalanceField.setColumns(10);
		prevBalanceField.setBounds(358, 133, 161, 27);
		//prevBalanceField.setText("$  "+currentUser.getTotalBalance()+".00");
		depositPanel.add(prevBalanceField);
		
		userInfo = new JLabel("New label");
		userInfo.setBounds(338, 18, 206, 14);
		userInfo.setText("Welcome back " + currentUser.getFirstName() + " " + currentUser.getLastName());
		depositPanel.add(userInfo);
		
		for (Account a : currentUser.getAllAccounts()) {
			comboBox.addItem(a.getacctId());
		}
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(50, 44, 197, 23);
		depositPanel.add(comboBox);
		
		lblPleaseSelectAccount = new JLabel("Please Select Account");
		lblPleaseSelectAccount.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPleaseSelectAccount.setBounds(50, 13, 161, 20);
		depositPanel.add(lblPleaseSelectAccount);
		
		stmtField = new JTextField();
		stmtField.setEditable(false);
		stmtField.setFont(new Font("Tahoma", Font.ITALIC, 13));
		stmtField.setBounds(10, 433, 554, 105);
		contentPane.add(stmtField);
		
		//Deposit.users = users;  //= Deposit.users;
		Deposit.currentUser = currentUser;
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
				int acctId = (Integer) comboBox.getSelectedItem();
				int value = Integer.parseInt(depositField.getText());
				Account account = currentUser.getAccount(acctId);
				if(value > 0) {
					int oldVal = account.depositIntoAccount(value);
					prevBalanceField.setText(Integer.toString(oldVal));
					currBalanceField.setText(Integer.toString(account.gettotalBalance()));
					
				}
				else {
					stmtField.setText("Unable to deposit amount into account"); 
				}
			}
			else if(event.getSource() == clearBtn) {
				depositVal = 0;
				depositField.setText(Integer.toString(depositVal));
			}
			else if(event.getSource() == oneDollarBtn) {
				depositVal++;
				depositField.setText(Integer.toString(depositVal));
			}
			else if(event.getSource() == fiveDollarBtn) {
				depositVal = depositVal + 5;
				depositField.setText(Integer.toString(depositVal));
			}
			else if(event.getSource() == tenDollarBtn) {
				depositVal = depositVal + 10;
				depositField.setText(Integer.toString(depositVal));
			}
			else if(event.getSource() == twentyDollarBtn) {
				depositVal = depositVal + 20;
				depositField.setText(Integer.toString(depositVal));
			}
			else if(event.getSource() == fiftyDollarBtn) {
				depositVal = depositVal + 50;
				depositField.setText(Integer.toString(depositVal));
			}
			else if(event.getSource() == hundredDollarBtn) {
				depositVal = depositVal + 100;
				depositField.setText(Integer.toString(depositVal));
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit(currentUser);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
