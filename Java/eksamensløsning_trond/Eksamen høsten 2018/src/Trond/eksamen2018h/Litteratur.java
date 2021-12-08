package Trond.eksamen2018h;

public abstract class Litteratur implements Comparable<Litteratur> {
	private String type;
	private String isbn;
	private String forfatter;
	private String tittel;
	private int utgivelsesår;
	
	public Litteratur(String type, String isbn, String forfatter, 
			String tittel, int utgivelsesår) {
		this.type = type;
		this.isbn = isbn;
		this.forfatter = forfatter;
		this.tittel = tittel;
		this.utgivelsesår = utgivelsesår;
	}
	
	public int compareTo(Litteratur litt) {
		return this.isbn.compareTo(litt.getIsbn());
	}

	public String getIsbn() {
		return isbn;
	}

	public String getForfatter() {
		return forfatter;
	}

	public String getTittel() {
		return tittel;
	}

	public int getUtgivelsesår() {
		return utgivelsesår;
	}

	@Override
	public String toString() {
		return "Litteratur: isbn: " + isbn + ", forfatter: " + forfatter + ", tittel: " + tittel + ", utgivelsesår: "
				+ utgivelsesår;
	}
	
	public String toFile() {
		return type + "," + isbn + "," + forfatter + "," + tittel + "," + utgivelsesår;
	}
	
	
	
	

}
