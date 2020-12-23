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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
public class MainWindow extends JFrame {
	
	LoginWindow LoginWindow;
	String Procuratore;
	private JPanel ContentPanel;
	private JTextField WelcomeTextField;
    Controller Controller;
	
	
	public MainWindow(Controller temp,String test){
		Controller = temp;
		Procuratore = test;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 502);
		ContentPanel = new JPanel();
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ContentPanel);
		ContentPanel.setLayout(null);
		
		WelcomeTextField = new JTextField();
		WelcomeTextField.setBounds(277, 0, 336, 48);
		WelcomeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeTextField.setFont(new Font("Arial", Font.BOLD, 14));
		WelcomeTextField.setEditable(false);
		ContentPanel.add(WelcomeTextField);
		WelcomeTextField.setColumns(10);
		WelcomeTextField.setText("Welcome " +Procuratore);
		
		JButton CreaProcuratoreButton = new JButton("Crea Procuratore");
		CreaProcuratoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Controller.RichiamaCreazioneProcuratore();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		CreaProcuratoreButton.setFont(new Font("Arial", Font.BOLD, 14));
		CreaProcuratoreButton.setBounds(194, 195, 164, 64);
		ContentPanel.add(CreaProcuratoreButton);
		
		JButton CreaAtletaButton = new JButton("Crea Atleta");
		CreaAtletaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Controller.RichiamaCreazioneAtleta();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		CreaAtletaButton.setFont(new Font("Arial", Font.BOLD, 14));
		CreaAtletaButton.setBounds(548, 195, 164, 64);
		ContentPanel.add(CreaAtletaButton);
		
	}
}
