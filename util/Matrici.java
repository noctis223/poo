package poo.util;

public class Matrici {
	
	public static int det(int matrice[][], int ordine){
		if(matrice.length!=matrice[0].length && matrice.length!=ordine) throw new IllegalArgumentException();
		if(ordine==1) return matrice[0][0];
		if (ordine==2) return (matrice[0][0]*matrice[1][1] - matrice[0][1]*matrice[1][0]);
		boolean saltareCol=false;// se è true la colonna considerata va saltata
		boolean segnoNegativo = false;  //variabile che tiene conto del simbolo dell'elemento
		int elem;//il singolo elemento che cambia di volta in volta nel calcolo
		int d=0;
		int[][] matrix=new int[ordine-1][ordine-1];//matrice di ordine minore
		for (int i=0;i<ordine;i++){     //per il calcolo partiamo sempre dalla prima riga. Questo conta le colonne
			for (int r=1;r<ordine;r++){ //creiamo il minore
				for (int c=0;c<ordine;c++){
					if (c==i){//permette di saltare la colonna relativa all'elem in considerazione         
						saltareCol = true;  
						c++;         //salta questa colonna e vai avanti
						if (c>=ordine-1) break;
					}//if
					if(saltareCol) matrix[r-1][c-1]=matrice[r][c];//se ha saltato la colonna l'indice c va arretrato
					else matrix[r-1][c] = matrice[r][c];//c non va modificato
		        }//for colonne
				saltareCol=false;//riporta false il saltareCol
			} //for righe
			//matrix minore è popolata
			if (segnoNegativo) elem = -matrice[0][i];//all'inizio è true
			else elem = matrice[0][i];
			d += elem * det(matrix,ordine-1);//aggiunge al determinante il prodotto tra elem e il determinante del minore calcolato ricorsivamente
			segnoNegativo = !(segnoNegativo);//cambia segno per ogni elemento
		}//for colonne esterno
		return d;//d è il determinante alla fine delle chiamate ricorsive
    }
	public static double determinante(double matrice[][]){
		if(matrice.length!=matrice[0].length) throw new RuntimeException("Matrice non quadrata");
		int ordine=matrice.length;
		if(ordine==1) return matrice[0][0];
		if(ordine==2) return (matrice[0][0]*matrice[1][1] - matrice[0][1]*matrice[1][0]);
		
		double [][] minore=new double[ordine-1][ordine-1]; 	//la matrice che conterrà la matrice di ordine minore
		boolean saltaColonna=false; 			//indica se la colonna in esame è da saltare o meno
		boolean segnoNegativo=false;	
		double risultato=0;
		double valore;
		
		for(int i=0; i<ordine; i++){ //conta le colonne sulla vecchia matrice per vedere quali saltare. Si calcola sulla prima riga il determinante
			for(int r=1; r<ordine; r++){ //righe
				for(int c=0; c<ordine; c++){//colonne
					if(c==i){   	//colonna da saltare
						saltaColonna=true;
						c++;
						if(c>=ordine-1) break;
					}
					if(saltaColonna) minore[r-1][c-1] = matrice[r][c];
					else  minore[r-1][c] = matrice[r][c];
				}// for delle colonne
				saltaColonna=false;
			}//for delle righe
			//Ora la matrice minore è riempita
			if(segnoNegativo) valore = -matrice[0][i];
			else valore = matrice[0][i];
			risultato += valore*determinante(minore);
			segnoNegativo = !segnoNegativo;
		}//for esterno
		return risultato;
	}//determinante
		
	public static void main(String [] args){
		int [][] a={{1,2,3,4,5,6},{7,8,9,10,11,0},{0,12,13,14,0,15},{16,17,8,19,20,0},{0,0,0,4,0,3},{11,12,13,18,9,22}};
		System.out.println(det(a,6));
		double [][] b={{1,2,3,4,5,6},{7,8,9,10,11,0},{0,12,13,14,0,15},{16,17,8,19,20,0},{0,0,0,4,0,3},{11,12,13,18,9,22}};
		System.out.println(determinante(b));
	}
}
