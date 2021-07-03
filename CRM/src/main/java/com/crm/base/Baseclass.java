/**
 * 
 */
package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.utility.AttachScreenShotToReport;

/**
 * @author Nitin
 * This class is the base class which will be used by all the classes
 *
 */
public class Baseclass {
	public static Properties prop;
	public static WebDriver driver;
	
	public Baseclass()
	{
		try {
	prop=new Properties();
	FileInputStream ip=new FileInputStream("D:\\eclipse data\\CRM\\Configuration\\config.properties");
	prop.load(ip);
		}catch(FileNotFoundException e) 
			{
			System.out.println("File NOt Found error");
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
			}

	public static void launchApp()
	{
		String browser_name=prop.getProperty("browsername");
		if(browser_name.contains("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\eclipse data\\CRM\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}else
			if(browser_name.equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.firefox.driver", "D:\\eclipse data\\CRM\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		}
	

}
