package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atm.Withdrawal.ButtonListener;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Transfer extends JFrame {

	private JPanel contentPane, transferPanel;
	private JTextField acctTrnField, amtTrnField, authPinField, acctNumField, acctBlncField;
	private JButton returnButton, transferBtn, clearBtn;
	JTextArea stmtField;
	//private static User[] users;
	private static User currentUser, transferUser;
	private JLabel acctNum, acctBlnc, authPin, transferlbl, acctTransfer, amtTransfer, dollarSign;
	private int transferVal = 0;
	
	Database database = new Database();
	JComboBox comboBox1 = new JComboBox();
	JComboBox comboBox2 = new JComboBox();
		
	/**
	 * Initialize JFrame.
	 */
	public Transfer(User currentUser) {
		setTitle("ATLAS ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 692);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		transferPanel = new JPanel();
		transferPanel.setBackground(Color.WHITE);
		transferPanel.setBounds(10, 11, 496, 631);
		contentPane.add(transferPanel);
		transferPanel.setLayout(null);
		
		transferlbl = new JLabel("TRANSFER");
		transferlbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		transferlbl.setHorizontalAlignment(SwingConstants.CENTER);
		transferlbl.setBounds(157, 11, 177, 40);
		transferPanel.add(transferlbl);
		
		acctTrnField = new JTextField();
		acctTrnField.setBounds(256, 192, 90, 29);
		transferPanel.add(acctTrnField);
		
		acctTransfer = new JLabel("Accout number to transfer to:");
		acctTransfer.setFont(new Font("Tahoma", Font.BOLD, 15));
		acctTransfer.setBounds(25, 190, 221, 29);
		transferPanel.add(acctTransfer);
		
		amtTransfer = new JLabel("Amount to transfer:");
		amtTransfer.setFont(new Font("Tahoma", Font.BOLD, 15));
		amtTransfer.setBounds(25, 242, 177, 29);
		transferPanel.add(amtTransfer);
		
		amtTrnField = new JTextField();
		amtTrnField.setBounds(256, 244, 106, 29);
		transferPanel.add(amtTrnField);
		
		dollarSign = new JLabel("$");
		dollarSign.setFont(new Font("Tahoma", Font.BOLD, 15));
		dollarSign.setBounds(245, 242, 10, 29);
		transferPanel.add(dollarSign);
		
		clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearBtn.setBounds(380, 193, 106, 23);
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
		
		acctNum = new JLabel("Accout number:");
		acctNum.setFont(new Font("Tahoma", Font.BOLD, 15));
		acctNum.setBounds(25, 60, 128, 29);
		transferPanel.add(acctNum);
		
		acctBlnc = new JLabel("Accout Balance:");
		acctBlnc.setFont(new Font("Tahoma", Font.BOLD, 15));
		acctBlnc.setBounds(25, 100, 128, 29);
		
		transferPanel.add(acctBlnc);
		
		authPin = new JLabel("Authenticate Pin:");
		authPin.setFont(new Font("Tahoma", Font.BOLD, 15));
		authPin.setBounds(25, 140, 144, 29);
		transferPanel.add(authPin);
		
		authPinField = new JTextField();
		authPinField.setColumns(10);
		authPinField.setBounds(170, 140, 90, 29);
		transferPanel.add(authPinField);
		
		acctNumField = new JTextField();
		acctNumField.setEnabled(false);
		acctNumField.setBounds(170, 60, 90, 29);
		acctNumField.setText(" " + currentUser.getAccountNumber());
		transferPanel.add(acctNumField);
		
		acctBlncField = new JTextField();
		acctBlncField.setEnabled(false);
		acctBlncField.setBounds(170, 100, 90, 29);
		acctBlncField.setText("$ " + currentUser.getTotalBalance() + ".00");
		transferPanel.add(acctBlncField);
		
		stmtField = new JTextArea();
		stmtField.setBackground(Color.LIGHT_GRAY);
		stmtField.setBounds(10, 415, 476, 205);
		transferPanel.add(stmtField);
		
		for (Account a : currentUser.getAllAccounts()) {
			comboBox1.addItem(a.getacctId());
		}
		comboBox1.setBounds(327, 315, 247, 23); //create new position using windowbuilder
		transferPanel.add(comboBox1);
		
		for (Account a : currentUser.getAllAccounts()) {
			comboBox2.addItem(a.getacctId());
		}
		comboBox2.setBounds(327, 315, 247, 23); //create new position using windowbuilder
		transferPanel.add(comboBox2);
		Transfer.currentUser = currentUser;
		
		//create two labels for drop downs, one for select acount to transfer from and transfer to.
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int acctPin = Integer.parseInt(authPinField.getText());
			int accountNum = Integer.parseInt(acctTrnField.getText());
						
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
					if(value < 0) {
						stmtField.setText("Unable to transfer $0.00 into an account"); 
						break; //break of this try, throw new illegal argument exception
					}
					if(accountFrom.canWithdrawAmount(value) != true) {
						stmtField.setText("Amount to transfer exceeds the current Balance of" + accountFrom); 
						break; //need to break out of this try, throw new illegal argument exception
					}
					else {
						int oldVal = accountFrom.withdrawFromAccount(value);
						int newVal = accountTo.depositIntoAccount(value);
						//prevBalanceField.setText(Integer.toString(oldVal));
						//currBalanceField.setText(Integer.toString(account.gettotalBalance()));
						stmtField.setText("Successfully transferred $" + value + "From Account:" + accountFrom + " to Account: " + accountTo); 
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Amount to withdraw exceeds current Balance");
				}
					//currentUser.withdrawlMoney(transferVal);
					//transferUser.depositMoney(transferVal);
					//stmtField.setText("Transfered in the amount of: $"+ transferVal + " from account: " + currentUser.getAccountNumber() + 
					//		" to account: " + transferUser.getAccountNumber()); 
					//stmtField.setText("Transfered $" + transferVal + "from account: " + currentUser.getAccountNumber() + 
							//" to account: " + transferUser.getAccountNumber());
					//acctBlncField.setText("$ " + currentUser.getTotalBalance() + ".00");
					amtTrnField.setText("");
					acctTrnField.setText("");
				}
			else if(event.getSource() == clearBtn) {
				int temp = 0;
				amtTrnField.setText("$ " + temp + ".00");
				acctTrnField.setText("");
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
