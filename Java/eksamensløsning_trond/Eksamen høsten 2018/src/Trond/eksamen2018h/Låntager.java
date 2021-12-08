package Trond.eksamen2018h;

public class Låntager {
	private int kundenr;
	private String navn;
	private String adresse;
	
	public Låntager(int kundenr, String navn, String adresse) {
		this.kundenr = kundenr;
		this.navn = navn;
		this.adresse = adresse;
	}
	
	public int getKnr() {
		return kundenr;
	}
	
	public String getNavn() {
		return navn;
	}

	@Override
	public String toString() {
		return "Låntager: " + kundenr + ", navn: " + navn + ", adresse: " + adresse;
	}	

}
