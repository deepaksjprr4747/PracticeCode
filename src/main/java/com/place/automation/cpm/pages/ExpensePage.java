package com.place.automation.cpm.pages;


import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Log;


public class ExpensePage extends BasePage {
	
	public By expTypeGeneralRadioButton = By.xpath("//span[contains(.,'General')]/../preceding-sibling::div/input[@type='radio']");
	public By expAccountCreationPopup = By.xpath("//div/h2[contains(.,'New Expense Account')]");
	public By nextButtonExpCreationPopup = By.xpath("//button/span[contains(.,'Next')]");
	public By revAccountinputField = By.xpath("//input[@placeholder='Search Accounts...']");
	public By expNameTextField = By.xpath("//input[@name='Name']");
	public By expGlAccountinputField = By.xpath("//input[@placeholder='Search GL Accounts...']");
	//public By expNameTextField = By.xpath("//label/span[contains(.,'Name')]/../following-sibling::input");
	//public By expGlAccountinputField = By.xpath("//label/span[contains(.,'GL Account')]/../following-sibling::div//input");
	public By expSaveButton = By.xpath("//button[@name='SaveEdit']");
	public By revAccountNewAccountAdd = By.xpath("//lightning-base-combobox-item[@data-value='actionCreateNew']//span[@title='New Account']");

	//public By addNewAccountPageNewAccountName = By.xpath("(//div[@class='slds-form-element slds-hint-parent']//input)[1]");

	public By addNewAccountPageNewAccountName = By.xpath("//*[text()='Account Name']//parent::label//following-sibling::input");

	public By addNewAccountPageMove = By.xpath("//div[@class='slds-form-element slds-hint-parent']//input");
	public By expenseAccountSearchBar = By.xpath("//input[@placeholder='Search this list...']");
	public By expensePageClickAway = By.xpath("//div[@class='slds-th__action'][1]");
	public By expStartDate = By.xpath("//label/span[contains(.,'Start Date')]/../following-sibling::div/input");
	public By expInvoiceDate = By.xpath("//label/span[contains(.,'Invoice Date')]/../following-sibling::div/input");
	public By expEndDate = By.xpath("//label/span[contains(.,'End Date')]/../following-sibling::div/input");
	public By expAmount = By.xpath("//label/span[contains(.,'Expense Amount')]/../following-sibling::input");
	public By CashGLExpansion = By.xpath("//a[contains(@class,'slds-truncate')]");
	public By expPayAccount = By.xpath("//input[@title='Search Payment Accounts']");
	public By expPayTerm = By.xpath("//span/span[contains(.,'Payment Term (After # Days)')]/../following-sibling::div//a");
	public By expPayFreq = By.xpath("//span/span[contains(.,'Payment Frequency')]/../following-sibling::div//a");
	public By expAutoRenewcbox = By.xpath("//label/span[contains(.,'Auto Renew')]/../following-sibling::input[@checked='checked']");
	//public By expDetailSaveButton = By.xpath("(//div/button/span[contains(.,'Save')])[3]");
	public By expDetailSaveButton = By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']//span[text()='Save']");
	public By expAccountSaveButton = By.xpath("//div[@class='modal-footer slds-modal__footer']//button[3]");
	public By expHeader = By.xpath("//h2[text()='Recurring']");
	public By expEditHeader = By.xpath("//div/h2[contains(.,'Expense')]");
	public By expAccountHeader = By.xpath("//div/h2[contains(.,'New Account')]");
	public By expNonRecHeader = By.xpath("//div/h2[contains(.,'Non')]");
	public By expCrossButtonPopup = By.xpath("//button/span[contains(.,'Close this window')]");
	public By expPayacLabel = By.xpath("//div/label/span[contains(.,'Payment Account')]");
	public By expOKButton = By.xpath("//button[@title='OK']");
	public By expObstacle = By.xpath("//div/h2[contains(.,'Sorry to interrupt')]");
	public By successMsg = By.xpath("//div/div/span[contains(.,’Expense Detail Created Successfully.’)]");
	public By expenseDetailHeaderInRelatedList = By.xpath("//span[@title='Expense Details']");
	public By viewAllcashAllocation = By.xpath("(//div/span[contains(.,'Expense Cash Allocations')])[1]");
	public By viewAllcashAllocationHeader = By.xpath("//a/span[@title='Expense Cash Allocations']");
	public By viewAllGLAllocationHeader = By.xpath("//a/span[@title='Expense GL Allocations']");
	public By expenseGLAllocationCount = By.xpath("//span/a[contains(.,'EPLA')]");
	public By expenseCashAllocationCount = By.xpath("//span/a[contains(.,'ECA')]");
	public By expAccountNameOnED = By.xpath("//div/span[text()='Expense Account']/../following-sibling::div//a");
	//public By addNewAccountCursorAway = By.xpath("//input[@class=' input']");
	
