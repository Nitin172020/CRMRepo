package com.crm.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.crm.base.Baseclass;


public class AttachScreenShotToReport extends Baseclass {
	WebDriver driver;
	
	public String TakeScreenShotforExtent(WebDriver driver, String Screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"/Screenshots/" + Screenshotname +".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	}

}
