package com.place.automation.cpm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Log;

public class RevenuePage extends BasePage{
	
	
	public By PLPageActToDatenForecastFilter = By.xpath("(//select[@class='single wd20 select uiInput uiInputSelect uiInput--default uiInput--select'])[2]");
	public By cashAndPLPageActToDatenForecastFilter = By.xpath("(//select[@class='single wd20 select uiInput uiInputSelect uiInput--default uiInput--select'])[2]");
	
	public By revTypeGeneralRadioButton = By.xpath("//span[contains(.,'General')]/../preceding-sibling::div/input[@type='radio']");
	public By nextButtonRevCreationPopup = By.xpath("//button/span[contains(.,'Next')]");
	public By revNameTextField = By.xpath("//input[@name='Name']");
	public By revGlAccountinputField = By.xpath("//input[@placeholder='Search GL Accounts...']");
	public By revAccountinputField = By.xpath("//input[@placeholder='Search Accounts...']");
	public By revSaveButton = By.xpath("//button[@name='SaveEdit']");
	
	public By revConStartDate = By.xpath("//label/span[contains(.,'Start Date')]/../following-sibling::div/input");
	public By revConInvoiceDate = By.xpath("//label/span[contains(.,'Invoice Date')]/../following-sibling::div/input");
	public By revConEndDate = By.xpath("//label/span[contains(.,'End Date')]/../following-sibling::div/input");
	public By revConSubsStartDate = By.xpath("//label/span[text()='Subscription Start Date']/../following-sibling::div/input");
	
	public By revBillCycle = By.xpath("//span/span[contains(.,'Payment Frequency')]/../following-sibling::div//a");
	public By revPaymentTerms = By.xpath("//span/span[contains(.,'Payment Terms')]/../following-sibling::div//a");
	public By revPayAccount = By.xpath("//input[@title='Search Payment Accounts']");
	public By revAutoRenewcbox = By.xpath("//label/span[contains(.,'Auto Renew')]/../following-sibling::input[@checked='checked']");
	//public By revContractSaveButton = By.xpath("(//div/button/span[contains(.,'Cancel')]/../following-sibling::button)[5]");
	public By revContractSaveButton = By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']//span[text()='Save']");
	
	public By revLineItemSaveButton = By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']//span[text()='Save']");
	
	//button/span[contains(text(),'Save')])[6]
	
	public By revHeader = By.xpath("//div//h2[text()='New Recurring']");
	public By revContractName = By.xpath("//td/span[contains(.,'3/13/2020')]/../preceding-sibling::th");
	public By cliHeader = By.xpath("//h2[contains(.,'New Line Item - Recurring')]");
	//public By revConLineItem = By.xpath("//h2/a[contains(.,'Contract Line Items')]/../../../following-sibling::div//div[@title='New']");
	
	public By revConLineItem = By.xpath("//button[text()='New Line Item - Recurring']");
	
	public By revProdName = By.xpath("//div/input[@title='Search Product']");
	public By revQty = By.xpath("//label[contains(.,'Quantity')]/following-sibling::input");
	public By revUnitPrice = By.xpath("//label[contains(.,'Unit Price')]/following-sibling::input");
	public By revAccountName = By.xpath("//div/span[text()='Revenue Account']/../following-sibling::div/span//a");
	
	public By viewAllRevContract = By.xpath("//a/span[@title='Revenue Detail']");
	public By totalAmountCLI = By.xpath("//label/span[contains(.,'Total Amount')]/../following-sibling::input");
	public By revenueGLAllocationCount = By.xpath("//span/a[contains(.,'RPLA')]");
	public By viewAllcashAllocationHeader = By.xpath("//a/span[@title='Revenue Cash Allocations']");
	public By viewAllGLAllocationHeader = By.xpath("//a/span[@title='Revenue GL Allocations']");
	public By revenueCashAllocationCount = By.xpath("//span/a[contains(.,'RCA')]");
	public By revAccountNameOnED = By.xpath("//div/span[text()='Revenue Account']/../following-sibling::div//a");
	
