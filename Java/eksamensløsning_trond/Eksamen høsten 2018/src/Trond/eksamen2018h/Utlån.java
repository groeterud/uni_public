package Trond.eksamen2018h;

public class Utl�n {
	private String utdato;
	private String inndato;
	private L�ntager l�neren;
	private Litteratur boken;
	
	public Utl�n(String utdato, String inndato, L�ntager l�neren, 
			Litteratur boken) {
		this.utdato = utdato;
		this.inndato = inndato;
		this.l�neren = l�neren;
		this.boken = boken;
	}
	
	public String toString() {
		return "L�nedato: " + utdato + ", leveringsdato: " + inndato 
				+ ", L�ner: " + l�neren.getNavn() + ", Bok: " + boken.getTittel();
	}

}
