package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile {
	FileInputStream fis;
	XSSFWorkbook wb1;
	HashMap<String, String> hasMap;
	@Test
	public void readCredentials() {
		hasMap = new HashMap<String, String>();
				
		// Read Data from Excel file
		try {
			fis = new FileInputStream("C:\\Users\\Nikil\\eclipse-workspace\\RestAssured\\testData\\Datadriven_TestdataCredentials.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// create workbook instance
		try {
			wb1 = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Get access to Sheet 1
		XSSFSheet sheet = wb1.getSheetAt(0);
		// Iteration through each row
		for (int row = 1; row < sheet.getPhysicalNumberOfRows(); row++) {
			XSSFRow rowObj = sheet.getRow(row);
			// Iteration through each cell
			for (int col = 0; col < rowObj.getPhysicalNumberOfCells(); col++) 
			{
				XSSFCell cellObj = rowObj.getCell(col);
				// Retrieving cell value
				String cellValue = cellObj.getStringCellValue();
				System.out.println((cellValue));
			}
		} 
		
		
	}

}
