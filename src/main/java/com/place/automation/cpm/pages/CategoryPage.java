package com.place.automation.cpm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.place.automation.cpm.base.BasePage;

public class CategoryPage extends BasePage{
	
	By expenseCategory = By.xpath("//a[@title='EXPENSE']");
	By editButtonExpenseCat = By.xpath("(//button[@name='Edit'])[1]");
	By categoryTypeValue = By.xpath("//span/span[text()='Category Type']/../following-sibling::div//a");
	By categoryNewButton = By.xpath("(//a[@title='New'])[1]");
	By categoryNameTfield = By.xpath("//label/span[contains(.,'Category Name')]/../following-sibling::input");
	By categorySequence = By.xpath("//div/input[@class='input uiInputSmartNumber']");
	By categoryAnotherType = By.xpath("//span/span[text()='Type']/../following-sibling::div//a");
	By categorySaveButton = By.xpath("(//button/span[text()='Save'])[2]");
	
	String sequenceNumber = "1";
	
	
	//button[text()='abc']
	
	
	public CategoryPage(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	public void createNewCategory(String categoryName, By categoryType, String sequenceNumber, By categoryAnotherTypeExpense) throws InterruptedException
	{
		clickElement(driver, categoryNewButton);
		enterText(driver, categoryNameTfield, categoryName);
		clickElement(driver, categoryTypeValue);
		clickElement(driver, categoryType);
		enterText(driver, categorySequence, sequenceNumber);
		clickElement(driver, categoryAnotherType);
		clickElement(driver, categoryAnotherTypeExpense);
		
	}

	public void setExpenseCategory() throws InterruptedException
	{
		clickElement(driver, expenseCategory);
		clickElement(driver, editButtonExpenseCat);
		
	}
	
	public void verifyCategoryType(By locator, String CategoryName)
	{
		
	}
	
}

//span[contains(text(), 'Contact Address')]/ancestor::div[1]
//span[text() = 'Contact Address']/ancestor::div[1]
