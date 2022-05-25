package com.place.automation.cpm.testcases;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC07_QBOSetup extends BaseTest {

	String orgNameText = "AutoQBOrg";
	String tabIntegration = "PlaceCPM Admin";

	String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	String orgName = orgNameText + "_" + date; 
	String qboURL = "https://developer.intuit.com/app/developer/homepage";
	String redirectURL;

	@BeforeTest
	public void navigateRevPage() throws Exception {
	//	logger = extent.startTest("navigateRevPage");
		System.out.println("going to login now on scratch");
		loginPage.loginSandbox(Constants.usernameTest, Constants.passwordTest);
		System.out.println("opened the new tab");
		homePage.searchInLauncher("Organizations");
		homePage.selectAllView();
	}

	@Test
	public void createNewOrgSetup() throws InterruptedException {
	//	logger = extent.startTest("createNewOrgSetup");
		Log.info("Setting up a new org to import the data");
		driver.navigate().refresh();
		orgPage.createNewOrg(orgName);

	}

	@Test
	public void setupOrgconfig() throws Exception {
	//	logger = extent.startTest("setupOrgconfig");
		homePage.searchInLauncher(tabIntegration);
		placeCPMAdminPage.configureQBO(orgName);
		placeCPMAdminPage.QBODataSetup(orgName, qboURL);

	}

	@Test
	public void tauthenticateOrg() throws InterruptedException {
	//	logger = extent.startTest("authenticateOrg");
		placeCPMAdminPage.authOrg(orgName);

	}

}
