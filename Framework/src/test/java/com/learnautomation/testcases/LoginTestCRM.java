package com.learnautomation.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.Helper;




public class LoginTestCRM extends BaseClass{
	
@Test(priority=1)
public void loginAPP() {
	logger = report.createTest("Login to CRM");
	
	LoginPage loginPage =PageFactory.initElements(driver,LoginPage.class);
	
	logger.info("Starting Application");
	
	loginPage.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
	
	logger.pass("Login success");
	
//	Helper.captureSceenshot(driver);
//	if it fails it's not gonna capture screenshot, to capture it when it fails creating tearDownMethod() in the BaseClass
	
	
	   
}
@Test(priority=2)
public void loginAPP1() {
	logger = report.createTest("Logout");
	
	logger.fail("Logout failed");
	
//	if it fails it's not gonna capture screenshot, to capture it when it fails creating tearDownMethod() in the BaseClass
	
	
	
}

}
