package com.place.automation.cpm.pages;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Log;




public class EmployeePage extends BasePage {

	public By orgSearch = By.xpath("//input[@placeholder='Search this list...']");
	public By employeeNewButton = By.xpath("(//button[text()='New'])[1]");
	public By employeeSalesRT = By.xpath("//span[text()='Sales Employee']//parent::div//preceding-sibling::div");
	public By employeeRTNext = By.xpath("//span[text()='Next']");
	public By employeeName = By.xpath("//input[@name='Name']");
	public By employeeOffice = By.xpath("//input[@placeholder='Search Offices...']");
	public By employeeOfficeSelection = By.xpath("//input[@placeholder='Search Offices...']//parent::div//following::div[contains(@class,'slds-dropdown')]//child::ul");
	public By employeeStartDtate = By.xpath("//label[text()='Employee Start Date']//following-sibling::div//child::input");
	public By employeeEndDate = By.xpath("//label[text()='Employee End Date']//following-sibling::div//child::input");
	public By employeeSaveButton = By.xpath("//button[text()='Save']");
	public By employeeHeader = By.xpath("//a[contains(@class,'header-title-container')]//*[text()='Employees']");
	public By employeeNewCompensation = By.xpath("(//button[text()='New'])[1]");
	public By employeeCompStartDate = By.xpath("//label[text()='Start Date']//following-sibling::div/input");
	public By employeeCompAnnualSalary = By.xpath("//label[text()='Annual Salary']//following-sibling::div/input");
	public By employeeCompPayrollFreq = By.xpath("//label[text()='Payroll Frequency']//following-sibling::div//child::input");
	public By employeeCompSave = By.xpath("//button[text()='Save']");
	public By employeeCompensationHeader = By.xpath("//span[text()='Compensations']");
	public By employeeWagesHeader = By.xpath("//span[text()='Wages']//parent::a");
	public By employeeWagesCount = By.xpath("//a[contains(@title,'Wage-')]");
	public By employeeEndDateValidation = By.xpath("//div[text()='End Date should be after Start Date.']");
	public By employeeCompStartDateValidation = By.xpath("//li[text()='Compensation Start Date Can not be Less than Employee Start Date']");
	public By employeeSalaryValidation = By.xpath("//li[text()='Annual Salary can not be negative']");
	public By employeeCompEndDate = By.xpath("//label[text()='End Date']//parent::div//child::div/input");
	public By employeeCompEndDateValidation = By.xpath("//li[text()='End Date Should be greater then Start Date']");
	public By employeeBonus = By.xpath("//label[text()='Bonus Plan']//parent::lightning-grouped-combobox//descendant::input");
	public By employeeCompRec = By.xpath("//a[contains(text(),'Comp')]");
	public By employeeDesc = By.xpath("//th[@title='Employee Name']/div/a");
	public By employeeDateDesc = By.xpath("//span[text()='Created Date']");
	public By employeeEditButton = By.xpath("//button[text()='Edit']");
	public By employeeEndDateEdit = By.xpath("//label[text()='Employee End Date']//parent::div//child::div/input");
	public By employeeRoleClearSelection = By.xpath("//label[text()='Employee Role']//parent::lightning-grouped-combobox//button[@title='Clear Selection']");
	public By employeeRoleEdit = By.xpath("//label[text()='Employee Role']//parent::lightning-grouped-combobox//input");
	public By employeeOfficeClearSelection = By.xpath("//label[text()='Office']//parent::lightning-grouped-combobox//button[@title='Clear Selection']");
	public By employeeOfficeEdit = By.xpath("//label[text()='Office']//parent::lightning-grouped-combobox//input");
	public By employeeConfirmButton = By.xpath("//button[text()='Confirm']"); 
	public By employeeEditEndDateValidation = By.xpath("//div[text()='End Date should be after Start Date.']");
	public By employeeCompEditValidation = By.xpath("//h2[text()='Compensation End Date Should not be Greater than Employee’s End Date.']");
	public By employeeCompensationDelButton = By.xpath("//button[text()='Delete']");
	public By employeeCompDeleteCheck = By.xpath("//span[text()='Compensations']//following-sibling::span[@title='(0)']");
	public By empoloyeeCompDeleteConfirm = By.xpath("//button[@class='slds-button slds-button_brand']");
	public By employeeSearchSideBar = By.xpath("//div[@class='slds-th__action']");
	public By employeeNoItemsPresent = By.xpath("//p[text()='No items to display.']");
	public By employeeBonusClearSelection = By.xpath("//label[text()='Bonus Plan']//parent::lightning-grouped-combobox//descendant::button[@title='Clear Selection']");
	public By employeeDownarrow = By.xpath("//span[text()='Show Actions']//parent::span");
	public By employeeDeleteButton = By.xpath("//div[text()='Delete']//parent::a");
	
