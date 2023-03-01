package ebay.testMap;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class map {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		
		List<WebElement> listOfcategory = driver.findElements(By.xpath("//div[@class='hl-cat-nav']/ul/li"));
		List<WebElement> listOfitmes = driver.findElements(By.xpath("//div[2]/div/nav[2]/ul/li/a"));
		
		for(int i=0; i<listOfcategory.size(); i++)
		{
			if(listOfcategory.get(i).getText().contains("Electronics"))
			{
				Actions action = new Actions(driver);
				action.moveToElement(listOfcategory.get(i)).build().perform();
				break;
			}
		}
				Thread.sleep(1000);
				for(int j=0; j<listOfitmes.size(); j++)
				{
					if(listOfitmes.get(j).getText().contains("Apple"))
					{
						listOfitmes.get(j).click();
						break;
					}
				}
				
			
		
		Thread.sleep(7000);
		List<WebElement> listOfDevice = driver.findElements(By.xpath("//div[@class='b-visualnav__grid']/a/div[@class='b-visualnav__title']"));
		
		Assert.assertEquals(listOfDevice.size(), 10);
		
		driver.quit();
		
}
}
		


