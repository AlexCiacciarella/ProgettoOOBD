package Classi;

public class Club extends Contratto {
	private String TipoContratto;
	
	//costruttore
	public Club(int durata, double guadagno, Atleta contrattoAtleta,String tipocontratto) {
		super(durata, guadagno, contrattoAtleta);
		TipoContratto = "Club";
	}

	//getter e setter
	@Override
	public int getDurata() {
		// TODO Auto-generated method stub
		return super.getDurata();
	}

	@Override
	public void setDurata(int durata) {
		// TODO Auto-generated method stub
		super.setDurata(durata);
	}

	@Override
	public double getGuadagno() {
		// TODO Auto-generated method stub
		return super.getGuadagno();
	}

	@Override
	public void setGuadagno(double guadagno) {
		// TODO Auto-generated method stub
		super.setGuadagno(guadagno);
	}

	@Override
	public Atleta getContrattoAtleta() {
		// TODO Auto-generated method stub
		return super.getContrattoAtleta();
	}

	@Override
	public void setContrattoAtleta(Atleta contrattoAtleta) {
		// TODO Auto-generated method stub
		super.setContrattoAtleta(contrattoAtleta);
	}
	
	

}
