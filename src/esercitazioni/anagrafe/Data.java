package poo.anagrafe;

import java.util.GregorianCalendar;

//file Data.java

//import java.util.*;

public class Data{

	public static final int GIORNO=0, MESE=1, ANNO=2;

	private static final long GIORNO_IN_MILLIS = 1000*60*60*24;

	private int g, m, a;

	public Data(){
		GregorianCalendar gc=new GregorianCalendar();
		g=gc.get( GregorianCalendar.DAY_OF_MONTH );
		m=gc.get( GregorianCalendar.MONTH )+1;
		a=gc.get( GregorianCalendar.YEAR );
	}//Data

	public Data(int g, int m, int a){
		if( g<1 || g>31 || m<1 || m>12 || a<0 ){
			System.out.println(g+"/"+m+"/"+a+" non e' una data valida");
			System.exit(-1);
		}
		this.g=g; this.m=m; this.a=a;
	}//Data

	public Data(Data d){
		g=d.g; m=d.m; a=d.a;
	}//Data

	public int get( int cosa ){
		switch( cosa ){
			case GIORNO: return g;
			case MESE: return m;
			case ANNO: return a;
			default: return -1;
		}
	}//cosa

	public static boolean bisestile(int anno){
		if( anno%4!=0 ) return false;
		if( anno%100==0 && anno%400!=0 ) return false;
		return true;
	}//bisestile

	public static int durataMese(int mese, int anno){
		int durata;
		switch( mese ){
			case 1: case 3: case 5: case 7: case 8:
			case 10: case 12: durata=31; break;
			case 2: durata= bisestile(anno) ? 29:28; break;
			default: durata=30;
		}//switch
		return durata;
	}//durataMese

	public Data giornoDopo(){
		/*
		int durata;
		switch( mese ){
			case 1: case 3: case 5: case 7: case 8:
			case 10: case 12: durata=31; break;
			case 2: durata= bisestile(anno) ? 29:28; break;
			default: durata=30;
		}//switch
		*/
		int durata = durataMese(m,a);
		int g1, m1, a1;
		if( g==durata ){
			g1=1;
			if( m==12 ){ m1=1; a1=a+1; }
			else{ m1=m+1; a1=a; }
		}
		else{ g1=g+1; m1=m; a1=a; }
		return new Data( g1,m1,a1 );
	}//giornoDopo

	public Data giornoPrima(){
		if (g>1)//cambia solo il giorno
			return new Data(g-1,m,a);
		//siamo sicuri che g==1
		if (m>1){//cambia mese e giorno
			int nuovoGiorno = durataMese(m-1,a);
			return new Data(nuovoGiorno,m-1,a);
		}
		//cambia giorno, mese, anno
		return new Data(31,12,a-1);
	}//giornoPrima

	public int distanzaInGiorni( Data d ){
		GregorianCalendar gc1 = new GregorianCalendar(a,m,g);
		GregorianCalendar gc2 = new GregorianCalendar(d.a,d.m,d.g);
		long distanzaInMillis = Math.abs(gc1.getTimeInMillis()-gc2.getTimeInMillis());
		return (int)(distanzaInMillis/GIORNO_IN_MILLIS);
	}//distanzaInGiorni

	public boolean equals( Object o){
		if (this==o) return true;
		if( !(o instanceof Data) ) return false;
		Data d=(Data)o;
		return this.g==d.g && this.m==d.m && this.a==d.a;
	}//equals

	public String toString(){
		return g+"/"+m+"/"+a;
	}//toString

	public static void main( String []args ){//solo per test
		System.out.println("Oggi e' il "+new Data());
		Data d=new Data( 28, 2, 2000 );
		System.out.println("Il giorno dopo il "+d+" e' il "+d.giornoDopo());
	}//main
}//Data