package pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import util.Configreader;

public class BookingPage extends HomePage {
	
	
	public void Bookdetails() throws FileNotFoundException, IOException {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//Adult passenger details		
		Select gender = new Select(driver.findElement(By.xpath("(//*[@id='ddlTitles0'])")));
		gender.selectByValue("Mr");
		
		WebElement firstnameadult = driver.findElement(By.id("txtFirstName0"));
		firstnameadult.sendKeys(Configreader.getPropertyValue("Firstname"));
		
		WebElement lastnameadult = driver.findElement(By.id("txtLastName0"));
		lastnameadult.sendKeys(Configreader.getPropertyValue("Lastname"));
		
		Select date = new Select(driver.findElement(By.xpath("//*[@id='ddlDay0']")));
		date.selectByVisibleText("10");
		Select month = new Select(driver.findElement(By.xpath("//*[@id='ddlMonth0']")));
		month.selectByVisibleText("08");

		Select year = new Select(driver.findElement(By.xpath("//*[@id='ddlYear0']")));
		year.selectByVisibleText("1990");
		
		WebElement country= driver.findElement(By.xpath("//div//ul//li//div[@class='selectlist']//select[@id='ddlNationality0']"));
		Select country1 =   new Select(country);
		country1.selectByVisibleText("Algeria");
		
	    WebElement passportno = driver.findElement(By.xpath("//*[@id='txtPassportNo0']"));
	    passportno.sendKeys(Configreader.getPropertyValue("Passportadult"));
	    
	    Select countryofissue = new Select(driver.findElement(By.xpath("//*[@id='ddlPassportIssuedCountries0']")));
	    countryofissue.selectByValue("dz");
	    
	    WebElement issuecity = driver.findElement(By.xpath("//*[@id='txtPassportIssueCity0']"));
	    issuecity.sendKeys("test");
	    
	    Select passportissuedate = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueDay0']")));
	    passportissuedate.selectByVisibleText("10");
	    
	    Select passportissuemon = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueMonth0']")));
	    passportissuemon.selectByVisibleText("08");
	    

	    Select passportissueyear = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueYear0']")));
	    passportissueyear.selectByVisibleText("2012");
	    
	    Select passportexpiryday = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryDay0']")));
	    passportexpiryday.selectByVisibleText("10");
	    
	    Select passportexpirymonth = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryMonth0']")));
	    passportexpirymonth.selectByVisibleText("08");
	    

	    Select passportexpiryyear = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryYear0']")));
	    passportexpiryyear.selectByVisibleText("2025");


	    
	    Select countryofresidence = new Select(driver.findElement(By.xpath("//*[@id='ddlCountryOfResidence0']")));
	    countryofresidence.selectByValue("dz");
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("E:/MyWorkspace/Assignmentproject/Screenshot/adult.png"));   
	    
	 //child passenger details
	    
		Select genderchild = new Select(driver.findElement(By.xpath("(//*[@id='ddlTitles1'])")));
		genderchild.selectByValue("Mrs");
		
		WebElement firstnamechild = driver.findElement(By.id("txtFirstName1"));
		firstnamechild.sendKeys(Configreader.getPropertyValue("Firstnamechild"));
		
		WebElement lastnamechild = driver.findElement(By.id("txtLastName1"));
		lastnamechild.sendKeys(Configreader.getPropertyValue("Lastnamechild"));
		
		File cFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(cFile, new File("E:/MyWorkspace/Assignmentproject/Screenshot/child2.png"));
		
		Select date1 = new Select(driver.findElement(By.xpath("//*[@id='ddlDay1']")));
		date1.selectByVisibleText("10");
		Select month1 = new Select(driver.findElement(By.xpath("//*[@id='ddlMonth1']")));
		month1.selectByVisibleText("08");

		Select year1 = new Select(driver.findElement(By.xpath("//*[@id='ddlYear1']")));
		year1.selectByVisibleText("2014");
		
		WebElement country11= driver.findElement(By.xpath("//div//ul//li//div[@class='selectlist']//select[@id='ddlNationality1']"));
		Select country2 =   new Select(country11);
		country2.selectByVisibleText("Algeria");
		   
	    
	    WebElement passportno1 = driver.findElement(By.xpath("//*[@id='txtPassportNo1']"));
	    passportno1.sendKeys(Configreader.getPropertyValue("Passportchildnum"));
	    
	    Select countryofissue1 = new Select(driver.findElement(By.xpath("//*[@id='ddlPassportIssuedCountries1']")));
	    countryofissue1.selectByValue("dz");
	    
