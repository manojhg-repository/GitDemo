package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By cartBag=By.xpath("//img[@alt='Cart']");
	By checkoutButton=By.xpath("//button[.='PROCEED TO CHECKOUT']");
	By prmoButton=By.xpath("//button[@class='promoBtn']");
	By placeOrderButton=By.xpath("//button[.='Place Order']");
	 
	public void checkoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean verifyPrmoButton()
	{
		return driver.findElement(prmoButton).isDisplayed();
	}
	
	public boolean verifyplaceOrderButton()
	{
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
}
