package com.place.automation.cpm.testcases.revenueaccount;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;
import com.place.automation.utils.WriteCSV;

public class TC02_CreateRARD extends BaseTest{
	
	WriteCSV csvWrite = new WriteCSV(currentDir + "//src//test//resources//dataValidationCsvOutputFiles//GLAndCashValidationCSV.csv");
	
	@BeforeTest
	public void navigateRevPage() throws Exception {

		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
	}
	
	@AfterTest
	public void navigateRevPageAfter() throws Exception {
		
		csvWrite.closeFile();
		
	}

	@DataProvider
	public Object[][] getData() {
		System.out.println("entering inside object method");
		Object d1[][] = getTestData("Sheet1","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData", priority = 1, alwaysRun = true)
	public void createNewRContract(String glName, String revName, String accName, String revContractType,
			String revStartDate, String revInvoiceDate, String revEndDate, String revPayAccountName, String revPayTerm,
			String revBillingCycle, String revRenewDate, String revProductName, String productQty, String productPrice,
			String glCount, String cashCount,String glAllocationValue,String cashAllocationValue, String editedStartDate, 
			String editedInvoiceDate, String	editedEndDate, String	editedPayAccountName, String	editedPayTerm, 
			String	editedFreqency, String	editedRevRenewDate, String	editedGlCount, String	editedCashCount, 
			String	editedGlAllocationValue, String	editedCashAllocationValue) throws Exception {
		
		cashAllocationValue = cashProjection.validationCashAmount(revBillingCycle,cashAllocationValue);
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		revName = revName + "_" + date;
		accName = accName + "_" + date;
		
		
		
	    
	    homePage.searchInLauncher("Revenue Accounts");
		Log.info("logged in successfully");
		homePage.selectAllView();
		Log.info("entered in createNewRevenue");
		revenuePage.createNewRevenueAccount(glName, revName, accName);
		driver.navigate().refresh();
		Log.info("Revenue account created successfully");
		minWait();
		Thread.sleep(2000);
		Log.info("Going to create recurring revenue detail for payment term "+revPayTerm +" and billing cycle "+ revBillingCycle);
		revenuePage.createNewRContract(revContractType, revStartDate, revInvoiceDate, revEndDate, revRenewDate,
				revPayAccountName, revPayTerm, revBillingCycle, revProductName, productQty, productPrice);
		Log.info("create the recurring revenue detail successfully");
		Log.info("Going to validate recurring revenue detail");
		revenuePage.validateNewRContract(glCount, cashCount);
		Log.info("create the recurring revenue detail successfully");
		
		String[] line = {glName,accName,revStartDate,revEndDate,revPayTerm,revBillingCycle,glAllocationValue,cashAllocationValue,revContractType,glCount,cashCount}; 
		csvWrite.addLines(line);
		 
	    
	
	}
}
