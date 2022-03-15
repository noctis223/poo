package poo.util;

public class Utils {
	
	private Utils(){};

	public static int mcdIterativo( int x, int y ){//metodo ad uso interno
		int r;
		do{
		     r=x%y;
		     x=y; y=r;
		}while( y!=0 );
		return x;
	}//mcd
	
	public static int mcd( int x, int y ){
	     if( y==0 ) return x;
	     return mcd( y, x%y );
	}//mcd
	
	public static int mcm(int n, int m){
		int inc_n=n, inc_m=m;
	    while( n!=m )
		  if( n<m ) n=n+inc_n;
		  else m=m+inc_m;
		return n;
	}

}
