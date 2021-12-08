package Trond.eksamen2018h;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import Hjelpeklasser.Filbehandling;

public class Kontroll {
	private ArrayList<Låntager> lånere = new ArrayList<>();
	private ArrayList<Litteratur> litteratur = new ArrayList<>();
	private ArrayList<Utlån> utlån = new ArrayList<>();
	
	public void nyFagbok(String type, String isbn, String forfatter, 
			String tittel, int utår, String fag, String nivå) {
		litteratur.add(new Faglitteratur(type, isbn, forfatter, 
				tittel, utår, fag, nivå));
	}
	
	//Linjær søkemetode:
	public Litteratur finnLitteratur(String isbn) {
		for(Litteratur l : litteratur) {
			if(l.getIsbn().equals(isbn)) return l;
		}
		return null;
	}
	
	//Binær søkemetode:
	public Litteratur finnLitteraturBin(String isbn) {
		Collections.sort(litteratur);
		int indeks = Collections.binarySearch(litteratur, isbn, null);
		if(indeks >= 0) return litteratur.get(indeks);
		else return null;
	}
	
	public Låntager finnLåntager(int kundenr) {
		for(Låntager l : lånere) {
			if(l.getKnr() == kundenr) return l;			
		}
		return null;
	}
	
	public void regUtlån(String isbn, int knr, String utdato, String inndato) {
		Litteratur litt = finnLitteratur(isbn);
		Låntager låner = finnLåntager(knr);
		utlån.add(new Utlån(utdato, inndato, låner, litt));
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
				else lesSkjønn(innLinje);				
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
		int år = Integer.parseInt(innhold.nextToken());
		String fag = innhold.nextToken();
		String nivå = innhold.nextToken();
		litteratur.add(new Faglitteratur(type, isbn, forfatter, tittel, år, fag, nivå));
	}
	
	public void lesSkjønn(String innLinje) {
		
		
	}

}
