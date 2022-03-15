package poo.util;

public final class Mat{
	private Mat(){}
	//tolleranza nei confronti tra double
	private static double EPSILON=1.0E-14; 
	public static boolean sufficientementeProssimi( double x1, double x2 ){
		if( Math.abs( x1-x2 )<=EPSILON ) return true;
		return false;
	}//sufficientementeProssimi
	public static double getEpsilon(){ return EPSILON; }
	public static void setEpsilon( double EPSILON ){
		Mat.EPSILON=EPSILON;
	}//setEpsilon
	public static int mcm( int n, int m ){
		if( n<=0 || m<=0 ) throw new IllegalArgumentException();
		return (n*m)/mcd_euclide(n,m);
	}//mcm
	public static int mcd( int n, int m ){
		if( n<=0 || m<=0 ) throw new IllegalArgumentException();
		return mcd_euclide(n,m);
	}//mcd
	private static int mcd_euclide( int n, int m ){
		if( m==0 ) return n;
		return mcd_euclide(m,n%m);
	}//mcd_euclide	
	
	public static int sqrt( int num ){
	    int op = num;
	    int res = 0;
	    int one = 1 << 30; // The second-to-top bit is set
	    // "one" starts at the highest power of four <= the argument.
	    while( one > op )
	       one >>= 2;

	    while( one != 0 ){
	       if( op >= res + one ){
	           op -= res + one;
	           res = (res >> 1) + one;
	       } 
	       else res >>= 1;
	       one >>= 2;
	    }
	    return res;
	}//sqrt
	public static int pow(int a, int n){
		if(n==0) return 1;
		if(n==1) return a;
		int p=pow(a,n/2);
		p=p*p;
		if(n%2!=0) p=p*a;
		return p;
	}//pow
	public static long fibo( int n ){
		if( n<1 ) throw new IllegalArgumentException();
		if( n<=2 ) return 1;
		long[][] a={{1,1},{1,0}};
		long[][] b=pow(a,n-1);
		return b[0][0];
	}//fibo

	private static long[][] mul( long[][]a, long[][] b ){
		if( a.length!=a[0].length || b.length!=b[0].length || 
			a.length!=b.length )
			throw new IllegalArgumentException();
		long[][] p=new long[a.length][a.length];
	 
		for( int i=0; i<p.length; ++i )
			for( int j=0; j<p[i].length; ++j ){
				long ps=0;
				for( int k=0; k<p.length; ++k )
					ps=ps+a[i][k]*b[k][j];
				p[i][j]=ps;
			}
		return p;
	}

	private static long[][] pow( long[][] a, int n ){
		if( n==1 ) 
			return new long[][]{{a[0][0],a[0][1]},{a[1][0],a[1][1]}};
		long[][] b=pow(a,n/2);
		long[][] c=mul(b,b);
		if( n%2!=0 ) c=mul(c,a);
		return c;
	}//pow
	public static int fibonacci(int n){
		if(n<1) throw new IllegalArgumentException();
		if(n<=2) return 1;
		int fm1=1,fm2=1;
		int f=0;
		for(int i=3;i<=n;i++){
			f=fm1+fm2;
			fm2=fm1;
			fm1=f;
		}
		return f;
	}

}//Mat