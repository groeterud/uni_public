package trond.Oblig2;

public class Hare extends Dyr {
	private char type;
	private char farge;

	public Hare(String i,char k,double l,double v,String s,String d,char t,char f) {
		super(i,k,l,v,s,d);
		type = t;
		farge = f;
	} //Konstruktør

	public char hentType() {
		return type;
	}

	public char hentFarge() {
		return farge;
	}

	public String toString() {
		return super.toString() + "\t" + type + "\t" + farge;
	}
	

}
