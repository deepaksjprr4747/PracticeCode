package com.place.automation.testcases.quotaschedule;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC01_QuotaScheduleCreation extends BaseTest{
	String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	@BeforeTest
	public void orglogin() throws Exception {
		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
	}
	@DataProvider
	public Object[][] getData() {
		System.out.println("entering inside object method");
		Object d1[][] = getTestData("Sheet 8","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData")
	public void createQuotaSchedule(String quotaDescription,	String paymentTerm,	String paymentFreq,	String paymentAcc ,String expenseGL,	String	revenueGL,	String	periodType,	String	noOFPeriods,	String	periodAmount1,String	periodAmount2, String	periodAmount3,String	periodAmount4,String salesEmployee,String	incStartDate,String	startDate, String endDate, String expectedQuotaCount) throws Exception {
		String employee = salesEmployee+date;
		
		driver.navigate().refresh();
		minWait();
		homePage.searchInLauncher("Employees");
		extreporting("Navigating to Employee tab", "Redirected to Employee page successfully", "Pass");
		minWait();
		quota.createEmployee(employee, startDate, endDate);
		extreporting("Creating new employee", "Created new employee successfully", "Pass");

		driver.navigate().refresh();
		minWait();
		homePage.searchInLauncher("Quota Schedule");
		extreporting("Navigating to Quota Schedule tab", "Redirected to Quota Schedule page successfully", "Pass");
		minWait();
		
		quota.quotaCreation(quotaDescription,paymentTerm, paymentFreq,paymentAcc ,expenseGL, revenueGL, periodType, noOFPeriods,	periodAmount1,periodAmount2,periodAmount3,periodAmount4);
		extreporting("Creating Quota schedule record", "Quota schedule created successfully", "Pass");
		quota.validateQuotaScheduleLineItems(noOFPeriods);
		extreporting("Validating Line Item Count", "Line Item count matches the expected count", "Pass");
		minWait();
		quota.employeeAssignment(employee , incStartDate,  startDate ,endDate);
		extreporting("Assigning Quota to Sales Employee", "Assigned Quota to Sales Employee successfully", "Pass");
		minWait();
		quota.validatingAssignmentonEmployee(salesEmployee+date, startDate, endDate,expectedQuotaCount);
		extreporting("Validating that quota assignment is present on employee page ", "Validate quota assignment is present on employee page", "Pass");
		
	    minWait();
		homePage.searchInLauncher("Cash Projection (Beta)");
		minWait();
		driver.navigate().refresh();
		minWait();
		extreporting("Navigating to Cash Projection (Beta) tab", "Redirected to Cash Projection (Beta) page successfully", "Pass");
		minWait();
		
		plForecast.cashFilters(startDate, endDate, "SB6", "Forecast", "Month");
		cashProjectionBeta.validateQuotaAllocations(revenueGL,startDate, endDate, periodType, paymentFreq, noOFPeriods, salesEmployee+date,periodAmount1,periodAmount2,periodAmount3,periodAmount4);
		
		
		minWait();
		homePage.searchInLauncher("P&L Forecast (Beta)");
		minWait();
		driver.navigate().refresh();
		minWait();
		extreporting("Navigating to P&L Forecast (Beta) tab", "Redirected to P&L Forecast (Beta) page successfully", "Pass");
		minWait();
		
		plForecast.cashFilters(startDate, endDate, "SB6", "Forecast", "Month");
		plForecastBeta.validateQuotaAllocations(revenueGL, startDate, endDate, periodType, paymentFreq, noOFPeriods, salesEmployee+date, periodAmount1, periodAmount2, periodAmount3, periodAmount4);
		
	}
}
