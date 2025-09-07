package streams;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class OutputStreamWriterExample {

	
	public static void main(String[] args) {
		
		try
		{
		//OutputStreamWriter outStream=new OutputStreamWriter(System.out);
		//OutputStreamWriter out=new OutputStreamWriter(System.out);
			 
		OutputStreamWriter out=new OutputStreamWriter(System.out, Charset.forName("UTF-16"));

		 //Writer out=outStream;
		 
		
		 out.write( (char)45678 );
		 out.flush();

		 
		 out.write("\nCharacter Coding of the output Stream is " + out.getEncoding());
		 out.flush();
		 
		 out.close();

		 }catch(Exception e) {System.err.println(e);}
			}
	}


