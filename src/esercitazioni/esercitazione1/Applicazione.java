package poo.esercitazione1;

import java.util.Scanner;

import poo.anagrafe.Anagrafe;
import poo.anagrafe.Data;
import poo.anagrafe.Persona;

public class Applicazione {

	static Anagrafe ufficioAnagrafico = new Anagrafe(40);
	static Scanner sc=new Scanner(System.in);
	
	final static int AGGIUNGI=0;
	final static int CANCELLA=1;
	final static int RICERCA=2;
	final static int STAMPA=3;
	final static int ESCI=4;
	
	static void ricerca(){
		System.out.print("Inserisci il cognome:");
		String cognome = sc.next();
		Persona[] risultato = ufficioAnagrafico.ricerca(cognome);
		System.out.println("Risultato Ricerca");
		if (risultato.length==0)
			System.out.println("Nessuna persona corrisponde al cognome specificato!!");
		else for(int i=0; i<risultato.length;i++)
				System.out.println(risultato[i]);
	}
	
	
	static void aggiungi(){
		
		System.out.print("Inserisci nome:");
		String nome=sc.next();
		System.out.print("Inserisci cognome:");
		String cognome=sc.next();
		System.out.println("Inserisci data di nascita");
		System.out.print("Giorno (0-31):");
		int gg = sc.nextInt();
		System.out.print("Mese   (1-12):");
		int mm = sc.nextInt();
		System.out.print("Anno:");
		int aa = sc.nextInt();
		Data dataDiNascita = new Data(gg,mm,aa);
		System.out.print("Sesso [M-F]:");
		String sesso = sc.next();
		Persona.Sesso ss;
		if (sesso.equalsIgnoreCase("m"))
			ss=Persona.Sesso.MASCHILE;
		else
			ss=Persona.Sesso.FEMMINILE;
		Persona	nuovaPersona=new Persona(nome,cognome,dataDiNascita,ss);
		ufficioAnagrafico.add(nuovaPersona);	
	}
	
	
	public static void main(String[] args){			
		boolean finito=false;
		while(!finito){
			System.out.println("  ---  MENU  ---  ");
			System.out.println("  ["+AGGIUNGI+"] Aggiungi persona");
			System.out.println("  ["+CANCELLA+"] Cancella persona");
			System.out.println("  ["+RICERCA+"] Ricerca persona");
			System.out.println("  ["+STAMPA+"] Stampa anagrafe");
			System.out.println("  ["+ESCI+"] Esci");
			System.out.print("\nCosa vuoi fare:");
			int scelta=sc.nextInt();
			switch(scelta){
				case AGGIUNGI:aggiungi();break;
				case CANCELLA:break;
				case RICERCA:ricerca();break;
				case STAMPA:break;
				case ESCI:finito=true;break;
				default:System.out.println("ERRORE nella scelta!!");
			}
		}
	}//main
}
