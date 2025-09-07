package util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

public class VerifyCollectionData {
	
	private String filePath =  System.getProperty("user.dir")+ "\\src\\main\\resources\\ExcelFiles";
	List<HashMap<String,String>> actualList=new ArrayList<HashMap<String,String>>();
	List<HashMap<String,String>> expectedList=new ArrayList<HashMap<String,String>>();
	
	public List<HashMap<String,String>> getDataFromExcel(String excelFileName, String sheet) throws IOException{
		//Create an object of ReadExcel
	    ExcelCsvReader objExcelCsvFile = new ExcelCsvReader();
	    List<HashMap<String,String>> excelList=new ArrayList<HashMap<String,String>>();
	    
	    //Read Excel sheet and store the data in List<HashMap<String,String>>
	    excelList=objExcelCsvFile.readExcel(filePath,excelFileName,sheet);
	    
	    
	    // Print Excel data
	    //objExcelCsvFile.printTable(excelList);
	   
	    return excelList;
	}
	public List<HashMap<String,String>> getDataFromCSV(String excelFileName) throws IOException{
		//Create an object of ReadExcel
		ExcelCsvReader objExcelCsvFile = new ExcelCsvReader();
	    List<HashMap<String,String>> csvList=new ArrayList<HashMap<String,String>>();
	    
	    //Read Excel sheet and store the data in List<HashMap<String,String>>
	    csvList=objExcelCsvFile.readCSV(filePath,excelFileName);
	    
	    
	    // Print Excel data
	    //objExcelCsvFile.printTable(csvList);
	   
	    return csvList;
	}
	public List<HashMap<String,String>> getDataFromDataBaseUsingQuery(String query)throws ClassNotFoundException,IOException {

		DatabaseHandler dbHandler =new DatabaseHandler();
		List<HashMap<String,String>> tableLst=null;
		try {

				Connection connection = dbHandler.getConnection();
				Statement currStmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				//ResultSet resultSet = currStmt.executeQuery("Select * from dbo.Employee");
				//ResultSet resultSet = currStmt.executeQuery("Select * from dbo.[ClientsSpendOverview]");
				ResultSet resultSet = currStmt.executeQuery(query);
				int rowCount = resultSet.last() ? resultSet.getRow() : 0;

				resultSet.beforeFirst();

				ResultSetMetaData rsmd = resultSet.getMetaData();

				int columnCount = rsmd.getColumnCount();
				
				
				//sqlserverDb.printTable(resultSet,rowCount,columnCount );
				tableLst=dbHandler.storeTable(resultSet,rowCount,columnCount );
				
				//sqlserverDb.printTable(tableLst);
				
				

			} catch (SQLException e) {

				System.out.println("Query Execution Failed! Check output console");

				e.printStackTrace();

			}
		return tableLst;
	}
	
	public List<HashMap<String,String>> getDataFromDataBaseUsingSP(String spName, Map<String,Object> argMap)throws ClassNotFoundException, IOException {

		DatabaseHandler dbHandler =new DatabaseHandler();
		List<HashMap<String,String>> tableLst=null;
		try {

				Connection connection = dbHandler.getConnection();
				CallableStatement callStmt= connection.prepareCall("{call " + spName+ " }",
						ResultSet.TYPE_SCROLL_INSENSITIVE,
		                ResultSet.CONCUR_READ_ONLY);
				
				for (Entry<String,Object> entry : argMap.entrySet()){
					callStmt.setObject(entry.getKey(), entry.getValue());
						
				}
				
				
				ResultSet resultSet = callStmt.executeQuery();
				int rowCount = resultSet.last() ? resultSet.getRow() : 0;

				resultSet.beforeFirst();

				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();
				tableLst=dbHandler.storeTable(resultSet,rowCount,columnCount );
			} catch (SQLException e) {

				System.out.println("Stored Procedure Execution Failed! Check output console");

				e.printStackTrace();

			}
		return tableLst;
	}

	public List<HashMap<String,String>> getDataFromDataBaseUsingScript(String filePath, String scriptName)throws ClassNotFoundException, IOException {

		DatabaseHandler dbHandler =new DatabaseHandler();
		List<HashMap<String,String>> tableLst=null;
		try {

				Connection connection = dbHandler.getConnection();
				ScriptRunner scrRunn=new ScriptRunner(connection, false, true);
				Reader reader = Files.newBufferedReader(Paths.get(filePath + "\\" + scriptName));
				
				
				
				System.out.println("Fetching data from DB ... Please wait !");
				ResultSet resultSet = scrRunn.runScript(reader);
				
				Optional<Object> opCol;
				String columnName = null;
				HashMap<String, String> rowMap = null;
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();
				tableLst=new ArrayList<HashMap<String,String>>();
				while (resultSet.next()) {

					rowMap = new HashMap<String, String>();
					for (int i = 1; i <= columnCount; i++) {

						opCol = Optional.ofNullable(resultSet.getObject(i));

						columnName = rsmd.getColumnName(i);
						rowMap.put(columnName, opCol.orElse("").toString());

					}

					tableLst.add(rowMap);
				}
				
				System.out.println("Database Metadata:");
				System.out.println("		Total Rows    : " + tableLst.size());
				System.out.println("		Total Columns : " + rsmd.getColumnCount());

		} catch (SQLException e) {

				System.out.println("Stored Procedure Execution Failed! Check output console");

				e.printStackTrace();

			}
		return tableLst;
	}


