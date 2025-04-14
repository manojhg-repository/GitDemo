package CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/featuress",glue="StepDefinitions",monochrome=true,
tags="@PlaceOrder or @OffersPage",plugin= {"html:target/cucmber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
    //target is folder name
	//html,json,extent reports
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios(); //calls super class method scenarios() from AbstractTestNGCucumberTests class and return type object
	}// it will run 2 scenarios in 2 browsers at a time [Ex: tom and beet]

}

//tags="@PlaceOrder" if it is mentioned it will run only one otherwise it will run all 3 scenarios at same time
 