package com.place.automation.cpm.testcases;


import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC01_CreateExpenseAc extends BaseTest {

	String glName = "Design income - DSSB6";
	String expName = "Quarter Party Expense";
	String edType = "Recurring";

	@BeforeTest
	public void login() throws Exception {
	//	logger = extent.startTest("login");
		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
		// loginPage.loginSandbox(Constants.usernameTest, Constants.passwordTest);
		homePage.searchInLauncher("Expense Accounts");
		Log.info("logged in successfully");
		homePage.selectAllView();
	}

	@Test(priority = 1, alwaysRun = true)
	public void createNewExpense() throws InterruptedException {
	//	logger = extent.startTest("createNewExpense");
		Log.info("entered in createNewExpense");
		expensePage.createNewExpense(glName, expName,"a");
		driver.navigate().refresh();
		Log.info("Expense account created successfully");

	}

	@DataProvider
	public Object[][] getData() {
		Log.info("entering inside object method");
		Object d1[][] = getTestData("Sheet1", "ExpOnly.xlsx");
		return d1;
	}

	@Test(dataProvider = "getData", priority = 2, alwaysRun = true)
	public void createED(String edType, String startDate, String invoiceDate, String expAmount, String endDate,
			String payAccountName, String payTerm, String freqency, String glCount, String cashCount)
			throws InterruptedException {
	//	logger = extent.startTest("createED");
		
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String updatedExpName = expName + "_" + date;
		String vendorName = "vendor_" +date;
		
		expensePage.createNewExpense(glName, updatedExpName, vendorName);
		driver.navigate().refresh();
		Log.info("Expense account created successfully");
		
		Log.info("Going to create recurring expense detail");
		expensePage.createNewRecED(edType, startDate, invoiceDate, expAmount, endDate, payAccountName, payTerm, freqency,
				glCount, cashCount);
		Log.info("create the recurring expense detail successfully");

	}

}
