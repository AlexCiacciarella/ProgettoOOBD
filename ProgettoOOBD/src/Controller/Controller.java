package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Caricamento.ConnessioneAlDatabase;
import Classi.Atleta;
import Classi.Contratto;
import DAOPostgressImplem.ProcuratoreDAOPostgressImplem;
import DBConfiguration.DBCreateConnection;
import DBConfiguration.DBTableCreation;
import LoginWindow.LoginWindow;
import MainWindow.MainWindow;

public class Controller {
	  //attributi
	  LoginWindow LoginWindow;
      MainWindow FinestraPrincipale;     
      ConnessioneAlDatabase firstgui;
      Connection connessione;
      DBCreateConnection connessionedb;
      DBTableCreation Tablebuilder;
      
      ProcuratoreDAOPostgressImplem ProcuratoreDAO;
      Contratto con;
      ArrayList<Atleta> ListaAtleti = new ArrayList<Atleta>();
      
      //main
      public static void main(String[] args) throws SQLException {
    	  Controller c = new Controller();
    	  
      }
      

	  //costruttore
      public Controller() throws SQLException {
    	  //connessione alla prima gui
    	  onFirstGui();
      }
      
      //metodi
	  public void MainWindowSpawn(String nome, String cognome,int id) throws SQLException{
    	ProcuratoreDAO = new ProcuratoreDAOPostgressImplem(this.connessione,this);
    	ArrayList<Atleta> ListaAtleti = new ArrayList<Atleta>();
    	ProcuratoreDAO = new ProcuratoreDAOPostgressImplem(this.connessione,this);
    	ListaAtleti = ProcuratoreDAO.getAtletaByProcuratore(id);
    	System.out.println(ListaAtleti);
    	FinestraPrincipale = new MainWindow(this, nome, cognome,id,ListaAtleti);
  		FinestraPrincipale.setVisible(true);	
  		
  	}
      
      public void onFirstGui() throws SQLException{
    	  firstgui = new ConnessioneAlDatabase(this);
    	  firstgui.setVisible(true);
    	  connessionedb = new DBCreateConnection(this);
    	  if(connessionedb.Controllo) {
    		  firstgui.getCaricamentoTextField().setText("Caricamento del Driver Riuscito!");
    		  RichiamaCreazioneAtleta();
    		  RichiamaCreazioneProcuratore();
        	  RichiamaCreazioneContratto();
        	  
        	  if(!(Tablebuilder.isProblemiCreazione())) {
        		  firstgui.getCaricamentoTextField().setText("Creazione delle tabelle avvenuta con successo");
        		  RichiamaCreaVincoli();
        		  if(!(Tablebuilder.isProblemiVincoli()))
        		  {
        			  firstgui.getCaricamentoTextField().setText("Creazione dei vincoli avvenuta con successo");
        			  firstgui.getToLoginButton().setVisible(true);
        		  }
        	  }else {
        		  firstgui.getCaricamentoTextField().setText("Si è verificato un problema nella creazione delle tabelle");
        	  }
            		  
    		  
    	  }
    	  
    	  
      }
      
      public void CaricamentoToLogin() throws SQLException {
    	  if(connessionedb.Controllo)
    	  {
    		  firstgui.setVisible(false);
      	  	  LoginWindow = new LoginWindow(this);
      	  	  LoginWindow.setVisible(true);
    	  }
    	  
      }
      
      public void ControlloLogin(String email, String pass) throws SQLException{
    	  String nome, cognome;
    	  int id = 0;
    	  List list = new ArrayList<>();
    	  PassaConnessioneATableBuilder();
    	  list = Tablebuilder.ControllaIdEPassword(email, pass);
    	  if(Tablebuilder.isProblemiLogin() == false)
    	  {
    		  nome = (String) list.get(0);
        	  cognome = (String) list.get(1);
        	  id = (int) list.get(2);
        	  
    		  LoginWindow.setVisible(false);
    		  MainWindowSpawn(nome, cognome,id);
    	  }else
    	  {
    		  JOptionPane.showMessageDialog(null, "ID o password sbagliati");
    		  LoginWindow.getProcuratorePasswordField().setText("");
    	  }
      }

    public void ShutDownLoginWindow() throws SQLException {
    	LoginWindow.setVisible(false);
    }
    
    public void PassaConnessioneATableBuilder() {
   		connessione = connessionedb.getConnessione();
   		Tablebuilder = new DBTableCreation(connessione, this);
    }
    
  public void RichiamaCreazioneProcuratore() throws SQLException{
	  	PassaConnessioneATableBuilder();
   		Tablebuilder.CreaTabellaProcuratore();
   }
  
  public void RichiamaCreazioneAtleta() throws SQLException{
	  PassaConnessioneATableBuilder();
	  Tablebuilder.CreaTabellaAtleta();
  }
  
  public void RichiamaCreazioneContratto() throws SQLException{
	  PassaConnessioneATableBuilder();
	  Tablebuilder.CreaTabellaContratto();
  }
  
  public void RichiamaCreaVincoli() throws SQLException{
	  PassaConnessioneATableBuilder();
	  Tablebuilder.CreaVincoliTabelle();
  }
  
  public ArrayList<Contratto> RichiamaListaContratti(int id) throws SQLException{
	  List<Contratto> lista = new ArrayList<Contratto>();
	  lista = ProcuratoreDAO.getContratti(id);
	  return (ArrayList<Contratto>) lista;
  }
  //da rivedere
  public List Richiamalista(int id) {
	  List lista = new ArrayList();
	  lista = ProcuratoreDAO.getIntroitiAtleta(id);
	  return lista;
  }
  
  public Contratto RichiamaAtletaPiùRedditizio(int id) {
	  Contratto c;
	  c = ProcuratoreDAO.getAtletaPiùRedditizio(id);
	  return c;
  }




   
  
	
       

	
    

}
