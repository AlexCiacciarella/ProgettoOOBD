package LoginWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import MainWindow.MainWindow;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Controller.Controller;

public class LoginWindow extends JFrame {
	//attributi
	private MainWindow driver;
	private Controller Controller;
	private JPanel MainContentPanel;
	private JTextField ProcuratoreTextField;
	private JPasswordField ProcuratorePasswordField;
    
	
	
	//costruttore
	public LoginWindow(Controller temp) {
		Controller = temp;
		setFont(new Font("Arial", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 478);
		MainContentPanel = new JPanel();
		MainContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainContentPanel);
		MainContentPanel.setLayout(null);
		
		ProcuratoreTextField = new JTextField();
		ProcuratoreTextField.setFont(new Font("Arial", Font.PLAIN, 14));
		ProcuratoreTextField.setBounds(374, 143, 225, 31);
		MainContentPanel.add(ProcuratoreTextField);
		ProcuratoreTextField.setColumns(10);
		
		JLabel IDLabel = new JLabel("Id");
		IDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		IDLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		IDLabel.setBounds(265, 148, 85, 20);
		MainContentPanel.add(IDLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		PasswordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		PasswordLabel.setBounds(265, 220, 85, 20);
		MainContentPanel.add(PasswordLabel);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
				    Controller.ControlloLogin(getProcuratoreTextField().getText(), getProcuratorePasswordField().getText());;
				}catch(SQLException a)
				{
					System.out.println(a);
				}
			}
		});
		LoginButton.setFont(new Font("Arial", Font.BOLD, 14));
		LoginButton.setBounds(412, 328, 124, 54);
		MainContentPanel.add(LoginButton);
		
		ProcuratorePasswordField = new JPasswordField();
		ProcuratorePasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
		ProcuratorePasswordField.setBounds(374, 215, 225, 31);
		MainContentPanel.add(ProcuratorePasswordField);
	}



    //getter e setter
	public JPanel getMainContentPanel() {
		return MainContentPanel;
	}
	public void setMainContentPanel(JPanel mainContentPanel) {
		MainContentPanel = mainContentPanel;
	}
	public JTextField getProcuratoreTextField() {
		return ProcuratoreTextField;
	}
	public void setProcuratoreTextField(JTextField procuratoreTextField) {
		ProcuratoreTextField = procuratoreTextField;
	}
	public JPasswordField getProcuratorePasswordField() {
		return ProcuratorePasswordField;
	}
	public void setProcuratorePasswordField(JPasswordField procuratorePasswordField) {
		ProcuratorePasswordField = procuratorePasswordField;
	}



}
