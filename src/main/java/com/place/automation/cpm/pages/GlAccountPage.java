package com.place.automation.cpm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.place.automation.cpm.base.BasePage;

public class GlAccountPage extends BasePage {
	
	public By glAccountNameTextF = By.xpath("//label/span[contains(.,'GL Account Name')]/../following-sibling::input");
	public By glAccountSequenceTextF = By.xpath("//label/span[contains(.,'Sequence')]/../following-sibling::input");
	public By glPLCategory = By.xpath("//label/span[contains(.,'P&L Category')]/../following-sibling::div//input");
	public By glClassTypeDropDown = By.xpath("//span[contains(.,'Class Type')]/../following-sibling::div//div/a[contains(.,'--None--')]");
	public By glCashCategory = By.xpath("//label/span[contains(.,'Cash Category')]/../following-sibling::div//input");
	public By glCodeTextF = By.xpath("//label/span[contains(.,'GL Code')]/../following-sibling::input");
	
	
	
	
	
	
	
	public GlAccountPage(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	
	
	public void createNewGL(String glName, String seq, String plCategory, String classType, String cashCategory, String glCode) throws InterruptedException
	{
		clickElement(driver, newButtonOnPage);
		//glName = glName + getTimeStampRandomNumber();
		//glCode = glCode + getTimeStampRandomNumber();
		
		enterText(driver, glAccountNameTextF, glName);
		enterText(driver, glCodeTextF, glCode);
		enterText(driver, glAccountSequenceTextF, seq);
		enterText(driver, glPLCategory, plCategory);
		clickElement(driver, By.xpath("//div[@title='"+plCategory+"']"));
		Thread.sleep(3000);
		//enterText(driver, glPLCategory, plCategory);
		clickElement(driver, glClassTypeDropDown);
		clickElement(driver, By.xpath("//li/a[@title='"+classType+"']"));
		enterText(driver, glCashCategory, cashCategory);
		clickElement(driver, By.xpath("//div[@title='"+cashCategory+"']"));
		Thread.sleep(1000);
		clickElement(driver, glAccountSequenceTextF);
		Thread.sleep(2000);
		clickElement(driver, saveButtonOnPage);
		Thread.sleep(6000);
		
	}
	

}
