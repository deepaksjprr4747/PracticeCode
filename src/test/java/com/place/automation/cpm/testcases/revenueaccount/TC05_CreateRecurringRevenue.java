package com.place.automation.cpm.testcases.revenueaccount;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;
import com.place.automation.utils.WriteCSV;

public class TC05_CreateRecurringRevenue extends BaseTest{
	String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//Editedvalues.csv";
	WriteCSV csvWrite = new WriteCSV(filePath);
	int flag=0;
	String edGlAllocationValue ;
	String amount;
	
	List<String[]> r;
	int loopcount= 0;
	Object d1[][];
	
	
	@BeforeTest
	public void navigateRevPage() throws Exception {
		Log.info("Logging into the org with mentioned creds");
		loginPage.login(Constants.username, Constants.password);
		
	}
	@AfterMethod
	public void closecsv() throws Exception {
		if(d1.length==loopcount) {
		csvWrite.closeFile();
		}
		
	}
	
	@DataProvider
	public Object[][] getData() {
		System.out.println("Entering Data provider");
		d1 = getTestData("Sheet1","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData", alwaysRun = true, enabled= true)
	public void createRevenue(String glName, String revName, String	accName, String	revContracttype, String	startDate, 
			String	invoiceDate, String	endDate, String	payAccountName, String	payTerm, String frequency	, String revRenewDate, 
			String	revProductName, String	productQuantity, String	productPrice, String	glCount, String	cashCount, 
			String	glAllocationValue, String	cashAllocationValue, String	editedStartDate, String	editedInvoiceDate, 
			String	editedEndDate, String	editedPayAccountName, String	editedPayTerm, String	editedFrequency,
			String	editedRevRenewDate, String	editedGlCount, String	editedCashCount, String	editedGlAllocationValue, String	editedCashAllocationValue, String edProductQuantity, String edProductPrice, String subscriptionDate )
			throws Exception {
		 
		 
	try {
		
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		minWait();
		homePage.searchInLauncher("Revenue Accounts");
		Log.info("Searched for Revenue Accounts in app launcher ");
		homePage.selectAllView();
		Log.info("All list view is selected for revenue accounts");
		revenuePage.createNewRevenueAccount(glName, revName+date, accName+date);
		Log.info("Revenue account created successfully");
		minWait();
		Log.info("Creating recurring revenue ");
		
		revenuePage.createNewRContract(revContracttype, startDate, invoiceDate, endDate, subscriptionDate,
				payAccountName, payTerm, frequency, revProductName, productQuantity, productPrice);
		
		Log.info("Revenue detail was successfully created");
		Log.info("Going to validate GL and Cah allocations on recurring revenue detail");
		
		revenuePage.validateNewRContract(glCount, cashCount);
		
		Log.info("Validated the allocations successfully");
		 
		
		
		//validating the allocations on P&L and cash screens 
		
		minWait();
			homePage.searchInLauncher("Cash Projection");
			minWait();
			minWait();
			driver.navigate().refresh();
			cashProjection.cashFilters(invoiceDate, endDate);
			minWait();
			
			cashProjection.validateRecordCreation(glName, accName+date ,frequency,cashAllocationValue,revContracttype,payTerm,cashCount); 
			minWait();
			minWait();
			homePage.searchInLauncher("P&L Forecast");
			minWait();
			driver.navigate().refresh();
			plForecast.cashFilters(invoiceDate, endDate,"SB6","Forecast","Month");
			plForecast.validatePLRecords(glName, accName+date, glAllocationValue, cashAllocationValue,payTerm, revContracttype, startDate, endDate); 
	}
	catch(Exception e) {
		Log.info(e.getMessage());
	}
	finally{
		String fileX = plForecast.exportCSV(driver);
		
		plForecast.csvValidation(fileX);
	}
	}
}