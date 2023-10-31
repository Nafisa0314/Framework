package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
//	Sceenshot,alerts,frames,windows,sync issue,javascript executer
	
	public static String captureSceenshot(WebDriver driver) {
		
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		 to use screenshot path for attachment
		 
		 
		 String screenshotPath= System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getCurrentDateTime()+".png";
		 
		 try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Sceenshot captured ");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot "+e.getMessage());
			e.printStackTrace();
		}
		 return screenshotPath;
		
	}
	public static String getCurrentDateTime() {
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate= new Date();
		return customformat.format(currentDate);
	}

}