	public By systemInformation = By.xpath("(//span[@class ='test-id__section-header-title slds-truncate'])[2]");
	public By startDateTTT = By.xpath("//label/span[text()='Start Date']/../div");
	public By startDateTTTPlaceHolder = By.xpath("//label/span[text()='Start Date']/..//span[@role='tooltip']");
	
	
	
	public By endDateTTT = By.xpath("//label/span[text()='End Date']/../div");
	
	public String startDateTTTValue = "Date for when you want to start accruing this expense.Deepak";
	public String endDateTTTValue = "End Date should be populated with the actual date that the expense will stop. If the expense is going on indefinitely, please leave End Date blank and ensure Auto Renew is checked.";
	public String invoiceDateTTTValue = "Invoice Date is the date you apply Payment Terms to in order to forecast when cash will be debited.";
	public String expAmountTTTValue = "Expense Amount should be consistent with the Payment Terms (i.e. if Payment Terms are annual, Expense Amount should be the annual price. If Payment Terms are monthly, Expense Amount should be the monthly amount.)";
	public String autoRenTTTValue = "Auto Renew should be checked if the expense is to be forecasted indefinitely. Please uncheck and add End Date if you know when the expense should no longer be forecasted.";
	public String perLicCostTTTValue = "License Cost should be consistent with the Payment Terms (i.e. if Payment Terms are annual, License Cost should be the annual price. If Payment Terms are monthly, License Cost should be the monthly amount.)";
	public String payFreqTTTValue = "Payment Frequency will determine when cash will be debited. The expense will be accrued on a monthly basis to the GL account.";
	public String payTermTTTValue = "Payment Terms will look at Invoice Date and add this amount of days to determine when to forecast cash to be debited.";
	public String payAccount = "Bank account or credit card that the expense will be credited/debited.";
	public String expCrePopupGLacTTTValue = "GL account where the expense is allocated.";
	public String expCrePopupAcTTTValue = "Look up the Account that you would like to relate this expense to. Please leave it blank if you don't want to relate it.";
	public By addNewAccountPageSaveButton = By.xpath("//div[@class='modal-footer slds-modal__footer']//button[@title='Save']");
	
	
	
	public By closeButtonpopup = By.xpath("//button[@title='Close this window']");
	
	
	public By invoiceDateTTT = By.xpath("//label/span[text()='Invoice Date']/../div");
	public By expAmountTTT = By.xpath("//label/span[text()='Expense Amount']/../div");
	public By autoRenewTTT = By.xpath("//label/span[text()='Auto Renew']/../div");
	public By paymentAccountTTT = By.xpath("//label/span[text()='Payment Account']/../div");
	public By paymentTermTTT = By.xpath("//label/span[text()='Payment Term (After # Days)']/../div");
	public By paymentFreqTTT = By.xpath("//label/span[text()='Payment Frequency']/../div");
	public By perLicCostTTT = By.xpath("//label/span[text()='Per License Cost']/../div");
	
	public By recurringButtonExpDetail = By.xpath("//button[text()='Recurring']");
	public By nonRecrruingButtonExpDetail = By.xpath("//button[text()='Non Recurring']");
	public By vendorNameInput = By.xpath("//input[@placeholder='Search Accounts...']");
	public By vendorNameSearchIcon = By.xpath("//span[@title='New Account']");
	public By accountNameInput = By.xpath("//span[text()='Account Name']/../following-sibling::input");
	public By accountPhoneInput = By.xpath("//span[text()='Phone']/../following-sibling::input");
	public By expenseAccountSelect = By.xpath("//table[contains(@class,'slds-table')]//span//a[1]");
	
