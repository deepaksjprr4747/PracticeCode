package com.place.automation.cpm.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;
import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;
import com.place.automation.utils.WriteCSV;

public class CashProjection extends BasePage{

	public By cashAndPLPageScrollingFunction = By.xpath("//table[@class='slds-table slds-table_cell-buffer  mx100 fixed_header']/tbody/tr");
	public By cashAndPLPageEmployeeCommission = By.xpath("//td[@class='headColumn' and @data-label='Employee Commissions']");
	public By cashAndPLPageEmpQuotaGlLink = By.xpath("//td[@data-label='Quota']/div/lightning-icon");
	public By cashAndPLPageEmpCommissionGlLink = By.xpath("//div[@data-headertitle ='Employee Commissions']/lightning-icon");
	public By cashAndPLPageHorizontalExpandButton = By.xpath("//th[@class='textRight minWidth fixedHeader']/div/a");
	public By cashAndPLGLexpandIcon = By.xpath("//tr[@class='slds-hint-parent GLParent ']/td[1]/div/div[1]/lightning-icon");
	public static By cashAndPLPageExportCSVField = By.xpath("//button[text()='Export CSV']");
	public By cashAndPLJanuaryMonth = By.xpath("//a/span[@data-month='January']");
	public By cashAndPLFebruraryMonth = By.xpath("//a/span[@data-month='February']");
	public By cashAndPLMarchMonth = By.xpath("//a/span[@data-month='March']");
	public By cashAndPLAprilMonth = By.xpath("//a/span[@data-month='April']");
	public By cashAndPLMayMonth = By.xpath("//a/span[@data-month='May']");
	public By cashAndPLJulyMonth = By.xpath("//a/span[@data-month='July']");       ////a/span[text()='Jan']
	public By cashAndPLJuneMonth = By.xpath("//a/span[@data-month='June']");
	public By cashAndPLAugustMonth = By.xpath("//a/span[@data-month='August']");
	public By cashAndPLSeptemberMonth = By.xpath("//a/span[@data-month='September']");
	public By cashAndPLOctoberMonth = By.xpath("//a/span[@data-month='October']");
	public By cashAndPLNovemberMonth = By.xpath("//a/span[@data-month='November']");
	public By cashAndPLDecemberMonth = By.xpath("//a/span[@data-month='December']");
	public By cashAndPLApplyButton = By.xpath("//button[text()='Apply']");
	public By cashAndPLQ1Quarter = By.xpath("//a/span[@data-month='Q1']");
	public By cashAndPLQ2Quarter = By.xpath("//a/span[@data-month='Q2']");
	public By cashAndPLQ3Quarter = By.xpath("//a/span[@data-month='Q3']");
	public By cashAndPLQ4Quarter = By.xpath("//a/span[@data-month='Q4']");
	public By cashAndPLPageWeekfilter = By.xpath("//label/span[text()='Week']");
	public By cashAndPLPageMonthfilter = By.xpath("(//label/span[text()='Month'])");
	public By cashAndPLPageQuarterfilter = By.xpath("//label/span[text()='Quarter']");
	public By cashAndPLPageYearfilter = By.xpath("//label/span[text()='Year']");
	public By cashAndPLPreviousMonthIcon = By.xpath("//div[@class='slds-align-middle']/button[@id='nextButton']");
	public By cashAndPLNextMonthIcon = By.xpath("//div[@class='slds-align-middle']/button[@title='Next Month']");
	public By cashAndPLPageOrgSelectionDropDown  = By.xpath("//select[@class='single wd20 slds-m-right_xx-small displayInline select uiInput uiInputSelect uiInput--default uiInput--select']");
	public By cashAndPLPageLoadingIndicator = By.xpath("//span[text()=???Loading???]");
	public By cashAndPLPageActToDatenForecastFilter = By.xpath("(//select[@class='single wd20 select uiInput uiInputSelect uiInput--default uiInput--select'])[2]");
	public By cashAndPLPageWeeklySelection = By.xpath("//div[@class='slds-datepicker slds-dropdown slds-dropdown_left']/table/tbody/tr/td");
	public By cashAndPLPageYearSelection = By.xpath("//div[@class='slds-datepicker slds-dropdown slds-dropdown_left']/table/tbody/tr/td");
	
	
	public By cashFrom = By.xpath("//p[text()='From']//parent::div//following-sibling::input']");
	public By cashTo = By.xpath("//p[text()='To']//parent::div//following-sibling::input");
	public By applyButton = By.xpath("//div/button[text()='Apply']");
	public By assumptionDoc = By.xpath("(//div[contains(@class,'AssumptionDock')]//following-sibling::div//child::lightning-primitive-icon)[2]");
	public By forecastDuration = By.xpath("//span[text()='Forecast Duration (Months)']//following-sibling::div//child::lightning-formatted-number");
	public By revenueAccountHeading = By.xpath("//div[@title='GL Accounts']");
	public CashProjection(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	// This method is Used to scroll down into page
	public void scrollDown(int i) throws InterruptedException {
		
		List<WebElement> scrollinglist =  driver.findElements(cashAndPLPageScrollingFunction);
		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollinglist.get(i));
		
		minWait();
	}
	
