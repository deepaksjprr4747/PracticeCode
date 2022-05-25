package com.place.automation.cpm.testcases.employee;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class ReportingSampleTestcase extends BaseTest {

	@BeforeTest
	public void navigateRevPage() throws Exception {
		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
	}
	
	@Test
	public void employeeNavigation() throws Exception {
		homePage.searchInLauncher("Organizations");
		extreporting("Navigating to organzation tab", "Redirected to Organization page", "Pass");
		minWait();
		homePage.searchInLauncher("Employees");
		extreporting("Navigating to Employees tab", "Redirected to Employee page", "Pass");
	}
}
