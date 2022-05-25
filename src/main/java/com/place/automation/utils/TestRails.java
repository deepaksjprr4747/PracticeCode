//package com.place.automation.utils;
//
//
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import org.json.JSONObject;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import util.APIClient;
//import util.APIException;
//
//
//public class TestRails {
//	
//
//	    public static String TEST_RUN_ID                = <Test RUN ID>;
//	    public static String TESTRAIL_USERNAME          = <Test Rail Username>;
//	    public static String TESTRAIL_PASSWORD          = <Test Rail Password>;
//	    public static String RAILS_ENGINE_URL           = <Test Rail URL>;
//	    public static final int TEST_CASE_PASSED_STATUS = 1;
//	    public static final int TEST_CASE_FAILED_STATUS = 5;
//	    WebDriver driver;
//	    
//	    @Test(description = "Verify that Title appearing on the webpage is as expected. TC_ID=C120254")
//	    public void verifyTitle() throws Exception, APIException {
//	        driver= new FirefoxDriver();
//	        driver.get("https://www.google.co.in");
//	        String actualTilte = driver.getTitle();
//	        if (actualTilte.contains("Google")) {
//	            Assert.assertTrue(actualTilte.contains("Google"));
//	            testgoogle.addResultForTestCase("120254", TEST_CASE_PASSED_STATUS, "");
//	        }
//	else{
//			testgoogle.addResultForTestCase("120254", TEST_CASE_FAILED_STATUS, "");
//		}
//
//	        driver.quit();
//	    }
//
//
//	    public static void addResultForTestCase(String testCaseId, int status,
//	            String error) throws IOException, APIException {
//
//	        String testRunId = TEST_RUN_ID;
//
//	        APIClient client = new APIClient(RAILS_ENGINE_URL);
//	        client.setUser(TESTRAIL_USERNAME);
//	        client.setPassword(TESTRAIL_PASSWORD);
//	        Map data = new HashMap();
//	        data.put("status_id", status);
//	        data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
//	        client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"",data );
//
//	    }
//
//	}
//
//}
