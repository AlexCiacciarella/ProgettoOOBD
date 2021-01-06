package Classi;

import java.util.List;

public class Atleta {
	
	private double GettonePresenzaNazionale;
	private Procuratore proc;
	private String Nome;
	private String Cognome;
	private double Stipendio;
	private String id_atleta;
	
	//Costruttore
	public Atleta(String id_atleta, String nome, String cognome, double stipendio, double gettonepresenzanazionale) {
		super();
		this.id_atleta = id_atleta;
		Nome = nome;
		Cognome = cognome;
		Stipendio = stipendio;
		GettonePresenzaNazionale = gettonepresenzanazionale;
	}

	//Getter e Setter
	public double getGettonePresenzaNazionale() {
		return GettonePresenzaNazionale;
	}

	public void setGettonePresenzaNazionale(double gettonePresenzaNazionale) {
		GettonePresenzaNazionale = gettonePresenzaNazionale;
	}

	public Procuratore getProc() {
		return proc;
	}

	@Override
	public String toString() {
		return "Atleta nome=" + Nome + ", cognome=" + Cognome + ", stipendio=" + Stipendio
				+ ", GettonePresenzaNazionale=" + GettonePresenzaNazionale;
	}

	public void setProc(Procuratore proc) {
		this.proc = proc;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		this.Cognome = cognome;
	}

	public double getStipendio() {
		return Stipendio;
	}

	public void setStipendio(double stipendio) {
		this.Stipendio = stipendio;
	}

	public String getId_atleta() {
		return id_atleta;
	}

	public void setId_atleta(String id_atleta) {
		this.id_atleta = id_atleta;
	}
	
	
	

	
	
	
	

}
