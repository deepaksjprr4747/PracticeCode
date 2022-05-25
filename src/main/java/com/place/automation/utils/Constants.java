package com.place.automation.utils;

import org.openqa.selenium.By;

public class Constants {
	
	public static String URL = "https://login.salesforce.com/";
	//public static String URL = "https://cpmtestdrive0218.lightning.force.com/";
		
	public static String URLTEST = "https://test.salesforce.com";
	
	public static String URLSCRATCH = "https://saas-computing-92852-dev-ed.cs97.my.salesforce.com/";
	
	public static String URLQB = "https://pcpmstagingqb31012020-dev-ed.my.salesforce.com/";
	
	public static String URLReleaseXero = "https://pcpmenterprisereleasexero.lightning.force.com/";
	
	public static String URLReleaseQB = "https://pcpmenterprisereleaseqb.lightning.force.com/";
	
	public static String ShailReleaseQBUsername ="ssingh+rqb@placetechnology.com";
	public static String ShailReleaseQBPassword ="Request25$$";
	
	public static String URLRelease = "https://pcpmenterpriserelease.lightning.force.com/";
	
	public static String ShailReleaseUsername ="ssinssingh+rent@placetechnology.com";
	public static String ShailReleasePassword ="Request25@@$$";
	
	public static String ShailReleaseXeroUsername ="ssingh+pcpmenterprisereleasexero@placetechnology.com";
	public static String ShailReleaseXeroPassword ="Request25$$";
	
	
	public static long PAGE_LOAD_Timeout_Min = 20;
	public static long PAGE_LOAD_Timeout = 60;
	public static long PAGE_LOAD_Timeout_Max = 100;
	public static long IMPLICIT_WAIT = 50;
	
	public static By sflt_lightning_icon = By.cssSelector("a.switch-to-lightning");
	public static By sflt_app_launcher = By.xpath ("//div[contains(@class, 'slds-icon-waffle')]/..");
	
	public static String IsLightingEnabled = "False";
	
	public static final String REPORTS_PATH = null;
	public static final String ExecutionResultFile = "TestExecutionResult.txt";
	public static final String logFile = "testlog.log";
	public static final String logHTMLFile = "application.html.txt";
	public static final String TestDataFile = "TestData.xml";
	public static final String PropertyFileName = "info.properties";
	public static final String lg4jPropFileName = "log4j.properties";
	public static final By cashAndPLPageFromInputBox = By.xpath("//div/p[text()='From']/..//input");
	public static final By cashAndPLPageToInputBox = By.xpath("//div/p[text()='To']/..//input");
	public static final By cashAndPLPageApplyButton = By.xpath("//div/button[text()='Apply']");
	public static final By cashAndPLPageExportCSVField = By.xpath("//div[@class='slds-page-header__col-actions']/div/button[1]");
	
	//Project Folder Path
	public static final String LogFileLocation = "\\logs\\";
	public static final String ExecutionFolder = "\\src\\test\\resources\\executionresults\\";
	public static final String screenshotFolder = "\\screenshots\\";
	public static final String testDataFolder = "\\src\\test\\resources\\testdata\\";
	public static final String configFolder = "/src/test/resources/config/";
	
	//Drivers
	public static final String chromeDriverPath = "/resources/drivers/chromedriver101";
	public static final String firefoxDriverPath = "/resources/drivers/geckodriver";
	public static final String extentReportsPath = "/reports/Extentreport.html";
	public static final String edgeDriverPath = "\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe";
	
	
	public static String username = "deepak+autom@placetechnology.com"; //dsharma+automsxero@placetechnology.com dsharma+autom@placetechnology.com" for staging;
	public static String password = "qwerqwer2" ;   //"Ibms#12345"
	
	public static String usernameTest = "test-pmma6cetr78x@example.com";  //"test-wscpwtuhecsm@example.com";
	public static String passwordTest = "74N5L*iBO";						//"lOky|V7]H3";
	
	public static String UsernameQBO = "dsharma@placetechnology.com";
	public static String PasswordQBO = "Deepak#123";
	
	public static String UsernameQB1 = "dsharma+sqbauto@placetechnology.com";
	public static String PasswordQB1 = "Ibms#12345";

	public static String ShailUsername ="test-yvyiov3wloe2@example.com";
	public static String ShailPassword ="7tw&Ul0CR$";
    
