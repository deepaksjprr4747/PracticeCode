package com.place.automation.cpm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Log;

public class OrganizationPage extends BasePage{
	
	
	
	public By orgName = By.xpath("//label/span[contains(.,'Organization Name')]/../following-sibling::input");
	
	public By orgNameInput = By.xpath("//label[contains(.,'Organization Name')]/../div/input");
	//public By orgSaveButton = By.xpath("//button[@title='Save']");
	public By orgSaveButton = By.xpath("//button[@name='SaveEdit']");
	
	
	public By deptName = By.xpath("//label/span[contains(.,'Department Name')]/../following-sibling::input");
	public By deptLink = By.xpath("//a/span[@title='Departments']");
	public By deptNewButton = By.xpath("//div//h2//span[@title='Departments']/ancestor::div[3]/following-sibling::div//a[@title='New']");
	
	//(//li[@class='slds-button slds-button--neutral slds-truncate']//div[@title='New'])[4]
	public By saveButtonDept = By.xpath("//div[@class='actionsContainer']//button[@title='Save']");
	public By empRoleslink = By.xpath("//div//h2//span[@title='Employee Roles']/ancestor::div[3]/following-sibling::div//a[@title='New']");
	public By empRoleName = By.xpath("//label/span[contains(.,'Employee Role Name')]/../following-sibling::input");
	public By eINTax = By.xpath("//label/span[contains(.,'EIN/Tax ID')]");
	public By roleLabel = By.xpath("//h2[contains(.,'New Employee Roles')]");
	String completeErrorF = "//ul/li[contains(.,'Complete this field')]";
	//WebElement completeFieldErrro = driver.findElement(By.xpath("//ul/li[contains(.,'Complete this field')]"));
	
	
	public OrganizationPage(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	public void createNewOrg(String orgName) throws InterruptedException
	{
		clickElement(driver, newButtonOnPage);
		//String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//String orgName = orgNameText + "_"+ date;
		enterText(driver, orgNameInput, orgName);
		minWait();
		//clickElement(driver, eINTax);
		clickElement(driver, orgSaveButton);
		minWait(); 
		Log.info("Created " +orgName+ " org successfully");
	}
	
	public void createNewDept(String deptNameText, String glName) throws InterruptedException
	{
		//clickElement(driver, deptLink);
		clickElement(driver, deptNewButton);
		enterText(driver, deptName, deptNameText);
		minWait();
		enterText(driver, glAccountTextbox, glName);
		Thread.sleep(3000);	
		enterText(driver, glAccountTextbox, glName);
		clickElement(driver, By.xpath("//div[@title='"+glName+"']"));
		clickElement(driver, saveButtonDept);
		Thread.sleep(3000);	
		
	}
	
	public void createNewRole(String deptNameText, String roleNameText) throws InterruptedException
	{
		clickElement(driver, By.xpath("//div/a[contains(.,'"+deptNameText+"')]"));
		clickElement(driver, empRoleslink);
		String finalRoleName = deptNameText + "-"+ roleNameText;
		enterText(driver, empRoleName, roleNameText);
		//minWait();
		clickElement(driver, roleLabel);
		Thread.sleep(5000);	
		clickElement(driver, saveButtonDept);
		Thread.sleep(3000);	
		if(driver.findElement(By.xpath(completeErrorF)).isDisplayed())
		{
			System.out.println("need to click again on Save button");
			clickElement(driver, saveButtonDept);
		}
		else
		{
			System.out.println("no need to click on save button again");
		}
		
		
	}

}
