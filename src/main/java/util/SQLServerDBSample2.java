package util;

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
import java.util.Optional;



public class SQLServerDBSample2 {
	public static String dataRecordIndex1 = null; 
	public static List<String> list1 = new ArrayList<String>();
	public static Map<String, String> map1 = new HashMap<>();


	// Get Connection 
	public static Connection getConnection() {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//String url1 = "jdbc:sqlserver://HW1664\\TESTDATA:1433;databaseName=TestDB;user=sa;password=Password123;";
		String url1 = "jdbc:sqlserver://10.62.67.20:1433;databaseName=TestDB;user=sa;password=Password123;";
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
		
		System.out.println("rowCount: " + rowCount);

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
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {

			Connection connection = getConnection();
			Statement currStmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet resultSet = currStmt.executeQuery("Select * from dbo.Employee");

			int rowCount = resultSet.last() ? resultSet.getRow() : 0;

			resultSet.beforeFirst();

			ResultSetMetaData rsmd = resultSet.getMetaData();

			int columnCount = rsmd.getColumnCount();
			
			printTable(resultSet,rowCount,columnCount );

		} catch (SQLException e) {

			System.out.println("Query Execution Failed! Check output console");

			e.printStackTrace();

		}
	}

	public static String centerString(int width, String s) {
		return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

	
	
	
	
	

	
	
	public static String getIndexesForTC(String TCID, String index_writData, String Sheetname) throws SQLException {
		Map<String, String> dataMap = new HashMap<String, String>();
		Connection con = getConnection();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet recset = stmt.executeQuery(
				"SELECT  W.BasicInfo_index, W.Debtor_index, W.Defendant_index, W.Creditor_index, W.LawyerAgent_index, W.JudgmentCost_index,W.FinTransaction_index, W.PC_index, W.OC_index, W.History_index, W.WritAction_index from WRIT_Data W , TestCase T where W.[index] = T.WRIT_index and T.Sheet = '"
						+ Sheetname + "' and T.[index]='"
						+ TCID + "' ;");

		ResultSetMetaData rsmd = recset.getMetaData();
		recset.beforeFirst();
		int recCount = 0;
		while (recset.next()) {
			recCount = recCount + 1;
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				dataMap.put(rsmd.getColumnName(i), recset.getString(rsmd.getColumnName(i)));
			}
			map1 = dataMap;
		}
		String index = map1.get(index_writData);
		return index;
	}

	// GET Indexes by Table Name
	public static String getIndexesForTC_WritsARC(String TCID, String index_writData, String Sheetname) throws SQLException {
		Map<String, String> dataMap = new HashMap<String, String>();
		Connection con = getConnection();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet recset = stmt.executeQuery(
				"SELECT  W.BasicInfo_index, W.Debtor_index, W.Defendant_index, W.Creditor_index, W.LawyerAgent_index, W.JudgmentCost_index,W.FinTransaction_index, W.PC_index, W.OC_index, W.History_index from WRIT_Data W , TestCase T where W.[index] = T.WRIT_index and T.Sheet = '"
						+ Sheetname + "' and T.[index]='"
						+ TCID + "' ;");

		ResultSetMetaData rsmd = recset.getMetaData();
		recset.beforeFirst();
		int recCount = 0;
		while (recset.next()) {
			recCount = recCount + 1;
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				dataMap.put(rsmd.getColumnName(i), recset.getString(rsmd.getColumnName(i)));
			}
			map1 = dataMap;
		}
		String index = map1.get(index_writData);
		return index;
	}

	// GET Indexes by Table Name
	public static String getIndexesForTC_SearchARC(String TCID, String index_writData, String Sheetname) throws SQLException {
		Map<String, String> dataMap = new HashMap<String, String>();
		Connection con = getConnection();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet recset = stmt.executeQuery(
				"SELECT  W.BasicInfo_index, W.Debtor_index, W.Defendant_index, W.Creditor_index, W.LawyerAgent_index, W.JudgmentCost_index,W.FinTransaction_index, W.PC_index, W.OC_index, W.History_index from WRIT_Data W , TestCase T where W.[index] = T.WRIT_index and T.Sheet = '"
						+ Sheetname + "' and T.[index]='"
						+ TCID + "' ;");

		ResultSetMetaData rsmd = recset.getMetaData();
		recset.beforeFirst();
		int recCount = 0;
		while (recset.next()) {
			recCount = recCount + 1;
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				dataMap.put(rsmd.getColumnName(i), recset.getString(rsmd.getColumnName(i)));
			}
			map1 = dataMap;
		}
		String index = map1.get(index_writData);
		return index;
	}

	// Get SearchIndex from Testcase by TCID
	public String getSearchIndexByTCID(String TCID, String sheetname) throws SQLException, NullPointerException {

		Connection con = getConnection();
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet recset = stmt.executeQuery(
				"select Search_index from TestCase where [index]='" + TCID + "' and Sheet = '" + sheetname + "';");
		recset.beforeFirst();
		/*
		 * TestCase testcase = new TestCase(); while (recset.next()) { testcase.setSearch_index(recset.getString("Search_index")); }
		 */
		closeConnection(con);
		// return testcase.getSearch_index();
		return "dummy";
	}

	// getRecordIndex

	public static String getRecordIndex(String dataRecordIndex, String tableName, String Debtorindex, String sheetname) throws SQLException {
		Map<String, String> bimap1 = new HashMap<String, String>();
		String sQuery = "select " + dataRecordIndex + " from " + tableName + " where [index] = '" + Debtorindex + "'  and Sheet = '" + sheetname + "';";
		Connection c = getConnection();
		Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet recset = stmt.executeQuery(sQuery);
		ResultSetMetaData rsmd = recset.getMetaData();
		recset.beforeFirst();
		while (recset.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				bimap1.put(rsmd.getColumnName(i), recset.getString(rsmd.getColumnName(i)));
				dataRecordIndex1 = recset.getString(rsmd.getColumnName(i));

			}
		}
		return dataRecordIndex1;
	}

	public static List<String> getDataRecordindices_list(String Test) {
		List<String> list2 = new ArrayList<String>();
		List<String> listofIndices = new ArrayList<String>();
		String[] arrOfStr = Test.split(",");
		for (int j = 0; j < arrOfStr.length; j++) {
			listofIndices.add(arrOfStr[j]);
			list2.add(listofIndices.get(j));
		}
		return list2;
	}

}
