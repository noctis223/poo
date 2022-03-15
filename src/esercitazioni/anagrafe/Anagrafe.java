package poo.anagrafe;

import poo.anagrafe.Persona;

public class Anagrafe {

	private Persona[] elenco;
	private int numeroPersone=0;
	private final boolean dimDinamica;

	public Anagrafe(int n, boolean dimDinamica){
		elenco = new Persona[n];
		this.dimDinamica=dimDinamica;
	}
	
	public Anagrafe(int n){
		this(n,false);
	}

	public Anagrafe(){
		this(100,false);
	}
	
	private void resize() {
		Persona[] nuovoElenco = new Persona[elenco.length*2];
		System.arraycopy(elenco,0,nuovoElenco,0,numeroPersone);
		elenco=nuovoElenco;
	}

	//completare aggiungendo in ordine alfabetico
	public boolean add(Persona p){
		if (dimDinamica==false && numeroPersone>=elenco.length)
			return false;
		if (dimDinamica && numeroPersone>=elenco.length)
			resize();
		elenco[numeroPersone]=p;
		numeroPersone++;
		return true;
	}

	public int getNumeroPersone(){return numeroPersone;}

	public boolean anagrafePiena(){
		if (!dimDinamica)
			return numeroPersone==elenco.length;
		else 
			return false;}

	private int trova(Persona p){
		//nel caso di struttura ordinata si potrebbe fare di meglio??
		boolean trovato=false;
		int i;
		for(i=0; i<numeroPersone && !trovato; i++)
			trovato = elenco[i].equals(p);
		if (!trovato) return -1;
		else return i;
	}

	public boolean rimuovi(Persona p){
		int i = trova(p);
		if (i==-1) return false;
		numeroPersone--;
		for(int j=i; j<numeroPersone; j++)
			elenco[j]=elenco[j+1];
		return true;
	}

	//come cambia il metodo se l'array è ordinato?
	public Persona[] ricerca(String cognome){
		Persona[] result = new Persona[numeroPersone];
		int index=0;
		for(int i=0; i<numeroPersone; i++)
			if ( elenco[i].getCognome().toLowerCase().startsWith(cognome.toLowerCase())){
				result[index]=elenco[i];
				index++;}
		Persona[] r = new Persona[index];
		System.arraycopy(result,0,r,0,index);
		return r;
	}

	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Numero Persone: ").append(numeroPersone);
		for(int i=0; i<numeroPersone; i++)
			sb.append('\n').append(elenco[i].toString());
		return sb.toString();
	}

	public Persona[] getPersone(Persona.Sesso sesso){//accetta Persona.MASCHILE o Persona.FEMMINILE
		Persona[] result = new Persona[numeroPersone];
		int pos=0;
		for(int i=0; i<numeroPersone; i++)
			if (elenco[i].getSesso()==sesso){
				result[pos]=elenco[i];
				pos++;
			}
		Persona[] daRestituire = new Persona[pos];
		System.arraycopy(result,0,daRestituire,0,pos);
		return daRestituire;
	}
}
