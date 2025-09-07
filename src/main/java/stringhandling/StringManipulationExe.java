package stringhandling;

import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulationExe {
	
	public static void main(String[] args){
		
		
		String str="Shunmuga sundarm Senthivelu";
		
		//StringBuilder sb=new StringBuilder(str);
		String sb = str;
		System.out.println("1. int length()  ");
		System.out.println("Actual String : " +sb);
		System.out.println("Length = " +sb.length());
		
		
		System.out.println("\n2. char charAt(int index) ");
		System.out.println("charAt(0) : " + sb.charAt(0));
		System.out.println("charAt(sb.length-1) : " + sb.charAt(sb.length()-1));
		System.out.println(sb.hashCode());
		
		
		
		System.out.println("\n9. int indexOf(String str, int fromIndex) ");
		System.out.println("indexOf(\"S\",16) : " + sb.indexOf("S",16));
		
		System.out.println("\n10. int lastIndexOf(String str) ");
		System.out.println("lastIndexOf(\"S\") : " + sb.lastIndexOf("S"));
		
		
		System.out.println("\n11. int lastIndexOf(String str, int tillIndex) ");
		System.out.println("lastIndexOf(\"S\", 16) : " + sb.lastIndexOf("S",16));
		
		System.out.println("\n12.replace syntax is different from StingBuilder  ");
		System.out.println("sb.replace('s', 'S') : " + sb.replace('s', 'S'));
		System.out.println("sb.replace(\"Shunmuga\", \"Mohana\") : " + sb.replace("Shunmuga", "Mohana"));
		System.out.println("sb.replaceAll(\"\\s\", \"X\") : " + sb.replaceAll("\\s", "X"));
		System.out.println("sb.replaceFirst(\"\\s\", \"x\") : " + sb.replaceFirst("\\s", "x"));
		
			
		
		System.out.println("\n16. String substring(int fromIndex)");
		System.out.println("substring(11) : " + sb.substring(11));
		
		System.out.println("\n17. String substring(int start, int end)");
		System.out.println("substring(6,11) : " + sb.substring(6, 11));
		
		
		
		System.out.println("--------------Additional----------------------");
		System.out.println("\n1. String concat(String)");
		System.out.println("concat(\"Perumal\")) : " + sb.concat(" Perumal"));

		System.out.println("\n2. String String.format(String, Object... args)");
		System.out.println("String.format(\"%s = %d\",\"Tamil\",88) \t\t: " + String.format("%s = %d","Tamil",88));
		System.out.println("String.format(\"%10s = %5d\",\"English\",88) \t: " + String.format("%10s = %5d","English",88));
		System.out.println("String.format(\"%-10s = %-5d\",\"Maths\",99) \t: " + String.format("%-10s = %-5d","Maths",99));
		System.out.println("String.format(\"%.3s = %(5d\",\"Science\",-95) \t: " + String.format("%.3s = %(5d","Science",-95));
		System.out.println("String.format(\"%-10.3s = %05d\",\"History\",-5) \t: " + String.format("%-10.3s = %05d","History",-5));
		System.out.println("String.format(\"%-10s = %+5d\",\"Biology\",5) \t: " + String.format("%-10s = %+5d","Biology",5));
		System.out.println("String.format(\"%-10s = % 5d\",\"Zoology\",5) \t: " + String.format("%-10s = % 5d","Zoology",5));
		System.out.println("String.format(\"%-10s = % 5d\",\"Zoology\",-5) \t: " + String.format("%-10s = % 5d","Zoology",-5));
		System.out.println("String.format(\"%-10s = %,d\",\"Chemistry\",10000) \t: " + String.format("%-10s = %,d","Chemistry",10000));
		System.out.println("String.format(\"%tA\",Calendar.getInstance().getTime()) \t: " + String.format("%tA",Calendar.getInstance().getTime()));

		
		System.out.println("\n3. String[] split(String regex)");
		System.out.println("split(\" \") : " + Arrays.asList(sb.split(" ")));
		
		System.out.println("\n4. String toLowerCase()");
		System.out.println("toLowerCase() : " +sb.toLowerCase());
		
		System.out.println("\n5. String toUpperCase()");
		System.out.println("toUpperCase() : " +sb.toUpperCase());
		
		System.out.println("\n6. String trim()");
		sb="    shunmugam       ";
		System.out.println("String : "+ sb);
		System.out.println("trim() : " +sb.trim());
		
		System.out.println("------------------------------------");
		sb="SightLine Version Platinum release 53.0.04";
		System.out.println("String  \t : " + sb);
		System.out.println("^[S](.*) \t : " +Pattern.matches("^[S](.*)", sb));
		System.out.println("(.*)(\\d{2}\\.\\d{1}\\.\\d{2})$ \t : " +Pattern.matches("(.*)(\\d{2}\\.\\d{1}\\.\\d{2})$", sb));
		
		Matcher m=Pattern.compile("\\d").matcher(sb);
		
		
		
	
		m=Pattern.compile("X").matcher(sb);
		System.out.println(m.replaceAll("Y"));
		System.out.println(sb);
	}

}
