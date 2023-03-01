package ebay.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ebay.reusable.reusable;

public class itemsPage extends reusable{
	WebDriver driver;
	
	public itemsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//div[@class='b-visualnav__grid']/a/div[@class='b-visualnav__title']")
	 List<WebElement> listOfDevice; 

	public int numberOfappleProducts() throws InterruptedException
	{
		waitforElement(listOfDevice);
		int num= listOfDevice.size();
		return num;
	}
}
