package stringhandling;

public class StringPredicateExe {
	
	public static void main(String[] args){
		
		String str1="shunmugasundaram senthivelu";
		//String str2="SHUNMUGASUNDARAM SENTHIVELU";
		StringBuffer sb=new StringBuffer(str1);
		System.out.println("str1 : "+ str1);
		System.out.println("1. int compareTo(String anotherStr)  ");
		System.out.println("compareTo(\"shunmugasunaram senthivelu\") : " + str1.compareTo("shunmugasundaram senthivelu"));
		System.out.println("compareTo(\"aram senthivelu\") : " + str1.compareTo("aram senthivelu"));
		
		System.out.println("\n2. int compareToIgnoreCase(String anotherStr)  ");
		System.out.println("compareToIgnoreCase(\"SHUNMUGASUNDARAM SENTHIVELU\") : " + str1.compareToIgnoreCase("SHUNMUGASUNDARAM SENTHIVELU"));
	
		System.out.println("\n3. boolean contains(CharSequence s)  ");
		System.out.println("str1.contains(\"sundaram\") : " + str1.contains("sundaram"));
		
		System.out.println("\n4. boolean contentEquals(CharSequence s)  ");
		System.out.println("contentEquals(new StringBuffer(\"shunmugasundaram senthivelu\")) : " + str1.contentEquals(new StringBuffer("shunmugasundaram senthivelu")));
		
		System.out.println("\n5. boolean equals(Object o)  ");
		System.out.println("equals(new String(\"shunmugasundaram senthivelu\")) : " + str1.equals(new String("shunmugasundaram senthivelu")));
		System.out.println("equals(new StringBuffer(\"shunmugasundaram senthivelu\")) : " + str1.equals(new StringBuffer("shunmugasundaram senthivelu")));
	

		System.out.println("\n5. boolean equals(String anotherString)  ");
		System.out.println("equalsIgnoreCase(new String(\"SHUNMUGASUNDARAM SENTHIVELU\")) : " + str1.equalsIgnoreCase("SHUNMUGASUNDARAM SENTHIVELU"));
		//System.out.println("equalsIgnoreCase(sb) : " + str1.equalsIgnoreCase(sb));  // only String will work
	
		System.out.println("\n6. boolean endsWith(String suffix)  ");
		System.out.println("endsWith(\"velu\") : " + str1.endsWith("velu"));
		
		System.out.println("\n7. boolean startsWith(String prefix)  ");
		System.out.println("startsWith(\"shun\") : " + str1.startsWith("shun"));
		
		System.out.println("\n8. boolean startsWith(String prefix, int offsetFrom)  ");
		System.out.println("startsWith(\"mugam\",4) : " + str1.startsWith("muga",4));
		
		System.out.println("\n9. boolean isEmpty()  ");
		System.out.println("\"\".isEmpty() : " + "".isEmpty());
		
		System.out.println("\n10. String intern()  ");
		String str3=new String("shunmugasundaram senthivelu").intern();
		System.out.println("str1 == new String(\"shunmugasundaram senthivelu\").intern() : " + (str1 == str3) );
		
		
		
		System.out.println("\n11. int hashCode()  ");
		System.out.println("Formula = s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]");
		System.out.println("hashCode() : " + "zzzzzz".hashCode());          // if the hashcode is more than int max value , starts negative
		System.out.println("Max int value (2^31) -1 =" + (int)(Math.pow(2, 31)-1 ));
		

		System.out.println("\n12. boolean matches(String regex)  ");
		System.out.println("matches(\"^shun.*\") : " + str1.matches("^shun.*") );
		 
		
		System.out.println("\n13. boolean regionMatches(toffset, other, ooffset, len)  ");
		System.out.println("regionMatches(4, \"Arumuga\", 3, 4) : " + str1.regionMatches(4, "Arumuga", 3, 4));
	}
}
