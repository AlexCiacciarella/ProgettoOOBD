package DBConfiguration;

import java.sql.*;

import Controller.Controller;

public class DBTableCreation {
	
	Connection conn;
	DBCreateConnection dbconnection;
	Controller c;
    private boolean ProblemiCreazione = false;
	
    //getter e setter
    public boolean isProblemiCreazione() {
		return ProblemiCreazione;
	}
    
    //costruttore
	public DBTableCreation(Connection conn, Controller temp) {
		this.conn = conn;
		this.c = temp;
	}
	
	//metodi
	public boolean ConnectionExists() {
		if(conn == null) {
			return false;
		}else
			return true;
	}
	
	public boolean TableExists(String Tbl_name) throws SQLException {
		DatabaseMetaData dbm = conn.getMetaData();
		ResultSet tables = dbm.getTables(null, null, Tbl_name, null);
		if (tables.next()) {
			 return true;
		}
		else {
			 return false;
		}
	}

	public void CreaTabellaProcuratore()
	{
		Statement statement = null;
		if(ConnectionExists())
		{
			int result;
			try {
				statement = conn.createStatement();
				if(!TableExists("procuratore")){
					String sqlcommand = "CREATE TABLE Procuratore"+
										"( id_Procuratore VARCHAR(10) not null,"+
										"  password VARCHAR(20) NOT NULL,"+
										"  Nome VARCHAR(200) ,"+
										"  Cognome VARCHAR(200),"+
										"  Percentuale_Guadagno float,"+
										"  Stipendio float,"+
										"  PRIMARY KEY(id_procuratore));";
					result = statement.executeUpdate(sqlcommand);
					System.out.println("Tabella Creata");
					statement.close();
				}else
					System.out.println("La tabella Procuratore esiste già");
			} catch (SQLException e) {
				ProblemiCreazione = true;
				System.out.println("C'è stato un problema a creare la tabella Procuratore: "+ e);
			}
			
		}
	}
	
	public void CreaTabellaAtleta()
	{
		Statement statement = null;
		if(ConnectionExists())
		{
			int result;
			try {
				statement = conn.createStatement();
				if(!(TableExists("atleta"))){
					String sqlcommand = "CREATE TABLE Atleta"+
										"( id_Atleta VARCHAR(10) not null,"+
										"  Nome VARCHAR(200) ,"+
										"  Cognome VARCHAR(200),"+
										"  GettonePresenzaNazionale float,"+
										"  Stipendio float,"+
										"  PRIMARY KEY(id_Atleta));";
					result = statement.executeUpdate(sqlcommand);
					System.out.println("La tabella è stata creata " + result);
					statement.close();
				}else
					System.out.println("La tabella Atleta esiste già");
			} catch (SQLException e) {
				ProblemiCreazione = true;
				System.out.println("C'è stato un problema a creare la tabella Atleta : "+ e);
			}
			
		}
	}

}