	public static String releaseUsername = "manmeet+pcpmenterpriserelease@placetechnology.com";
	public static String releasePassword = "Micku@1234";
	
	public static String ShailScratchUsername ="test-wscpwtuhecsm@example.com";
	public static String ShailScratchPassword ="lOky|V7]H3";
	
	public static String GISC_ImportQBAcc_Batch = "GISC_ImportQBAcc_Batch";
	public static String GISC_ImportQBAcc_Batch_count = "5";
	
	public static String GISC_ImportQBInvoice_Batch = "GISC ImportQBInvoice Batch";
	public static String GISC_ImportQBInvoice_Batch_count = "50";
	
	
	public static String GISC_ImportQBBill_Batch = "GISC_ImportQBBill_Batch";
	public static String GISC_ImportQBBill_Batch_count = "25";
	
	public static String GISC_ImportQBDeposit_Batch = "GISC_ImportQBDeposit_Batch";
	public static String GISC_ImportQBDeposit_Batch_count = "200";
	
	public static String GISC_ImportQBItem_Batch = "GISC_ImportQBItem_Batch";
	public static String GISC_ImportQBItem_Batch_count = "800";
	
	public static String GISC_ImportQBPurchases_Batch = "GISC_ImportQBPurchases_Batch";
	public static String GISC_ImportQBPurchases_Batch_count = "200";
	
	
	public static String GISC_ImportQBVendorCredit_Batch = "GISC_ImportQBVendorCredit_Batch";
	public static String GISC_ImportQBVendorCredit_Batch_count = "200";
	
	public static String GISC_Import_QB_Bill_Payment_Batch = "GISC Import QB Bill Payment Batch";
	public static String GISC_Import_QB_Bill_Payment_Batch_count = "200";
	
	
	public static String GISC_ImportQBCreditMemo_Batch = "GISC_ImportQBCreditMemo_Batch";
	public static String GISC_ImportQBCreditMemo_Batch_count = "200";
	
	public static String GISC_Import_QB_Manual_Journal_Batch = "GISC Import QB Manual Journal Batch";
	public static String GISC_Import_QB_Manual_Journal_Batch_count = "200";
	
	public static String GISC_Import_QB_Payment_Batch = "GISC Import QB Payment Batch";
	public static String GISC_Import_QB_Payment_Batch_count = "25";
	
	
	
	public static String GISC_ImportXeroAcc_Batch = "GISC_ImportXeroAcc_Batch";
	public static String GISC_ImportXeroAcc_Batch_count = "5"; 
	
	
	public static String GISC_ImportXeroInvoice_Batch = "GISC_ImportXeroInvoice_Batch";
	public static String GISC_ImportXeroInvoice_Batch_count = "200"; 
	
	
	public static String GISC_ImportXeroPayment_Batch = "GISC_ImportXeroPayment_Batch";
	public static String GISC_ImportXeroPayment_Batch_count = "200";
	
	public static String GISC_ImportXeroBankTransaction = "GISC ImportXeroBankTransaction";
	public static String GISC_ImportXeroBankTransaction_count = "200";

	public static String GISC_Import_Xero_Credit_Note_Batch = "GISC Import Xero Credit Note Batch";
	public static String GISC_Import_Xero_Credit_Note_Batch_count = "200";
	
	public static String GISC_Import_Xero_Manual_Journal_Batch = "GISC Import Xero Manual Journal Batch";
	public static String GISC_Import_Xero_Manual_Journal_Batch_count = "200";
	
	
	
