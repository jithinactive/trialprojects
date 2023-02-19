package urlverify1;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class CompareFiles{
	
	int i;
	
	int count;
	ExcelUtility objutil;
	
	public static void main(String[] args) {
		
	}
	@Test
	public void excelcompare() throws IOException {
		
		objutil = new ExcelUtility();
		

		int row1 = objutil.rowlimits1();
//		int col1 = objutil.collimits1();
		int row2 = objutil.rowlimits2();
//		int col2 = objutil.collimits2();
		String cellval1;
		String cellval2;
//		System.out.println(row1);
//		System.out.println("row2:"+row2);
		
		
		
//		System.out.println(cellval1);
		
		do {
			cellval2 = ExcelUtility.getCellData2(i, 0);
//			System.out.println(cellval2);
			int j=0;
			count=0;
			do {
				
				cellval1 = ExcelUtility.getCellData1(j, 0);
//				System.out.println(cellval1);
			if(cellval1.equals(cellval2)) {
				System.out.println("found url at:"+j);
				j++;
				count++;
				}
			else {
				j++;
//				count++;
//				System.out.println("cell mismatch at row" + (j+1) + "column" + (0+1));
//				System.out.println("&" + cellval1);
			}
			
			}while(j<row1);
//			System.out.println("afterRow1: "+j);
//			System.out.println("count :"+count);
			if(count!=1) {
			System.out.println("Not found url:"+cellval2+" AtRow:"+i);
		}
//			System.out.println("2row"+i);
			i++;
		}while(i<=row2);
		
	}
}

