package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up reports and Test is getting ready ", true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime() +".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test can be Started ", true);
	} 
		
	@BeforeClass	
	public void setup() {
		
		Reporter.log("Trying to start Browser and Getting application ready ", true);
		driver= BrowserFactory.startApplication(driver, config.getBrowser(),config.getStagingURL());
		Reporter.log("Browser and applicatiom is up and running ", true);
	}
	
	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(driver); 
	}
	

@AfterMethod
//to run it after every testcase,to take screenshot even after test fail
public void tearDownMethod(ITestResult result) throws IOException{
	if(result.getStatus()==ITestResult.FAILURE) {		
//		Helper.captureSceenshot(driver);
				
//		now we want to attach the screenshot whenever my test fails, we will write Helper.capture Screenshot below
		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureSceenshot(driver)).build());	
	}else if(result.getStatus()==ITestResult.SUCCESS) {
		logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureSceenshot(driver)).build());
	}
	else if (result.getStatus()==ITestResult.SKIP) {
		logger.skip("Test skipped",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureSceenshot(driver)).build()); 
		}
	report.flush();
	Reporter.log("Test Completed >>>> Reports generated", true);
}



}
