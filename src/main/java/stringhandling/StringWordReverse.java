package stringhandling;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringWordReverse {
   
	public void reverseWord(String str1)
	{
	String sentenceReverse="";
	String wordReverse="";
	StringBuilder wordReverseSB=new StringBuilder();
	StringBuilder sentenceReverseSB=new StringBuilder();
	//char[] c1 = str1.toCharArray();  // to traverse using index
	
	
	
	System.out.print( "Original word : ");
	for (char c : str1.toCharArray()){
	
	System.out.print(c );
	wordReverse= c + wordReverse;
	wordReverseSB.insert(0, c);

	if ((c == ' ') ){
		sentenceReverse= sentenceReverse + wordReverse ;
		sentenceReverseSB.append(wordReverseSB);
		wordReverse="";
		wordReverseSB.setLength(0);
	}
}
	sentenceReverse= sentenceReverse + " "+ wordReverse ;
	sentenceReverseSB.append(" ").append(wordReverseSB);
	wordReverse="";
	wordReverseSB.setLength(0);
	System.out.print( "\nReverse  word :");
	System.out.println(sentenceReverse);
	System.out.println("\nReverse  word with SB :" + sentenceReverseSB);
}
	public void reverseSentenceUsingCharIndex(String str1)
	{
	
		int strLenght=str1.length();
		
		System.out.print("Rev sentence  : ");
		
		for (int i=strLenght-1; i>=0 ; i--)
		{
			System.out.print(str1.charAt(i));
		}
		
		
	}
	public void usingCharArray() throws IOException{
				
		System.out.println("Enter the 2nd string");
		
		char[] c1={' '};
        String str="";	
		InputStreamReader is=new InputStreamReader(System.in);
		char c = 0;
		int i=0;
		
		try {
			
			
			while ( (i=is.read()) !=10){
				
			
			 c=(char)i;
			 //str=str + new Character(c).toString();   // this is another way
			 str=str + c;
			 
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		c1=str.toCharArray();
		System.out.println("\nString created by reading char by char	 :" +str);
		System.out.print("Print using char[]   			 :");
		for (char ch: c1){
		System.out.print(ch);
		}
		
		System.out.println("\nEnter the char to find its index:");
		try{
			int j=is.read();	
			//int j=(int)'n';
			System.out.println("Index of '" + (char)j +"' =" +str.indexOf(j));
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			is.close();
		}
		
	}
	public String readString() throws IOException{
		System.out.println("Enter the 1st string");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		try {
			 str = br.readLine();
			
			 
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally{
			br.close();
		}
		return str;
	}

	public static void main(String[] args) throws IOException {
		

		String str1 =null;		
		System.out.println("Note: char to String then char[] \n"
				          + "      no char to char[] assignment\n"      );
		
		
		
		StringWordReverse sh=new StringWordReverse();
		str1=sh.readString();
		System.out.print( "1. Reversing a word within sentence\n");
		sh.reverseWord(str1);
		
		System.out.println("\n2. Reversing a sentence using charAt()");
		sh.reverseSentenceUsingCharIndex(str1);
		
		System.out.println("\n\n 3. Create string by reading char by char and print with char[] example");
		sh.usingCharArray();
		
		
	}
	
}
