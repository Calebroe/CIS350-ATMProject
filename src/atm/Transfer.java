package atm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

/*************************************************
 * Front end JPanel for displaying Transfer Screen
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class Transfer extends JFrame {

	private JPanel contentPane, transferPanel;
	private JTextField amtTrnField;
	private JButton returnButton, transferBtn, clearBtn;
	JTextArea stmtField;
	//private static User[] users;
	private static User currentUser, transferUser;
	private JLabel transferlbl, acctTransferTo, amtTransfer, dollarSign, acctTransferFrom;
	
	Database database = new Database();
	JComboBox comboBox1 = new JComboBox();
	JComboBox comboBox2 = new JComboBox();
	private JLabel savingsAcct;
	private JLabel checkingAcct;
		
	/**
	 * Initialize the frame.
	 */
	public Transfer(User currentUser) {
		setTitle("ATLAS ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 589);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		transferPanel = new JPanel();
		transferPanel.setBackground(Color.WHITE);
		transferPanel.setBounds(10, 11, 496, 528);
		contentPane.add(transferPanel);
		transferPanel.setLayout(null);
		
		transferlbl = new JLabel("TRANSFER");
		transferlbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		transferlbl.setHorizontalAlignment(SwingConstants.CENTER);
		transferlbl.setBounds(157, 11, 177, 40);
		transferPanel.add(transferlbl);
		
		acctTransferTo = new JLabel("Accout number to transfer to:");
		acctTransferTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		acctTransferTo.setBounds(25, 239, 221, 29);
		transferPanel.add(acctTransferTo);
		
		amtTransfer = new JLabel("Amount to transfer:");
		amtTransfer.setFont(new Font("Tahoma", Font.BOLD, 15));
		amtTransfer.setBounds(25, 322, 177, 29);
		transferPanel.add(amtTransfer);
		
		amtTrnField = new JTextField("0.00");
		amtTrnField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		amtTrnField.setBounds(192, 324, 106, 29);
		transferPanel.add(amtTrnField);
		
		dollarSign = new JLabel("$");
		dollarSign.setFont(new Font("Tahoma", Font.BOLD, 15));
		dollarSign.setBounds(180, 322, 10, 29);
		transferPanel.add(dollarSign);
		
		clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearBtn.setBounds(192, 364, 106, 23);
		clearBtn.addActionListener(new ButtonListener());
		transferPanel.add(clearBtn);
		
		transferBtn = new JButton("Transfer");
		transferBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		transferBtn.setBounds(365, 375, 121, 29);
		transferBtn.addActionListener(new ButtonListener());
		transferPanel.add(transferBtn);
		
		returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		returnButton.setBounds(10, 375, 121, 29);
		returnButton.addActionListener(new ButtonListener());
		transferPanel.add(returnButton);
		
		stmtField = new JTextArea();
		stmtField.setBackground(Color.LIGHT_GRAY);
		stmtField.setBounds(10, 415, 476, 99);
		transferPanel.add(stmtField);
		
		for (Account a : currentUser.getAllAccounts()) {
			comboBox1.addItem(a.getacctId());
		}
		comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox1.setBounds(69, 205, 221, 23); //create new position using windowbuilder
		transferPanel.add(comboBox1);
		
		for (Account a : currentUser.getAllAccounts()) {
			comboBox2.addItem(a.getacctId());
		}
		comboBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox2.setBounds(69, 279, 221, 23); //create new position using windowbuilder
		transferPanel.add(comboBox2);
		
		acctTransferFrom = new JLabel("Accout number to transfer from:");
		acctTransferFrom.setFont(new Font("Tahoma", Font.BOLD, 15));
		acctTransferFrom.setBounds(25, 165, 286, 29);
		transferPanel.add(acctTransferFrom);
		
		ArrayList<Account> a = currentUser.getAllAccounts();
		Account account1 = a.get(0);
		Account account2 = a.get(1);
		
		savingsAcct = new JLabel(account1.getacctId() + "-" + account1.getAcctType() + "($" + account1.gettotalBalance() + ")");
		savingsAcct.setFont(new Font("Tahoma", Font.BOLD, 15));
		savingsAcct.setBounds(25, 59, 371, 29);
		transferPanel.add(savingsAcct);
		
		checkingAcct = new JLabel(account2.getacctId() + "-" + account2.getAcctType() + "($" + account2.gettotalBalance() + ")");
		checkingAcct.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkingAcct.setBounds(25, 99, 371, 29);
		transferPanel.add(checkingAcct);
		
		
		
		Transfer.currentUser = currentUser;
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
			else if(event.getSource() == transferBtn) {
				try {
					int acctId1 = (Integer) comboBox1.getSelectedItem();
					int acctId2 = (Integer) comboBox2.getSelectedItem();
					int value = Integer.parseInt(amtTrnField.getText());
					Account accountFrom = currentUser.getAccount(acctId1);
					Account accountTo = currentUser.getAccount(acctId2);
					if(value <= 0) {
						stmtField.setText("Unable to transfer $0.00 into an account"); 
					}
					else if(accountFrom.canWithdrawAmount(value) != true) {
						stmtField.setText("Amount to transfer exceeds the current Balance of " + accountFrom); 
					}
					else {
						int oldVal = accountFrom.withdrawFromAccount(value);
						int newVal = accountTo.depositIntoAccount(value);
						stmtField.setText("Transferred $" + value + ", From: " + accountFrom + " To: " + accountTo);
						amtTrnField.setText("0.00"); 
						//savingsAcct.setText(account1.getacctId() + account1.getAcctType() + account1.gettotalBalance());
						//checkingAcct =.setText(account2.getacctId() + account2.getAcctType() + account2.gettotalBalance());
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "There was an error in completing your request, please try again");
				}
					amtTrnField.setText("");
				}
			else if(event.getSource() == clearBtn) {
				amtTrnField.setText("0.00");
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer frame = new Transfer(currentUser);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
