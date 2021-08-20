package forelesning2008;

public class Person {
	String navn;
	int alder;
	
	// Konstruktør med parametere: 
	public Person(String navn, int alder) {
		this.navn=navn;
		this.alder=alder;
	}// end constructor
	
	// Setter for navn, dersom du har annerledes navn på parameteret så behover man ikke this
	public void set_navn (String navn) {
		this.navn=navn;
	}
	//Setter for alder
	public void set_alder (int ny_alder) {
		alder=ny_alder;
	}
	//Getter for navn
	public String get_navn() {
		return navn;
	}
	public int get_alder() {
		return alder;
	}
	//toString er en standard metode i OOP 
	public String toString() {
		return "Navn: " + navn +", alder: "+alder;
	}
}// end class

