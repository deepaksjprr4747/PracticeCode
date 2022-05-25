package com.place.automation.cpm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class LoginPage extends BasePage{

	
	By usernameField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By loginButton = By.xpath("//input[@id='Login']");
	
	
	public LoginPage(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	
	public void login(String un, String pw) throws InterruptedException
	{
		//Log.info("Starting login functionality now");
		driver.get(Constants.URL);
		System.out.println("going to enter the text now in un and pw field");
		if(findElement(driver, usernameField).isDisplayed())
		{
			enterText(driver, usernameField, un);
			enterText(driver, passwordField, pw);
			clickElement(driver, loginButton);
		}
		else
		{
			Log.info("no such element exists");
		}
		
	}
	
	
	public void loginScratch(String unTest, String pwTest) throws InterruptedException
	{
		driver.get(Constants.URLSCRATCH);
		System.out.println("going to enter the text now in un and pw field");
		if(findElement(driver, usernameField).isDisplayed())
		{
			enterText(driver, usernameField, unTest);
			enterText(driver, passwordField, pwTest);
			clickElement(driver, loginButton);
			minWait(); 
			//Thread.sleep(6000);
		}
		else
		{
			Log.info("no such element exists");
		}
		
	}

	
	public void loginSandbox(String unTest, String pwTest) throws InterruptedException
	{
		driver.get(Constants.URLTEST);
		System.out.println("going to enter the text now in un and pw field");
		if(findElement(driver, usernameField).isDisplayed())
		{
			enterText(driver, usernameField, unTest);
			enterText(driver, passwordField, pwTest);
			clickElement(driver, loginButton);
			minWait(); 
			//Thread.sleep(6000);
		}
		else
		{
			Log.info("no such element exists");
		}
		
	}


	public void loginStageQB(String unTest, String pwTest) throws InterruptedException {
		
		driver.get(Constants.URL);
		System.out.println("going to enter the text now in un and pw field");
		if(findElement(driver, usernameField).isDisplayed())
		{
			enterText(driver, usernameField, unTest);
			enterText(driver, passwordField, pwTest);
			clickElement(driver, loginButton);
			minWait(); 
			//Thread.sleep(6000);
		}
		else
		{
			Log.info("no such element exists");
		}
		
	}
	
	public void loginReleaseXero(String unTest, String pwTest) throws InterruptedException {
		
		driver.get(Constants.URL);
		System.out.println("going to enter the text now in un and pw field");
		if(findElement(driver, usernameField).isDisplayed())
		{
			enterText(driver, usernameField, unTest);
			enterText(driver, passwordField, pwTest);
			clickElement(driver, loginButton);
			minWait(); 
			//Thread.sleep(6000);
		}
		else
		{
			Log.info("no such element exists");
		}
		
	}
	
	public void loginRelease(String unTest, String pwTest) throws InterruptedException {
		
		driver.get(Constants.URLReleaseQB);
		System.out.println("going to enter the text now in un and pw field");
		if(findElement(driver, usernameField).isDisplayed())
		{
			enterText(driver, usernameField, unTest);
			enterText(driver, passwordField, pwTest);
			clickElement(driver, loginButton);
			minWait(); 
			//Thread.sleep(6000);
		}
		else
		{
			Log.info("no such element exists");
		}
		
	}
	
	
	
}
