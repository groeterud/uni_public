package trond.Oblig2;

public class HareGjenfangst extends Gjenfangst {
	private char farge;

	public HareGjenfangst(String d,String gs,double l,double v,char f) {
		super(d,gs,l,v);
		farge = f;
	} //Konstruktør

	public String toString() {
		return super.toString()+"  farge: "+farge;
	}	

}
