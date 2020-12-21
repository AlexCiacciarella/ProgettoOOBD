package Daos;

import java.util.List;

import Classi.Atleta;
import Classi.Contratto;

public interface AtletaDAO {
	
	public double getTotGettoniPresenza(Atleta atleta);
	public double getTotaleIntroito(Atleta atleta);
	public List<Contratto> getContrattiAtleta(Atleta atleta);
}
