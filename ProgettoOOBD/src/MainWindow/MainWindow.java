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
import DBConfiguration.DBTableCreation;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.Button;
import javax.swing.JScrollBar;
public class MainWindow extends JFrame {
	int ID;
	LoginWindow LoginWindow;
	String Nome, Cognome;
	private JPanel ContentPanel;
	private JTextField WelcomeTextField;
    Controller Controller;
    private JTable table;
	
	
	public MainWindow(Controller temp,String nome, String cognome,int id){
		Controller = temp;
		Nome = nome;
		Cognome = cognome;
		ID = id;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 502);
		ContentPanel = new JPanel();
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ContentPanel);
		ContentPanel.setLayout(null);
		
		WelcomeTextField = new JTextField();
		WelcomeTextField.setBounds(277, 0, 381, 48);
		WelcomeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeTextField.setFont(new Font("Arial", Font.BOLD, 14));
		WelcomeTextField.setEditable(false);
		ContentPanel.add(WelcomeTextField);
		WelcomeTextField.setColumns(10);
		WelcomeTextField.setText("Welcome " + nome + " " + cognome);
		
		table = new JTable();
		table.setBounds(10, 67, 930, 367);
		ContentPanel.add(table);
		
	}
}
