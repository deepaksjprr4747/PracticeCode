package com.place.automation.cpm.testcases.employee;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC01_CreateNewEmployee extends BaseTest{
	//EmployeePage employee= new EmployeePage();
	
	@BeforeTest
	@Parameters({"un","pw"})
	public void navigateRevPage(String un, String pw) throws Exception {
		Log.info("going to login now");
		loginPage.login(un,pw);
	}
	@DataProvider
	public Object[][] getData() {
		System.out.println("entering inside object method");
		Object d1[][] = getTestData("Sheet 6","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData")
	public void createEmployee(String org, String department, String role, String name, String office, String startdate, String endDate , String annualSalary, String payrollFreq, String wageCount, String incEmpEndDate , 
			String incCompStartDate, String	incCompEndDate, String	incAnnualSalary,String bonusPlan, String bPeriod, String bFreq) throws Exception {
		minWait();
		homePage.searchInLauncher("Organizations");
		extreporting("Navigating to organization tab", "Redirected to organization page successfully", "Pass");
		minWait();
		
		//Log.info("Creating new Employee");
		employee.createEmployeeWithValidation(org, department, role, name, office, startdate, endDate,incEmpEndDate);
		extreporting("Creating Employee record with validation checks", "Employee created successfully", "Pass");
		//Log.info("Going to create compensation for the employee");
		//homePage.searchInLauncher("Organizations");
		//extreporting("Creating compensation for the employee created", "Failed to create compensation because element was not visible", "Fail");
		employee.createCompensationWithValidation(startdate, annualSalary, payrollFreq, incCompStartDate,	incCompEndDate, incAnnualSalary,endDate,bonusPlan);
		extreporting("Creating compensation for the employee created", "Compensation record created successfully", "Pass");
		employee.validateWages(wageCount);
		extreporting("Validating Wage count ", "Wage count validated successfully", "Pass");
		minWait();
		minWait();
		homePage.searchInLauncher("Cash Projection (Beta)");
		minWait();
		minWait();
		driver.navigate().refresh();
		Log.info("***Validationg Wage values on cash******");
		minWait();
		minWait();
		plForecast.cashFilters(startdate, endDate,"SB6","Forecast","Month");
	    cashProjectionBeta.validateWageRecord("Job Expenses - DSSB6", name, payrollFreq, startdate, endDate, annualSalary,"100000","Wage", bPeriod,bFreq);
	    extreporting("Validating wage allocation on Cash Projection (beta)", "Validated wages successfully", "Pass");
		minWait();
		driver.navigate().refresh();
		minWait();
		minWait();
		Log.info("***Validationg bonus values on cash******");
		plForecast.cashFilters(startdate, endDate,"SB6","Forecast","Month");
		cashProjectionBeta.validateWageRecord("Accumulated Adjustment_New - DSSB6", name, payrollFreq, startdate, endDate, annualSalary,"100000","Bonus",bPeriod, bFreq);
		extreporting("Validating bonus record on Cash Projection (beta)", "Bonus allocations validated successfully", "Pass");
		minWait();
		Log.info("****Validating tax values on cash****** ");
		driver.navigate().refresh();
		minWait();
		minWait();
		plForecast.cashFilters(startdate, endDate,"SB6","Forecast","Month");
		cashProjectionBeta.validateWageRecord("Opening Balance Equity - DSSB6", name, payrollFreq, startdate, endDate, annualSalary,"100000","Tax", bPeriod,bFreq);
		extreporting("Validating tax record on Cash Projection (beta)", "Tax allocations validated successfully", "Pass");
		minWait();
		minWait();
		homePage.searchInLauncher("P&L Forecast (Beta)");
		minWait();
		minWait();
		driver.navigate().refresh();
		minWait();
		Log.info("****Validating Wage values on PL****** ");
		minWait();
		plForecast.cashFilters(startdate, endDate,"SB6","Forecast","Month");
	
		plForecastBeta.validateEmployeeRecord("Job Expenses - DSSB6", name, payrollFreq, startdate, endDate, annualSalary,"100000", "Wage",bPeriod, bFreq);
		extreporting("Validating wage record on P&L forecast (beta)", "Wage allocations validated successfully", "Pass");
		minWait();
		driver.navigate().refresh();
		Log.info("****Validating Bonus values on PL****** ");
		minWait();
		minWait();
		plForecast.cashFilters(startdate, endDate,"SB6","Forecast","Month");
		plForecastBeta.validateEmployeeRecord("Accumulated Adjustment_New - DSSB6", name, payrollFreq, startdate, endDate, annualSalary,"100000","Bonus", bPeriod,bFreq);
		extreporting("Validating Bonus record on P&L forecast (beta)", "Bonus allocations validated successfully", "Pass");
		driver.navigate().refresh();
		Log.info("****Validating tax values on PL****** ");
		minWait();
		minWait();
		plForecast.cashFilters(startdate, endDate,"SB6","Forecast","Month");
		plForecastBeta.validateEmployeeRecord("Opening Balance Equity - DSSB6", name, payrollFreq, startdate, endDate, annualSalary,"100000", "Tax",bPeriod, bFreq);
		extreporting("Validating tax record on P&L forecast (beta)", "Tax allocations validated successfully", "Pass");
		minWait();
		
	}
	
}
