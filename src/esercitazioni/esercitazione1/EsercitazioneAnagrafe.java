package poo.esercitazione1;

import poo.anagrafe.Data;
import poo.anagrafe.Persona;

public class EsercitazioneAnagrafe {

	public static void main(String[] args) {
		System.out.println("Oggi e' il "+new Data());
		Data d=new Data( 28, 2, 2000 );
		System.out.println("Il giorno dopo il "+d+" e' il "+d.giornoDopo());
		
		Persona p1 = new Persona("Giovanni","Baldi",new Data(19,2,1954),Persona.Sesso.MASCHILE);
		Persona p2 = new Persona("Carla","Fortunata",new Data(19,2,1964),Persona.Sesso.FEMMINILE);
		System.out.println(p2);
		System.out.println(p1);	
		p2.sposaCon(p1);
		System.out.println(p2);
		System.out.println(p1);		

	}

}