	public By revAccountNewAccountAdd = By.xpath("//lightning-base-combobox-item[@data-value='actionCreateNew']//span[@title='New Account']");
	public By addNewAccountPageNewAccountName = By.xpath("//span[text()='Account Name']//parent::label//following-sibling::input");
	public By addNewAccountPagePhone = By.xpath("//div[@class='slds-form-element slds-hint-parent']//input[2]");
	public By addNewAccountPageSaveButton = By.xpath("//div[@class='modal-footer slds-modal__footer']//button[@title='Save']");
	public By addNewAccountCursorAway = By.xpath("//input[@class=' input']");
	//Mansha's new xpaths
	public By revenueDetail = By.xpath("//*[text()='Revenue Detail Name']//following::a[@class='flex-wrap-ie11 slds-truncate']//child::span[contains(text(),RD )]");
	public By revStartDate = By.xpath("//label[text()='Start Date']//parent::div//child::div//child::input");
	public By revInvoiceDate = By.xpath("//label[text()='Invoice Date']//following-sibling::div//child::input");
	public By revEndDate = By.xpath("//label[text()='End Date']//following-sibling::div//child::input");
	public By rDSave = By.xpath("//button[@name='save']");
	public By rDEdit = By.xpath("//button[text()='Edit']");
	public By description = By.xpath("//textarea[@name='pcpm__Transaction_Description__c']");
	public By revdet = By.xpath("//h2[text()='Revenue Detail']");
	public By revPaymentFreq= By.xpath("//label[text()='Payment Frequency']//following-sibling::div//child::input");
	public By revPayTerm = By.xpath("//label[text()='Payment Terms']//following-sibling::div//child::input");
	
	public By SubsStartDate = By.xpath("//label[text()='Subscription Start Date']//parent::div//child::input");
	
	public By rDConfirm = By.xpath("//button[text()='Confirm']");
	public By revAccountSearchBar = By.xpath("//input[@placeholder='Search this list...']");
	public By revPageClickAway = By.xpath("//div[@class='slds-th__action'][1]");
	public By revAccountSelect = By.xpath("//table[contains(@class,'slds-table')]//span//a[1]");
	public By nonRStartDate = By.xpath("//span[text()='Start Date']//parent::label//following-sibling::div//child::input");
	public By nonRInvoiceDate = By.xpath("//span[text()='Invoice Date']//parent::label//following-sibling::div//child::input");
	public By nonRPayAccount = By.xpath("//span[text()='Payment Account']//parent::label//following-sibling::div//child::input");
	public By nonRPayTerm = By.xpath("//span[text()='Payment Terms']//parent::span//following-sibling::div//child::a");
	public By nonRHeader = By.xpath("//h2[text()='New Non - Recurring']");
	public By nonRSave = By.xpath("(//span[text()='Save'])[2]");
	public By nonRDHeader = By.xpath("//span[text()='Revenue Detail']");
	public By nonRLineItem = By.xpath("//button[text()='New Line Item - Non Recurring']");
	public By nonRQuantity = By.xpath("//span[text()='Quantity']//parent::label//following-sibling::input");
	public By nonRUnitPrice = By.xpath("//span[text()='Unit Price']//parent::label//following-sibling::input");
	public By nonREdStartDate = By.xpath("//label[text()='Start Date']//parent::label//following-sibling::div//child::input");
	public By nonREdInvoiceDate = By.xpath("//label[text()='Invoice Date']//parent::label//following-sibling::div//child::input");
	public By nonRPayAccClear  = By.xpath("//label[text()='Payment Account']//following-sibling::div//descendant::button[@title='Clear Selection']");
	public By nonREdPayAccount = By.xpath("//label[text()='Payment Account']//following-sibling::div//descendant::input");
	public By nonREdPayTerm = By.xpath("//label[text()='Payment Terms']//following-sibling::div//descendant::input");
	public By nonREdSave = By.xpath("//button[text()='Save']");
	public By recLineItemHeader = By.xpath("//h2[text()='New Line Item - Recurring']");
	
	
	public RevenuePage (WebDriver driver1)
	{
		this.driver = driver1;
	}

