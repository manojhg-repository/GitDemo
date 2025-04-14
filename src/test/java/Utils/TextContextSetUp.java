package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TextContextSetUp {
// sharing variables
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	//2nd step
	public TextContextSetUp() throws IOException  //constructor will invoked in LandingPageStepDefinition Class by this statement (TextContextSetUp textContextSetUp)
	{
		//creating an object of TestBase class to call method driverManager() and this method provides driver
	    testBase=new TestBase();
		pageObjectManager=new PageObjectManager(testBase.driverManager());
		//testBase.driverManager()-> it will return the chrome driver and gives driver to PageObjectManager class
		
		genericUtils=new GenericUtils(testBase.driverManager());
		//passing driver to GenericUtils class
		
	}
}
