package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Caricamento.ConnessioneAlDatabase;
import Classi.Atleta;
import Classi.Contratto;
import DAOPostgresImplem.ProcuratoreDAOPostgresImplem;
import DBConfiguration.DBCreateConnection;
import DBConfiguration.DBTableCreation;
import LoginWindow.LoginWindow;
import MainWindow.MainWindow;

public class Controller {
	  //attributi
	 private LoginWindow LoginWindow;
     private MainWindow FinestraPrincipale;     
     private ConnessioneAlDatabase firstgui;
     private Connection connessione;
     private DBCreateConnection connessionedb;
     private DBTableCreation Tablebuilder;
     private ProcuratoreDAOPostgresImplem ProcuratoreDAO;
     private Contratto con;
     
      
      //main
      public static void main(String[] args) throws  SQLException {
    	  Controller c = new Controller();
    	  
      }
      

	  //costruttore
      public Controller() throws SQLException {
    	  //connessione alla prima gui
    	  onFirstGui();
      }
      
      //metodi
	  public void MainWindowSpawn(String nome, String cognome,int id) throws SQLException{
    	ArrayList<Atleta> ListaAtleti = new ArrayList<Atleta>();
    	ProcuratoreDAO = new ProcuratoreDAOPostgresImplem(this.connessione,this);
    	ListaAtleti = ProcuratoreDAO.getAtletaByProcuratore(id);
    	System.out.println(ListaAtleti);
    	FinestraPrincipale = new MainWindow(this, nome, cognome,id);
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
      public Contratto RichiamaAtletaPiùRedditizio(int id) {
	  Contratto c;
	  c = ProcuratoreDAO.getAtletaPiùRedditizio(id);
	  return c;
      } 
      public Contratto RichiamaClubPiùRedditizio(int id) {
	  Contratto c;
	  c = ProcuratoreDAO.getClubPiùRedditizio(id);
	  return c;
      }
      public ArrayList<Contratto> RichiamaIntroitiAtleta(int id){
	    ArrayList<Contratto> Introiti = new ArrayList();
	    Introiti = ProcuratoreDAO.getIntroitiAtleta(id);
        return Introiti;
      }
      public ArrayList<Atleta> RichiamaListaAtleti(int id) throws SQLException{
    	  ArrayList<Atleta> Atleti = new ArrayList();
    	  Atleti = ProcuratoreDAO.getAtletaByProcuratore(id);
    	  return Atleti;
      }

      public void RichiamoLogOut() throws SQLException {
    	  CaricamentoToLogin();
      }
   
}
