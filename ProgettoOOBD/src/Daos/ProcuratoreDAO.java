package Daos;

import java.util.List;
import Classi.Atleta;
import Classi.Club;
import Classi.Contratto;
import Classi.Procuratore;

public interface ProcuratoreDAO {
	
	public List<Contratto> getContratti();
	public Contratto getContrattoAtleta(Atleta atleta);
	public List<Integer> getGettoniNaz(Atleta atleta);
	public double PercentualeGuadagno(Contratto contratto);
	public Atleta getAtletaPi�Redditizio(Procuratore procuratore);
	public Club getClubPi�Redditizio();
}
