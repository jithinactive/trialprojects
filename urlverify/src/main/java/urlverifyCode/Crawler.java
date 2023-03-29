package urlverifyCode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Crawler {
	
	WebDriver driver;
	String driverPath = System.getProperty("user.dir")+"/driver/geckodriver.exe";
	String wpurl;
	String url;
	int strCount;
	
	public Crawler(WebDriver driver) {
		this.driver = driver;
	}
    
	public void splitUrl(String url) {
		Pattern pattern = Pattern.compile("[^/]*/");
		Matcher matcher = pattern.matcher(url);
		int count = 0;
		while (matcher.find()) {
		    count++;
		}
		System.out.println(count);
		
if(3<=count) {
	//to remove everthing after domain name
	int a = url.indexOf("/", 10);
	wpurl = url.substring(0, a);
	System.out.println(wpurl);
}else {wpurl=url;}
	}
	
	public void	browserSetup(String url){
		System.setProperty("webdriver.gecko.driver", driverPath);
    	driver = new FirefoxDriver();
		driver.get(url);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void browserSetupSitMap() {
		
//		splitUrl(wpurl);
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
    	driver = new FirefoxDriver();
		driver.get(wpurl+"/page-sitemap.xml");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

	public int crawler() throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	    XSSFSheet sheet = workbook.createSheet("sheet1");// creating a blank sheet
	    File directory = new File("./src/main/resources/SitemapExport");
	    try {
	    FileUtils.cleanDirectory(directory);
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}
		
//		WebElement tag = driver.findElement(By.cssSelector("table#sitemap"));
		List<WebElement> table = driver.findElements(By.tagName("a"));

		
		 //We will iterate through the list and will check the elements in the list.
		strCount = table.size()-2;
		System.out.println("Total links on the Wb Page: " + strCount);
		
//		int i;
  		Cell cell;
  		int rownum = 0;
//	  for(i=0;i<=strCount;i++);
		
	      Iterator<WebElement> iterator = table.iterator();
	      while (iterator.hasNext()) {
	    	  String itrUrl = iterator.next().getText();
//	    	  System.out.println(url);
	    	  
	    		  Row row = sheet.createRow(rownum++);
	            cell = row.createCell(0);
	            
	            cell.setCellValue(itrUrl);
//	            System.out.println(itrUrl);
//	            }   
	        }                   
	         try { 
	            FileOutputStream out = new FileOutputStream(new File(directory+"/ExportSitemap.xlsx")); // file name with path
	            workbook.write(out);
	            out.close();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	         return strCount;
	}  
}
