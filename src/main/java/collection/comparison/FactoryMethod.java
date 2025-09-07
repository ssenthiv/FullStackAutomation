package collection.comparison;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import org.openxmlformats.schemas.officeDocument.x2006.customXml.impl.DatastoreItemDocumentImpl;

interface DataStructureFactory{
	
	public void createObject(String element);
	default public void addingBulkElements(int start){
		System.out.println("Defatul method");
	}
	
	default public void printCollection(){
		System.out.println("Defatul method");
	}
	default public void searchElement(){
		System.out.println("Defatul method");
	}
	default public void removeElement(){
		System.out.println("Defatul method");
	}
	default public void addNewElement(){
		System.out.println("Defatul method");
	}
	default public void addExistingElement(){
		System.out.println("Defatul method");
	}
	
	
	default public void removeElementsQueue(){
		System.out.println("Defatul method");
	}
	
}

public class FactoryMethod {
	
	public static void main(String[] args){
		
		//DataStructureFactory ds=new CollectionFactory();
		DataStructureFactory ds=new MapFactory();
		//String name;
		//name="java.util.HashSet";
		//name="java.util.LinkedHashSet";
		//name="java.util.TreeSet";
		//name="java.util.ArrayList";
		//name="java.util.LinkedList";
		//name="java.util.Vector";
		//name="java.util.PriorityQueue";
		//name="java.util.ArrayDeque";
		
		// Map
		//name="java.util.HashMap";
		//name="java.util.TreeMap";
		
		List<String> collectionClassArray;
		collectionClassArray= Arrays.asList("java.util.HashSet","java.util.LinkedHashSet",
				"java.util.TreeSet","java.util.ArrayList","java.util.LinkedList","java.util.Vector",
				"java.util.PriorityQueue","java.util.ArrayDeque");
 		
		collectionClassArray= Arrays.asList("java.util.HashMap","java.util.TreeMap");
		
		for (String name : collectionClassArray ){
			
		
		ds.createObject(name);
		ds.addingBulkElements(0);
		//ds.addingBulkElements(11);
		ds.printCollection();
		ds.searchElement();
		ds.removeElement();
		ds.addNewElement();
		ds.addExistingElement();
		
		//ds.printCollection();
		//fd.removeElementsQueue();
		}
		
	}
}
