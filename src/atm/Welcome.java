package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atm.Main.ButtonListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Welcome extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane, panel;
	private JLabel titleBanner, titleBanner2, titleBanner3, userBanner, acctBanner;
	private JButton loginBtn, CreateAcctBtn;

	//private User[] users = new User[3];
	//private User currentUser = null;
	
	/**
	 * Create the frame.
	 */
	public Welcome() {
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("Atlas ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 364, 399);
		contentPane.add(panel);
		panel.setLayout(null);
		
		titleBanner = new JLabel("Atlas");
		titleBanner.setHorizontalAlignment(SwingConstants.CENTER);
		titleBanner.setFont(new Font("Tahoma", Font.BOLD, 35));
		titleBanner.setBounds(125, 48, 125, 34);
		panel.add(titleBanner);
		
		titleBanner2 = new JLabel("Automated Telling");
		titleBanner2.setHorizontalAlignment(SwingConstants.CENTER);
		titleBanner2.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleBanner2.setBounds(82, 93, 215, 25);
		panel.add(titleBanner2);
		
		titleBanner3 = new JLabel("Machine");
		titleBanner3.setHorizontalAlignment(SwingConstants.CENTER);
		titleBanner3.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleBanner3.setBounds(82, 129, 215, 25);
		panel.add(titleBanner3);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(142, 208, 89, 23);
		loginBtn.addActionListener(new ButtonListener());
		panel.add(loginBtn);
		
		userBanner = new JLabel("Existing User?");
		userBanner.setFont(new Font("Tahoma", Font.BOLD, 15));
		userBanner.setBounds(135, 180, 108, 14);
		panel.add(userBanner);
		
		acctBanner = new JLabel("Become an Account Holder");
		acctBanner.setFont(new Font("Tahoma", Font.BOLD, 15));
		acctBanner.setBounds(88, 253, 205, 14);
		panel.add(acctBanner);
		
		CreateAcctBtn = new JButton("Create Account");
		CreateAcctBtn.setBounds(130, 278, 112, 23);
		CreateAcctBtn.addActionListener(new ButtonListener());
		panel.add(CreateAcctBtn);
		
		//users[0] = new User("Caleb", "Roe", 1111, 1400, 1001);
		//users[1] = new User("Grant", "Spears", 1112, 1500, 1002);
		//users[2] = new User("Jessica", "Kressner", 1113, 1600, 1003);
		
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == loginBtn) {
				Login window = new Login();
				window.frmAtm.setVisible(true);
				dispose();
			}
			else if(event.getSource() == CreateAcctBtn) {
				new Form().setVisible(true);
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