	public By vendorNameSave = By.xpath("(//span[text()='Save'])[2]");
	public By editED = By.xpath("//button[text()='Edit']");
	public By addNewAccountCursorAway = By.xpath("//input[@class=' input']");
	
	public By editExpenseAmount = By.xpath("//input[contains(@name,'Expense_Amount')]");
	public By editPaymentTerm = By.xpath("//input[contains(@name,'Payment_Term')]");
	public By editPaymentFrequency = By.xpath("//input[contains(@name,'Payment_Frequency')]");
	public By editedExpStartDate = By.xpath("//input[contains(@name,'Start_Date')]");
	public By editedExpInvoiceDate = By.xpath("//input[contains(@name,'Invoice_Date')]");
	public By editedExpEndDate = By.xpath("//input[contains(@name,'End_Date')]");
	public By saveEditedRecord = By.xpath("//button[text()='Save']");
	public By confirmEditedRecord = By.xpath("//button[text()='Confirm']");
	
	public ExpensePage(WebDriver driver1)
	{
		this.driver = driver1;
		
	}
	

	
	public void createNewExpense(String glName, String expName, String accName) throws InterruptedException
	{
		
		clickElement(driver, newButtonOnPage);
		clickElement(driver, expTypeGeneralRadioButton);
		clickElement(driver, nextButtonExpCreationPopup);
		enterText(driver, expNameTextField,expName);
		enterText(driver, expGlAccountinputField, glName);
		minWait();
		enterText(driver, expGlAccountinputField, glName);
		clickElement(driver, By.xpath("//span/lightning-base-combobox-formatted-text[@title='"+glName+"']"));
		
		enterText(driver, revAccountinputField, accName);
		minWait();
		enterText(driver, revAccountinputField, accName);
		minWait();
		
		clickElement(driver,revAccountNewAccountAdd);
		minWait();
		enterText(driver, addNewAccountPageNewAccountName, accName);
		
		List<WebElement> move = driver.findElements(addNewAccountPageMove);
	
		move.get(2).click();
		
		clickElement(driver,expAccountHeader);
		minWait();
		
		clickElement(driver,expAccountSaveButton);
		minWait();
		
		
		clickElement(driver, expSaveButton);
		minWait();	
	}



