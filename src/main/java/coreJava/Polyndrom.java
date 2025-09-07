package coreJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Polyndrom {

	 int cGlobal=0;
	
	public  int getRemainder(int i){
	
		int r;
		r=i % 10;
		//System.out.println(r);
		return r;
	}
	
	
	public  int getQuotient(int i){
		
		int q;
		cGlobal=1; 
		q=i;
		do{
		q=q / 10;
		cGlobal=cGlobal*10;
		}
		while(q>10);
		cGlobal=cGlobal*q;
		//System.out.println(q);
		return q;
	}
	
	public  void isPolyndrom(int inputNum){
		
		int r;
		int q;
		int i=inputNum;
		//c=1;
		while (i>=10){
		r=getRemainder(i);
		q=getQuotient(i);
		if (r!=q) {
			//System.out.println(r + " is not equal to" +q);
			System.out.println(inputNum+ " is not a polyndrom");
			
			return;
		}else{
			i=i-cGlobal;
			i=i / 10;
		}
		}
		System.out.println(inputNum+ " is polyndrom");
	}
	
	
public  void isPolyndromRecursive(int inputNum){
		
		int r;
		int q;
		int i=inputNum;
		int c=1;
		
		r=i % 10;	
			
		
			q=i;
			do{
			q=q / 10;
			c=c*10;
			}
			while(q>10);
			
			//System.out.println(q);
			
		
		if (r!=q) {
			//System.out.println(r + " is not equal to" +q);
			System.out.println("It is not a polyndrom");
			
			return;
		}
			c=c*q;
			i=i-c;
			i=i / 10;
		if (i>=10)
			isPolyndromRecursive(i);
		else
		{
		System.out.println("It is polyndrom");
		return;
		}
	}
	
public  void isPolyndromUsingCollection(int inputNum){
	
	int i=inputNum;
	int r;
	List<Integer> listDigit=new ArrayList<Integer>();
	while (i>0){
	r=i % 10;
	listDigit.add(r);
	i=i / 10;
	}
	
	for (int j=0; j< (listDigit.size()/2); j++){
		
		if (listDigit.get((listDigit.size()-1)-j) != listDigit.get(j)){
		//System.out.println(listDigit.get((listDigit.size()-1)-j)+ " -> "+listDigit.get(j) );
		System.out.println(inputNum + " is not a polyndrom");
		return;
		}
	}
	System.out.println(inputNum + " is  a polyndrom");
}

public  void isPolyndromUsingLinkedList(int inputNum){
	
	int i=inputNum;
	int r;
	LinkedList<Integer> listDigit=new LinkedList<>();
	while (i>0){
	r=i % 10;
	listDigit.addLast(r);
	i=i / 10;
	}
	Iterator<Integer> linkedItr=listDigit.iterator();
	while (listDigit.size()>1) {
		
		if (listDigit.pollFirst() != listDigit.pollLast()){            // peek(), poll() from Queue interface
		System.out.println(inputNum + " is not a polyndrom");
		return;
		}
		
	}
	System.out.println(inputNum + " is  a polyndrom");	
	
}
	public static void  main(String[] args){
		
		Polyndrom po=new Polyndrom();
		
		po.isPolyndrom(12343211);
		po.isPolyndromRecursive(12343211);
		po.isPolyndromUsingCollection(123403211);
		po.isPolyndromUsingLinkedList(123403211);
		
		po.isPolyndrom(8751578);
		po.isPolyndromRecursive(8751578);
		po.isPolyndromUsingCollection(8751578);
		po.isPolyndromUsingLinkedList(8751578);
		po.isPolyndrom(0000);
		po.isPolyndromRecursive(0000);
		po.isPolyndromUsingCollection(0000);
		po.isPolyndromUsingLinkedList(0000);
		
	}
}
