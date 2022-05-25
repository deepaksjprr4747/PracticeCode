package com.place.automation.cpm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.place.automation.cpm.base.BaseTest;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class TC05_PISscript_XeroQB extends BaseTest{
	
	String searchValue = "Custom Settings";
	String GISC_ImportQBAcc_Batch = "GISC_ImportQBAcc_Batch";
	String GISC_ImportQBAcc_Batch_count = "5";
	
	
	@BeforeTest
	public void navigateSetupPage() throws Exception
	{
		//logger = extent.startTest("navigateSetupPage");
		Log.info("we are on quick find page");
		loginPage.login(Constants.username, Constants.password);
		//loginPage.loginSandbox(Constants.usernameTest, Constants.passwordTest);
		sfBasic.clickSetup();
		Log.info("clicked on quick find successfully");
	}
	
	
	@Test(priority=4, alwaysRun = true)
	public void checkDefaultValues() throws Exception
	{
		
		//logger = extent.startTest("checkDefaultValues");
		
		Log.info("we are on quick find page");
		
		sfBasic.quickFindSetup(sfBasic.quickFind, searchValue);
		
		sfBasic.clickManageButton(sfBasic.manageBatchSetting);	
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportXeroBankTransaction, Constants.GISC_ImportXeroBankTransaction_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_Import_Xero_Credit_Note_Batch, Constants.GISC_Import_Xero_Credit_Note_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportXeroAcc_Batch, Constants.GISC_ImportXeroAcc_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportXeroInvoice_Batch, Constants.GISC_ImportXeroInvoice_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportXeroPayment_Batch, Constants.GISC_ImportXeroPayment_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_Import_Xero_Manual_Journal_Batch, Constants.GISC_Import_Xero_Manual_Journal_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportQBAcc_Batch, Constants.GISC_ImportQBAcc_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportQBInvoice_Batch, Constants.GISC_ImportQBInvoice_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportQBBill_Batch, Constants.GISC_ImportQBBill_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportQBDeposit_Batch, Constants.GISC_ImportQBDeposit_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportQBItem_Batch, Constants.GISC_ImportQBItem_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportQBPurchases_Batch, Constants.GISC_ImportQBPurchases_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportQBVendorCredit_Batch, Constants.GISC_ImportQBVendorCredit_Batch_count);
			
		batchSettings.verifyBatchSetting(Constants.GISC_Import_QB_Bill_Payment_Batch, Constants.GISC_Import_QB_Bill_Payment_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_ImportQBCreditMemo_Batch, Constants.GISC_ImportQBCreditMemo_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_Import_QB_Manual_Journal_Batch, Constants.GISC_Import_QB_Manual_Journal_Batch_count);
		
		batchSettings.verifyBatchSetting(Constants.GISC_Import_QB_Payment_Batch, Constants.GISC_Import_QB_Payment_Batch_count);

		extreporting("Checking default values", "Default values checked successfully", "Pass");
		
	}
	
	@Test(priority=2, enabled = true)
	public void checkXeroSettings() throws Exception
	{
		
		//logger = extent.startTest("checkXeroSettings");
		
		Log.info("we are on quick find page");
		
		sfBasic.quickFindSetup(sfBasic.quickFind, searchValue);
		minWait();
		
		sfBasic.clickManageButton(sfBasic.manageXeroSetting);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_Endpoint, Constants.XERO_CS_Endpoint_Value);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_GetDataEndpoint, Constants.XERO_CS_GetDataEndpoint_Value);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_AccessTokenEndPoint, Constants.XERO_CS_AccessTokenEndPoint_Value);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_AuthScope, Constants.XERO_CS_AuthScope_Value);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_MaxCalloutBankTxnsBatch, Constants.XERO_CS_MaxCalloutBankTxnsBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_MaxCalloutInvoiceBatch, Constants.XERO_CS_MaxCalloutInvoiceBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_MaxCalloutPaymentBatch, Constants.XERO_CS_MaxCalloutPaymentBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_MaxCalloutsCreditNotesBatch, Constants.XERO_CS_MaxCalloutsCreditNotesBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.XERO_CS_MaxCalloutsManualJournalBatch, Constants.XERO_CS_MaxCalloutsManualJournalBatch_Value);
		
		
		extreporting("Checking xero settings", "Verified all Xero settings", "Pass");

		
	}
	
	
	@Test(priority=3, enabled = false)
	public void checkQBSettings() throws Exception
	{
		//logger = extent.startTest("checkQBSettings");
		
		Log.info("we are on quick find page");
		
		sfBasic.quickFindSetup(sfBasic.quickFind, searchValue);
		
		sfBasic.clickManageButton(sfBasic.manageQBSetting);
		
		batchSettings.verifyBatchSetting(Constants.QB_RedirectingVFPage, Constants.QB_RedirectingVFPage_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_AuthorizationEndpoint, Constants.QB_AuthorizationEndpoint_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_RefreshTokenEndpoint, Constants.QB_RefreshTokenEndpoint_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_APIEndpoint, Constants.QB_APIEndpoint_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_SandboxAPIEndpoint, Constants.QB_SandboxAPIEndpoint_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MinorVersion, Constants.QB_MinorVersion_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_Scope, Constants.QB_Scope_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutBillBatch, Constants.QB_MaxCalloutBillBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutInvoiceBatch, Constants.QB_MaxCalloutInvoiceBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsAccountsBatch, Constants.QB_MaxCalloutsAccountsBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsBillPayments, Constants.QB_MaxCalloutsBillPayments_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsCreditMemosBatch, Constants.QB_MaxCalloutsCreditMemosBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsManualJournal, Constants.QB_MaxCalloutsManualJournal_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsPaymentsBatch, Constants.QB_MaxCalloutsPaymentsBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsPurchaseBatch, Constants.QB_MaxCalloutsPurchaseBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsVendorCreditBatch, Constants.QB_MaxCalloutsVendorCreditBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsItemsBatch, Constants.QB_MaxCalloutsItemsBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QB_MaxCalloutsDepositsBatch, Constants.QB_MaxCalloutsDepositsBatch_Value);
		
				extreporting("Checking QB settings", "Verified all QB setting", "Pass");

	}
	

	
	@Test(priority=1, enabled = true)
	public void checkQuotaBatchSettings() throws Exception
	{
		
		//logger = extent.startTest("checkQuotaBatchSettings");
		
		Log.info("we are on quick find page");
		
		sfBasic.quickFindSetup(sfBasic.quickFind, searchValue);
		
		sfBasic.clickManageButton(sfBasic.manageBatchSetting);
		
		batchSettings.verifyBatchSetting(Constants.BatchCreateCommission, Constants.BatchCreateCommission_Value);
		
		batchSettings.verifyBatchSetting(Constants.BatchClassToDeleteRecords, Constants.BatchClassToDeleteRecords_Value);
		
		batchSettings.verifyBatchSetting(Constants.BatchUpdateRevenueContract, Constants.BatchUpdateRevenueContract_Value);
		
		batchSettings.verifyBatchSetting(Constants.BatchUpdateExpenseDetail, Constants.BatchUpdateExpenseDetail_Value);
		
		batchSettings.verifyBatchSetting(Constants.BatchUpdateCompensation, Constants.BatchUpdateCompensation_Value);
		
		batchSettings.verifyBatchSetting(Constants.BUC_DPLAONFD_Batch, Constants.BUC_DPLAONFD_Batch_Value);
		
		batchSettings.verifyBatchSetting(Constants.DPLAONFD_DCAONFD_Batch, Constants.DPLAONFD_DCAONFD_Batch_Value);
		
		batchSettings.verifyBatchSetting(Constants.DCAONFD_DCPLA_Batch, Constants.DCAONFD_DCPLA_Batch_Value);
		
		batchSettings.verifyBatchSetting(Constants.DCPLA_DCCA_Batch, Constants.DCPLA_DCCA_Batch_Value);
		
		batchSettings.verifyBatchSetting(Constants.QuotaUtilityBatch, Constants.QuotaUtilityBatch_Value);
		
		batchSettings.verifyBatchSetting(Constants.PlaceCPM_Utility_SDR_Batch, Constants.PlaceCPM_Utility_SDR_Batch_Value);
		
		batchSettings.verifyBatchSetting(Constants.DSR_DARCSR_Batch, Constants.DSR_DARCSR_Batch_Value);
		
		batchSettings.verifyBatchSetting(Constants.UECTOCPB_URCTOCPB_Batch, Constants.UECTOCPB_URCTOCPB_Batch_Value);
		
		batchSettings.verifyBatchSetting(Constants.UECTOCPB_UECTOCPB_Batch_1, Constants.UECTOCPB_UECTOCPB_Batch_1_Value);
		
		batchSettings.verifyBatchSetting(Constants.UECTOCPB_UECTOCPB_Batch_2, Constants.UECTOCPB_UECTOCPB_Batch_2_Value);
		
		batchSettings.verifyBatchSetting(Constants.BatchUpdateRevenueExpense, Constants.BatchUpdateRevenueExpense_Value);
		
		batchSettings.verifyBatchSetting(Constants.CFHC_UpdtExpPLTotalsOnPLPageBatch_Batch, Constants.CFHC_UpdtExpPLTotalsOnPLPageBatch_Batch_Value);
		
		batchSettings.verifyBatchSetting(Constants.UEPLTOPLPB_URPLTOPLPB_Btach, Constants.UEPLTOPLPB_URPLTOPLPB_Btach_Value);
		
		batchSettings.verifyBatchSetting(Constants.UEPLTOPLPB_UEPLTOPLPB_Btach_1, Constants.UEPLTOPLPB_UEPLTOPLPB_Btach_1_Value);
		
		batchSettings.verifyBatchSetting(Constants.UEPLTOPLPB_UEPLTOPLPB_Btach_2, Constants.UEPLTOPLPB_UEPLTOPLPB_Btach_2_Value);
		
		extreporting("Checking QuotaBatch settings", "Verified all Quotabatch settings", "Pass");

		
	}

	
}
