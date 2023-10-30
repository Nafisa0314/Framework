package com.learnautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {
	
	@Test
	public void test1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver4\\chromedriver-118.0.5993.70.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://trcrm.com/login/en");
		driver. manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("_username")).sendKeys("Selenium_50");
		driver.findElement(By.name("_password")).sendKeys("Abcd@123456");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

}
