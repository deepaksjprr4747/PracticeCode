package com.place.automation.cpm.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Log;

public class SFbasic extends BasePage {
	
	
	
	By setupIcon = By.xpath("//li/div[@class='setupGear']//a");
	By setupOption = By.xpath("//div//a[@title='Setup']");
	public By quickFind = By.xpath("//div/input[@placeholder='Quick Find']");
	
	//public By manageBatchSetting = By.xpath("//a[@title = 'Manage - Record 1 - Batch Setting']");
	public By manageBatchSetting = By.xpath("//a[contains(@title,'Batch Setting') and text()='Manage']");
	
	public By manageXeroSetting = By.xpath("//a[contains(@title,'Xero Settings') and text()='Manage']");
	
	public By manageQBSetting = By.xpath("//a[contains(@title,'Quickbooks Online Settings') and text()='Manage']");
	
	
	
	public SFbasic(WebDriver driver1)	{

		this.driver = driver1;
	}
	
	
	public void clickSetup() throws InterruptedException {
		
		clickElement(driver, setupIcon);
		Thread.sleep(3000);
		clickElement(driver, setupOption);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> i = handles.iterator();
		
		while(i.hasNext()) {
			String childwin = i.next();
			Log.info("child winodw name is: " +childwin);
			//System.out.println("child winodw name is: " +childwin);
			driver.switchTo().window(childwin);
			String child_w_title = driver.switchTo().window(childwin).getTitle();	
		}
		
	}
		
	public void quickFindSetup(By locator, String searchValue) throws InterruptedException
	{
		
		System.out.println("element is present: " +driver.findElement(By.xpath("//div/input[@placeholder='Quick Find']")).isDisplayed());
		
		enterText(driver, locator,searchValue);
		Log.info("Searched the element successfully");
		driver.findElement(By.xpath("//div[@title='"+searchValue+"']/a")).click();
		
		//driver.findElement(By.xpath("//span/div[text()='"+searchValue+"']")).click();
		//driver.findElement(By.xpath("//a/mark[text()='"+searchValue+"']")).click();
		
	}

	public void clickManageButton(By locator) throws InterruptedException
	{
		//WebElement we = driver.findElement(By.xpath("//div[@class='content iframe-parent']/iframe"));
		
		WebElement we1 = driver.findElement(By.xpath("//div[@class='oneAlohaPage']//iframe"));
		
		driver.switchTo().frame(we1);
		clickElement(driver, locator);
		Log.info("clicked on batch settings successfully");
		//driver.findElement(By.xpath("//td/input[@value='Edit']"));
		driver.switchTo().defaultContent();
		Log.info("came to default frame successfully");
		
	}
	
}
