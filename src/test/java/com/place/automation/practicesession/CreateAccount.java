package com.place.automation.practicesession;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;

import jdk.internal.org.jline.utils.Log;

public class CreateAccount extends BaseTest{
	
	String accName = "PlaceAutomationAccount";
	String accBillingStreet = "Kcc Nagar Ajmer Road";
	String accBillingCity = "Jaipur";
	String accBillingState = "Rajasthan";
	String accZipCode = "302024";
	String accCounty = "India";
	
	
	@Test(priority = 1)
	public void navigateToAccountPage() throws InterruptedException
	{
		
		loginPage.login(Constants.username, Constants.password);
		
	}
	
	
	@Test(priority = 2)
	public void createAcccount() throws Exception
	{
		homePage.searchInLauncher("Accounts");
		accountPage.fillrequiredDetails(accName, accBillingStreet, accBillingCity, accBillingState, accZipCode, accCounty);
	}

}