	public void createNewRevenueAccount(String glName, String revName, String accName) throws InterruptedException
	{
		clickElement(driver, newButtonOnPage);
		clickElement(driver, revTypeGeneralRadioButton);
		clickElement(driver, nextButtonRevCreationPopup);
		enterText(driver, revNameTextField,revName);
		enterText(driver, revGlAccountinputField, glName);
		minWait();
		//enterText(driver, revGlAccountinputField, glName);
		clickElement(driver, By.xpath("//span/lightning-base-combobox-formatted-text[@title='"+glName+"']"));
		
		enterText(driver, revAccountinputField, accName);
		Thread.sleep(2000);
		enterText(driver, revAccountinputField, accName);
		Thread.sleep(2000);
		clickElement(driver,revAccountNewAccountAdd);
		minWait();
		enterText(driver, addNewAccountPageNewAccountName, accName);
		minWait();
		List<WebElement> cursorAway = driver.findElements(addNewAccountCursorAway);
		cursorAway.get(2).click();
		minWait();
		
		clickElement(driver,addNewAccountPageSaveButton);
		minWait();
		minWait();
		clickElement(driver, revSaveButton);
		minWait();
		
		
	}
	

	
	
	
	public void createNewRContract(String revContractType, String revStartDate, String revInvoiceDate, String revEndDate, String revSubsStartDate, String revPayAccountName, String revPayTerm, String revBillingCycle, String revProductName, String productQty, String productPrice) throws InterruptedException
	{
		driver.navigate().refresh();
		minWait();
	//	waitTillInvisible(By.xpath("//span[text()='GL Account']"));
		minWait();
		clickElement(driver, By.xpath("//button[text()='"+revContractType+"']"));
		
		
		enterText(driver, revConStartDate, revStartDate);
		enterText(driver,revConInvoiceDate, revInvoiceDate);
		enterText(driver, revConEndDate, revEndDate);
		enterText(driver, revConSubsStartDate, revSubsStartDate);
		enterText(driver, revPayAccount, revPayAccountName);
		minWait();
		enterText(driver, revPayAccount, revPayAccountName);
		clickElement(driver, By.xpath("//div[@title='"+revPayAccountName+"']"));
		clickElement(driver, revHeader);
		minWait();
		clickElement(driver, revBillCycle);
		clickElement(driver, By.xpath("//ul/li/a[starts-with(.,'"+revBillingCycle+"')]"));
		
		clickElement(driver, revPaymentTerms);
		clickElement(driver, By.xpath("//ul/li/a[starts-with(.,'"+revPayTerm+"')]"));
		
		clickElement(driver, revAutoRenewcbox);
		
		clickElement(driver, revHeader);
		minWait();
		clickElement(driver, revContractSaveButton);
//		System.out.println("Clicked on save button successfully");
		minWait();
		
		scrollByPixel();
		clickElement(driver, viewAllRevContract);
		
		
		clickElement(driver, By.xpath("//td//span[text()='"+revStartDate+"']/../../preceding-sibling::th/span/a"));
	
		
		
		
//		System.out.println("going to click on create CLI now");
		minWait();
	//	driver.navigate().refresh();
		minWait();
		clickElement(driver, revConLineItem);
		minWait();
		enterText(driver, revProdName, revProductName);
		minWait();
		enterText(driver, revProdName, revProductName);
		clickElement(driver, By.xpath("//div[@class='listContent']//div[@title=\'"+revProductName+"']")); 
		minWait();
		//clearText(driver, revUnitPrice);
		minWait();
		enterText(driver, revUnitPrice, productPrice);
		minWait();
		enterText(driver, revQty, productQty);
		minWait();
		//enterText(driver, revUnitPrice, productPrice);
		minWait();
		clickElement(driver, recLineItemHeader);
		minWait();
		clickElement(driver, revLineItemSaveButton);
		clickElement(driver, revLineItemSaveButton);
	minWait();
		driver.navigate().refresh();
		scrollByPixel();
		minWait();
	}

