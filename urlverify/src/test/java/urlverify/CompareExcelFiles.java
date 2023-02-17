package urlverify;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CompareExcelFiles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "ExportExcel.xlsx");
        FileInputStream file2 = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources" + "/ExportExcel2.xlsx");
        
        XSSFWorkbook ExcelBook1;
        XSSFWorkbook ExcelBook2;
    	XSSFSheet ExcelSheet1;
    	XSSFSheet ExcelSheet2;
    	
    	ExcelBook1 = new XSSFWorkbook(file1);
    	ExcelBook2 = new XSSFWorkbook(file2);
    	
    	ExcelSheet1 = ExcelBook1.getSheetAt(0);
    	ExcelSheet2 = ExcelBook2.getSheetAt(0);
    	
    	int rowmax1 = ExcelSheet1.getLastRowNum() + 1;
    	int colmax1 = ExcelSheet1.getRow(0).getLastCellNum();
    	
    	int rowmax2 = ExcelSheet2.getLastRowNum() + 1;
    	int colmax2 = ExcelSheet2.getRow(0).getLastCellNum();
    	
    	int i=0;
    	int j=0;
    	XSSFCell cellval1;
    	XSSFCell cellval2;
    	
    	for(i=0; i<rowmax1; i++) {
    	cellval1 = ExcelSheet1.getRow(i).getCell(0);
    	cellval2 = ExcelSheet1.getRow(i).getCell(0);
    	if(cellval1 != cellval2) {
    		System.out.println("Data mismatch in row" + i + "column" + "1");
    	}
    	
    	}
	}

}
