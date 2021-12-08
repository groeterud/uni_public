package Trond.eksamen2018h;

public class Utlån {
	private String utdato;
	private String inndato;
	private Låntager låneren;
	private Litteratur boken;
	
	public Utlån(String utdato, String inndato, Låntager låneren, 
			Litteratur boken) {
		this.utdato = utdato;
		this.inndato = inndato;
		this.låneren = låneren;
		this.boken = boken;
	}
	
	public String toString() {
		return "Lånedato: " + utdato + ", leveringsdato: " + inndato 
				+ ", Låner: " + låneren.getNavn() + ", Bok: " + boken.getTittel();
	}

}
