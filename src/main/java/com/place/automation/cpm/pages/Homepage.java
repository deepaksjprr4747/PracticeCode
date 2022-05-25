package com.place.automation.cpm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.place.automation.cpm.base.BasePage;

public class Homepage extends BasePage {
	
	
	
	By viewDropDown = By.xpath("//button[@title='Select List View']");
	By allOptionDropDown = By.xpath("//li//span[contains(.,'All')]");
	By recentlyViewDropDown = By.xpath("//li//span[contains(.,'Recently Viewed')]");
	By searchBox = By.xpath("//input[@id='searchInput']");
	By capitalCity = By.xpath("//tr/th[contains(.,'Capital')]/../td/a");
	
	
	
	
	
	
	public Homepage(WebDriver driver1)	{

		this.driver = driver1;
	}
	
	
	
	public void navigateAndSearch(String country, String url) throws InterruptedException
	{
		driver.get(url);
		enterText(driver, searchBox, country);
		clickElement(driver, capitalCity);
		
		
	}

	public void searchInLauncher(String optionName) throws Exception {

		switchTo_Lightning();
		
	try {
		clickElement(driver, lightningLauncher);
	
		minWait();
		minWait(); 
		if(verifyPresence(launcherSearchBar)) {
			
		
		enterText(driver, launcherSearchBar, optionName);
		clearText(driver, launcherSearchBar);
		minWait();
		enterText(driver, launcherSearchBar, optionName);
		minWait();
		minWait();
		clickElement(driver, By.xpath("//span/p[contains(.,'"+optionName+"')]"));
		}
		else 
		{
			enterText(driver, appLauncher, optionName);
			minWait();
			clickElement(driver, By.xpath("//span/mark[text()='"+optionName+"']//ancestor::a"));
		
		}
		
	}
	catch(Exception e) {
		
	}
	}
	
	public void selectAllView() throws InterruptedException	{
		
		clickElement(driver,viewDropDown);
		clickElement(driver, allOptionDropDown);
		minWait(); 
	}
	
	public void selectRecentlyViewed() throws InterruptedException {
		
		clickElement(driver,viewDropDown);
		clickElement(driver, recentlyViewDropDown);
		Thread.sleep(3000);
	}
		
	
}
