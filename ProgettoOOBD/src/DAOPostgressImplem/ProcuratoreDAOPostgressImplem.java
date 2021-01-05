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
	public List<Contratto> getContratti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contratto getContrattoAtleta(Atleta atleta) {
		// TODO Auto-generated method stub
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
	    	Atleta a = new Atleta(rs.getString("id_atleta"));
	    	a.setNome(rs.getString("nome"));
	    	a.setCognome(rs.getString("cognome"));
	    	a.setStipendio(rs.getDouble("stipendio"));
	    	a.setGettonePresenzaNazionale(rs.getDouble("gettonepresenzanazionale"));
	    	atleti.add(a);	
	    }
	    rs.close();
        return atleti;
		
		}
	

}
