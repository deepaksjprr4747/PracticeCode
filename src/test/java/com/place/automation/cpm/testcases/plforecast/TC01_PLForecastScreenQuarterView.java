package com.place.automation.cpm.testcases.plforecast;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC01_PLForecastScreenQuarterView extends BaseTest{

	@BeforeTest
	public void navigatePLPage() throws Exception
	{
		Log.info("going to login now on scratch");
		loginPage.login(Constants.ShailReleaseUsername, Constants.ShailReleasePassword);
		homePage.searchInLauncher("P&L Forecast");
		minWait();
	}
	
	@Test
	@Parameters({"fromMonth","fromYear","toMonth","toYear","orgName"})  
	public void plTabExpand(int fromMonth,int fromYear, int toMonth, int toYear,String orgName) throws InterruptedException, FileNotFoundException, IOException
	{
		try{
			driver.navigate().refresh();
			minWait();
			minWait();
			Log.info("Starting PL Forecast screen expansion on Quarter View");
			Log.info("Starting filter selection");
			plForecast.selectFiltercriteria(orgName,"Actuals to Date & Forecast"); 		//Pass selectFiltercriteria("OrgName") to select manual Org
			plForecast.timePeriodFilter("Quarter");
			Log.info("Starting dates selection");
			plForecast.timePeriodQuarterView(fromMonth, fromYear, Constants.cashAndPLPageFromInputBox);
			plForecast.timePeriodQuarterView(toMonth, toYear, Constants.cashAndPLPageToInputBox);
			plForecast.SubmitDate(Constants.cashAndPLPageApplyButton);
			Log.info("Starting horizontal expansion");
			plForecast.expandHorizontal();	
			Log.info("Starting vertical expansion");
			plForecast.glExpandVertical(driver);
			Log.info("Starting Commission expansion");
			plForecast.expandEmployeeCommissionLinks();
			Log.info("Starting Quota expansion");
			plForecast.expandEmployeeQuotaLinks();
		}
		finally{
			String fileX = plForecast.exportCSV(driver);
			
			plForecast.csvValidation(fileX);
		}
		
	}
}