	public void verifyToolTipText(String actual, String e)
	{
		
		
	}
			
			
	public void createNewRecED(String edType, String startDate, String invoiceDate, String expDAmount, String endDate, String payAccountName, String payTerm, String freqency, String glCount, String cashCount) throws InterruptedException
	{
		Log.info("Creating ED now");
		minWait();
		driver.navigate().refresh();
		minWait();
		//waitTillVisible(By.xpath("//span[text()='GL Account']"));
		minWait();
		clickElement(driver, By.xpath("//button[text()='"+edType+"']"));	
		minWait();
		enterText(driver, expStartDate, startDate);
		enterText(driver,expInvoiceDate, invoiceDate);
		enterText(driver, expAmount, expDAmount);
		enterText(driver, expEndDate, endDate);
		enterText(driver, expPayAccount, payAccountName);
		Thread.sleep(2000);
		enterText(driver, expPayAccount, payAccountName);
		clickElement(driver, By.xpath("//div[@title='"+payAccountName+"']"));
		clickElement(driver, expPayTerm);
		doubleClickElement(driver, By.xpath("//ul/li[contains(.,'"+payTerm+"')]"));
		clickElement(driver, expHeader);
		Thread.sleep(3000);
		clickElement(driver, expPayFreq);
		clickElement(driver, By.xpath("//li/a[@title='"+freqency+"']"));
		clickElement(driver, expAutoRenewcbox);
		clickElement(driver, expHeader);
		minWait();
		clickElement(driver, expDetailSaveButton);
		Log.info("clicked on Save button successfully");
		Log.info("Created ED successfully");
//		waitTillInvisible(expHeader);
		minWait();
		minWait();
		
		
//		Scroll_ByBottomofpage();
		scrollAbit();
		clickElement(driver, expenseDetailHeaderInRelatedList);
		minWait();
		driver.navigate().refresh();
		minWait();
		minWait();
		
		clickElement(driver, CashGLExpansion);
		Log.info("Clicked on cash Gl expansion");
		
//		clickElement(driver, By.xpath("//td/span[contains(.,'"+startDate+"')]/../preceding-sibling::th//span/a"));
//		minWait();
		driver.navigate().refresh();
		minWait();
		//waitTillInvisible(expHeader);
		//driver.navigate().refresh();

		scrollByPixel();
		minWait();
		scrollByPixel();
		clickElement(driver, viewAllGLAllocationHeader);
		minWait();
		List<WebElement> totalCountGL = driver.findElements(expenseGLAllocationCount);
		int tCountGL = totalCountGL.size();
		String tCountGLString = Integer.toString(tCountGL);
		Log.info("Actual count of Gl allcoation is " +tCountGL);
		Log.info("Expected count of GL allocation is " +glCount);
		if(tCountGLString.equalsIgnoreCase(glCount)) {
		Log.info("Verified the gl allocation count, actual and expected count of GL allocation is same");
		}
		else 
			Log.error("Verified the gl allocation count, actual and expected count of GL allocation is not same");

		minWait();
		driver.navigate().back();

		minWait();
		scrollByPixel();

		minWait();
		scrollByPixel();
		clickElement(driver, viewAllcashAllocationHeader);
		
		List<WebElement> totalCountCash = driver.findElements(expenseCashAllocationCount);
		int tCountCash = totalCountCash.size();
		String tCountCashString = Integer.toString(tCountCash);
		Log.info("Actual count of Gl allcoation is " +tCountCash);
		if(tCountCashString.equalsIgnoreCase(cashCount)) {
		Log.info("Verified the cash allocation count, actual and expected count of cash allocation is same");
		}
		else 
			Log.error("Verified the cash allocation count, actual and expected count of cash allocation is not same");

		minWait();
		driver.navigate().back();
		minWait();
		clickElement(driver, expAccountNameOnED);
		Log.info("Clicked on EA name");
		minWait();
		driver.navigate().refresh();
		
		//minWait();
		//td/span[contains(.,'1/1/2020')]/../preceding-sibling::th//div/a
//		clickElement(driver, successMsg);
//		System.out.println("clicked on success message finally");
//		
//		boolean successmsg = findElement(driver, successMsg).isDisplayed();
//		System.out.println("success message appeareed exists: " +successmsg);
//		Thread.sleep(3000);
//		
		//clickElement(driver, expOKButton);
	
//		boolean popupExists = findElement(driver, expOKButton).isDisplayed();
//		System.out.println("popup exists: " +popupExists);
//		if(popupExists==true)
//		{
//			//clickElement(driver, expOKButton);
//			System.out.println("clicked on OK button successfully");
//			Thread.sleep(30000);
//			//doubleClickElement(driver, expDetailSaveButton);
//			clickElement(driver, expDetailSaveButton);
//			System.out.println("Clicked again on save button successfully");
//		}
		
		//minWait();
		
				
		
	}

	public void clickRecurringExp() throws InterruptedException {
		
		clickElement(driver, recurringButtonExpDetail);
		System.out.println("clicked on recurring link successfully");
	} 
	
	public void clickNonRecurringExp() throws InterruptedException {
		
		clickElement(driver, nonRecrruingButtonExpDetail);
		System.out.println("clicked on non-recurring link successfully");
	}
	
	public void createNewEDwithTTT(String dateType, String tttextValue) throws InterruptedException
	{
		By dateLoc = By.xpath("//span[text()='"+dateType+"']/../div");
		hoverOnElement(driver, dateLoc);
		String actualtooltipText = driver.findElement(By.xpath("//span[text()='"+dateType+"']/..//span[@role='tooltip']")).getText();	
		Assert.assertEquals(actualtooltipText, tttextValue);
		System.out.println("tooltiptext looks good for field" +dateType);				
		
	}
	
	public void closeEDpopup() throws InterruptedException
	{
		clickElement(driver, closeButtonpopup);
		
	}
	
	public String validationGLAmount(String revBillingCycle, String value) {
		double s = 0;
		DecimalFormat df = new DecimalFormat("#.##");
		switch(revBillingCycle) {
		
		case "Monthly": s = Double.valueOf(value);
						break;
						
		case "Quarterly": s = Double.valueOf(value)/3;
							s = Double.valueOf(df.format(s));
							break;
							
		case "Semi Annually": s = Double.valueOf(value)/6;
							  s = Double.valueOf(df.format(s));
								break;
								
		case "Annually": s = Double.valueOf(value)/12;
						 s = Double.valueOf(df.format(s));	
							break;
		}
		
		return String.valueOf(s);
	}

