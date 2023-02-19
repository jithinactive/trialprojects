package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook workbook1;
	private static XSSFWorkbook workbook2;
	private static XSSFSheet sheet1;
	private static XSSFSheet sheet2;
	
//	FileInputStream file1 = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "ExportExcel.xlsx");
	
	public static String getCellData1(int RowNum1, int ColNum1) throws IOException {
		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "ExportExcel.xlsx");
		
		workbook1 = new XSSFWorkbook(file1);
		
		sheet1 = workbook1.getSheetAt(0);
		
		
        
		DataFormatter formatter = new DataFormatter();
		return
		formatter.formatCellValue(sheet1.getRow(RowNum1).getCell(ColNum1));
		
		
		
		
	}
	
	public static String getCellData2(int RowNum2, int ColNum2) throws IOException {
	
		FileInputStream file2 = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "ExportExcel2.xlsx");
		workbook2 = new XSSFWorkbook(file2);
		sheet2 = workbook2.getSheetAt(0);
		
		DataFormatter formatter = new DataFormatter();
		return
		formatter.formatCellValue(sheet2.getRow(RowNum2).getCell(ColNum2));


	}
	
	public int rowlimits1() throws IOException {
		
		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "ExportExcel.xlsx");
		
		workbook1 = new XSSFWorkbook(file1);
		
		sheet1 = workbook1.getSheetAt(0);
		int rowmax1 = sheet1.getLastRowNum();

	
		return rowmax1;
	}
	
	public static int collimits1() {
		int colmax1 = sheet1.getRow(0).getLastCellNum();
		return colmax1;
	}
	
	public int rowlimits2() throws IOException {
		FileInputStream file2 = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "ExportExcel2.xlsx");
		workbook2 = new XSSFWorkbook(file2);
		sheet2 = workbook2.getSheetAt(0);
		int rowmax2 = sheet2.getLastRowNum();
		
		return rowmax2;
	}
	
	public static int collimits2() {
		int colmax2 = sheet2.getRow(0).getLastCellNum();
		return colmax2;
	}
}
