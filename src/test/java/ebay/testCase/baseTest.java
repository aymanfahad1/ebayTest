package ebay.testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ebay.pageObjects.itemsPage;
import ebay.pageObjects.landOnPage;

public class baseTest {
	public WebDriver driver;
	public landOnPage landOnPage;
	
	public void startTheBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(alwaysRun = true)
	public ebay.pageObjects.landOnPage landOnPage ()
	{
		startTheBrowser();
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
