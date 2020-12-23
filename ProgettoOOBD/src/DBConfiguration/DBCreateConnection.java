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
		Controllo = false;
		try {
			Class.forName("org.postgresql.Driver");
			//Ottenimento di una connessione
			Connessione = DriverManager.getConnection(Url,Username, password);
			System.out.println("Connessione stabilita");
			Controllo = true;
		}catch(ClassNotFoundException NFE){
			System.out.println("La classe non � stata trovata: "+ NFE);
		}catch(SQLException noconn)
		{
			System.out.println("La connessione non � stata trovata con errore: "+ noconn);
		}
		//System.out.println("Programma eseguito");
	}

	public Connection getConnessione() {
		return Connessione;
	}
	
	
//	public DBCreateConnection getInstance() throws SQLException{
//		if(istanza == null)
//		{
//			istanza = new DBCreateConnection(c);
//		}
//		else if (istanza.getConnection().is)
//		{
//			
//		}
//	}
//	
	

}
