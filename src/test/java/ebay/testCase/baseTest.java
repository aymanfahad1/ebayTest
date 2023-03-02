package ebay.testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ebay.pageObjects.itemsPage;
import ebay.pageObjects.landOnPage;

public class baseTest {
	public WebDriver driver;
	public landOnPage landOnPage;
	
	public WebDriver startTheBrowser() throws IOException
	{
		 Properties prop =new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\rashi\\eclipse-workspace\\ebay\\src\\main\\java\\ebay\\resources\\browserName.properties");
		 prop.load(fis);
		 
		 String browserName = prop.getProperty("browser");
		 if(browserName.equalsIgnoreCase("chrome"))
		 {
			 driver = new ChromeDriver();
		 }
		 else if(browserName.equalsIgnoreCase("firefox"))
		 {
			 driver = new FirefoxDriver();
		 }
		 else if(browserName.equalsIgnoreCase("edge"))
		 {
			 driver = new EdgeDriver();
		 }
		 driver.manage().window().maximize();
		 return driver;
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public ebay.pageObjects.landOnPage landOnPage () throws IOException
	{
		driver = startTheBrowser();
		landOnPage = new landOnPage(driver);
		landOnPage.ebayWebsite();
		return landOnPage;
	}
	
	public boolean appleProductTest() throws InterruptedException
	{
		itemsPage it = new itemsPage(driver);
		 if( it.numberOfappleProducts() ==10)
		{
			boolean apple = true;
		}
		return true;
	}
	@AfterMethod(alwaysRun= true)
	public void turnoffBrowser()
	{
		driver.quit();
	}
}
