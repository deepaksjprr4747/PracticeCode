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


public class TC03_SingleRDwithMultipleEdit extends BaseTest{
	
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
		d1 = getTestData("Sheet1","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData", alwaysRun = true, enabled= true)
	public void createSingleRevenue(String glName, String revName, String	accName, String	revContracttype, String	startDate, 
			String	invoiceDate, String	endDate, String	payAccountName, String	payTerm, String frequency	, String revRenewDate, 
			String	revProductName, String	productQuantity, String	productPrice, String	glCount, String	cashCount, 
			String	glAllocationValue, String	cashAllocationValue, String	editedStartDate, String	editedInvoiceDate, 
			String	editedEndDate, String	editedPayAccountName, String	editedPayTerm, String	editedFrequency,
			String	editedRevRenewDate, String	editedGlCount, String	editedCashCount, String	editedGlAllocationValue, String	editedCashAllocationValue, String edProductQuantity, String edProductPrice, String subscriptionDate )
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
		
		revenuePage.createNewRContract(revContracttype, startDate, invoiceDate, endDate, subscriptionDate,
				payAccountName, payTerm, frequency, revProductName, productQuantity, productPrice);
		
		Log.info("Revenue detail was successfully created");
		Log.info("Going to validate GL and Cah allocations on recurring revenue detail");
		
		revenuePage.validateNewRContract(glCount, cashCount);
		
		Log.info("Validated the allocations successfully");
		 }
		
		flag=flag+1; 
		loopcount= loopcount+1;
		String[] line = {glName,revName+date,accName+date,editedStartDate,editedEndDate,editedInvoiceDate,editedFrequency,editedPayTerm,edProductQuantity, edProductPrice, editedGlAllocationValue,editedCashAllocationValue,editedGlCount,editedCashCount, revContracttype, subscriptionDate}; 
		csvWrite.addLines(line);
		
		
		
	}
	
	
	
	@Test
	public void editRecRev() throws Exception {
		
	
try {
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
	 			String editedEndDate = array[4];
	 			String editedInvoiceDate = array[5];
	 			String editedFrequency = array[6];
	 			String editedPayTerm = array[7];
	 			String edProductQuantity = array[8];
	 			String edProductPrice = array[9];
	 			String editedGlAllocationValue = array[10];
	 			String editedCashAllocationValue= array[11];
	 			String editedGlCount = array[12];
	 			String editedCashCount = array[13];
	 			String revContracttype = array[14];
	 			String subDate = array[15];
	 		    homePage.searchInLauncher("Revenue Accounts");
	 			Log.info("Entered Revenue Accounts tab");
	 			homePage.selectAllView();
	 			Log.info("All list view is displayed ");
	 			revenuePage.findRevenue(revName);
	 			Log.info("Found the revenue account successfully");
	 			
	 			
	 			revenuePage.editRecurringRevenue(editedStartDate, editedInvoiceDate, editedEndDate, editedPayTerm, editedFrequency, subDate);
	 			minWait();
	 			Log.info("RD edit was successful");
	 			Log.info("Going to validate recurring revenue detail");
	 			revenuePage.validateNewRContract(editedGlCount, editedCashCount);
	 			Log.info("create the recurring revenue detail successfully");
	 		
	 			minWait();
	 			homePage.searchInLauncher("Cash Projection");
	 			minWait();
	 			minWait();
	 			driver.navigate().refresh();
	 			cashProjection.cashFilters(editedInvoiceDate, editedEndDate);
	 			minWait();
	 			minWait();
	 			cashProjection.validateRecordCreation(glName, accName ,editedFrequency,editedCashAllocationValue,revContracttype,editedPayTerm,editedCashCount); 
	 			minWait();
	 			minWait();
	 			homePage.searchInLauncher("P&L Forecast");
	 			minWait();
	 			driver.navigate().refresh();
	 			plForecast.cashFilters(editedInvoiceDate, editedEndDate,"SB6","Forecast","Month");
	 			plForecast.validatePLRecords(glName, accName, editedGlAllocationValue, editedCashAllocationValue,editedPayTerm, revContracttype, editedStartDate, editedEndDate); 
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

	
