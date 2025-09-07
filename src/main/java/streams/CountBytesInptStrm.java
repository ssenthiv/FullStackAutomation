package streams;

import java.io.*;

public class CountBytesInptStrm {
	
  public static void main(String[] args) 
     throws IOException
  {
	    InputStream in =null;
	    OutputStream out = null;
	   
	    
	      in = System.in;
	      out= System.out; 
	   
	   
	      readInputStrm(in, out);
	      
  }
  static void readInputStrm(InputStream in, OutputStream out) throws IOException{
	  
	    int total = 0;
	    int ch=0;
	    System.out.println("Enter the line");
	    while ((ch=in.read())!= 10){
	    
	     //System.out.print((char)ch);
	    out.write(ch);
	    out.flush();
	    	total++;}
	    System.out.println("\n"+total + " bytes");
  }
  
  
	  
	  
  
}

