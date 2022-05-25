package com.place.automation.cpm.testcases;


import org.testng.annotations.Test;
import com.place.automation.cpm.base.BaseTest;


public class FindingCountry extends BaseTest{
	
	String country = "Japan";
	String url = "https://en.wikipedia.org";

	@Test
	public void login() throws Exception {
	
		homePage.navigateAndSearch(country, url);
		
	}
	
}
