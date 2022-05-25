package com.place.automation.cpm.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.TimeZone;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTGapAmount;

import com.opencsv.CSVReader;
import com.place.automation.cpm.base.BasePage;
import com.place.automation.utils.Log;
import com.place.automation.utils.WriteCSV;

public class CashProjectionBeta extends BasePage {
	public By cashAndPLPageScrollingFunction = By
			.xpath("//table[@class='mainTable slds-table slds-table_cell-buffer mx100 fixed_header']/tbody/tr");
	public By cashAndPLPageEmployeeCommission = By
			.xpath("//td[@class='headColumn' and @data-label='Employee Commissions']");
	public By cashAndPLPageEmpQuotaGlLink = By
			.xpath("//td[@class='Quota1 headColumn rowExpansionCollapse expansion-highlight-color']/p[2]/a");
	public By cashAndPLPageEmpCommissionGlLink = By.xpath(
			"//span[text()='Employee Commissions']/../following-sibling::p/a[@class='rowCollapse slds-m-left_xx-small']");
	public By cashAndPLPageHorizontalExpandButton = By
			.xpath("//th[@class='textCenter minWidth textRight fixedHeader']/a");
	public By cashAndPLGLexpandIcon = By
			.xpath("//tr[@class='GLCode slds-hint-parent GLParent ']/td/p/a[1]/lightning-icon");
	public static By cashAndPLPageExportCSVField = By.xpath("//button[text()='Export CSV']");
	public By cashAndPLJanuaryMonth = By.xpath("//a/span[@data-month='January']");
	public By cashAndPLFebruraryMonth = By.xpath("//a/span[@data-month='February']");
	public By cashAndPLMarchMonth = By.xpath("//a/span[@data-month='March']");
	public By cashAndPLAprilMonth = By.xpath("//a/span[@data-month='April']");
	public By cashAndPLMayMonth = By.xpath("//a/span[@data-month='May']");
	public By cashAndPLJulyMonth = By.xpath("//a/span[@data-month='July']"); //// a/span[text()='Jan']
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
	public By cashAndPLPageMonthfilter = By.xpath("//label/span[text()='Month']");
	public By cashAndPLPageQuarterfilter = By.xpath("//label/span[text()='Quarter']");
	public By cashAndPLPageYearfilter = By.xpath("//label/span[text()='Year']");
	public By cashAndPLPreviousMonthIcon = By.xpath("//div[@class='slds-align-middle']/button[@id='nextButton']");
	public By cashAndPLNextMonthIcon = By.xpath("//div[@class='slds-align-middle']/button[@title='Next Month']");
	public By cashAndPLPageOrgSelectionDropDown = By.xpath(
			"//select[@class='single wd20 slds-m-right_xx-small select uiInput uiInputSelect uiInput--default uiInput--select']");
	public By cashAndPLPageLoadingIndicator = By.xpath("//span[text()=‘Loading’]");
	public By cashAndPLPageActToDatenForecastFilter = By
			.xpath("(//select[@class='single wd20 select uiInput uiInputSelect uiInput--default uiInput--select'])[2]");
	public By cashAndPLPageYearSelection = By
			.xpath("//div[@class='slds-datepicker slds-dropdown slds-dropdown_left']/table/tbody/tr/td");
	public By cashAndPLAppLauncher = By.xpath("//div/span[text()='App Launcher']");
	public By cashAndPLAppSearch = By.xpath("//input[@placeholder='Search apps and items...']");
	public By cashAndPLMisc = By.xpath("//p[text()='Miscellaneous']");
	public By cashAndPLHorizontalExpansion = By.xpath("//th[@class='textCenter minWidth textRight fixedHeader']/a");
	public By cashAndPLVerticalExpansion = By.xpath("//tr[@class='GLCode slds-hint-parent GLParent ']//child::lightning-icon[contains(@class,'chevronright slds-icon_container')]/lightning-primitive-icon");
	public By cashandPLPageLoad = By.xpath("//lightning-spinner[@class='slds-spinner_brand positionfixed slds-spinner_container']");
	public By cashAndPLQuotaExpansion = By.xpath("//tr[contains(@class,'Quota slds-hint-parent GLParent')]//child::p[not(contains(@class,'rowExpansionExpanded'))]//child::lightning-icon[contains(@class,'chevronright slds-icon_container')]/lightning-primitive-icon");
	public By cashAndPLCommissionExpansion = By.xpath("//tr[contains(@class,'Employee Commissions')]//child::p[not(contains(@class,'rowExpansionExpanded'))]//child::lightning-icon[contains(@class,'chevronright slds-icon_container')]/lightning-primitive-icon");
	public By cashAndPLOpportunityPipeline = By.xpath("//p[@title='Opportunity Pipeline']//parent::p//parent::td//child::p[not(contains(@class,'rowExpansionExpanded'))]//child::lightning-icon[contains(@class,'chevronright slds-icon_container')]/lightning-primitive-icon");
	public By cashAndPLPageGLSelectionMethod1 = By.xpath("//p[@class='GlTitle slds-m-right_xx-small slds-is-relative tooltipWrap ']/p");
	public By cashAndPLPageQuotaRecords = By.xpath("//p[text()='Quota']//parent::p//following-sibling::p//child::lightning-primitive-icon");
    public By cashAndPLPageMonths = By.xpath("//p[contains(@class,'MonthHeader')]");
    public By cashAndPLPageGLChildSelectionMethod = By.xpath("//td[@class='Employee1 headColumn  rowClass expansion-highlight-color']/p/p");
    public By cashAndPLPageGLChildValues = By.xpath("//td[contains(@class,' rowClass')]/following-sibling::td/p/lightning-formatted-number");
	public By cashAndPLPageQuotaChildRecord = By.xpath("//tr[@class='QuotaChild slds-hint-parent GLParent expansion-highlight-color']/td/p/p");
	public By cashAndPLPageQuotachildColumns = By.xpath("//tr[@class='QuotaChild slds-hint-parent GLParent expansion-highlight-color']/td//following-sibling::td//child::lightning-formatted-number");
	public By cashAndPLPageExpenseAccounts = By.xpath("//tr[@class='Account slds-hint-parent GLParent expansion-highlight-color']/td/p/p");
	
	
	List<String> cashValue = new ArrayList();
	List<String> bonusValue = new ArrayList();
	public static List<String> finalBonusValue = new ArrayList();
	public static List<String> wageValue = new ArrayList();
	List<String> tcashValue = new ArrayList();
	double sum=0;
	Map<String, List<Integer>> monthMap = new HashMap<String, List<Integer>>();
	public CashProjectionBeta(WebDriver driver) {

		this.driver = driver;
	}

	public void scrollDown(int i) throws InterruptedException {

		List<WebElement> scrollinglist = driver.findElements(cashAndPLPageScrollingFunction);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollinglist.get(i));

