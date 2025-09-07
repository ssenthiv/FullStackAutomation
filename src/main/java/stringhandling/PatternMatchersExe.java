package stringhandling;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchersExe {

public void replaceStr(){
		
		String str="This is the first linefirst release of 65 53333v and 633..12 also 72ve.rsion";
		System.out.println("\nstr 			: "+str);
		System.out.println("\nRegex : ^[T|t]		: "+str.replaceAll("^[T|t]", "#####"));
		System.out.println("Regex : \\sfirst\\s	: "+str.replaceAll("\\sfirst\\s", "#####"));
		System.out.println("Regex : \\d+([v]|\\.)?	: "+str.replaceAll("\\d+([v]|\\.)?", "#"));	// ? -> 0 or 1 pattern
		
		str=Calendar.getInstance().getTime().toString();
		System.out.println("\nstr 			: "+ str);
		System.out.println("Regex : \\d{2}:\\d{2}:\\d{2}: "+str.replaceAll("\\d{2}:\\d{2}:\\d{2}", "XX:XX:XX"));
	}

public void patternMatching(){
	String str="SightLine Version Platinum release 53.0.04";
	StringBuilder sb=new StringBuilder(str);
	System.out.println("\nstr		\t\t\t\t: "+str);
	System.out.println("StringBuilder	sb	\t\t\t: "+sb);
	System.out.println("str.matches\t( ^[S|s](.+)   		    )\t: "+str.matches("^[S|s](.+)"));
	System.out.println("Pattern.matches\t( ([A-Za-z0-9[\\s][.]])+, str)\t: "+Pattern.matches("([A-Za-z0-9[\\s][.]])+",str));  // allows A-Z a-z 0-9 ' ' .  ie. ([A-Za-z0-9\\s.])+
	
	Pattern p=Pattern.compile("(.+)[V|v]ersion(.+)");
	Matcher m=p.matcher(str);
	System.out.println("\nPattern p	:(.+)[V|v]ersion(.+)		: ");
	System.out.println("\n		  p.matcher(str).matches 	: "+m.matches());
	m=p.matcher(sb);
	System.out.println("		  p.matcher(sb).matches	 	: "+m.matches());
	
	p=Pattern.compile("(.+)\\d{2}.\\d{1}.\\d{2}");
	m=p.matcher(sb);
	System.out.println("\nPattern p	:(.+)\\d{2}.\\d{1}.\\d{2}		: ");
	System.out.println("\n		  p.matcher(sb).matches		: "+m.matches());	// matches dd.d.dd
	
	
	p=Pattern.compile("(.*)\\d{2}(.*)");
	m=p.matcher(" Version  995  st");
	System.out.println("\nPattern p	:(.*)\\d{2}(.*)			: ");
	System.out.println("\np.matcher(\" Version  995  st\").matches 		: "+m.matches());
	
	p=Pattern.compile("\\d");
	m=p.matcher(sb);
	System.out.println("\nPattern p	:\\d				: ");
	System.out.println("\n		p.matcher(sb).matches 		: "+m.matches());
	
	System.out.println("\n\t\tm.replaceFirst(\"Y\") \t	: "+ m.replaceFirst("Y"));
	//m.reset();
	System.out.println("\n		sb.replace(m.start(),m.end,\"x\") 		: \n");
	while (m.find()){
		System.out.println("\t\t\t\t\t\t"+sb.replace(m.start(),m.end(),"X"));
	}
	
	
}
public static void main(String args[]){
		
		PatternMatchersExe pm=new PatternMatchersExe();
		System.out.println("1. replaceAll with regex");
		pm.replaceStr();
		
		System.out.println("\n2. Pattern Matching");
		pm.patternMatching();
	}

}
