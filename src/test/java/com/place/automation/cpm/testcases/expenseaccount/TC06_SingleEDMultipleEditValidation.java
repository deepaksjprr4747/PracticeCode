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

public class TC06_SingleEDMultipleEditValidation extends BaseTest{
	
	
	String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//GLAndCashValidationCSV.csv";

	List<String[]> r;

	
	@BeforeTest
	public void navigateRevPage() throws Exception {
		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
	}
	
	@Test
	public void editED()
			throws Exception {
		
		try {
			CSVReader reader = new CSVReader(new FileReader(filePath));
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
		expensePage.editRecurringExpense(editedStartDate,editedInvoiceDate,editedEndDate,editedExpenseAmount,editedPayTerm,editedFrequency,editedPayementAccount);
		Log.info("Expense detail edited successfully");

		minWait();
		//expensePage.validateEditedED(editedGlCount,editedCashCount);

	//	expensePage.validateEditedED(editedGlCount,editedCashCount);
		
		minWait();
		minWait();
		homePage.searchInLauncher("Cash Projection");
		minWait();
		driver.navigate().refresh();

		minWait();
		minWait();
		
		Log.info(arrays[1]);
		
		String revEndDate = arrays[13];
		String revInvoiceDate = arrays[12];
		String glName = arrays[0];
		String cashAllocationValue = arrays[18];
		String revBillingCycle = arrays[16];
		String expEDType = arrays[8];
		String cashCount = arrays[20];
		String edPayTerm = arrays[15];
		
		
		int fromMonth = 0;
		int toMonth = 0;
		
		if (!(revInvoiceDate.substring(0, 2).contains("/"))) {
			fromMonth = Integer.parseInt(revInvoiceDate.substring(0, 2));
		} else {
			fromMonth = Integer.parseInt(revInvoiceDate.substring(0, 1));
		}

		int fromYear = Integer.parseInt(revInvoiceDate.substring(revInvoiceDate.length() - 4));
		minWait();
		
		if (!(revEndDate.substring(0, 2).contains("/"))) {
			toMonth = Integer.parseInt(revEndDate.substring(0, 2));
		} else {
			toMonth = Integer.parseInt(revEndDate.substring(0, 1));
		}
		
		int toYear = Integer.parseInt(revEndDate.substring(revEndDate.length() - 4));
		toYear = toYear-1;
		
		toMonth = toMonth+6;
		if(toMonth>12) {
			toMonth=toMonth-12;
			toYear=toYear+1;
		}
		
		
		Log.info("Starting Cash Projection screen expansion on Month View");
		Log.info("Starting filter selection");

		cashProjection.selectFiltercriteria("SB6","Forecast"); 		//Pass selectFiltercriteria("OrgName") to select manual Org

		cashProjection.selectFiltercriteria("All Organizations","Forecast"); 		//Pass selectFiltercriteria("OrgName") to select manual Org
		
		Log.info("Starting dates selection");
		cashProjection.timePeriodMonthView(fromMonth, fromYear, Constants.cashAndPLPageFromInputBox);
		cashProjection.timePeriodMonthView(toMonth, toYear, Constants.cashAndPLPageToInputBox);
		cashProjection.SubmitDate(Constants.cashAndPLPageApplyButton);
		minWait();
		cashProjection.validateRecordCreation(glName, accName ,revBillingCycle,cashAllocationValue,expEDType,edPayTerm,cashCount);
		
			
		}
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
