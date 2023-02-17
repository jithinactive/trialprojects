package urlverify;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class CompareFiles{
	@Test
	public void excelcompare() throws IOException {
		
		ExcelUtility objutil = new ExcelUtility();
		int i;
		int j=0;

		int row1 = objutil.rowlimits1();
		int col1 = objutil.collimits1();
		int row2 = objutil.rowlimits2();
		int col2 = objutil.collimits2();
		String cellval1;
		String cellval2;
		
		for(i=0; i<row1; i++) {
			
			
			cellval1 = ExcelUtility.getCellData1(i, j);
			cellval2 = ExcelUtility.getCellData2(i, j);
			System.out.println(cellval1 + "&" + cellval2);
			if(cellval1 != cellval2) {
				System.out.println("cell mismatch at row" + (i+1) + "column" + (j+1));
			}
		}
		
	}

}
