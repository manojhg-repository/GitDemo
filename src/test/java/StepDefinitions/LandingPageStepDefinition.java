package StepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.PageObjectManager;
import Utils.TextContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageStepDefinition {
	
public 	WebDriver driver;
public String landingPageProductName;
public String offersPageProductName;
TextContextSetUp textContextSetUp;
public PageObjectManager pageObjectManager;
public LandingPage landingPage;


//Single Responsibility= should perform single activity
//losely coupled= should allow the user to enhance it means easily update code for existing feature
//Page Factory Design pattern

    //1st step
    public LandingPageStepDefinition(TextContextSetUp textContextSetUp) {
    	this.textContextSetUp=textContextSetUp;
    	this.landingPage=textContextSetUp.pageObjectManager.getLandingPage(); // creates landingPage object
    }

	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() {
		
		System.out.println(landingPage.getLandingPageTitle());
	  
	   Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));	
	}
	
	@When("^user searched with shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
	// added in TextContextSetUp
	//	pageObjectManager=new PageObjectManager(textContextSetUp.driver);
		
		
		
		landingPage.searchItem(shortName);
	    Thread.sleep(2000);
	    
		textContextSetUp.landingPageProductName= landingPage.getProductName().split("-")[0].trim();
	    System.out.println(textContextSetUp.landingPageProductName +"product name");
	}
	

	@When("added {string} items of the selected product to the cart")
	public void added_items_product(String quantity)
	{
		landingPage.increment(Integer.parseInt(quantity));
		landingPage.clickAddToCart();
	}
	
	
	
	
}