	// This method is Used to scroll up into page
	public void scrollUp() throws InterruptedException {
		
		List<WebElement> scrollinglist =  driver.findElements(cashAndPLPageScrollingFunction);
		int length = scrollinglist.size();
		
		for (int i=length -1;i>=0;i--)
		{
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollinglist.get(i));
			if(i-4>0) {
				i=i-4;
			}
			
			minWait();
		}	
	}
	
	// This method is Used to expand Employee Quota after vertical expansion of all GLs
	public void expandEmployeeQuotaLinks() throws InterruptedException {
		
		scrollToTop();
		List<WebElement> empquota = driver.findElements(cashAndPLPageEmpQuotaGlLink);
		
		Log.info("total link of employee quota name is " +empquota.size());
		
		int length = empquota.size();
		for(int i=0;i<length;i++)
		{
			try {
				List<WebElement> empquota2 = driver.findElements(cashAndPLPageEmpQuotaGlLink);
				scrollBelow(empquota2.get(i));
				empquota2.get(i).click();
	            
	        } catch(StaleElementReferenceException e) {
	        	i--;
	        	scrollAbit();
	        }catch(org.openqa.selenium.ElementClickInterceptedException e2) {
	        	i--;
	        	scrollLarge();
	        }
			
			waitTillInvisible(cashAndPLPageLoadingIndicator);
			Log.info("Clicked on employee quota gl expand icon " +i+ " time");
		
		}
		
	}

	// This method is Used to expand Employee Commission after vertical expansion of all GLs
	public void expandEmployeeCommissionLinks() throws InterruptedException {
		scrollToTop();
		List<WebElement> empcom = driver.findElements(cashAndPLPageEmpCommissionGlLink);
		
		Log.info("total link of employee commission name is " +empcom.size());
		
		int length = empcom.size();
		for(int i=0;i<length;i++)
		{
			try {
				List<WebElement> empcom2 = driver.findElements(cashAndPLPageEmpCommissionGlLink);
				
				scrollBelow(empcom2.get(i));
				empcom2.get(i).click();
				minWait();
	            
	        } catch(StaleElementReferenceException e) {
	        	i--;
	        	scrollAbit();
	        }catch(org.openqa.selenium.ElementClickInterceptedException e2) {
	        	i--;
	        	scrollLarge();
	        }
			
			waitTillInvisible(cashAndPLPageLoadingIndicator);
			Log.info("Clicked on employee commission gl expand icon " +i+ " time");
		
		}
		
	}
	

	// This method is Used to expand records Horizontally and a re-try of expansion after first time expansion
	public void expandHorizontal() throws InterruptedException
	{
		waitTillInvisible(cashAndPLPageLoadingIndicator);
		maxWait();
		List<WebElement> we = driver.findElements(cashAndPLPageHorizontalExpandButton);
		
		int length = we.size();
		Log.info("Horizontal expansion length " + length);
		minWait();
		for(int i=0;i<length;i++)
		{
				
				we.get(i).click();
				Log.info("Horizontal expansion clicked " + i + " times");
				minWait();
				
				
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollLeft)");
//		Log.info("scrolled to left successfully");
		
		List<WebElement> we2 = driver.findElements(cashAndPLPageHorizontalExpandButton);
		
		int length2 = we2.size();
		Log.info("Horizontal expansion length " + length2);
		for(int i=0;i<length2;i++)
		{
			try{
				//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",we2.get(i));
				we2.get(i).click();
				Log.info("Horizontal expansion clicked " + i + " times");
				minWait();
			}
			catch(org.openqa.selenium.ElementClickInterceptedException e) {
			}
			
		}
		
	}
	
	// This method is Used to expand records vertically 
	public void glExpandVertical(WebDriver driver) throws InterruptedException
	{
		List<WebElement> we = driver.findElements(cashAndPLGLexpandIcon);
		
		
		int countOfGL = we.size();
		
		Log.info("Total count of GLs is" +countOfGL);
		for(int i=0; i<countOfGL; i++)
		{
			
			List<WebElement> we2 = driver.findElements(cashAndPLGLexpandIcon);
			
		        try {
		        	scrollBelow(we2.get(i));
		      
		        	we2.get(i).click();
		    		
		    		if(i+1<countOfGL) {
		        		scrollDown(i+1);
//			        	Log.info("Scrolled down by "+ (i+1) +" GL");
		        	}
		        	

		        } catch(StaleElementReferenceException e) 
		        {
		        	i--;
		        	scrollDown(i);
//		        	Log.info("Scrolled down by "+ (i) +" GL");
		        	//scrollAbit();
		        	Log.info("scrolled from catch 1 block");
		        }
		        catch(org.openqa.selenium.ElementClickInterceptedException e2)
		        {
		        	i--;
		        	scrollDown(i);
//		        	Log.info("Scrolled down by "+ (i) +" GL");
		        	Log.info("scrolled from catch 2 block");
		        }
		      
			waitTillInvisible(cashAndPLPageLoadingIndicator);
			Log.info("Clicked on gl expand icon " +i+ " time");
			
		}
		
	}
	
	// This method is enter date in calendar for Month view 
	public void timePeriodMonthView( int month,int year, By element) throws InterruptedException {
		LocalDateTime now = LocalDateTime.now(); 
		
		clickElement(driver, element);
		minWait();
		
		int yearsToGoBack= now.getYear() - year;
		
		if(yearsToGoBack<0) {
			
			yearsToGoBack = year - now.getYear();
			WebElement we3 = driver.findElement(cashAndPLNextMonthIcon);
			
			for(int i=0;i<yearsToGoBack;i++) {
				
				we3.click();
				
			}
			
		}
		else if(yearsToGoBack>0) {
			
			WebElement we3 = driver.findElement(cashAndPLPreviousMonthIcon);
			
			for(int i=0;i<yearsToGoBack;i++) {
				
				we3.click();
				
			}
			
		}
		
		switch(month){
			
			case 1: driver.findElement(cashAndPLJanuaryMonth).click();
							break;
							
			case 2: driver.findElement(cashAndPLFebruraryMonth).click();
			break;
			
			case 3: driver.findElement(cashAndPLMarchMonth).click();
			break;
							
			case 4: driver.findElement(cashAndPLAprilMonth).click();
			break;
			
			case 5: driver.findElement(cashAndPLMayMonth).click();
			break;
			
			case 6: driver.findElement(cashAndPLJuneMonth).click();
			break;
			
			case 7: driver.findElement(cashAndPLJulyMonth).click();
			break;
			
			case 8: driver.findElement(cashAndPLAugustMonth).click();
			break;
			
			case 9: driver.findElement(cashAndPLSeptemberMonth).click();
			break;
			
			case 10: driver.findElement(cashAndPLOctoberMonth).click();
			break;
			
			case 11: driver.findElement(cashAndPLNovemberMonth).click();
			break;
			
			case 12: driver.findElement(cashAndPLDecemberMonth).click();
			break;
		}
		minWait();
	}
	

	// This method is enter date in calendar for Quarter view 
	public void timePeriodQuarterView(int month,int year, By element) throws InterruptedException {
		LocalDateTime now = LocalDateTime.now(); 
		
		clickElement(driver, element);
		minWait();
		
		int yearsToGoBack= now.getYear() - year;
		
		if(yearsToGoBack<0) {
			
			yearsToGoBack = year - now.getYear();
			WebElement we3 = driver.findElement(cashAndPLNextMonthIcon);
			
			for(int i=0;i<yearsToGoBack;i++) {
				
				we3.click();
				
			}
			
		}
		else if(yearsToGoBack>0) {
			
			WebElement we3 = driver.findElement(cashAndPLPreviousMonthIcon);
			
			for(int i=0;i<yearsToGoBack;i++) {
				
				we3.click();
				
			}
			
		}
		
		switch(month){
			
			case 1: driver.findElement(cashAndPLQ1Quarter).click();
							break;
							
			case 2: driver.findElement(cashAndPLQ1Quarter).click();
			break;
			
			case 3: driver.findElement(cashAndPLQ1Quarter).click();
			break;
							
			case 4: driver.findElement(cashAndPLQ2Quarter).click();
			break;
			
			case 5: driver.findElement(cashAndPLQ2Quarter).click();
			break;
			
			case 6: driver.findElement(cashAndPLQ2Quarter).click();
			break;
			
			case 7: driver.findElement(cashAndPLQ3Quarter).click();
			break;
			
			case 8: driver.findElement(cashAndPLQ3Quarter).click();
			break;
			
			case 9: driver.findElement(cashAndPLQ3Quarter).click();
			break;
			
			case 10: driver.findElement(cashAndPLQ4Quarter).click();
			break;
			
			case 11: driver.findElement(cashAndPLQ4Quarter).click();
			break;
			
			case 12: driver.findElement(cashAndPLQ4Quarter).click();
			break;
		}
		minWait();
	}
	

	// This method is submit date in calendar
	public void SubmitDate( By element) throws InterruptedException {
		
		scrollToTop();
		driver.findElement(element).click();
		minWait();
	}
	

	// This method is to select time period filter in Cash Projection screen
	public void timePeriodFilter(String value) throws InterruptedException {
		
		switch(value) {
		
		case "Month": clickElement(driver, cashAndPLPageMonthfilter);
						break;
		
		case "Quarter" : clickElement(driver, cashAndPLPageQuarterfilter);
						break;
		
		case "Year" : clickElement(driver, cashAndPLPageYearfilter);
						break;
						
		case "Week": clickElement(driver, cashAndPLPageWeekfilter);
						break;
		
		}
		minWait();
	}
	
	// This method is to export CSV in Cash Projection screen
	public String exportCSV(WebDriver driver) throws InterruptedException {
		minWait();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollTop)");
		Log.info("scrolled to top successfully");	
		
		driver.findElement(cashAndPLPageExportCSVField).click();
		Log.info("CSV exported");
		minWait();
		
		String mainWindow = driver.getWindowHandle();
	      
	      // open a new tab
	     
	      js.executeScript("window.open()");
	     // switch to new tab
	    // Switch to new window opened
	      for(String winHandle : driver.getWindowHandles()){
	          driver.switchTo().window(winHandle);
	      }
	     // navigate to chrome downloads
	      driver.get("chrome://downloads");
	      
	      JavascriptExecutor js1 = (JavascriptExecutor)driver;
	     
	     // get the latest downloaded file name
	      String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
	    
	     // close the downloads tab2
	      driver.close();
	     // switch back to main window
	      driver.switchTo().window(mainWindow);
	      return fileName;
		}
	
	public void selectAllOrg() throws InterruptedException
	{

		Select orgs = new Select(driver.findElement(cashAndPLPageOrgSelectionDropDown));
		orgs.selectByVisibleText("All Organizations");
		
	}
	
	public void selectActualToDForecast()
	{
		Select actualToDForecast = new Select(driver.findElement((cashAndPLPageActToDatenForecastFilter)));
		actualToDForecast.selectByValue("Actuals to Date & Forecast");
	//	actualToDForecast.selectByValue("Forecast");
	}
	
	public void selectActualToDForecast(String ForecastFilter)
	{
		Select actualToDForecast = new Select(driver.findElement((cashAndPLPageActToDatenForecastFilter)));
		//actualToDForecast.selectByValue("Actuals to Date & Forecast");
		actualToDForecast.selectByValue(ForecastFilter);
	}
	
	public void selectFiltercriteria() throws InterruptedException
	{
		clickElement(driver, cashAndPLPageMonthfilter);
		minWait();
		selectAllOrg();
		Log.info("selected All organization filter successfully");
		minWait();
		
		selectActualToDForecast();
		Log.info("selected Actuals to Daate & Forecast filter successfully");
		minWait();
	
	}
	
	public void selectFiltercriteria(String org, String ForecastFilter) throws InterruptedException
	{
		clickElement(driver, cashAndPLPageMonthfilter);
		minWait();
		selectAllOrg(org);
		Log.info("selected All organization filter successfully");
		minWait();
		
		selectActualToDForecast(ForecastFilter);
		Log.info("selected Actuals to Daate & Forecast filter successfully");
		minWait();
	
	}
	
	public void selectAllOrg(String org) throws InterruptedException
	{

		Select orgs = new Select(driver.findElement(cashAndPLPageOrgSelectionDropDown));
		orgs.selectByVisibleText(org);
	//	orgs.selectByVisibleText("Sandbox Company_US_3");
	//	orgs.selectByVisibleText("TATA");
	//	orgs.selectByVisibleText("NL Pvt Ltd");
	//	orgs.selectByVisibleText("Deepak Org Bulk Data");
	//	orgs.selectByVisibleText("KMO");
	//	orgs.selectByVisibleText("RD Org");
	//	orgs.selectByVisibleText("Sharma Traders");
	//	orgs.selectByVisibleText("DSSB2INRQB");
	//	orgs.selectByVisibleText("XeroTestORG");
	//	orgs.selectByVisibleText("Bulk Expense");
		
		
	}
	
	public void timePeriodWeekView( int day, int month,int year, By element) throws InterruptedException {
		LocalDateTime now = LocalDateTime.now(); 
		minWait();
		clickElement(driver, element);
		minWait();
		
		int yearsToGoBack= now.getYear() - year;
		
		if(yearsToGoBack<0) {
			
			yearsToGoBack = year - now.getYear();
			WebElement we3 = driver.findElement(cashAndPLNextMonthIcon);
			
			for(int i=0;i<yearsToGoBack;i++) {
				
				we3.click();
				
			}
			
		}
		else if(yearsToGoBack>0) {
			
			WebElement we3 = driver.findElement(cashAndPLPreviousMonthIcon);
			
			for(int i=0;i<yearsToGoBack;i++) {
				
				we3.click();
				
			}
			
		}
		String Weekday = null ;
		switch(month){
			
			case 1: Weekday = day + " Jan";
					break;
							
			case 2: Weekday = day + " Feb";
			break;
			
			case 3: Weekday = day + " Mar";
			break;
							
			case 4: Weekday = day + " Apr";
			break;
			
			case 5: Weekday = day + " May";
			break;
			
			case 6: Weekday = day + " Jun";
			break;
			
			case 7: Weekday = day + " Jul";
			break;
			
			case 8: Weekday = day + " Aug";
			break;
			
			case 9: Weekday = day + " Sep";
			break;
			
			case 10: Weekday = day + " Oct";
			break;
			
			case 11: Weekday = day + " Nov";
			break;
			
			case 12: Weekday = day + " Dec";
			break;
		}
		
		minWait();
		
		List<WebElement> weekElement = driver.findElements(cashAndPLPageWeeklySelection);
		
		for (int i = 0;i<weekElement.size();i++) {
			
			if(weekElement.get(i).getText().startsWith(Weekday)) {
				weekElement.get(i).click();
				break;
			}
		}
	}
	
	public void timePeriodYearView( int year, By element) throws InterruptedException {
		minWait();
		
		clickElement(driver, element);
		minWait();

		
		List<WebElement> yearElement = driver.findElements(cashAndPLPageYearSelection);
		
		for (int i = 0;i<yearElement.size();i++) {
			
			if(yearElement.get(i).getText().startsWith(String.valueOf(year))) {
				yearElement.get(i).click();
				break;
			}
		}
	}
	
	public void validateRecordCreation(String glName,String accName,String revBillingCycle, String value,String expEDType,String edPayTerm,String cashCount) throws InterruptedException {
		
		minWait();
		maxWait();
		By cashAndPLPageGLSelectionMethod1 = By.xpath("//tr[@class='slds-hint-parent GLParent ']//a");
		By cashAndPLPageGLChildSelectionMethod = By.xpath("//tr[contains(@class,'slds-hint-parent child')]/td[1]");
		By cashAndPLPageGLChildValues = By.xpath("//tr[contains(@class,'slds-hint-parent child')]/td");
		
		List<WebElement> we = driver.findElements(cashAndPLPageGLSelectionMethod1);
		
		int i=0;
		
		
		while(i<we.size()) {
			minWait();
			scrollBelow(we.get(i));
			Log.info("Gl scrolled "+ i+"th time.");
			Log.info(we.get(i).getText());
			if(i>4) {
				scrollDown(i);
			}
			
			if(we.get(i).getText().contains(glName)) {
				
				List<WebElement> we2 =  driver.findElements(cashAndPLGLexpandIcon);
				
	        	Log.info("GL record found");
	        	we2.get(i).click();
	        	
	        	minWait();
	        	List<WebElement> we3 =  driver.findElements(cashAndPLPageGLChildSelectionMethod);
	        	List<WebElement> we4 =  driver.findElements(cashAndPLPageGLChildValues);
	        	
	        	int lengthOfColumn = we4.size()/we3.size();
	        	
	        	Log.info("Number of columns is "+lengthOfColumn);
	        	
	        	if(we4.size() != 0) {
	        		
	        		int k =0;
		        	while( k<we4.size()) {
		        		
		        		String gName = we4.get(k).getText();
		        		Log.info(gName);
		        		if(gName.startsWith(accName)) {
		        			
		        			i= we.size();
			            	Log.info("Account matched.");
			            	minWait();
			            	
			            	int counter =0;
			          if(expEDType.matches("Non Recurring")) {
			        	  
			        	  switch(edPayTerm) {
			            	
			            	case "On Delivery": counter =0;
			            	break;
			            	case "Net 15": counter =0;
			            	break;
			            	case "Net 30": counter =-1;
			            	break;
			            	case "Net 45": counter =-1;
			            	break;
			            	case "Net 60": counter =-2;
			            	break;
			            	case "Net 75": counter =-2;
			            	break;
			            	case "Net 90": counter =-3;
			            	break;
			            	}
			        	  
			        	  for(int m=(k+1);m<(k+lengthOfColumn);m++) {
  							
  							String matchingValue = we4.get(m).getText().replaceAll(",","");
  							matchingValue = matchingValue.replaceAll(" ","");
  							Log.info("Matching value is "+ matchingValue);
  							minWait();
  		
  							if(counter ==0){
  								if(matchingValue.contains(value)) {
  								//	Assert.assertEquals(matchingValue, value);
  									Log.info("Value in Cash Screen matched to gl allocations.");
  									
  								}
  								else {
  									Log.info("Value in Cash Screen didn't match to gl allocations.");
  								}
  								
  							}
  							else if(matchingValue.matches("0.00")) {
  								//	Assert.assertEquals(matchingValue, "0.00");
  								Log.info("Value in Cash Screen matched to gl allocations.");
  							
  							}
  							else {
  								Log.info("Value in Cash Screen didn't match to gl allocations.");
  							}
  							
  							counter= counter+1;
  							}
			          
			          	}
			          else {
			        	  
			        	  switch(edPayTerm) {
			            	
			            	case "On Delivery": counter =0;
			            	break;
			            	case "Net 15": counter =0;
			            	break;
			            	case "Net 30": counter =-1;
			            	break;
			            	case "Net 45": counter =-1;
			            	break;
			            	case "Net 60": counter =-2;
			            	break;
			            	case "Net 75": counter =-2;
			            	break;
			            	case "Net 90": counter =-3;
			            	break;
			            	}
			          
				        	switch(revBillingCycle){
				        		
				        	case "Quarterly" : for(int m=(k+1);m<(k+lengthOfColumn);m++) {
				        							
				        							String matchingValue = we4.get(m).getText().replaceAll(",","");
				        							matchingValue = matchingValue.replaceAll(" ","");
				        							Log.info("Value in "+counter+"th month is "+matchingValue);
				        							minWait();
				        		
				        							if((counter%3==0 || counter ==0) && counter/3 >=0 && counter/3<Integer.valueOf(cashCount)){
				        								if(matchingValue.contains(value)) {
				        									//		Assert.assertEquals(matchingValue, value);
				        									Log.info("Value in Cash Screen matched to gl allocations.");
				        									
				        								}
				        								else {
				        									//		Assert.assertEquals(matchingValue, value);
				        									Log.info("Value in Cash Screen didn't match to gl allocations.");
				        								}
				        								
				        							}
				        							else if(matchingValue.matches("0.00")) {
				        								//	Assert.assertEquals(matchingValue, "0.00");
				        								Log.info("Value in Cash Screen matched to gl allocations.");
				        							
				        							}
				        							else {
				        								//		Assert.assertEquals(matchingValue, value);
				        								Log.info("Value in Cash Screen didn't match to gl allocations.");
				        							}
				        							
				        							counter= counter+1;
				        							}
				        							break;
				        	
				        	case "Semi Annually" : for(int m=(k+1);m<(k+lengthOfColumn);m++) {
				        								
    													String matchingValue = we4.get(m).getText().replaceAll(",","");
    													matchingValue = matchingValue.replaceAll(" ","");
    													Log.info("Value in "+counter+"th month is "+matchingValue);
    													minWait();
    		
    													if((counter%6==0 || counter ==0) && counter/6 >=0 && counter/6<Integer.valueOf(cashCount)){
    				        								if(matchingValue.contains(value)) {
    				        									//		Assert.assertEquals(matchingValue, value);
    				        									Log.info("Value in Cash Screen matched to gl allocations.");
    				        									
    				        								}
    				        								else {
    				        									//		Assert.assertEquals(matchingValue, value);
    				        									Log.info("Value in Cash Screen didn't match to gl allocations.");
    				        								}
    				        								
    				        							}
    													else if(matchingValue.matches("0.00")) {
    														//		Assert.assertEquals(matchingValue, "0.00");
    														Log.info("Value in Cash Screen matched to gl allocations.");
    														
    													}
    													else {
    														//		Assert.assertEquals(matchingValue, value);
    														Log.info("Value in Cash Screen didn't match to gl allocations.");
    													}
    													counter= counter+1;
    												
    													}
    													break;
    													
				        	case "Annually" : for(int m=(k+1);m<(k+lengthOfColumn);m++) {
				        								
														String matchingValue = we4.get(m).getText().replaceAll(",","");
														matchingValue = matchingValue.replaceAll(" ","");
														Log.info("Value in "+counter+"th month is "+matchingValue);
														minWait();

														if((counter%12==0 || counter ==0) && counter/12 >=0 && counter/12<Integer.valueOf(cashCount)){
															if(matchingValue.contains(value)) {
																//		Assert.assertEquals(matchingValue, value);
																Log.info("Value in Cash Screen matched to gl allocations.");
																
															}
															else {
																//		Assert.assertEquals(matchingValue, value);
																Log.info("Value in Cash Screen didn't match to gl allocations.");
															}
    								
														}
														else if(matchingValue.matches("0.00")) {
															//		Assert.assertEquals(matchingValue, "0.00");
															Log.info("Value in Cash Screen matched to gl allocations.");
															
														}
														else {
															//		Assert.assertEquals(matchingValue, value);
															Log.info("Value in Cash Screen didn't match to gl allocations.");
														}
														counter= counter+1;
														
														}
														break;
														
				        	case "Monthly" : for(int m=(k+1);m<(k+lengthOfColumn);m++) {
				        						
				        						String matchingValue = we4.get(m).getText().replaceAll(",","");
				        						matchingValue = matchingValue.replaceAll(" ","");
				        						Log.info("Value in "+counter+"th month is "+matchingValue);
				        						minWait();

				        						if((counter%1==0 || counter ==0) && counter/1 >=0 && counter/1<Integer.valueOf(cashCount)){
				        							if(matchingValue.contains(value)) {
				        								//		Assert.assertEquals(matchingValue, value);
				        								Log.info("Value in Cash Screen matched to gl allocations.");
				        								
				        							}
				        							else {
				        								//		Assert.assertEquals(matchingValue, value);
				        								Log.info("Value in Cash Screen didn't match to gl allocations.");
				        							}
    								
				        						}
				        						else if(matchingValue.matches("0.00")) {
				        							//		Assert.assertEquals(matchingValue, "0.00");
				        							Log.info("Value in Cash Screen matched to gl allocations.");
				        							
				        						}
				        						else {
				        							//		Assert.assertEquals(matchingValue, value);
				       								Log.info("Value in Cash Screen didn't match to gl allocations.");
				        							}
				        						counter= counter+1;
				        						
				        						}
				        						break;
				        	}
			            	
		        	}
		        	k=we4.size();	
	        	}
	        	
		        		k = k+lengthOfColumn;
	            }
	        	
			}
			
	        		}
			i++;
		}	
	}
	
	public String validationCashAmount(String revBillingCycle, String value) {
		int s = 0;
		switch(revBillingCycle) {
		
		case "Monthly": s = Integer.valueOf(value);
						break;
						
		case "Quarterly": s = Integer.valueOf(value)*3;
							break;
							
		case "Semi Annually": s = Integer.valueOf(value)*6;
								break;
								
		case "Annually": s = Integer.valueOf(value)*12;
							break;
		}
		
		return String.valueOf(s);
	}
	
	public String waitUntilDonwloadCompleted(WebDriver driver) throws InterruptedException {
	      // Store the current window handle
	      String mainWindow = driver.getWindowHandle();
	      
	      // open a new tab
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("window.open()");
	     // switch to new tab
	    // Switch to new window opened
	      for(String winHandle : driver.getWindowHandles()){
	          driver.switchTo().window(winHandle);
	      }
	     // navigate to chrome downloads
	      driver.get("chrome://downloads");
	      
	      JavascriptExecutor js1 = (JavascriptExecutor)driver;
	     
	     // get the latest downloaded file name
	      String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
	     // get the latest downloaded file url
	    //  String sourceURL = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').href");
	      // file downloaded location
	    //  String donwloadedAt = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div.is-active.focus-row-active #file-icon-wrapper img').src");
	   //   System.out.println("Download deatils");
	   //   System.out.println("File Name :-" + fileName);
	   //   System.out.println("Donwloaded path :- " + donwloadedAt);
	   //   System.out.println("Downloaded from url :- " + sourceURL);
	     // print the details
	   //   System.out.println(fileName);
	   //   System.out.println(sourceURL);
	     // close the downloads tab2
	      driver.close();
	     // switch back to main window
	      driver.switchTo().window(mainWindow);
	      return fileName;
	  }
	
	public void csvValidation(String fileX) throws FileNotFoundException, IOException {
		
		final String currentDir = System.getProperty("user.dir");
		
		String fileName = currentDir+"/downloads/" + fileX;
	
		List<String[]> r;

		
		String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//Output_" + fileX;	
		
		WriteCSV csvWrite = new WriteCSV(filePath);
		
		 
		
    try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
         r = reader.readAll();
    }

    double [][] glValidation = new double [r.get(0).length][r.size()+1];
    
    int listIndex = 0;
  
    Boolean csvFlag=false;
    
    List<Integer> glRows = new ArrayList<Integer>();
    List<Integer> failedGlRows = new ArrayList<Integer>();
    List<Integer> nextGlRows = new ArrayList<Integer>();
    List<Integer> rowsToSkip = new ArrayList<Integer>();
    
    for (String[] arrays : r) {
    	listIndex++;
        
       if(arrays.length>2) {
    	   if(!(arrays[1].isBlank())) {
    		   
        		   glRows.add(Integer.valueOf(listIndex));
    		 
           }
           																					
           if((arrays[2].matches("Quota")) || (arrays[2].matches("Employee Commissions"))) {
        	   rowsToSkip.add(Integer.valueOf(listIndex));
           }
       }

        int index = 0;
        for (String array : arrays) {
        
        	
        	if (index>2 && listIndex>2) {
        		
        		char [] ch =array.toCharArray() ;
              	 
              	 String str1 = "";
              	 
              	 for(int i =0;i<ch.length;i++) {
              		
              		 
              		 if(!((Character.getType(ch[i]) == 26) || (Character.getType(ch[i]) == 24) || (Character.getType(ch[i]) == 12) )) {
              			 str1 = str1 + ch[i];
              		 }
              	 }
       
           	
           	if(!str1.isBlank()) {
           		
           		double value = Double.parseDouble(str1);
           		
           		glValidation[index][listIndex] = value/100;
           		index++;
           	}
      
        	else {
        		index++;
        		
        	}
        	
        	} 
        	else {
        		index++;
        	}
        	
        	}
    	}
    
    
    
    for(int a=0;a<glRows.size()-6;a++) {
    	
    	
    	for (int i =3;i<r.get(0).length;i++) {
   
    		
        	double sum = 0;
        	
        	for(int j = (glRows.get(a)+1);j<glRows.get(a+1);j++) {
        		
        		Boolean skipFlag = false;
        		
        		for(int k=0;k<rowsToSkip.size();k++) {
        			
        			if(j == rowsToSkip.get(k)) {
        				skipFlag=true;
        			}
        		}
        			if(!skipFlag) {
        				sum = sum + glValidation[i][j];
        			}
        		
        	}
      
        //System.out.println(glRows);	
        	
        	if(sum == glValidation[i][glRows.get(a)]) {
      //  		System.out.println("Sum to be matched " + sum);
      //  		System.out.println("Sum Matched for "+ i +"th Column. ");
        	}
        	
        	else if((!((glRows.get(a+1) - glRows.get(a) == 1)) && (!((glValidation[i][glRows.get(a)]-sum)> -0.02) || !((glValidation[i][glRows.get(a)]-sum)< 0.02))) && !(r.get(glRows.get(a)-1)[1].matches("Total INCOME")) && !(r.get(glRows.get(a)-1)[1].matches("TOTAL REVENUE")) && !(r.get(glRows.get(a)-1)[1].matches("Total EXPENSE")))  {
            	Log.info("*********************************************************************");
            	Log.info("Failed GL name is:  " + r.get(glRows.get(a)-1)[1]);
            	Log.info("Sum failed to Match for "+ r.get(0)[i] +" Column by $ "+ (glValidation[i][glRows.get(a)]-sum));
            	Log.info("*********************************************************************");
        	csvFlag = true;
        	
        	failedGlRows.add(Integer.valueOf(glRows.get(a)-1));
        	nextGlRows.add(Integer.valueOf(glRows.get(a+1)-1));
        
        	
        }
     
        }
    }
    
    if(!csvFlag) {
    	Log.info("*********************************************************************");
    	Log.info("Data on File matched successfully.");
    	Log.info("*********************************************************************");
	 	
	}
    
    List<Integer> removedDuplicates = failedGlRows.stream()
            .distinct()
            .collect(Collectors.toList());
    
    List<Integer> removedDuplicates1 = nextGlRows.stream()
            .distinct()
            .collect(Collectors.toList());
    
	
	
    String[] header = r.get(0); 
    csvWrite.addLines(header);
    csvWrite.addLines(r.get(1));

    // add data to csv 
    for(int i =0;i<removedDuplicates.size();i++) {
    	for (int k= removedDuplicates.get(i);k<removedDuplicates1.get(i);k++) {
    		csvWrite.addLines(r.get(k));
    	}
    }

    // closing writer connection 
    csvWrite.closeFile();
	} 
	
	public void cashFilters(String InvoiceDate, String EndDate) throws InterruptedException, ParseException {
		minWait();
		driver.navigate().refresh();
		minWait();
		selectFiltercriteria("SB6","Forecast");

		String assumptionMonths;
		String finalEDate;
		
		Log.info("Entering data in From Filter");
        
		// converting string to date of format MM, yyyy
		DateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy"); 
		Date date1 = (Date)formatter1.parse(InvoiceDate);
		SimpleDateFormat newFormat1 = new SimpleDateFormat("MM, yyyy");
		String finalSDate = newFormat1.format(date1);
		Log.info("Sending date in To field");
		String fromMonth= finalSDate.substring(0,finalSDate.indexOf(","));
		String fromYear= finalSDate.substring(finalSDate.indexOf(",")+2,finalSDate.length());
	
		
		timePeriodMonthView(Integer.parseInt(fromMonth), Integer.parseInt(fromYear), Constants.cashAndPLPageFromInputBox);
		maxWait();
		
		
		// converting string to format (yyyy-MM-dd) in order to add months directly 
		
		Log.info("Entering data in To Filter");
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
		Date date = (Date)formatter.parse(InvoiceDate);
		SimpleDateFormat newFormat = new SimpleDateFormat("yyy-MM-dd");
		String finalDate = newFormat.format(date);
		if(EndDate.equalsIgnoreCase("no value")) {
			maxWait();
			clickElement(driver, assumptionDoc);
			
			maxWait();
			assumptionMonths= findElement(driver, forecastDuration).getText();
			long assptnMonth=Long.parseLong(assumptionMonths); 
			
			//adding forecast duration to invoice date 
			Log.info("adding forecast duration to invoice date ");
			LocalDate date2 = LocalDate.parse(finalDate);
			System.out.println("Date : "+date2);
			// Add x month to the date
			LocalDate newDate = date2.plusMonths(assptnMonth); 
			System.out.println("New Date : "+newDate);
			
			//converting localDate to string 
			String fDate = newDate.toString();
			// converting date from format yyyy-MM-dd to MM, yyyy
			DateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd"); 
			Date date3 = (Date)formatter3.parse(fDate);
			SimpleDateFormat newFormat3 = new SimpleDateFormat("MM, yyyy");
			 finalEDate = newFormat3.format(date3);
			 Log.info("Date to display in To when End date is not present : "+finalEDate);
			 
			 String toMonth= finalEDate.substring(0,finalEDate.indexOf(","));
				String toYear= finalEDate.substring(finalEDate.indexOf(",")+2,finalEDate.length());
			 timePeriodMonthView(Integer.parseInt(toMonth), Integer.parseInt(toYear), Constants.cashAndPLPageToInputBox);
			 minWait();
		}
		else 
		{
			// converting end date from format MM/dd/yyyy to MMMM, yyyy
						DateFormat formatter4 = new SimpleDateFormat("MM/dd/yyyy"); 
						Date date4 = (Date)formatter4.parse(EndDate);
						SimpleDateFormat newFormat4 = new SimpleDateFormat("MM, yyyy");
						String finalEndDate = newFormat4.format(date4);
						 Log.info("Date to display in To when End date is present : "+finalEndDate);
						 String toMonth= finalEndDate.substring(0,finalEndDate.indexOf(","));
							String toYear= finalEndDate.substring(finalEndDate.indexOf(",")+2,finalEndDate.length());
						 timePeriodMonthView(Integer.parseInt(toMonth), Integer.parseInt(toYear), Constants.cashAndPLPageToInputBox);
						 minWait();
		}
		minWait();
		click(driver, revenueAccountHeading);
		minWait();
		click(driver, applyButton);
		
		maxWait();
		minWait();
		click(driver, revenueAccountHeading);
		maxWait();
	}
	
	
	}