	public static String XERO_CS_Endpoint = "Endpoint";
	public static String XERO_CS_Endpoint_Value = "https://login.xero.com/identity/connect/authorize?response_type=code";
	
	
	public static String XERO_CS_GetDataEndpoint = "Get Data Endpoint";
	public static String XERO_CS_GetDataEndpoint_Value = "https://api.xero.com/api.xro/2.0/";
	
	
	public static String XERO_CS_AccessTokenEndPoint = "Access Token Endpoint";
	public static String XERO_CS_AccessTokenEndPoint_Value = "https://identity.xero.com/connect/token";
	
	
	public static String XERO_CS_AuthScope = "auth_scope";
	public static String XERO_CS_AuthScope_Value = "openid profile email accounting.transactions accounting.settings offline_access accounting.reports.read accounting.contacts";    //addded accounting.contacts on 24 July2020
	
	
	public static String XERO_CS_MaxCalloutBankTxnsBatch = "Max Callout BankTxns  Batch";
	public static String XERO_CS_MaxCalloutBankTxnsBatch_Value = "50";
	
	
	public static String XERO_CS_MaxCalloutInvoiceBatch = "Max Callout Invoice Batch";
	public static String XERO_CS_MaxCalloutInvoiceBatch_Value = "50";
	
	
	public static String XERO_CS_MaxCalloutPaymentBatch = "Max Callout Payment Batch";
	public static String XERO_CS_MaxCalloutPaymentBatch_Value = "50";
	
	
	public static String XERO_CS_MaxCalloutsCreditNotesBatch = "Max Callouts CreditNotes Batch";
	public static String XERO_CS_MaxCalloutsCreditNotesBatch_Value = "50";
	
	
	public static String XERO_CS_MaxCalloutsManualJournalBatch = "Max Callouts ManualJournal Batch";
	public static String XERO_CS_MaxCalloutsManualJournalBatch_Value = "50";
	
	
	public static String QB_RedirectingVFPage = "Redirecting VF Page";
	public static String QB_RedirectingVFPage_Value = "pcpm__Quickbook_Authorization";
	
	
	public static String QB_AuthorizationEndpoint = "Authorization Endpoint";
	public static String QB_AuthorizationEndpoint_Value = "https://appcenter.intuit.com/connect/oauth2";
	
	
	public static String QB_RefreshTokenEndpoint = "RefreshToken Endpoint";
	public static String QB_RefreshTokenEndpoint_Value = "https://oauth.platform.intuit.com/oauth2/v1/tokens/bearer";
	
	
	public static String QB_APIEndpoint = "API Endpoint";
	public static String QB_APIEndpoint_Value = "https://quickbooks.api.intuit.com/";
	
	
	public static String QB_SandboxAPIEndpoint = "Sandbox API Endpoint";
	public static String QB_SandboxAPIEndpoint_Value = "https://sandbox-quickbooks.api.intuit.com/";
	
	
	public static String QB_MinorVersion = "Minor Version";
	public static String QB_MinorVersion_Value = "45";
	
	
	public static String QB_Scope = "Scope";
	public static String QB_Scope_Value = "com.intuit.quickbooks.accounting";
	
	
	public static String QB_MaxCalloutBillBatch = "Max Callout Bill Batch";
	public static String QB_MaxCalloutBillBatch_Value = "50";
	
	
	public static String QB_MaxCalloutInvoiceBatch = "Max Callout Invoice Batch";
	public static String QB_MaxCalloutInvoiceBatch_Value = "50";
	
	public static String QB_MaxCalloutsAccountsBatch = "Max Callouts Accounts Batch";
	public static String QB_MaxCalloutsAccountsBatch_Value = "50";
	
	
	public static String QB_MaxCalloutsBillPayments = "Max Callouts Bill Payments";
	public static String QB_MaxCalloutsBillPayments_Value = "50";
	
	public static String QB_MaxCalloutsCreditMemosBatch = "Max Callouts Credit Memos Batch";
	public static String QB_MaxCalloutsCreditMemosBatch_Value = "20";
	
	
	public static String QB_MaxCalloutsManualJournal = "Max Callouts Manual Journal";
	public static String QB_MaxCalloutsManualJournal_Value = "20";
	
	public static String QB_MaxCalloutsPaymentsBatch = "Max Callouts Payments Batch";
	public static String QB_MaxCalloutsPaymentsBatch_Value = "20";
	
	public static String QB_MaxCalloutsPurchaseBatch = "Max Callouts Purchase Batch";
	public static String QB_MaxCalloutsPurchaseBatch_Value = "50";
	
	public static String QB_MaxCalloutsVendorCreditBatch = "Max Callouts Vendor Credit Batch";
	public static String QB_MaxCalloutsVendorCreditBatch_Value = "50";
	
	
	public static String QB_MaxCalloutsItemsBatch = "Max Callouts Items Batch";
	public static String QB_MaxCalloutsItemsBatch_Value = "9";
	
