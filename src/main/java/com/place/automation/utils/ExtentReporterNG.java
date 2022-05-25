//package com.place.automation.utils;
//
//import com.relevantcodes.extentreports.*;
//
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//
//import org.testng.IResultMap;
//import org.testng.ISuite;
//import org.testng.ISuiteResult;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.xml.XmlSuite;
////
////import com.aventstack.extentreports.ExtentReports;
////import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ExtentReporterNG implements IReporter{
//	private ExtentReports extent;
//	
////	public static ExtentReports getReportObject()
////	{
////		
////		String path =System.getProperty("user.dir")+"//reports//index.html";
////		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
////		reporter.config().setReportName("CPM Automation Test Results");
////		reporter.config().setDocumentTitle("CPM Test Results");
////		
////		 extent =new ExtentReports();
////		extent.attachReporter(reporter);
////		extent.setSystemInfo("Automation Engineer", "Deepak Sharma");
////		return extent;
////		
////	}
//	
//	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)
//	{
//		extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);
//		
//		for(ISuite suite : suites)
//		{
//			Map<String, ISuiteResult> result = suite.getResults();
//			
//			for(ISuiteResult r : result.values())
//			{
//				ITestContext context = r.getTestContext();
//				
//				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//				buildTestNodes(context.getPassedTests(), LogStatus.FAIL);
//				buildTestNodes(context.getPassedTests(), LogStatus.SKIP);
//				
//				
//				
//				
//			}
//		}
//	}
//
//	
//	private void buildTestNodes(IResultMap tests, LogStatus status) {
//	    ExtentTest test;
//
//	    if (tests.size() > 0) {
//	        for (ITestResult result : tests.getAllResults()) {
//	            test = extent.startTest(result.getMethod().getMethodName());
//	            test.assignAuthor("360Log");
//	           // test.setStartedTime(getTime(result.getStartMillis()));
//	            //test.setEndedTime(getTime(result.getEndMillis()));
//
//	            for (String group : result.getMethod().getGroups())
//	                test.assignCategory(group);
//	            int s = result.getStatus();
//	            if (result.getStatus() == 1) {
//	                test.log(status, "Test " + status.toString().toLowerCase() + "ed");
//	            } else {
//	                String screen = BaseTest.screen;
//	                test.log(status, "Test " + status.toString().toLowerCase() + "ed " + test.addScreenCapture(screen));
//
//	            }
//	            extent.endTest(test);
//	        }
//	    }
//	  }
//	
//	
//	@Override
//	public void start(Report report) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void stop() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void flush() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void addTest() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setTestRunnerLogs() {
//		// TODO Auto-generated method stub
//		
//	}
//}
