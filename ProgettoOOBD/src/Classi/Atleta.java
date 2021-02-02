package Classi;

import java.util.List;

import Controller.Controller;

public class Atleta {
	//attributi
	private double GettonePresenzaNazionale;
	private Procuratore proc;
	private String Nome;
	private String Cognome;
	private double Stipendio;
	private String id_atleta;
	private List<Contratto> Contratti;
	
	//Costruttore
	public Atleta(String nome, String cognome, double stipendio,String id_atleta, double gettonePresenzaNazionale) {
		super();
		this.id_atleta = id_atleta;
		Nome = nome;
		Cognome = cognome;
		Stipendio = stipendio;
		GettonePresenzaNazionale = gettonePresenzaNazionale;
	}

	//Getter e Setter
	public String toString() {
		return "\nNome=" + Nome + ", Cognome=" + Cognome + ", Stipendio="
				+ Stipendio + ", GettonePresenzaNazionale=" + GettonePresenzaNazionale + "\n";

	}
	public double getGettonePresenzaNazionale() {
		return GettonePresenzaNazionale;
	}
	public Procuratore getProc() {
		return proc;
	}
	public String getNome() {
		return Nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public double getStipendio() {
		return Stipendio;
	}
	public String getId_atleta() {
		return id_atleta;
	}
	
	
	

	
	
	
	

}
