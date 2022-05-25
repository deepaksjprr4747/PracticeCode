package com.place.automation.cpm.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;

import com.place.automation.cpm.base.BasePage;

public class PracticeSessionAccountPage extends BasePage{
	
	private By AccountPageRecentdropdown = By.xpath("//button[@title = 'Select a List View']");
	private By AccountPageAllOption = By.xpath("//li//span[text()='All Accounts']");
	private By AccountPageNewButton = By.xpath("//a[@title='New']");
	private By AccountPageNameInput = By.xpath("//input[@name='Name']");
	private By AccouuntPageBillingStreet = By.xpath("//label[contains(.,'Billing Street')]/../div/textarea[@name='street']");
	private By AccountPageBillingCity = By.xpath("//label[contains(.,'Billing City')]/../div/input[@name='city']");
	private By AccountPageBillingState = By.xpath("//label[contains(.,'Billing State/Province')]/..//input[@name='province']");
	private By AccountPageBillingZipCode = By.xpath("//label[contains(.,'Billing Zip/Postal Code')]/..//input[@name='postalCode']");
	private By AccountPageBillingCounty = By.xpath("//label[contains(.,'Billing Country')]/..//input[@name='country']");
	private By AccountPageSaveButton = By.xpath("//button[@name='SaveEdit']");

	BasePage bp = new BasePage();
	String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	String name = "My New Salesforce Account";
	
	
	public PracticeSessionAccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void fillrequiredDetails(String accName, String accBillingStreet, String accBillingCity, String accBillingState, String accZipCode,String accCounty) throws InterruptedException
	{
		clickElement(driver,AccountPageRecentdropdown);
		clickElement(driver,AccountPageAllOption);
		clickElement(driver, AccountPageNewButton);
		enterText(driver, AccountPageNameInput, accName+date);
		enterText(driver, AccouuntPageBillingStreet, accBillingStreet+date);
		enterText(driver, AccountPageBillingCity, accBillingCity);
		enterText(driver, AccountPageBillingState, accBillingState);
		enterText(driver, AccountPageBillingZipCode, accZipCode);
		enterText(driver, AccountPageBillingCounty, accCounty);
		clickElement(driver, AccountPageSaveButton);
		
		
	}
	
	
}
