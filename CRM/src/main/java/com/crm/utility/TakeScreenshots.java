package com.crm.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.base.Baseclass;

public class TakeScreenshots extends Baseclass {
	
	public String takeScreenShots(WebDriver driver,String filename) throws IOException
	{
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File source= takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+ "\\Screenshots\\" +filename+ "_" + ".png";
	
	
	try {
		FileUtils.copyFile(source, new File(destination));
	} catch (Exception e) {
		e.getMessage();
	}
	return destination;
	
	
	
	
 
}
}
