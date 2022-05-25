package com.place.automation.cpm.testcases.employee;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.place.automation.cpm.base.BaseTest;
import com.place.automation.cpm.pages.CashProjectionBeta;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;
import com.place.automation.utils.WriteCSV;

public class TC02_EmployeeCreationWithMultipleEdits extends BaseTest{
	int Loop =0;
	int loopcount= 0;
	Object d1[][];
	
	String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//Editedvalues.csv";
	WriteCSV csvWrite = new WriteCSV(filePath);
	List<String[]> r;
	
	@BeforeTest
	public void navigateRevPage() throws Exception {
		Log.info("going to login now");
		loginPage.login(Constants.username, Constants.password);
		
	}
	@AfterMethod
	public void closecsv() throws Exception {
		if(d1.length==loopcount) {
		csvWrite.closeFile();
		}
		
	}
	@DataProvider
	public Object[][] getData() {
		System.out.println("entering inside object method");
		d1= getTestData("Sheet 7","ExpRevFinal.xlsx");
		return d1;
	}
	
	@Test(dataProvider = "getData")
	public void createSingleEmployee(String org, String department, String role, String name, String office, String startdate, String empEndDate , String compEndDate,String annualSalary, String payrollFreq, String wageCount,String incEmpEndDate,String incCompStartDate, String	incCompEndDate, String	incAnnualSalary, String edEmpEndDate ,String incEdEmpEndDate, String edCompEndDate, 
			String	edSalary, String	edPayrollFreq,String edWageCount, String edOffice, String edRole , String incEdCompEndDate, String edCompWageCount, String edBonus, String edbPeriod, String edbFreq, String edWageAllocation, String edWageGL, String	edBonusGL, String	edTaxGL) throws Exception {
		minWait();
		if(Loop==0) {
		
			homePage.searchInLauncher("Organizations");
			Log.info("Navigated to organization tab");
			minWait();
			Log.info("Creating new Employee");
			employee.createEmployee(org, department, role, name, office, startdate, empEndDate);
			Log.info("Going to create compensation for the employee");
			employee.createCompensation(startdate, annualSalary, payrollFreq,compEndDate,"Bonus1");
			//employee.validateWages(wageCount);
			minWait();
			minWait();
			
		}
Loop=Loop+1;
		
loopcount= loopcount+1;
		
			String[] line = {  name,   edEmpEndDate ,  edCompEndDate, edSalary, 	edPayrollFreq, edWageCount, edOffice, edRole  ,incEdEmpEndDate, startdate,payrollFreq, annualSalary,incEdCompEndDate , edCompWageCount, 
					edBonus, edbPeriod, edbFreq, edWageAllocation,edWageGL,	edBonusGL, edTaxGL}; 
			csvWrite.addLines(line);
			minWait();
		
	}
	@Test
	public void editEmployee() throws Exception {
		
	

		CSVReader reader = new CSVReader(new FileReader(filePath));
	         r = reader.readAll();
	         
	         for (String[] array : r) {
	        	 String empName = array[0];
	        	 String edEmpEndDate = array[1];
	        	 String edCompEndDate = array[2];
	        	 String edSalary = array[3];
	        	 String edPayrollFreq = array[4];
	        	 String edWageCount = array[5];
	        	 String edOffice = array[6];
	        	 String edRole = array[7];
	        	 String incEdEmpEndDate = array[8];
	        	 String startdate = array[9];
	        	 String payrollFreq = array[10];
	        	 String annualSalary = array[11];
	        	 String incEdCompEndDate = array[12];
	        	 String edCompWageCount = array[13];
	        	 String edBonus = array[14];
	        	 String edbPeriod = array[15];
	        	 String edbFreq = array[16];
	        	 String edWageAllocation = array[17];
	        	 String edWageGL= array[18];
	        	 String	edBonusGL= array[19];
	        	 String	edTaxGL= array[20];
	        	 
	        /* homePage.searchInLauncher("Employees");
		 			Log.info("Entered Employee tab");
		 			
		 			
		 			employee.editEmployee(edEmpEndDate,edRole,edOffice,incEdEmpEndDate);
		 			employee.validateWages(edWageCount);
		 			homePage.searchInLauncher("Cash Projection (Beta)");
		 			minWait();
		 			minWait();
		 			//driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			plForecast.cashFilters(startdate, edEmpEndDate,"SB6","Forecast","Month");
		 			Log.info("*************Validating employee changes on Wage on Cash screen***********");
		 			cashProjectionBeta.validateWageRecord("Job Expenses - DSSB6", empName, payrollFreq, startdate, edEmpEndDate, annualSalary,"100000","Wage", "On Delivery","Monthly");
		 			minWait();*/
		 			
		 			homePage.searchInLauncher("Employees");
		 			extreporting("Navigating to employee page", "Redirected to employee page successfully", "Pass");
		 			employee.compensationEdit(edCompEndDate, edSalary, edPayrollFreq, incEdCompEndDate,edBonus);
		 			extreporting("Navigating to compensation record to edit", "Compensation was edited successfully", "Pass");
		 			minWait();
		 			//employee.validateWages(edCompWageCount);
		 			homePage.searchInLauncher("Cash Projection (Beta)");
		 			minWait();
		 			minWait();
		 			extreporting("Navigating to Cash Projection(Beta) page", "Redirected to Cash Projection (Beta) page successfully", "Pass");
		 		   Log.info("*************Validating Wage on Cash screen***********");
		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 		    plForecast.cashFilters(startdate, edCompEndDate,"SB6","Forecast","Month");
		 		
		 			cashProjectionBeta.validateWageRecord(edWageGL, empName, edPayrollFreq, startdate, edCompEndDate, edSalary,edWageAllocation, "Wage",edbPeriod,edbFreq);
		 			extreporting("Validating wage allocation on Cash Projection (beta) page", "Validated wage allocations successfully", "Pass");
		 			minWait();
		 			Log.info("************Validating Bonus on cash Screen***********");
		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			plForecast.cashFilters(startdate, edCompEndDate,"SB6","Forecast","Month");
		 			cashProjectionBeta.validateWageRecord(edBonusGL, empName, edPayrollFreq, startdate, edCompEndDate, edSalary,edWageAllocation,"Bonus", edbPeriod,edbFreq);
		 			extreporting("Validating bonus allocation on Cash Projection (beta) page", "Validated bonus allocations successfully", "Pass");
		 			driver.navigate().refresh();
		 			Log.info("************Validating Tax on cash Screen***********");
		 			minWait();
		 			minWait();
		 			plForecast.cashFilters(startdate, edCompEndDate,"SB6","Forecast","Month");
		 			cashProjectionBeta.validateWageRecord(edTaxGL, empName, edPayrollFreq, startdate, edCompEndDate, edSalary,edWageAllocation,"Tax", edbPeriod,edbFreq);
		 			extreporting("Validating tax allocation on Cash Projection (beta) page", "Validated tax allocations successfully", "Pass");

		 			minWait();
		 			
		 			
		 			homePage.searchInLauncher("P&L Forecast (Beta)");
		 			extreporting("Navigating to P&L Forecast(Beta) page", "Redirected to P&L Forecast (Beta) page successfully", "Pass");

		 			Log.info("*************Validating Wage on P&L screen***********");
		 			minWait();
		 			minWait();
		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 		    plForecast.cashFilters(startdate, edEmpEndDate,"SB6","Forecast","Month");
		 		
		 		   plForecastBeta.validateEmployeeRecord(edWageGL, empName, edPayrollFreq, startdate, edCompEndDate, edSalary,edWageAllocation, "Wage", edbPeriod,edbFreq);
		 			extreporting("Validating wage allocation on P&L Forecast (beta) page", "Validated wage allocations successfully", "Pass");

		 		   minWait();
		 			Log.info("*************Validating Bonus on P&L screen***********");
		 			driver.navigate().refresh();
		 			minWait();
		 			minWait();
		 			plForecast.cashFilters(startdate, edCompEndDate,"SB6","Forecast","Month");
		 			plForecastBeta.validateEmployeeRecord(edBonusGL, empName, edPayrollFreq, startdate, edCompEndDate, edSalary,edWageAllocation,"Bonus", edbPeriod,edbFreq);
		 			extreporting("Validating bonus allocation on P&L Forecast (beta) page", "Validated bonus allocations successfully", "Pass");

		 			driver.navigate().refresh();
		 			Log.info("*************Validating Tax on P&L screen***********");
		 			minWait();
		 			minWait();
		 			plForecast.cashFilters(startdate, edCompEndDate,"SB6","Forecast","Month");
		 			plForecastBeta.validateEmployeeRecord(edTaxGL, empName, edPayrollFreq, startdate, edCompEndDate, edSalary,edWageAllocation,"Tax", edbPeriod,edbFreq);
		 			extreporting("Validating tax allocation on P&L Forecast (beta) page", "Validated tax allocations successfully", "Pass");

		 			minWait();
		 			CashProjectionBeta.finalBonusValue.clear();
		 			System.out.println(CashProjectionBeta.finalBonusValue.size());
		 			CashProjectionBeta.wageValue.clear();
		 			System.out.println(CashProjectionBeta.wageValue.size());
		 	
		 			
	         }

	         
	}
}
