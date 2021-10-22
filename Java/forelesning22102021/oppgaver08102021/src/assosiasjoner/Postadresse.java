package assosiasjoner;

public class Postadresse implements Comparable<Postadresse>{
    private String postnr;
    private String poststed;

    public Postadresse(String postnr, String poststed) {
        this.postnr = postnr;
        this.poststed = poststed;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    @Override
    public int compareTo(Postadresse o) {
        return this.postnr.compareTo(o.getPostnr());
    }

    @Override
    public String toString() {
        return "Postadresse{" +
                "postnr='" + postnr + '\'' +
                ", poststed='" + poststed + '\'' +
                '}';
    }
}
