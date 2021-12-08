package Trond.eksamen2018h;

public class Faglitteratur extends Litteratur {
	private String fag;
	private String nivå;
	
	public Faglitteratur(String type, String isbn, String forfatter, 
			String tittel, int utgivelsesår, String fag, String nivå) {
		super(type, isbn, forfatter, tittel, utgivelsesår);
		this.fag = fag;
		this.nivå = nivå;
	}

	public String getFag() {
		return fag;
	}

	public String getNivå() {
		return nivå;
	}

	@Override
	public String toString() {
		return "Faglitteratur: " + super.toString() + "Fag: " + fag + "Nivå: " + nivå;
	}
	
	public String toFile() {
		return "F" + "," + super.toFile() + "," + fag + "," + nivå;
	}
}