	public static String QB_MaxCalloutsDepositsBatch = "Max Callouts Deposits Batch";
	public static String QB_MaxCalloutsDepositsBatch_Value = "50";
	
	
	
	
	
	
	
	
	public static String BatchCreateCommission = "Batch Create Commission";
	public static String BatchCreateCommission_Value = "1";
	
	public static String BatchClassToDeleteRecords = "BatchClassToDeleteRecords";
	public static String BatchClassToDeleteRecords_Value = "100";
	
	public static String BatchUpdateRevenueContract = "Batch Update Revenue Contract";
	public static String BatchUpdateRevenueContract_Value = "50";
	
	public static String BatchUpdateExpenseDetail = "Batch Update Expense Detail";
	public static String BatchUpdateExpenseDetail_Value = "50";
	
	public static String BatchUpdateCompensation = "Batch Update Compensation";
	public static String BatchUpdateCompensation_Value = "5";
	
	
	
	
	
	public static String BUC_DPLAONFD_Batch = "BUC_DPLAONFD_Batch";
	public static String BUC_DPLAONFD_Batch_Value = "200";
	
	public static String DPLAONFD_DCAONFD_Batch = "DPLAONFD_DCAONFD_Batch";
	public static String DPLAONFD_DCAONFD_Batch_Value = "200";
	
	public static String DCAONFD_DCPLA_Batch = "DCAONFD_DCPLA_Batch";
	public static String DCAONFD_DCPLA_Batch_Value = "200";
	
	public static String DCPLA_DCCA_Batch = "DCPLA_DCCA_Batch";
	public static String DCPLA_DCCA_Batch_Value = "200";
	
	public static String QuotaUtilityBatch = "QuotaUtilityBatch";
	public static String QuotaUtilityBatch_Value = "30";
	
	
	
	
	
	public static String PlaceCPM_Utility_SDR_Batch = "PlaceCPM_Utility_SDR_Batch";
	public static String PlaceCPM_Utility_SDR_Batch_Value = "200";
	
	public static String DSR_DARCSR_Batch = "DSR_DARCSR_Batch";
	public static String DSR_DARCSR_Batch_Value = "20";
	
	public static String CFHC_UpdtExpCashTotalOnCashPgBatch_Batch = "CFHC_UpdtExpCashTotalOnCashPgBatch_Batch";
	public static String CFHC_UpdtExpCashTotalOnCashPgBatch_Batch_Value = "50";
	
	
	public static String UECTOCPB_URCTOCPB_Batch = "UECTOCPB_URCTOCPB_Batch";
	public static String UECTOCPB_URCTOCPB_Batch_Value = "50";
	
	public static String UECTOCPB_UECTOCPB_Batch_1 = "UECTOCPB_UECTOCPB_Batch_1";
	public static String UECTOCPB_UECTOCPB_Batch_1_Value = "200";
	
	public static String UECTOCPB_UECTOCPB_Batch_2 = "UECTOCPB_UECTOCPB_Batch_2";
	public static String UECTOCPB_UECTOCPB_Batch_2_Value = "50";
	
	
	
	
	public static String BatchUpdateRevenueExpense = "Batch Update Revenue Expense";
	public static String BatchUpdateRevenueExpense_Value = "1";                            //updaetd from 10 to 1 on 24 July 2020
	
	public static String CFHC_UpdtExpPLTotalsOnPLPageBatch_Batch = "CFHC_UpdtExpPLTotalsOnPLPageBatch_Batch";
	public static String CFHC_UpdtExpPLTotalsOnPLPageBatch_Batch_Value = "200";
	
	public static String UEPLTOPLPB_URPLTOPLPB_Btach = "UEPLTOPLPB_URPLTOPLPB_Btach";
	public static String UEPLTOPLPB_URPLTOPLPB_Btach_Value = "200";
	
	public static String UEPLTOPLPB_UEPLTOPLPB_Btach_1 = "UEPLTOPLPB_UEPLTOPLPB_Btach_1";
	public static String UEPLTOPLPB_UEPLTOPLPB_Btach_1_Value = "200";
	
	public static String UEPLTOPLPB_UEPLTOPLPB_Btach_2 = "UEPLTOPLPB_UEPLTOPLPB_Btach_2";
	public static String UEPLTOPLPB_UEPLTOPLPB_Btach_2_Value = "200";
	
}
