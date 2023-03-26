package urlverifyCode;

import java.io.IOException;

import javax.swing.JTextPane;

import urlVerifyUI.UrlTestUI;
import urlVerifyUI.UrlTestUI.AppendTextPane;
//import org.testng.annotations.Test;
import utilities.ExcelUtility;

public class CompareFiles extends UrlTestUI{
	private JTextPane textPane;
	
	int i;
	int count;
	String string1;
	ExcelUtility objutil;
	
	public static final String GREEN = "#00FF00*#";
	public static final String RED = "#FF0000*#";

	public CompareFiles(AppendTextPane textpane) {
		this.atp=textpane;
	}
	
//	@Test
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
				atp.appendText(GREEN+"found url at:"+j);
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
			atp.appendText(RED+"Not found url:"+cellval2+" AtRow:"+i);
		}
//			System.out.println("2row"+i);
			i++;
		}while(i<=row2);
		
	}	
}


