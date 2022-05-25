package com.place.automation.cpm.testcases.cashprojectionbeta;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC01_CashprojectionBetaMonthViewExpansion extends BaseTest{
	@BeforeTest
	public void Login() throws Exception
	{
		System.out.println("going to login now ");
		loginPage.login(Constants.username, Constants.password);
		
	}
	
	@Test
	@Parameters({"startDate","endDate"})  
	public void cashProjectionMonthExpansion(String startDate, String endDate) throws Exception
	{
		try{
			homePage.searchInLauncher("Cash Projection (Beta)");
			minWait();
			Log.info("Starting Cash Projection  Beta screen expansion on Month View");
			Log.info("Starting filter selection");
			plForecast.cashFilters(startDate, endDate,"All Organizations",  "Actuals to Date & Forecast","Month");
			Log.info("Starting horizontal expansion");
			cashProjectionBeta.horizontalExpansionBeta();
			Log.info("Starting vertical expansion");
			cashProjectionBeta.verticalExpansionBeta();
			
		}
		finally{
				String fileX = cashProjectionBeta.exportCSV(driver);
			
			cashProjectionBeta.csvValidation(fileX);
		}
		
	}
}
