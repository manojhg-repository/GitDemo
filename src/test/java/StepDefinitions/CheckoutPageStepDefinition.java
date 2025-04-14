package StepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import PageObjects.PageObjectManager;
import Utils.TextContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutPageStepDefinition {
	
public 	WebDriver driver;
public String landingPageProductName;
public String offersPageProductName;
TextContextSetUp textContextSetUp;
public PageObjectManager pageObjectManager;
public CheckoutPage checkoutPage;


//Single Responsibility= should perform single activity
//losely coupled= should allow the user to enhance it means easily update code for existing feature
//Page Factory Design pattern

    //1st step
    public CheckoutPageStepDefinition(TextContextSetUp textContextSetUp) {
    	this.textContextSetUp=textContextSetUp;
    	this.checkoutPage=textContextSetUp.pageObjectManager.getCheckoutPage(); // initialization do in constructor to avoid errors
    }

	
    @Then("verify the user has the ability to enter promocode and place the order")
    public void user_has_ability_enter_promocode()
    {
    	
    	Assert.assertTrue(checkoutPage.verifyPrmoButton());
    	Assert.assertTrue(checkoutPage.verifyplaceOrderButton());
    }
	
    @Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout(String name) throws InterruptedException
    {
    	checkoutPage.checkoutItems();
    	Thread.sleep(2000);
    }
	
	
	
}
