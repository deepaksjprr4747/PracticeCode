package com.place.automation.cpm.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class FindingCapital {
	
	public String url = "https://en.wikipedia.org/wiki/Main_Page";
	
	public static void main(String[] args)
	{
		
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Constants.chromeDriverPath);
				WebDriver driver = new ChromeDriver();
				
				//searchfunction();
				
						
	}
	

}
