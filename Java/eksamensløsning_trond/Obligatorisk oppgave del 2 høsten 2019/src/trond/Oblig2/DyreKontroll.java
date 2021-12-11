package trond.Oblig2;

import java.util.ArrayList;

public class DyreKontroll {
	ArrayList<Dyr> dyreliste = new ArrayList<Dyr>();
	private int antallGauper = 0;
	private int antallHarer = 0;
	
	public void regGaupe(char kjønn,double lengde,double vekt,String fangststed,String dato,double øretustlengde) {
		antallGauper++;//Brukes til å gi dyret et autonummer
		String id = "G"+antallGauper;
		id.trim();
		Gaupe nyGaupe = new Gaupe(id,kjønn,lengde,vekt,fangststed,dato,øretustlengde);
		dyreliste.add(nyGaupe);
	}
	
	public void regHare(char kjønn,double lengde,double vekt,String fangststed,String dato,char type,char farge) {
		antallHarer++;//Brukes til å gi dyret et autonummer
		String id = "H"+antallHarer;
		id = id.trim();
		Hare nyhare = new Hare(id,kjønn,lengde,vekt,fangststed,dato,type,farge);
		dyreliste.add(nyhare);
	}
	
	public void regDyr(Dyr dyr) {
		dyreliste.add(dyr);
	}
	
	public Dyr finnDyr(String id) {
		//Bruker linjært søk etter dyr:
		Dyr dyr = null;
		boolean funnet = false;
		int teller = 0;
		while(!funnet) {
			dyr = dyreliste.get(teller);
			if(id.equals(dyr.hentId())) funnet = true;
			else teller++;
		}
		return dyr;
	}
	
	public void regGjenfangst(Gjenfangst gjenfangst, String id) {
		Dyr dyret = finnDyr(id);
		if(dyret !=null) {
			dyret.regGjenfangst(gjenfangst);
		}
	}
	
	public void regHgjenfangst(String id,String dato,String sted,double lengde,double vekt,char farge) {
		Hare haren = (Hare)finnDyr(id);
		if(haren !=null) {
			HareGjenfangst fangst = new HareGjenfangst(dato,sted,lengde,vekt,farge);
			haren.regGjenfangst(fangst);
		}
	}
	
	public void regGgjenfangst(String id,String dato,String sted,double lengde,double vekt,double øretustlengde) {
		Gaupe gaupen = (Gaupe)finnDyr(id);
		if(gaupen !=null) {
			GaupeGjenfangst fangst = new GaupeGjenfangst(dato,sted,lengde,vekt,øretustlengde);
			gaupen.regGjenfangst(fangst);
		}
	}
	
	public ArrayList<Dyr> getDyr() {
		return dyreliste;
	}
	

}
