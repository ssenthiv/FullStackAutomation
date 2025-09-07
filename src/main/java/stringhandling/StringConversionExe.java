package stringhandling;

import java.util.Arrays;

public class StringConversionExe {

	
	public static void main(String[] args ){
		String str="Shunmugasundarm Senthielu";
		
		System.out.println("str = "+ str);
		System.out.println("1.char[] to String");
		System.out.println("\ta.String String.copyValueOf(char[]) ");
		char[] cArray="Shunmugam".toCharArray();
		String copyStr=String.copyValueOf(cArray);
		//cArray="Senthivelu".toCharArray();				// valueOf and copyValueOf are working similar. valueOf supposed to use original char[] as the body of String
		System.out.println("\t  String.copyValueOf(cArray) = "+ copyStr);
		
		System.out.println("\n\tb.String String.copyValueOf(char[] ch, int offset, int count) ");
		System.out.println("\t  String.copyValueOf(cArray, 4, 5) = "+ String.copyValueOf(cArray, 4, 5));
		
		System.out.println("\n2.String to byte[] and byte[] to String");
		System.out.println("\tbyte[] getBytes() ");
		System.out.println("\tnew String(str.getBytes()) = " + new String(str.getBytes()));
	
		System.out.println("\n3.String(partial) to char[] ");
		System.out.println("\tvoid getChars(int, int, char[], int dstBegin) ");
		cArray=new char[9];
		str.getChars(16, 25, cArray, 0);
		
		System.out.println("\tgetChars(16, 25, cArray, 0)\n\tString.valueOf(cArray) = " + String.valueOf(cArray) );
		
		System.out.println("\n4.String to char[] and char[] to String");
		System.out.println("\tchar[] toCharArray() ");
		System.out.println("\tString valuOf(char[]), String new String(char[]) ");
		System.out.println("\tString.valueOf(str.toCharArray()) = " + String.valueOf(str.toCharArray()));
		
		System.out.println("\tnew String(str.toCharArray()) = " + new String(str.toCharArray()) );
	}
}
