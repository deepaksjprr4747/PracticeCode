package com.place.automation.cpm.testcases.cashprojection;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC02_CashProjectionScreenMonthView extends BaseTest{

	@BeforeTest
	public void navigatePLPage() throws Exception
	{
		System.out.println("going to login now on scratch");

		loginPage.login(Constants.ShailReleaseUsername, Constants.ShailReleasePassword);


		homePage.searchInLauncher("Cash Projection");
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
			Log.info("Starting Cash Projection screen expansion on Month View");
			Log.info("Starting filter selection");
			cashProjection.selectFiltercriteria(orgName,"Actuals to Date & Forecast"); 		//Pass selectFiltercriteria("OrgName") to select manual Org
			minWait();
			cashProjection.timePeriodFilter("Month");
			minWait();
			Log.info("Starting dates selection");
			cashProjection.timePeriodMonthView(fromMonth, fromYear, Constants.cashAndPLPageFromInputBox);
			cashProjection.timePeriodMonthView(toMonth, toYear-1, Constants.cashAndPLPageToInputBox);
			cashProjection.SubmitDate(Constants.cashAndPLPageApplyButton);
			minWait();
			Log.info("Starting horizontal expansion");
			cashProjection.expandHorizontal();	
			Log.info("Starting vertical expansion");
			cashProjection.glExpandVertical(driver);
			Log.info("Starting Commission expansion");
			cashProjection.expandEmployeeCommissionLinks();
			Log.info("Starting Quota expansion");
			cashProjection.expandEmployeeQuotaLinks();
		}
		finally{
			String fileX = cashProjection.exportCSV(driver);
			
			cashProjection.csvValidation(fileX);
		}
		
	}
}
