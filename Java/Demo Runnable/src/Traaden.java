public class Traaden extends Superklasse implements Runnable{
    //Inneholder et objekt av klassen thread
    private Thread tråd;

    public Traaden() {
        tråd = new Thread(this);
        tråd.start();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Lever...");
        }
    }
}