	public static String employeeWithDate = "";
	
public EmployeePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
/*This method creates a new employee with existing org , Role, department and office 
@param org(String) : An organization record should exist on which we need to create employee 
@param department(String) : A department record should exist on which we need to create employee 
@param role(String): A role record should exist on which we need to create employee 
@param name(String): Name of the employee 
@param office(String): Office should pre-exist in the org 
@param startDate(String) : Employee start Date in the organization 
@param endDate: employee end date
@param incEndDate : incorrect end date */

	
	public void createEmployeeWithValidation (String org, String department, String role, String name, String office, String startDate, String endDate, String incEndDate) throws InterruptedException, ParseException 
	{
		
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		employeeWithDate= name + date;
		click(driver, orgSearch);
		//enterText(driver, orgSearch, org);
		driver.navigate().refresh();
		
		boolean orgPresence = verifyPresence(By.xpath("//a[text()='"+org+"']"));
		if(orgPresence==true) 
		{
			Log.info(org+"org found successfully");
		click(driver, By.xpath("//a[text()='"+org+"']"));
		
		minWait();
		driver.navigate().refresh();
		minWait();
		boolean deptPresence = verifyPresence(By.xpath("//div[@class='slds-grid']/a//*[text()='"+department+"']"));
		if(deptPresence==true) 
		 {
			Log.info(department+"Department is present");
			click(driver, By.xpath("//div[@class='slds-grid']/a//*[text()='"+department+"']"));//remove star
			
			minWait();
			driver.navigate().refresh();
			scrollByPixel();
			minWait();
			boolean rolePresence = verifyPresence(By.xpath("//div[@class='slds-grid']/a//*[text()='"+role+"']"));//remove star
			if(rolePresence==true) 
			{
				Log.info(role+"Role is present");
			click(driver, By.xpath("//div[@class='slds-grid']/a//*[text()='"+role+"']"));
			
			minWait();
			driver.navigate().refresh();
			minWait();
			Log.info("Creating new employee record");
			click(driver, employeeNewButton);
			click(driver, employeeSalesRT);
			click(driver, employeeRTNext);
			enterText(driver, employeeName, name+date);
			enterText(driver, employeeStartDtate, startDate);
			enterText(driver, employeeOffice, office);
			click(driver, employeeOfficeSelection);
			
			Log.info("Checking validation message when end date is less than start date");
			enterText(driver, employeeEndDate, incEndDate);
			click(driver, employeeSaveButton);
			verifyPresence(employeeEndDateValidation);
			Log.info("Validated end date:"+incEndDate +"is smaller than start date:"+startDate);
			enterText(driver, employeeEndDate, endDate);
			minWait();
			click(driver, employeeSaveButton);
			minWait();
			Log.info("Now end date:"+endDate+"is greater than start date:"+startDate);
			Log.info("Employee record created successfully ");
			Log.info("Navigating to the employee record");
			
			click(driver, employeeHeader);
			minWait();
			
			//click(driver, employeeDateDesc);
			minWait();
			
			minWait();
			click(driver, By.xpath("//a[text()='"+name+date+"']"));
			}
		else
			{
			Log.info(role+" role is not present ");
			}
		}
		
		else
		{
			Log.info(department+" department is not present ");
		}
	}
		else 
	{
			Log.info(org+"Org is not present ");
	}
}
	
