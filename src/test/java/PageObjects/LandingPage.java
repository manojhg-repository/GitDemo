package PageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By search=By.xpath("//input[@type='search']");
	By productName=By.cssSelector("h4.product-name");
	By topDealsLink=By.linkText("Top Deals");
	By increment=By.xpath("//a[@class='increment']");
	By addToCart=By.xpath("//button[.='ADD TO CART']");
	
	public void searchItem(String name) 
	{
		
	driver.findElement(search).sendKeys(name);
    }
	
	public String getProductName() 
	{
		return driver.findElement(productName).getText();
	}

	
	public void selectTopDeals() {
		driver.findElement(topDealsLink).click();
		}
	
	public @Nullable String getLandingPageTitle()
	{
	 return	driver.getTitle();
	 
	}
	
	public void increment(int quantity)
	{
		int i=quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	public void clickAddToCart()
	{
		driver.findElement(addToCart).click();
	}
}
