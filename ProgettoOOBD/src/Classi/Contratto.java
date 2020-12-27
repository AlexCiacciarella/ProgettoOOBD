package Classi;

public class Contratto {
	//attributi
	private int Durata;
	private double Guadagno;
	private Atleta ContrattoAtleta;
	
	//costruttore
	public Contratto(int durata, double guadagno, Atleta contrattoAtleta) {
		super();
		Durata = durata;
		Guadagno = guadagno;
		ContrattoAtleta = contrattoAtleta;
	}
	
	//getter e setter
	public int getDurata() {
		return Durata;
	}
	public void setDurata(int durata) {
		Durata = durata;
	}
	public double getGuadagno() {
		return Guadagno;
	}
	public void setGuadagno(double guadagno) {
		Guadagno = guadagno;
	}
	public Atleta getContrattoAtleta() {
		return ContrattoAtleta;
	}
	public void setContrattoAtleta(Atleta contrattoAtleta) {
		ContrattoAtleta = contrattoAtleta;
	}
    
}
