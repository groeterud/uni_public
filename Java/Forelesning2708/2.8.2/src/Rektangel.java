public class Rektangel {
    int høyde;
    int bredde;

    public Rektangel (int høyde, int bredde) {
        this.høyde=høyde;
        this.bredde=bredde;
    }
    public void setHøyde (int høyde) {
        this.høyde=høyde;
    }
    public void setBredde (int bredde){
        this.bredde=bredde;
    }
    public int getHøyde() {
        return høyde;
    }
    public int getBredde() {
        return bredde;
    }
    public int getAreal() {
        int areal = høyde*bredde;
        return areal;
    }
}
