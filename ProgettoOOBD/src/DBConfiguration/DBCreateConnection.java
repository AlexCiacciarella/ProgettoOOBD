package DBConfiguration;

import java.sql.*;

import Controller.Controller;

public class DBCreateConnection {
	
	private static DBCreateConnection istanza;
	private Connection Connessione;
	private String IP = "localhost";
	private String Username = "postgres";
	private String password = "admin";
	private String port = "5432";
	private String Url = "jdbc:postgresql://"+IP+":"+port+"/AgenziaProcuratoriSportivi";
	public Controller c;
	public boolean Controllo = false;
	
	
	public DBCreateConnection(Controller temp) throws SQLException {
		//Caricamento del Driver
		c = temp;
		try {
			Class.forName("org.postgresql.Driver");
			//Ottenimento di una connessione
			Connessione = DriverManager.getConnection(Url,Username, password);
			System.out.println("Connessione stabilita");
			Controllo = true;
		}catch(ClassNotFoundException NFE){
			System.out.println("La classe non è stata trovata: "+ NFE);
		}catch(SQLException noconn)
		{
			System.out.println("La connessione non è stata trovata con errore: "+ noconn);
		}
		//System.out.println("Programma eseguito");
	}

	public boolean ConnectionExists() {
		return !(Connessione==null);
	}

	public Connection getConnessione() {
		return Connessione;
	}
	
	
	
	
	
	
	/*public DBCreateConnection getInstance() throws SQLException{
		if(istanza == null)
		{
			istanza = new DBCreateConnection();
		}
		else if (istanza.getConnection().is)
		{
			
		}
	}*/
	
	

}
