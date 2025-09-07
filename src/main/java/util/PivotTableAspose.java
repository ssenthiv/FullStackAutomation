/* ====================================================================
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ==================================================================== */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.aspose.cells.PivotField;
import com.aspose.cells.PivotFieldCollection;
import com.aspose.cells.PivotFieldType;
import com.aspose.cells.PivotTable;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;


public class PivotTableAspose {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
        	
        	// Create an object of File class to open xlsx file
    		//File file = new File("sample-pivottbale.xlsx");
    		//File file = new File("Benchmarking Dashboard.xlsx");
    		
    		// Create an object of FileInputStream class to read excel file
    		//FileInputStream inputStream = new FileInputStream(file);

    		

        Workbook wb = new Workbook("C:\\Softwares\\Working\\Workspace\\FullStackAutomation\\" +"Benchmarking Dashboard.xlsx")	;
            //XSSFSheet sheet = wb.getSheet("Sheet");
        	//Worksheet sheet = wb.getWorksheets().get("Spend per Ton");
        	Worksheet sheet = wb.getWorksheets().get("new");
            PivotTable pivotTable=sheet.getPivotTables().get(0);
            
           
           
          
            System.out.println("Page label = " +pivotTable.getPageFields().getCount());
            System.out.println("Col label = " +pivotTable.getColumnFields().getCount());
            System.out.println("Row Field = " + pivotTable.getRowFields().getCount());
            System.out.println("Base label = " +pivotTable.getBaseFields().getCount());
            System.out.println("Data label = " +pivotTable.getDataFields().getCount());
            System.out.println("Filter = " +pivotTable.getPivotFilters().getCount());
            
            // System.out.println("Data label = " +pivotTable.getSource().toString());
            PivotFieldCollection pFieldCol=null;
            pFieldCol=pivotTable.getDataFields();
            
            for (int i=0; i< pFieldCol.getCount(); i++ ) {
            	/*System.out.println("Name : " +pFieldCol.get(i).getName());
            	System.out.println("Drag to col : " +pFieldCol.get(i).dragToColumn());
            	System.out.println("Drag to Hide : " +pFieldCol.get(i).dragToHide());
            	System.out.println("Drag to page : " +pFieldCol.get(i).dragToPage());*/
            	//System.out.println("Drag to Row : " +pFieldCol.get(i).dragToRow());
            	//pFieldCol.get(i).dragToRow();
            }
            
            pivotTable.addFieldToArea(PivotFieldType.ROW, 0);
            pivotTable.addFieldToArea(PivotFieldType.COLUMN, 1);
            pivotTable.calculateData();
            //pivotTable.getDataFields()
            /*PivotField pivotField=pivotTable.getPageFields().get(0);
            
            pivotField.dragToRow();
            pivotTable.calculateData();
            pivotTable.calculateRange();
           */ 
            
            System.out.println("Page label = " +pivotTable.getPageFields().getCount());
            System.out.println("Col label = " +pivotTable.getColumnFields().getCount());
            System.out.println("Row Field = " + pivotTable.getRowFields().getCount());
            System.out.println("Base label = " +pivotTable.getBaseFields().getCount());
            System.out.println("Data label = " +pivotTable.getDataFields().getCount());
            System.out.println("Filter = " +pivotTable.getPivotFilters().getCount());
            
            wb.save("C:\\Softwares\\Working\\Workspace\\FullStackAutomation\\" +"Modified Dashboard.xlsx");
           // System.out.println("ColField = " + pivotTable.getRowFields().get(0).getName());
            
            //XSSFPivotCache pCache = pivotTable.getPivotCache();
            
           
            
        

            /*try (FileOutputStream fileOut = new FileOutputStream("ooxml-pivottable.xlsx")) {
                wb.write(fileOut);
            }*/
        }catch (Exception e){
        
        	e.printStackTrace();
        }
    }

    }
