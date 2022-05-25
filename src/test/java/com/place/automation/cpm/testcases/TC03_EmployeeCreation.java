package com.place.automation.cpm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;

public class TC03_EmployeeCreation extends BaseTest{
	
	
	
	String orgNameText = "Autoplex3";
	String deptNameText = "Sales";
	String glName = "Wages and Salaries";
	String roleNameText = "Sales Manager";
	
	
	@BeforeTest
	public void navigateRevPage() throws Exception
	{
		System.out.println("going to login now");
		//loginPage.login(Constants.username, Constants.password);
		loginPage.loginSandbox(Constants.usernameTest, Constants.passwordTest);
		homePage.searchInLauncher("Organizations");
		homePage.selectRecentlyViewed();
		//minWait();
	}
	
	@Test
	public void createNewOrgSetup() throws InterruptedException
	{
		System.out.println("we are inside createNewOrgSetup method");
		driver.navigate().refresh();
		orgPage.createNewOrg(orgNameText);
		//orgPage.createNewDept(deptNameText, glName);
		//orgPage.createNewRole(deptNameText, roleNameText);
		
	}

	
}
