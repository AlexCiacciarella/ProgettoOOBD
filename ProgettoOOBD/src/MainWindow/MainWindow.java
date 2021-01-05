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
    Controller Controller;
	ArrayList<Atleta> ListaAtleti;
	
	
	public MainWindow(Controller temp,String nome, String cognome,int id,ArrayList<Atleta> Lista){
		ListaAtleti = Lista;
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
		
		JScrollPane AtletaListScrollPanel = new JScrollPane();
		AtletaListScrollPanel.setBounds(10, 83, 930, 369);
		ContentPanel.add(AtletaListScrollPanel);
		
		JList AtletaList = new JList();
		AtletaList.setFont(new Font("Arial", Font.PLAIN, 14));
		AtletaListScrollPanel.setViewportView(AtletaList);
		DefaultListModel ListModel = new DefaultListModel();
	    for(int i=0;i<ListaAtleti.size();i++) {
	    	ListModel.addElement(ListaAtleti.get(i));
	    }
		AtletaList.setModel(ListModel);
		
	}
}
