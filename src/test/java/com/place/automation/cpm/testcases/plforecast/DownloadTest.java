package com.place.automation.cpm.testcases.plforecast;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;


public class DownloadTest extends BaseTest{

	@BeforeTest
	public void navigatePLPage() throws Exception
	{
		//logger = extent.startTest("navigateRevPage");
		Log.info("going to login now on scratch");
		loginPage.loginRelease(Constants.ShailReleaseUsername, Constants.ShailReleasePassword);
		homePage.searchInLauncher("P&L Forecast");
	}

	@Test
	public void testDownloadFun() throws InterruptedException
	{
		try {
			Thread.sleep(40000);
		}
		finally {
		
			plForecast.exportCSV(driver);
		}
		
	}
	
	
}
