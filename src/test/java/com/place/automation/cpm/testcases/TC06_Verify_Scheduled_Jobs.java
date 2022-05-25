package com.place.automation.cpm.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC06_Verify_Scheduled_Jobs extends BaseTest{
	
	String searchValue = "Scheduled Jobs";
	String expectednameAllocationJob = "Add Allocation On New Month";
	String expectednameDebugJob = "Delete Debug Log";
	String expectednameEDJob = "Expense Detail Update Job";
	
	
	
	@Test(priority=0, alwaysRun = true)
	public void navigateSetupPage() throws Exception
	{
		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
		//loginPage.loginSandbox(Constants.usernameTest, Constants.passwordTest);
		sfBasic.clickSetup();
		Log.info("clicked on quick find successfully");
	}
	
	@Test(priority=1, alwaysRun = true)
	public void checkDefaultValues() throws Exception
	{
		Log.info("we are on quick find page");
		sfBasic.quickFindSetup(sfBasic.quickFind, searchValue);
		extreporting("Verifying the scheduled jobs now", "Redirected to scheduled jobs", "Pass");
		//Log.info("Verifying the scheduled jobs now");
	}
	
	@Test(priority=2, alwaysRun = true)
	public void checkScheduledJobs() throws Exception

	{
	//Entering iFrame
		
		WebElement iFrame = driver.findElement(By.xpath("//div[@class='oneAlohaPage']/force-aloha-page/div/iframe"));
		Log.info("iframe is available "+iFrame.isDisplayed());
		
		driver.switchTo().frame(iFrame);
		Log.info("entered in iframe");
		minWait();
		
		
	//Verify Add Allocation Job
		
		Log.info("Verifying add allocation job");
		WebElement addAllocationJob = driver.findElement(By.xpath("//th[text()='Add Allocation On New Month']"));
	    String actualnameAllocationJob =  addAllocationJob.getText();
		
	    AssertJUnit.assertEquals(actualnameAllocationJob, expectednameAllocationJob);
	    Log.info("Step -1 Batch name is correct i.e " +actualnameAllocationJob);
	    extreporting("Verifying batch name"+actualnameAllocationJob, "Batch name is correct i.e " +actualnameAllocationJob, "Pass");
	
	//Verify Debug Log Job 
	    
	    Log.info("Verifying debug log job");
		WebElement debugJob = driver.findElement(By.xpath("//th[text()='Delete Debug Log']"));
	    String actualnameDebugJob =  debugJob.getText();
		
	    AssertJUnit.assertEquals(actualnameDebugJob, expectednameDebugJob);
	    Log.info("Step -2 Batch name is correct i.e " +actualnameDebugJob);	
	
	    extreporting("Verifying batch name"+actualnameDebugJob, "Batch name is correct i.e " +actualnameDebugJob, "Pass");

	//Verify Expense Detail Job                     
	    
	    Log.info("Verifying dexpense detail job");
		WebElement edJob = driver.findElement(By.xpath("//th[text()='Expense Detail Update Job']"));
		String actualnameEDJob =  edJob.getText();
    
        AssertJUnit.assertEquals(actualnameEDJob, expectednameEDJob);
    	Log.info("Step -3 Batch name is correct i.e " +actualnameEDJob);
	    extreporting("Verifying batch name"+actualnameEDJob, "Batch name is correct i.e " +actualnameEDJob, "Pass");

    //Exit iFrame
    	
    	driver.switchTo().defaultContent();
		Log.info("Exiting iframe, Moving to Default frame");
		Log.info("All jobs verified successfully, TC passed");
    
	}   
}
	
		
	
	

		
		
			