	/*
	 * This method creates employee without validation
	 * @param org(String) : An organization record should exist on which we need to create employee
	 * @param department(String) : A department record should exist on which we need to create employee
	 * @param role(String): A role record should exist on which we need to create employee
	 * @param name(String): Name of the employee 
	 * @param office(String): Office should pre-exist in the org 
	 * @param startDate(String) : Employee start Date in the organization 
	 * @param endDate: employee end date
	 */
	public void createEmployee(String org, String department, String role, String name, String office, String startDate, String endDate) throws InterruptedException, ParseException 
	{
		
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		employeeWithDate= name + date;
		click(driver, orgSearch);
		//enterText(driver, orgSearch, org);
		driver.navigate().refresh();
		
		boolean orgPresence = verifyPresence(By.xpath("//a[text()='"+org+"']"));
		if(orgPresence==true) 
		{
			Log.info(org+"org found successfully");
		click(driver, By.xpath("//a[text()='"+org+"']"));
		
		minWait();
		driver.navigate().refresh();
		minWait();
		boolean deptPresence = verifyPresence(By.xpath("//div[@class='slds-grid']/a//*[text()='"+department+"']"));
		if(deptPresence==true) 
		 {
			Log.info(department+"Department is present");
			click(driver, By.xpath("//div[@class='slds-grid']/a//*[text()='"+department+"']"));//remove star
			
			minWait();
			driver.navigate().refresh();
			scrollByPixel();
			boolean rolePresence = verifyPresence(By.xpath("//div[@class='slds-grid']/a//*[text()='"+role+"']"));//remove star
			if(rolePresence==true) 
			{
				Log.info(role+"Role is present");
			click(driver, By.xpath("//div[@class='slds-grid']/a//*[text()='"+role+"']"));
			
			minWait();
			driver.navigate().refresh();
			minWait();
			Log.info("Creating new employee record");
			click(driver, employeeNewButton);
			click(driver, employeeSalesRT);
			click(driver, employeeRTNext);
			enterText(driver, employeeName, name+date);
			enterText(driver, employeeStartDtate, startDate);
			enterText(driver, employeeOffice, office);
			click(driver, employeeOfficeSelection);
			
			enterText(driver, employeeEndDate, endDate);
			minWait();
			click(driver, employeeSaveButton);
			minWait();
			Log.info("Employee record created successfully ");
			Log.info("Navigating to the employee record");
			
			click(driver, employeeHeader);
			minWait();
			
			//click(driver, employeeDateDesc);
			minWait();
			
			minWait();
			click(driver, By.xpath("//a[text()='"+name+date+"']"));
			}
		else
			{
			Log.info(role+" role is not present ");
			}
		}
		
		else
		{
			Log.info(department+" department is not present ");
		}
	}
		else 
	{
			Log.info(org+"Org is not present ");
	}
}

	/*This method will create a compensation for an existing employee from employee page using related lsit 
	/*@param startDate: start date for the compensation 
	 *@param annual salary: Salary compensation on annual basis 
	 *@param payrollFreq: At what frequency the wage will appear 
	 *@param incCompStartDate : Incorrect compensation start date
	 *@param incCompEndDate: incorrect compensation end date 
	 *@param incAnnualSalary :incorrect annual salary
	 *@param endDate: end date of compensation
	 *@param bonus: The bonus to be entered 
	 */

