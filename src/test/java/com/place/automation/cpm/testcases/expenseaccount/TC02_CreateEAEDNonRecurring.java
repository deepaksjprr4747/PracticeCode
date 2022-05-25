package com.place.automation.cpm.testcases.expenseaccount;

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

public class TC02_CreateEAEDNonRecurring extends BaseTest{

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
		Object d1[][] = getTestData("Sheet 3","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData")
	public void createNonRecurringED(String glName, String expName, String accName,String edType, String startDate, String invoiceDate, String expAmount, String endDate,
			String payAccountName, String payTerm, String frequency, String glCount, String cashCount, String editedStartDate, String editedInvoiceDate, String editedExpAmount, String editedEndDate,
			String editedPayAccountName, String editedPayTerm, String editedFrequency, String editedGlCount, String editedCashCount)
			throws Exception {
		
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		expName = expName + "_" + date;
		accName = accName + "_" + date;
		String glAllocationValue = expensePage.validationGLAmount(frequency,expAmount);
		String editedGlAllocationValue = expensePage.validationGLAmount(editedFrequency,editedExpAmount);
		
		homePage.searchInLauncher("Expense Accounts");
		Log.info("logged in successfully");
		homePage.selectAllView();
		Log.info("entered in create New Expense");
		expensePage.createNewExpense(glName, expName,accName);
		
		Log.info("Expense account created successfully");
		
		 endDate = startDate;
		 editedEndDate = editedStartDate;
				Log.info("Going to create non recurring expense detail for payment term "+payTerm +" and billing cycle "+ frequency);
			expensePage.createNewNonRecED(edType, startDate, invoiceDate, expAmount, payAccountName, payTerm, 
					glCount, cashCount);
			Log.info("create the recurring expense detail successfully");
			
			String[] line = {glName,accName,startDate,endDate,payTerm,frequency,glAllocationValue,expAmount,edType,glCount,cashCount,editedStartDate,editedInvoiceDate,editedEndDate,
					editedPayAccountName,editedPayTerm,editedFrequency,editedGlAllocationValue,editedExpAmount,editedGlCount,editedCashCount}; 
			csvWrite.addLines(line);
			Thread.sleep(3000);
	}
}
