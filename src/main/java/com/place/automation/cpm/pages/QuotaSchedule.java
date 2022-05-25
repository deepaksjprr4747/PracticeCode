package com.place.automation.cpm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Log;



public class QuotaSchedule extends BasePage{
	

		By QuotaScheduleNewButton = By.xpath("//div[text()='New']");
		By QuotaScheduleDesc= By.xpath("//label[text()='Description']//following-sibling::div/input");
		By QuotaSchedulePaymentFreq = By.xpath("//label[text()='Payment Frequency']//following-sibling::div//descendant::input");
		By QuotaSchedulePaymentAcc = By.xpath("//label[text()='Payment Account']//following-sibling::div//descendant::input");
		By QuotaSchedulePeriodType = By.xpath("//label[text()='Period Type']//following-sibling::div//descendant::input");
		By QuotaScheduleRevGLAcc = By.xpath("//label[text()='Revenue GL Account']//following-sibling::div//descendant::input");
		By QuotaSchedulePayTerm = By.xpath("//label[text()='Payment Terms']//following-sibling::div//descendant::input");
		By QuotaScheduleNoOfPeriods = By.xpath("//p[text()='No.of Periods']//parent::div//following-sibling::div//child::input");
		By QuotaScheduleSaveButton = By.xpath("//button[text()='Save']");
		By QuotaScheduleEqualQuota = By.xpath("//p[text()='Equal Quota per period']//parent::div//following-sibling::div//child::span[@class='slds-checkbox_faux']");
		By QuotaSchedulePeriodAmount1 = By.xpath("//p[text()='1']//parent::td//following-sibling::td//child::input");
		By QuotaSchedulePeriodAmount2 = By.xpath("//p[text()='2']//parent::td//following-sibling::td//child::input");
		By QuotaSchedulePeriodAmount3 = By.xpath("//p[text()='3']//parent::td//following-sibling::td//child::input");
		By QuotaSchedulePeriodAmount4 = By.xpath("//p[text()='4']//parent::td//following-sibling::td//child::input");
		By QuotaScheduleLineItemsHeader = By.xpath("//span[text()='Quota Schedule Line Items']");
		By QuotaScheduleLineItems = By.xpath("//a[contains(@class,'slds-truncate outputLookupLink slds-truncate')]");
		By QuotaScheduleRevenueGLValidation = By.xpath("//span[text()='Please Select Revenue GL Account']");
		By QuotaScheduleRevenueGLClear = By.xpath("//label[text()='Revenue GL Account']//following-sibling::div//child::button[@title='Clear Selection']");
		By QuotaScheduleEmployeeAssignNewButton = By.xpath("//button[text()='New']");
		By QuotaScheduleEmployeeAssignEmployee = By.xpath("//label[text()='Employee']//following-sibling::div//child::input");
		By QuotaScheduleEmployeeSearch = By.xpath("//span[contains(text(),'Show All Results for')]");
		By QuotaScheduleEmployeeSearchResults = By.xpath("//input[@title='Search Employees...']");
		By QuotaScheduleNewEmployee = By.xpath("//div[text()='New']//parent::a");
		By QuotaScheduleEmployeeSalesRT = By.xpath("//span[text()='Sales Employee']//parent::div//preceding-sibling::div//child::span");
		By QuotaScheduleEmployeeRTNext = By.xpath("//span[text()='Next']//parent::button");
		By QuotaScheduleEmployeeName = By.xpath("//label[text()='Employee Name']//following-sibling::div/input");
		By QuotaScheduleEmployeeRoles = By.xpath("//label[text()='Employee Role']//following-sibling::div//child::input");
		By QuotaScheduleEmployeeOffice = By.xpath("//label[text()='Office']//following-sibling::div//child::input");
		By QuotaScheduleEmployeeStartDate = By.xpath("//label[text()='Employee Start Date']//following-sibling::div//child::input");
		By QuotaScheduleEmployeeEndate= By.xpath("//label[text()='Employee End Date']//following-sibling::div//child::input");
		By QuotaScheduleEmployeeSave = By.xpath("//button[text()='Save']");
		By QuotaScheduleEmployeeAssignStartDate = By.xpath("//label[text()='Start Date']//following-sibling::div//child::input");
		By QuotaScheduleEmployeeAssignEndDate = By.xpath("//label[text()='End Date']//following-sibling::div//child::input");
		By QuotaScheduleEmployeeQuotaAssignmentRL = By.xpath("//span[text()='Employee Quota Assignments']//parent::a");
		By QuotaScheduleEmployeeQuotaRL = By.xpath("//span[text()='Quota']//parent::a");
		By QuotaScheduleEmployeeQuotaCount = By.xpath("//a[contains(@class,'slds-truncate outputLookupLink')]");
	    By QuotaScheduleCashPLPageScroller = By.xpath("//table[@class='mainTable slds-table slds-table_cell-buffer mx100 fixed_header']/tbody/tr");
	    By QuotaScheduleEmployeeSelection = By.xpath("//lightning-base-combobox-formatted-text[@title='Pia20210907090252']");
	    
