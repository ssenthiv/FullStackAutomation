package collection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.poi.hwpf.usermodel.DateAndTime;

public class EqualsAndHashCode {

	
	public static void main(String[] args){
		
		Student student1=new Student("Amb1");
		Student student2=new Student("Amb1");
		Student student3=new Student("Amb1");
		Student student4=null;
		System.out.println("1. Verifying two objects are equal");
		System.out.println(student1.equals(student2));
		
		Map<Student,ReportCard> studentReport=new HashMap<Student,ReportCard>();
		studentReport.put(student1,new ReportCard());
		studentReport.put(student2, new ReportCard());
				
		System.out.println(studentReport.size());
		
		System.out.println("\n2. Performance of Collection using hashCode()");
		
		Set<Student> studentSet=new HashSet<>();
		
		for (int i=0; i<10000; i++){
			studentSet.add(new Student("Adit"+i));
		}
		System.out.println("size = " + studentSet.size());

		long startT=System.nanoTime();
		long startM=System.currentTimeMillis();
		System.out.println(studentSet.contains(new Student("Adit5000")));
		
		System.out.println("Elapsed Time Nano =" + (System.nanoTime()-startT));
		System.out.println("Elapsed Time Milli=" + (System.currentTimeMillis()-startM));
		System.out.println("\n*********** Change the hashCode to give constant then check the time*********");
		
		
		System.out.println("----------");
		
		
		
		System.out.println("\n3. Rules for equals implementation");
		
		System.out.println(student1.equals(student1));
		System.out.println(student1.equals(student2)+ " --- "+student2.equals(student1));
		System.out.println(student1.equals(student2)+ " --- "+student2.equals(student3)+ " --- "+student1.equals(student3));
		System.out.println(student1.equals(null));
		//System.out.println(student4.equals(null));
		
		
	}	
}
