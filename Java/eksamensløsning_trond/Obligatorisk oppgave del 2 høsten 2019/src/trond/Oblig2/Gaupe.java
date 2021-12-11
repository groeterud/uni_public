package trond.Oblig2;

public class Gaupe extends Dyr {
	double øretustlengde;
	
	public Gaupe(String i,char k,double l,double v,String s,String d,double øtl) {
		super(i,k,l,v,s,d);
		this.øretustlengde = øtl;
	} //Konstruktør
	
	@Override
	public String toString() {
		return super.toString() + "\t" + øretustlengde;
	}
	
	public double getØretustlengde() {
		return øretustlengde;
	}	

}
