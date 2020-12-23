package DBConfiguration;

import java.sql.*;

public class DBTableCreation {
	
	Connection conn;
	DBCreateConnection dbconnection;
	
	
	public DBTableCreation(Connection conn) {
		this.conn = conn;
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
		if(dbconnection.ConnectionExists())
		{
			try {
				statement = conn.createStatement();
				if(!(TableExists("Procuratore"))){
					String sqlcommand = "CREATE TABLE Procuratore"+
										"( id_Procuratore VARCHAR(10) not null,"+
										"  password VARCHAR(20) NOT NULL,"+
										"  Nome VARCHAR(200) ,"+
										"  Cognome VARCHAR(200),"+
										"  Percentuale_Guadagno double,"+
										"  Stipendio double,"+
										"  PRIMARY KEY(id_procuratore));";
					statement.executeQuery(sqlcommand);
					statement.closeOnCompletion();
				}else
					System.out.println("La tabella Procuratore esiste già");
			} catch (SQLException e) {
				System.out.println("C'è stato un problema a creare la tabella Procuratore: "+ e);
			}
			
		}
	}
	
	public void CreaTabellaAtleta()
	{
		Statement statement = null;
		if(dbconnection.ConnectionExists())
		{
			try {
				statement = conn.createStatement();
				if(!(TableExists("Atleta"))){
					String sqlcommand = "CREATE TABLE Atleta"+
										"( id_Atleta VARCHAR(10) not null,"+
										"  Nome VARCHAR(200) ,"+
										"  Cognome VARCHAR(200),"+
										"  GettonePresenzaNazionale double,"+
										"  Stipendio double,"+
										"  PRIMARY KEY(id_Atleta));";
					statement.executeQuery(sqlcommand);
				}else
					System.out.println("La tabella Atleta esiste già");
			} catch (SQLException e) {
				System.out.println("C'è stato un problema a creare la tabella Atleta : "+ e);
			}
			
		}
	}

}
