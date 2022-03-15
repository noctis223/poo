package poo.esercitazione1;

import java.util.Scanner;

import poo.util.Array;

public class ApplicazioneArray {

	static Scanner sc = new Scanner(System.in); 
	
	static boolean quadratoMagico(int[][] m){
		if (m.length!=m[0].length){
			System.out.println("La matrice non è quadrata!!");
			System.exit(-1);
		}
		int numeroMagico = Array.somma(Array.estraiDiagonalePrincipale(m));
		if (Array.somma(Array.estraiDiagonaleSecondaria(m))!=numeroMagico)
				return false;
		for(int i=0; i<m.length; i++)
			if (numeroMagico!=Array.somma(Array.estraiRiga(m,i)) &&
				numeroMagico!=Array.somma(Array.estraiColonna(m,i)))
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.print("Inserisci ordine della matrice:");
		//magico: int[][] m={{8,1,6},{3,5,7},{4,9,2}};
		//sella: int[][] m={{8,200,6},{3,100,7},{4,300,2}};
		int n=sc.nextInt();
		int[][] m = new int[n][n];
		Array.leggi(m,sc);
		System.out.println("Punto di sella:");
		if (Array.esisteSella(m)){
			System.out.println("Punto di sella:");
			Array.stampa(Array.sella(m));
		}else
			System.out.println("Non esiste punto di sella.");
		System.out.println("Quadrato magico: "+quadratoMagico(m));
	}

}