		minWait();
	}

	public void scrollUp() {

		List<WebElement> scrollinglist = driver.findElements(cashAndPLPageScrollingFunction);
		int length = scrollinglist.size();

		for (int i = length - 1; i >= 0; i--) {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollinglist.get(i));
			if (i - 4 > 0) {
				i = i - 4;
			}

			
		}
	}

	public void expandEmployeeQuotaLinks() throws InterruptedException {

		scrollToTop();
		List<WebElement> empquota = driver.findElements(cashAndPLPageEmpQuotaGlLink);

		Log.info("total link of employee quota name is " + empquota.size());

		int length = empquota.size();
		for (int i = 0; i < length; i++) {
			try {
				List<WebElement> empquota2 = driver.findElements(cashAndPLPageEmpQuotaGlLink);
				scrollBelow(empquota2.get(i));
				empquota2.get(i).click();

			} catch (StaleElementReferenceException e) {
				i--;
				scrollAbit();
			} catch (org.openqa.selenium.ElementClickInterceptedException e2) {
				i--;
				scrollLarge();
			}

			waitTillInvisible(cashAndPLPageLoadingIndicator);
			Log.info("Clicked on employee quota gl expand icon " + i + " time");

		}

	}

	public void expandEmployeeCommissionLinks() throws InterruptedException {
		scrollToTop();
		List<WebElement> empcom = driver.findElements(cashAndPLPageEmpCommissionGlLink);

		Log.info("total link of employee commission name is " + empcom.size());

		int length = empcom.size();
		for (int i = 0; i < length; i++) {
			try {
				List<WebElement> empcom2 = driver.findElements(cashAndPLPageEmpCommissionGlLink);

				scrollBelow(empcom2.get(i));
				empcom2.get(i).click();
				minWait();

			} catch (StaleElementReferenceException e) {
				i--;
				scrollAbit();
			} catch (org.openqa.selenium.ElementClickInterceptedException e2) {
				i--;
				scrollLarge();
			}

			waitTillInvisible(cashAndPLPageLoadingIndicator);
			Log.info("Clicked on employee commission gl expand icon " + i + " time");

		}

	}

	public void expandHorizontal() throws InterruptedException {

		List<WebElement> we = driver.findElements(cashAndPLPageHorizontalExpandButton);

		int length = we.size();
		Log.info("Horizontal expansion length " + length);
		for (int i = 0; i < length; i++) {
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
		for (int i = 0; i < length2; i++) {
			try {
				// ((JavascriptExecutor)
				// driver).executeScript("arguments[0].scrollIntoView(true);",we2.get(i));
				we2.get(i).click();
				Log.info("Horizontal expansion clicked " + i + " times");
				minWait();
			} catch (org.openqa.selenium.ElementClickInterceptedException e) {
			}

		}

	}

	public void glExpandVertical(WebDriver driver) throws InterruptedException {
		List<WebElement> we = driver.findElements(cashAndPLGLexpandIcon);

		int countOfGL = we.size();

		Log.info("Total count of GLs is" + countOfGL);
		for (int i = 0; i < countOfGL; i++) {

			List<WebElement> we2 = driver.findElements(cashAndPLGLexpandIcon);

			try {
				scrollBelow(we2.get(i));

				we2.get(i).click();

				if (i + 1 < countOfGL) {
					scrollDown(i + 1);
//			        	Log.info("Scrolled down by "+ (i+1) +" GL");
				}

			} catch (StaleElementReferenceException e) {
				i--;
				scrollDown(i);
//		        	Log.info("Scrolled down by "+ (i) +" GL");
				// scrollAbit();
				Log.info("scrolled from catch 1 block");
			} catch (org.openqa.selenium.ElementClickInterceptedException e2) {
				i--;
				scrollDown(i);
//		        	Log.info("Scrolled down by "+ (i) +" GL");
				Log.info("scrolled from catch 2 block");
			}

			// waitTillInvisible(cashAndPLPageLoadingIndicator);
			Log.info("Clicked on gl expand icon " + i + " time");

		}

	}

	public void timePeriodMonthView(int month, int year, By element) throws InterruptedException {
		LocalDateTime now = LocalDateTime.now();

		clickElement(driver, element);
		minWait();

		int yearsToGoBack = now.getYear() - year;

		if (yearsToGoBack < 0) {

			yearsToGoBack = year - now.getYear();
			WebElement we3 = driver.findElement(cashAndPLNextMonthIcon);

			for (int i = 0; i < yearsToGoBack; i++) {

				we3.click();

			}

		} else if (yearsToGoBack > 0) {

			WebElement we3 = driver.findElement(cashAndPLPreviousMonthIcon);

			for (int i = 0; i < yearsToGoBack; i++) {

				we3.click();

			}

		}

		switch (month) {

		case 1:
			driver.findElement(cashAndPLJanuaryMonth).click();
			break;

		case 2:
			driver.findElement(cashAndPLFebruraryMonth).click();
			break;

		case 3:
			driver.findElement(cashAndPLMarchMonth).click();
			break;

		case 4:
			driver.findElement(cashAndPLAprilMonth).click();
			break;

		case 5:
			driver.findElement(cashAndPLMayMonth).click();
			break;

		case 6:
			driver.findElement(cashAndPLJuneMonth).click();
			break;

		case 7:
			driver.findElement(cashAndPLJulyMonth).click();
			break;

		case 8:
			driver.findElement(cashAndPLAugustMonth).click();
			break;

		case 9:
			driver.findElement(cashAndPLSeptemberMonth).click();
			break;

		case 10:
			driver.findElement(cashAndPLOctoberMonth).click();
			break;

		case 11:
			driver.findElement(cashAndPLNovemberMonth).click();
			break;

		case 12:
			driver.findElement(cashAndPLDecemberMonth).click();
			break;
		}
		minWait();
	}

	public void timePeriodQuarterView(int month, int year, By element) throws InterruptedException {
		LocalDateTime now = LocalDateTime.now();

		clickElement(driver, element);
		minWait();

		int yearsToGoBack = now.getYear() - year;

		if (yearsToGoBack < 0) {

			yearsToGoBack = year - now.getYear();
			WebElement we3 = driver.findElement(cashAndPLNextMonthIcon);

			for (int i = 0; i < yearsToGoBack; i++) {

				we3.click();

			}

		} else if (yearsToGoBack > 0) {

			WebElement we3 = driver.findElement(cashAndPLPreviousMonthIcon);

			for (int i = 0; i < yearsToGoBack; i++) {

				we3.click();

			}

		}

		switch (month) {

		case 1:
			driver.findElement(cashAndPLQ1Quarter).click();
			break;

		case 2:
			driver.findElement(cashAndPLQ1Quarter).click();
			break;

		case 3:
			driver.findElement(cashAndPLQ1Quarter).click();
			break;

		case 4:
			driver.findElement(cashAndPLQ2Quarter).click();
			break;

		case 5:
			driver.findElement(cashAndPLQ2Quarter).click();
			break;

		case 6:
			driver.findElement(cashAndPLQ2Quarter).click();
			break;

		case 7:
			driver.findElement(cashAndPLQ3Quarter).click();
			break;

		case 8:
			driver.findElement(cashAndPLQ3Quarter).click();
			break;

		case 9:
			driver.findElement(cashAndPLQ3Quarter).click();
			break;

		case 10:
			driver.findElement(cashAndPLQ4Quarter).click();
			break;

		case 11:
			driver.findElement(cashAndPLQ4Quarter).click();
			break;

		case 12:
			driver.findElement(cashAndPLQ4Quarter).click();
			break;
		}
		minWait();
	}

	public void SubmitDate(By element) throws InterruptedException {

		scrollToTop();
		driver.findElement(element).click();
		minWait();
	}

	public void timePeriodFilter(String value) throws InterruptedException {

		switch (value) {

		case "Month":
			clickElement(driver, cashAndPLPageMonthfilter);
			break;

		case "Quarter":
			clickElement(driver, cashAndPLPageQuarterfilter);
			break;

		case "Year":
			clickElement(driver, cashAndPLPageYearfilter);
			break;

		}
		minWait();
	}

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
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// navigate to chrome downloads
		driver.get("chrome://downloads");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		// get the latest downloaded file name
		String fileName = (String) js1.executeScript(
				"return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");

		// close the downloads tab2
		driver.close();
		// switch back to main window
		driver.switchTo().window(mainWindow);
		return fileName;
	}

	public void selectAllOrg() throws InterruptedException {

		Select orgs = new Select(driver.findElement(cashAndPLPageOrgSelectionDropDown));
		orgs.selectByVisibleText("All Organizations");

	}

	public void selectActualToDForecast(String ForecastFilter) {
		Select actualToDForecast = new Select(driver.findElement((cashAndPLPageActToDatenForecastFilter)));
		// actualToDForecast.selectByValue("Actuals to Date & Forecast");
		actualToDForecast.selectByValue(ForecastFilter);
	}

	public void selectFiltercriteria() throws InterruptedException {
		clickElement(driver, cashAndPLPageMonthfilter);
		minWait();
		selectAllOrg();
		Log.info("selected All organization filter successfully");
		minWait();

	}

	public void selectFiltercriteria(String org, String ForecastFilter) throws InterruptedException {
		clickElement(driver, cashAndPLPageMonthfilter);
		minWait();
		selectAllOrg(org);
		Log.info("selected All organization filter successfully");
		minWait();

		selectActualToDForecast(ForecastFilter);
		Log.info("selected Actuals to Daate & Forecast filter successfully");
		minWait();

	}

	public void selectAllOrg(String org) throws InterruptedException {

		Select orgs = new Select(driver.findElement(cashAndPLPageOrgSelectionDropDown));
		orgs.selectByVisibleText(org);
		// orgs.selectByVisibleText("Sandbox Company_US_3");
		// orgs.selectByVisibleText("TATA");
		// orgs.selectByVisibleText("NL Pvt Ltd");
		// orgs.selectByVisibleText("Deepak Org Bulk Data");
		// orgs.selectByVisibleText("KMO");
		// orgs.selectByVisibleText("RD Org");
		// orgs.selectByVisibleText("Sharma Traders");
		// orgs.selectByVisibleText("DSSB2INRQB");
		// orgs.selectByVisibleText("XeroTestORG");
		// orgs.selectByVisibleText("Bulk Expense");

	}

	public void timePeriodYearView(int year, By element) throws InterruptedException {
		minWait();

		clickElement(driver, element);
		minWait();

		List<WebElement> yearElement = driver.findElements(cashAndPLPageYearSelection);

		for (int i = 0; i < yearElement.size(); i++) {

			if (yearElement.get(i).getText().startsWith(String.valueOf(year))) {
				yearElement.get(i).click();
				break;
			}
		}
	}

	public void csvValidation(String fileX) throws FileNotFoundException, IOException {

		final String currentDir = System.getProperty("user.dir");

		String fileName = currentDir+"/downloads/" + fileX;

		List<String[]> r;

		String filePath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles//Output_" + fileX;

		WriteCSV csvWrite = new WriteCSV(filePath);
		 Log.info("csv :"+fileX);

		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			r = reader.readAll();
		}

		double[][] glValidation = new double[r.get(0).length][r.size() + 1];

		int listIndex = 0;

		Boolean csvFlag = false;

		List<Integer> glRows = new ArrayList<Integer>();
		List<Integer> failedGlRows = new ArrayList<Integer>();
		List<Integer> nextGlRows = new ArrayList<Integer>();
		List<Integer> rowsToSkip = new ArrayList<Integer>();

		for (String[] arrays : r) {
			listIndex++;

			if (arrays.length > 2) {
				if (!(arrays[1].isBlank())) {

					glRows.add(Integer.valueOf(listIndex));

				}

				if ((arrays[2].matches("Quota")) || (arrays[2].matches("Employee Commissions"))|| (arrays[2].matches("Opportunity Pipeline"))) {
					rowsToSkip.add(Integer.valueOf(listIndex));
				}
			}

			int index = 0;
			for (String array : arrays) {

				if (index > 2 && listIndex > 2) {

					char[] ch = array.toCharArray();

					String str1 = "";

					for (int i = 0; i < ch.length; i++) {

						if (!((Character.getType(ch[i]) == 26) || (Character.getType(ch[i]) == 24)
								|| (Character.getType(ch[i]) == 12))) {
							str1 = str1 + ch[i];
						}
					}

					if (!str1.isBlank()) {

						double value = Double.parseDouble(str1);

						glValidation[index][listIndex] = value / 100;
						index++;
					}

					else {
						index++;

					}

				} else {
					index++;
				}

			}
		}

		for (int a = 0; a < glRows.size() - 6; a++) {

			for (int i = 3; i < r.get(0).length; i++) {

				double sum = 0;

				for (int j = (glRows.get(a) + 1); j < glRows.get(a + 1); j++) {

					Boolean skipFlag = false;

					for (int k = 0; k < rowsToSkip.size(); k++) {

						if (j == rowsToSkip.get(k)) {
							skipFlag = true;
						}
					}
					if (!skipFlag) {
						sum = sum + glValidation[i][j];
					}

				}

				// System.out.println(glRows);

				if (sum == glValidation[i][glRows.get(a)]) {
					// System.out.println("Sum to be matched " + sum);
					// System.out.println("Sum Matched for "+ i +"th Column. ");
				}

				else if ((!((glRows.get(a + 1) - glRows.get(a) == 1))
						&& (!((glValidation[i][glRows.get(a)] - sum) > -0.02)
								|| !((glValidation[i][glRows.get(a)] - sum) < 0.02)))
						&& !(r.get(glRows.get(a) - 1)[1].matches("Total INCOME"))
						&& !(r.get(glRows.get(a) - 1)[1].matches("TOTAL REVENUE"))
						&& !(r.get(glRows.get(a) - 1)[1].matches("Total EXPENSE"))) {
					Log.info("*********************************************************************");
					Log.info("Failed GL name is:  " + r.get(glRows.get(a) - 1)[1]);
					Log.info("Sum failed to Match for " + r.get(0)[i] + " Column by $ "
							+ (glValidation[i][glRows.get(a)] - sum));
					Log.info("*********************************************************************");
					csvFlag = true;

					failedGlRows.add(Integer.valueOf(glRows.get(a) - 1));
					nextGlRows.add(Integer.valueOf(glRows.get(a + 1) - 1));

				}

			}
		}

		if (!csvFlag) {
			Log.info("*********************************************************************");
			Log.info("Data on File matched successfully.");
			Log.info("*********************************************************************");

		}

		List<Integer> removedDuplicates = failedGlRows.stream().distinct().collect(Collectors.toList());

		List<Integer> removedDuplicates1 = nextGlRows.stream().distinct().collect(Collectors.toList());

		String[] header = r.get(0);
		csvWrite.addLines(header);
		csvWrite.addLines(r.get(1));

		// add data to csv
		for (int i = 0; i < removedDuplicates.size(); i++) {
			for (int k = removedDuplicates.get(i); k < removedDuplicates1.get(i); k++) {
				csvWrite.addLines(r.get(k));
			}
		}

		// closing writer connection
		csvWrite.closeFile();
	}

	/*
	 * This method validate wages , bonus and tax 
	 * @param glname :Name of the Gl in which the values are stored
	 * @param employee : employee name 
	 * @param freq : Frequency of distribution 
	 * @param startDate: start date of employee 
	 * @param endDate : endDate of employee
	 * @param annualsal : annual salary of employee
	 * @param value : per month salary distribution
	 * @param record : record value stores tax /bonus/ wage
	 * @param bPeriod : bonus period 
	 * @param bFreq: bonus frequency
	 */

	public void validateWageRecord(String glname, String employee, String freq, String startDate, String endDate,
			String annualSal, String value, String record, String bPeriod,String bFreq ) throws InterruptedException, ParseException, IOException {
		
		
		String bonus1="";
		String wage="";
		minWait();
		maxWait();
		minWait();
		String sBonus="";
		EmployeePage employeeObj = new EmployeePage(driver);


		
		int loopcount = 0;
		List<WebElement> we = driver.findElements(cashAndPLPageGLSelectionMethod1);
		System.out.println("Size of list:" + we.size());
		int i = 0;
		int counter = 0;
		while (i < we.size()) {

			scrollBelow(we.get(i));
			Log.info("Gl scrolled " + i + "th time.");
			Log.info(we.get(i).getText());
			if (i > 4) {
				scrollDown(i - 2);
			}

			if (we.get(i).getText().contains(glname)) {

				Log.info("GL record found");
				minWait();

				click(driver, By.xpath("(//p[text()='" + glname+ "']//parent::p//following-sibling::p/a/lightning-icon/child::lightning-primitive-icon)[1]"));
				minWait();

				List<WebElement> we3 = driver.findElements(cashAndPLPageGLChildSelectionMethod);

				List<WebElement> we4 = driver.findElements(cashAndPLPageGLChildValues);
				minWait();
				int lengthOfColumn = we4.size() / we3.size();

				Log.info("Number of columns is " + lengthOfColumn);
				DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				Date date = (Date) formatter.parse(startDate);
				SimpleDateFormat newFormat = new SimpleDateFormat("yyy-MM-dd");
				String sDate = newFormat.format(date);
				Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
				calendar.setTime(date);
				int syear = calendar.get(Calendar.YEAR);
				System.out.println(syear);
				int sDay = calendar.get(Calendar.DAY_OF_MONTH);
				System.out.println(sDay);
				int sMonth = Integer.parseInt(new SimpleDateFormat("MM").format(calendar.getTime()));
				System.out.println(sMonth);

				YearMonth yearMonthObject = YearMonth.of(syear, sMonth);
				int daysInMonth = yearMonthObject.lengthOfMonth();
				Log.info("Number of Days in start Month " + daysInMonth);

				DateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
				Date date1 = (Date) formatter1.parse(endDate);
				SimpleDateFormat newFormat1 = new SimpleDateFormat("yyy-MM-dd");
				String eDate = newFormat1.format(date1);
				Calendar calendar1 = Calendar.getInstance(TimeZone.getDefault());
				calendar1.setTime(date1);
				int eyear = calendar1.get(Calendar.YEAR);
				System.out.println(eyear);
				int eDay = calendar1.get(Calendar.DAY_OF_MONTH);
				System.out.println(eDay);
				int eMonth = Integer.parseInt(new SimpleDateFormat("MM").format(calendar1.getTime()));
				System.out.println(eMonth);

				YearMonth yearMonth = YearMonth.of(eyear, eMonth);
				int daysIneMonth = yearMonth.lengthOfMonth();
				Log.info("Days in end Month" + daysIneMonth);

				Period diff = Period.between(LocalDate.parse(eDate).withDayOfMonth(1),
						LocalDate.parse(sDate).withDayOfMonth(1));
			int index1=	diff.toString().indexOf("-");
			int index2 = diff.toString().indexOf("M");
			 
			
				int counter1 = Integer.parseInt(diff.toString().substring(index1+1, index2));
				Log.info("Difference between start date and end date is: "+counter1);
				if (we4.size() != 0) {
					int k = 0;
					String gName = we3.get(k).getText();
					Log.info("'First Employee name is" + gName);
					i = we3.size();
					scrollBelow(we3.get(i - 1));
					Log.info("Last employee is" + we3.get(i - 1).getText());
					Log.info("Employee name is : " + employeeObj.employeeWithDate);
					if(we3.get(i - 1).getText().equalsIgnoreCase(employeeObj.employeeWithDate)) {
					Log.info("Employee found");
					minWait();
					}
					else 
					{
						Log.info("Employee not present");
						scrollRight();
						scrollRight();
						maxWait();
						minWait();
						scrollRight();
						scrollRight();
						maxWait();
						minWait();
						
						
						List<WebElement> monAfterscroll = driver.findElements(cashAndPLPageMonths);
						Log.info("After scroll size: " + monAfterscroll.size());
						int counter2 = monAfterscroll.size();
						while(finalBonusValue.size()!=counter2)
						{
							finalBonusValue.add("");
						}
						break;
					}
					if (i == we3.size()) {

						List<WebElement> mon = driver.findElements(cashAndPLPageMonths);
						System.out.println("Size of list:" + mon.size());

						scrollRight();
						scrollRight();
						maxWait();
						minWait();
						scrollRight();
						scrollRight();
						maxWait();
						minWait();
						
						
						List<WebElement> monAfterscroll = driver.findElements(cashAndPLPageMonths);
						Log.info("After scroll size: " + monAfterscroll.size());
						int counter2 = monAfterscroll.size();
						Log.info("Employee list size:" + we3.size());
						List<WebElement> colAfterscroll = driver.findElements(cashAndPLPageGLChildValues);
						Log.info("Columns After scroll size : " + colAfterscroll.size());

						int col = ((we3.size()-1) * counter2);
						
						int lastvalue;
						if (verifyPresence(cashAndPLMisc)) {
							lastvalue = colAfterscroll.size() - counter2;
						} else {
							lastvalue = colAfterscroll.size();
						}
						
						if(verifyPresence(cashAndPLQuotaExpansion)) {
							lastvalue = lastvalue - counter2;
						}
						if(verifyPresence(cashAndPLCommissionExpansion)) {
							col = (col + counter2)-1;
						}
						Log.info("Starting point of validation is "+col);
						Log.info("End point of validation is "+lastvalue);
						for (int m = col ; m < lastvalue; m++) {
							
							
							String matchingValue = colAfterscroll.get(m).getText().replaceAll(",", "");
							matchingValue = matchingValue.replaceAll(" ", "");
						Log.info("Value in " + counter + "th month is " + matchingValue);
							minWait();
						
							wage = wageCalculation(sDay,  eDay,  matchingValue,  value, freq, daysInMonth, daysIneMonth, counter1, loopcount);
							
							if(record.equalsIgnoreCase("Wage")) {
							Logger(matchingValue, wage);
							}
							
							else if (record.equalsIgnoreCase("Bonus")) {
								
								
									
									 cashValue.add( matchingValue);
									 if(wage!="") {
										 double bonus = Double.parseDouble(wage)*0.10;
											DecimalFormat df = new DecimalFormat("#.00");
											 sBonus = df.format(bonus);
									 bonusValue.add(sBonus);
									 }
									 else
										 bonusValue.add("");
								
									}
								
				
								else if(record.equalsIgnoreCase("Tax")) {
									tcashValue.add(matchingValue);
							        wageValue.add(wage);
								}
							loopcount++;
							counter += 1;
							
						}
						if(record.equalsIgnoreCase("Bonus")) {
							
							 bonusCalculation(bPeriod, bFreq, counter1, bonusValue, sMonth, eMonth);


							for(int p =0; p<cashValue.size()-1;p++) {
							   
									Logger(cashValue.get(p), finalBonusValue.get(p));
									
								
							}
						}
						
						if(record.equalsIgnoreCase("Tax")) {
							
							for(int l=0;l<wageValue.size()-1;l++) {
								if(wageValue.get(l)!= "") {
							if(finalBonusValue.get(l).equalsIgnoreCase("")) {
								String tax = String.valueOf(Double.parseDouble(wageValue.get(l))*0.10);
								Logger(tcashValue.get(l), tax);
							}
							else
							{
								String tax = String.valueOf((Double.parseDouble(wageValue.get(l))+Double.parseDouble(finalBonusValue.get(l)))*0.10);
								Logger(tcashValue.get(l), tax);
							}
								}
								else
									Logger(tcashValue.get(l), "");
						}
						}
					}

				}
				break;
			}

			i++;
		}
cashValue.clear();
tcashValue.clear();
bonusValue.clear();
	}

	/*
	 * This method calculates the wage according to the number of days 
	 * @param sDay : starting date day 
	 * @param eDay : end date day
	 * @param : matchingValue : Value on the screen 
	 * @param value : per month compensation value
	 * @param freq : frequency of wage distribution
	 * @param daysInMonth: Days in starting month 
	 * @param daysIneMonth: Days in ending month
	 * @param counter1 and loopcount : These are integer values
	 */

			
	
	public String wageCalculation(int sDay, int eDay, String matchingValue, String value, String freq, int daysInMonth, int daysIneMonth, int counter1, int loopcount) {
		
		
		String wage = "";
		int counter = 0;
		if (sDay == 1 && eDay == daysIneMonth) 
		{
			
			Log.info("Inside complete months block");
			if (loopcount <= (counter1)) {
				wage = value;
			} 
			
		}
		else
		{
		
		
		if (loopcount == 0) {

			if (sDay == 1) {
				Log.info("Matching first month value when start date is 1");
				wage = value;
				
			} else {
				Log.info("Matching first month value when start date is not 1");
				if (freq.equalsIgnoreCase("Monthly")) {
					int workingDays = daysInMonth - (sDay - 1);
					double salary = (Double.parseDouble(value) / daysInMonth) * workingDays;
					System.out.println("Salary is: " + salary);
					DecimalFormat df = new DecimalFormat("#.00");
					wage = df.format(salary);
					Log.info("Value to be matched is: " + wage);

				} else if (freq.equalsIgnoreCase("Semi-Monthly")) {
					double halfMonthSalary = (Double.parseDouble(value)) / 2;
					double salaryPerDay = (Double.parseDouble(value) / daysInMonth);

					if (sDay < 15) {
						int days = 15 - (sDay - 1);
						double salary = salaryPerDay * days;
						double tSalary = salary + halfMonthSalary;
						System.out.println("Salary is: " + tSalary);
						DecimalFormat df = new DecimalFormat("#.00");
						wage = df.format(tSalary);
						Log.info("Value to be matched is: " + wage);
					}

					else {
						int days = (sDay - 1) - 15;
						double salary = salaryPerDay * days;
						double tSalary = halfMonthSalary - salary;
						System.out.println("Salary is: " + tSalary);
						DecimalFormat df = new DecimalFormat("#.00");
						wage = df.format(tSalary);
						Log.info("Value to be matched is: " + wage);
					}

				}

				
			}

		}

		if (loopcount != 0 && loopcount < (counter1)) {
			Log.info("Matching full months");
			wage= value;

		}
		if (loopcount == (counter1)) {

			Log.info("Matching last Month value");
			if (eDay == daysIneMonth) {
				Log.info("Matching last month value when end date is last day of month");
				wage= value;
			} else {
				Log.info("Matching last month value when is not last day");
				if (freq.equalsIgnoreCase("Monthly")) {
					int workingDays = eDay;
					double salary = (Double.parseDouble(value) / daysIneMonth);
					double tSalary = salary * workingDays;
					System.out.println("Salary is: " + tSalary);
					DecimalFormat df = new DecimalFormat("#.00");
					wage = df.format(tSalary);
					Log.info("Value to be matched is: " + wage);

				} else if (freq.equalsIgnoreCase("Semi-Monthly")) {
					double halfMonthSalary = (Double.parseDouble(value)) / 2;
					double salaryPerDay = (Double.parseDouble(value) / daysIneMonth);

					if (eDay < 15) {
						int days = eDay;
						double salary = salaryPerDay * days;
						double tSalary = salary;
						System.out.println("Salary is: " + tSalary);
						DecimalFormat df = new DecimalFormat("#.00");
						wage = df.format(tSalary);
						Log.info("Value to be matched is: " + wage);
					}

					else {
						int days = (eDay) - 15;
						double salary = salaryPerDay * days;
						double tSalary = halfMonthSalary + salary;
						System.out.println("Salary is: " + tSalary);
						DecimalFormat df = new DecimalFormat("#.00");
						wage = df.format(tSalary);
						Log.info("Value to be matched is: " + wage);
					}

				}
			}
			

		}

		
		
	}
		return wage;
	}
	/*
	 * This method logs the value to be matched against the value on the screen 
	 * @param matchingValue : This is the value on the screen
	 * @param value : This is the calculated value 
	 */
	public void Logger(String matchingValue, String value ) throws IOException {
		if (matchingValue.contains(value)) {
			Log.info("Value on screen is: "+matchingValue);
			Log.info("Value to be matched is: " + value);
			Log.info("Value in Cash Screen matched to gl allocations.");

		} else {
			Log.info("Value on screen is: "+matchingValue);
			Log.info("Value to be matched is: " + value);
			Log.error("Value in Cash Screen didn't match to gl allocations.");
			//screenshotCap(driver);
		}
	}
	/*
	 * This method calculates the bonus according to different period type and frequency 
	 * @param bFreq : Frequency of bonus 
	 * @param bPeriod: bonus period type
	 * @param counter1:  Flag used
	 * @param bonusValue : List of bonus values
	 * @param sMonth : start month
	 * @param eMonth : end month
	 */
	
	public void bonusCalculation(String bPeriod,String bFreq,  int counter1,List<String> bonusValue, int sMonth, int eMonth) {
		String sBonus="";
		int flag=0;
		
		if(bFreq.equalsIgnoreCase("On Delivery")) {
			if(bPeriod.equalsIgnoreCase("Monthly")) {
				
				for(int k=0;k<bonusValue.size();k++) {
					
					finalBonusValue.add(bonusValue.get(k));
				
				}
					
				}
			
			else if(bPeriod.equalsIgnoreCase("Quarterly")) {
				int month = sMonth;
				monthMap.put("Quarter1", Arrays.asList(1, 2, 3));
				monthMap.put("Quarter2", Arrays.asList(4,5,6));
				monthMap.put("Quarter3", Arrays.asList(7,8,9));
				monthMap.put("Quarter4", Arrays.asList(10,11,12));
				String quarter="";
				String quarter1="";
				while(flag<=counter1) {
					if(month>12) {
						month= month-12;
					}
					switch (month){
						case 1: 
						case 2:
						case 3:
							quarter = "Quarter1";
							Log.info("Start month is in:"+quarter);
							break;
							
						case 4:
						case 5:
						case 6:
							quarter = "Quarter2";
							Log.info("Start month is in:"+quarter);
							break;
						case 7:
						case 8:
						case 9:
							quarter = "Quarter3";
							Log.info("Start month is in:"+quarter);
							break;
						case 10:
						case 11:
						case 12:
							quarter = "Quarter4";
							Log.info("Start month is in:"+quarter);
							break;
					}
					
					
					if (quarter1!=quarter) {
						sum=0;
					}
					
				int sIndex= monthMap.get(quarter).indexOf(month);
				
					sum = sum + (Double.parseDouble(bonusValue.get(flag)));
				   sBonus=String.valueOf(sum);
				   
				
				
				
				
				if(sIndex==0) {
					finalBonusValue.add("");
					
				}
				else if(sIndex==1) {
					finalBonusValue.add("");
					
					
				}
				else if(sIndex==2)
				{
					
					finalBonusValue.add(sBonus);
					
				}
				
			
				flag=flag+1;
				month=month+1;
				quarter1 = quarter;
				}
				
				
				while(finalBonusValue.size()!=bonusValue.size()) {
					finalBonusValue.add("");
				}
					 
			}
			else if(bPeriod.equalsIgnoreCase("Semi-Annually")) {
				
				int month = sMonth;
				monthMap.put("Quarter1", Arrays.asList(1, 2, 3,4,5,6));
				monthMap.put("Quarter2", Arrays.asList(7,8,9,10,11,12));
				
				String quarter="";
				String quarter1="";
				while(flag<=counter1) {
					if(month>12) {
						month= month-12;
					}
					switch (month){
						case 1: 
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
							quarter = "Quarter1";
							Log.info("Month is in:"+quarter);
							break;
							
						
							
						case 7:
						case 8:
						case 9:
						case 10:
						case 11:
						case 12:
							quarter = "Quarter2";
							Log.info("Start month is in:"+quarter);
							break;
						
						
					}
					
					
					if (quarter1!=quarter) {
						sum=0;
					}
					
				int sIndex= monthMap.get(quarter).indexOf(month);
				
					sum = sum + (Double.parseDouble(bonusValue.get(flag)));
				   sBonus=String.valueOf(sum);
				   
				
				
				
				
				if(sIndex==0||sIndex==1||sIndex==2||sIndex==3||sIndex==4) {
					finalBonusValue.add("");
					
				}
				
				else if(sIndex==5)
				{
					
					finalBonusValue.add(sBonus);
					
				}
				
			
				flag=flag+1;
				month=month+1;
				quarter1 = quarter;
				}
				
				
				while(finalBonusValue.size()!=bonusValue.size()) {
					finalBonusValue.add("");
				}
				}
			
			else if(bPeriod.equalsIgnoreCase("Annually")) {
				
					
				int month = sMonth;
				monthMap.put("Quarter1", Arrays.asList(1, 2, 3,4,5,6,7,8,9,10,11,12));
				
				String quarter="";
				String quarter1="";
				while(flag<=counter1) {
					if(month>12) {
						sum=0;
						month= month-12;
					}
					switch (month){
						case 1: 
						case 2:
						case 3:
						case 4:
						case 5:
						case 6:
						case 7:
						case 8:
						case 9:
						case 10:
						case 11:
						case 12:
							quarter = "Quarter1";
							Log.info("Month is in:"+quarter);
							break;
							
					}
					
					
					if (quarter1!=quarter) {
						sum=0;
					}
					
				int sIndex= monthMap.get(quarter).indexOf(month);
				
					sum = sum + (Double.parseDouble(bonusValue.get(flag)));
				   sBonus=String.valueOf(sum);
				   
				
				
				
				
				if(sIndex==0||sIndex==1||sIndex==2||sIndex==3||sIndex==4||sIndex==5||sIndex==6||sIndex==7||sIndex==8||sIndex==9||sIndex==10) {
					finalBonusValue.add("");
					
				}
				
				else if(sIndex==11)
				{
					
					finalBonusValue.add(sBonus);
					
				}
				
			
				flag=flag+1;
				month=month+1;
				quarter1 = quarter;
				}
				
				
				while(finalBonusValue.size()!=bonusValue.size()) {
					finalBonusValue.add("");
				}
			
		}
		}
		else 
			if(bFreq.equalsIgnoreCase("End of Next Month")){
				if(bPeriod.equalsIgnoreCase("Monthly")) {
					finalBonusValue.add("");
					while(flag<counter1) {
						
						finalBonusValue.add(bonusValue.get(flag));
						flag= flag+1;
					}
					while(finalBonusValue.size()!=bonusValue.size()) {
						finalBonusValue.add("");
					}
					
									}
				else if(bPeriod.equalsIgnoreCase("Quarterly")) {
					finalBonusValue.add("");
					int month = sMonth;
					monthMap.put("Quarter1", Arrays.asList(1, 2, 3));
					monthMap.put("Quarter2", Arrays.asList(4,5,6));
					monthMap.put("Quarter3", Arrays.asList(7,8,9));
					monthMap.put("Quarter4", Arrays.asList(10,11,12));
					String quarter="";
					String quarter1="";
					while(flag<counter1) {
						if(month>12) {
							month= month-12;
						}
						switch (month){
							case 1: 
							case 2:
							case 3:
								quarter = "Quarter1";
								Log.info("Start month is in:"+quarter);
								break;
								
							case 4:
							case 5:
							case 6:
								quarter = "Quarter2";
								Log.info("Start month is in:"+quarter);
								break;
							case 7:
							case 8:
							case 9:
								quarter = "Quarter3";
								Log.info("Start month is in:"+quarter);
								break;
							case 10:
							case 11:
							case 12:
								quarter = "Quarter4";
								Log.info("Start month is in:"+quarter);
								break;
						}
						
						
						if (quarter1!=quarter) {
							sum=0;
						}
						
					int sIndex= monthMap.get(quarter).indexOf(month);
					
						sum = sum + (Double.parseDouble(bonusValue.get(flag)));
					   sBonus=String.valueOf(sum);
					   
					
					
					
					
					if(sIndex==0) {
						finalBonusValue.add("");
						
					}
					else if(sIndex==1) {
						finalBonusValue.add("");
						
						
					}
					else if(sIndex==2)
					{
						
						finalBonusValue.add(sBonus);
						flag=flag+1;
						sum=0;
						
						sum = sum + (Double.parseDouble(bonusValue.get(flag)));
						   sBonus=String.valueOf(sum);

					}
					
				
					flag=flag+1;
					month=month+1;
					quarter1 = quarter;
					}
					
					
					while(finalBonusValue.size()!=bonusValue.size()) {
						finalBonusValue.add("");
					}
						 
				}
				else if(bPeriod.equalsIgnoreCase("Semi-Annually")) {
					finalBonusValue.add("");
					int month = sMonth;
					monthMap.put("Quarter1", Arrays.asList(1, 2, 3,4,5,6));
					monthMap.put("Quarter2", Arrays.asList(7,8,9,10,11,12));
					
					String quarter="";
					String quarter1="";
					while(flag<counter1) {
						if(month>12) {
							month= month-12;
						}
						switch (month){
							case 1: 
							case 2:
							case 3:
							case 4:
							case 5:
							case 6:
								quarter = "Quarter1";
								Log.info("Month is in:"+quarter);
								break;
								
							
								
							case 7:
							case 8:
							case 9:
							case 10:
							case 11:
							case 12:
								quarter = "Quarter2";
								Log.info("Start month is in:"+quarter);
								break;
							
							
						}
						
						
						if (quarter1!=quarter) {
							sum=0;
						}
						
					int sIndex= monthMap.get(quarter).indexOf(month);
					
						sum = sum + (Double.parseDouble(bonusValue.get(flag)));
					   sBonus=String.valueOf(sum);
					   
					
					
					
					
					if(sIndex==0||sIndex==1||sIndex==2||sIndex==3||sIndex==4) {
						finalBonusValue.add("");
						
					}
					
					else if(sIndex==5)
					{
						finalBonusValue.add(sBonus);
						flag=flag+1;
						sum=0;
						
						sum = sum + (Double.parseDouble(bonusValue.get(flag)));
						   sBonus=String.valueOf(sum);
						
					}
					
				
					flag=flag+1;
					month=month+1;
					quarter1 = quarter;
					}
					
					
					while(finalBonusValue.size()!=bonusValue.size()) {
						finalBonusValue.add("");
					}
					}
				else if(bPeriod.equalsIgnoreCase("Annually")) {
					finalBonusValue.add("");
					
					int month = sMonth;
					monthMap.put("Quarter1", Arrays.asList(1, 2, 3,4,5,6,7,8,9,10,11,12));
					
					String quarter="";
					String quarter1="";
					while(flag<counter1) {
						if(month>12) {
							sum=0;
							month= month-12;
						}
						switch (month){
							case 1: 
							case 2:
							case 3:
							case 4:
							case 5:
							case 6:
							case 7:
							case 8:
							case 9:
							case 10:
							case 11:
							case 12:
								quarter = "Quarter1";
								Log.info("Month is in:"+quarter);
								break;
								
						}
						
						
						if (quarter1!=quarter) {
							sum=0;
						}
						
					int sIndex= monthMap.get(quarter).indexOf(month);
					
						sum = sum + (Double.parseDouble(bonusValue.get(flag)));
					   sBonus=String.valueOf(sum);
					   
					
					
					
					
					if(sIndex==0||sIndex==1||sIndex==2||sIndex==3||sIndex==4||sIndex==5||sIndex==6||sIndex==7||sIndex==8||sIndex==9||sIndex==10) {
						finalBonusValue.add("");
						
					}
					
					else if(sIndex==11)
					{
						finalBonusValue.add(sBonus);
						flag=flag+1;
						sum=0;
						
						sum = sum + (Double.parseDouble(bonusValue.get(flag)));
						   sBonus=String.valueOf(sum);
						
					}
					
				
					flag=flag+1;
					month=month+1;
					quarter1 = quarter;
					}
					
					
					while(finalBonusValue.size()!=bonusValue.size()) {
						finalBonusValue.add("");
					}
				
			}
			}
		
		
		
	}
	

	/*
	 * this method deleted the compensation record of an employee
	 * @param glname: stores the name of gl in which the employee was earlier present
	 */
	
	public void deletedCompVerification(String glname) throws InterruptedException {
		minWait();
		maxWait();
		minWait();
		
		EmployeePage employeeObj = new EmployeePage(driver);


		
	
		List<WebElement> we = driver.findElements(cashAndPLPageGLSelectionMethod1);
		System.out.println("Size of list:" + we.size());
		int i = 0;
		
		while (i < we.size()) {

			scrollBelow(we.get(i));
			Log.info("Gl scrolled " + i + "th time.");
			Log.info(we.get(i).getText());
			if (i > 4) {
				scrollDown(i - 2);
			}

			if (we.get(i).getText().contains(glname)) {

				Log.info("GL record found");
				minWait();

				click(driver, By.xpath("(//p[text()='" + glname+ "']//parent::p//following-sibling::p/a/lightning-icon/child::lightning-primitive-icon)[1]"));
				minWait();

				List<WebElement> we3 = driver.findElements(cashAndPLPageGLChildSelectionMethod);

				List<WebElement> we4 = driver.findElements(cashAndPLPageGLChildValues);
				minWait();
				int lengthOfColumn = we4.size() / we3.size();

				Log.info("Number of columns is " + lengthOfColumn);
				

				if (we4.size() != 0) {
					int k = 0;
					String gName = we3.get(k).getText();
					Log.info("'First Employee name is" + gName);
					i = we3.size();
					scrollBelow(we3.get(i - 1));
					Log.info("Last employee is" + we3.get(i - 1).getText());
					Log.info("Employee name is : " + employeeObj.employeeWithDate);
					if(we3.get(i - 1).getText().equalsIgnoreCase(employeeObj.employeeWithDate)) {
					Log.info("Employee still present");
					}
					else 
					Log.info("employee is deleted ");
					
				}
				break;	
			}
			i++;
		}
	}
	
	/*
	 * This method expands gl horizontally
	 */
	
	public void horizontalExpansionBeta() throws InterruptedException {
		scrollRight();
List<WebElement> horizontalList = driver.findElements(cashAndPLHorizontalExpansion);
		
		int length = horizontalList.size();
		Log.info("Horizontal expansion length " + length);
		scrollRight();
		scrollRight();
		int lengthafterscroll = horizontalList.size();
		for(int i=0;i<lengthafterscroll;i++)
		{
				clickElement(horizontalList.get(i));
				Log.info("Horizontal expansion clicked " + i + " times");
				minWait();
				
				
		}
	}
	
	/*
	 * This method expands gl vertically
	 */
	public void verticalExpansionBeta() throws InterruptedException {
		
List<WebElement> verticalList = driver.findElements(cashAndPLVerticalExpansion);
		
		int length = verticalList.size();
		Log.info("Vertical expansion length " + length);
		
		
		for(int i=0;i<length;i++)
		{
			By Vertical = By.xpath("(//tr[@class='GLCode slds-hint-parent GLParent ']//child::lightning-icon[contains(@class,'chevronright slds-icon_container')]/lightning-primitive-icon)["+(i+1)+"]");
			
			
			
				clickElement(driver,Vertical);
				
			
				Log.info("Vertical expansion clicked " + i + " times");
			
				/*waitFortheElementToBeInvisible(cashandPLPageLoad);
				if(verifyPresence(cashandPLPageLoad)!=false) {
				maxWait();
				}*/
				//Thread.sleep(120000);
				if(verifyPresence(cashAndPLQuotaExpansion)==true) {
					//scrollAbit();
				clickElement(driver, cashAndPLQuotaExpansion);
				Log.info("Quota expanded");
				minWait();
				}
				if(verifyPresence(cashAndPLCommissionExpansion)==true) {
					//scrollAbit();
					clickElement(driver,cashAndPLCommissionExpansion);
					Log.info("Commission expanded");
					minWait();
				}
				if(verifyPresence(cashAndPLOpportunityPipeline)==true) {
					clickElement(driver,cashAndPLOpportunityPipeline);
					Log.info("Opportunity pipeline expanded");
					minWait();
				}
				if(i<length-1) {
				scrollDown(i+1, cashAndPLVerticalExpansion);
				}
				
				
		}
	}
	/*
	 * This is a generic method for cash screen which returns the values we need to verify 
	 * @param glname: The GL name 
	 * @param employee : Employee for which we need to verify values
	 * @param startDate : start date of period
	 * @param endDate : end date of period
	 */
	
	public Map<Integer, List<String>> locatingValues(String glname,String employee, String startDate, String endDate) throws InterruptedException, ParseException {
		int loopcount = 0;
		Map<Integer, List<String>> valueMap = new HashMap<Integer, List<String>>();
		List<WebElement> we = driver.findElements(cashAndPLPageGLSelectionMethod1);
		Log.info("Size of list of gls:" + we.size());
		int i = 0;
		int counter = 0;
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(startDate);
		SimpleDateFormat newFormat = new SimpleDateFormat("yyy-MM-dd");
		String sDate = newFormat.format(date);
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(date);
		int syear = calendar.get(Calendar.YEAR);
		System.out.println(syear);
		int sDay = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(sDay);
		int sMonth = Integer.parseInt(new SimpleDateFormat("MM").format(calendar.getTime()));
		System.out.println(sMonth);

		YearMonth yearMonthObject = YearMonth.of(syear, sMonth);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		Log.info("Number of Days in start Month " + daysInMonth);

		DateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = (Date) formatter1.parse(endDate);
		SimpleDateFormat newFormat1 = new SimpleDateFormat("yyy-MM-dd");
		String eDate = newFormat1.format(date1);
		Calendar calendar1 = Calendar.getInstance(TimeZone.getDefault());
		calendar1.setTime(date1);
		int eyear = calendar1.get(Calendar.YEAR);
		System.out.println(eyear);
		int eDay = calendar1.get(Calendar.DAY_OF_MONTH);
		System.out.println(eDay);
		int eMonth = Integer.parseInt(new SimpleDateFormat("MM").format(calendar1.getTime()));
		System.out.println(eMonth);

		YearMonth yearMonth = YearMonth.of(eyear, eMonth);
		int daysIneMonth = yearMonth.lengthOfMonth();
		Log.info("Days in end Month" + daysIneMonth);

		Period diff = Period.between(LocalDate.parse(eDate).withDayOfMonth(1),
				LocalDate.parse(sDate).withDayOfMonth(1));
		int counter1;
		if(diff.toString().contains("Y")) {
		int  diff1= diff.getMonths();
		
		
			counter1 = 12-diff1;
		}
		else 
		{
				int index1=	diff.toString().indexOf("-");
	            int index2 = diff.toString().indexOf("M");
	            counter1= Integer.parseInt(diff.toString().substring(index1+1,index2));
	 
		}
		
		Log.info("Difference between start date and end date is: "+counter1);
		while (i < we.size()) {

			scrollBelow(we.get(i));
			Log.info("Gl scrolled " + i + "th time.");
			Log.info(we.get(i).getText());
			if (i > 4) {
				scrollDown(i - 2);
			}

			if (we.get(i).getText().contains(glname))
			{

				Log.info("GL record found");
				minWait();
				int index = i+1;
				click(driver, By.xpath("(//p[contains(@class,'GlTitle')]//following-sibling::p/a[not(contains(@class,'rowExpanded'))]/lightning-icon/lightning-primitive-icon)["+index+"]"));
				minWait();
				scrollRight();
				scrollRight();
				scrollRight();
				scrollRight();
				horizontalScroll();
				horizontalScroll();
				minWait();
				minWait();
				if(verifyPresence(cashAndPLPageQuotaRecords)==true)
				{
				click(driver, cashAndPLPageQuotaRecords);
				minWait();
				List <WebElement> quotaRecords = driver.findElements(cashAndPLPageQuotaChildRecord);
				for(int j=0;j<quotaRecords.size();j++) {
					scrollBelow(quotaRecords.get(j));
					Log.info("Emoployee name is :"+quotaRecords.get(j).getText());
					if(quotaRecords.get(j).getText().contains(employee)) {
						Log.info("Quota record found");
						
					
						int k =j+1;
					int quotaSize = driver.findElements(By.xpath("(//tr[contains(@class,'QuotaChild')])["+k+"]//child::td[contains(@class,'rowClass expansion')]/p/lightning-formatted-number")).size();
					
					List<String> cashValues = new ArrayList();
					for(int m =1;m<=quotaSize;m++) {
						
						
					String value =	driver.findElement(By.xpath("((//tr[contains(@class,'QuotaChild')])["+k+"]//child::td[contains(@class,'rowClass expansion')]/p/lightning-formatted-number)["+m+"]")).getText();
					if(value.equalsIgnoreCase("")) {
						value= "0.0";
					}
					System.out.println(value);
					cashValues.add(value);
					}
					
					valueMap.put(counter1, cashValues);
					System.out.println(valueMap);
					
					break;
					}
				}
		
				break;
				}
				else if(verifyPresence(cashAndPLPageExpenseAccounts)==true)
				
				{
					List <WebElement> expenseRecords = driver.findElements(cashAndPLPageExpenseAccounts);
					for(int j=0;j<expenseRecords.size();j++) {
						scrollBelow(expenseRecords.get(j));
						Log.info("Expense Account name is :"+expenseRecords.get(j).getText());
						if(expenseRecords.get(j).getText().contains(employee)) {
							Log.info("Expense Account record found");
							minWait();
							scrollRight();
							scrollRight();
							scrollRight();
							scrollRight();
							minWait();
							minWait();
							
							int k =j+1;
							int expenseSize = driver.findElements(By.xpath("(//tr[contains(@class,'Account')])["+k+"]//child::td[contains(@class,'rowClass expansion')]/p/lightning-formatted-number")).size();
							
							List<String> cashValues = new ArrayList();
							for(int m =1;m<=expenseSize;m++) {
								
								
							String value =	driver.findElement(By.xpath("((//tr[contains(@class,'Account')])["+k+"]//child::td[contains(@class,'rowClass expansion')]/p/lightning-formatted-number)["+m+"]")).getText();
							if(value.equalsIgnoreCase("")) {
								value= "0.0";
							}
							System.out.println(value);
							cashValues.add(value);
							}
							
							valueMap.put(counter1, cashValues);
							System.out.println(valueMap);
							
							break;
						}
					}
					break;
				}
	         }
				
			i=i+1;
			
}
		return valueMap;
	}
	
	/*
	 * This method is regarding all the calculations of quota
	 * @param startDate : Quota start Date 
	 * @param endDate: Quota end date 
	 * @param cashQuotaValues : List of values present on screen
	 * @param months : The difference between start date and end date
	 * @param periodType : Period type of quota 
	 * @param paymentFreq : Freq of quota 
	 * @param noOfPeriods : No. Of Periods used in quota 
	 * @param employee : Employee to which quota is assigned
	 * @param amount1 : Amount for 1st period
	 * @param amount2 : Amount for 2nd period
	 * @param amount3 : Amount for 3rd period
	 * @param amount4 : Amount for 4th period
	 */
	
	public List<Double> quotaCalcalculation(String startDate, String endDate,List<String> cashQuotaValues, int months , String noOfPeriods, String amount1, String amount2 , String amount3, String amount4, String periodType , String payFreq) throws ParseException {
		List <Double> quotaCalValue = new ArrayList();
		LocalDate todayDate = LocalDate.now();
		
			if(periodType.equalsIgnoreCase("Monthly"))
			{
				double val1 = (Double.parseDouble(amount1)/12);
				BigDecimal bd = new BigDecimal(val1).setScale(2, RoundingMode.HALF_UP);
			      double amount1perPeriod = bd.doubleValue();
				double val2 = (Double.parseDouble(amount2)/12);
				BigDecimal bd2 = new BigDecimal(val2).setScale(2, RoundingMode.HALF_UP);
			      double amount2perPeriod = bd2.doubleValue();
				double val3 = (Double.parseDouble(amount3)/12);
				BigDecimal bd3 = new BigDecimal(val3).setScale(2, RoundingMode.HALF_UP);
			      double amount3perPeriod = bd3.doubleValue();
				double val4 = (Double.parseDouble(amount4)/12);
				BigDecimal bd4 = new BigDecimal(val4).setScale(2, RoundingMode.HALF_UP);
			      double amount4perPeriod = bd4.doubleValue();
			      
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate sDate = LocalDate.parse(startDate, formatter1); 
				LocalDate eDate = LocalDate.parse(endDate, formatter1); 

				int lastmonth = months+12;
				
				int monthDiff = todayDate.getMonthValue()- sDate.getMonthValue();
				
				if(payFreq.equalsIgnoreCase("Monthly")) {
				
				switch(monthDiff) {
				case 0: 
				case -1:
				case -2:
				case -3:
					
					quotaCalValue.add(amount1perPeriod);
					quotaCalValue.add(amount1perPeriod+amount2perPeriod);
					quotaCalValue.add(quotaCalValue.get(1)+amount3perPeriod);
					quotaCalValue.add(quotaCalValue.get(2)+amount4perPeriod);
						for(int j=4;j<=lastmonth;j++) {
							if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								}
								else
									quotaCalValue.add(quotaCalValue.get(j-1));
						}
					
					break;
				case 1:
				
					quotaCalValue.add(0.00);
					quotaCalValue.add(amount2perPeriod);
					quotaCalValue.add(quotaCalValue.get(1)+amount3perPeriod);
					quotaCalValue.add(quotaCalValue.get(2)+amount4perPeriod);
					
						for(int j=4;j<=lastmonth;j++) {
							if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								}
								else
									quotaCalValue.add(quotaCalValue.get(j-1));
						}
					
					break;
				case 2: 
					quotaCalValue.add(0.00);
					quotaCalValue.add(0.00);
					quotaCalValue.add(amount3perPeriod);
					quotaCalValue.add(quotaCalValue.get(2)+amount4perPeriod);
						for(int j=4;j<=lastmonth;j++) {
							if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								}
								else
									quotaCalValue.add(quotaCalValue.get(j-1));
						}
				
					break;
				case 3: 
					quotaCalValue.add(0.00);
					quotaCalValue.add(0.00);
					quotaCalValue.add(0.00);
					quotaCalValue.add(amount4perPeriod);
						for(int j=4;j<=lastmonth;j++) {
							
							if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								}
								else
									quotaCalValue.add(quotaCalValue.get(j-1));
						}
					
					break;
				default:
					quotaCalValue.add(0.00);
					quotaCalValue.add(0.00);
					quotaCalValue.add(0.00);
					quotaCalValue.add(0.00);
					quotaCalValue.add(amount4perPeriod);
					
						for(int j=5;j<=lastmonth;j++) {
							if(j<=months) {
							quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							}
							else
								quotaCalValue.add(quotaCalValue.get(j-1));
							
						}
						break;
					}
					
				
				
				System.out.println("Calculated values size"+quotaCalValue.size());
			}
				else if(payFreq.equalsIgnoreCase("Quarterly")) {
					
					double quatAmount1 =amount1perPeriod*3;
					double quatAmount2 =amount2perPeriod*3;
					double quatAmount3 =amount3perPeriod*3;
					double quatAmount4 =amount4perPeriod*3;
					int quatAmountCounter=0;
					switch(monthDiff) {
					case 0:
					case -1:
					case -2:
					case -3:
						int i =1;
						int k=0;
						quotaCalValue.add((new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						quotaCalValue.add((new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						quotaCalValue.add((new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						int j=3;
						while(j<lastmonth) {
							
							
							if(j<months+1) {
								
						quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount1)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
						k=i;
						quatAmountCounter=1;
							}
							
							if(j<months+1) {
								
						quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
						k=i;
						quatAmountCounter=2;
							}

						if(j<months+1) {
							
						quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
						k=i;
						i=i+1;
						quatAmountCounter=3;
						}
							
							else {
								 
								quotaCalValue.add(quotaCalValue.get(j-3));
								j=j+1;
						/*	  if((months+1)%3==0) {
									
									if(quatAmountCounter==3) {
										
									quotaCalValue.add((new BigDecimal((quatAmount4)*k+(quatAmount1)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									quatAmountCounter=1;
									}
									if(quatAmountCounter==1) {
									if(j<lastmonth||j==lastmonth) {
										
										quotaCalValue.add((new BigDecimal((quatAmount4)*k+(quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										quatAmountCounter=2;
									}
									}
									if(quatAmountCounter==2) {
									if(j<lastmonth||j==lastmonth) {
										
										quotaCalValue.add((new BigDecimal((quatAmount4)*k+(quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										k=i;
										i=i+1;
										quatAmountCounter=3;
									}
									}
									
								}
								else if((months+1)%3==1) {
									if(quatAmountCounter==3) {
										
									quotaCalValue.add((new BigDecimal((quatAmount4)*k+(quatAmount1)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									quatAmountCounter=1;
									}
									if(quatAmountCounter==1) {
									if(j<lastmonth||j==lastmonth) {
									
										quotaCalValue.add((new BigDecimal((quatAmount4)*(k-1)+(quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										quatAmountCounter=2;
									}
									}
									if(quatAmountCounter==2) {
									if(j<lastmonth||j==lastmonth) {
									
										quotaCalValue.add((new BigDecimal((quatAmount4)*(k-1)+(quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										i=i+1;
										quatAmountCounter=3;
									}
								}
								}
									else if((months+1)%3==2)
									{
						
											if(quatAmountCounter==3) {
												
											quotaCalValue.add((new BigDecimal((quatAmount4)*k+(quatAmount1)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
											j=j+1;
											quatAmountCounter=1;
											}
											if(quatAmountCounter==1) {
											if(j<lastmonth||j==lastmonth) {
												
												quotaCalValue.add((new BigDecimal((quatAmount4)*k+(quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
												j=j+1;
												quatAmountCounter=2;
											}
											}
											if(quatAmountCounter==2) {
											if(j<lastmonth||j==lastmonth) {
												
												quotaCalValue.add((new BigDecimal((quatAmount4)*(k-1)+(quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
												j=j+1;
												i=i+1;
												quatAmountCounter=3;
											}
									}
									}
									
								
			*/
								
							}
							
						
						}

						break;
					case 1:
						
						
						 i =1;
						 quotaCalValue.add(0.00);
						quotaCalValue.add((new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						quotaCalValue.add((new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						quotaCalValue.add((new BigDecimal(quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=4;
						while(j<lastmonth) {
							
							
							if(j<=months) {
								
						quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
						k=i;
						quatAmountCounter=1;
							}
							
							if(j<=months) {
								
						quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
						k=i;
						quatAmountCounter=2;
							}

						if(j<=months) {
							
						quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
						k=i;
						i=i+1;
						quatAmountCounter=3;
						}
							else {
								 
								quotaCalValue.add(quotaCalValue.get(j-3));
								j=j+1;

								
							}
							
						
						}
						break;
					case 2:
						 i =1;
						quotaCalValue.add(0.00);
						quotaCalValue.add(0.00);
						quotaCalValue.add(amount3perPeriod*3);
						quotaCalValue.add(amount4perPeriod*3);
						quotaCalValue.add(amount4perPeriod*3);
						j=5;
						while(j<lastmonth) {
							
							
								if(j<months+1) {
									
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									quatAmountCounter=1;
										}
										
										if(j<months+1) {
											
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									quatAmountCounter=2;
										}

									if(j<months+1) {
										
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									i=i+1;
									quatAmountCounter=3;
									}
							
							else {
								quotaCalValue.add(quotaCalValue.get(j-3));
								j=j+1;

								
							}
							
						
						}
						break;
					case 3:
						
						 i =1;
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(amount4perPeriod*3);
							quotaCalValue.add(amount4perPeriod*3);
							quotaCalValue.add(amount4perPeriod*3);
							j=6;
							while(j<lastmonth) {
								
								

								if(j<months+1) {
									
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									quatAmountCounter=1;
										}
										
										if(j<months+1) {
											
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									quatAmountCounter=2;
										}

									if(j<months+1) {
										
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									i=i+1;
									quatAmountCounter=3;
									}
								
								else {
									quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;

									
								}
								
							
							}
						
						
						break;
					default :
						 i =1;
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(amount4perPeriod*3);
							quotaCalValue.add(amount4perPeriod*3);
							quotaCalValue.add(amount4perPeriod*3);
							j=7;
							while(j<lastmonth) {
								
								if(j<=months) {

								if(j<months+1) {
									
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									quatAmountCounter=1;
										}
										
										if(j<months+1) {
											
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									quatAmountCounter=2;
										}

									if(j<months+1) {
										
									quotaCalValue.add((new BigDecimal((quatAmount4)*i+(quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									k=i;
									i=i+1;
									quatAmountCounter=3;
									}
							}
								else {
									quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;

									
								}
								
									
							}
						
							break;
					}
					
					
				
				}
				else if(payFreq.equalsIgnoreCase("Annually")) {
					int sMonth = sDate.getMonthValue();
					int nMonth=1;
					double quatAmount1 =amount1perPeriod*12;
					double quatAmount2 =amount2perPeriod*12;
					double quatAmount3 =amount3perPeriod*12;
					double quatAmount4 =amount4perPeriod*12;
					
					switch(monthDiff) {
					case 0:
					case -1:
					case -2:
					case -3:
						int i =1;
						
						quotaCalValue.add((new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						quotaCalValue.add((new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						quotaCalValue.add((new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						int j=3;
						while(j<lastmonth) {
							
							
						
						if(j<=months) {
							for(int m=0;m<12;m++) {
								if(j<=months) {
						quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
								}
							}
					 nMonth = (sDate.plusMonths(j)).getMonthValue();
						
						}
					
						else {
							 while(nMonth<sMonth) {
								 quotaCalValue.add(0.0);
								 nMonth=nMonth+1;
										 
							 }
							 for(int z=0;z<months+1;z++) {
								if(j<lastmonth&&quotaCalValue.get(z)!=0.0) {
							quotaCalValue.add(quotaCalValue.get(z));
							j=j+1;
								}
							 }
							
							
						}
							
			}
						break;
					case 1:
					
						 i =1;
						 
						 quotaCalValue.add(0.00);
						quotaCalValue.add((new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						quotaCalValue.add((new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
					    j=3;
						while(j<lastmonth) {
							
							
						
						if(j<=months) {
							for(int m=0;m<12;m++) {
								if(j<=months) {
						quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
								}
							}
					 nMonth = (sDate.plusMonths(j)).getMonthValue();
						
						}
					
						else {
							 while(nMonth<sMonth) {
								 quotaCalValue.add(0.0);
								 nMonth=nMonth+1;
										 
							 }
							 for(int z=0;z<months+1;z++) {
								if(j<lastmonth&&quotaCalValue.get(z)!=0.0) {
							quotaCalValue.add(quotaCalValue.get(z));
							j=j+1;
								}
							 }
							
							
						}
							
			}
						break;
					case 2:
						
						
						 quotaCalValue.add(0.00);
						 quotaCalValue.add(0.00);
						quotaCalValue.add((new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						
					    j=3;
						while(j<lastmonth) {
							
							
						
						if(j<=months) {
							for(int m=0;m<12;m++) {
								if(j<=months) {
						quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
								}
							}
					 nMonth = (sDate.plusMonths(j)).getMonthValue();
						
						}
					
						else {
							 while(nMonth<sMonth) {
								 quotaCalValue.add(0.0);
								 nMonth=nMonth+1;
										 
							 }
							 for(int z=0;z<months+1;z++) {
								if(j<lastmonth&&quotaCalValue.get(z)!=0.0) {
							quotaCalValue.add(quotaCalValue.get(z));
							j=j+1;
								}
							 }
							
							
						}
							
			}
						break;
					case 3:
						
						
						 quotaCalValue.add(0.00);
						 quotaCalValue.add(0.00);
						 quotaCalValue.add(0.00);
						
					    j=3;
						while(j<lastmonth) {
							
							
						
						if(j<=months) {
							for(int m=0;m<12;m++) {
								if(j<=months) {
						quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
								}
							}
					 nMonth = (sDate.plusMonths(j)).getMonthValue();
						
						}
					
						else {
							 while(nMonth<sMonth) {
								 quotaCalValue.add(0.0);
								 nMonth=nMonth+1;
										 
							 }
							 for(int z=0;z<months+1;z++) {
								if(j<lastmonth&&quotaCalValue.get(z)!=0.0) {
							quotaCalValue.add(quotaCalValue.get(z));
							j=j+1;
								}
							 }
							
							
						}
							
			}
						break;
					case 4:
						
						quotaCalValue.add(0.00);
						 quotaCalValue.add(0.00);
						 quotaCalValue.add(0.00);
						 quotaCalValue.add(0.00);
						
					    j=4;
						while(j<lastmonth) {
							
							
						
						if(j<months+1) {
							
						quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
						
						
					 nMonth = (sDate.plusMonths(j)).getMonthValue();
						
						}
					
						else {
							 while(nMonth<sMonth) {
								 quotaCalValue.add(0.00);
								 nMonth=nMonth+1;
										 
							 }
							 for(int z=0;z<months+1;z++) {
								if(j<lastmonth) {
							quotaCalValue.add(quotaCalValue.get(z));
							j=j+1;
								}
							 }
							 break;
							
						}
					
					

						
			}
						
				}
				}
			}
			else if(periodType.equalsIgnoreCase("Quarterly"))
			{
				double val1 = (Double.parseDouble(amount1)/12/3);
				BigDecimal bd = new BigDecimal(val1).setScale(2, RoundingMode.HALF_UP);
			      double amount1perPeriod = bd.doubleValue();
				double val2 = (Double.parseDouble(amount2)/12/3);
				BigDecimal bd2 = new BigDecimal(val2).setScale(2, RoundingMode.HALF_UP);
			      double amount2perPeriod = bd2.doubleValue();
				double val3 = (Double.parseDouble(amount3)/12/3);
				BigDecimal bd3 = new BigDecimal(val3).setScale(2, RoundingMode.HALF_UP);
			      double amount3perPeriod = bd3.doubleValue();
				double val4 = (Double.parseDouble(amount4)/12/3);
				BigDecimal bd4 = new BigDecimal(val4).setScale(2, RoundingMode.HALF_UP);
			      double amount4perPeriod = bd4.doubleValue();
			      
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate sDate = LocalDate.parse(startDate, formatter1); 
				LocalDate eDate = LocalDate.parse(endDate, formatter1); 

				int lastmonth = months+12;
				
				int monthDiff = todayDate.getMonthValue()- sDate.getMonthValue();
				 if(payFreq.equalsIgnoreCase("Monthly")) {
						
						switch(monthDiff) {
						case 0: 
						case -1:
						case -2:
						case -3:
							
							quotaCalValue.add(amount1perPeriod);
							int j=1;
							while(j<=lastmonth) {
								if(j<=months) {
									for(int r=0;r<2;r++) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount1perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									}
									for(int r=0;r<3;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									}
								
								
									for(int r=0;r<3;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									}
								}
								
									for(int r=0;r<3;r++) {
										if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
									}
								}
							}
								else
								{
									quotaCalValue.add(quotaCalValue.get(j-1));
								j=j+1;
								}
							}
							break;
						case 1:
						
							quotaCalValue.add(0.00);
							quotaCalValue.add(amount1perPeriod);
							 j=2;
							while(j<=lastmonth) {
								if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount1perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									for(int r=0;r<3;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									}
								
								
									for(int r=0;r<3;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									}
								}
								
									for(int r=0;r<3;r++) {
										if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
									}
								}
							}
								else
								{
									quotaCalValue.add(quotaCalValue.get(j-1));
								j=j+1;
								}
							}
							break;
						case 2: 
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(amount1perPeriod);
						   j=3;
							while(j<=lastmonth) {
								if(j<=months) {
									for(int r=0;r<3;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									}
								
								
									for(int r=0;r<3;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									}
								}
								
									for(int r=0;r<3;r++) {
										if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
									}
								}
							}
								else
								{
									quotaCalValue.add(quotaCalValue.get(j-1));
								j=j+1;
								}
							}
							break;
						case 3: 
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(amount2perPeriod);
							 j=4;
							while(j<=lastmonth) {
								if(j<=months) {
									for(int r=0;r<2;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									}
								
								
									for(int r=0;r<3;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									}
								}
								
									for(int r=0;r<3;r++) {
										if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
									}
								}
							}
								else
								{
									quotaCalValue.add(quotaCalValue.get(j-1));
								j=j+1;
								}
							}
							
							break;
						default:
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							quotaCalValue.add(amount2perPeriod);
							j=5;
							
								while(j<=lastmonth) {
									if(j<=months) {
										
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										
									
									
										for(int r=0;r<3;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
													}
															}
									
										for(int r=0;r<3;r++) {
											if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									}
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-1));
									j=j+1;
									}
								}
								break;
							}
							
						
						
						System.out.println("Calculated values size"+quotaCalValue.size());
					}
						else if(payFreq.equalsIgnoreCase("Quarterly")) {
							
							double quatAmount1 =amount1perPeriod*3;
							double quatAmount2 =amount2perPeriod*3;
							double quatAmount3 =amount3perPeriod*3;
							double quatAmount4 =amount4perPeriod*3;
							
							switch(monthDiff) {
							case 0:
							case -1:
							case -2:
							case -3:
							
								quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								int j=1;
								while(j<=lastmonth) {
									if(j<=months) {
										for(int r=0;r<2;r++) {
										quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										}
										int f=1;
										for(int r=0;r<3;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-f)+quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-f)+quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f+1;
										}
									}
										f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-f)+quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									f=f+1;
										}
									}
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;
									}
								}
								break;
							case 1:
								
								quotaCalValue.add(0.00);
								quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=2;
								while(j<=lastmonth) {
									if(j<=months) {
										
										quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										int f=2;
										for(int r=0;r<2;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-f)+quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=3;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-3)+quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f-1;
										}
									}
										f=2;
										for(int r=0;r<3;r++) {
											if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-3)+quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									f=f+1;
										}
									}
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;
									}
								}
								break;
							case 2:
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());

								j=5;
								while(j<=lastmonth) {
									if(j<=months) {
										
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										
										int f=2;
										for(int r=0;r<3;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-3)+quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-3)+quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f+1;
										}
									}
										
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;
									}
								}
								break;
							case 3:
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								j=3;
								while(j<=lastmonth) {
									if(j<=months) {
										for(int r=0;r<3;r++) {
										quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										}
										int f=1;
										for(int r=0;r<3;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-3)+quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-3)+quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f+1;
										}
									}
									
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;
									}
								}
								
								break;
							default :
								
								
									quotaCalValue.add(0.00);
									quotaCalValue.add(0.00);
									quotaCalValue.add(0.00);
									quotaCalValue.add(0.00);
									quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=5;
									while(j<=lastmonth) {
										if(j<=months) {
											
											quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
											j=j+1;
											
											int f=1;
											for(int r=0;r<3;r++) {
												
												if(j<=months) {
													
											quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-3)+quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
											f=f+1;
											j=j+1;
												}
											}
										
											 f=1;
											for(int r=0;r<3;r++) {
												if(j<=months) {
											quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-3)+quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
											j=j+1;
											f=f+1;
											}
										}
											
									}
										else
										{
											quotaCalValue.add(quotaCalValue.get(j-3));
										j=j+1;
										}
									}
										
											break;
									}
								
								
							}
							
							
						
						
						else if(payFreq.equalsIgnoreCase("Annually")) {
							int sMonth = sDate.getMonthValue();
							int nMonth=1;
							double quatAmount1 =amount1perPeriod*12;
							double quatAmount2 =amount2perPeriod*12;
							double quatAmount3 =amount3perPeriod*12;
							double quatAmount4 =amount4perPeriod*12;
							
							switch(monthDiff) {
							case 0:
							case -1:
							case -2:
							case -3:
								quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								int j=1;
								while(j<=lastmonth) {
									if(j<=months) {
										for(int r=0;r<2;r++) {
										quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										}
										int f=1;
										for(int r=0;r<3;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f+1;
										}
									}
										f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									f=f+1;
										}
									}
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;
									}
								}
								break;
							case 1:
								
								quotaCalValue.add(0.00);
								quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=2;
								while(j<=lastmonth) {
									if(j<=months) {
										
										quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										int f=2;
										for(int r=0;r<2;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=3;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f-1;
										}
									}
										f=2;
										for(int r=0;r<3;r++) {
											if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									f=f+1;
										}
									}
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;
									}
								}
								break;
							case 2:
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add( (new BigDecimal(quatAmount1).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());

								j=5;
								while(j<=lastmonth) {
									if(j<=months) {
										
										quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										
										int f=2;
										for(int r=0;r<3;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f+1;
										}
									}
										
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-12));
									j=j+1;
									}
								}
								break;
							case 3:
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								j=3;
								while(j<=lastmonth) {
									if(j<=months) {
										for(int r=0;r<3;r++) {
										quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										}
										int f=1;
										for(int r=0;r<3;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f+1;
										}
									}
									
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-12));
									j=j+1;
									}
								}
								
								break;
							case 4:
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=5;
								while(j<=lastmonth) {
									if(j<=months) {
										
										quotaCalValue.add( (new BigDecimal(quatAmount2).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										
										int f=1;
										for(int r=0;r<3;r++) {
											
											if(j<=months) {
												
										quotaCalValue.add( (new BigDecimal(quatAmount3).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										f=f+1;
										j=j+1;
											}
										}
									
										 f=1;
										for(int r=0;r<3;r++) {
											if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quatAmount4).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										f=f+1;
										}
									}
										
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-12));
									j=j+1;
									}
								}
								break;
								
						}
			}
			}
	
			else if(periodType.equalsIgnoreCase("Annually"))
			{
				double val1 = (Double.parseDouble(amount1)/12/12);
				BigDecimal bd = new BigDecimal(val1).setScale(2, RoundingMode.HALF_UP);
			      double amount1perPeriod = bd.doubleValue();
				double val2 = (Double.parseDouble(amount2)/12/12);
				BigDecimal bd2 = new BigDecimal(val2).setScale(2, RoundingMode.HALF_UP);
			      double amount2perPeriod = bd2.doubleValue();
				double val3 = (Double.parseDouble(amount3)/12/12);
				BigDecimal bd3 = new BigDecimal(val3).setScale(2, RoundingMode.HALF_UP);
			      double amount3perPeriod = bd3.doubleValue();
				double val4 = (Double.parseDouble(amount4)/12/12);
				BigDecimal bd4 = new BigDecimal(val4).setScale(2, RoundingMode.HALF_UP);
			      double amount4perPeriod = bd4.doubleValue();
			      
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate sDate = LocalDate.parse(startDate, formatter1); 
				LocalDate eDate = LocalDate.parse(endDate, formatter1); 

				int lastmonth = months+12;
				
				int monthDiff = todayDate.getMonthValue()- sDate.getMonthValue();
			
				if(payFreq.equalsIgnoreCase("Monthly")) {
					
					switch(monthDiff) {
					case 0: 
					case -1:
					case -2:
					case -3:
						quotaCalValue.add( (new BigDecimal(amount1perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						int j=1;
						while(j<=lastmonth) {
							if(j<=months) {
						for(int r=0;r<11;r++) {
							if(j<=months) {
							quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount1perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
							}
						
						}
								
						for(int r=0;r<12;r++) {
							if(j<=months) {
							quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
							}
							
						
						}		
						for(int r=0;r<12;r++) {
							if(j<=months) {
							quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
							}
						
						}
						for(int r=0;r<12;r++) {
							if(j<=months) {
							quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
							}
						
						}		
						}
							
					else
					{
										quotaCalValue.add(quotaCalValue.get(j-1));
										j=j+1;
					}
						}
						
						break;
					case 1:
					
						quotaCalValue.add(0.00);
						quotaCalValue.add(amount1perPeriod);
						quotaCalValue.add(quotaCalValue.get(1)+amount1perPeriod);
						
						j=3;
							while(j<=lastmonth) {
								if(j<=months) {
									for(int r=0;r<9;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount1perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									}
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
										
									
									}		
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									
									}
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										}
									
									}		
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-1));
										j=j+1;
									}
								
							}
							break;
						
					case 2: 
						quotaCalValue.add(0.00);
						quotaCalValue.add(0.00);
						quotaCalValue.add(amount1perPeriod);
						
						j=3;
							while(j<=lastmonth) {
								if(j<=months) {
									for(int r=0;r<9;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount1perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									}
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
										
									
									}		
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									
									}
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										}
									
									}		
									}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-1));
										j=j+1;
									}
							}
					
						break;
					case 3: 
						quotaCalValue.add(0.00);
						quotaCalValue.add(0.00);
						quotaCalValue.add(0.00);
						quotaCalValue.add(amount1perPeriod);
						j=4;
							while(j<=lastmonth) {
								
								if(j<=months) {
									for(int r=0;r<8;r++) {
										if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount1perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									}
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
										
									
									}		
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
										}
									
									}
									for(int r=0;r<12;r++) {
										if(j<=months) {
										quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
										}
									
									}		
								}
									else
									{
										quotaCalValue.add(quotaCalValue.get(j-1));
								j=j+1;
									}
							}
						
						break;
					default:
						quotaCalValue.add(0.00);
						quotaCalValue.add(0.00);
						quotaCalValue.add(0.00);
						quotaCalValue.add(0.00);
						quotaCalValue.add(amount1perPeriod);
						j=5;
							while(j<=lastmonth) {
								if(j<=months) {
									for(int r=0;r<7;r++) {
										if(j<=months) {
								quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount1perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
										}
									}
								for(int r=0;r<12;r++) {
									if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount2perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
									}
									
								
								}		
								for(int r=0;r<12;r++) {
									if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount3perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
									}
								
								}
								for(int r=0;r<12;r++) {
									if(j<=months) {
									quotaCalValue.add( (new BigDecimal(quotaCalValue.get(j-1)+amount4perPeriod).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
									}
								
								}		
								}
								else
								{
									quotaCalValue.add(quotaCalValue.get(j-1));
								j=j+1;
								}
								
							}
							break;
						}
						
					
					
					System.out.println("Calculated values size"+quotaCalValue.size());
				}
					else if(payFreq.equalsIgnoreCase("Quarterly")) {
						
						double quatAmount1 =amount1perPeriod*3;
						double quatAmount2 =amount2perPeriod*3;
						double quatAmount3 =amount3perPeriod*3;
						double quatAmount4 =amount4perPeriod*3;
						int quatAmountCounter=0;
						switch(monthDiff) {
						case 0:
						case -1:
						case -2:
						case -3:
							int i =1;
							int k=0;

							int j=0;
							while(j<lastmonth) {
								
								

								if(j<=months) {
									if(i<=3) {
									for (int l=0;l<3;l++) {
										if(j<=months) {
							quotaCalValue.add((new BigDecimal((quatAmount1)*i).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									}
									
									i=i+1;
									}
									if(i>3&&i<=6) {
										int f=1;
										for (int l=0;l<3;l++) {
											if(j<=months) {
												
								quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount2*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										f=f+1;
										i=i+1;
									}
									if(i>6&&i<=9) {
										int f=1;
									for (int l=0;l<3;l++) {
										
										if(j<=months) {
							quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									}
									f=f+1;
									i=i+1;
									}
									if(i>9&&i<=12) {
										int f=1;
										for (int l=0;l<3;l++) {
											if(j<=months) {
								quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										i=i+1;
										f=f+1;
										}
								}
								
								
								else {
									 
									quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;

									
								}
								
							
							}

							break;
						case 1:
							
							
							 i =1;
							 quotaCalValue.add(0.00);
							j=1;
							while(j<lastmonth) {
								
								

								if(j<=months) {
									if(i<=3) {
									for (int l=0;l<3;l++) {
										if(j<=months) {
							quotaCalValue.add((new BigDecimal((quatAmount1)*i).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									}
									
									i=i+1;
									}
									if(i>3&&i<=6) {
										int f=1;
										for (int l=0;l<3;l++) {
											if(j<=months) {
												
								quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount2*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										f=f+1;
										i=i+1;
									}
									if(i>6&&i<=9) {
										int f=1;
									for (int l=0;l<3;l++) {
										
										if(j<=months) {
							quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									}
									f=f+1;
									i=i+1;
									}
									if(i>9&&i<=12) {
										int f=1;
										for (int l=0;l<3;l++) {
											if(j<=months) {
								quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										i=i+1;
										f=f+1;
										}
								}
								
								
								else {
									 
									quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;

									
								}
								
							
							}
							break;
						case 2:
							 i =1;
							quotaCalValue.add(0.00);
							quotaCalValue.add(0.00);
							
							j=2;
							while(j<lastmonth) {
								
								

								if(j<=months) {
									if(i<=3) {
									for (int l=0;l<3;l++) {
										if(j<=months) {
							quotaCalValue.add((new BigDecimal((quatAmount1)*i).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									}
									
									i=i+1;
									}
									if(i>3&&i<=6) {
										int f=1;
										for (int l=0;l<3;l++) {
											if(j<=months) {
												
								quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount2*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										f=f+1;
										i=i+1;
									}
									if(i>6&&i<=9) {
										int f=1;
									for (int l=0;l<3;l++) {
										
										if(j<=months) {
							quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									}
									f=f+1;
									i=i+1;
									}
									if(i>9&&i<=12) {
										int f=1;
										for (int l=0;l<3;l++) {
											if(j<=months) {
								quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										i=i+1;
										f=f+1;
										}
								}
								
								
								else {
									 
									quotaCalValue.add(quotaCalValue.get(j-3));
									j=j+1;

									
								}
								
							
							}
							break;
						case 3:
							
							 i =1;
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								
								j=3;
								while(j<lastmonth) {
									
									

									if(j<=months) {
										if(i<=3) {
										for (int l=0;l<3;l++) {
											if(j<=months) {
								quotaCalValue.add((new BigDecimal((quatAmount1)*i).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										
										i=i+1;
										}
										if(i>3&&i<=6) {
											int f=1;
											for (int l=0;l<3;l++) {
												if(j<=months) {
													
									quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount2*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											}
											f=f+1;
											i=i+1;
										}
										if(i>6&&i<=9) {
											int f=1;
										for (int l=0;l<3;l++) {
											
											if(j<=months) {
								quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										f=f+1;
										i=i+1;
										}
										if(i>9&&i<=12) {
											int f=1;
											for (int l=0;l<3;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											}
											i=i+1;
											f=f+1;
											}
									}
									
									
									else {
										 
										quotaCalValue.add(quotaCalValue.get(j-3));
										j=j+1;

										
									}
									
								
								}
							
							
							break;
						default :
							 i =1;
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								quotaCalValue.add(0.00);
								
								j=4;
								while(j<lastmonth) {
									
									

									if(j<=months) {
										if(i<=3) {
										for (int l=0;l<3;l++) {
											if(j<=months) {
								quotaCalValue.add((new BigDecimal((quatAmount1)*i).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										
										i=i+1;
										}
										if(i>3&&i<=6) {
											int f=1;
											for (int l=0;l<3;l++) {
												if(j<=months) {
													
									quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount2*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											}
											f=f+1;
											i=i+1;
										}
										if(i>6&&i<=9) {
											int f=1;
										for (int l=0;l<3;l++) {
											
											if(j<=months) {
								quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
										f=f+1;
										i=i+1;
										}
										if(i>9&&i<=12) {
											int f=1;
											for (int l=0;l<3;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal(quotaCalValue.get(j-3)+(quatAmount3*f)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											}
											i=i+1;
											f=f+1;
											}
									}
									
									
									else {
										 
										quotaCalValue.add(quotaCalValue.get(j-3));
										j=j+1;

										
									}
									
								
								}
								break;
							
							
						}
						
						
					
					}
					else if(payFreq.equalsIgnoreCase("Annually")) {
						int sMonth = sDate.getMonthValue();
						int nMonth=1;
						int annualDiff =  todayDate.getMonthValue()-eDate.getMonthValue();
						double quatAmount1 =amount1perPeriod*12;
						double quatAmount2 =amount2perPeriod*12;
						double quatAmount3 =amount3perPeriod*12;
						double quatAmount4 =amount4perPeriod*12;
						
						switch(monthDiff) {
						case 0:
						case -1:
						case -2:
						case -3:
							int i =1;
							
							int fl =0;
							int j=0;
							while(j<lastmonth) {
								
								
									if(j<=months) {
										for (int l=0;l<12;l++) {
											if(j<=months) {
								quotaCalValue.add((new BigDecimal((quatAmount1)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
											for (int l=0;l<12;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal((quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											
										}
											for (int l=0;l<12;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal((quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											
										}	
											for (int l=0;l<12;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											
										}
								    	}
									
									
									else {
										if(fl==0) {
										for(int k=1;k<annualDiff;k++) {
											if(j<lastmonth) {
											quotaCalValue.add(0.0);
											j=j+1;
											}
										}
										fl=1;
										}
										for(int k=0;k<months;k++) {
											if(j<lastmonth&& quotaCalValue.get(k)!=0.0) {
										quotaCalValue.add(quotaCalValue.get(k));
										j=j+1;
											}
										}
										
									}
								
						
							
						}
								break;
								
							
						case 2:
							i=1;
							int flg =0;
							 quotaCalValue.add(0.00);
							 quotaCalValue.add(0.00);
						
						    j=2;
						    while(j<lastmonth) {
								
								
									if(j<=months) {
										for (int l=0;l<10;l++) {
											if(j<=months) {
								quotaCalValue.add((new BigDecimal((quatAmount1)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
								j=j+1;
											}
										}
											for (int l=0;l<12;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal((quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											
										}
											for (int l=0;l<12;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal((quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											
										}	
											for (int l=0;l<12;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											
										}
								    	}
									
									
									else {
										if(flg==0) {
										for(int k=1;k<annualDiff;k++) {
											if(j<lastmonth) {
											quotaCalValue.add(0.0);
											j=j+1;
											}
										}
										flg=1;
										}
										for(int k=0;k<months;k++) {
											if(j<lastmonth&& quotaCalValue.get(k)!=0.0) {
										quotaCalValue.add(quotaCalValue.get(k));
										j=j+1;
											}
										}
										
									}
								
						
							
						}
								break;
							
						case 3:
							i=1;
							 fl =0;
							 quotaCalValue.add(0.00);
							 quotaCalValue.add(0.00);
							 quotaCalValue.add(0.00);
							
						    j=3;
						    while(j<lastmonth) {
						    	if(j<=months) {
								for (int l=0;l<9;l++) {
									if(j<=months) {
						quotaCalValue.add((new BigDecimal((quatAmount1)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
						j=j+1;
									}
								}
									for (int l=0;l<12;l++) {
										if(j<=months) {
							quotaCalValue.add((new BigDecimal((quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									
								}
									for (int l=0;l<12;l++) {
										if(j<=months) {
							quotaCalValue.add((new BigDecimal((quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									
								}	
									for (int l=0;l<12;l++) {
										if(j<=months) {
							quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
							j=j+1;
										}
									
								}
						    	}
								
									else {
										if(fl==0) {
										for(int k=1;k<annualDiff;k++) {
											if(j<lastmonth) {
											quotaCalValue.add(0.0);
											j=j+1;
											}
										}
										fl=1;
										}
										for(int k=0;k<months;k++) {
											if(j<lastmonth&& quotaCalValue.get(k)!=0.0) {
										quotaCalValue.add(quotaCalValue.get(k));
										j=j+1;
											}
										}
										
									}
								}
						
							
						
							break;
							
						case 4:
							i=1;
							int f =0;
							quotaCalValue.add(0.00);
							 quotaCalValue.add(0.00);
							 quotaCalValue.add(0.00);
							 quotaCalValue.add(0.00);
							
						    j=4;
							while(j<lastmonth) {
								
									
										if(j<=months) {
											for (int l=0;l<8;l++) {
												if(j<=months) {
									quotaCalValue.add((new BigDecimal((quatAmount1)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
									j=j+1;
												}
											}
												for (int l=0;l<12;l++) {
													if(j<=months) {
										quotaCalValue.add((new BigDecimal((quatAmount2)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
													}
												
											}
												for (int l=0;l<12;l++) {
													if(j<=months) {
										quotaCalValue.add((new BigDecimal((quatAmount3)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
													}
												
											}	
												for (int l=0;l<12;l++) {
													if(j<=months) {
										quotaCalValue.add((new BigDecimal((quatAmount4)).setScale(2, RoundingMode.HALF_UP)).doubleValue());
										j=j+1;
													}
												
											}
									    	}
										
										
										else {
											if(f==0) {
											for(int k=1;k<annualDiff;k++) {
												if(j<lastmonth) {
												quotaCalValue.add(0.0);
												j=j+1;
												}
											}
											f=1;
											}
											for(int k=0;k<months;k++) {
												if(j<lastmonth&& quotaCalValue.get(k)!=0.0) {
											quotaCalValue.add(quotaCalValue.get(k));
											j=j+1;
												}
											}
											
										}
									
							
								
							}
							break;
							
					}
		
					}
			}
			return quotaCalValue;
	}
	/*
	 * This method verifies the quota allocations on Cash screen 
	 * @param revGL : The Revenue Gl used in Quota creation
	 * @param startDate : Quota start Date 
	 * @param endDate: Quota end date 
	 * @param periodType : Period type of quota 
	 * @param paymentFreq : Freq of quota 
	 * @param noOfPeriods : No. Of Periods used in quota 
	 * @param employee : Employee to which quota is assigned
	 * @param amount1 : Amount for 1st period
	 * @param amount2 : Amount for 2nd period
	 * @param amount3 : Amount for 3rd period
	 * @param amount4 : Amount for 4th period
	 */
	
	public void validateQuotaAllocations(String revGL, String startDate, String endDate,String periodType, String paymentFreq , String noOfPeriods, String employee, String amount1,String amount2,String amount3, String amount4) throws InterruptedException, ParseException, IOException {
		
		Map<Integer, List<String>> counterAndValues = new HashMap<Integer, List<String>>();
		counterAndValues = locatingValues(revGL, employee, startDate, endDate);
		Set<Integer> monthCount = counterAndValues.keySet();
		TreeSet sortedSet = new TreeSet<Integer>(monthCount);
	    int months = (int) sortedSet.first();
	    
	    List<String> cashQuotaValues = counterAndValues.get(months);
	    List <Double> calculatedValues = quotaCalcalculation(startDate, endDate, cashQuotaValues, months, noOfPeriods, amount1,amount2,amount3,amount4, periodType, paymentFreq);
	    minWait();
	    for(int i =0;i<calculatedValues.size();i++) {
	    	Logger(cashQuotaValues.get(i).replace(",",""), Double.toString(calculatedValues.get(i)));
	    }
		
		
	}
	/*
	 * This method calculates expense 
	 * @param startDate : This is the start date of expense account 
	 * @param edPayTerm : Payment term of expense account
	 * @param paymentFreq : Billing cycle of expense account 
	 * @param endDate : End date of expense account
	 */
	public List<String> expenseCalculation(String startDate,String edPayTerm,String paymentFreq,String endDate,String value) throws ParseException {
		
		List <String> expCalValue = new ArrayList();

		DateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = (Date) formatter1.parse(endDate);
		SimpleDateFormat newFormat1 = new SimpleDateFormat("yyy-MM-dd");
		String eDate = newFormat1.format(date1);
		
		DateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy");
		Date date2 = (Date) formatter2.parse(startDate);
		SimpleDateFormat newFormat2 = new SimpleDateFormat("yyy-MM-dd");
		String sDate = newFormat2.format(date2);
		
		Period diff = Period.between(LocalDate.parse(eDate).withDayOfMonth(1),
				LocalDate.parse(sDate).withDayOfMonth(1));
		int counter1;
		if(diff.toString().contains("Y")) {
		int  diff1= diff.getMonths();
		
		
			counter1 = 12-diff1;
		}
		else 
		{
				int index1=	diff.toString().indexOf("-");
	            int index2 = diff.toString().indexOf("M");
	            counter1= Integer.parseInt(diff.toString().substring(index1+1,index2));
	 
		}
		
		Log.info("Difference between start date and end date is: "+counter1);
		
		switch(edPayTerm) {
			case "On Delivery":
				if(paymentFreq.equalsIgnoreCase("Monthly")) {
					for(int i=0;i<=counter1;i++) {
						expCalValue.add(value);
					}
					
				}
				else if(paymentFreq.equalsIgnoreCase("Quarterly")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						if(i<=counter1) {
							expCalValue.add("0.0");
							i++;
							}
						if(i<=counter1) {
							expCalValue.add("0.0");
							i++;
							}
					}
					
				}
				else if(paymentFreq.equalsIgnoreCase("Semi Annually")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						for(int l=0;l<5;l++) {
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							
						}
					}
					
				}
				else if(paymentFreq.equalsIgnoreCase("Annually")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						for(int l=0;l<11;l++) {
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							
						}
					}
					
				}
				
				break;
			case "Net 15":
				if(paymentFreq.equalsIgnoreCase("Monthly")) {
					for(int i=0;i<=counter1;i++) {
						expCalValue.add(value);
					}
				}
				else if(paymentFreq.equalsIgnoreCase("Quarterly")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						if(i<=counter1) {
							expCalValue.add("0.0");
							i++;
							}
						if(i<=counter1) {
							expCalValue.add("0.0");
							i++;
							}
					}
					for(int k=0;k<10;k++) {
						expCalValue.add("0.0");
						i++;
					}
				}
				else if(paymentFreq.equalsIgnoreCase("Semi Annually")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						for(int l=0;l<5;l++) {
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							
						}
					}
					
				}
				else if(paymentFreq.equalsIgnoreCase("Annually")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						for(int l=0;l<11;l++) {
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							
						}
					}
					
				}
				break;
			case "Net 30":
				expCalValue.add("0.0");
				if(paymentFreq.equalsIgnoreCase("Monthly")) {
					for(int i=0;i<=counter1;i++) {
						expCalValue.add(value);
					}
				}
				else if(paymentFreq.equalsIgnoreCase("Quarterly")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						if(i<=counter1) {
							expCalValue.add("0.0");
							i++;
							}
						if(i<=counter1) {
							expCalValue.add("0.0");
							i++;
							}
					}
				}
				else if(paymentFreq.equalsIgnoreCase("Semi Annually")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						for(int l=0;l<5;l++) {
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							
						}
					}
					
				}
				else if(paymentFreq.equalsIgnoreCase("Annually")) {
					int i=0;
					while(i<=counter1) {
						if(i<=counter1) {
						expCalValue.add(value);
						i++;
						}
						for(int l=0;l<11;l++) {
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							
						}
					}
					
				}
				
				break;
			case "Net 45":
				
					expCalValue.add("0.0");
					if(paymentFreq.equalsIgnoreCase("Monthly")) {
						for(int i=0;i<=counter1;i++) {
							expCalValue.add(value);
						}
					}
					else if(paymentFreq.equalsIgnoreCase("Quarterly")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
						}
					}
					else if(paymentFreq.equalsIgnoreCase("Semi Annually")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							for(int l=0;l<5;l++) {
								if(i<=counter1) {
									expCalValue.add("0.0");
									i++;
									}
								
							}
						}
						
					}
					else if(paymentFreq.equalsIgnoreCase("Annually")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							for(int l=0;l<11;l++) {
								if(i<=counter1) {
									expCalValue.add("0.0");
									i++;
									}
								
							}
						}
						
					}
				break;
			case "Net 60":
			
					expCalValue.add("0.0");
					expCalValue.add("0.0");
					if(paymentFreq.equalsIgnoreCase("Monthly")) {
						for(int i=0;i<=counter1;i++) {
							expCalValue.add(value);
						}
					}
					else if(paymentFreq.equalsIgnoreCase("Quarterly")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
						}
					}
					else if(paymentFreq.equalsIgnoreCase("Semi Annually")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							for(int l=0;l<5;l++) {
								if(i<=counter1) {
									expCalValue.add("0.0");
									i++;
									}
								
							}
						}
						
					}
					else if(paymentFreq.equalsIgnoreCase("Annually")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							for(int l=0;l<11;l++) {
								if(i<=counter1) {
									expCalValue.add("0.0");
									i++;
									}
								
							}
						}
						
					}
				
				break;
			case "Net 75":
				
					expCalValue.add("0.0");
					expCalValue.add("0.0");
					if(paymentFreq.equalsIgnoreCase("Monthly")) {
						for(int i=0;i<=counter1;i++) {
							expCalValue.add(value);
						}
					}
					else if(paymentFreq.equalsIgnoreCase("Quarterly")) {
						
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
						}
					}
					else if(paymentFreq.equalsIgnoreCase("Semi Annually")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							for(int l=0;l<5;l++) {
								if(i<=counter1) {
									expCalValue.add("0.0");
									i++;
									}
								
							}
						}
						
					}
					else if(paymentFreq.equalsIgnoreCase("Annually")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							for(int l=0;l<11;l++) {
								if(i<=counter1) {
									expCalValue.add("0.0");
									i++;
									}
								
							}
						}
						
					}
				
				break;
			case "Net 90":
				
					expCalValue.add("0.0");
					expCalValue.add("0.0");
					expCalValue.add("0.0");

					if(paymentFreq.equalsIgnoreCase("Monthly")) {
						for(int i=0;i<=counter1;i++) {
							expCalValue.add(value);
						}
					}
					else if(paymentFreq.equalsIgnoreCase("Quarterly")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
							if(i<=counter1) {
								expCalValue.add("0.0");
								i++;
								}
						}
					}
					else if(paymentFreq.equalsIgnoreCase("Semi Annually")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							for(int l=0;l<5;l++) {
								if(i<=counter1) {
									expCalValue.add("0.0");
									i++;
									}
								
							}
						}
						
					}
					else if(paymentFreq.equalsIgnoreCase("Annually")) {
						int i=0;
						while(i<=counter1) {
							if(i<=counter1) {
							expCalValue.add(value);
							i++;
							}
							for(int l=0;l<11;l++) {
								if(i<=counter1) {
									expCalValue.add("0.0");
									i++;
									}
								
							}
						}
						
					}
				
				break;
		}
		return expCalValue;
	}
	
	/*
	 * This method validates the expense allocations on cash screen
	 * @param glName: This stores the name of the Gl for which the expense account is created 
	 * @param expAccount : Stores the account name of expense accounts
	 * @param startDate : This is the start date 
	 * @param endDate : This stores the end date 
	 */
	public void validateExpenseAllocations(String glName, String expAccount, String startDate, String endDate, String payterm, String payFreq,String value) throws InterruptedException, ParseException, IOException {
		Map<Integer, List<String>> counterAndValues = new HashMap<Integer, List<String>>();
		counterAndValues = locatingValues(glName, expAccount, startDate, endDate);
		Set<Integer> monthCount = counterAndValues.keySet();
		TreeSet sortedSet = new TreeSet<Integer>(monthCount);
	    int months = (int) sortedSet.first();
	    List<String> cashExpenseValues = counterAndValues.get(months);
	    
	    List <String> calculatedValues = expenseCalculation(startDate, payterm, payFreq, endDate, value);
	    minWait();
	    for(int i =0;i<calculatedValues.size();i++) {
	    	Logger(cashExpenseValues.get(i).replace(",",""), calculatedValues.get(i));
	    }
		
	}
}
