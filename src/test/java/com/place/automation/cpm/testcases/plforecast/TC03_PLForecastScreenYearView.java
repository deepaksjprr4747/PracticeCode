package com.place.automation.cpm.testcases.plforecast;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC03_PLForecastScreenYearView extends BaseTest{

	@BeforeTest
	public void navigatePLPage() throws Exception
	{
		System.out.println("going to login now on scratch");
		loginPage.login(Constants.ShailReleaseUsername, Constants.ShailReleasePassword);

		homePage.searchInLauncher("P&L Forecast");
		minWait();
	}
	
	@Test
	@Parameters({"fromYear","toYear","orgName"})  
	public void plTabExpand(int fromYear, int toYear,String orgName) throws InterruptedException, FileNotFoundException, IOException
	{
		try{
			driver.navigate().refresh();
			minWait();
			minWait();
			Log.info("Starting PL Forecast screen expansion on Year View");
			Log.info("Starting filter selection");
			plForecast.selectFiltercriteria(orgName,"Actuals to Date & Forecast"); 		//Pass selectFiltercriteria("OrgName") to select manual Org
			plForecast.timePeriodFilter("Year");
			Log.info("Starting dates selection");
			plForecast.timePeriodYearView(fromYear, Constants.cashAndPLPageFromInputBox);
			plForecast.timePeriodYearView(toYear, Constants.cashAndPLPageToInputBox);
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