	//This method is to create new Expense detail of non recurring type
	
	public void createNewNonRecED(String edType, String startDate, String invoiceDate, String expDAmount,  String payAccountName, String payTerm, String glCount, String cashCount) throws InterruptedException
	{
		Log.info("Creating ED now");
		
		driver.navigate().refresh();
		minWait();
		minWait();
		clickElement(driver, By.xpath("//button[text()='"+edType+"']"));	
		minWait();
		enterText(driver, expStartDate, startDate);
		enterText(driver,expInvoiceDate, invoiceDate);
		enterText(driver, expAmount, expDAmount);
		
		enterText(driver, expPayAccount, payAccountName);
		Thread.sleep(2000);
		enterText(driver, expPayAccount, payAccountName);
		clickElement(driver, By.xpath("//div[@title='"+payAccountName+"']"));
		clickElement(driver, expPayTerm);
		doubleClickElement(driver, By.xpath("//ul/li[contains(.,'"+payTerm+"')]"));
		
		Thread.sleep(3000);
	
		clickElement(driver, expHeader);
		minWait();
		clickElement(driver, expDetailSaveButton);
		Log.info("clicked on Save button successfully");
		Log.info("Created ED successfully");
//		waitTillInvisible(expHeader);
		minWait();
		
		
		
//		Scroll_ByBottomofpage();
		clickElement(driver, expenseDetailHeaderInRelatedList);
		minWait();
		minWait();
		driver.navigate().refresh();
		minWait();
		minWait();
		clickElement(driver, CashGLExpansion);
		
//		clickElement(driver, By.xpath("//td/span[contains(.,'"+startDate+"')]/../preceding-sibling::th//span/a"));
//		minWait();
		driver.navigate().refresh();
		minWait();
		
		Scroll_ByBottomofpage();
		minWait();
		//waitTillInvisible(expHeader);
		//driver.navigate().refresh();
		
		clickElement(driver, viewAllGLAllocationHeader);
		minWait();
		List<WebElement> totalCountGL = driver.findElements(expenseGLAllocationCount);
		int tCountGL = totalCountGL.size();
		String tCountGLString = Integer.toString(tCountGL);
		Log.info("Actual count of Gl allcoation is " +tCountGL);
		Log.info("Expected count of GL allocation is " +glCount);
		if(tCountGLString.equalsIgnoreCase(glCount)) {
		Log.info("Verified the gl allocation count, actual and expected count of GL allocation is same");
		}
		else 
			Log.error("Verified the gl allocation count, actual and expected count of GL allocation is not same");
	
		minWait();
		driver.navigate().back();
		Scroll_ByBottomofpage();
		minWait();
		clickElement(driver, viewAllcashAllocationHeader);
		
		List<WebElement> totalCountCash = driver.findElements(expenseCashAllocationCount);
		int tCountCash = totalCountCash.size();
		String tCountCashString = Integer.toString(tCountCash);
		Log.info("Actual count of Gl allcoation is " +tCountCash);
		if(tCountCashString.equalsIgnoreCase(cashCount)) {
		Log.info("Verified the cash allocation count, actual and expected count of cash allocation is same");
		}
		else 
			Log.error("Verified the cash allocation count, actual and expected count of cash allocation is not same");

		minWait();
		driver.navigate().back();
		minWait();
		clickElement(driver, expAccountNameOnED);
		Log.info("Clicked on EA name");
		minWait();
		driver.navigate().refresh();
		
	}

	public void findExpense(String accName) throws InterruptedException {
		
		enterText(driver,expenseAccountSearchBar,accName);
		clickElement(driver,expensePageClickAway);
		minWait();
		clickElement(driver,expenseAccountSelect);
		minWait();
		
		driver.navigate().refresh();
		minWait();
		scrollByPixel();
		clickElement(driver, expenseDetailHeaderInRelatedList);
		minWait();
		
	}
	
