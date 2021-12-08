package Trond.eksamen2018h;

public class TestKlient {

	public static void main(String[] args) {
		Kontroll kontroll = new Kontroll();
		Låntager låner = new Låntager(1, "Ole", "Vei 1");
		Faglitteratur fbok = new Faglitteratur("F", "65.15.64", "Albert Tostein", "Ser du lyset?", 2015, "Astronomi", "Universitet");
		Utlån utlånet = new Utlån("30/11/2018", "30/12/2018", låner, fbok);
		System.out.println(låner.toString());
		System.out.println(fbok.toString());
		System.out.println("Utlån: " + utlånet.toString());
	}

}
