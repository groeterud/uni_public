package trond.Oblig2;

public class Gjenfangst {
	private String dato;
	private String gjenfangststed;
	private double lengde;
	private double vekt;

	public Gjenfangst(String d,String gs,double l,double v) {
		dato = d;
		gjenfangststed = gs;
		lengde = l;
		vekt = v;
	} //Konstruktør

	public String hentDato() {
		return dato;
	}

	public String hentSted() {
		return gjenfangststed;
	}
	public double hentLengde() {
		return lengde;
	}

	public double hentVekt() {
		return vekt;
	}

	public String toString() {
		return "Dato for gjenfangst: "+dato+"  Sted: "+gjenfangststed+"  Lengde: "+lengde+"  Vekt: "+vekt;
	}	

}
