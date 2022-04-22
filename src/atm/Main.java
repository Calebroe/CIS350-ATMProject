package atm;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*************************************************
 * Front end JPanel for displaying Menu Screen
 *
 * @author Caleb Roe
 * @version April 21, 2022
 *************************************************/
public class Main extends JFrame {
	private JFrame mainFrame;
	private JPanel contentPane;
	private JButton LogOutBtn, depositButton, withdrawButton, transferButton;
	private JLabel welcomeUser, atmBanner1, atmBanner2;
	private static User currentUser;
	private JButton AccountBtn;
	

	/**
	 * Initialize the frame.
	 */
	//public Main(User users[], User currentUser) {
	public Main(User currentUser) {
		setBackground(Color.LIGHT_GRAY);
		setTitle("ATLAS ATM Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 464, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		welcomeUser = new JLabel("s");
		welcomeUser.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeUser.setBounds(97, 47, 287, 19);
		panel.add(welcomeUser);
		welcomeUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		welcomeUser.setText("Welcome back " + currentUser.getFirstName() + " " + currentUser.getLastName());
		
		atmBanner2 = new JLabel("Atlas ATM");
		atmBanner2.setBounds(0, 0, 151, 36);
		panel.add(atmBanner2);
		atmBanner2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		atmBanner2.setHorizontalAlignment(SwingConstants.CENTER);
		
		atmBanner1 = new JLabel("Main Menu");
		atmBanner1.setBounds(156, 58, 157, 58);
		panel.add(atmBanner1);
		atmBanner1.setFont(new Font("Tahoma", Font.BOLD, 27));
		atmBanner1.setHorizontalAlignment(SwingConstants.CENTER);
		atmBanner1.setBackground(Color.LIGHT_GRAY);
		
		depositButton = new JButton("Deposit");
		depositButton.setBounds(50, 145, 160, 45);
		panel.add(depositButton);
		depositButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		withdrawButton = new JButton("Withdrawal");
		withdrawButton.setBounds(255, 145, 160, 45);
		panel.add(withdrawButton);
		withdrawButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		transferButton = new JButton("Transfer");
		transferButton.setBounds(50, 226, 160, 45);
		panel.add(transferButton);
		transferButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		AccountBtn = new JButton("Account");
		AccountBtn.setBounds(255, 226, 160, 45);
		panel.add(AccountBtn);
		AccountBtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		LogOutBtn = new JButton("Log Out");
		LogOutBtn.setBounds(167, 303, 140, 45);
		panel.add(LogOutBtn);
		LogOutBtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		LogOutBtn.addActionListener(new ButtonListener());
		AccountBtn.addActionListener(new ButtonListener());
		transferButton.addActionListener(new ButtonListener());
		withdrawButton.addActionListener(new ButtonListener());
		depositButton.addActionListener(new ButtonListener());
		
		//assigning parameters
		//Main.users = users; //= Main.users;
		Main.currentUser = currentUser;
	}
	
	 /**************************************************************
    Respond to either button clicks
    @param e the action event that was just fired
    **************************************************************/
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == LogOutBtn) {
				new Welcome().setVisible(true);
				dispose();
			}
			else if(event.getSource() == depositButton) {
				new Deposit(currentUser).setVisible(true);
				dispose();
			}
			else if(event.getSource() == withdrawButton) {
				new Withdrawal(currentUser).setVisible(true);
				dispose();
			}
			else if(event.getSource() == transferButton) {
				new Transfer(currentUser).setVisible(true);
				dispose();
			}
			else if(event.getSource() == AccountBtn) {
				new AccountView(currentUser).setVisible(true);
				dispose();
			}
//			else if(event.getSource() == StatementBtn) {
//				new Statement(currentUser).setVisible(true);
//				dispose();
//			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main mainFrame = new Main(currentUser);
					mainFrame.setVisible(true);
					mainFrame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
