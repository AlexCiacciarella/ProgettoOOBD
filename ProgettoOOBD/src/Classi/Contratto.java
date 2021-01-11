package Classi;

public class Contratto {
	//attributi
	private int Durata;
	private double Guadagno;
	private String Nome, Cognome;
	private String TipoContratto;
	private String Id_atleta;
	private String Nome_Società;
	
	
	//costruttore
	public Contratto(String nome, String cognome,int durata, double guadagno, String tipocontratto, String id_atleta) {
		super();
		Durata = durata;
		Guadagno = guadagno;
		TipoContratto = tipocontratto;
		Nome = nome;
		Cognome = cognome;
		Id_atleta = id_atleta;
	}
	
	public Contratto(String nome, String cognome,double guadagno) {
		super();
		Nome = nome;
		Cognome = cognome;
		Guadagno = guadagno;
	}

	public Contratto(String nome_Società,int durata, double guadagno, String tipoContratto) {
		super();
		Durata = durata;
		Guadagno = guadagno;
		TipoContratto = tipoContratto;
		Nome_Società = nome_Società;
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
	
	public String getId_atleta() {
		return Id_atleta;
	}

	public String getNome_Società() {
		return Nome_Società;
	}



	@Override
	public String toString() {
		return "Contratto: Nome=" + Nome + ", Cognome=" + Cognome + ", Durata=" + Durata+ " mesi " + ", Guadagno=" + Guadagno
				+ ", TipoContratto=" + TipoContratto;
	}
	
	public String toString2() {
		return "Contratto : Nome Società= "+ Nome_Società + ", Durata= "+ Durata + ", Guadagno= "+ Guadagno+ ", Tipo Contratto= "+ TipoContratto;
	}

	public String toString3() {
		return "Contratto: Nome=" + Nome + ", Cognome= " + Cognome +  ", Guadagno=" + Guadagno;
	}
	
	
    
}
