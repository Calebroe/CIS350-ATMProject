package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Form extends JFrame {

	private JPanel contentPane, panel1;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField pinField1;
	private JTextField pinField2;
	private JLabel formlbl1, formBanner1, firstNamelbl, lastNamelbl, 
	lblLastName_1, formlbl2, formlbl3, formlbl4, pinlbl1, pinlbl2;  
	private JRadioButton rdbtnCheck, rdbtnSave;
	private JButton createbtn;
	
	/**
	 * Create the frame.
	 */
	public Form() {
		setBackground(Color.WHITE);
		setTitle("Atlas ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 519);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setBounds(10, 11, 397, 458);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		formBanner1 = new JLabel("Account Creation Form");
		formBanner1.setFont(new Font("Tahoma", Font.BOLD, 20));
		formBanner1.setBounds(80, 21, 242, 24);
		panel1.add(formBanner1);
		
		formlbl1 = new JLabel("Please Enter the following Information:");
		formlbl1.setBounds(33, 56, 204, 24);
		panel1.add(formlbl1);
		
		formlbl2 = new JLabel("Please select accounts desired:");
		formlbl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		formlbl2.setBounds(10, 145, 177, 24);
		panel1.add(formlbl2);
		
		formlbl3 = new JLabel("Please enter account pin:");
		formlbl3.setBounds(10, 234, 154, 24);
		panel1.add(formlbl3);
		
		formlbl4 = new JLabel("must have 4 -- 12 digits");
		formlbl4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		formlbl4.setBounds(10, 250, 154, 24);
		panel1.add(formlbl4);
		
		firstNamelbl = new JLabel("First Name:");
		firstNamelbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		firstNamelbl.setBounds(67, 81, 69, 24);
		panel1.add(firstNamelbl);
		
		lastNamelbl = new JLabel("Last Name:");
		lastNamelbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lastNamelbl.setBounds(67, 110, 68, 24);
		panel1.add(lastNamelbl);
		
		rdbtnCheck = new JRadioButton("Checking Account");
		rdbtnCheck.setBounds(40, 168, 124, 23);
		panel1.add(rdbtnCheck);
		
		rdbtnSave = new JRadioButton("Savings Account");
		rdbtnSave.setBounds(40, 194, 109, 23);
		panel1.add(rdbtnSave);
		
		pinlbl1 = new JLabel("Pin:");
		pinlbl1.setBounds(53, 281, 55, 24);
		panel1.add(pinlbl1);
		
		pinlbl2 = new JLabel("Confirm Pin:");
		pinlbl2.setBounds(10, 307, 58, 24);
		panel1.add(pinlbl2);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(146, 83, 137, 20);
		panel1.add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(146, 112, 137, 20);
		panel1.add(lastNameField);
		
		pinField1 = new JTextField();
		pinField1.setColumns(10);
		pinField1.setBounds(78, 283, 109, 20);
		panel1.add(pinField1);
		
		pinField2 = new JTextField();
		pinField2.setColumns(10);
		pinField2.setBounds(78, 309, 109, 20);
		panel1.add(pinField2);
		
		createbtn = new JButton("Create Account");
		createbtn.setBounds(130, 405, 124, 23);
		panel1.add(createbtn);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
