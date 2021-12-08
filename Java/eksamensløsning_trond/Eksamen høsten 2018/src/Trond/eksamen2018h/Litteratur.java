package Trond.eksamen2018h;

public abstract class Litteratur implements Comparable<Litteratur> {
	private String type;
	private String isbn;
	private String forfatter;
	private String tittel;
	private int utgivelses�r;
	
	public Litteratur(String type, String isbn, String forfatter, 
			String tittel, int utgivelses�r) {
		this.type = type;
		this.isbn = isbn;
		this.forfatter = forfatter;
		this.tittel = tittel;
		this.utgivelses�r = utgivelses�r;
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

	public int getUtgivelses�r() {
		return utgivelses�r;
	}

	@Override
	public String toString() {
		return "Litteratur: isbn: " + isbn + ", forfatter: " + forfatter + ", tittel: " + tittel + ", utgivelses�r: "
				+ utgivelses�r;
	}
	
	public String toFile() {
		return type + "," + isbn + "," + forfatter + "," + tittel + "," + utgivelses�r;
	}
	
	
	
	

}
