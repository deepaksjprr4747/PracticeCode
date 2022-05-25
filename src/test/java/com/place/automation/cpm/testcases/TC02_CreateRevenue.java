package com.place.automation.cpm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;

public class TC02_CreateRevenue extends BaseTest{

	
	
	String glName = "Auto Photo Exp";
	String revName = "Party Revenue";
	String revContractType = "New Recurring";
	String revStartDate = "1/1/2020";
	String revInvoiceDate = "1/1/2020";
	String revEndDate = "12/31/2020";
	String revPayAccountName = "HDFC Bank Account";
	String revPayTerm = "On Delivery";
	String revBillingCycle = "Monthly";
	String revRenewDate = "1/2/2020";
	String revProductName = "SF License";
	String productQty = "2";
	String productPrice = "70";
	
	
	@BeforeTest
	public void navigateRevPage() throws Exception
	{
		System.out.println("going to login now");
		loginPage.login(Constants.username, Constants.password);
		homePage.searchInLauncher("Revenue Accounts");
		homePage.selectRecentlyViewed();
		minWait();
	}
	
	@Test(priority=1, alwaysRun = true)
	public void createNewRevenueAc() throws InterruptedException
	{
		System.out.println("we are inside createnewRevenue method");
//		revenuePage.createNewRevenueAccount(glName, revName);
		driver.navigate().refresh();
		
	}
	
	
	
	@Test(priority=2, alwaysRun = true)
	public void createRevenueDemo() throws InterruptedException {
		
		System.out.println("we are inside revenuecontract method");
		
		revenuePage.createNewRContract(revContractType, revStartDate, revInvoiceDate, revEndDate, revRenewDate, revPayAccountName, revPayTerm, revBillingCycle, revProductName, productQty, productPrice);
		
	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		System.out.println("entering inside object method");
//		Object d1[][] = getTestData("Sheet2");
//		return d1;
//	}
//	
//	@Test(dataProvider = "getData", priority=2, alwaysRun = true)
//	public void createNewRContract(String revContractType, String revStartDate, String revInvoiceDate, String revEndDate, String revRenewDate, String revPayAccountName, String revPayTerm, String revBillingCycle, String revProductName, String productQty, String productPrice) throws InterruptedException
//	{
//		System.out.println("we are inside createRcontract method");
//		revenuePage.createNewRContract(revContractType, revStartDate, revInvoiceDate, revEndDate, revRenewDate, revPayAccountName, revPayTerm, revBillingCycle, revProductName, productQty, productPrice);
//		
//	}
	
	
	
}
