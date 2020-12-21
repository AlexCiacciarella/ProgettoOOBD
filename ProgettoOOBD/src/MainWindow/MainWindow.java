package MainWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;


import LoginWindow.LoginWindow;
import Controller.Controller;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class MainWindow extends JFrame {
	
	LoginWindow logwin;
	String Procuratore;
	private JPanel ContentPanel;
	private JTextField WelcomeTextField;
    Controller Login;
	
	
	public MainWindow(Controller temp,String test) {
		Login = temp;
		Procuratore = test;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 502);
		ContentPanel = new JPanel();
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ContentPanel);
		ContentPanel.setLayout(null);
		
		WelcomeTextField = new JTextField();
		WelcomeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeTextField.setFont(new Font("Arial", Font.BOLD, 14));
		WelcomeTextField.setEditable(false);
		WelcomeTextField.setBounds(277, 0, 336, 48);
		ContentPanel.add(WelcomeTextField);
		WelcomeTextField.setColumns(10);
		WelcomeTextField.setText("Welcome " +Procuratore );
		
	}
}