	public void createCompensationWithValidation(String startDate, String annualSalary, String payrollFreq,String incCompStartDate, String incCompEndDate, String	incAnnualSalary, String endDate, String bonus) throws InterruptedException {
		  
		driver.navigate().refresh();
		minWait();
		scrollAbit();
		minWait();
		Log.info("Creating new compensation record for the employee created");
		click(driver, employeeNewCompensation);
		enterText(driver, employeeBonus, bonus);
		minWait();
		click(driver, employeeBonus);
		minWait();
		click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+bonus+"']"));
		enterText(driver, employeeCompAnnualSalary, annualSalary);
		click(driver, employeeCompPayrollFreq);
		click(driver, By.xpath("//div/input//parent::div//following::div/lightning-base-combobox-item[@data-value='"+payrollFreq+"']"));
		Log.info("Validating Compensation start date less than employee start date");
		enterText(driver, employeeCompStartDate, incCompStartDate);
		click(driver, employeeCompSave);
		verifyPresence(employeeCompStartDateValidation);
		Log.info("validated compensation start date : "+incCompStartDate+"is employee start date: "+startDate);
		Log.info("Entering compensation start date greater or equal to employee start date");
		minWait();
		enterText(driver, employeeCompStartDate, startDate);
		Log.info("Validating salary should not be in negative");
		String sal = "-"+incAnnualSalary;
		enterText(driver, employeeCompAnnualSalary, sal);
		click(driver, employeeCompSave);
		verifyPresence(employeeSalaryValidation);
		Log.info("Salary cannot be in negative");
		Log.info("Entering correct value of salary ");
		minWait();
		enterText(driver, employeeCompAnnualSalary, annualSalary);
		minWait();
		Log.info("Validating compensation end date should be less than employee end Date ");
		enterText(driver, employeeCompEndDate, incCompEndDate);
		click(driver, employeeCompSave);
		verifyPresence(employeeCompEndDateValidation);
		Log.info("Entering correct value of end date");
		enterText(driver, employeeCompEndDate, endDate);
		
		click(driver, employeeCompSave);
		minWait();
		minWait();
		Log.info("Compensation record is created with all the details");
		driver.navigate().refresh();
		minWait();
		Log.info("Navigating to compensation record");
		scrollAbit();
		minWait();
		click(driver, employeeCompensationHeader);
		maxWait();
		driver.navigate().refresh();
		maxWait();
		
		click(driver, employeeCompRec);
		
	}
	/*This method will create a compensation for an existing employee from employee page using related list  without validation checks 
	/*@param startDate: start date for the compensation 
	 *@param annual salary: Salary compensation on annual basis 
	 *@param payrollFreq: At what frequency the wage will appear 
	 *@param endDate: end date of compensation
	 *@param bonus: The bonus to be entered 
	 */
	
	public void createCompensation(String startDate, String annualSalary, String payrollFreq, String endDate, String bonus) throws InterruptedException {
		  
		driver.navigate().refresh();
		minWait();
		scrollAbit();
		minWait();
		Log.info("Creating new compensation record for the employee created");
		click(driver, employeeNewCompensation);
		enterText(driver, employeeBonus, bonus);
		minWait();
		click(driver, employeeBonus);
		minWait();
		click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+bonus+"']"));
		enterText(driver, employeeCompAnnualSalary, annualSalary);
		click(driver, employeeCompPayrollFreq);
		click(driver, By.xpath("//div/input//parent::div//following::div/lightning-base-combobox-item[@data-value='"+payrollFreq+"']"));
		Log.info("Entering compensation start date greater or equal to employee start date");
		minWait();
		enterText(driver, employeeCompStartDate, startDate);
		Log.info("Entering correct value of salary ");
		minWait();
		enterText(driver, employeeCompAnnualSalary, annualSalary);
		minWait();
		enterText(driver, employeeCompEndDate, endDate);
		
		click(driver, employeeCompSave);
		minWait();
		minWait();
		Log.info("Compensation record is created with all the details");
		driver.navigate().refresh();
		minWait();
		Log.info("Navigating to compensation record");
		scrollAbit();
		minWait();
		click(driver, employeeCompensationHeader);
		maxWait();
		driver.navigate().refresh();
		maxWait();
		
		click(driver, employeeCompRec);
		
	}
	
	/*This method will check the count of wages is as per expected value 
	 * @param wageCount: Expected count of wages
	 * 
	 */
	public void validateWages(String wageCount) throws InterruptedException, IOException {
		driver.navigate().refresh();
		//click(driver, wagesHeader);
		//driver.get("https://cpmtestdrive0218.lightning.force.com/lightning/r/pcpm__Compensation__c/a0E5Y00000czrflUAA/view");
	    Log.info("Navigating to the wages allocation ");
		driver.navigate().refresh();
		minWait();
		click(driver, employeeWagesHeader);
		minWait();
		driver.navigate().refresh();
		maxWait();
		
		Log.info("Going to validate wage count");
		minWait();
		
		scrollDown();
		
		List<WebElement> totalWageCount = driver.findElements(employeeWagesCount);
		int wCount = totalWageCount.size();
		scrollDown(wCount-2, employeeWagesCount);
		List<WebElement> finalWageCount = driver.findElements(employeeWagesCount);
		int finalCount = finalWageCount.size();
		String count = Integer.toString(finalCount);
		Log.info("Actual count of wages is " +count);
		Log.info("Expected count of wages is " +wageCount);
		if(wageCount.equalsIgnoreCase(count)) {
		Log.info("Count of wages matches the expected value");
		}
		else 
		{
			Log.error("Count of wages does not match");
			screenshotCap(driver);
		}
		minWait();
	}
	
	/*This method will edit employee details such as end date , role, office etc
	 * @param edEmpEndDate : edited employee end date
	 * @param edRole : edited employee role having different GL 
	 * @param edOffice : edited office having different gl 
	 * @param incEdEmpEndDate : incorrect edited end date of employee
	 * 
	 */
	
	public void editEmployee (String edEmpEndDate, String edRole,String edOffice,String incEdEmpEndDate) throws InterruptedException {
		findRecord(employeeWithDate);
		Log.info("Found employee record to edit");
		click(driver, employeeEditButton);
		minWait();
		enterText(driver, employeeEndDateEdit, incEdEmpEndDate);
		
		
		click(driver, employeeRoleClearSelection);
		enterText(driver, employeeRoleEdit, edRole);
		minWait();
		click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+edRole+"']"));
		minWait();
		click(driver, employeeOfficeClearSelection);
		enterText(driver, employeeOfficeEdit, edOffice);
		click(driver, employeeOfficeSelection);
		minWait();
		click(driver, employeeSaveButton);
		click(driver, employeeConfirmButton);
		Log.info("Checking the validation that employee end date cannot be before compensation end date ");
	    verifyPresence(employeeEditEndDateValidation);
	    minWait();
	    enterText(driver, employeeEndDateEdit, edEmpEndDate);
	    
	    click(driver, employeeSaveButton);
	    minWait();
		click(driver, employeeConfirmButton);
		minWait();
		Log.info("Edited employee record successfully");
		
		minWait();
		driver.navigate().refresh();
		maxWait();
		Log.info("Navigating to compensation record");
		click(driver, employeeCompensationHeader);
		minWait();
		maxWait();
		driver.navigate().refresh();
		minWait();
		maxWait();
		click(driver, employeeCompRec);
		minWait();
		maxWait();
		
	}
	/*
	 * This method will edit compensation details of employee 
	 * @param edCompEndDate : edited compensation end date 
	 * @param edCompSalary : edited compensation salary
	 * @param edPayrollFreq : edited payroll freq
	 * @param incEdCompEndDate : incorrect edited compensation end date 
	 */
	
	public void compensationEdit(String edCompEndDate, String edCompSalary, String edPayrollFreq, String incEdCompEndDate, String edBonus) throws InterruptedException {
		findRecord(employeeWithDate);
		Log.info("Found employee record , whose compensation we need to edit");
		minWait();
		driver.navigate().refresh();
		maxWait();
		Log.info("Navigating to compensation record to edit ");
		scrollAbit();
		minWait();
		click(driver, employeeCompensationHeader);
		minWait();
		maxWait();
		driver.navigate().refresh();
		minWait();
		maxWait();
		click(driver, employeeCompRec);
		minWait();
		maxWait();
		click(driver, employeeEditButton);
		minWait();
		click(driver, employeeBonusClearSelection);
		enterText(driver, employeeBonus, edBonus);
		minWait();
		click(driver, employeeBonus);
		minWait();
		click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+edBonus+"']"));
		minWait();
		enterText(driver, employeeCompEndDate, incEdCompEndDate);
		minWait();
		enterText(driver, employeeCompAnnualSalary, edCompSalary);
		minWait();
		click(driver, employeeCompPayrollFreq);
		click(driver, By.xpath("//div/input//parent::div//following::div/lightning-base-combobox-item[@data-value='"+edPayrollFreq+"']"));
		click(driver, employeeCompSave);
		click(driver, employeeConfirmButton);
		maxWait();
		Log.info("Validating the error message when compensation end date is greater than employee end date ");
		verifyPresence(employeeCompEditValidation);
		minWait();
		enterText(driver, employeeCompEndDate, edCompEndDate);
		click(driver, employeeCompSave);
		click(driver, employeeConfirmButton);
		maxWait();

		
	}
	/*
	 * the method deletes the compensation 
	 * 
	 */
	
	public void deleteCompensation() throws InterruptedException {
		findRecord(employeeWithDate);
		Log.info("Found employee record , whose compensation we need to delete");
		minWait();
		driver.navigate().refresh();
		maxWait();
		Log.info("Navigating to compensation record to delete ");
		scrollAbit();
		minWait();
		click(driver, employeeCompensationHeader);
		minWait();
		maxWait();
		driver.navigate().refresh();
		minWait();
		maxWait();
		click(driver, employeeCompRec);
		minWait();
		maxWait();
		driver.navigate().refresh();
		maxWait();
		
		click(driver, employeeCompensationDelButton);
		maxWait();
		driver.switchTo().frame(findElement(driver, By.xpath("//iframe[@title='accessibility title']")));
		click(driver, empoloyeeCompDeleteConfirm);
		maxWait();
		driver.navigate().refresh();
		Log.info("Validating 0 Compensations present");
		verifyPresence(employeeCompDeleteCheck);
		Log.info("Validated no compensation present");
	}
	/*
	 * This method deletes the employee record user search for 
	 * 
	 */
	public void deleteEmployee() throws InterruptedException {
		driver.navigate().refresh();
		minWait();
		click(driver, orgSearch);
		enterText(driver, orgSearch, employeeWithDate);
		click(driver, employeeSearchSideBar);
		Log.info("Found employee record we need to delete");
		minWait();
		minWait();
		click(driver, employeeDownarrow);
		click(driver, employeeDeleteButton);
		maxWait();
		maxWait();
		driver.switchTo().frame(findElement(driver, By.xpath("//iframe[@title='accessibility title']")));
		click(driver, empoloyeeCompDeleteConfirm);
		maxWait();
		driver.navigate().refresh();
		minWait();
		click(driver, orgSearch);
		enterText(driver, orgSearch, employeeWithDate);
		click(driver, employeeSearchSideBar);
		Log.info("Validation the employee no longer exists");
		verifyPresence(employeeNoItemsPresent);
	}
	
	
	
	
}
