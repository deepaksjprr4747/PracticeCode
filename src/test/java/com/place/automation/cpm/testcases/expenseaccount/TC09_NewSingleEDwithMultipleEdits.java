package com.place.automation.cpm.testcases.expenseaccount;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;
import com.place.automation.utils.WriteCSV;

public class TC09_NewSingleEDwithMultipleEdits extends BaseTest{



WriteCSV csvWrite = new WriteCSV(currentDir + "//src//test//resources//dataValidationCsvOutputFiles//GLAndCashValidationCSV.csv");
int Loop =0;
String GLName;
String ACCName;
String EXPName;
String GLAllocationValue;
Boolean expenseCreated;
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
		System.out.println("entering inside object method");
		 d1 = getTestData("Sheet 4","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData")
	public void createSingleED(String glName, String expName, String accName,String edType, String startDate, String invoiceDate, String expAmount, String endDate,
			String payAccountName, String payTerm, String frequency, String glCount, String cashCount, String editedStartDate, String editedInvoiceDate, String editedExpAmount, String editedEndDate,
			String editedPayAccountName, String editedPayTerm, String editedFrequency, String editedGlCount, String editedCashCount)
			throws Exception {
		
		if(Loop==0) {
			
			GLName = glName;
			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			expName = expName + "_" + date;
			accName = accName + "_" + date;
			ACCName = accName;
			String glAllocationValue = expensePage.validationGLAmount(frequency,expAmount);
			GLAllocationValue = glAllocationValue;
			homePage.searchInLauncher("Expense Accounts");
			Log.info("logged in successfully");
			homePage.selectAllView();
			Log.info("entered in create New Expense");
			expensePage.createNewExpense(glName, expName,accName);
			
			Log.info("Expense account created successfully");
			
				
				 Log.info("Going to create recurring expense detail for payment term "+payTerm +" and billing cycle "+ frequency);
				expensePage.createNewRecED(edType, startDate, invoiceDate, expAmount, endDate, payAccountName, payTerm, frequency,
						glCount, cashCount);
				Log.info("created recurring expense detail successfully");
				expenseCreated = true;
		}
		
		Loop=Loop+1;
		
		String editedGlAllocationValue = expensePage.validationGLAmount(editedFrequency,editedExpAmount);
		if(expenseCreated) {
			loopcount= loopcount+1;
			String[] line = {GLName,ACCName,startDate,endDate,payTerm,frequency,GLAllocationValue,expAmount,edType,glCount,cashCount,editedStartDate,editedInvoiceDate,editedEndDate,
					editedPayAccountName,editedPayTerm,editedFrequency,editedGlAllocationValue,editedExpAmount,editedGlCount,editedCashCount}; 
			csvWrite.addLines(line);
			minWait();
		}
		
	}

	
	@Test
	public void editRecurringED() throws Exception {
		String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//GLAndCashValidationCSV.csv";

		List<String[]> r;
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
	         r = reader.readAll();
		
		
		for (String[] arrays : r) {
	    	
			Log.info(arrays[1]);
			
			String glname = arrays[0];
			String accName = arrays[1];
			
			String editedStartDate = arrays[11];
			String editedInvoiceDate = arrays[12];
			String editedEndDate = arrays[13];
			String editedPayementAccount = arrays[14];
			String editedPayTerm = arrays[15];
			String editedFrequency = arrays[16];
			String editedExpenseAmount = arrays[18];
			String editedGlCount = arrays[19];
			String editedCashCount = arrays[20];
		
		homePage.searchInLauncher("Expense Accounts");
		Log.info("logged in successfully");
		homePage.selectAllView();
		Log.info("entered in edit Expense");
		expensePage.findExpense(accName);
		Log.info("Expense account reached successfully");
		expensePage.editRecurringExpense(editedStartDate,editedInvoiceDate,editedEndDate,editedExpenseAmount,editedPayTerm,editedFrequency,editedPayementAccount);
		Log.info("Expense detail edited successfully");
		expensePage.validateEditedED(editedGlCount,editedCashCount);
		
		
		minWait();
			homePage.searchInLauncher("Cash Projection (Beta)");
			minWait();
			minWait();
			driver.navigate().refresh();
			plForecast.cashFilters(editedInvoiceDate, editedEndDate,"SB6","Forecast","Month");
			cashProjectionBeta.validateExpenseAllocations(glname,accName, editedStartDate, editedEndDate, editedPayTerm, editedFrequency, editedExpenseAmount);
			minWait();
			minWait();
			minWait();
			minWait();
			homePage.searchInLauncher("P&L Forecast (Beta)");
			minWait();
			driver.navigate().refresh();
			plForecast.cashFilters(editedInvoiceDate, editedEndDate,"SB6","Forecast","Month");
			plForecastBeta.validateExpenseAllocations(glname,accName, editedStartDate, editedEndDate, editedPayTerm, editedFrequency, editedExpenseAmount);

			
		}
	}
	}
}

