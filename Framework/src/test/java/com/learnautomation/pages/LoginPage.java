package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
//	This is a new commit message to practice git
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(xpath= "//input[@type='text']") WebElement uname;
	@FindBy(xpath="//input[@name='xoo-el-password']")WebElement pass;
	@FindBy(xpath = "//button[text()='Sign in']") WebElement loginButton;
	
	public void loginToCRM(String userNameApplication,String passwordApplication) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		uname.sendKeys(userNameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();
	}
	
	

}
