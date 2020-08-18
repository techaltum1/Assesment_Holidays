package pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import util.Baseclass;
import util.Configreader;

public class HomePage extends Baseclass {
	Commonmethods  cm= new Commonmethods();
	
	
	private static final WebDriver WebDriverRefrence = null;

	public void home() throws FileNotFoundException, IOException, InterruptedException {
	
		

		int colNum = 1;
		String sheettabname = "My_FirstSheet";	
		driver.get(Configreader.getPropertyValue("url"));
		
		String title = driver.getTitle();
		String title1 = title.replace(",", " ");
		
		String	Reportfilepath ="E:/MyWorkspace/Assignmentproject/excelread.xlsx";
		
		cm.setcelldata("tittle", title1, colNum, Reportfilepath);
			
	 String meta = driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("Content");
			cm.setcelldata("metadescription", meta, colNum, Reportfilepath);
		
		String metar= driver.findElement(By.xpath("//meta[@name='ROBOTS']")).getAttribute("content");
		cm.setcelldata("metarobot", metar, colNum, Reportfilepath);
		
		List<WebElement>radioButton = driver.findElements(By.xpath("//div[contains(@id,'mhSearchBoxFlight')]"));
        //System.out.println(radioButton.size());
        
        driver.findElement(By.xpath("//*[contains(text(),'Round trip')]")).click();
        for(int i=0;i<radioButton.size();i++) {
            System.out.println(radioButton.get(i).getText());
        } 
        if(driver.findElement(By.id("rdRoundTrip")).isSelected()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        //destinationfrom
        WebElement from = driver.findElement(By.xpath("//*[contains(@id,'txtDepartureAirport')]"));
        from.clear();
        from.sendKeys(Configreader.getPropertyValue("From"));
        Thread.sleep(3000);
        WebElement dropdownvalue = driver.findElement(By.xpath("//ul[3]//li[1]//a//span//span"));
        dropdownvalue.click();
        
        //destinationTo
        
        WebElement To = driver.findElement(By.xpath("//*[contains(@id,'txtArrivalAirport')]"));
        To.clear();
        To.sendKeys(Configreader.getPropertyValue("To"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement dropdownvaluedes = driver.findElement(By.xpath("//ul[4]//li[1]//a//span//span"));
        dropdownvaluedes.click();
        driver.findElement(By.xpath("//*[@id='DepartureDt']")).click();
        //date
        
        Date date = new Date();
		int fromDate = date.getDate();
		int futureDate = fromDate + 4;
        List<WebElement> dateList = driver.findElements(By.xpath("//div[contains(@class,'group')]//a[contains(@class, 'datepicker-content')]"));
		//System.out.println(dateList.size());
        for (WebElement we : dateList) {
        	//System.out.println(we.getText());
			
			if (we.getText().trim().equals(String.valueOf(futureDate))) {
				we.click();
				break;
			} 
					}
        driver.findElement(By.xpath("//*[@id='ArrivalDt']")).click();
        Date date1 = new Date();
      		int fromDate1 = date.getDate();
      		int futureDate1 = fromDate1 + 4;
              List<WebElement> dateList1 = driver.findElements(By.xpath("//div[contains(@class,'group')]//a[contains(@class, 'datepicker-content')]"));
      		//System.out.println(dateList1.size());
              for (WebElement we : dateList1) {
      			if (we.getText().trim().equals(String.valueOf(futureDate1))) {
      				we.click();
      				break;
      			} 
      					}
        
        WebElement selectpassenger = driver.findElement(By.xpath("//div[@id='mhSearchBoxFlight']/div[2]/ul/li/div/span[2]/span"));
        selectpassenger.click();
        
        WebElement child = driver.findElement(By.xpath("//*[@id='btChildPlusCount']"));
        child.click();
        
        WebElement infant = driver.findElement(By.xpath("//*[@id='btInfantPlusCount']"));
        infant.click();
        
        WebElement classselect = driver.findElement(By.xpath("//*[@id='lblBusinessClass']"));
        classselect.click();
        
        WebElement searchbtn = driver.findElement(By.xpath("//*[@id='lblSearchFlight']"));
        searchbtn.click();
        
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
       
        
        WebElement option2 = driver.findElement(By.xpath("//ul[@class='filter_list collapse_filter']//li//label//span[@id='lblNonstop']"));							
        option2.click();			
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        	
         
        WebElement departurefilter = driver.findElement(By.xpath("//div[@class='filterDeparture']//ul[@class='filter_list collapse_filter']//li[2]"));
        departurefilter.click();
        
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        jse.executeScript("window.scrollBy(0,500)");
         
         WebElement flightresult= driver.findElement(By.xpath("//div//li[@id='pnlFlightResult3']"));
         String flightresu=flightresult.getText();
          String FR = flightresu.replace(",", " ");

      	String abc = "C:/Users/admin/Desktop/myfiles/reportadi"+ ".csv";
    	  exceldata(FR, abc);
   
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
          driver.findElement(By.xpath("//*[contains(@id,'btnExpander3')]")).click();
         

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         WebElement Flightdetails = driver.findElement(By.xpath("//*[@id='FlightDetails3']"));
         String FD = Flightdetails.getText();
         String FDD = FD.replace(",", " ");
 		
   	  exceldata("FlightDetails:-"+ FD, abc);
      
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        
   	  WebElement Flightfaredetails = driver.findElement(By.xpath("//*[@id='FareDetailTab3']//a"));
   	 jse.executeScript("arguments[0].click()", Flightfaredetails);
   	  String Farede = Flightfaredetails.getText();
   	exceldata("FareDetails:-"+ Farede, abc);
    

    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    //jse.executeScript("window.scrollBy(200,0)");
    
     WebElement Bookticket = driver.findElement(By.xpath("//div[2]//button[@id='Newbook3']"));
     Bookticket.click();
        
	}
	protected static void exceldata(String key, String Reportfile) throws IOException {
		File myfile = new File(Reportfile);
		if (!myfile.exists()) {
			myfile.createNewFile();
		}
		FileWriter writerr = new FileWriter(Reportfile, true);
		BufferedWriter out = new BufferedWriter(writerr);
		out.toString();
		out.write(key);
		out.newLine();
		out.close();
		
	}

/*	protected static void setcelldata(String parameterkey, String object, int colNum, String Reportfilepath)
			throws IOException {
		File src = new File(Reportfilepath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		String sheettabname;
		sheettabname = "My_FirstSheet";
		XSSFSheet sheet1 = wb.getSheet(sheettabname);

		int rowlenth = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		for (int i = 0; i < rowlenth + 1; i++) {
			Row row = sheet1.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {

				if (row.getCell(0).getStringCellValue().equals(parameterkey)) {
					sheet1.getRow(i).createCell(colNum).setCellValue(object.toString());
				}
			}
		}
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
		fout.flush();
		fout.close();

	}
*/
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		Baseclass bc = new Baseclass();
		bc.BrowserInstance();
		HomePage hp = new HomePage();
		hp.home();
		BookingPage Bp = new BookingPage();
		Bp.Bookdetails();

		 driver.quit();
	}

}
