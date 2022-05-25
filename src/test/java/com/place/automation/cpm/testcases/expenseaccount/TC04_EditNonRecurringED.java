package com.place.automation.cpm.testcases.expenseaccount;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC04_EditNonRecurringED extends BaseTest{
	
	
	String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//GLAndCashValidationCSV.csv";

	List<String[]> r;

	@BeforeTest
	public void navigateRevPage() throws Exception {
		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
	}
	
	
	
	@Test
	public void editNonRecurringED()
			throws Exception {
		
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
	         r = reader.readAll();
		
		
		for (String[] arrays : r) {
	    	
			Log.info(arrays[1]);
			
			
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
		expensePage.editNonRecurringExpense(editedStartDate,editedInvoiceDate,editedExpenseAmount,editedPayTerm,editedPayementAccount);
		Log.info("Expense detail edited successfully");
		expensePage.validateEditedED(editedGlCount,editedCashCount);
			
		}
	}
	}
}
