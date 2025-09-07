package util;

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public List<HashMap<String,String>> readExcel(String filePath,String fileName,String sheetName) throws IOException{

		int totalAmount = 0;

		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		Workbook wb = null;

		// Find the file extension by splitting file name in substring and
		// getting only extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			wb = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of HSSFWorkbook class

			wb = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		Sheet st = wb.getSheet(sheetName);

		// Find number of rows in excel file

		int rowCount = st.getLastRowNum() - st.getFirstRowNum();
		List<HashMap<String, String>> tableList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> rowMap = null;
		List<String> colList = new ArrayList<String>();
		// Create a loop over all the rows of excel file to read it
		for (int i = 6; i < rowCount; i++) {
			rowMap = new HashMap<String, String>();
			Row row = st.getRow(i);

			// Create a loop to print cell values in a row

			Iterator<Cell> cellIterator = row.iterator();
			int colIndx = 0;
			while (cellIterator.hasNext()) {

				Cell currentCell = cellIterator.next();
				// getCellTypeEnum shown as deprecated for version 3.15
				// getCellTypeEnum ill be renamed to getCellType starting from
				// version 4.0

				if (i == 6) {

					// System.out.print(currentCell.getStringCellValue()+ "|" );
					colList.add(currentCell.getStringCellValue());

				} else if (currentCell.getCellTypeEnum() == CellType.STRING) {

					// System.out.print(currentCell.getStringCellValue() );
					rowMap.put(colList.get(colIndx), currentCell.getStringCellValue());

				} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
					totalAmount += currentCell.getNumericCellValue();
					// System.out.print(currentCell.getNumericCellValue() );
					rowMap.put(colList.get(colIndx), String.valueOf(currentCell.getNumericCellValue()));
				}
				colIndx = colIndx + 1;

			}

			if (i != 6)
				tableList.add(rowMap);
		}
		// System.out.println("Total Expense: "+totalAmount);
		System.out.println("Excel Metadata:");
		System.out.println("		Total Rows    : " + String.valueOf(rowCount-6));
		System.out.println("		Total Columns : " + colList.size());
		return tableList;
    }  

    public List<HashMap<String,String>> readCSV(String filePath,String fileName) throws IOException{
    	
    	List<HashMap<String, String>> tableList = null;
    	 try (
         		
         		// Create Reader from given CSV file 
         		Reader reader = Files.newBufferedReader(Paths.get(filePath+"\\"+fileName),StandardCharsets.UTF_16LE);
         		CSVParser csvParser =	CSVParser.parse(reader, CSVFormat.MYSQL.withHeader())
         ) {
         	
         	// Column Names
         	List<String>  columnList=csvParser.getHeaderNames();
         	
         	// To store one record 
         	HashMap<String,String> recordMap=null;
         	// To store table of records
         	tableList = new ArrayList<HashMap<String, String>>();
         	
         	// Create a list of records to iterate
         	List<CSVRecord> recordLst = csvParser.getRecords();
         	
         	System.out.println("Reading CSV file ... Please wait !");
             for (CSVRecord csvRecord : recordLst) {
             	
             	recordMap=new HashMap<String, String>();
             
             	for (String column : columnList){
             		
             		recordMap.put(column, csvRecord.get(column));
             		//System.out.println(column +" = " + csvRecord.get(column));
             		
             	}
             	//System.out.println(csvRecord.getRecordNumber());
             	
             	tableList.add(recordMap);
             
               
             }
             System.out.println("CSV Metadata:");
     		 System.out.println("		Total Rows    : " + recordLst.size());
     		 System.out.println("		Total Columns : " + csvParser.getHeaderNames().size());
            
         }
	
		return tableList;
    }  


    public  void printTable(List<HashMap<String,String>> resultList) {
		
		Optional<Object> opCol;
		String column;
		System.out.println("-----------------Print table using HashMap :Excel Start--------");
		for (HashMap<String, String> hashMap : resultList) {
			
			for (Entry<String, String> entry : hashMap.entrySet()) {
				
				column = entry.getKey();
				
				System.out.print(centerString(5, column) + " : ");
				opCol = Optional.ofNullable(entry.getValue());
				
				System.out.print(centerString(12, opCol.orElse("").toString()) + "|");	
				
			}
			System.out.println();
			
		}
		System.out.println("-----------------Print table using HashMap :Excel End----------");
	}
    private  String centerString(int width, String s) {
		return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}
	
    //Main function is calling readExcel function to read data from excel file

    public static void main(String...strings) throws IOException{

    //Create an object of ReadGuru99ExcelFile class
    ReadExcel objExcelFile = new ReadExcel();

    //Prepare the path of excel file
    //String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
    //String filePath = "C:\\Softwares\\workspace";
    String filePath = "C:\\shunmugam\\cigniti\\Workspace\\Workspace\\FullStackAutomation\\src\\main\\resources\\ExcelFiles";
    //Call read file method of the class to read data
    List<HashMap<String,String>> expectedLst=new ArrayList<HashMap<String,String>>();
    //expectedLst=objExcelFile.readExcel(filePath,"Expense.xlsx","Demo");
    expectedLst=objExcelFile.readExcel(filePath,"Clients%5FSpendOverview.xlsx","sheet1");
    
    
   
   // printTable(expectedLst);
   

    }

}