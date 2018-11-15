package stringhandling;

public class StringManipulation {

	public static void main(String[] args) {

		
		String s = "The rains have started here";
		String s1 = "The rains Have started here";

		System.out.println("String length 					: "+s.length());
		System.out.println("CharAt(5)     					: " + s.charAt(5));
		System.out.println("indexOf('s')  					: " + s.indexOf('s')); //1st occurrence of s
		
		System.out.println("indexOf('e') after 3rd position	: " +s.indexOf('e', 3)); //2nd occurrence of s
		
		System.out.println("indexOf(\"have\") 				: "+s.indexOf("have"));
		
		System.out.println("indexOf(\"hello\")				: " +s.indexOf("hello"));
		
		System.out.println("s.equals(s1)					: " +s.equals(s1));
		
		System.out.println("s.equalsIgnoreCase(s1)				: " +s.equalsIgnoreCase(s1));
		
		System.out.println("s.toUpperCase()					: " +s.toUpperCase());
		
		//sub string:
		System.out.println("s.substring(0, 9)				: " +s.substring(0, 9));
		
		//trim:
		String t = "     Hello World    ";
		
		System.out.println("trim()						: " + t.trim());
		
		//replace:
		String u = "Hello world";
		System.out.println("replace(\" \", \"-\")				: " + u.replace(" ", "-"));
		System.out.println("replace(\" \", \"\")				: " +t.replace(" ", ""));
		
		String d = "01-01-1990";
		System.out.println("replace(\"-\", \"/\")				: " +d.replace("-", "/"));
		
		
		
		
	}

}
