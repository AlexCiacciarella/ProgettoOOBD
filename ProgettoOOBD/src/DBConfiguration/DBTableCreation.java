package DBConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Controller.Controller;
import MainWindow.MainWindow;

public class DBTableCreation {
	
	Connection conn;
	DBCreateConnection dbconnection;
	Controller c;
    private boolean ProblemiCreazione = false;
    private boolean ProblemiVincoli = false;
    private boolean ProblemiLogin = false;
	
    //getter e setter
    
    
    
    public boolean isProblemiCreazione() {
		return ProblemiCreazione;
	}
    
    
    
    public boolean isProblemiLogin() {
		return ProblemiLogin;
	}



	public boolean isProblemiVincoli() {
		return ProblemiVincoli;
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
	
	public List ControllaIdEPassword(String email, String password) throws SQLException{
		String nome,cognome;
		int id;
		List lista = new ArrayList<String>();
		try{
			PreparedStatement login =conn.prepareStatement("SELECT procuratore.id, procuratore.password, procuratore.nome, procuratore.cognome  "
					  									  +"FROM procuratore "
					  									  +"WHERE procuratore.email = ? AND procuratore.password = ? ;");
			login.setString(1, email);
			login.setString(2, password);
			ResultSet rs = login.executeQuery();
			if(rs.next()) {
				System.out.println("Accesso effettuato");
				nome = rs.getString("nome");
				cognome = rs.getString("cognome");
				id = rs.getInt("id");
				ProblemiLogin = false;
				System.out.println(nome);
				lista.add(nome);
				lista.add(cognome);
				lista.add(id);
				return lista;
			}else
			{
				System.out.println("Id o password errati");
				ProblemiLogin = true;
			}
			return lista;
		}catch(SQLException e){
			System.out.println("Errore nel controllo id e pass "+ e);
			
		}
		return lista;
		
	}


	public void FunzionePerIVincoli() {
		Statement st;
			
	}

	public void CreaTabellaProcuratore()
	{
		Statement statement = null;
		if(ConnectionExists())
		{
			try {
				statement = conn.createStatement();
				if(!TableExists("procuratore")){
					String sqlcommand = "CREATE TABLE Procuratore"+
										"( id_Procuratore int not null,"+ 
										"  email VARCHAR(100) not null ,"+
										"  password VARCHAR(20) NOT NULL,"+
										"  Nome VARCHAR(200) ,"+
										"  Cognome VARCHAR(200),"+
										"  Percentuale_Guadagno float,"+
										"  Stipendio float,"+
										"  PRIMARY KEY(id_Procuratore) ,"
										+ "UNIQUE (id_Procuratore, email), "
										+ "CONSTRAINT CK_name CHECK (email ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$'));";
					statement.executeUpdate(sqlcommand);
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
			try {
				statement = conn.createStatement();
				if(!(TableExists("atleta"))){
					String sqlcommand = "CREATE TABLE Atleta"+
										"( id_Atleta VARCHAR(10) not null,"+
										"  Nome VARCHAR(200) ,"+
										"  Cognome VARCHAR(200),"+
										"  GettonePresenzaNazionale float,"+
										"  Stipendio float,"+
										"  id_Procuratore int,"+
										"  PRIMARY KEY(id_Atleta));";
					statement.executeUpdate(sqlcommand);
					System.out.println("La tabella è stata creata ");
					statement.close();
				}else
					System.out.println("La tabella Atleta esiste già");
			} catch (SQLException e) {
				ProblemiCreazione = true;
				System.out.println("C'è stato un problema a creare la tabella Atleta : "+ e);
			}
		}
	}
			
			public void CreaTabellaContratto()
			{
				Statement statement = null;
				if(ConnectionExists())
				{
					try {
						statement = conn.createStatement();
						if(!(TableExists("contratto"))){
							String sqlcommand = "CREATE TABLE Contratto"+
												"( id_Contratto VARCHAR(10) not null,"+
												"  Durata int not null,"+
												"  Guadagno float not null,"+
												"  TipoContratto VARCHAR(7) not null,"+
												"  id_Atleta VARCHAR(10),"+
												"  PRIMARY KEY(id_Contratto));";
							statement.executeUpdate(sqlcommand);
							System.out.println("La tabella è stata creata ");
							statement.close();
						}else
							System.out.println("La tabella Contratto esiste già");
					} catch (SQLException e) {
						ProblemiCreazione = true;
						System.out.println("C'è stato un problema a creare la tabella Contratto : "+ e);
					}
				
				}
			
			}
			
			public void CreaVincoliTabelle() throws SQLException {
				Statement statement = null;
				try {
					statement = conn.createStatement();
					String AlteraAtleta1 =" ALTER TABLE Atleta "
										+ " DROP CONSTRAINT IF EXISTS atleta_id_procuratore_fkey,"+
										 " ADD FOREIGN KEY (id_Procuratore) REFERENCES Procuratore(id_Procuratore)";
					String AlteraContratto =" ALTER TABLE Contratto "
											+"DROP CONSTRAINT IF EXISTS contratto_id_atleta_fkey,"+
							 " ADD FOREIGN KEY (id_Atleta) REFERENCES Atleta(id_Atleta);";
					statement.executeUpdate(AlteraAtleta1);
					statement.executeUpdate(AlteraContratto);
					System.out.println("Vincoli creati!");
					statement.close();
				}catch(SQLException e){
					System.out.println("C'è stato un problema a creare i vincoli delle tabelle : "+ e);
					ProblemiVincoli = true;
				}
				
				
			}
			
	}
