package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import atm.Login.ButtonListener;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Main extends JFrame {
	private JFrame mainFrame;
	private JPanel contentPane;
	private JButton LogOutBtn, depositButton, withdrawButton, transferButton;
	private JLabel welcomeUser, atmBanner1, atmBanner2;
	private static User[] users;
	private static User currentUser;
	private JButton AccountBtn;
	private JButton StatementBtn;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	//public Main(User users[], User currentUser) {
	public Main() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("ATLAS ATM Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		atmBanner1 = new JLabel("Main Menu");
		atmBanner1.setFont(new Font("Tahoma", Font.BOLD, 27));
		atmBanner1.setHorizontalAlignment(SwingConstants.CENTER);
		atmBanner1.setBackground(Color.LIGHT_GRAY);
		atmBanner1.setBounds(160, 53, 157, 58);
		contentPane.add(atmBanner1);
		
		atmBanner2 = new JLabel("Atlas ATM");
		atmBanner2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		atmBanner2.setHorizontalAlignment(SwingConstants.CENTER);
		atmBanner2.setBounds(10, 10, 151, 36);
		contentPane.add(atmBanner2);
		
		depositButton = new JButton("Deposit");
		depositButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		depositButton.setBounds(80, 122, 140, 45);
		depositButton.addActionListener(new ButtonListener());
		contentPane.add(depositButton);
		
		withdrawButton = new JButton("Withdrawal");
		withdrawButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		withdrawButton.setBounds(266, 122, 140, 45);
		withdrawButton.addActionListener(new ButtonListener());
		contentPane.add(withdrawButton);
		
		transferButton = new JButton("Transfer");
		transferButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		transferButton.setBounds(80, 203, 140, 45);
		transferButton.addActionListener(new ButtonListener());
		contentPane.add(transferButton);
		
		AccountBtn = new JButton("Account");
		AccountBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AccountBtn.setBounds(266, 203, 140, 45);
		contentPane.add(AccountBtn);
		
		StatementBtn = new JButton("Statement");
		StatementBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		StatementBtn.setBounds(80, 281, 140, 45);
		contentPane.add(StatementBtn);
		
		LogOutBtn = new JButton("Log Out");
		LogOutBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LogOutBtn.setBounds(266, 281, 140, 45);
		LogOutBtn.addActionListener(new ButtonListener());
		contentPane.add(LogOutBtn);
		
		welcomeUser = new JLabel("s");
		welcomeUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		welcomeUser.setBounds(229, 17, 230, 25);
		welcomeUser.setText("Welcome back " + currentUser.getFirstName() + " " + currentUser.getLastName());
		contentPane.add(welcomeUser);
		
		
		
		//assigning parameters
		//Main.users = users; //= Main.users;
		//Main.currentUser = currentUser;  //= Main.currentUser;
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == LogOutBtn) {
				Login window = new Login();
				window.frmAtm.setVisible(true);
				dispose();
			}
			else if(event.getSource() == depositButton) {
				new Deposit().setVisible(true);
				dispose();
			}
			else if(event.getSource() == withdrawButton) {
				new Withdrawal().setVisible(true);
				dispose();
			}
			else if(event.getSource() == transferButton) {
				new Transfer().setVisible(true);
				dispose();
			}
			else if(event.getSource() == AccountBtn) {
				new Account().setVisible(true);
				dispose();
			}
			else if(event.getSource() == StatementBtn) {
				new Statement().setVisible(true);
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main mainFrame = new Main();
					mainFrame.setVisible(true);
					mainFrame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
