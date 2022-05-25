package com.place.automation.cpm.testcases.revenueaccount;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;
import com.place.automation.utils.WriteCSV;

public class TC04_CreateNonRecurringRDwithMultipleEdits extends BaseTest{
	String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//Editedvalues.csv";
	WriteCSV csvWrite = new WriteCSV(filePath);
	int flag=0;
	String edGlAllocationValue ;
	String amount;
	String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
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
		d1 = getTestData("Sheet 5","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData", alwaysRun = true, enabled= true)
	public void createSingleRevenue(String glName, String revName, String accName, String rdType, String	startDate, 
		String invoiceDate, String	revAmount, String	payAccountName, String	payTerm, String	glCount, String	cashCount, 
		String glAllocationValue, String cashAllocationValue,String	editedStartDate, String	editedInvoiceDate, 
		String	editedPayAccountName, String	editedPayTerm, String	editedGlCount, String	editedCashCount, String unitPrice , String quantity,String editedGlAllocationValue , String editedCashAllocationValue, String Product)
			throws Exception {
		 
		 
		 if(flag==0){
		
		// String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		homePage.searchInLauncher("Revenue Accounts");
		Log.info("Searched for Revenue Accounts in app launcher ");
		homePage.selectAllView();
		Log.info("All list view is selected for revenue accounts");
		revenuePage.createNewRevenueAccount(glName, revName+date, accName+date);
		Log.info("Revenue account created successfully");
		minWait();
		Log.info("Creating recurring revenue ");
		revenuePage.createNewNonRecRD(rdType, startDate, invoiceDate, quantity, payAccountName, payTerm, glCount, cashCount, unitPrice);
		
		Log.info("Revenue detail was successfully created");
		Log.info("Going to validate GL and Cah allocations on recurring revenue detail");
		
		revenuePage.validateNewRContract(glCount, cashCount);
		
		Log.info("Validated the allocations successfully");
		 }
		
		flag=flag+1; 
		loopcount= loopcount+1;
		String[] line = {glName,revName+date,accName+date,editedStartDate,editedInvoiceDate,editedPayTerm, editedGlAllocationValue,editedCashAllocationValue,editedGlCount,editedCashCount, rdType,editedPayAccountName}; 
		csvWrite.addLines(line);
	}
	
	@Test
	public void editNonRecRev() throws Exception {

		CSVReader reader = new CSVReader(new FileReader(filePath));
	         r = reader.readAll();
	         
	         for (String[] array : r) {
	     
	        	 Log.info(array[1]);
	 			String glName = array[0];
	        	 String revName = array[1];
	        	 Log.info(revName);
	 			String accName = array[2];
	 			Log.info(accName);
	 			String editedStartDate = array[3];
	 			Log.info(editedStartDate);
	 			String editedInvoiceDate = array[4];
	 			String editedPayTerm = array[5];
	 			//String edProductQuantity = array[8];
	 			//String edProductPrice = array[9];
	 			String editedGlAllocationValue = array[16];
	 			String editedCashAllocationValue= array[7];
	 			String editedGlCount = array[8];
	 			String editedCashCount = array[9];
	 			String revContracttype = array[10];
	 		    String editedPaymentAccount= array[11];
	 		    
	 		   homePage.searchInLauncher("Revenue Accounts");
	 			Log.info("Entered Revenue Accounts tab");
	 			homePage.selectAllView();
	 			Log.info("All list view is displayed ");
	 			revenuePage.findRevenue(revName);
	 			Log.info("Found the revenue account successfully");
	 			
	 			
	 			revenuePage.editNonRecurringRev(editedStartDate, editedInvoiceDate, editedPayTerm, editedPaymentAccount);
	 			minWait();
	 			Log.info("RD edit was successful");
	 			Log.info("Going to validate recurring revenue detail");
	 			revenuePage.validateNewRContract(editedGlCount, editedCashCount);
	 			Log.info("create the recurring revenue detail successfully");
	 		
	 			minWait();
	 			homePage.searchInLauncher("Cash Projection");
	 			minWait();
	 			minWait();
	 			cashProjection.selectFiltercriteria("SB6","Forecast");
	 			cashProjection.validateRecordCreation(glName, accName ,"null",editedCashAllocationValue,revContracttype,editedPayTerm,editedCashCount);
	 			minWait();
	 			/*homePage.searchInLauncher("P&L Forecast");
	 			minWait();
	 			plForecast.selectFiltercriteria("SB6","Forecast");
	 			plForecast.validateRecordCreation(glName, accName, editedGlAllocationValue);*/
	         }
	         
	}
}
