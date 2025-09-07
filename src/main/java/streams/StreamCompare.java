package streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

public class StreamCompare {

public void readWriteFileIOStream(String fileFrom, String fileTo) throws IOException{
		
		InputStream in=null;
		OutputStream out=null;
		
		try {
			in=new FileInputStream(fileFrom);
			out=new FileOutputStream(fileTo);
			
			int byteData;
			while (true){
				
				byteData=in.read();
				
				if (byteData == -1)
					break;
				out.write(byteData);
					
				
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}finally
		{
			if (in !=null)
				in.close();
			if (out !=null)
				out.close();
			
		}
		
		
	}

public void readWriteBufferedIOStream(String fileFrom, String fileTo) throws IOException{
		
		InputStream in=null;
		OutputStream out=null;
		
		try {
			in=new BufferedInputStream(new FileInputStream(fileFrom));
			out=new BufferedOutputStream(new FileOutputStream(fileTo));
			
			int byteData;
			while (true){
				
				byteData=in.read();
				
				if (byteData == -1)
					break;
				out.write(byteData);
				
					
				
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}finally
		{
			if (in !=null)
				in.close();
			if (out !=null)
				out.close();
			
		}
		
		
	}

public void readWriteArrayFileIOStream(String fileFrom, String fileTo) throws IOException{
	
	InputStream in=null;
	OutputStream out=null;
	
	try {
		in=new FileInputStream(fileFrom);
		out=new FileOutputStream(fileTo);
		
		int byteData;
		int arrayLength=in.available();
		byte[] byteArray=new byte[arrayLength];
		
		
			
			byteData=in.read(byteArray);
			
			
				
			out.write(byteArray);
				
			
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}finally
	{
		if (in !=null)
			in.close();
		if (out !=null)
			out.close();
		
	}
	
	
}

public void readWriteFileIOReader(String fileFrom, String fileTo) throws IOException{
	
	Reader in=null;
	Writer out=null;
	
	try {
		in=new FileReader(fileFrom);
		out=new FileWriter(fileTo);
	
		
		int charData;
		while (true){
			
			charData=in.read();
			
			if (charData == -1)
				break;
			out.write(charData);
				
			
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}finally
	{
		if (in !=null)
			in.close();
		if (out !=null)
			out.close();
		
	}
	
	
}

public void readWriteBufferedIOReader(String fileFrom, String fileTo) throws IOException{
	
	Reader in=null;
	Writer out=null;
	
	try {
		in=new BufferedReader(new FileReader(fileFrom));
		out=new BufferedWriter(new FileWriter(fileTo));
		
		int charData;
		while (true){
			
			charData=in.read();
			
			if (charData == -1)
				break;
			out.write(charData);
			
				
			
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}finally
	{
		if (in !=null)
			in.close();
		if (out !=null)
			out.close();
		
	}
	
	
}

public void readWriteArrayFileIOReader(String fileFrom, String fileTo) throws IOException{
	
	Reader in=null;
	Writer out=null;
	InputStream inputStream=null;
	inputStream=new FileInputStream(fileFrom);
	try {
		in=new FileReader(fileFrom);
		out=new FileWriter(fileTo);
		
		int charData;
		int arrayLength=inputStream.available();
		//arrayLength=arrayLength/2;
		char[] charArray=new char[arrayLength];
	
		
		
			
		charData=in.read(charArray);
			
			
				
			out.write(charArray);
				
			
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}finally
	{
		if (in !=null)
			in.close();
		if (out !=null)
			out.close();
		
	}
	
	
}


public static void main(String[] args) throws IOException{
		
		StreamCompare sc=new StreamCompare();
		String inputFile=System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\" + sc.getClass().getSimpleName()+"Input.txt";
		String outputFile=System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\" + sc.getClass().getSimpleName()+"Output.txt";
		long startTime;
		long endTime;
		
		System.out.println("1. FileInput/Output Stream\n");
		startTime=System.currentTimeMillis();
		sc.readWriteFileIOStream(inputFile, outputFile);
		endTime=System.currentTimeMillis();
		System.out.println("\tTime taken = "+ (endTime - startTime) + " milli seconds\n");
		
		
		System.out.println("2. Buffered FileInput/Output Stream\n");
		startTime=System.currentTimeMillis();
		sc.readWriteBufferedIOStream(inputFile, outputFile);
		endTime=System.currentTimeMillis();
		System.out.println("\tTime taken = "+ (endTime - startTime) + " milli seconds\n");
		
		System.out.println("3. Custom  buffer FileInput/Output Stream\n");
		startTime=System.currentTimeMillis();
		sc.readWriteArrayFileIOStream(inputFile, outputFile);
		endTime=System.currentTimeMillis();
		System.out.println("\tTime taken = "+ (endTime - startTime) + " milli seconds\n");
		
		System.out.println("4. FileInput/Output Reader\n");
		startTime=System.currentTimeMillis();
		sc.readWriteFileIOReader(inputFile, outputFile);
		endTime=System.currentTimeMillis();
		System.out.println("\tTime taken = "+ (endTime - startTime) + " milli seconds\n");
	
		System.out.println("5. Buffered FileInput/Output Reader\n");
		startTime=System.currentTimeMillis();
		sc.readWriteBufferedIOReader(inputFile, outputFile);
		endTime=System.currentTimeMillis();
		System.out.println("\tTime taken = "+ (endTime - startTime) + " milli seconds\n");
		
		System.out.println("6. Custom  buffer FileInput/Output Reader\n");
		startTime=System.currentTimeMillis();
		sc.readWriteArrayFileIOReader(inputFile, outputFile);
		endTime=System.currentTimeMillis();
		System.out.println("\tTime taken = "+ (endTime - startTime) + " milli seconds\n");
	}
}
