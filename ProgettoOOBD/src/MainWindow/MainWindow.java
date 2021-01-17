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
import java.awt.Component;

import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class MainWindow extends JFrame {
	//attributi
	private int ID;
	private LoginWindow LoginWindow;
	private String Nome, Cognome;
	private JPanel ContentPanel;
	private JTextField WelcomeTextField;
	private JList AtletaList = null;
	private DefaultListModel ListModel = null;
    private Controller Controller;
	
    //costruttore
	public MainWindow(Controller temp,String nome, String cognome,int id){

		Controller = temp;
		Nome = nome;
		Cognome = cognome;
		ID = id;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1187, 674);
		ContentPanel = new JPanel();
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ContentPanel);
		ContentPanel.setLayout(null);
		
		WelcomeTextField = new JTextField();
		WelcomeTextField.setBounds(430, 0, 381, 48);
		WelcomeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeTextField.setFont(new Font("Arial", Font.BOLD, 14));
		WelcomeTextField.setEditable(false);
		ContentPanel.add(WelcomeTextField);
		WelcomeTextField.setColumns(10);
		WelcomeTextField.setText("Benvenuto " + nome + " " + cognome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 1077, 197);
		ContentPanel.add(scrollPane);
		
		AtletaList = new JList();
		AtletaList.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(AtletaList);
		ListModel = new DefaultListModel();
	    try {
			ListaAtleti(id);
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		AtletaList.setModel(ListModel);
		
		JButton BottoneContratti = new JButton("Visualizza tutti i Contratti");
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
		BottoneContratti.setBounds(12, 363, 255, 48);
		ContentPanel.add(BottoneContratti);
		
		JButton Sorgenti_Introito_Button = new JButton("Mostra sorgenti introito giocatori");
		Sorgenti_Introito_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					IntroitiAtleta(id);
				} catch (SQLException e2) {
					System.out.println("C'è stato un'errore nel bottone "+ e2);
				}
			}
		});
		Sorgenti_Introito_Button.setHorizontalAlignment(SwingConstants.LEFT);
		Sorgenti_Introito_Button.setFont(new Font("Arial", Font.BOLD, 14));
		Sorgenti_Introito_Button.setBounds(839, 363, 277, 44);
		ContentPanel.add(Sorgenti_Introito_Button);
		
		JButton btnNewButton = new JButton("Ottieni Atleta pi\u00F9 Redditizio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AtletaRedditizio(id);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(553, 363, 258, 44);
		ContentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ottieni Club Pi\u00F9 Redditizio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClubRedditizio(id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBounds(277, 363, 255, 48);
		ContentPanel.add(btnNewButton_1);
		
		JButton MostraAtleti = new JButton("Mostra tutti gli atleti");
		MostraAtleti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListaAtleti(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		MostraAtleti.setFont(new Font("Arial", Font.BOLD, 14));
		MostraAtleti.setBounds(12, 437, 255, 48);
		ContentPanel.add(MostraAtleti);
		
	}
	
	//metodi
	public void RiempiLista(int id) throws SQLException {
		ListModel.removeAllElements();
		AtletaList.setModel(ListModel);
		ArrayList<Contratto> ListaContratti = Controller.RichiamaListaContratti(id);
		for(int i=0;i<ListaContratti.size();i++) {
	    	ListModel.addElement(ListaContratti.get(i).toString());
	    }
		AtletaList.setModel(ListModel);
	}
	public void AtletaRedditizio(int id) throws SQLException{
		ListModel.removeAllElements();
		AtletaList.setModel(ListModel);
		ListModel.addElement(Controller.RichiamaAtletaPiùRedditizio(id).toString());
		AtletaList.setModel(ListModel);
	}
	public void ClubRedditizio(int id) throws SQLException{
		ListModel.removeAllElements();
		AtletaList.setModel(ListModel);
		ListModel.addElement(Controller.RichiamaClubPiùRedditizio(id).toString2());
		AtletaList.setModel(ListModel);
	}
	public void IntroitiAtleta(int id) throws SQLException{
		 ListModel.removeAllElements();
		 AtletaList.setModel(ListModel); 
			for(int i=0;i<Controller.RichiamaIntroitiAtleta(id).size();i++) {
		    	ListModel.addElement(Controller.RichiamaIntroitiAtleta(id).get(i).toString3());
		    }
			AtletaList.setModel(ListModel);
	}
	
	public void ListaAtleti(int id) throws SQLException{
		ListModel.removeAllElements();
		AtletaList.setModel(ListModel);
		for(int i=0;i<Controller.RichiamaListaAtleti(id).size();i++) {
	    	ListModel.addElement(Controller.RichiamaListaAtleti(id).get(i).toString());
	    }
		AtletaList.setModel(ListModel);
	}
}

