package poo.anagrafe;

public class Persona{

	public enum Sesso{ MASCHILE, FEMMINILE }
	public enum StatoCivile{ CELIBE, NUBILE, CONIUGATO, CONIUGATA }

	private String nome;
	private String cognome;
	private Sesso sesso;
	private Data dataDiNascita;
	private String numTel;
	private Persona sposatoCon;
	
	private boolean maggiorenne=false;

	public Persona(String nome, String cognome, Data dataDiNascita, Sesso sesso){
		if (nome==null || cognome==null || dataDiNascita==null )
			throw new IllegalArgumentException("Ricevuto qualche parametro nullo");
		this.nome=nome;
		this.cognome=cognome;
		this.sesso=sesso;
		//this.dataDiNascita=new Data(dataDiNascita);
		this.dataDiNascita=dataDiNascita;
	}
	public Persona(Persona p){
		this.nome=p.nome;
		this.cognome=p.cognome;
		this.sesso=p.sesso;
		this.dataDiNascita=p.dataDiNascita;
		this.numTel=p.numTel;
		//Aliasing voluto??
		this.sposatoCon = p.sposatoCon;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public String getCognome() {
		return cognome;
	}
	public Data getDataDiNascita() {
		return dataDiNascita;
	}
	public String getNome() {
		return nome;
	}
	public Sesso getSesso() {
		return sesso;
	}
	public Persona getSposatoCon() {
		return sposatoCon;
	}
	public boolean maggiorenne(){
		
		if (maggiorenne) return true;
		
		Data dataOdierna = new Data();
		if (dataOdierna.get(Data.ANNO)-dataDiNascita.get(Data.ANNO)>18)
			maggiorenne=true;
		else if (dataOdierna.get(Data.ANNO)-dataDiNascita.get(Data.ANNO)<18)
			maggiorenne=false;
		else if (dataOdierna.get(Data.MESE)>dataDiNascita.get(Data.MESE))
			maggiorenne=true;
		else if (dataOdierna.get(Data.MESE)<dataDiNascita.get(Data.MESE))
			maggiorenne=false;
		else
			maggiorenne=(dataOdierna.get(Data.GIORNO)>=dataDiNascita.get(Data.GIORNO));
		return maggiorenne;
	}
	public StatoCivile getStatoCivile(){
		if (sesso==Sesso.MASCHILE){
			if (sposatoCon==null) return StatoCivile.CELIBE;
			else return StatoCivile.CONIUGATO;
		}else if (sposatoCon==null) return StatoCivile.NUBILE;
		else return StatoCivile.CONIUGATA;
	}
	public boolean sposaCon(Persona p){
		//Perchè non si usa equals?
		if (this==p) return false;
		//controlliamo altri vincoli
		if (this.sesso==p.sesso) return false;
		if (!this.maggiorenne()||!p.maggiorenne()) return false;
		if (this.sposatoCon!=null || p.sposatoCon!=null) return false;
		this.sposatoCon=p;
		p.sposatoCon=this;
		return true;
	}
	public boolean equals(Object o){
		if (!(o instanceof Persona)) return false;
		if (o==this) return true;
		Persona p=(Persona)o;
		return  p.nome.equals(nome)&&
				p.cognome.equals(cognome)&&
				p.dataDiNascita.equals(dataDiNascita)&&
				p.sesso==sesso;
	}
	public String toString(){
		String s = "Dati persona:\nNome "+nome+"\nCognome: "+cognome+"\nData di nascita: "+dataDiNascita;
		if (sesso==Sesso.MASCHILE)
			s +="\nSesso: Maschile";
		else
			s+="\nSesso: Femminile";
		s+="\nMaggiorenne:"+maggiorenne();
		s+="\nStato Civile:";
		switch(getStatoCivile()){
			case CELIBE:s+="Celibe";break;
			case NUBILE:s+="Nubile";break;
			case CONIUGATO:s+="Coniugato con "+sposatoCon.cognome+" "+sposatoCon.nome;break;
			case CONIUGATA:s+="Coniugata con "+sposatoCon.cognome+" "+sposatoCon.nome;break;
		}
		//Perchè non si è usato il metodo toString di PERSONA nel caso di CONIUGATO/CONIUGATA??
		return s;
	}
	public static void main(String[] args) {
		Persona p1 = new Persona("Giovanni","Baldi",new Data(19,2,1954),Persona.Sesso.MASCHILE);
		Persona p2 = new Persona("Carla","Fortunata",new Data(19,2,1964),Persona.Sesso.FEMMINILE);
		System.out.println(p2);
		System.out.println(p1);
		p2.sposaCon(p1);
		System.out.println(p2);
		System.out.println(p1);
	}
}