package DAOPostgresImplem;

import java.sql.*;
import Controller.Controller;
import MainWindow.MainWindow;
import DBConfiguration.DBTableCreation;
import java.util.*;

import Classi.Atleta;
import Classi.Contratto;
import Classi.Procuratore;
import Daos.ProcuratoreDAO;

public class ProcuratoreDAOPostgresImplem implements ProcuratoreDAO {
    //Attributi
	private Connection conn;
    private PreparedStatement getAtletaByProcuratorePS;
    private Controller Controller;
    
    //Costruttore
	public ProcuratoreDAOPostgresImplem(Connection Connection,Controller temp) throws SQLException {
		this.conn=Connection;
		this.Controller = temp;
	}

	//Metodi
	@Override
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
				Contratto c = new Contratto(rs.getString("nome"), rs.getString("cognome"),rs.getInt("durata"), rs.getDouble("guadagno"),rs.getString("tipocontratto"), rs.getString("id_atleta"));
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
	public List<Contratto> getContrattoAtleta() {
		List<Contratto> ContrattiAtleta = new ArrayList<Contratto>();
		try {
			PreparedStatement getContrattoAtletaPS = conn.prepareStatement("SELECT * "
																		 + "FROM contratto natural join atleta "
																		 + "WHERE contratto.id_atleta = ' ? ' ");
			ResultSet rs = getContrattoAtletaPS.executeQuery();
			while(rs.next())
            {
                Contratto c = new Contratto(rs.getString("nome"), rs.getString("cognome"),rs.getInt("durata"), rs.getDouble("guadagno"),rs.getString("tipocontratto"), rs.getString("id_atleta"));
                ContrattiAtleta.add(c);
            }
            rs.close();
            return ContrattiAtleta;
		} catch (SQLException e) {
			System.out.println("Non è stato possibile ottenere i contratti degli atleti : "+e);
		}
		return null;
	}
	@Override
	public ArrayList getIntroitiAtleta(int id) {
		int ID = id;
	    ArrayList<Contratto> Introiti = new ArrayList<Contratto>();
		try {
			PreparedStatement getIntroitiAtletaPS = conn.prepareStatement("SELECT atleta.nome,atleta.cognome,contratto.guadagno "
					                                                    +  "FROM contratto natural join atleta join procuratore on atleta.id_procuratore = procuratore.id_procuratore "
					                                                    +  "WHERE procuratore.id_procuratore = ? "
					                                                    +  "GROUP BY atleta.nome,atleta.cognome,contratto.guadagno ");
			getIntroitiAtletaPS.setInt(1, ID);
			ResultSet rs = getIntroitiAtletaPS.executeQuery();
			while(rs.next())
            {
               Contratto c = new Contratto(rs.getString("nome"), rs.getString("cognome"), rs.getDouble("guadagno"));
               Introiti.add(c);
            }
            rs.close();
            return Introiti;
		} catch (SQLException e) {
			System.out.println("Non è stato possibile ottenere le informazioni sugli introiti dell'atleta: " + e);
		} 
		return null;
	 }
	@Override
	public Contratto getClubPiùRedditizio(int id) {
		Contratto c = null;
		try {
			PreparedStatement ClubpiùRedditizio = conn.prepareStatement("select * "
																	   +"from contratto "
																	   +"where percentuale_guadagno_procuratore = (select max(contratto.percentuale_guadagno_procuratore) from contratto natural join atleta join procuratore on atleta.id_procuratore = procuratore.id_procuratore where procuratore.id_procuratore = ? and contratto.tipocontratto = 'Club')");
			ClubpiùRedditizio.setInt(1, id);
			ResultSet rs = ClubpiùRedditizio.executeQuery();
			while(rs.next())
			{
				c = new Contratto(rs.getString("nome_società"), rs.getInt("durata") , rs.getDouble("guadagno"), rs.getString("tipocontratto"));
			}
			return c;
		} catch (SQLException e) {
			System.out.println("Non è stato possibile trovare il club più redditizio : "+ e);
		}
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
	public Contratto getAtletaPiùRedditizio(int id) {
		Contratto c = null;
		try {
			PreparedStatement getAtletaPS = conn.prepareStatement("select * "
																+ "from contratto natural join atleta "
																+ "where percentuale_guadagno_procuratore = (select max(percentuale_guadagno_procuratore) from contratto natural join atleta join procuratore on procuratore.id_procuratore = atleta.id_procuratore where procuratore.id_procuratore = ? )");
			getAtletaPS.setInt(1, id);
			ResultSet rs = getAtletaPS.executeQuery();
			while(rs.next()) {
			c = new Contratto(rs.getString("nome"), rs.getString("cognome"), rs.getInt("durata"), rs.getDouble("guadagno"), rs.getString("tipocontratto"), rs.getString("id_atleta"));
			}
			return c;
		} catch (SQLException e) {
			System.out.println("Non è stato possibile trovare l'atleta più redditizio : "+ e);
		}
		return null;
    }

}
