package stringhandling;

public class CharacterHandling {

	
	public static void main(String args[]){
		
		String str="I am shunmuga sundaram";
		
		System.out.println("1. String to char[]");
		char[] charArray=new char[5];
		
		charArray=str.toCharArray();
		System.out.println("Original Str : " +str);
		System.out.print("Copied char[]: " + String.valueOf(charArray));
		
		
		
		System.out.println("\n\n2. String to char[] partial");
		 charArray=new char[15];
		
		str.getChars(0, 10, charArray, 5);
		System.out.println("Original Str : " +str);
		System.out.print("Copied char[]: ");
		
		for ( char c: charArray){
		System.out.print(c);
		}
		
	
		
		
		System.out.println("\n\n3. char[] to String");
		String str1=String.copyValueOf(charArray);
		System.out.println("Copied String : "+ str1);
		
		
	}
}
