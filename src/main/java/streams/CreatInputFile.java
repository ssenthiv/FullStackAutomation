package streams;

import java.io.FileWriter;
import java.io.IOException;

public class CreatInputFile {

	
	public void generateLarfile(String inputFile) throws IOException{
		
		String line1 ="This is the ";
		String line2 =" line from the file StreamCompareInput.txt \n";
		
		FileWriter out=new FileWriter(inputFile);
		String outLine=null;
		try{
		for (int count=1;count<=2000;count++){
			
			outLine=line1 + count + line2 ;
			
				
			
			out.write(outLine);
			
		}
		}finally
		{
			if (out != null)
				out.close();
		}
	}
	public static void main(String[] args) throws IOException{
		
		CreatInputFile ci= new CreatInputFile();
		
		String inputFile=System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\" + "StreamCompareInput.txt";
		
		ci.generateLarfile(inputFile);
		
		
	}
}
