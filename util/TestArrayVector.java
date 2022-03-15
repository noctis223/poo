package poo.util;

import java.util.*;

public class TestArrayVector {
	public static void main(String[]args){
		Vector<Integer> v=new ArrayVector<Integer>();
		for( int i=100; i>0; --i )
			v.add( new Integer(i) );
		System.out.println(v);
		v.clear();
		for( int i=10; i>0; --i )
			v.add(0,new Integer(i));
		System.out.println(v);
		Vector<Integer> sv=v.subVector(4,10);
		System.out.println(sv);
		
		Vector<String> w=new ArrayVector<String>();
		Scanner sc=new Scanner(System.in);
		for(; ;){
			System.out.print("String(solo INVIO per terminare):");
			String s=sc.nextLine();
			if(s.length()==0)
				break;
			int indice=0;
			boolean flag=false;
			while(indice<w.size()&&flag==false){
				String str=(String)w.get(indice);
				if(str.compareTo(s)>=0)
					flag=true;
				else
					indice++;
			}//while
			w.add(indice,s);
		}//for
		System.out.println(w);
		
		
	}//main
}//TestArrayVector
