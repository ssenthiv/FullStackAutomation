/**
* Copyright (c) 2019,  Waste Management and/or its affiliates. All rights reserved.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*/
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import difflib.DiffUtils;
import difflib.Patch;

/**
* This class consists of private methods for finding diff and printing it for 
* given two files
* @author  Shunmugasundaram Senthivelu
*/
public class FileDiffUtil {
	
	private String filePath =  System.getProperty("user.dir")+ "\\src\\main\\resources\\ExcelFiles";
	
	/**
	* Helper method to get the file content into List<String>
	* 
	* @param filename 	Name of the file along with Path.
	*/
	private List<String> fileToLines(String filename) {
	    List<String> lines = new LinkedList<String>();
	    String line = "";
	    
	    try (BufferedReader in = new BufferedReader(new FileReader(filename))){
	    	
	        while ((line = in.readLine()) != null) {
	            lines.add(line);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        //Report.fail();
	    }
	    
	    return lines;
	}
	
	/**
	* Printing the diff details line by line with position.
	* 
	* @param patch 	patch is the container for computed deltas.
	*/

	private void printDiff(Patch<String> patch){

		for ( Object deltaObj : patch.getDeltas()){
			System.out.println(deltaObj.toString().split(",").clone()[1] + deltaObj.toString().split(",").clone()[2]);
		}
		
	}
	
	/**
	* Finding the diff between two files
	* 
	* @param originalFilename 	Filename of the original file to be compared.
	* @param revisedFilename 	Filename of the revised file to be compared.
	*/
	private void findDiff(String originalFilename, String revisedFilename ){
		
		List<String> original = fileToLines(originalFilename);
        List<String> revised  = fileToLines(revisedFilename);
        
        // Compute diff and Get the Patch object. 
        // Patch is the container for computed deltas.
        Patch<String> patch = DiffUtils. diff(original, revised);

        if (patch.getDeltas().size()==0){
        	
        	System.out.println("No change in files");
        	System.out.println("Original Filename = "+originalFilename );
        	System.out.println("Revised Filename  = "+revisedFilename );
        }else{
        	System.out.println(" **** Changes identified ****\n");
        	System.out.println("Original Filename = "+originalFilename );
        	System.out.println("Revised Filename  = "+revisedFilename +"\n");
        	
        	printDiff(patch);
        }
	}
	
	public static void  main(String[] args){
		
		FileDiffUtil fd =new FileDiffUtil();
		
		String originalFilename=fd.filePath + "\\original1.sql";
		//String originalFilename=fd.filePath + "\\original2.sql";
		String revisedFilename=fd.filePath  + "\\revised.sql";
		
		fd.findDiff(originalFilename, revisedFilename);
	}

}
