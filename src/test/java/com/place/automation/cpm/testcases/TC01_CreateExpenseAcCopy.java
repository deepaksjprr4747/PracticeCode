package com.place.automation.cpm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC01_CreateExpenseAcCopy extends BaseTest{
	
	
	String glName = "Auto Photo Exp";
	String expName = "Party Expense";
	String edType = "Recurring";
	String startDate = "01/01/2020";
	String invoiceDate = "01/01/2020";
	String expAmount = "125";
	String endDate = "12/31/2020";
	String payAccountName = "HDFC Bank Account";
	String payTerm = "On Delivery";
	String freqency = "Monthly";
	

	
	@BeforeTest
	public void login() throws Exception {
		
		Log.info("we are starting the execution from login method");
		System.out.println("going to login now");
		loginPage.login(Constants.username, Constants.password);
		
		homePage.searchInLauncher("Expense Accounts");
		homePage.selectRecentlyViewed();
		System.out.println("coming out from login method");
	}
	
//	@Test(priority=1, alwaysRun = true)
//	public void createNewExpense() throws InterruptedException {
//		
//		System.out.println("we are inside createnewExp method");
//		expensePage.createNewExpense(glName, expName);
//		driver.navigate().refresh();
//		System.out.println("coming out from createNewExpense method");
//		System.out.println("we are inside createED method");
//		expensePage.createNewED(edType, startDate, invoiceDate, expAmount, endDate, payAccountName, payTerm, freqency);
//		System.out.println("coming out from createExpenseDemo method");
//		
//	}
	
//	@Test(priority=2, alwaysRun = true)
//	public void createExpenseDemo() throws InterruptedException {
//		
//		System.out.println("we are inside createExpenseDemo method");
//		expensePage.createNewED(edType, startDate, invoiceDate, expAmount, endDate, payAccountName, payTerm, freqency);
//		System.out.println("coming out from createExpenseDemo method");
//		
//	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		System.out.println("entering inside object method");
		Object d1[][] = getTestData("Sheet1", "ExpRevFinal.xlsx");
		return d1;
	}
	

	@Test(dataProvider = "getData", priority=2, alwaysRun = true)
	public void createED(String edType, String startDate, String invoiceDate, String expAmount, String endDate, String payAccountName, String payTerm, String freqency) throws InterruptedException
	{
		System.out.println("we are inside createED method");
		//expensePage.createNewED(edType, startDate, invoiceDate, expAmount, endDate, payAccountName, payTerm, freqency);
		
	}
		

}
