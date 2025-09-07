package streams;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CountBytesBufferedInpStrm {
	
  public static void main(String[] args) 
     throws IOException
  {
	    InputStream in =System.in;
	    OutputStream out = System.out; 
	    InputStream bis=new BufferedInputStream(in);
	    OutputStream bos =new BufferedOutputStream(out);
	   
	    
	     
	     readByByte(bis, bos);
	     readUsingBufferSize(bis, bos);
	   
  }
  static void readByByte(InputStream bis, OutputStream bos) throws IOException{
	  
	    int total = 0;
	    int ch=0;
	    
	    System.out.println("1. write using single byte");
	    System.out.println("Enter a line");
	    
	    // 10='\n'
	    
	    while ((ch=bis.read())!= 10){
	    
	     //System.out.println((char)ch);
	    
	    bos.write(ch);
	    bos.flush();
	    	total++;}
	    System.out.println("\n"+total + " bytes");
  }
  
  static void readUsingBufferSize(InputStream bis, OutputStream bos) throws IOException{
	  
	
	  byte[] b=new byte[33];
	  int rc=-1;
	  System.out.println("\n \n \n Enter the line");
	  
	  rc=bis.read(b,0,33);
	  for (byte b1 : b){
		  System.out.print((char)b1);
	  }
	  System.out.println("\n rc ="+ (char)rc);
	  System.out.println("Byte length ="+ b.length);
	  System.out.println("write using byte[]");
	  bos.write(b,0,10);
	  bos.flush();
	  
  }
  
}

