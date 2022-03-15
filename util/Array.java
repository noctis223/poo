package poo.util;

public final class Array{

	private Array(){}

	public static int ricercaLineare( int []v, int x ){
		for( int i=0; i<v.length; i++ )
			if( v[i]==x ) return i;
		return -1;
	}//ricercaLineare

	public static int ricercaLineareOttimizzata( int []v, int x ){
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<v.length; i++ ){
			if( v[i]==x ) return i;
			if( v[i]>x ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

	public static int ricercaLineare( double []v, double x ){
		for( int i=0; i<v.length; i++ )
			if( v[i]==x ) return i;
		return -1;
	}//ricercaLineare

	public static int ricercaLineareOttimizzata( double []v, double x ){
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<v.length; i++ ){
			if( v[i]==x ) return i;
			if( v[i]>x ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

	public static <T extends Comparable<? super T>> int ricercaLineare( T []v, T x ){
		for( int i=0; i<v.length; i++ )
			if( v[i].compareTo(x)==0 ) return i;
		return -1;
	}//ricercaLineare

	public static <T extends Comparable<? super T>> int ricercaLineareOttimizzata( T []v, T x ){
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<v.length; i++ ){
			if( v[i].compareTo(x)==0 ) return i;
			if( v[i].compareTo(x)>0 ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

    public static void bubbleSort( int []v ){
		int ius=0; //assegnazione fittizia
		for( int j=v.length-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i]>v[i+1] ){//scambia
			       int tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

    public static void bubbleSort( double []v ){
		int ius=0; //assegnazione fittizia
		for( int j=v.length-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i]>v[i+1] ){//scambia
			       double tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

	public static <T extends Comparable<? super T>> void bubbleSort( T []v ){
		int ius=0; //assegnazione fittizia
		for( int j=v.length-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i].compareTo( v[i+1] )>0 ){//scambia
			       T tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

	public static void selectionSort( int []v ){
		for( int j=v.length-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i]>v[indMax] ) indMax=i;
			//scambia v[indMax] con v[j]
			int park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void selectionSort( double []v ){
		for( int j=v.length-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i]>v[indMax] ) indMax=i;
			//scambia v[indMax] con v[j]
			double park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static <T extends Comparable<? super T>> void selectionSort( T []v ){
		for( int j=v.length-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i].compareTo(v[indMax])>0 ) indMax=i;
			//scambia v[indMax] con v[j]
			T park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void insertionSort( int []v ){
		for( int i=1; i<v.length; i++ ){
			int x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1]>x ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static void insertionSort( double []v ){
		for( int i=1; i<v.length; i++ ){
			double x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1]>x ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static <T extends Comparable<? super T>> void insertionSort( T []v ){
		for( int i=1; i<v.length; i++ ){
			T x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1].compareTo(x)>0 ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static int ricercaBinaria( int []v, int x ){
		//ipotesi: v è ordinato per valori crescenti
	    int inf=0, sup=v.length-1;
	    while( inf<=sup ){
			int med=(inf+sup)/2;
			if( v[med]==x ) return med;
			if( v[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static int ricercaBinaria( double []v, double x ){
		//ipotesi: v è ordinato per valori crescenti
	    int inf=0, sup=v.length-1;
	    while( inf<=sup ){
			int med=(inf+sup)/2;
			if( v[med]==x ) return med;
			if( v[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static <T extends Comparable<? super T>> int ricercaBinaria( T []v, T x ){
		//ipotesi: v è ordinato per valori crescenti
		int inf=0, sup=v.length-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			int esito=v[med].compareTo(x);
			if( esito==0 ) return med;
			if( esito>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

    //nei metodi che seguono, l'array v è supposto riempito da 0 a size-1

	public static <T extends Comparable<? super T>> int ricercaLineare( T []v, T x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int i=0; i<size; i++ )
			if( v[i].compareTo(x)==0 ) return i;
		return -1;
	}//ricercaLineare

	public static <T extends Comparable<? super T>> int ricercaLineareOttimizzata( T []v, T x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<size; i++ ){
			if( v[i].compareTo(x)==0 ) return i;
			if( v[i].compareTo(x)>0 ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

    public static void bubbleSort( int []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		int limite=0; //assegnazione fittizia
		for( int j=size-1; j>0; j=limite ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i]>v[i+1] ){//scambia
			       int tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; limite=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

  	public static void bubbleSort( double []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		int limite=0; //assegnazione fittizia
		for( int j=size-1; j>0; j=limite ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i]>v[i+1] ){//scambia
			       double tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; limite=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

	public static <T extends Comparable<? super T>> void bubbleSort( T []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		int ius=0; //assegnazione fittizia
		for( int j=size-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v[i].compareTo( v[i+1] )>0 ){//scambia
			       T tmp=v[i]; v[i]=v[i+1];
			       v[i+1]=tmp; scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort

	public static void selectionSort( int []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int j=size-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i]>v[indMax] ) indMax=i;
			//scambia v[indMax] con v[j]
			int park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void selectionSort( double []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int j=size-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v[i]>v[indMax] ) indMax=i;
			//scambia v[indMax] con v[j]
			double park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static <T extends Comparable<? super T>> void selectionSort( T []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int j=size-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			    if( v[i].compareTo(v[indMax])>0 ) indMax=i;
			//scambia v[indMax] con v[j]
			T park=v[j]; v[j]=v[indMax];
			v[indMax]=park;
		}
	}//selectionSort

	public static void insertionSort( int []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int i=1; i<size; i++ ){
			int x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1]>x ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static void insertionSort( double []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int i=1; i<size; i++ ){
			double x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1]>x ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static <T extends Comparable<? super T>> void insertionSort( T []v, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		for( int i=1; i<v.length; i++ ){
			T x=v[i]; //togli v[i] dal vettore
			int j=i;
			while( j>0 && v[j-1].compareTo(x)>0 ){
				v[j]=v[j-1];
				j--;
			}
			v[j]=x;
		}
	}//insertionSort

	public static <T extends Comparable<? super T>> T max( T[]v ){
		T max=null;
		for( T x: v){
			if( max==null || x.compareTo(max)>0 )
				max=x;
		}
		return max;
	}//max

	public static int ricercaBinaria( int []v, int x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		//ipotesi: v è ordinato per valori crescenti
	    int inf=0, sup=size-1;
	    while( inf<=sup ){
			int med=(inf+sup)/2;
			if( v[med]==x ) return med;
			if( v[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static int ricercaBinaria( double []v, double x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		//ipotesi: v è ordinato per valori crescenti
	    int inf=0, sup=size-1;
	    while( inf<=sup ){
			int med=(inf+sup)/2;
			if( v[med]==x ) return med;
			if( v[med]>x ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static <T extends Comparable<? super T>> int ricercaBinaria( T []v, T x, int size ){
		if( size<0 || size>v.length ) throw new IllegalArgumentException();
		//ipotesi: v è ordinato per valori crescenti
		int inf=0, sup=size-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			int esito=v[med].compareTo(x);
			if( esito==0 ) return med;
			if( esito>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	//metodi su vector

	public static <T extends Comparable<? super T>> int ricercaLineare( Vector<T> v, T x ){
		for( int i=0; i<v.size(); i++ )
			if( v.get(i).compareTo(x)==0 ) return i;
		return -1;
	}//ricercaLineare

	public static <T extends Comparable<? super T>> int ricercaLineareOttimizzata( Vector<T> v, T x ){
		//v e' supposto ordinato per valori crescenti
		for( int i=0; i<v.size(); i++ ){
			if( v.get(i).compareTo(x)==0 ) return i;
			if( v.get(i).compareTo(x)>0 ) return -1;
		}
		return -1;
	}//ricercaLineareOttimizzata

	public static <T extends Comparable<? super T>> int ricercaBinaria( Vector<T> v, T x ){
		//ipotesi: v è ordinato per valori crescenti
		int inf=0, sup=v.size()-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			int esito=v.get(med).compareTo(x);
			if( esito==0 ) return med;
			if( esito>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static <T extends Comparable<? super T>> int ricercaBinaria( Vector<T> v, T x, int size ){
		if( size<0 || size>v.size() ) throw new IllegalArgumentException();
		//ipotesi: v è ordinato per valori crescenti
		int inf=0, sup=size-1;
		while( inf<=sup ){
			int med=(inf+sup)/2;
			int esito=v.get(med).compareTo(x);
			if( esito==0 ) return med;
			if( esito>0 ) sup=med-1;
			else inf=med+1;
		}
		return -1;
	}//ricercaBinaria

	public static <T extends Comparable<? super T>> void selectionSort( Vector<T> v ){
		for( int j=v.size()-1; j>0; j-- ){
			int indMax=0;
			for( int i=1; i<=j; i++ )
			     if( v.get(i).compareTo(v.get(indMax))>0 ) indMax=i;
			//scambia v<indMax> con v<j>
			T park=v.get(j); v.set(j,v.get(indMax));
			v.set(indMax,park);
		}
	}//selectionSort

	public static <T extends Comparable<? super T>> void insertionSort( Vector<T> v ){
		for( int i=1; i<v.size(); i++ ){
			T x=v.get(i); //togli v<i> dal vettore
			int j=i;
			while( j>0 && v.get(j-1).compareTo(x)>0 ){
				v.set(j,v.get(j-1));
				j--;
			}
			v.set(j,x);
		}
	}//insertionSort

	public static <T extends Comparable<? super T>> void bubbleSort( Vector<T> v ){
		int ius=0; //assegnazione fittizia
		for( int j=v.size()-1; j>0; j=ius ){
			int scambi=0;
			for( int i=0; i<j; i++ )
			    if( v.get(i).compareTo( v.get(i+1) )>0 ){//scambia
			       T tmp=v.get(i); v.set(i,v.get(i+1));
			       v.set(i+1,tmp); scambi++; ius=i;
				}
				if( scambi==0 ) break;
			}
	}//bubbleSort
	
	/*public static <T extends Comparable<? super T>> void HeapSort(T[]v){
		Heap<T> h=new Heap<T>(v.length);
		//caricamento heap
		for(T x: v)
			h.add(x);
		//estrazione dell'heap
		for( int i=0; i<v.length; i++ )
			v[i]=h.remove();
	}//HeapSort
	*/
}//Util