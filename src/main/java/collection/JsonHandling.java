package collection;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
//import java.text.Collator;
//import java.text.RuleBasedCollator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonHandling  {

	
	// Traverse and collect itemids for each cluster


	//@SuppressWarnings("unchecked")
	public Map<String,String> traverseLeafNodes(JSONObject JsonObj,Map<String,String> itemClusterMap ){
		 		
		JSONArray subclustersJsonArray=(JSONArray) JsonObj.get("subclusters");      // simplified
		//subclustersJsonArray=(JSONArray) JsonObj.get("subclusters");
		
		
		JSONArray itemsJsonArray=null;
		JSONObject jsonObjInSubclusersArray=null;
		JSONObject jsonObjInItemsArray=null;
		
		
		
		//@SuppressWarnings("unchecked")
		//Iterator<JSONObject> subclusterIterator= subclustersJsonArray.iterator();
		Iterator<?> subclusterIterator= 	subclustersJsonArray.iterator();
		Iterator<JSONObject> itemIterator=	null;
		while (subclusterIterator.hasNext()){
			
			jsonObjInSubclusersArray= (JSONObject)subclusterIterator.next();
			String clusterId=jsonObjInSubclusersArray.get("clusterId").toString();
			itemsJsonArray=(JSONArray) jsonObjInSubclusersArray.get("items");
			
			// The expression of type Iterator needs unchecked conversion to Confirm to Iterator<JSONObject>
			// So added @SuppressWarnings("unchecked")  in the method declaration
			itemIterator=itemsJsonArray.iterator();
			
			
			// If no items in the cluster traverse recursively till we find the items(leaf node)	
			if (!itemIterator.hasNext()){
			
				traverseLeafNodes(jsonObjInSubclusersArray,itemClusterMap);
				
			}
			
			while (itemIterator.hasNext()){
				jsonObjInItemsArray=(JSONObject) itemIterator.next();
				String item=jsonObjInItemsArray.get("itemId").toString();
				// Create Item Cluster HashMap
				itemClusterMap.put(item, clusterId);
			}
				
			
		}
		
		return itemClusterMap;
	}
	public Map<String,List<String>> interchangeHashMapKeyValue(Map<String,String> itemClusterMap) {
	
		
	    // Removing duplicates
		Set<String> clusterSet =null;
		//clusterSet=(Set<String>) itemClusterMap.values(); // not working as collection objects can not be type cast lik this
		//clusterSet= itemClusterMap.values().stream().collect(Collectors.toSet()); // using stream working
		clusterSet=new HashSet<String>(itemClusterMap.values());
		Iterator<String> clusterItr=clusterSet.iterator();
	
		HashMap<String, List<String>> clusterItemMap=new HashMap<String, List<String>>();
		List<String> itemListGrpByCluster=new ArrayList<String>();
		
	
		while(clusterItr.hasNext()){
		
		String cluster=clusterItr.next();
		
		for(Map.Entry<String, String> entry :  itemClusterMap.entrySet()) {
									
			if (cluster.equals(entry.getValue())){
				
				itemListGrpByCluster.add(entry.getKey());
			}
				
		}
		clusterItemMap.put(cluster, itemListGrpByCluster);
		itemListGrpByCluster=new ArrayList<String>();
		//itemListGrpByCluster.clear();                           // Cannot use it as it will affect the Map
		}
		return clusterItemMap;
}
	public Map<String,ResultSet>  findMachtingClusters(Map<String,List<String>> actualClusterItemMap ,Map<String,List<String>> expectedClusterItemMap){
		

		ResultSet result=null;
		HashMap<String,ResultSet> clusterResultSet=new HashMap<String,ResultSet>();
		
		
		
		for (Map.Entry<String,List<String>> expectedEntry : expectedClusterItemMap.entrySet() ){
			
			List<ResultSet> arrayResultSet=new ArrayList<ResultSet>();
			String cluster=expectedEntry.getKey();
			
			for(Map.Entry<String, List<String>> actualEntry : actualClusterItemMap.entrySet()){
				
				result=calculatePrecission(actualEntry.getValue(),expectedEntry.getValue());
				
				if (!result.isEmpty()){
					arrayResultSet.add(result);
				}
			}
			// Sort based on total in ascending order. This is done to find the best match
			Collections.sort(arrayResultSet);
			// Take the last entry from arrayResultSet(best match)
			clusterResultSet.put(cluster, arrayResultSet.get((arrayResultSet.size()-1)));
		}
		return clusterResultSet;
	}
	public ResultSet calculatePrecission(List<String> actualItemList ,List<String> expectedItemList){
		
		double precision;
		double recall;

		List<String> actualItemCopy=new ArrayList<String>(actualItemList);
		List<String> expectedItemCopy=new ArrayList<String>(expectedItemList);
		ResultSet result=new ResultSet();
		
		// To find similar element in two list
		actualItemCopy.retainAll(expectedItemCopy);

		if (!actualItemCopy.isEmpty())
		{
			precision= (double) actualItemCopy.size()/expectedItemList.size();
			recall=   (double) actualItemCopy.size()/actualItemList.size();
			result=new ResultSet(precision,recall);
		}
		
		return result;
	}
	public void writeMetricsToExcel(Map<String,ResultSet>  clusterResultSet){

		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("MasterClusters");

		//sheet.addMergedRegion(new CellRangeAddress(0,clusterResultSet.size(),0,2));

		
		int rowcount=0;
		XSSFRow row;
		XSSFCell cell;
		// Font and style for header
		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFont(font);
		
		
		row=sheet.createRow(rowcount++);

		cell=row.createCell(0);
		cell.setCellValue("ClusterId");
		cell.setCellStyle(style);
		cell=row.createCell(1);
		cell.setCellValue("Precision");
		cell.setCellStyle(style);
		cell=row.createCell(2);
		cell.setCellValue("Recall");
		cell.setCellStyle(style);

		String clusterId;
		ResultSet resultSet;
		
		DecimalFormat df1=new DecimalFormat("##0.00");

		for (Map.Entry<String, ResultSet> entry : clusterResultSet.entrySet()){
			
			clusterId=(String) entry.getKey();
			resultSet=(ResultSet) entry.getValue();
			//System.out.println(" CluserId = "+ String.format("%3S", clusterId) +" : Precision = " + df1.format(resultSet.precission) + " : Recall = "+ df1.format(resultSet.recall ));
			
			 row=sheet.createRow(rowcount++);
				
				cell=row.createCell(0);
				cell.setCellValue(clusterId);
				cell=row.createCell(1);
				cell.setCellValue(df1.format(resultSet.precission));
				cell=row.createCell(2);
				cell.setCellValue(df1.format(resultSet.recall ));
			

		}


			FileOutputStream fos=null;
			
			try {
				fos=new FileOutputStream("src\\main\\resources\\metrics\\masterclusters.xlsx");
				workbook.write(fos);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			finally{
				
				if (fos!= null){
					try {
						fos.flush();
						fos.close();
						//((Closeable) workbook).close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
				}
				
			}
		}
	
	
	public static void main(String[] args) {
	
	JsonHandling jh=new JsonHandling();
		
		//System.out.println(ResultSet.t);
	
	String actualFile=null;
	String expectedFile=null;
	actualFile=System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\MasterCluster_actual.json";
	expectedFile=System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\MasterCluster_expected.json";
	
	// Reading json files using FileUtils
	
	File file=new File(actualFile);
	String actualString=null;
	String expectedString=null;
	try {
		 actualString = FileUtils.readFileToString(file);
		
		 file=new File(expectedFile);
		 expectedString= FileUtils.readFileToString(file);
	} 
	catch (IOException e) {
		e.printStackTrace();
	}


// Converting strings into JSONObject

JSONObject actualJsonObj=new JSONObject();
JSONObject expectedsonObj=new JSONObject();
JSONParser jsonParser=new JSONParser();


try {
	actualJsonObj= (JSONObject) jsonParser.parse(actualString);
	expectedsonObj= (JSONObject) jsonParser.parse(expectedString);
} catch (ParseException e) {

	e.printStackTrace();
}

// Creating JsonObject for top level cluster

JSONObject actualTopNode=null;
JSONObject expectedTopNode=null;

actualTopNode=(JSONObject) actualJsonObj.get("cluster");
expectedTopNode=(JSONObject) expectedsonObj.get("cluster");


// To store ItemCluster Map

 Map<String,String> actualItemClusterMap =new HashMap<>();         //simplified see expectedItemClusterMap
 //actualItemClusterMap =new HashMap<String,String>();

 Map<String,String> expectedItemClusterMap =null;
 expectedItemClusterMap =new HashMap<String,String>();

	
// To find and collect clusters having items
 actualItemClusterMap=jh.traverseLeafNodes(actualTopNode,actualItemClusterMap);
  
 //expectedItemClusterMap=jh.traverseLeafNodes(expectedTopNode,expectedItemClusterMap);   // this also works
 jh.traverseLeafNodes(expectedTopNode,expectedItemClusterMap);

 

 System.out.println("Item cluster Map Size = " +actualItemClusterMap.size());
 System.out.println("Actual  ->Item cluster Map : " +actualItemClusterMap);

 //System.out.println("Item cluster Map Size = " +expectedItemClusterMap.size());
 System.out.println("Expected->Item cluster Map : " +expectedItemClusterMap);



Map<String,List<String>> actualClusterItemMap =jh.interchangeHashMapKeyValue(actualItemClusterMap); // simplified
//actualClusterItemMap=jh.interchangeHashMapKeyValue(actualItemClusterMap);

Map<String,List<String>> expectedClusterItemMap =null;
expectedClusterItemMap= jh.interchangeHashMapKeyValue(expectedItemClusterMap);

System.out.println("Actual  ->Cluster Item Hash map  : " + actualClusterItemMap);	
System.out.println("Expected->Cluster Item Hash map  : " + expectedClusterItemMap);	

Map<String,ResultSet> clusterResultSet=null;

clusterResultSet=jh.findMachtingClusters(actualClusterItemMap,expectedClusterItemMap );


// Display ClusterId with Precision and Recall

String clusterId;
ResultSet resultSet;

// Formatting Precission and Recall
DecimalFormat df1=new DecimalFormat("####0.00");



for (Map.Entry<String, ResultSet> entry : clusterResultSet.entrySet()){
	
	clusterId=(String) entry.getKey();
	resultSet=(ResultSet) entry.getValue();
	System.out.println(" CluserId = "+ String.format("%3S", clusterId) +" : Precision = " + df1.format(resultSet.precission) + " : Recall = "+ df1.format(resultSet.recall ));
	
}


// writting into Excel sheet
jh.writeMetricsToExcel(clusterResultSet);

	}   // main()
	

	// Inner class ResultSet used to Precision and Recall
	public class ResultSet implements Comparable<ResultSet> {
		
		double precission=0;
		double recall=0;
		Double total;
		
			
		// Default constructor		
		public ResultSet(){

			this.total=(double) 0;
		}
		// Constructor 2
		public ResultSet(double p, double r){
			
			this.precission=p;
			this.recall=r;
			this.total=2*(p*r)/(p+r);
			
		}
		// Overridden a supper method to be used in collections.sort
		@Override
		public int compareTo(ResultSet o){
			
			Double total=this.total;
			//Double ototal=o.total;
			return total.compareTo(o.total);
			
		}
		// To determine null or not
		public boolean isEmpty(){
			
			if (this.total==0){
				return true;
			}else
				return false;
		}
		/*public  void main(String[] args) {
			// Inner class to represent Precision , Recall and Total
			// Also note that static is removed here.

			double p=5.4;
			double r=6.3;
			ResultSet result1 =new ResultSet(p,r);
			
			ResultSet result2 =new ResultSet(12.0,50.1);
			System.out.println(result1.total + " " +  result2.total);
			
		}*/

	}

	
}
