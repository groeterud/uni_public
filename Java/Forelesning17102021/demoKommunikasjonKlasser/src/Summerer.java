public class Summerer {
    int tall_en;
    int tall_to;
    int sum;

    public Summerer(int tall_en, int tall_to) {
        this.tall_en = tall_en;
        this.tall_to = tall_to;
        this.sum=0;
    }

    public int getTall_en() {
        return tall_en;
    }

    public void setTall_en(int tall_en) {
        this.tall_en = tall_en;
    }

    public int getTall_to() {
        return tall_to;
    }

    public void setTall_to(int tall_to) {
        this.tall_to = tall_to;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
