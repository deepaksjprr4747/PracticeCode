package com.place.automation.cpm.base;



import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.place.automation.utils.Log;
import com.relevantcodes.extentreports.LogStatus;


public class Listeners extends BaseTest implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		Log.info("****************************************************************************************");
		Log.info("------------------  " + result.getMethod().getMethodName() + " -------------------------");
		Log.info("****************************************************************************************");

	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("this call is from listener failure method");
		logger.log(LogStatus.PASS, "test case passed is "+result.getName());
		
		try {
			getresult(result);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("this call is from listener failure method");
		
		
		try {
			getresult(result);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			getresult(result);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

//	public void onFinish(ITestContext context) {
//		System.out.println("this call is from listener on finish method");
//		// TODO Auto-generated method stub
//		//extent.flush();
//		end_report();
//	}
	
	public void onFinish(ITestResult result) {
		//System.out.println("this call is from listener on finish method");
		// TODO Auto-generated method stub
		//extent.flush();
		//end_report();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
