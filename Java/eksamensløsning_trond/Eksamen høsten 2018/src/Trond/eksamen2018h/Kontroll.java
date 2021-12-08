package Trond.eksamen2018h;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import Hjelpeklasser.Filbehandling;

public class Kontroll {
	private ArrayList<L�ntager> l�nere = new ArrayList<>();
	private ArrayList<Litteratur> litteratur = new ArrayList<>();
	private ArrayList<Utl�n> utl�n = new ArrayList<>();
	
	public void nyFagbok(String type, String isbn, String forfatter, 
			String tittel, int ut�r, String fag, String niv�) {
		litteratur.add(new Faglitteratur(type, isbn, forfatter, 
				tittel, ut�r, fag, niv�));
	}
	
	//Linj�r s�kemetode:
	public Litteratur finnLitteratur(String isbn) {
		for(Litteratur l : litteratur) {
			if(l.getIsbn().equals(isbn)) return l;
		}
		return null;
	}
	
	//Bin�r s�kemetode:
	public Litteratur finnLitteraturBin(String isbn) {
		Collections.sort(litteratur);
		int indeks = Collections.binarySearch(litteratur, isbn, null);
		if(indeks >= 0) return litteratur.get(indeks);
		else return null;
	}
	
	public L�ntager finnL�ntager(int kundenr) {
		for(L�ntager l : l�nere) {
			if(l.getKnr() == kundenr) return l;			
		}
		return null;
	}
	
	public void regUtl�n(String isbn, int knr, String utdato, String inndato) {
		Litteratur litt = finnLitteratur(isbn);
		L�ntager l�ner = finnL�ntager(knr);
		utl�n.add(new Utl�n(utdato, inndato, l�ner, litt));
	}
	
	public void lagreLitteratur(String filnavn) {		
		try {
			PrintWriter utfil = Filbehandling.lagSkriveForbindelse(filnavn);
			for(Litteratur l : litteratur) utfil.println(l.toFile());
			utfil.close();
		}catch(Exception e) {}
	}
	
	public void lesLitteratur(String filnavn) {
		litteratur.clear();
		try {
			BufferedReader innfil = Filbehandling.lagLeseForbindelse(filnavn);
			String innLinje = innfil.readLine();
			while(innLinje != null) {
				if(innLinje.charAt(0) == 'F') lesFag(innLinje);
				else lesSkj�nn(innLinje);				
			}
			innfil.close();
		} catch(Exception e) {}
	}
	
	public void lesFag(String innLinje) {
		StringTokenizer innhold = new StringTokenizer(innLinje, ",");
		String type = innhold.nextToken();
		String isbn = innhold.nextToken();
		String forfatter = innhold.nextToken();
		String tittel = innhold.nextToken();
		int �r = Integer.parseInt(innhold.nextToken());
		String fag = innhold.nextToken();
		String niv� = innhold.nextToken();
		litteratur.add(new Faglitteratur(type, isbn, forfatter, tittel, �r, fag, niv�));
	}
	
	public void lesSkj�nn(String innLinje) {
		
		
	}

}
