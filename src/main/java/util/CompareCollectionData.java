package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CompareCollectionData {
	
	private String filePath = "C:\\shunmugam\\cigniti\\Workspace\\Workspace\\FullStackAutomation\\src\\main\\resources\\ExcelFiles";
	List<HashMap<String,String>> actualList=new ArrayList<HashMap<String,String>>();
	List<HashMap<String,String>> expectedList=new ArrayList<HashMap<String,String>>();
	
	public List<HashMap<String,String>> getActualListFromExcel(String excelFileName, String sheet) throws IOException{
		//Create an object of ReadExcel
	    ReadExcel objExcelFile = new ReadExcel();
	    List<HashMap<String,String>> excelList=new ArrayList<HashMap<String,String>>();
	    
	    //Read Excel sheet and store the data in List<HashMap<String,String>>
	    excelList=objExcelFile.readExcel(filePath,excelFileName,sheet);
	    
	    
	    // Print Excel data
	    //objExcelFile.printTable(excelList);
	   
	    return excelList;
	}

	public List<HashMap<String,String>> getActualListFromCSV(String excelFileName) throws IOException{
		//Create an object of ReadExcel
	    ReadExcel objExcelFile = new ReadExcel();
	    List<HashMap<String,String>> csvList=new ArrayList<HashMap<String,String>>();
	    
	    //Read Excel sheet and store the data in List<HashMap<String,String>>
	    csvList=objExcelFile.readCSV(filePath,excelFileName);
	    
	    
	    // Print Excel data
	    //objExcelFile.printTable(csvList);
	   
	    return csvList;
	}
	public List<HashMap<String,String>> getExpectedListFromDB()throws ClassNotFoundException {

		SQLServerDBSample sqlserverDb =new SQLServerDBSample();
		List<HashMap<String,String>> tableLst=null;
		try {

				Connection connection = sqlserverDb.getConnection();
				Statement currStmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				//ResultSet resultSet = currStmt.executeQuery("Select * from dbo.Employee");
				ResultSet resultSet = currStmt.executeQuery("Select * from dbo.[ClientsSpendOverview]");
				int rowCount = resultSet.last() ? resultSet.getRow() : 0;

				resultSet.beforeFirst();

				ResultSetMetaData rsmd = resultSet.getMetaData();

				int columnCount = rsmd.getColumnCount();
				
				
				//sqlserverDb.printTable(resultSet,rowCount,columnCount );
				tableLst=sqlserverDb.storeTable(resultSet,rowCount,columnCount );
				
				//sqlserverDb.printTable(tableLst);
				
				

			} catch (SQLException e) {

				System.out.println("Query Execution Failed! Check output console");

				e.printStackTrace();

			}
		return tableLst;
	}
	public void verifyAll(List<HashMap<String,String>> actualList, List<HashMap<String,String>> expectedList){
		
		// 1. Rowcount
		if (actualList.size()!= expectedList.size()){
			System.out.println("*********Excel and DB are not matching ************");
			System.out.println("Actual Rowcount   =" + actualList.size());
			System.out.println("Expected Rowcount =" + expectedList.size());
			return;
		}
		System.out.println("Actual Rowcount   =" + actualList.size());
		System.out.println("Expected Rowcount =" + expectedList.size());
		
		// 2. Compare two Lists
		
		/*if (!actualList.equals(expectedList)){
			System.out.println("*********Excel and DB are not matching ************");
			
			return;
		}*/
		
		int rowcount=actualList.size();
		HashMap<String,String> actualRowMap=null;
		HashMap<String,String> expectedRowMap=null;
		for (int i=0;i<rowcount;i++){
			actualRowMap=new HashMap<String,String>();
			expectedRowMap=new HashMap<String,String>();
			actualRowMap=actualList.get(i);
			expectedRowMap=expectedList.get(i);
			
			Set<String> columnSet=actualRowMap.keySet();
			
			for (String key : columnSet) {
				
				
				if (actualRowMap.get(key).equals(expectedRowMap.get(key))){
					
					//System.out.println("Machting");
					
				}else{
					System.out.println("******* Not Machting *******");
					System.out.println("Row ="+ i);
					System.out.println("Actual "+key+ " = "+actualRowMap.get(key));
					System.out.println("Expected "+key+ " = "+expectedRowMap.get(key));
					//return;
				}
			}
			
		}
		
		
	}
	
	public void verifyColumn(List<HashMap<String,String>> actualList, List<HashMap<String,String>> expectedList, String columnName){
		
		// 1. Rowcount
		if (actualList.size()!= expectedList.size()){
			System.out.println("*********Excel and DB are not matching ************");
			System.out.println("Actual Rowcount   =" + actualList.size());
			System.out.println("Expected Rowcount =" + expectedList.size());
			return;
		}
		System.out.println("Actual Rowcount   =" + actualList.size());
		System.out.println("Expected Rowcount =" + expectedList.size());
		
		
		//2. verify given column values
		
		int rowcount=actualList.size();
		HashMap<String,String> actualRowMap=null;
		HashMap<String,String> expectedRowMap=null;
		for (int i=0;i<rowcount;i++){
			actualRowMap=new HashMap<String,String>();
			expectedRowMap=new HashMap<String,String>();
			actualRowMap=actualList.get(i);
			expectedRowMap=expectedList.get(i);
			
			//Set<String> columnSet=actualRowMap.keySet();
			
			//for (String key : columnSet) {
				
				
				if (actualRowMap.get(columnName).equals(expectedRowMap.get(columnName))){
					
					//System.out.println("Machting");
					
				}else{
					System.out.println("******* Not Machting *******");
					System.out.println("Row ="+ i);
					System.out.println("Actual "+columnName+ " = "+actualRowMap.get(columnName));
					System.out.println("Expected "+columnName+ " = "+expectedRowMap.get(columnName));
					//return;
				}
			//}
			
		}
		
		
	}
	
	public void verifyRow(List<HashMap<String,String>> actualList, List<HashMap<String,String>> expectedList, int row){
		
		// 1. Rowcount
		if (actualList.size()!= expectedList.size()){
			System.out.println("*********Excel and DB are not matching ************");
			System.out.println("Actual Rowcount   =" + actualList.size());
			System.out.println("Expected Rowcount =" + expectedList.size());
			return;
		}
		System.out.println("Actual Rowcount   =" + actualList.size());
		System.out.println("Expected Rowcount =" + expectedList.size());
		
		
		
		int rowcount=actualList.size();
		HashMap<String,String> actualRowMap=null;
		HashMap<String,String> expectedRowMap=null;
		//for (int i=0;i<rowcount;i++){
			actualRowMap=new HashMap<String,String>();
			expectedRowMap=new HashMap<String,String>();
			actualRowMap=actualList.get(row);
			expectedRowMap=expectedList.get(row);
			
			Set<String> columnSet=actualRowMap.keySet();
			
			System.out.println("Row      : "+ row);
			for (String key : columnSet) {
				
				
				if (actualRowMap.get(key).equals(expectedRowMap.get(key))){
					

					
				}else{
					System.out.println("******* Not Machting *******");
					System.out.println("Actual   : "+key+ " = "+actualRowMap.get(key));
					System.out.println("Expected : "+key+ " = "+expectedRowMap.get(key));
					System.out.println();
					
					//return;
				}
			}
			
		//}
		
		
	}
	
	
	public void verifyRowColumn(List<HashMap<String,String>> actualList, List<HashMap<String,String>> expectedList,int row, String columnName){
		
		// 1. Rowcount
		if (actualList.size()!= expectedList.size()){
			System.out.println("*********Excel and DB are not matching ************");
			System.out.println("Actual Rowcount   =" + actualList.size());
			System.out.println("Expected Rowcount =" + expectedList.size());
			return;
		}
		System.out.println("Actual Rowcount   =" + actualList.size());
		System.out.println("Expected Rowcount =" + expectedList.size());
		
		//2. verify given column values
		
		int rowcount=actualList.size();
		HashMap<String,String> actualRowMap=null;
		HashMap<String,String> expectedRowMap=null;
		
			actualRowMap=new HashMap<String,String>();
			expectedRowMap=new HashMap<String,String>();
			actualRowMap=actualList.get(row);
			expectedRowMap=expectedList.get(row);
		
				if (actualRowMap.get(columnName).equals(expectedRowMap.get(columnName))){
					
					System.out.println("Machting");
					
				}else{
					System.out.println("******* Not Machting *******");
					
					return;
				}
				System.out.println("Row      : "+ row);
				System.out.println("Actual   : "+columnName+ " = "+actualRowMap.get(columnName));
				System.out.println("Expected : "+columnName+ " = "+expectedRowMap.get(columnName));
		
		
		
	}
	
	public static void main(String...strings) throws IOException,ClassNotFoundException{
		
		CompareCollectionData compareCollectionData =new CompareCollectionData();
		
		compareCollectionData.actualList=compareCollectionData.getActualListFromCSV("SpendOverview_csv.csv");
		/*
		compareCollectionData.actualList=compareCollectionData.getActualListFromExcel("Clients%5FSpendOverview.xlsx","sheet1");
		
		
		compareCollectionData.expectedList=compareCollectionData.getExpectedListFromDB();
		
		System.out.println("1. Verify Cell");
		compareCollectionData.verifyRowColumn(compareCollectionData.actualList,compareCollectionData.expectedList,1003, "Location Code");
		
		System.out.println("2. Verify Columns");
		compareCollectionData.verifyColumn(compareCollectionData.actualList,compareCollectionData.expectedList, "Company Code");
		//compareCollectionData.verifyColumn(compareCollectionData.actualList,compareCollectionData.expectedList, "Location Code");
		
		System.out.println("3. Verify Rows");
		compareCollectionData.verifyRow(compareCollectionData.actualList,compareCollectionData.expectedList,1003);
		
		//compareCollectionData.verifyAll(compareCollectionData.actualList,compareCollectionData.expectedList);
		
		*/
		
	}
}
