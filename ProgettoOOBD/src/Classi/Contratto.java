package Classi;

public class Contratto {
	//attributi
	private int Durata;
	private double Guadagno;
	private Atleta Atleta;
	private String TipoContratto;
	
	
	//costruttore
	public Contratto(int durata, double guadagno, Atleta atleta, String tipocontratto) {
		super();
		Durata = durata;
		Guadagno = guadagno;
		Atleta = atleta;
		TipoContratto = tipocontratto;
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
	public Atleta getAtleta() {
		return Atleta;
	}
	public void setAtleta(Atleta contrattoAtleta) {
		Atleta = contrattoAtleta;
	}
    
}
