package Daos;

import java.util.List;
import Classi.Atleta;
import Classi.Contratto;
import Classi.Procuratore;

public interface ProcuratoreDAO {
	
	public List<Contratto> getContratti(int id);
	public Contratto getContrattoAtleta(Atleta atleta);
	public List<Integer> getGettoniNaz(Atleta atleta);
	public double PercentualeGuadagno(Contratto contratto);
	public Atleta getAtletaPiùRedditizio(Procuratore procuratore);
	public Contratto getClubPiùRedditizio();
}
