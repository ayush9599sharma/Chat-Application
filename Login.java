package com.chat.chatapplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JLabel lblIpAddress;
	private JTextField txtAddress;
	private JLabel lblPort;
	private JTextField txtPort;
	private JLabel lblAddressDesc;
	private JLabel lblPortDesc;
	
	/**
	 * Create the frame.
	 */
	public Login() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 300, 379);
		setSize(300,380);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(50, 72, 185, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(101, 43, 84, 19);
		contentPane.add(lblName);
		
		lblIpAddress = new JLabel("IP Address :");
		lblIpAddress.setBounds(101, 101, 84, 13);
		contentPane.add(lblIpAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(50, 124, 185, 19);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		lblPort = new JLabel("Port :");
		lblPort.setBounds(101, 167, 45, 13);
		contentPane.add(lblPort);
		
		txtPort = new JTextField();
		txtPort.setBounds(50, 190, 185, 19);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		lblAddressDesc = new JLabel("(e.g  192.132.33.31)");
		lblAddressDesc.setBounds(101, 144, 106, 13);
		contentPane.add(lblAddressDesc);
		
		lblPortDesc = new JLabel("(eg. 3000)");
		lblPortDesc.setBounds(101, 212, 68, 13);
		contentPane.add(lblPortDesc);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name  = txtName.getText();
				String address  = txtAddress.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(name , address , port);	
			}
		});
		btnNewButton.setBounds(100, 296, 85, 21);
		contentPane.add(btnNewButton);
	}
	
	/**
	 * login code here 
	 */
	private void login(String name , String address , int port) {
		dispose();
		Client c = new Client(name, address, port);
	}
	

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
}
