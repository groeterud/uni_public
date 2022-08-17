public class TallSkriver extends Thread {
    private int tall;

    public TallSkriver(int tall) {
        this.tall = tall;
    }

    @Override //overstyrer metoden i Thread
    public void run() {
        //starter en evig løkke
        while(true) {
            System.out.println(tall);
            //forsinkelse for å vise effekten
            try {
                Thread.sleep(10);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" ");
        }
    }
}
