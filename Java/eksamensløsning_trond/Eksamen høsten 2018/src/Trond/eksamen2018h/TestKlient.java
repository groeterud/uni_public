package Trond.eksamen2018h;

public class TestKlient {

	public static void main(String[] args) {
		Kontroll kontroll = new Kontroll();
		L�ntager l�ner = new L�ntager(1, "Ole", "Vei 1");
		Faglitteratur fbok = new Faglitteratur("F", "65.15.64", "Albert Tostein", "Ser du lyset?", 2015, "Astronomi", "Universitet");
		Utl�n utl�net = new Utl�n("30/11/2018", "30/12/2018", l�ner, fbok);
		System.out.println(l�ner.toString());
		System.out.println(fbok.toString());
		System.out.println("Utl�n: " + utl�net.toString());
	}

}
