package com.place.automation.cpm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;

public class createGLs extends BaseTest{
	
	
//	@Test(priority=0, alwaysRun = true)
//	public void atestCase1() throws Exception
//	{
//		System.out.println("entering in testCase1 createGl file");
//		loginPage.login(Constants.username, Constants.password);
//		homePage.searchInLauncher("GL Accounts");
//		
//	}
//	
	@DataProvider
	public Object[][] getData()
	{
		System.out.println("entering inside object method");
		Object d1[][] = getTestData("Sheet3","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData")
	public void createDataGL(String glName, String seq, String plCategory, String classType, String cashCategory, String glCode) throws InterruptedException
	{
		glAccountPage.createNewGL(glName, seq, plCategory, classType, cashCategory, glCode);
	
	}
	

}
