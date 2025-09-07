package streams;

import java.io.*;

public class CountBytesFileInpStrm {
	
  public static void main(String[] args) 
     throws IOException
  {
	    InputStream in =null;
	    OutputStream out = null;
	      
	      in = new FileInputStream(new File(args[0]));
	      out = new FileOutputStream(new File(args[1]));
	   
	    
	    readFileStream(in, out);
	    readBufferedSteam(in, out);
  }
  static void readFileStream(InputStream in, OutputStream out) throws IOException{
	  
	    int total = 0;
	    int ch=0;
	    System.out.println("1. Read / write file using FileInputStream");
	    while ((ch=in.read())!= -1){
	    
	     System.out.print((char)ch);
	    out.write(ch);
	    	total++;}
	    System.out.println("\n"+total + " bytes");
  }
  
  static void readBufferedSteam(InputStream in, OutputStream out) throws IOException{
	  
	  String str="";
	  byte[] b=new byte[33];
	  int rc=-1;
	  
	  BufferedInputStream bis=new BufferedInputStream(in);
	  System.out.println("2. Read file using BufferedInputStream (FileInputStream)");
	  rc=bis.read(b,0,33);
	  for (byte b1 : b){
		  System.out.print((char)b1);
	  }
	  System.out.println("rc ="+ rc);
	  System.out.println("Byte length ="+ b.length);
  }
  
}

