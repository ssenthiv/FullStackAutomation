package collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {
	
	@SuppressWarnings("deprecation")
	public void readExcel(String name){
		Workbook workbook;
		Sheet sheet;
		Row row;
		Cell cell;
		workbook = createWorkbook(name);
		sheet = workbook.getSheet("Sheet1");
		int rowSize = sheet.getLastRowNum();
		
		System.out.println("Row count =" + rowSize);
		for (int i=0;i< rowSize+1;i++){
			
			row=sheet.getRow(i);
			int colSize=row.getLastCellNum();
			//System.out.println("Col size : "+colSize);
			for (int j=0; j<colSize ;j++){
				
				cell=row.getCell(j);
				if (cell.getCellType()==cell.CELL_TYPE_STRING){
				System.out.printf("%10s",cell.getStringCellValue()+ " ");
				}
				/*
				if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
					System.out.print(cell.getNumericCellValue()+" ");
					}
				*/
			}
			System.out.println();
		}
		
			
		
	}
	public Workbook createWorkbook(String fileName){
		FileInputStream fis;
		Workbook wb=null;
		try {
			fis = new FileInputStream(fileName);
		
		String strExt =fileName.split("\\.")[1];
		
		
		switch(strExt) {
		
		case "xlsx" :
						wb=new XSSFWorkbook(fis);
						break;
		case "xls" :
						wb=new HSSFWorkbook(fis);
						break;
		default :
					System.out.println("Invalid Excel format");
					break;
		}
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		
		return wb;
	}
	public static void main(String[] args){
		
		ExcelHandling eh=new ExcelHandling();
		//System.out.println("src\\main\\resources\\inputData\\Expected.xlsx".split("\\.")[1]);
		eh.readExcel("src\\main\\resources\\inputData\\Expected.xlsx");
		//eh.readExcel("src\\main\\resources\\inputData\\Actual.xls");
	}

}
