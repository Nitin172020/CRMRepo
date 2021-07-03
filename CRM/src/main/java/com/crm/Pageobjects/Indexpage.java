package com.crm.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Baseclass;


public class Indexpage extends Baseclass {

	@FindBy(xpath="//a[@class='navbar-brand']")	
	WebElement CRMlogo;

	@FindBy(xpath="//input[@name='username']")
	WebElement username;

	@FindBy(xpath="//input[@name='password']")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//a[contains(text(), 'Sign Up')]")
	WebElement sighnUpBtn;
	
	

	public Indexpage()
	{
		
	PageFactory.initElements(driver, this);
	}
	public boolean validateCRMLogo()
	{
		
		return CRMlogo.isDisplayed();
	}

	public String validatePageTitle()
	{
		return driver.getTitle();
	}

	public HomePage loginPage(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	
	
		
	}
	
	


