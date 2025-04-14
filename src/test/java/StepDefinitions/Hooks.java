package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TextContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	public TextContextSetUp textContextSetUp;
	
	public Hooks(TextContextSetUp textContextSetUp)
	{
		this.textContextSetUp=textContextSetUp;
	}
	
	@After //after every scenario
	public void afterScenario() throws IOException
	{
		textContextSetUp.testBase.driverManager().quit();
		//driver.quit(); above to clear browser
	}
	
	@AfterStep //after every step of the scenario
	public void addScreenshot(Scenario scenario) throws IOException
	{
		
		WebDriver driver=textContextSetUp.testBase.driverManager();
		if(scenario.isFailed())
		{
		 File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   byte[] filecontent= FileUtils.readFileToByteArray(sourcepath);
		   scenario.attach(filecontent, "image/png", "image");
		}
	}

}
