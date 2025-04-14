package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	public WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By topDealsLink=By.linkText("Top Deals");
	By search=By.xpath("//input[@type='search']");
	By SelectedItem=By.cssSelector("tr td:nth-child(1)");
	
	public void selectTopDeals() {
	driver.findElement(topDealsLink).click();
	}
	
	public void searchItem(String name) 
	{
		driver.findElement(search).sendKeys(name);
    }
	
	public String getProduct() 
	{
	
		return driver.findElement(SelectedItem).getText();
    }
	
	

}