		public QuotaSchedule(WebDriver driver) {

			this.driver = driver;
		}
		/*
		 * This method creates quota 
		 * @param quotaDescription: Description of quota
		 * @param paymentTerm: Payment term used for quota creation
		 * @param paymentFreq : Payment freq used for quota creation
		 * @param paymentAcc : Payment Acc used for quota creation
		 * @param expenseGL : expense GL used for validation
		 * @param revenueGL : revenue Gl used in quota
		 * @param periodType : Period Type of quota
		 * @param noOFPeriods : no. of periods of quota 
		 * @param periodAmount1 : amount for period 1
		 * @param periodAmount2 : amount for period 2
		 * @param periodAmount3 : amount for period 3
		 * @param periodAmount4 : amount for period 1
		 */
		public void quotaCreation(String quotaDescription,	String paymentTerm,	String paymentFreq,	String paymentAcc ,String expenseGL,	String	revenueGL,	String	periodType,	String	noOFPeriods,	String	periodAmount1,String	periodAmount2,String	periodAmount3,String	periodAmount4) throws InterruptedException {
			click(driver, QuotaScheduleNewButton);
			minWait();
			enterText(driver, QuotaScheduleDesc, quotaDescription);
			click(driver, QuotaSchedulePaymentFreq);
		    click(driver,By.xpath("//label[text()='Payment Frequency']//following-sibling::div//child::div[contains(@class,'slds-dropdown slds-dropdown_fluid')]//child::span[text()='"+paymentFreq+"']"));
		    minWait();
		    enterText(driver,QuotaSchedulePaymentAcc, paymentAcc);
		    click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+paymentAcc+"']"));
		    minWait();
		    click(driver, QuotaSchedulePeriodType);
		    click(driver, By.xpath("//label[text()='Period Type']//following-sibling::div//child::div[contains(@class,'slds-dropdown slds-dropdown_fluid')]//child::span[text()='"+periodType+"']"));
		    minWait();
		    enterText(driver, QuotaScheduleRevGLAcc, expenseGL);
		    click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+expenseGL+"']"));
		    
		    click(driver, QuotaSchedulePayTerm);
		    click(driver, By.xpath("//span[text()='"+paymentTerm+"']"));
		    minWait();
		    
		    enterText(driver, QuotaScheduleNoOfPeriods, noOFPeriods);
		  //  click(driver, QuotaScheduleEqualQuota);
		    enterText(driver, QuotaSchedulePeriodAmount1, periodAmount1);
		    enterText(driver, QuotaSchedulePeriodAmount2, periodAmount2);
		    enterText(driver, QuotaSchedulePeriodAmount3, periodAmount3);
		    enterText(driver, QuotaSchedulePeriodAmount4, periodAmount4);
		    
		    
		    click(driver, QuotaScheduleSaveButton);
		    verifyPresence(QuotaScheduleRevenueGLValidation);
		    minWait();
		    click(driver, QuotaScheduleRevenueGLClear);
		    minWait();
		    enterText(driver, QuotaScheduleRevGLAcc, revenueGL);
		    click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+revenueGL+"']"));
		    click(driver, QuotaScheduleSaveButton);
		    minWait();
		    
		   click(driver, By.xpath("//span[text()='"+quotaDescription+"']//ancestor::td//preceding-sibling::th//child::a"));
		 minWait();
		}
		
		/*
		 * This method validated the line items of quota 
		 * @param lineItemcount : Expected line item count
		 */
		
		public void validateQuotaScheduleLineItems(String lineItemcount) throws InterruptedException {
			driver.navigate().refresh();
			
			click(driver, QuotaScheduleLineItemsHeader);
			minWait();
			driver.navigate().refresh();
			List <WebElement> lineItems = driver.findElements(QuotaScheduleLineItems);
			if(lineItems.size()==Integer.parseInt(lineItemcount)) {
			Log.info("Count of line Items matches the expected value");
			}
			else 
				Log.error("Count of line items do not match the expected value");
			driver.navigate().back();
			minWait();
			
		}
		/*
		 *This method will create new employee for quota assignment 
		 * @param employee : Name of the employee 
		 * @param startDate : start date of employee 
		 * @param endDate : end date of employee
		 */
		
		public void createEmployee(String employee, String startDate, String endDate) throws InterruptedException {
			minWait();
			driver.navigate().refresh();
			minWait();
			click(driver, QuotaScheduleNewEmployee);
			click(driver, QuotaScheduleEmployeeSalesRT);
			click(driver, QuotaScheduleEmployeeRTNext);
			enterText(driver, QuotaScheduleEmployeeName, employee);
			minWait();
			enterText(driver, QuotaScheduleEmployeeRoles, "Sales Manager");
			minWait();
			click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='Sales Manager']"));
			minWait();
			enterText(driver, QuotaScheduleEmployeeOffice, "Jaipur");
			minWait();
			click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='Jaipur']"));
			minWait();
			enterText(driver, QuotaScheduleEmployeeStartDate, startDate);
			enterText(driver, QuotaScheduleEmployeeEndate, endDate);
			click(driver, QuotaScheduleEmployeeSave);
			minWait();
		}
		/*
		 * This method assign quota to employee
		 * @param employee : Employee to which quota is assigned 
		 * @param incStartDate : incorrect start date used for validation
		 * @param startDate : correct start date of assignment
		 * @param endDate : end date of assignment
		 */
		
		public void employeeAssignment(String employee , String incStartDate, String startDate ,String endDate) throws InterruptedException {
			driver.navigate().refresh();
			minWait();
			scrollAbit();
			minWait();
			click(driver, QuotaScheduleEmployeeAssignNewButton);
			minWait();
			enterText(driver, QuotaScheduleEmployeeAssignEmployee, employee);
			/*click(driver, QuotaScheduleEmployeeAssignEmployee);
			click(driver, QuotaScheduleEmployeeSelection);*/
			minWait();
			click(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+employee+"']"));
			/*click(driver, QuotaScheduleEmployeeSearch);
			minWait();
			click(driver, QuotaScheduleEmployeeSearchResults);
			click(driver, QuotaScheduleNewEmployee);
			click(driver, QuotaScheduleEmployeeSalesRT);
			click(driver, QuotaScheduleEmployeeRTNext);
			enterText(driver, QuotaScheduleEmployeeName, employee);
			minWait();
			enterText(driver, QuotaScheduleEmployeeRoles, "Sales Manager");
			minWait();
			click(driver, By.xpath("//div[@title='Sales Manager']"));
			minWait();
			enterText(driver, QuotaScheduleEmployeeOffice, "Jaipur");
			minWait();
			click(driver, By.xpath("//div[@title='Jaipur']"));
			minWait();
			enterText(driver, QuotaScheduleEmployeeStartDate, startDate);
			enterText(driver, QuotaScheduleEmployeeEndate, endDate);
			click(driver, QuotaScheduleEmployeeSave);*/
			

			minWait();
			enterText(driver, QuotaScheduleEmployeeAssignStartDate, incStartDate);
			enterText(driver, QuotaScheduleEmployeeAssignEndDate, endDate);
			click(driver, QuotaScheduleSaveButton);
			minWait();
			
			enterText(driver, QuotaScheduleEmployeeAssignStartDate, startDate);
			click(driver, QuotaScheduleSaveButton);
			minWait();
			
			
		}
		/*
		 * This method validate the assignemnt 
		 * @param employee : Employee name 
		 * @param startDate : start date 
		 * @param endDate : end date 
		 * @param expectedQuotaCount : expected quota count 
		 */
		public void validatingAssignmentonEmployee(String employee, String startDate, String endDate,String expectedQuotaCount) throws InterruptedException {
			minWait();
			driver.navigate().refresh();
			minWait();
			scrollByPixel();
			minWait();
			click(driver, By.xpath("//span[text()='Employee Name']//ancestor::thead//following-sibling::tbody//child::a[text()='"+employee+"']"));
			minWait();
			driver.navigate().refresh();
			
		
			minWait();
			driver.navigate().refresh();
			maxWait();
			scrollByPixel();
			maximumWait();
			click(driver, QuotaScheduleEmployeeQuotaAssignmentRL);
			//verifyPresence(By.xpath("//span[text()='"+startDate+"']"));
			//verifyPresence(By.xpath("//span[text()='"+endDate+"']"));
			minWait();
			driver.navigate().back();
			minWait();
			driver.navigate().refresh();
			minWait();
			scrollByPixel();
			maximumWait();
			click(driver, QuotaScheduleEmployeeQuotaRL);
			minWait();
			List <WebElement> quotaCount = driver.findElements(QuotaScheduleEmployeeQuotaCount);
			
			if(quotaCount.size()==Integer.parseInt(expectedQuotaCount)) {
				Log.info("Count of quota matches the expected value");
				}
				else 
					Log.error("Count of quota do not match the expected value");
			
			
			
		}
		
		
		public void scrollDown(int i) throws InterruptedException {

			List<WebElement> scrollinglist = driver.findElements(QuotaScheduleCashPLPageScroller);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollinglist.get(i));

			minWait();
		}
		
		
		
		
		
}

