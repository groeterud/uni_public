package trond.Oblig2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DyreGUI {
	DyreKontroll kontroll = new DyreKontroll();
	private String[ ] ALTERNATIVER = {"Registrer gaupe","Registrer hare","Registrer gaupegjenfangst","Registrer haregjenfangst","Finn dyr","List ut dyr","Dyr med fangst","Avslutt"};
	private final int REG_GAUPE = 0;
	private final int REG_HARE = 1;
	private final int REG_GFANGST = 2;
	private final int REG_HFANGST = 3;
	private final int FINN_DYR = 4;
	private final int LIST_DYR = 5;
	private final int LIST_DYR_MED_GJENFANGST = 6;
	private int antallGauper = 1;
	private int antallHarer = 1;
	
	private final int AVSLUTT = 7;
	
	public DyreGUI() {
		kontroll.regDyr(new Hare("H1",'M', 50.5, 5.5, "S3", "15.06.2019", 'V', 'B'));
		kontroll.regDyr(new Gaupe("G1", 'F', 60.5, 12.5, "S6", "20.06.2019", 9.5));
		kontroll.regHgjenfangst("H1","25.07.2019", "S8", 50.5, 5.7, 'B');
	}
	
	public void start() {
		boolean fortsett = true;
		while(fortsett) {
			int valg = lesValg();
			switch(valg) {
				case REG_GAUPE : regGaupe();
					break;
				case REG_HARE : regHare();
					break;
				case REG_GFANGST : regGfangst();
					break;
				case REG_HFANGST : regHfangst();
					break;
				case FINN_DYR : finnDyr();
					break;
				case LIST_DYR : listDyr();
					break;
				case LIST_DYR_MED_GJENFANGST: listDyrMedGjenfangst();
					break;
				default : fortsett = false;
			}
		} //while
	} //metode
	
	public int lesValg( ) {
		int valg = JOptionPane.showOptionDialog(null,"Gjør et valg","Dyreregister",JOptionPane.DEFAULT_OPTION,
		JOptionPane.PLAIN_MESSAGE,null,ALTERNATIVER,ALTERNATIVER[0]);
		return valg;
	}
	
	public void regGaupe() {
		String lestKjønn = JOptionPane.showInputDialog("Dyrets kjønn:");
		char kjønn = lestKjønn.charAt(0);
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Dyrets lengde:"));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Dyrets vekt:"));
		String fangststed = JOptionPane.showInputDialog("Fangststed:");
		String dato = JOptionPane.showInputDialog("Dato:");
		double øretustlengde = Double.parseDouble(JOptionPane.showInputDialog("Dyrets vekt:"));
		kontroll.regGaupe(kjønn,lengde,vekt,fangststed,dato,øretustlengde);
	}
	
	public void regHare() {
		String lestKjønn = JOptionPane.showInputDialog("Dyrets kjønn:");
		char kjønn = lestKjønn.charAt(0);
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Dyrets lengde:"));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Dyrets vekt:"));
		String fangststed = JOptionPane.showInputDialog("Fangststed:");
		String dato = JOptionPane.showInputDialog("Dato:");
		String lestType = JOptionPane.showInputDialog("Dyrets type:");
		char type = lestType.charAt(0);
		String lestFarge = JOptionPane.showInputDialog("Dyrets farge:");
		char farge = lestFarge.charAt(0);
		kontroll.regHare(kjønn,lengde,vekt,fangststed,dato,type,farge);
	}
	
	public void regHfangst() {
		String id = JOptionPane.showInputDialog("Dyrets ID:");
		String dato = JOptionPane.showInputDialog("Dato for gjenfangst:");
		String sted = JOptionPane.showInputDialog("Sted for gjenfangst:");
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Dyrets lengde:"));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Dyrets vekt:"));
		String lestFarge = JOptionPane.showInputDialog("Dyrets farge:");
		char farge = lestFarge.charAt(0);
		kontroll.regHgjenfangst(id,dato,sted,lengde,vekt,farge);
	}
	
	public void regGfangst() {
		String id = JOptionPane.showInputDialog("Dyrets ID:");
		String dato = JOptionPane.showInputDialog("Dato for gjenfangst:");
		String sted = JOptionPane.showInputDialog("Sted for gjenfangst:");
		double lengde = Double.parseDouble(JOptionPane.showInputDialog("Dyrets lengde:"));
		double vekt = Double.parseDouble(JOptionPane.showInputDialog("Dyrets vekt:"));
		double øretustlengde = Double.parseDouble(JOptionPane.showInputDialog("Øretustenes lengde:"));
		kontroll.regGgjenfangst(id,dato,sted,lengde,vekt,øretustlengde);
	}
	
	public void finnDyr() {
		String id = JOptionPane.showInputDialog("Dyrets ID:");
		id = id.trim();
		Dyr dyret = kontroll.finnDyr(id);
		if(dyret !=null) JOptionPane.showMessageDialog(null,dyret.toString());
		else JOptionPane.showMessageDialog(null,"Fant ikke dyret");
	}
	
	public void listDyr() {
		ArrayList<Dyr> dyrene = kontroll.getDyr();
		String uttekst = "";
		for(int i = 0;i < dyrene.size();i++) {
			Dyr dyret = dyrene.get(i);
			uttekst+=dyret.toString();
			uttekst+="\n";			
		}
		System.out.println(uttekst);
		//JOptionPane.showMessageDialog(null,uttekst);
	}
	
	public void listDyrMedGjenfangst() {
		ArrayList<Dyr> dyrene = kontroll.getDyr();
		String uttekst = "";
		for(int i = 0;i < dyrene.size();i++) {
			Dyr dyret = dyrene.get(i);
			uttekst+=dyret.toString();
			uttekst+="\n";
			for(Gjenfangst g : dyret.gjenfangster) {
				uttekst+=g.toString();
				uttekst+="\n";
			}
			//uttekst+="\n";			
		}
		System.out.println(uttekst);
		//JOptionPane.showMessageDialog(null,uttekst);
	}	

}
