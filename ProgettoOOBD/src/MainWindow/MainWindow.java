package MainWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import Classi.Atleta;

import Classi.Contratto;

import LoginWindow.LoginWindow;
import Controller.Controller;
import DBConfiguration.DBTableCreation;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.ListModel;

import java.awt.Button;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class MainWindow extends JFrame {
	int ID;
	LoginWindow LoginWindow;
	String Nome, Cognome;
	private JPanel ContentPanel;
	private JTextField WelcomeTextField;
	JList AtletaList = null;
	DefaultListModel ListModel = null;
    Controller Controller;
    ArrayList<Atleta> ListaAtleti;
    ArrayList<Contratto> ListaContratti;
	
	

	public MainWindow(Controller temp,String nome, String cognome,int id, ArrayList<Atleta> lista){

		ListaAtleti = lista;
		Controller = temp;
		Nome = nome;
		Cognome = cognome;
		ID = id;

		ListaAtleti = lista;

		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(408, 101, 507, 328);
		ContentPanel.add(scrollPane);
		
		AtletaList = new JList();
		scrollPane.setViewportView(AtletaList);
		AtletaList.setFont(new Font("Arial", Font.PLAIN, 14));
		AtletaList.setModel(ListModel);
		ListModel = new DefaultListModel();
	    for(int i=0;i<ListaAtleti.size();i++) {
	    	ListModel.addElement(ListaAtleti.get(i));
	    }
		
		JButton BottoneContratti = new JButton("VIsualizza tutti i Contratti");
		BottoneContratti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RiempiLista(ID);
				} catch (SQLException e1) {
					System.out.println("C'è stato un'errore nel bottone "+ e1);
				}
			}
		});
		BottoneContratti.setFont(new Font("Arial", Font.BOLD, 14));
		BottoneContratti.setBounds(82, 101, 255, 48);
		ContentPanel.add(BottoneContratti);
		
	}
	
	public void RiempiLista(int id) throws SQLException {
		ListaContratti = Controller.RichiamaListaContratti(id);
		for(int i=0;i<ListaContratti.size();i++) {
	    	ListModel.addElement(ListaContratti.get(i).toString());
	    }
		AtletaList.setModel(ListModel);
	}
}
