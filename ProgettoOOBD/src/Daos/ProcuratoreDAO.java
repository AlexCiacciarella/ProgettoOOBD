package Daos;

import java.util.List;
import Classi.Atleta;
import Classi.Contratto;
import Classi.Procuratore;

public interface ProcuratoreDAO {
	
	public List<Contratto> getContratti(int id);
	public List<Contratto> getContrattoAtleta(String id);
	public List<Integer> getGettoniNaz(Atleta atleta);
	public Atleta getAtletaPi�Redditizio(Procuratore procuratore);
	public Contratto getClubPi�Redditizio();
}
