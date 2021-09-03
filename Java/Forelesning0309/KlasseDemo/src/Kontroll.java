public class Kontroll {
    Person[] personer = new Person[10];
    int teller = 0;

    public void settInn(Person person) {
        personer[teller] = person;
        teller++;
    }
}
