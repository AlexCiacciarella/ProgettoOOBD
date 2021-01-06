package Classi;

public class Contratto {
	//attributi
	private int Durata;
	private double Guadagno;
	private String Nome, Cognome;
	private String TipoContratto;
	
	
	//costruttore
	public Contratto(String nome, String cognome,int durata, double guadagno, String tipocontratto) {
		super();
		Durata = durata;
		Guadagno = guadagno;
		TipoContratto = tipocontratto;
		Nome = nome;
		Cognome = cognome;
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

	public String getNome() {
		return Nome;
	}

	public String getCognome() {
		return Cognome;
	}

	@Override
	public String toString() {
		return "Contratto: Nome=" + Nome + ", Cognome=" + Cognome + ", Durata=" + Durata+ " mesi " + ", Guadagno=" + Guadagno
				+ ", TipoContratto=" + TipoContratto;
	}
	

	
    
}
