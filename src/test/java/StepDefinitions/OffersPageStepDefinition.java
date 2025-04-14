package StepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import Utils.TextContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OffersPageStepDefinition {
public 	WebDriver driver;
public String landingPageProductName;
public String offersPageProductName;
TextContextSetUp textContextSetUp;

    public OffersPageStepDefinition(TextContextSetUp textContextSetUp)
    {
    	this.textContextSetUp=textContextSetUp;
    }
	
	
	@Then("^user searched same shortname (.+) in offers page$")
	public void user_searched_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		
		
		
	   
	
		switchToOffersPage();
		OffersPage offersPage=textContextSetUp.pageObjectManager.getOffersPage(); // creates OffersPage object
		offersPage.searchItem(shortName);
	   
	    Thread.sleep(2000);
	    offersPageProductName= offersPage.getProduct();
	    
}
	
	public void switchToOffersPage()
	{
		
		LandingPage landingPage=textContextSetUp.pageObjectManager.getLandingPage(); // creates landingPage object
		landingPage.selectTopDeals();
		textContextSetUp.genericUtils.switchToChild();
	}
	
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page()
	{
		Assert.assertEquals(offersPageProductName,textContextSetUp.landingPageProductName);
	}
}
