package poo.util;

import java.util.Scanner;

public class Array {

	private Array(){}
	
	public static int posizioneMassimo(int[] v){
		if (v.length==0) return -1;
		int max=0;
		for (int i = 1; i < v.length; i++) {
			if(v[i]>v[max])
				max=i;
		}
		return max;
	}
	
	public static int posizioneMassimo(double[] v){
		if (v.length==0) return -1;
		int max=0;
		for (int i = 1; i < v.length; i++) {
			if(v[i]>v[max])
				max=i;
		}
		return max;
	}	
	
	public static int somma(int[] v){
		int somma=0;
		for (int i = 0; i < v.length; i++) {
			somma+=v[i];
		}
		return somma;		
	}
	
	public static int posizioneMinimo(int[] v){
		if (v.length==0) return -1;
		int min=0;
		for (int i = 1; i < v.length; i++) {
			if(v[i]<v[min])
				min=i;
		}
		return min;
	}
	
	public static int[] estraiRiga(int[][] mat,int riga){	
		if (riga>=mat.length || riga<0)
			return null;
		return mat[riga];		
	}

	public static int[] estraiColonna(int[][] mat,int c){	
		if (c>=mat[0].length || c<0)
			return null;
		int[] colonna = new int[mat[0].length];
		for(int i=0; i<mat[0].length; i++)
			colonna[i]=mat[i][c];
		return colonna;		
	}	
	
	public static int[] estraiDiagonalePrincipale(int[][] mat){	
		if (mat.length!=mat[0].length)
			return null;
		int[] diagonale = new int[mat.length];
		for(int i=0; i<mat[0].length; i++)
			diagonale[i]=mat[i][i];
		return diagonale;		
	}
	
	public static int[] estraiDiagonaleSecondaria(int[][] mat){	
		if (mat.length!=mat[0].length)
			return null;
		int[] diagonale = new int[mat.length];
		for(int i=0; i<mat[0].length; i++)
			diagonale[i]=mat[i][mat.length-i-1];
		return diagonale;		
	}	
	
	public static boolean esisteSella(int[][] m){
		for(int i=0; i<m.length; i++){
			int posMassimoRiga=posizioneMassimo(estraiRiga(m,i));
			if (i==posizioneMinimo(estraiColonna(m,posMassimoRiga)))
				return true;
			int posMinimoRiga=posizioneMinimo( estraiRiga(m,i));
			if (i==posizioneMassimo(estraiColonna(m,posMinimoRiga)))
				return true;	
		}
		return false;
	}
	
	 public static int[] sella(int[][] m){
		for(int i=0; i<m.length; i++){
			int posMassimoRiga=posizioneMassimo(estraiRiga(m,i));
			if (i==posizioneMinimo(estraiColonna(m,posMassimoRiga)))
				return new int[]{i,posMassimoRiga};
			int posMinimoRiga=posizioneMinimo( estraiRiga(m,i));
			if (i==posizioneMassimo(estraiColonna(m,posMinimoRiga)))
				return new int[]{i,posMinimoRiga};		
		}
		return null;
	}
	
	public static void leggi(int[][] m, Scanner sc){
		System.out.println("Inserisci la matrice:");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print("M["+i+","+j+"]=");
				m[i][j]=sc.nextInt();
			}
		}		
	}
	
	public static void stampa(int[][] m){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++)
				System.out.printf("%6d",m[i][j]);
			System.out.println();
		}		
	}	
	
	public static void stampa(int[] v){
		for (int i = 0; i < v.length; i++)
				System.out.printf("%6d",v[i]);	
		System.out.println();
	}	
	
	public static void stampa(String[] v){
		for (int i = 0; i < v.length; i++)
				System.out.println(v[i]);	
		System.out.println();
	}
}