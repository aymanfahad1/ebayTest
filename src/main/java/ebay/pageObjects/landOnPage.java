package ebay.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ebay.reusable.reusable;

public class landOnPage extends reusable {
	WebDriver driver;
	
	public landOnPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[@class='hl-cat-nav']/ul/li")
	List<WebElement> listOfCategory;
	@FindBy(xpath = "//div[2]/div/nav[2]/ul/li/a")
	List<WebElement> listOfitmes;
	@FindBy(xpath ="//nav/ul/li/a")
	WebElement itemsOnCategory;
	
	public void ebayWebsite()
	{
		driver.get("https://www.ebay.com/");
	}
	public void lookForCategory(String category)
	{
		for(int i=0; i<listOfCategory.size(); i++)
		{
			if(listOfCategory.get(i).getText().contains(category))
			{
				Actions action = new Actions(driver);
				action.moveToElement(listOfCategory.get(i)).build().perform();
				break;
			}
		}
	}
	public void lookForItem(String productName) throws InterruptedException
	{
		waitforElement(itemsOnCategory);
		
		for(int j=0; j<listOfitmes.size(); j++)
		{
			if(listOfitmes.get(j).getText().contains(productName))
			{
				listOfitmes.get(j).click();
				break;
			}
		}
	}
	
	
}
