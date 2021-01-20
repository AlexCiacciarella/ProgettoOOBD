package DBConfiguration;

import java.sql.*;

import Controller.Controller;

public class DBCreateConnection {
	//attributi
	private static DBCreateConnection istanza;
	private Connection Connessione;
	private String IP = "rogue.db.elephantsql.com";
	private String Username = "bqsiywek";
	private String password = "uubz-OEXoS00fIK-skdbm0LL9cvpplE8";
	private String Url = "jdbc:postgresql://"+IP+"/"+Username+"?user="+Username+"&password="+password;
	public Controller c;
	public boolean Controllo = false;
	
	//costruttore
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
	}

	//getter e setter
	public Connection getConnessione() {
		return Connessione;
	}


	
	
	
	

}
