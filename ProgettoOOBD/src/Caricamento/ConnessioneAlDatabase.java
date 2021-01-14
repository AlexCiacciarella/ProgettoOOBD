package Caricamento;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ConnessioneAlDatabase extends JFrame {
    //attributi
	private JPanel contentPane;
	private JTextField CaricamentoTextField;
	private JButton ToLoginButton;
	private Controller c;
	
	//getter e setter
	public JTextField getCaricamentoTextField() {
		return CaricamentoTextField;
	}
	public void setCaricamentoTextField(JTextField caricamentoTextField) {

		CaricamentoTextField = caricamentoTextField;
	}
	public JButton getToLoginButton() {
		return ToLoginButton;
	}
	
	//Costruttore
	public ConnessioneAlDatabase(Controller temp) {
		c = temp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CaricamentoTextField = new JTextField();
		CaricamentoTextField.setHorizontalAlignment(SwingConstants.CENTER);
		CaricamentoTextField.setForeground(new Color(0, 0, 0));
		CaricamentoTextField.setText("Driver Non Connesso");
		CaricamentoTextField.setEditable(false);
		CaricamentoTextField.setFont(new Font("Arial", Font.BOLD, 22));
		CaricamentoTextField.setBounds(255, 126, 570, 61);
		contentPane.add(CaricamentoTextField);
		CaricamentoTextField.setColumns(10);
		
		ToLoginButton = new JButton("Vai al login!");
		ToLoginButton.setVisible(false);
		ToLoginButton.setFont(new Font("Arial", Font.PLAIN, 17));
		ToLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.CaricamentoToLogin();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		ToLoginButton.setBounds(426, 265, 214, 81);
		contentPane.add(ToLoginButton);
	}
}
