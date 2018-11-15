package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		
		for (int i=0; i<100; i++){
			
			studentSet.add(new Student("Adit"+i));
		}
		System.out.println(studentSet.size());
		
		long startT=System.nanoTime();
		System.out.println(studentSet.contains(new Student("Adit50")));
		
		System.out.println("Elapsed Time =" + (System.nanoTime()-startT));
		
		System.out.println("\n3. Rules for equals implementation");
		
		System.out.println(student1.equals(student1));
		System.out.println(student1.equals(student2)+ " --- "+student2.equals(student1));
		System.out.println(student1.equals(student2)+ " --- "+student2.equals(student3)+ " --- "+student1.equals(student3));
		System.out.println(student1.equals(null));
		System.out.println(student4.equals(null));
	}
}
