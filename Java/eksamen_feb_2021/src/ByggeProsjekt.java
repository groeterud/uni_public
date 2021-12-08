public class ByggeProsjekt extends Prosjekt{
    private String adresse;

    public ByggeProsjekt(int prosjektNr, String type, double budsjett, boolean tildelt, String adresse) {
        super(prosjektNr, type, budsjett, tildelt);
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return super.toString()+"ByggeProsjekt{" +
                "adresse='" + adresse + '\'' +
                '}';
    }
}
