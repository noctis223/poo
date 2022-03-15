package poo.esercitazione1;

import poo.util.Array;

public class ApplicazioneString {

	static int patternMatchingIgnoreCase(String testo, String pattern){
		int n=testo.length(), m=pattern.length();
		for( int i=0; i<=n-m; i++ )
			if( testo.substring( i, i+m ).equalsIgnoreCase( pattern ) )
				return i;		
		return -1;		
	}
	
	static int patternMatching(String testo, String pattern){
		int n=testo.length(), m=pattern.length();
		for( int i=0; i<=n-m; i++ )
			if( testo.startsWith(pattern,i) )
				return i;		
		return -1;		
	}
	
	static String[] tokenizer(String testo, char token){
		String[] result = new String[testo.length()/2];
		int start=0;
		int pos=0;
		while(true){
			boolean trovatoInizio=false;
			while(!trovatoInizio&&start<testo.length()){
				if (testo.charAt(start)!=token)
					trovatoInizio=true;
				else
					start++;					
			}
			if (!trovatoInizio) break;
			int end=start+1;
			while(end<testo.length()&&testo.charAt(end)!=token)
				end++;
			result[pos]=testo.substring(start,end);
			System.out.println(result[pos]);
			pos++;
			start=end+1;
		}
		String[] resultValido = new String[pos];
		System.arraycopy(result,0,resultValido,0,pos);
		return resultValido;		
	}
	
	public static String concatena(String[] str){
		String s="";
		for (int i = 0; i < str.length; i++) {
			s=s.concat(str[i].toUpperCase()+" ");
			// s=s+str[i].toUpperCase()+" ";
		}
		return s;
	}
	
	public static String concatenaFast(String[] str){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			buffer.append(str[i].toUpperCase()).append(" ");
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		String testo="public,static,void,main(String[],args)";
		System.out.println(patternMatching(testo,"args"));
		System.out.println("---------------------------");
		System.out.println(patternMatchingIgnoreCase(testo,"ARGS"));
		System.out.println("---------------------------");
		String[] r = tokenizer(testo,',');
		Array.stampa(r);
		System.out.println(concatenaFast(r));		
	}

}
