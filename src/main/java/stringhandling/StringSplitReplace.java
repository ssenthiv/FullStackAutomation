package stringhandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitReplace {

	
	public void splitStr(String str){
		
		String[] strArray=null;
		
		strArray= str.split("\\s+");		// regexp for one or more space
		
		for (String s : strArray){
		System.out.println( s);	
		}
		
	}
	public void replaceStr(){
		
		String str="This is the first linefirst release of 65 53333v and 633..12 also 72ve.rsion";
		System.out.println("\nstr 			: "+str);
		System.out.println("Regex : ^[T|t]		: "+str.replaceAll("^[T|t]", " "));
		System.out.println("Regex : \\sfirst\\s	: "+str.replaceAll("\\sfirst\\s", "REPLACED"));
		System.out.println("Regex : \\d+..(\\.\\d)?	: "+str.replaceAll("\\d+([v]|\\.)?", ""));	// ? -> 0 or 1 pattern
		str=Calendar.getInstance().getTime().toString();
		System.out.println("str 			: "+ str);
		System.out.println("Regex : \\d{2}:\\d{2}:\\d{2}: "+str.replaceAll("\\d{2}:\\d{2}:\\d{2}", "XX:XX:XX"));
	}
	public void patternMatching(){
		String str="SightLine Version Platinum release 53.0.04";
		System.out.println("str 				: "+str);
		System.out.println("Regexp	: ^[S|s](.+)		: "+str.matches("^[S|s](.+)"));
		Pattern p=Pattern.compile("(.+)[V|v]ersion(.+)");
		Matcher m=p.matcher(str);
		
		System.out.println("Regexp	: (.+)[V|v]ersion(.+)	: "+m.matches());
		System.out.println("Regexp	: ([A-Za-z0-9[\\s][.]])+	: "+Pattern.matches("([A-Za-z0-9[\\s][.]])+",str));  // allows A-Z a-z 0-9 ' ' .
		System.out.println("Regexp	: (.+)\\d.\\d.\\d(.+)	: "+str.matches("(.+)\\d{2}.\\d{1}.\\d{2}(.+)?"));	// matches dd.d.dd
		
		System.out.println("------------------------");
		String s=" Version  995  st";
		System.out.println(s);
		System.out.println("Regexp	: 	: "+s.matches("(.*)\\d{2}(.*)"));
	}


	
	
	public static void main(String args[]){
		
		//System.out.println("Enter the line");
		String str="Split  the given  line";
		
		StringSplitReplace sr=new StringSplitReplace();
		System.out.println("1.line splitting using str.split() ");
		sr.splitStr(str);
		System.out.println("\n2. Replace string using regexp");
		sr.replaceStr();
		System.out.println("\n3. Pattern matching using reqexp");
		sr.patternMatching();
		
	}
}
