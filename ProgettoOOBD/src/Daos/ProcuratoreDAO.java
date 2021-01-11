package Daos;

import java.util.List;
import Classi.Atleta;
import Classi.Contratto;
import Classi.Procuratore;

public interface ProcuratoreDAO {
	
	public List<Contratto> getContratti(int id);
	public List<Contratto> getContrattoAtleta();
	public List getIntroitiAtleta(int id);
	public Contratto getClubPi�Redditizio(int id);
	public Contratto getAtletaPi�Redditizio(int id);
}
