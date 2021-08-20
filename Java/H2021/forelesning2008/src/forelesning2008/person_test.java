package forelesning2008;

public class person_test {

	public static void main(String[] args) {
		Person p1 = new Person("Lise",23);
		Person p2 = new Person("Trond",25);
		
		//Print P1 og P2
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		p2.set_alder(29);
		
		System.out.println(p2.toString());

		System.out.println(p2.get_alder());
	}

}
