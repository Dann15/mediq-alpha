package me.shirvani.mediq;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/**
	 * Create the frame
	 */
	public Login() {
		setTitle("MedIQ Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 204);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(23, 40, 62, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(90, 35, 180, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//button login
				
				
				
			}
		});
		buttonLogin.setBounds(199, 147, 90, 29);
		contentPane.add(buttonLogin);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setBounds(23, 87, 62, 16);
		contentPane.add(labelPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 82, 180, 25);
		contentPane.add(passwordField);
	}
}
