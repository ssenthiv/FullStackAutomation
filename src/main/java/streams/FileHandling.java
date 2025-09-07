package streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {

	
	
	public static void main(String args[]){
		
		FileHandling fh=new FileHandling();
		
		String inputFile=System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\" + fh.getClass().getSimpleName()+"Input.txt";
		
		System.out.println(inputFile);
		String line=null;
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File(inputFile)));
			line=br.readLine();
			while (line !=null){
			if (line.matches(".+line(.)?")){
			//System.out.println(line);
			String[] col=line.split("i");
			System.out.println(col[1]);
			}
			line=br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	
	}
}
