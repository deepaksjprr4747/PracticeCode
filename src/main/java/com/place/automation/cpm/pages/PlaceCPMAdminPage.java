package com.place.automation.cpm.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class PlaceCPMAdminPage extends BasePage {
	
	String rURL;
	String parentWindow;
	String childWindow;
	
	public PlaceCPMAdminPage (WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	
	public By pCPMAdminintegrationSettingLink = By.xpath("//li/a[contains(.,'Integration Setting')]");
	
	public By pCPMAdminnewOrganisation = By.xpath("//button[@title='newOrganization']");
	
	public By pCPMAdminOrgDropDown = By.xpath("//label[text()='Organization']/..//div/input[@placeholder='Select an Option']");
	
	public By pCPMAdminClientId = By.xpath("//input[@name='clientId']");
	
	public By pCPMAdminClientSecret = By.xpath("//input[@name='clientSecret']");
	
	public By pCPMAdminOrgCode = By.xpath("//input[@name='organizationCode']");
	
	public By pCPMAdminAccoutType = By.xpath("//label[text()='Account Type']/..//div/input[@placeholder='Select an Option']");
	
	public By pCPMAdminrURL = By.xpath("//div/label[contains(.,'Redirect Link')]/../following-sibling::div//p");
	
	public By pCPMAdminCopyIcon = By.xpath("//div/label[contains(.,'Redirect Link')]/../following-sibling::div//lightning-icon");
	
	public By pCPMAdminisSandbox = By.xpath("//label/span[contains(.,'Is Sandbox')]");
	
	public By signInLinkQBO = By.xpath("//li/a[text()='Sign In']");
	
	public By userNameQBO = By.xpath("//input[@name='Email']");
	
	public By passwordQBO = By.xpath("//input[@name='Password']");
	
	public By signInQBOButton = By.xpath("//button[@name='SignIn']");
	
	public By intuitDashboard = By.xpath("//li/a[text()='Dashboard']");
	
	public By appLinkQBO = By.xpath("//div//span[text()='StagingQB new']");
	
	public By keynAuthQBO = By.xpath("//li/a[text()='Development']/..//li/a[text()='Keys & OAuth']");
	
	public By addURIButton =  By.xpath("//h3[text()='Redirect URIs']/button/span");
	
	public By saveButtonQBO = By.xpath("//span[text()='Save']/../..");
	
	public String clientIDQBO = "//label[@label='Client ID']/div/input";
	public String clientSecQBO = "//label[@label='Client Secret']/div/input";
	
	public By saveButton = By.xpath("//button[@title='Save']");
	
	public By closeButtonQBO = By.xpath("//button/span/span[text()='Close']");
	
	public By actionDropdown = By.xpath("//div[@class='slds-accordion__summary']//span[text()='Action']/..");
	
	public By authLink = By.xpath("//span[text()='Authenticate']/..");
	
	public By searchCompanyInput = By.xpath("//input[@placeholder='Search for a company']");
	
	public String companyName = "Sandbox Company_US_6";
	
	//public String companyName = "MulticurrencyExchangeRateGainandLoss";
	
	
	public By nextButton = By.xpath("//button[text()='Next']");
	
	
	public void configureQBO(String orgName) throws InterruptedException
	{
		clickElement(driver, pCPMAdminintegrationSettingLink);
		clickElement(driver, pCPMAdminnewOrganisation);
		clickElement(driver, pCPMAdminOrgDropDown);
		
		driver.findElement(By.xpath("//span[@title ='"+orgName+"']")).click();
		
		clickElement(driver, pCPMAdminAccoutType);
		
		clickElement(driver, By.xpath("//span[@title='Quickbooks Online']"));
		
		clickElement(driver, pCPMAdminisSandbox);
		
		rURL = driver.findElement(By.xpath("//div/label[contains(.,'Redirect Link')]/../following-sibling::div//p")).getText();
		
		System.out.println("url value is : " +rURL);
		
		clickElement(driver, pCPMAdminCopyIcon);
		minWait(); 
		
		
	}
	
	public void QBODataSetup(String orgName, String qboURL) throws InterruptedException
	{
		driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
		driver.get(qboURL);
		
		Set<String> handles = driver.getWindowHandles();
		
		List<String> ls = new ArrayList<String>(handles);
		
		parentWindow = ls.get(0);
		childWindow = ls.get(1);
		
		clickElement(driver, signInLinkQBO);
		
		enterText(driver, userNameQBO, Constants.UsernameQBO);
		enterText(driver, passwordQBO, Constants.PasswordQBO);
		clickElement(driver, signInQBOButton);
		
		clickElement(driver, intuitDashboard);
		
		Thread.sleep(4000);
		
		//clickElement(driver, closeButtonQBO);
		
		clickElement(driver, appLinkQBO);
		
		clickElement(driver, keynAuthQBO);
		Thread.sleep(4000);
		
		clickElement(driver, addURIButton);
		
		Thread.sleep(4000);
		
		List<WebElement> we = driver.findElements(By.xpath("//input[contains(@name,'redirectUri')]"));
		
		int length = we.size();
		
		WebElement we1 = we.get(length-1);
		
		System.out.println("total available URL fields are : " +length);
		System.out.println("url value is : " +rURL);
		we1.sendKeys(rURL);
		
		System.out.println("pasted the values");
		
		String cIDQBO = driver.findElement(By.xpath(clientIDQBO)).getAttribute("value");
		String cSecQBO = driver.findElement(By.xpath(clientSecQBO)).getAttribute("value");
		
		System.out.println("client id is " +cIDQBO);
		System.out.println("client secret is " +cSecQBO);
		
		clickElement(driver, saveButtonQBO);
		
		minWait(); 
		
		driver.switchTo().window(parentWindow);
		
		enterText(driver, pCPMAdminClientId, cIDQBO);
		
		enterText(driver, pCPMAdminClientSecret, cSecQBO);
		
		int orgCode = gen();
		String ocode = Integer.toString(orgCode);
		
		enterText(driver, pCPMAdminOrgCode, ocode);
		
		clickElement(driver, saveButton);
		
		waitTillvisible((By.xpath("//div[@title='"+orgName+"']")));
		
		Log.info("created org appeard on integration settings page");
		
		minWait(); 
		
	}
	
	
	public void authOrg(String orgName) throws InterruptedException
	{
		driver.findElement(By.xpath("//div[text()='"+orgName+"']")).click();
		minWait(); 
		driver.findElement(By.xpath("(//div[@class='slds-accordion__summary']//div[@title='"+orgName+"']/../../../following-sibling::div//lightning-primitive-icon)[2]")).click();
		
		minWait(); 
		clickElement(driver, authLink);
//		System.out.println("Now will enter QBO username and password again");
//		System.out.println(driver.getTitle());
//		Thread.sleep(6000);
//		driver.findElement(By.xpath("//button[@name='SignIn']"));
//		enterText(driver, userNameQBO, Constants.UsernameQBO);
//		enterText(driver, passwordQBO, Constants.PasswordQBO);
//		clickElement(driver, signInQBOButton);
		enterText(driver, searchCompanyInput, companyName);
		minWait(); 
		driver.findElement(By.xpath("//div[text()='"+companyName+"']")).click();
		clickElement(driver, nextButton);
		waitTillvisible((By.xpath("//div[@title='"+orgName+"']")));
		Log.info("Org " +orgName+ " authenticated successfully, ready to import the data now");
		
		
	}
	
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
}
