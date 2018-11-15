package coreJava;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.bcel.verifier.statics.IntList;

public class BubbleSort {
	
	//private static List<Object> objList=Arrays.asList("daaaaaaaaaaaaadfdf", "abbbbbbbbbbbbbbbb", "jjjjjjjjjjjjjjjjjjj", "bbbbbbbbbbbbbbbb", "aaaadfzzzzzzzzzzzzz");
	//private static List<Object> objList=Arrays.asList(100,0,-100,50,30,1,0.5);

	private static List<Object> objList=new ArrayList<>();
	public static void main(String args[]) throws IOException{
	
	BubbleSort bs=new BubbleSort();
	
	
	
	
	bs.readArray();
	System.out.println("Given Order :");
	bs.printArray(objList);
	System.out.println("\nSort Order :");
	bs.sort(objList);
	bs.printArray(objList);
	
	
		
		
	}
	
	public void readArray() throws NumberFormatException, IOException{
		BufferedReader bi=new BufferedReader(new InputStreamReader(System.in));
		//DataInputStream bi=(new DataInputStream(new BufferedInputStream(System.in)));
		System.out.print("Enter the integer : ");
		int size = Integer.parseInt(bi.readLine());

		System.out.println("size "+ size);
		System.out.println("Enter "+ size +" elements");
		
		for(int i=0;i<size;i++){
			
			//intList.add(Integer.parseInt(bi.readLine()));
			//intList.add(Integer.valueOf(bi.readLine()));
			objList.add((bi.readLine()));
		}
		
	}
	
	public  void sort(List<Object> objList) throws NumberFormatException, IOException{
		
		
		for (int i=0;i<objList.size();i++){
			for (int j=i+1;j<objList.size()  ;j++){
				
				 
				int comp= typeCast(objList.get(j),objList.get(i));
				//System.out.println("i : "+i+" j : "+j+" = "+comp);
				if ( comp < 0) 
				{
					Object temp=objList.get(i);
					
					objList.set(i,objList.get(j));
					objList.set(j,temp);
					
				}
			}
				
		}
		
		
}

	
public void printArray(List<Object> objList){
		
		//System.out.println("size  : "+ intList.size());
		
		System.out.print("[");
		for(Object i:objList){
			
			System.out.print(i+" ");
		}
		System.out.print("]");
		
	}

	
	
	public int typeCast(Object obj1, Object obj2){
		
		try {
		return ((Float.valueOf(obj1.toString())).compareTo((Float.valueOf(obj2.toString()))));
				
		} catch(NumberFormatException nf){
		//nf.printStackTrace();
			
				return (((String)obj1).compareTo((String)obj2));
				
			
		}
		
	}
}