	    WebElement issuecity1 = driver.findElement(By.xpath("//*[@id='txtPassportIssueCity1']"));
	    issuecity1.sendKeys("test1");
	    
	    Select passportissuedate1 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueDay1']")));
	    passportissuedate1.selectByVisibleText("10");
	    
	    Select passportissuemon1 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueMonth1']")));
	    passportissuemon1.selectByVisibleText("08");
	    

	    Select passportissueyear1 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueYear1']")));
	    passportissueyear1.selectByVisibleText("2015");
	    
	    Select passportexpiryday1 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryDay1']")));
	    passportexpiryday1.selectByVisibleText("10");
	    
	    Select passportexpirymonth1 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryMonth1']")));
	    passportexpirymonth1.selectByVisibleText("08");
	    

	    Select passportexpiryyear1 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryYear1']")));
	    passportexpiryyear1.selectByVisibleText("2025");


	    Select countryofresidence1 = new Select(driver.findElement(By.xpath("//*[@id='ddlCountryOfResidence1']")));
	    countryofresidence1.selectByValue("dz");
	    File scrrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrrFile, new File("E:/MyWorkspace/Assignmentproject/Screenshot/child.png"));
//@infant details
		Select genderinfant = new Select(driver.findElement(By.xpath("(//*[@id='ddlTitles2'])")));
		genderinfant.selectByValue("Mrs");
		
		WebElement firstnameinfant = driver.findElement(By.id("txtFirstName2"));
		firstnameinfant.sendKeys(Configreader.getPropertyValue("Firstnameinfant"));
		
		WebElement lastnameinfant = driver.findElement(By.id("txtLastName2"));
		lastnameinfant.sendKeys(Configreader.getPropertyValue("Lastnameinfant"));
		
		File ccFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(ccFile, new File("E:/MyWorkspace/Assignmentproject/Screenshot/child3.png"));
		
		Select date2 = new Select(driver.findElement(By.xpath("//*[@id='ddlDay2']")));
		date2.selectByVisibleText("20");
		Select month2 = new Select(driver.findElement(By.xpath("//*[@id='ddlMonth2']")));
		month2.selectByVisibleText("08");

		Select year2 = new Select(driver.findElement(By.xpath("//*[@id='ddlYear2']")));
		year2.selectByVisibleText("2019");
		
		WebElement country3= driver.findElement(By.xpath("//div//ul//li//div[@class='selectlist']//select[@id='ddlNationality2']"));
		Select country4 =   new Select(country3);
		country4.selectByVisibleText("Algeria");
		
	    WebElement passportno2 = driver.findElement(By.xpath("//*[@id='txtPassportNo2']"));
	    passportno2.sendKeys(Configreader.getPropertyValue("Passportchildnum"));
	    
	    Select countryofissue2 = new Select(driver.findElement(By.xpath("//*[@id='ddlPassportIssuedCountries2']")));
	    countryofissue2.selectByValue("dz");
	    
	    WebElement issuecity2 = driver.findElement(By.xpath("//*[@id='txtPassportIssueCity2']"));
	    issuecity2.sendKeys("testing");
	    
	    Select passportissuedate2 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueDay2']")));
	    passportissuedate2.selectByVisibleText("01");
	    
	    Select passportissuemon2 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueMonth2']")));
	    passportissuemon2.selectByVisibleText("01");
	    

	    Select passportissueyear2 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportIssueYear2']")));
	    passportissueyear2.selectByVisibleText("2020");
	    
	    Select passportexpiryday2 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryDay2']")));
	    passportexpiryday2.selectByVisibleText("20");
	    
	    Select passportexpirymonth2 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryMonth2']")));
	    passportexpirymonth2.selectByVisibleText("08");
	    

	    Select passportexpiryyear2 = new Select (driver.findElement(By.xpath("//*[@id='ddlPassportExpiryYear2']")));
	    passportexpiryyear2.selectByVisibleText("2027");


	    Select countryofresidence2 = new Select(driver.findElement(By.xpath("//*[@id='ddlCountryOfResidence2']")));
	    countryofresidence2.selectByValue("dz");
	    File sccrrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(sccrrFile, new File("E:/MyWorkspace/Assignmentproject/Screenshot/infant.png"));

	    Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);             
	    try {                 
	    ImageIO.write(screenshot.getImage(),"PNG",new File("E:/MyWorkspace/Assignmentproject/Screenshot/screen.PNG"));             
	  } catch (IOException e) {                                  
	    e.printStackTrace();             }
	    
	}
	

}
