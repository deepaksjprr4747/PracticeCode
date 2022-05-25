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

public class TC07_CreateSingleEDForMultipleEditValidation extends BaseTest{

	WriteCSV csvWrite = new WriteCSV(currentDir + "//src//test//resources//dataValidationCsvOutputFiles//GLAndCashValidationCSV.csv");
	int Loop =0;
	String GLName;
	String ACCName;
	String EXPName;
	String GLAllocationValue;
Boolean expenseCreated;

	@BeforeTest
	public void navigateRevPage() throws Exception {
		Log.info("going to login now");
		loginPage.loginRelease(Constants.ShailReleaseUsername, Constants.ShailReleasePassword);
		expenseCreated = false;
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
	public void createSingleNonRecurringED(String glName, String expName, String accName,String edType, String startDate, String invoiceDate, String expAmount, String endDate,
			String payAccountName, String payTerm, String frequency, String glCount, String cashCount, String editedStartDate, String editedInvoiceDate, String editedExpAmount, String editedEndDate,
			String editedPayAccountName, String editedPayTerm, String editedFrequency, String editedGlCount, String editedCashCount)
			throws Exception {
		if(Loop==0) {
			
			GLName = glName;
			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			expName = expName + "_" + date;
			accName = accName + "_" + date;
			ACCName = accName;
			String GLAllocationValue = expensePage.validationGLAmount(frequency,expAmount);
		
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
			expenseCreated = true;
			}
		endDate = editedEndDate =editedFrequency =frequency = "";
		
		
		Loop=Loop+1;
			
			String editedGlAllocationValue = expensePage.validationGLAmount("Monthly",editedExpAmount);
			
			if(expenseCreated) {
				String[] line = {GLName,ACCName,startDate,endDate,payTerm,frequency,GLAllocationValue,expAmount,edType,glCount,cashCount,editedStartDate,editedInvoiceDate,editedEndDate,
						editedPayAccountName,editedPayTerm,editedFrequency,editedGlAllocationValue,editedExpAmount,editedGlCount,editedCashCount}; 
				csvWrite.addLines(line);
				Thread.sleep(3000);
			}
			
	}
}
