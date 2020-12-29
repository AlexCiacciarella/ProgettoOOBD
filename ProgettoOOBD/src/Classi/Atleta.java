package Classi;

import java.util.List;

public class Atleta {
	
	private int GettonePresenzaNazionale;
	private Procuratore proc;
	private List<Contratto> Contratti;
	
	public Atleta(int gettonePresenzaNazionale, Procuratore proc, List<Contratto> contratti) {
		super();
		GettonePresenzaNazionale = gettonePresenzaNazionale;
		this.proc = proc;
		Contratti = contratti;
	}
	
	

}
