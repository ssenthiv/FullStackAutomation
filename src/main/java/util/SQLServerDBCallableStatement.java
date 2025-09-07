package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;



public class SQLServerDBCallableStatement {
	

	// Get Connection 
	public static Connection getConnection() {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//OS authentication
		//String url1 = "jdbc:sqlserver://HW1664:1433;databaseName=TestDB;integratedSecurity=true";
		String url1 = "jdbc:sqlserver://HW1664:1433;databaseName=TestDB;user=sa;password=Password123;";
		//String url1 = "jdbc:sqlserver://10.62.67.20:1433;databaseName=TestDB;user=sa;password=Password123;";
		String username = ""; // leave blank if none
		String password = ""; // leave blank if none
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection(url1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Close Database Connection
	public static void closeConnection(Connection con) throws SQLException {
		con.close();
	}

	public static void printTable(ResultSet resultSet, int rowCount, int columnCount) throws SQLException{
		
		//System.out.println("rowCount: " + rowCount);

		resultSet.beforeFirst();

		ResultSetMetaData rsmd = resultSet.getMetaData();



		for (int i = 1; i <= columnCount; i++) {

			System.out.print(centerString(25, rsmd.getColumnName(i)) + "|");

		}
		System.out.println();

		Optional<Object> opCol;

		while (resultSet.next()) {

			for (int i = 1; i <= columnCount; i++) {

				opCol = Optional.ofNullable(resultSet.getObject(i));
				System.out.print(centerString(25, opCol.orElse("").toString()) + "|");

			}

			System.out.println();
		}
		
	}
	
	public static void printTable(List<HashMap<String,String>> resultList) throws SQLException{
		
		Optional<Object> opCol;
		String column;
		System.out.println("-----------------Print table using HashMap : DB Start--------");
		for (HashMap<String, String> hashMap : resultList) {
			
			for (Entry<String, String> entry : hashMap.entrySet()) {
				
				column = entry.getKey();
				
				System.out.print(centerString(5, column) + " : ");
				opCol = Optional.ofNullable(entry.getValue());
				
				System.out.print(centerString(12, opCol.orElse("").toString()) + "|");	
				
			}
			System.out.println();
			
		}
		System.out.println("-----------------Print table using HashMap : DB End----------");
	}
	
	
	
public static List<HashMap<String,String>> storeTable(ResultSet resultSet, int rowCount, int columnCount) throws SQLException{
		
		List<HashMap<String,String>> tableList =new ArrayList<HashMap<String,String>>();
	
	    //System.out.println("rowCount: " + rowCount);
		
		System.out.println("Database Metadata:");
		System.out.println("		Total Rows    : " + rowCount);
		System.out.println("		Total Columns : " + columnCount);

		resultSet.beforeFirst();

		ResultSetMetaData rsmd = resultSet.getMetaData();



		

		Optional<Object> opCol;
		String columnName=null;
		HashMap<String,String> rowMap=null;
		while (resultSet.next()) {
			
			rowMap=new HashMap<String,String>();
			for (int i = 1; i <= columnCount; i++) {

				opCol = Optional.ofNullable(resultSet.getObject(i));
				
				
				
				columnName=rsmd.getColumnName(i);
				rowMap.put(columnName,opCol.orElse("").toString());

			}

			
			tableList.add(rowMap);
		}
		return tableList;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {

			Connection connection = getConnection();
			//Statement currStmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			CallableStatement callStmt= connection.prepareCall("{call dbo.uspgetEmployeesByLastName(?)}",
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_READ_ONLY);
			
			callStmt.setString("lastNameStartsWith", "S");
			//ResultSet resultSet = currStmt.executeQuery("Select * from dbo.Employee");
			ResultSet resultSet = callStmt.executeQuery();
			
			//ResultSet resultSet = currStmt.executeQuery("Select * from dbo.[ClientsSpendOverview]");
			int rowCount = resultSet.last() ? resultSet.getRow() : 0;

			resultSet.beforeFirst();

			ResultSetMetaData rsmd = resultSet.getMetaData();

			int columnCount = rsmd.getColumnCount();
			
			List<HashMap<String,String>> tableLst=null;
			//printTable(resultSet,rowCount,columnCount );
			tableLst=storeTable(resultSet,rowCount,columnCount );
			printTable(tableLst);
			

		} catch (SQLException e) {

			System.out.println("Query Execution Failed! Check output console");

			e.printStackTrace();

		}
	}

	public static String centerString(int width, String s) {
		return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

}
