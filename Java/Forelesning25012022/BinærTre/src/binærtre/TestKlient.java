package binærtre;

public class TestKlient {
    public static void main(String[] args) {
        Node node = new Node(5);
        node.settInn(3);
        node.settInn(10);
        node.settInn(20);
        node.settInn(4);
        node.settInn(1);

        System.out.println(node.søkVerdi(4));

        System.out.println(node.toString());
    }
}
