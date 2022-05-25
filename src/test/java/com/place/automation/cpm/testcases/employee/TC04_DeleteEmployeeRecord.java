package com.place.automation.cpm.testcases.employee;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC04_DeleteEmployeeRecord extends BaseTest {

	int Loop =0;
	int loopcount= 0;
	Object d1[][];
	
	
	
	@BeforeTest
	public void navigateRevPage() throws Exception {
		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
		
	}
	
		
	
	@DataProvider
	public Object[][] getData() {
		System.out.println("entering inside object method");
		d1= getTestData("Sheet 6","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData")
	public void deleteEmployee(String org, String department, String role, String name, String office, String startdate, String endDate , String annualSalary, String payrollFreq, String wageCount, String incEmpEndDate , String incCompStartDate, String	incCompEndDate, String	incAnnualSalary, String bonusPlan, String	bPeriod, String bFreq) throws Exception {
		minWait();
		if(Loop==0) {
		
			homePage.searchInLauncher("Organizations");
 			extreporting("Navigating to Organizations page", "Redirected to Organizations page successfully", "Pass");

			minWait();
			employee.createEmployee(org, department, role, name, office, startdate, endDate);
 			extreporting("Creating Employee record", "Created Employee record successfully", "Pass");

			
			employee.createCompensation(startdate, annualSalary, payrollFreq,endDate,"Bonus1");
 			extreporting("Creating Compensation record", "Created compensation record successfully", "Pass");
	
			minWait();
	
	        	 homePage.searchInLauncher("Employees");
		  			extreporting("Navigating to Employees page", "Redirected to Employee page successfully", "Pass");

		 			
		 			employee.deleteEmployee();
		  			extreporting("Deleting Employee record ", "Deleted Employee record successfully", "Pass");

		 			minWait();
		 			homePage.searchInLauncher("Cash Projection (Beta)");
		  			extreporting("Navigating to Cash Projection (Beta) page", "Redirected to Cash Projection (Beta) page successfully", "Pass");

		 			minWait();
		 			minWait();
		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			cashProjectionBeta.deletedCompVerification("Job Expenses - DSSB6");
		  			extreporting("Validating the deleted wage records", "Validated that the wage records are deleted", "Pass");

		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			Log.info("Validating dleted tax records");
		 			cashProjectionBeta.deletedCompVerification("Opening Balance Equity - DSSB6");
		  			extreporting("Validating the deleted tax records", "Validated that the tax records are deleted", "Pass");

		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			Log.info("Validating deleted bonus record ");
		 			cashProjectionBeta.deletedCompVerification("Accumulated Adjustment_New - DSSB6");
		  			extreporting("Validating the deleted bonus records", "Validated that the bonus records are deleted", "Pass");

		 			minWait();
		 			minWait();
		 			homePage.searchInLauncher("P&L Forecast (Beta)");
		  			extreporting("Navigating to P&L Forecast (Beta) page", "Redirected to P&L Forecast (Beta) page successfully", "Pass");

		 			minWait();
		 			minWait();
		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			Log.info("Entered Cash Projection beta tab to validate deleted Wage record");
		 			cashProjectionBeta.deletedCompVerification("Job Expenses - DSSB6");
		  			extreporting("Validating the deleted wage records", "Validated that the wage records are deleted", "Pass");

		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			Log.info("Validating dleted tax records");
		 			cashProjectionBeta.deletedCompVerification("Opening Balance Equity - DSSB6");
		  			extreporting("Validating the deleted tax records", "Validated that the tax records are deleted", "Pass");

		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			Log.info("Validating deleted bonus record ");
		 			cashProjectionBeta.deletedCompVerification("Accumulated Adjustment_New - DSSB6");
		  			extreporting("Validating the deleted bonus records", "Validated that the bonus records are deleted", "Pass");

	         }
	}


}
