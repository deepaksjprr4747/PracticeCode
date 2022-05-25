package com.place.automation.cpm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;


public class TC04_VerifyExpTTT extends BaseTest{
	
	String glName = "Auto Photo Exp";
	String expName = "USA photoGExp";
	String startDate = "Start Date";
	String endDate = "End Date";
	String invoiceDate = "Invoice Date";
	String expAmount = "Expense Amount";
	String autoRenew = "Auto Renew";
	String payAccount = "Payment Account";
	String payTerm = "Payment Term (After # Days)";
	String payFreq = "Payment Frequency";
	String perLicCost = "Per License Cost";
	String Account = "Account";
	String GlAcc = "GL Account";
	
	
	
	//@BeforeTest
	@Test(priority=0, alwaysRun = true)
	public void login() throws Exception
	{
		
		logger = extent.startTest("login");
		Log.info("going to start with login method");
		loginPage.login(Constants.username, Constants.password);
		
		homePage.searchInLauncher("Expense Accounts");
		homePage.selectRecentlyViewed();
	
	}
	
	@Test(priority=1, alwaysRun = true)
	public void createNewExpense() throws InterruptedException
	{
		logger = extent.startTest("createNewExpense");
		Log.info("we are inside createnewExp method");
		expensePage.createNewExpense(glName, expName,"A");
		driver.navigate().refresh();		
	}
	
	@Test(priority=2, alwaysRun = true)
	public void testExpTTT() throws InterruptedException
	{
		
		logger = extent.startTest("testExpTTT");
		Log.info("entered inside testEXPTTT");
		expensePage.clickRecurringExp();
		
		expensePage.createNewEDwithTTT(startDate, expensePage.startDateTTTValue);
		expensePage.createNewEDwithTTT(endDate, expensePage.endDateTTTValue);
		expensePage.createNewEDwithTTT(invoiceDate, expensePage.invoiceDateTTTValue);
		
		expensePage.createNewEDwithTTT(expAmount, expensePage.expAmountTTTValue);
		expensePage.createNewEDwithTTT(autoRenew, expensePage.autoRenTTTValue);
		expensePage.createNewEDwithTTT(payAccount, expensePage.payAccount);
		
		expensePage.createNewEDwithTTT(payTerm, expensePage.payTermTTTValue);
		expensePage.createNewEDwithTTT(payFreq, expensePage.payFreqTTTValue);
		expensePage.createNewEDwithTTT(perLicCost, expensePage.perLicCostTTTValue);
		expensePage.closeEDpopup();
		
	}
	
	@Test(priority=3, alwaysRun = true)
	public void testExpTTTNonRec() throws InterruptedException
	{
		logger = extent.startTest("testExpTTTNonRec");
		expensePage.clickNonRecurringExp();
		expensePage.createNewEDwithTTT(startDate, expensePage.startDateTTTValue);
		expensePage.createNewEDwithTTT(invoiceDate, expensePage.invoiceDateTTTValue);
		expensePage.createNewEDwithTTT(expAmount, expensePage.expAmountTTTValue);
		expensePage.createNewEDwithTTT(payTerm, expensePage.payTermTTTValue);
		expensePage.createNewEDwithTTT(payAccount, expensePage.payAccount);
		expensePage.closeEDpopup();
		
	}
	
	
	

}
