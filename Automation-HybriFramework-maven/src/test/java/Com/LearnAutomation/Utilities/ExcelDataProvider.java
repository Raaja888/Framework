package Com.LearnAutomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		
		File src = new File("./TestData/TestData.xlsx");
		
		try 
		
		{
			FileInputStream fis = new FileInputStream(src);
			  wb = new XSSFWorkbook(fis);
		}
		
		  catch (IOException e) 
		{
     	   System.out.println("unable to read Excel file" + e.getMessage());
			
		}		
	}
	
	
   public String getStringData(String sheetName, int row,int column) 
   
   { 
	   return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
   }
   
   public String getStringData(int sheetindex,int row,int column)
   {
	   return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
   }
   public double getNumnericData(String sheetname,int row,int column)
   {
	   return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
   }	
}



