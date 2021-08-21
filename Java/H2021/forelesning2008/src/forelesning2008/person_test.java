package forelesning2008;

import javax.swing.*;

public class person_test {

	public static void main(String[] args) {
		Person p1 = new Person("Lise",23);
		Person p2 = new Person("Trond",25);
		
		//Print P1 og P2
		System.out.println(p1.toString());
		System.out.println(p2.toString());

		String fornavn = JOptionPane.showInputDialog("Skriv et fornavn: ");
		String etternavn = JOptionPane.showInputDialog("Skriv et etternavn: ");
		Person_First_Last p = new Person_First_Last(fornavn, etternavn);
		System.out.println(p.toString());
		}
	}