	public void validateNewRContract(String glCount, String cashCount) throws InterruptedException {
		minWait();
		scrollByPixel();
		maxWait();
	    
		clickElement(driver, viewAllGLAllocationHeader);
		maxWait();
		minWait();
		minWait();
		driver.navigate().refresh();
		minWait();
		driver.navigate().refresh();
		minWait();
		scrollByPixel();
		List<WebElement> totalCountGL = driver.findElements(revenueGLAllocationCount);
		int tCountGL = totalCountGL.size();
		String tCountGLString = Integer.toString(tCountGL);
		Log.info("Actual count of Gl allcoation is " +tCountGL);
		Log.info("Expected count of GL allocation is " +glCount);
		Assert.assertEquals(tCountGLString, glCount);
		Log.info("Verified the gl allocation count, actual and expected count of GL allocation is same");
		minWait();
		
		driver.navigate().back();
		minWait();
		scrollByPixel();
		clickElement(driver, viewAllcashAllocationHeader);
		minWait();
		maxWait();
		minWait();
		driver.navigate().refresh();
		minWait();
		driver.navigate().refresh();
		minWait();
		List<WebElement> totalCountCash = driver.findElements(revenueCashAllocationCount);
		int tCountCash = totalCountCash.size();
		String tCountCashString = Integer.toString(tCountCash);
		Log.info("Actual count of cash allcoation is " +tCountCash);
		Log.info("Expected count of cash allocation is " +cashCount);
		Assert.assertEquals(tCountCashString, cashCount);
		Log.info("Verified the cash allocation count, actual and expected count of cash allocation is same");
		minWait();
		driver.navigate().back();
		minWait();
		clickElement(driver, revAccountNameOnED);
		Log.info("Clicked on EA name");
		minWait();
		driver.navigate().refresh();
		
	}
	
	
	

	public void selectActualToDForecastPL()
	{
		Select actualToDForecast = new Select(driver.findElement((PLPageActToDatenForecastFilter)));
		//actualToDForecast.selectByValue("Actuals to Date & Forecast");
		actualToDForecast.selectByValue("Forecast");
	}
	
	public void selectActualToDForecastCash()
	{
		Select actualToDForecast = new Select(driver.findElement((cashAndPLPageActToDatenForecastFilter)));
		//actualToDForecast.selectByValue("Actuals to Date & Forecast");
		actualToDForecast.selectByValue("Forecast");
	}
	
	public void Autorenew() throws InterruptedException {
		
		clickElement(driver,revAutoRenewcbox );
		clickElement(driver, revContractSaveButton);
	}
	
