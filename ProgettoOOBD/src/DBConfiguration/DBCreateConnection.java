package DBConfiguration;

import java.sql.*;

import Controller.Controller;

public class DBCreateConnection {
	
	private static DBCreateConnection istanza;
	private Connection Connessione;
	private String IP = "rogue.db.elephantsql.com";
	private String Username = "bqsiywek";
	private String password = "uubz-OEXoS00fIK-skdbm0LL9cvpplE8";
	private String Url = "jdbc:postgresql://"+IP+"/"+Username+"?user="+Username+"&password="+password;
	public Controller c;
	public boolean Controllo = false;
	
	
	public DBCreateConnection(Controller temp) throws SQLException {
		//Caricamento del Driver
		c = temp;
		Controllo = false;
		try {
			Class.forName("org.postgresql.Driver");
			//Ottenimento di una connessione
			Connessione = DriverManager.getConnection(Url);
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
