package util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\shunmugam\\cigniti\\Workspace\\Workspace\\FullStackAutomation\\src\\main\\resources\\ExcelFiles\\SpendOverview_csv.csv";
    public List<HashMap<String,String>> actualCSV=new ArrayList<HashMap<String,String>>();
    public static void main(String[] args) throws IOException {
        try (
        		//System.setProperty(key, value)
        		//Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH),StandardCharsets.UTF_16LE);
            //CSVParser csvParser = new CSVParser (reader, CSVFormat.DEFAULT);
        		 CSVParser csvParser =	CSVParser.parse(reader, CSVFormat.MYSQL.withHeader())
        ) {
        	
        	
        	List<String>  columnList=csvParser.getHeaderNames();
        	
        	Map<String,String> recordMap=null;
            for (CSVRecord csvRecord : csvParser) {
            	
            	recordMap=new HashMap<String, String>();
            	int index=0;
            	for (String column : columnList){
            		
            		recordMap.put(column, csvRecord.get(column));
            		System.out.println(column +" = " + csvRecord.get(column));
            		
            	}
            	
            //System.exit(1);
              
            }
            
            System.out.println("Total records :"+ csvParser.getRecords().size());
        	System.out.println("Total columns :"+ csvParser.getHeaderNames().size());
        }
    }
}