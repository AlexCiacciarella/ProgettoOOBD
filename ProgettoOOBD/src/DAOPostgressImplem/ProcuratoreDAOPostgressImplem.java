package DAOPostgressImplem;

import java.sql.*;
import Controller.Controller;
import MainWindow.MainWindow;
import DBConfiguration.DBTableCreation;
import java.util.*;

import Classi.Atleta;
import Classi.Contratto;
import Classi.Procuratore;
import Daos.ProcuratoreDAO;

public class ProcuratoreDAOPostgressImplem implements ProcuratoreDAO {
    //Attributi
	private Connection conn;
    private PreparedStatement getAtletaByProcuratorePS;
    Controller Controller;
    
    //Costruttore
	public ProcuratoreDAOPostgressImplem(Connection Connection,Controller temp) throws SQLException {
		this.conn=Connection;
		this.Controller = temp;
	}

	//Metodi
	@Override
	//FINITO
	public List<Contratto> getContratti(int id) {
		int ID = id;
		ArrayList<Contratto> ListaContratti = new ArrayList<Contratto>();
		String id_atleta =null;
		try {
			PreparedStatement getContrattiPS = conn.prepareStatement("SELECT * "
																	+"from atleta natural join contratto join procuratore on atleta.id_procuratore = procuratore.id_procuratore "
																	+"where procuratore.id_procuratore = ?");
			getContrattiPS.setInt(1, ID);
			Statement st = conn.createStatement();
			ResultSet rs = getContrattiPS.executeQuery();
			while(rs.next())
			{
				Contratto c = new Contratto(rs.getString("nome"), rs.getString("cognome"),rs.getInt("durata"), rs.getDouble("guadagno"),rs.getString("tipocontratto"));
				ListaContratti.add(c);
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("C'è stato un errore nel reperire le liste dei contratti : "+ e);
		}
		return ListaContratti;
	}

	@Override
	public Contratto getContrattoAtleta(Atleta atleta) {
		try {
			PreparedStatement getContrattoAtletaPS = conn.prepareStatement("SELECT * "
																		 + "FROM contratto natural join atleta "
																		 + "WHERE contratto.id_atleta = ' ? ' ");
			Statement st = conn.createStatement();
			ResultSet rs = getContrattoAtletaPS.executeQuery();
			//da continuare
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Integer> getGettoniNaz(Atleta atleta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double PercentualeGuadagno(Contratto contratto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Atleta getAtletaPiùRedditizio(Procuratore procuratore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contratto getClubPiùRedditizio() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Atleta> getAtletaByProcuratore(int id_proc) throws SQLException {
		getAtletaByProcuratorePS = conn.prepareStatement("SELECT * FROM atleta WHERE id_procuratore = ? ");
		getAtletaByProcuratorePS.setInt(1,id_proc);
    	ResultSet rs = getAtletaByProcuratorePS.executeQuery();
		ArrayList<Atleta> atleti = new ArrayList<Atleta>();
	    while(rs.next()) {
	    	Atleta a = new Atleta(rs.getString("nome"), rs.getString("cognome"), rs.getDouble("stipendio"), rs.getString("id_atleta"),rs.getDouble("gettonepresenzanazionale"));
	    	atleti.add(a);	
	    }
	    rs.close();
        return atleti;
		
		}
	

}
