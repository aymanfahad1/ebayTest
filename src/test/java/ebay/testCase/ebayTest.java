package ebay.testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ebay.pageObjects.itemsPage;
import ebay.pageObjects.landOnPage;

public class ebayTest extends baseTest {
	
	@Test(groups ="test1")
	public void categorySearch() throws InterruptedException
	{
		landOnPage.lookForCategory("Electronics");
		landOnPage.lookForItem("Apple");
		
	}
	
	@Test
	public void applePage() throws InterruptedException
	{
		categorySearch();
		Assert.assertTrue(appleProductTest());
	}
}
