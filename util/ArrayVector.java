package poo.util;

import java.util.Arrays;

public class ArrayVector<T> implements Vector<T>{
	private T[]array;
	int size;
	public ArrayVector(int capacity){
		if(capacity<=0)
			throw new IllegalArgumentException();
		array=(T[])new Object[capacity];
		size=0;
	}
	public ArrayVector(){
		this(20);
	}
	public int size(){
		return size;
	}
	public int indexOf(T elem){
		for(int i=0;i<size;i++)
			if(array[i].equals(elem))
				return i;
		return-1;
	}
	public boolean contains(T elem){
		return indexOf(elem)!=-1;
	}
	public T get(int indice){
		if(indice<0||indice>=size)
			throw new IndexOutOfBoundsException();
		return array[indice];
	}
	public T set(int indice,T elem){
		if(indice<0||indice>=size)
			throw new IndexOutOfBoundsException();
		T old=array[indice];
		array[indice]=elem;
		return old;
	}
	public void add(T elem){
		if(size==array.length)
			array=Arrays.copyOf(array, array.length*2);//espandi
		array[size]=elem;
		size++;
	}
	public void add(int indice,T elem){
		if(indice<0||indice>size)
			throw new IndexOutOfBoundsException();
		if(size==array.length)
			array=Arrays.copyOf(array, array.length*2);//espandi
		for(int i=size-1;i>=indice;i--)
			array[i+1]=array[i];
		array[indice]=elem;
		size++;
	}
	public void remove(T elem){
		int i=indexOf(elem);
		if(i==-1)
			return;
		remove(i);
	}
	public T remove(int indice){
		if(indice<0||indice>=size)
			throw new IndexOutOfBoundsException();
		T old=array[indice];
		for(int i=indice+1;i<size;i++)
			array[i-1]=array[i];
		array[size]=null;
		size--;
		if(size<array.length/2)
			array=Arrays.copyOf(array,array.length/2);
		return old;
	}
	public void clear(){
		for(int i=0;i<size;i++)
			array[i]=null;
		size=0;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public Vector<T> subVector(int da,int a){
		if(da<0||da>=size||a<0||a>size||da>a)
			throw new RuntimeException();
		Vector<T> v=new ArrayVector<T>(a-da);
		for(int j=da;j<a;j++)
			v.add(array[j]);
		return v;
	}
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Vector))
				return false;
		if(this==o)
			return true;
		Vector<T> v=(Vector<T>)o;
		if(size!=v.size())
			return false;
		for(int i=0;i<size;i++)
			if(!array[i].equals(v.get(i)))
				return false;
		return true;
	}
	@Override
	public int hashCode(){
		final int MOLT=41;
		int h=0;
		for(int i=0;i<size;i++)
			h=h*MOLT+array[i].hashCode();
		return h;
	}
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder(500);
		sb.append('[');
		for(int j=0;j<size;j++){
			sb.append(array[j]);
			if(j<size-1)
				sb.append(' ');	
		}
		sb.append(']');
		return sb.toString();
	}
	
}//ArrayVector
