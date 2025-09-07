package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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



public class DatabaseHandler {

	// Get Connection
	public Connection getConnection() {

		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// OS authentication
		// String url1 =
		// "jdbc:sqlserver://HW1664:1433;databaseName=TestDB;integratedSecurity=true";
		String url1 = "jdbc:sqlserver://HW1664:1433;databaseName=TestDB;user=sa;password=Password123;";
		//String url1 = "jdbc:sqlserver://10.62.67.20:1433;databaseName=TestDB;user=sa;password=Password123;";
		String username = ""; // leave blank if none
		String password = ""; // leave blank if none
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC SQL Connection Failed! Check output console");
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection(url1);
			 
			
		} catch (SQLException e) {
			//System.out.println("JDBC SQL Connection Failed! Check output console");
			//e.printStackTrace();
			//throw new FrameworkException("JDBC SQL Connection Failed! Check output console\n" + e.getMessage());
			throw new FrameworkException("JDBC SQL Connection Failed! Check output console\n" , e);
		}
		//return null;
	}

	// Close Database Connection
	public  void closeConnection(Connection con) throws SQLException {
		con.close();
	}

	
	public List<HashMap<String, String>> storeTable(ResultSet resultSet, int rowCount, int columnCount)
			throws SQLException {

		List<HashMap<String, String>> tableList = new ArrayList<HashMap<String, String>>();

		// System.out.println("rowCount: " + rowCount);
		
		System.out.println("Fetching data from DB ... Please wait !");
		System.out.println("Database Metadata:");
		System.out.println("		Total Rows    : " + rowCount);
		System.out.println("		Total Columns : " + columnCount);

		resultSet.beforeFirst();

		ResultSetMetaData rsmd = resultSet.getMetaData();

		Optional<Object> opCol;
		String columnName = null;
		HashMap<String, String> rowMap = null;
		while (resultSet.next()) {

			rowMap = new HashMap<String, String>();
			for (int i = 1; i <= columnCount; i++) {

				opCol = Optional.ofNullable(resultSet.getObject(i));

				columnName = rsmd.getColumnName(i);
				rowMap.put(columnName, opCol.orElse("").toString());

			}

			tableList.add(rowMap);
		}
		return tableList;
	}

	/*public String centerString(int width, String s) {
		return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}
*/
}
