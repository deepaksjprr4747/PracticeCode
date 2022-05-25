package com.place.automation.cpm.testcases.plforecastbeta;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC02_PLForecastBetaScreenMonthView extends BaseTest{

	@BeforeTest
	public void navigatePLPage() throws Exception
	{
		System.out.println("going to login now on scratch");
		loginPage.login(Constants.username, Constants.password);
		homePage.searchInLauncher("P&L Forecast (Beta)");
	}
	
	@Test
	@Parameters({"fromMonth","fromYear","toMonth","toYear","orgName"})  
	public void plTabExpand(int fromMonth,int fromYear, int toMonth, int toYear,String orgName) throws InterruptedException, FileNotFoundException, IOException
	{
		try{
			Log.info("Starting PL Forecast Beta screen expansion on Month View");
			Log.info("Starting filter selection");
			plForecastBeta.selectFiltercriteria(orgName,"Actuals to Date & Forecast"); 		//Pass selectFiltercriteria("OrgName") to select manual Org
			plForecastBeta.timePeriodFilter("Month");
			Log.info("Starting dates selection");
			plForecastBeta.timePeriodMonthView(fromMonth, fromYear, Constants.cashAndPLPageFromInputBox);
			plForecastBeta.timePeriodMonthView(toMonth, toYear-1, Constants.cashAndPLPageToInputBox);
			plForecastBeta.SubmitDate(Constants.cashAndPLPageApplyButton);
			Log.info("Starting horizontal expansion");
			plForecastBeta.expandHorizontal();	
			Log.info("Starting vertical expansion");
			cashProjectionBeta.verticalExpansionBeta();
			/*plForecastBeta.glExpandVertical(driver);
			Log.info("Starting Commission expansion");
			plForecastBeta.expandEmployeeCommissionLinks();
			Log.info("Starting Quota expansion");
			plForecastBeta.expandEmployeeQuotaLinks();
			Log.info("Starting Opportunity expansion");
			plForecastBeta.expandOptyPipelineLinks();*/
		}
		finally{
String fileX = plForecastBeta.exportCSV(driver);
			
			plForecastBeta.csvValidation(fileX);
		}
		
	}
}
