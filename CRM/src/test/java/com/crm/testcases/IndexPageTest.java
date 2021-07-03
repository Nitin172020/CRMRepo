package com.crm.testcases;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.Pageobjects.HomePage;
import com.crm.Pageobjects.Indexpage;
import com.crm.base.Baseclass;
import com.crm.utility.SetupeExtentReport;

import com.crm.utility.AttachScreenShotToReport;




public class IndexPageTest extends Baseclass {

	public Indexpage indexpage;
	public HomePage homepage;
	public AttachScreenShotToReport screenshot ;
	public SetupeExtentReport setupreport; 
	public ExtentTest test;
	
	
	public Logger log;


	public IndexPageTest()
	{
		super();
		
	}
	
	
	/*@BeforeTest
	public void setupLoggingAndReport() {
		
		Logger log=Logger.getLogger(IndexPageTest.class.getName());
		htmlreporter.config().setDocumentTitle("Automation CRMPO");
		htmlreporter.config().setReportName("IndexPageTest Report");
		
	}*/
	
@BeforeTest
public void setup()
{
	screenshot=new AttachScreenShotToReport();
	log=Logger.getLogger(IndexPageTest.class.getName());
	setupreport=new SetupeExtentReport();
}
	@BeforeMethod
	public void launcBrowser()
	{
		launchApp();
		indexpage=new Indexpage();
		//screenshot=new AttachScreenShotToReport();
		//setupreport=new SetupeExtentReport();
		//log=Logger.getLogger(IndexPageTest.class.getName());
		//screenshot=new AttachScreenShotToReport();
		
		
		
	}
	@Test

	public void validateCRMLogoTest() throws IOException, InterruptedException
	{
		log.info("========Creating Test===========");
		
		test=setupreport.createTestReport("validateCRMLogoTest");
		
		log.info("Validating the CRmm logo");
		boolean b=indexpage.validateCRMLogo();
		System.out.println(b);
		Assert.assertEquals(b, true);
		
		Thread.sleep(3000);
		log.info("Taking screen Shot");

	}


	@Test
	public void loginTest() throws Exception
	{
		test=setupreport.createTestReport("loginTest");
		log.info("logging in the application");
		homepage=indexpage.loginPage(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Getting the title of the Home page");
		String homepageTitle=homepage.getHomepageTitle();
		System.out.println("Homepage title is------"+homepageTitle);
		
		Assert.assertEquals(homepageTitle, prop.getProperty("expect_homepage"));
		log.info("Assertin the title of the Home page");
		String screenpth=screenshot.TakeScreenShotforExtent(driver,"CRMLogo");


	}

	@AfterMethod
	public void getResult(ITestResult result) throws InterruptedException, IOException
	{

		if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
            String screenShotPath1=screenshot.TakeScreenShotforExtent(driver, result.getName());
            test.addScreenCaptureFromPath(screenShotPath1);
            
            
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
		
		driver.quit();
	}
	@AfterTest
	public void tearDownReport() throws IOException
	{
		setupreport.endReport();
		
		
	}



}
