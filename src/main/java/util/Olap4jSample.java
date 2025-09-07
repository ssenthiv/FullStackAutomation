package util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import org.olap4j.CellSet;
import org.olap4j.OlapConnection;
import org.olap4j.OlapStatement;
import org.olap4j.OlapWrapper;
import org.olap4j.*;

public class Olap4jSample {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.olap4j.driver.xmla.XmlaOlap4jDriver");
		OlapConnection con = (OlapConnection)DriverManager.getConnection("jdbc:xmla:Server=http://ADCDWHSQLQA04/tab/msmdpump.dll;Catalog=Elements");
			
		OlapWrapper wrapper = (OlapWrapper) con;
		OlapConnection olapConnection = wrapper.unwrap(OlapConnection.class);
		OlapStatement stmt = olapConnection.createStatement();
		
		/*CellSet cellSet = stmt.executeOlapQuery("SELECT {[Measures].[Spend per Ton]," + 
				"[Measures].[Billable Amount]," + 
				"[Measures].[Location Count]," + 
				"[Measures].[Haul Count], " + 
				"[Measures].[Integrated Tonnage Quantity]} ON Columns, {[Client].[Client Code].[Client Code]} ON Rows FROM [Elements]");
		
		*/
		
		CellSet cellSet = stmt.executeOlapQuery("SELECT  {[Measures].[Billable Amount]} ON COLUMNS " + 
				",{ [Client].[Client Code].[Client Code]} ON ROWS" + 
				" FROM [Elements]" +
				" WHERE " +
				" {[Service Date].[Service Calendar].[Service Year].&[2019].&[3rd Quarter].&[August]}"
				);

		
		

		/*DataSet ds;
		
		for (Position rowPos : cellSet.getAxes().get(1)) {
		  ds.addRow();
		  for (Position colPos : cellSet.getAxes().get(0)) {
			test += Integer.toString(rowPos.getOrdinal()) + " : " + Integer.toString(colPos.getOrdinal());
			Cell cell = cellSet.getCell(colPos, rowPos);
			test += "Value: " + cell.getFormattedValue() + "";
					 
			ds.addValue("column" + Integer.toString(colPos.getOrdinal()), cell.getFormattedValue());
		  }
		}*/

	}

}
