package Trond.eksamen2018h;

public class Faglitteratur extends Litteratur {
	private String fag;
	private String niv�;
	
	public Faglitteratur(String type, String isbn, String forfatter, 
			String tittel, int utgivelses�r, String fag, String niv�) {
		super(type, isbn, forfatter, tittel, utgivelses�r);
		this.fag = fag;
		this.niv� = niv�;
	}

	public String getFag() {
		return fag;
	}

	public String getNiv�() {
		return niv�;
	}

	@Override
	public String toString() {
		return "Faglitteratur: " + super.toString() + "Fag: " + fag + "Niv�: " + niv�;
	}
	
	public String toFile() {
		return "F" + "," + super.toFile() + "," + fag + "," + niv�;
	}
}
