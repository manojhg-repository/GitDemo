package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//contains Webdriver it will pass to textContextSetUp class
//TestBase -> TextContextSetUp -> PageObjectManager -> LandingPage -> OffersPage

public class TestBase 
{
	public WebDriver driver;
	
	
	//3rd step
	public WebDriver driverManager() throws IOException
	{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
	    Properties prop=new Properties();
		prop.load(fis); //expects inputstream object and to read properties file
		String url=prop.getProperty("QAUrl");
		String browser_Properties=prop.getProperty("browser");
		String browser_Maven=System.getProperty("browser"); //through commandline -dbrowser
		//condition ? value_if_true : value_if_false;
		
		String browser= browser_Maven!=null? browser_Maven : browser_Properties;
		
		if(driver==null)
		{ 
			if(browser.equalsIgnoreCase("chrome"))
			{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
	    driver=new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(url);
		    }
		}
	    return driver;
	  
	}

}