	public void editRecurringExpense(String editedStartDate,String editedInvoiceDate,String editedEndDate,String editedExpenseAmount,String editedPayTerm,String editedFrequency,String editedPayementAccount) throws InterruptedException {
		driver.navigate().refresh();
		minWait();
		minWait();
		clickElement(driver, CashGLExpansion);
		minWait();
		clickElement(driver,editED);
		
		enterText(driver, editedExpStartDate, editedStartDate);
		enterText(driver,editedExpInvoiceDate, editedInvoiceDate);
		
		enterText(driver,editedExpEndDate, editedEndDate);
		minWait();
		enterText(driver,editExpenseAmount,editedExpenseAmount);
		//clickElement(driver, expEditHeader);
		
		minWait();
		
		clickElement(driver,editPaymentFrequency);
		clickElement(driver,By.xpath("//span[text()='"+editedFrequency+"']"));
		
		clickElement(driver,editPaymentTerm);
		clickElement(driver,By.xpath("//span[text()='"+editedPayTerm+"']"));
		
		clickElement(driver,saveEditedRecord);
		minWait();
		clickElement(driver,confirmEditedRecord);
		minWait();
		
	}
	
	public void validateEditedED(String editedGlCount,String editedCashCount) throws InterruptedException {
		
		minWait();
		minWait();
		
		driver.navigate().refresh();
		minWait();
		//waitTillInvisible(expHeader);
		//driver.navigate().refresh();
		scrollByPixel();
		clickElement(driver, viewAllGLAllocationHeader);
		minWait();
		driver.navigate().refresh();
		minWait();

		scrollAbit();
		minWait();

		List<WebElement> totalCountGL = driver.findElements(expenseGLAllocationCount);
		int tCountGL = totalCountGL.size();
		String tCountGLString = Integer.toString(tCountGL);
		Log.info("Actual count of Gl allcoation is " +tCountGL);
		Log.info("Expected count of GL allocation is " +editedGlCount);
		if(tCountGLString==editedGlCount) {
		Log.info("Verified the gl allocation count, actual and expected count of GL allocation is same");
		}
		else 
		{
			Log.info("Verified the gl allocation count, actual and expected count of GL allocation is not same");

		}
		minWait();
		driver.navigate().back();

		minWait();
		scrollByPixel();
		scrollover();
		minWait();
		scrollByPixel();
		clickElement(driver, viewAllcashAllocationHeader);

		
		/*minWait();
		driver.navigate().refresh();
		minWait();
		scrollBelow(driver.findElement(systemInformation));
		minWait();
		Scroll_ByBottomofpage();

		minWait();
		
		clickElement(driver, viewAllcashAllocationHeader);*/
		
		List<WebElement> totalCountCash = driver.findElements(expenseCashAllocationCount);
		int tCountCash = totalCountCash.size();
		String tCountCashString = Integer.toString(tCountCash);
		Log.info("Actual count of Gl allcoation is " +tCountCash);
		if(tCountCashString.equalsIgnoreCase(editedCashCount)) {
		Log.info("Verified the cash allocation count, actual and expected count of cash allocation is same");
		}
		else 
			Log.error("Verified the cash allocation count, actual and expected count of cash allocation is not same");

		minWait();
		driver.navigate().back();
		minWait();
		clickElement(driver, expAccountNameOnED);
		Log.info("Clicked on EA name");
		minWait();
		driver.navigate().refresh();
	}
	
	public void editNonRecurringExpense(String editedStartDate,String editedInvoiceDate,String editedExpenseAmount,String editedPayTerm,String editedPayementAccount) throws InterruptedException {
		
		driver.navigate().refresh();
		minWait();
		minWait();
		clickElement(driver, CashGLExpansion);
		minWait();
		clickElement(driver,editED);
		
		enterText(driver, editedExpStartDate, editedStartDate);
		enterText(driver,editedExpInvoiceDate, editedInvoiceDate);
		minWait();
		enterText(driver,editExpenseAmount,editedExpenseAmount);
		//clickElement(driver, expEditHeader);
		
		minWait();
		clickElement(driver,editPaymentTerm);
		clickElement(driver,By.xpath("//span[text()='"+editedPayTerm+"']"));
		
		clickElement(driver,saveEditedRecord);
		minWait();
		clickElement(driver,confirmEditedRecord);
		minWait();
		
	}

	
	
}