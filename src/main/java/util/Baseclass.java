package util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Baseclass {

	public static WebDriver driver;

	public   void BrowserInstance() throws FileNotFoundException, IOException  {
	
		/*
		System.setProperty("webdriver.chrome.driver", "E:\\MyWorkspace\\Assignmentproject\\driver\\chromedriver.exe");
	 driver = new ChromeDriver();
		*/

  Configreader.getPropertyValue("browser").equals("chrome");
  System.setProperty("webdriver.chrome.driver", Configreader.getPropertyValue("chromedriverpath"));
	 driver = new ChromeDriver();
	// driver.get(Configreader.getPropertyValue("url"));
	 driver.manage().window().maximize();
	}

	
}