	public void editRecurringRevenue(String editedStartDate,String editedInvoiceDate,String editedEndDate,String editedPayTerm,String editedFrequency, String subscriptionDate) throws InterruptedException {
		driver.navigate().refresh();
		minWait();
		//driver.get("https://cpmtestdrive0218.lightning.force.com/lightning/r/pcpm__Revenue_Account__c/a0o5Y00000asUdfQAE/view");
		clickElement(driver, revenueDetail);
		minWait();
		clickElement(driver, rDEdit);
        minWait();
        
        clickElement(driver, revdet);
        minWait();
        clickElement(driver, revStartDate);
        enterText(driver, revStartDate, editedStartDate);
       // sendKeys(driver, revStartDate, editedStartDate);
        minWait();
        scrollup();
		clickElement(driver,revPaymentFreq);
		clickElement(driver,By.xpath("//span[text()='"+editedFrequency+"']"));
		minWait();
		clickElement(driver,revPayTerm);
		clickElement(driver,By.xpath("//span[text()='"+editedPayTerm+"']"));
		
		
    
        clickElement(driver, revInvoiceDate);
        clearText(driver, revInvoiceDate);
        sendKeys(driver,revInvoiceDate, editedInvoiceDate);
		minWait();
		
		clickElement(driver, revEndDate);
		clearText(driver, revEndDate);
        sendKeys(driver,revEndDate, editedEndDate);
		minWait();
		
		clickElement(driver, SubsStartDate);
		clearText(driver, SubsStartDate);
        sendKeys(driver,SubsStartDate, editedStartDate);
        minWait();
        enterText(driver, description, "Hello");
		clickElement(driver,rDSave);
		minWait();
		
		
		
		clickElement(driver, rDConfirm);
		minWait();
		minWait();
		driver.navigate().refresh();
		maxWait();
		maxWait();
	}
	public void createNewNonRecRD(String rdType, String startDate, String invoiceDate, String quantity,  String payAccountName, String payTerm, String glCount, String cashCount, String unitPrice) throws InterruptedException
	{
		Log.info("Creating RD now");
		
		driver.navigate().refresh();
		minWait();
		minWait();
		clickElement(driver, By.xpath("//button[text()='"+rdType+"']"));	
		minWait();
		clickElement(driver, nonRHeader);
		enterText(driver, nonRStartDate, startDate);
		enterText(driver,nonRInvoiceDate, invoiceDate);
		//enterText(driver, expAmount, expDAmount);
		
		enterText(driver, nonRPayAccount, payAccountName);
		Thread.sleep(2000);
		clickElement(driver, By.xpath("//div[@title='"+payAccountName+"']"));
		clickElement(driver, nonRPayTerm);
		doubleClickElement(driver, By.xpath("//ul//child::li//child::a[@title = '"+payTerm+"']"));
	
	
		
		minWait();
		clickElement(driver, nonRSave);
		Log.info("clicked on Save button successfully");
		Log.info("Created Non recurring RD successfully");
		minWait();
		
	
		scrollByPixel();
		clickElement(driver, nonRDHeader);
		clickElement(driver, By.xpath("//div//child::lightning-formatted-text[text()='\"+startDate+\"']//ancestor::td//preceding-sibling::th//descendant::a"));
		minWait();
		minWait();
		Log.info("Creating non recurring line item");
		clickElement(driver, nonRLineItem);
		minWait();
		enterText(driver, nonRQuantity, quantity);
		enterText(driver, nonRUnitPrice, unitPrice);
		clickElement(driver, nonRHeader);
		minWait();
		click(driver, nonRSave);
		minWait();
	}
	
public void editNonRecurringRev(String editedStartDate,String editedInvoiceDate,String editedPayTerm,String editedPayementAccount) throws InterruptedException {
	driver.navigate().refresh();
		minWait();
		clickElement(driver, nonRDHeader);
		minWait();
		clickElement(driver,rDEdit);
		minWait();
		enterText(driver, nonREdStartDate, editedStartDate);
		enterText(driver,nonREdInvoiceDate, editedInvoiceDate);
		minWait();
	
		
		clickElement(driver,nonRPayAccClear);
		enterText(driver, nonREdPayAccount, editedPayementAccount);
		minWait();
		clickElement(driver, By.xpath("//lightning-base-combobox-formatted-text[@title='"+editedPayementAccount+"']"));
		
		
		clickElement(driver,nonREdPayTerm);
		clickElement(driver,By.xpath("//span[text()='"+editedPayTerm+"']"));
		
		clickElement(driver,nonREdSave);
		minWait();
		
	}
public void findRevenue(String accName) throws InterruptedException {
	
	enterText(driver,revAccountSearchBar,accName);
	clickElement(driver,revPageClickAway);
	minWait();
	clickElement(driver,revAccountSelect);
	minWait();
	
	driver.navigate().refresh();
	minWait();
	//clickElement(driver, expenseDetailHeaderInRelatedList);
	//minWait();
	
}

	}
	