    public  void printTable(List<HashMap<String,String>> resultList) {
		
		Optional<Object> opCol;
		String column;
		System.out.println("-----------------Print table using HashMap : Start--------");
		for (HashMap<String, String> hashMap : resultList) {
			
			for (Entry<String, String> entry : hashMap.entrySet()) {
				
				column = entry.getKey();
				
				System.out.print(centerString(5, column) + " : ");
				opCol = Optional.ofNullable(entry.getValue());
				
				System.out.print(centerString(12, opCol.orElse("").toString()) + "|");	
				
			}
			System.out.println();
			
		}
		System.out.println("-----------------Print table using HashMap : End----------");
	}
    private  String centerString(int width, String s) {
		return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
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
	
	/**
	* Fetching the source code for given Stored procedure from the Database
	* 
	* @author Shunmugasundaram Senthivelu
	* @param patch 	patch is the container for computed deltas.
	*/
	public List<HashMap<String,String>> fetchSourceCodeFromDB(String filePath, String spName)throws ClassNotFoundException {

		DatabaseHandler dbHandler =new DatabaseHandler();
		List<HashMap<String,String>> tableLst=null;
		String query = "EXEC [dbo].[sp_helptext] ?  ";

		try (BufferedWriter bw =new BufferedWriter(new FileWriter(filePath + "\\revised.sql"));
				Connection connection = dbHandler.getConnection();
				PreparedStatement stmt = connection.prepareStatement(query);){
				
				stmt.setString(2, spName);
				try (ResultSet resultSet = stmt.executeQuery();){
					
				
		
				System.out.println("Fetching Stored Procedure from DB ... Please wait !");
				StringBuilder b = new StringBuilder();
				while (resultSet.next())
				{
				    b.append(resultSet.getString("Text"));
				    bw.write(resultSet.getString("Text"));
				}
				
				System.out.println(b.toString()); 
				} catch (SQLException e){
						
						throw new FrameworkException("JDBC SQL ResultSet Execution Failed! Check output console\n" , e);

				}

		
		} catch (IOException e) {
			
			throw new FrameworkException("Writing sql file on disk Failed! Check output console\n" , e);


		} catch (SQLException e) {
			
			throw new FrameworkException("JDBC SQL Prepared Statement Failed! Check output console\n" , e);

		} 
		return tableLst;
	}

	public static void main(String...strings) throws ClassNotFoundException, IOException{
		
		VerifyCollectionData verifyCollectionData =new VerifyCollectionData();
		
		//1 . CSV
		//verifyCollectionData.actualList=verifyCollectionData.getDataFromCSV("SpendOverview_csv_demo.csv");
		// Print HashMap
		//verifyCollectionData.printTable(verifyCollectionData.actualList);
		
		//2. Excel
		verifyCollectionData.expectedList=verifyCollectionData.getDataFromExcel("Clients%5FSpendOverview_demo.xlsx","sheet1");
		// Print HashMap
		verifyCollectionData.printTable(verifyCollectionData.expectedList);
		
		//3. DB query
		//String query="Select * from dbo.[ClientsSpendOverview]";
	
		//verifyCollectionData.expectedList=verifyCollectionData.getDataFromDataBaseUsingQuery(query);
		// Print HashMap
		//verifyCollectionData.printTable(verifyCollectionData.expectedList); 
		
		
		//4. DB Calling Stored Procedure
		//String spName="dbo.uspgetSpendOverviewReport(?,?,?)";
		//Map<String, Object> inpMap=new HashMap<String,Object>();
		//inpMap.put("locationCode", "AZN000181");
		//inpMap.put("serviceDate", "2019-08-27");
		//inpMap.put("billableComponentQuantity", 1);
		
		//verifyCollectionData.expectedList=verifyCollectionData.getDataFromDataBaseUsingSP(spName, inpMap);
		// Print HashMap
		//verifyCollectionData.printTable(verifyCollectionData.expectedList);
		
		//5. DB Calling a sql script
		//String scrName="spendOverview.sql";
		//verifyCollectionData.expectedList=verifyCollectionData.getDataFromDataBaseUsingScript(verifyCollectionData.filePath, scrName);
		// Print HashMap
		//verifyCollectionData.printTable(verifyCollectionData.expectedList);
		
		
		//6. DB fetching SP
		//String scrName="sp_help.sql";
		
//		try {
//			verifyCollectionData.expectedList=verifyCollectionData.fetchSourceCodeFromDB(verifyCollectionData.filePath, "[dbo].[uspgetEmployeesByLastName]");
//			System.out.println("check next smt");
//		} catch (FrameworkException e) {
//			
//			System.out.println(e.getMessage());
//			e. printStackTrace();
//			
//			
//		}
		
		// Print HashMap
		//verifyCollectionData.printTable(verifyCollectionData.expectedList);
				
				
		
		
		// ******************  verification on Excel *******************
		/*
		System.out.println("1. Verify Cell");
		verifyCollectionData.verifyRowColumn(verifyCollectionData.actualList,verifyCollectionData.expectedList,1003, "Location Code");
		
		System.out.println("2. Verify Columns");
		verifyCollectionData.verifyColumn(verifyCollectionData.actualList,verifyCollectionData.expectedList, "Company Code");
		//verifyCollectionData.verifyColumn(verifyCollectionData.actualList,verifyCollectionData.expectedList, "Location Code");
		
		System.out.println("3. Verify Rows");
		verifyCollectionData.verifyRow(verifyCollectionData.actualList,verifyCollectionData.expectedList,1003);
		
		//verifyCollectionData.verifyAll(verifyCollectionData.actualList,verifyCollectionData.expectedList);
		
		*/
		
	}
}
