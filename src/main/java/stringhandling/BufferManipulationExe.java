package stringhandling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BufferManipulationExe {
	
	public static void main(String[] args){
		
		
		String str="Shunmuga sundarm Senthivelu";
		
		StringBuffer sb=new StringBuffer(str);
		System.out.println("1. int capacity() \n is 16 plus actulal length ");
		System.out.println("Actual String : " +sb);
		System.out.println("Length = " +sb.length());
		System.out.println("capacity = " +sb.capacity());
		
		System.out.println("\n2. char charAt(int index) ");
		System.out.println("charAt(0) : " + sb.charAt(0));
		System.out.println("charAt(sb.length-1) : " + sb.charAt(sb.length()-1));
		System.out.println(sb.hashCode());
		
		System.out.println("\n3. StringBuffer delete(int start,int end) ");
		System.out.println("delete(9, 17) : " + sb.delete(9, 17));
		System.out.println(sb.hashCode());
		
		System.out.println("\n4. StringBuffer insert(int offset, boolean b) ");
		System.out.println("insert(9, false) : " + sb.insert(9, false));
		System.out.println(sb.hashCode());
		
		System.out.println("\n5. StringBuffer insert(int offset, String str) ");
		System.out.println("insert(9, \"Sundaram\") : " + sb.insert(9 , "Sundaram"));
		System.out.println("delete(17 , 22) : " + sb.delete(17 , 22));
		System.out.println(sb.hashCode());
		
		System.out.println("\n6. StringBuffer insert(int index, char[] str,int offset, int len) ");
		char[] cArray="My name is Shunmugam".toCharArray();
		System.out.println("char[] = "+ String.valueOf(cArray));
		System.out.println("insert(0,cArray,3,8) : " + sb.insert(0,cArray,3,8));
		
		
		
		System.out.println("\n7. void ensureCapacity(int minimumCapacity) \n  increases into double + 2  ");
		sb.ensureCapacity(60);
		System.out.println("Lenght = "+sb.length());
		System.out.println("capacity = " +sb.capacity());
		
		System.out.println("insert(0, \"my name is \") : " + sb.insert(0 , "my name is differ"));
		System.out.println("Lenght = "+sb.length());
		System.out.println("capacity = " +sb.capacity());
		//sb.ensureCapacity(300);
		//System.out.println("capacity = " +sb.capacity());
		
		System.out.println("\n8. int indexOf(String str) ");
		System.out.println("indexOf(\"S\") : " + sb.indexOf("S"));
		
		System.out.println("\n9. int indexOf(String str, int fromIndex) ");
		System.out.println("indexOf(\"S\",26) : " + sb.indexOf("S",26));
		
		System.out.println("\n10. int lastIndexOf(String str) ");
		System.out.println("lastIndexOf(\"S\") : " + sb.lastIndexOf("S"));
		
		
		System.out.println("\n11. int lastIndexOf(String str, int tillIndex) ");
		System.out.println("lastIndexOf(\"S\", 26) : " + sb.lastIndexOf("S",26));
		
		System.out.println("\n12. StringBuffer replace(int start, int end, String str) ");
		System.out.println("replace(0, 24, \" \") : " + sb.replace(0, 24, " "));
		
		
		System.out.println("\n13. StringBuffer reverse() ");
		System.out.println("reverse() : " + sb.reverse());
		
		System.out.println("\n14. void setCharAt(int index, char ch)");
		sb.setCharAt(10,' ');
		//sb.insert(10, ' ');
		System.out.println("sb.setCharAt(10,\' \')" + sb);
		System.out.println("reverse() : " + sb.reverse());
		
		
		System.out.println("\n15. void setLength(int newLength)");
		sb.setLength(19);
		sb.ensureCapacity(18);
		System.out.println("setLength(19) : " + sb);
		System.out.println("ensureCapacity(18); = " +sb.capacity());
		
		
		System.out.println("\n16. String substring(int fromIndex)");
		System.out.println("substring(11) : " + sb.substring(11));
		
		System.out.println("\n17. String substring(int start, int end)");
		System.out.println("substring(6,11) : " + sb.substring(6, 11));
		
		System.out.println("\n18. void trimToSize()");
		System.out.println("ensureCapacity(88); = " +sb.capacity());
		sb.trimToSize();
		System.out.println("sb.trimToSize() : " + sb);
		System.out.println("capacity = " +sb.capacity());
		
		System.out.println("------------------------------------");
		//sb=sb.replace(0, sb.length(), "");
		sb=sb.delete(0, sb.length());
		sb=sb.append("SightLine Version Platinum release 53.0.04");
		
	}

}
