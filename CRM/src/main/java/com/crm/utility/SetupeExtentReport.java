package com.crm.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.base.Baseclass;


public class SetupeExtentReport extends Baseclass{
	
	public ExtentHtmlReporter htmlreport;
	public  ExtentReports report;
	public ExtentTest test1;
	
	
	public SetupeExtentReport()
	{
		htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/myReport.html");
		htmlreport.config().setDocumentTitle("Automating CRMPO");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("MyReport1");
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows 7");
		report.setSystemInfo("Hostname", "admin-PC");
		report.setSystemInfo("Tester Name", "Nitin");
		report.setSystemInfo("Browser Name", "Chrome");
	}
	
	public ExtentTest createTestReport(String testName)
	{
		 return report.createTest(testName);
	}
	
	
	
	public void endReport()
	{
		report.flush();
	}
	
	

}
