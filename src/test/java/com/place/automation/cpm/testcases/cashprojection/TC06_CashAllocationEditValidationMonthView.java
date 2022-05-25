package com.place.automation.cpm.testcases.cashprojection;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC06_CashAllocationEditValidationMonthView extends BaseTest{

	String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//GLAndCashValidationCSV.csv";

	List<String[]> r;
	
	int dateLoop;
	
	
	@BeforeTest
	public void navigatePLPage() throws Exception
	{
		System.out.println("going to login now on scratch");
		loginPage.login(Constants.username, Constants.password);
		homePage.searchInLauncher("Cash Projection");

		minWait();
		minWait();
		dateLoop=1;
	}
	
	@Test
	public void plTabExpand() throws InterruptedException, FileNotFoundException, IOException
	{
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
	         r = reader.readAll();
		
		
		for (String[] arrays : r) {
	    	
			Log.info(arrays[1]);
			
			String revEndDate = arrays[13];
			String revStartDate = arrays[11];
			String glName = arrays[0];
			String accName = arrays[1];
			String cashAllocationValue = arrays[18];
			String revBillingCycle = arrays[16];
			String expEDType = arrays[8];
			String cashCount = arrays[20];
			String edPayTerm = arrays[15];
			
			
			int fromMonth = 0;
			int toMonth = 0;
			
			if (revStartDate.substring(0, 2).contains("/")) {
				fromMonth = Integer.parseInt(revStartDate.substring(0, 1));
			} else {
				fromMonth = Integer.parseInt(revStartDate.substring(0, 2));
			}

			int fromYear = Integer.parseInt(revStartDate.substring(revStartDate.length() - 4));
			minWait();
			
			if (revEndDate.substring(0, 2).contains("/")) {
				toMonth = Integer.parseInt(revEndDate.substring(0, 1));
			} else {
				toMonth = Integer.parseInt(revEndDate.substring(0, 2));
			}
			
			int toYear = Integer.parseInt(revEndDate.substring(revEndDate.length() - 4));
			toYear = toYear-1;
			
			toMonth = toMonth+6;
			if(toMonth>12) {
				toMonth=toMonth-12;
				toYear=toYear+1;
			}
			LocalDateTime now = LocalDateTime.now();
			
			if(dateLoop>1) {
				if(now.getYear()-toYear>0) {
						toYear = toYear+1;
					}
				
				else if(now.getYear()-toYear<0) {
					toYear = toYear-1;
				}
			}
			
			if(dateLoop>1) {
				if(now.getYear()-fromYear>0) {
						fromYear = fromYear+1;
					}
				
				else if(now.getYear()-fromYear<0) {
					fromYear = fromYear-1;
				}
			}
			
			Log.info("Starting Cash Projection screen expansion on Month View");
			Log.info("Starting filter selection");
			cashProjection.selectFiltercriteria("SB6","Forecast"); 		//Pass selectFiltercriteria("OrgName") to select manual Org
			
			Log.info("Starting dates selection");
			cashProjection.timePeriodMonthView(fromMonth, fromYear, Constants.cashAndPLPageFromInputBox);
			cashProjection.timePeriodMonthView(toMonth, toYear, Constants.cashAndPLPageToInputBox);
			cashProjection.SubmitDate(Constants.cashAndPLPageApplyButton);
			
			cashProjection.validateRecordCreation(glName, accName ,revBillingCycle,cashAllocationValue,expEDType,edPayTerm,cashCount);
			dateLoop=dateLoop+1;
		}
		
	} catch (Exception e) {
		Log.info(e.getMessage());
	}
	finally {
		String fileX = cashProjection.exportCSV(driver);
		
		cashProjection.csvValidation(fileX);
	}
}
}
