package com.place.automation.cpm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Log;

public class BatchSettings extends BasePage {
	
	
	//public By batchImpQBAcc = By.xpath("//tr/th[text()='GISC_ImportQBAcc_Batch']/following-sibling::td[1]");
	
	
	
	public BatchSettings(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	public void verifyBatchSetting(String batchSettingName, String expectedCount) throws InterruptedException
	{
		
		Log.info("going to verify the batchsetting count now");
		WebElement iFrame = driver.findElement(By.xpath("//div[@class='oneAlohaPage']//iframe"));
		Log.info("iframe is available "+iFrame.isDisplayed());
		
		driver.switchTo().frame(iFrame);
		Log.info("entered in iframe again");
		minWait();
		
		WebElement we = driver.findElement(By.xpath("//tr/th[text()='"+batchSettingName+"']/following-sibling::td[1]/span"));
		By settingsName = By.xpath("//tr/th[text()='"+batchSettingName+"']/following-sibling::td[1]/span");
		clickElement(driver, settingsName);
		Log.info("batchsetting count is available " +we.isDisplayed());
		
		
		
		String actualCount = we.getText();
		Log.info("count value is : " +actualCount);
		
		if(actualCount.equalsIgnoreCase(expectedCount)) {
		Log.info("the given value of " +batchSettingName+expectedCount+ " matched the actual  " +actualCount);
		}
		else 
			Log.info("the given value of " +batchSettingName +expectedCount+ " didnt matched actual " +actualCount);
			
		driver.switchTo().defaultContent();
				
	}
	

}
