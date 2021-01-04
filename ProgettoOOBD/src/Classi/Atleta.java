package Classi;

import java.util.List;

public class Atleta {
	
	private double GettonePresenzaNazionale;
	private Procuratore proc;
	private String nome;
	private String cognome;
	private double stipendio;
	private String id_atleta;
	
	//Costruttore
	public Atleta(String id_atleta) {
		super();
		this.id_atleta = id_atleta;
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

	public void setProc(Procuratore proc) {
		this.proc = proc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public String getId_atleta() {
		return id_atleta;
	}

	public void setId_atleta(String id_atleta) {
		this.id_atleta = id_atleta;
	}
	
	
	

	
	
	
	

}
