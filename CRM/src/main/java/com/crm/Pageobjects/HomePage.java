package com.crm.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.Baseclass;

public class HomePage extends Baseclass {
	
	@FindBy(xpath="//td[contains(text(), 'User: Demo User')]")
	WebElement UsernameText;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactstab;	
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContact;
	
	public HomePage()
	{
		
		PageFactory.initElements(driver, this);
	}

	
	public boolean verifyHomepageUserName()
	{
		
		return UsernameText.isDisplayed();
	}
	
	public String getHomepageTitle()
	{
		return driver.getTitle();
		
	}
	
	public ContactsPage clickOnContactsTab()
	{
		contactstab.click();
		return new ContactsPage();
	}
	
	
	
}
