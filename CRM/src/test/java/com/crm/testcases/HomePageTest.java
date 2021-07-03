/**
 * 
 */
package com.crm.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
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
import com.crm.Pageobjects.NewContactPage;
import com.crm.base.Baseclass;
import com.crm.utility.AttachScreenShotToReport;
import com.crm.utility.SwitchFrame;

/**
 * @author admin
 *
 */
public class HomePageTest extends Baseclass  {
	
	public Indexpage indexpage;
	public HomePage homepage;
	public NewContactPage newContactpage;
	public SwitchFrame switchFrame;
	public ExtentHtmlReporter htmlreport;
	public ExtentReports extentreport;
	public ExtentTest test;
	public AttachScreenShotToReport screenshot;
	public Logger log;
	
	
	public HomePageTest()
	{
		
		super();
	}
	
	@BeforeTest
	public void setupReportAndReport()
	{
		htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/HomepageTest.html");
		htmlreport.config().setDocumentTitle("Automating CRMPO");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("HomepageTest");
		extentreport=new ExtentReports();
		extentreport.attachReporter(htmlreport);
		extentreport.setSystemInfo("OS", "Windows 7");
		extentreport.setSystemInfo("Hostname", "admin-PC");
		extentreport.setSystemInfo("Tester Name", "Nitin");
		extentreport.setSystemInfo("Browser Name", "Chrome");
		log=Logger.getLogger(HomePageTest.class.getName());


		
	}
	@BeforeMethod
	public void setup()
	{
		log.info("Launching the app");
		launchApp();
		indexpage=new Indexpage();
		homepage=indexpage.loginPage(prop.getProperty("username"), prop.getProperty("password"));
		switchFrame=new SwitchFrame() ;
		screenshot=new AttachScreenShotToReport();
	}
	
	@Test(groups= {"Sanity"})
	public void verifyHomePageTitleTest()
	{
		log.info("=========Starting the Test:verifyHomePageTitleTest===========");
		log.info("Creating the test for Extent Reports");
		test=extentreport.createTest("verifyHomePageTitleTest");
		log.info("Getting the title of the Homepage");
		String act_title=homepage.getHomepageTitle();
		log.info("Assertig the title of the HomePage");
		Assert.assertEquals(act_title, prop.getProperty("expect_homepage"));
		log.info("=========Ending the Test:verifyHomePageTitleTest===========");
		
	}
	
	@Test(groups= {"Sanity", "Smoke"})
	public void verifyHomepageUserTest() throws InterruptedException
	{
		log.info("=========Starting the Test:verifyHomepageUserTest===========");
		log.info("Creating the test for Extent Reports");
		test=extentreport.createTest("verifyHomepageUserTest");
		switchFrame.switchFrame("mainpanel");
		
		boolean b=homepage.verifyHomepageUserName();
		
		System.out.println(b);
		Assert.assertTrue(b);
		log.info("=========Ending the Test:verifyHomepageUserTest===========");
		//Assert.assertEquals(login_username, "User: Demo User");
	}
	
	
	
	@AfterTest
	public void tearDownReport()
	{
		extentreport.flush();
	}
	

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
            //String screenShotPath=screenshot.TakeScreenShotforExtent(driver, result.getName());
            //test.addScreenCaptureFromPath(screenShotPath);
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

}
