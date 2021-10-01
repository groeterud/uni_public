import java.util.ArrayList;

public class GeneriskStack<Type> {
    //Oppretter en ArrayList av Type
    private ArrayList<Type> stakk = new ArrayList<>();

    public int getSize() {
        /*
        gets the size of the list
         */
        return stakk.size();
    }

    public boolean isEmpty() {
        return stakk.isEmpty();
    }

    // implementerer standardmetodene for en stack
    // Metoden peek() "ser på" det øverste elementet:
    public Type peek() {
        return stakk.get(stakk.size()-1);
        //return stakk.get(-1);          // Java er ikke smart nok :(
    }

    // legg inn i stacken
    public void push (Type t) {
        stakk.add(t);
    }

    //metode som henter og fjerner det siste elementet
    public Type pop() {
        //Vi trenger en huskereferanse
        Type t = stakk.get(stakk.size()-1);
        //fjerner siste elementet
        stakk.remove(stakk.size()-1);
        return t;
    }

}
