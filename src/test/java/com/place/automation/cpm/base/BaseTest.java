package com.place.automation.cpm.base;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.dom4j.DocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
import com.place.automation.cpm.pages.BatchSettings;
import com.place.automation.cpm.pages.CashProjection;
import com.place.automation.cpm.pages.CashProjectionBeta;
import com.place.automation.cpm.pages.CategoryPage;
import com.place.automation.cpm.pages.EmployeePage;
import com.place.automation.cpm.pages.ExpensePage;
import com.place.automation.cpm.pages.GlAccountPage;
import com.place.automation.cpm.pages.Homepage;
import com.place.automation.cpm.pages.LoginPage;
import com.place.automation.cpm.pages.OrganizationPage;
import com.place.automation.cpm.pages.PLForecast;
import com.place.automation.cpm.pages.PLForecastBeta;
import com.place.automation.cpm.pages.PlaceCPMAdminPage;
import com.place.automation.cpm.pages.PracticeSessionAccountPage;
import com.place.automation.cpm.pages.QuotaSchedule;
import com.place.automation.cpm.pages.RevenuePage;
import com.place.automation.cpm.pages.SFbasic;
import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public ExpensePage expensePage;
	public LoginPage loginPage;
	public RevenuePage revenuePage;
	public Homepage homePage;
	public CategoryPage categoryPage;
	public GlAccountPage glAccountPage;
	public OrganizationPage orgPage;
	public SFbasic sfBasic;
	public BatchSettings batchSettings;
	public PlaceCPMAdminPage placeCPMAdminPage;
	public PLForecast plForecast;
	public PLForecastBeta plForecastBeta;
	public CashProjection cashProjection;
    public EmployeePage employee;
    public CashProjectionBeta cashProjectionBeta;
    public QuotaSchedule quota;
    public PracticeSessionAccountPage accountPage;
   
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static final String currentDir = System.getProperty("user.dir");
	//public static String TESTDATA_SHEET_PATH = currentDir + "//src//test//resources//testdata//ExpRevFinal.xlsx";
	public static String TESTDATA_SHEET_PATH = currentDir + "//src//test//resources//testdata//ExpRevFinal.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	
	

	@BeforeTest
	public void testngBrowserlaunch() throws FileNotFoundException, IOException, DocumentException {
		callBasicConfigFiles();
		String browser = prop.getProperty("browser");
		Log.info("browsername is: " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			//Log.info("browsername is: " + browser);
			System.out.println("browser value is chrome");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Constants.chromeDriverPath);
			String downloadFilepath = System.getProperty("user.dir")+"/downloads";
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			//chromeOptions.addArguments("--disable-infobars"); this is obselete now it doesn't work after chrome 75 version
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			
			//chromeOptions.setExperimentalOption("credentials_enable_service", false);
			//chromeOptions.setExperimentalOption("profile.password_manager_enabled", false);
			
			//this is to setup new download path
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		    chromePrefs.put("profile.default_content_settings.popups", 0);
		    chromePrefs.put("download.default_directory", downloadFilepath);
		    chromeOptions.setExperimentalOption("prefs", chromePrefs);
		  chromePrefs.put("profile.default_content_settings.popups", 0);
		  chromePrefs.put("download.default_directory", downloadFilepath);
		  chromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(chromeOptions);
			Log.info("Initialized the driver successfully");	

		} else if (browser.equalsIgnoreCase("firefox")) {
			Log.info("browsername is: " + browser);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +  Constants.firefoxDriverPath);
			driver = new FirefoxDriver();
			Log.info("Initialied firefox finally");
		}
		else if ((browser.equalsIgnoreCase("safari"))) {
			Log.info("browsername is: " + browser);
			driver = new SafariDriver();
		}
		else if (browser.equals("chromeheadless")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Constants.chromeDriverPath);
			

			//String downloadFilepath = currentDir + "//src//test//resources//dataValidationCsvOutputFiles";
			
			String downloadFilepath = System.getProperty("user.dir")+"/downloads";

			
			//this is to setup new download path
//			ChromeOptions chromeOptions = new ChromeOptions();
//		    chromeOptions.setExperimentalOption("prefs", chromePrefs);
//		  chromePrefs.put("profile.default_content_settings.popups", 0);
//		  chromePrefs.put("download.default_directory", downloadFilepath);
//		  //chromeOptions.setExperimentalOption("prefs", chromePrefs);
			
			
			
			
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();  
			 chromePrefs.put("profile.default_content_settings.popups", 0);  
			 chromePrefs.put("download.default_directory", downloadFilepath);  
			  chromePrefs.put("profile.default_content_settings.popups", 0);
			  chromePrefs.put("download.default_directory", downloadFilepath);

			
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Constants.chromeDriverPath);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--disable-popup-blocking");
			chromeOptions.addArguments("--window-size=1440,900");
			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("--ignore-certificate-errors");
			chromeOptions.addArguments("--test-type");
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
		
			DesiredCapabilities cap = new DesiredCapabilities();  
			 cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  
			 cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);  
			
			driver = new ChromeDriver(chromeOptions);
			Log.info("Chrome Headless Browser initilized Successfully");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// driver.get(prop.getProperty("url"));
		loadPageObjects();
		getInstance();
	}

//	@BeforeMethod
//	public void LogIn(ITestResult result) throws Exception {
//		System.out.println("Executing TestCase Name :" + result.getMethod().getMethodName());
//		logger = extent.startTest(result.getMethod().getMethodName());
//		//logger = extent.createTest(result.getMethod().getMethodName());
//	}
	
//	@AfterMethod
//	public void Logout(ITestResult result) throws Exception {
//		//Call Program to Capture screenshot in selenium for failed test cases
//		System.out.println("I am within after method now and value of result is "+result.getStatus());
//		getresult(result);
//	}


	@AfterTest
	public void closeBrowser1() {
		// end_report();
		closebrowser();

	}

	public void closebrowser() {
		driver.close();
		driver.quit();
		System.out.println("Close Browser Successfully");
	}

	public static void setExtent() {

		Log.info("setting up the extent report configuration");
		String path = System.getProperty("user.dir") + Constants.extentReportsPath;
		
		extent = new ExtentReports(path, true);
		extent.addSystemInfo("Host Name", "Deepak MacBook Pro");
		extent.addSystemInfo("user Name", "Deepak Sharma");
		extent.addSystemInfo("Environment", "Staging");

	}

	public static ExtentReports getInstance() {
		if (extent == null) {
			setExtent();
		}
		return extent;
	}

	@AfterMethod
	public void Logout(ITestResult result) throws Exception {

//	logger = extent.startTest(result.getMethod().getMethodName());
		getresult(result);
	}

	
	@BeforeMethod
	public  void LogIn(Method method) throws Exception {
		String testName = method.getName();
		Log.info("**************************************");
		Log.info("**********" +testName+"***********");
		Log.info("**************************************");
		
		logger = extent.startTest(testName.toUpperCase());
			
		
	}
	
	
	

	
	@AfterSuite
	public void flush_report() {
		end_report();

	}

	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test case failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test case failed is " + result.getThrowable());

			String screenshotPath = screenshotCap(driver);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));

		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test case skipeed is " + result.getName());
			logger.log(LogStatus.SKIP, "Test case skipped is " + result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "test case passed is " + result.getName());
			 logger.log(LogStatus.PASS, "Test case passed is " +result.getThrowable());
		}

		extent.endTest(logger);
	}

	public String screenshotCap(WebDriver driver) throws IOException {
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String d = System.getProperty("user.dir") + "/FailedTestScreenshots/" + "screenshot_" + date + ".jpg";
		//String d = System.getProperty("user.dir") + "/FailedTestScreenshots/" + "screenshot_" + date + ".png";
		System.out.println("value of string destination is: " + d);
		File destination = new File(d);
		FileUtils.copyFile(source, destination);
		return d;
	}

	public void end_report() {
		extent.flush();
		// extent.close();
	}

	public void loadPageObjects() {
		expensePage = new ExpensePage(driver);
		loginPage = new LoginPage(driver);
		revenuePage = new RevenuePage(driver);
		homePage = new Homepage(driver);
		categoryPage = new CategoryPage(driver);
		glAccountPage = new GlAccountPage(driver);
		orgPage = new OrganizationPage(driver);
		sfBasic = new SFbasic(driver);
		batchSettings = new BatchSettings(driver);
		placeCPMAdminPage = new PlaceCPMAdminPage(driver);

		plForecast = new PLForecast(driver);
		plForecastBeta = new PLForecastBeta(driver);
		cashProjection = new CashProjection(driver);
		employee = new EmployeePage(driver);
		cashProjectionBeta = new CashProjectionBeta(driver);
		quota = new QuotaSchedule(driver);
		accountPage = new PracticeSessionAccountPage(driver);
		
		Log.info("objects loaded successfully");

	}

	// Call basic configuration
	public void callBasicConfigFiles() throws FileNotFoundException, IOException, DocumentException {
		log4j_config();
		readConFigFile();		
	}

	// Initilize the log file
	public void log4j_config() {
		PropertyConfigurator
				.configure(System.getProperty("user.dir") + Constants.configFolder + Constants.lg4jPropFileName);

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println("ts object values is: " + ts);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		Log.info("going to return the failed screenshot");
		Log.info("***Placed screen shot at " + destinationFile + " ***");
		return destinationFile;

	}

	public void minWait() throws InterruptedException {
		Thread.sleep(5000);
	}

	public static Object[][] getTestData(String SheetName, String fileName) {

		System.out.println("we are inside the getTestData method");
		FileInputStream file = null;
		try {
			
			String fPath = currentDir + "//src//test//resources//testdata//"+fileName;
			
			file = new FileInputStream(fPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		System.out.println("number of row is: " + sheet.getLastRowNum());
//		System.out.println("number of column is: " + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				//System.out.println("I am runmning for loop");
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//				System.out.println(data[i][k]);
//				System.out.println("I am done with loop");
			}
		}

		return data;
	}

	// init the prop file
		public void readConFigFile() {
			Log.info("Load Property File");
			if (prop == null) {
				prop = new Properties();
				try {
					FileInputStream fs = new FileInputStream(
							System.getProperty("user.dir") + Constants.configFolder + Constants.PropertyFileName);
					prop.load(fs);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Log.info("Property File Initilized");
		}
	
		public ExtentTest methodLog(String result) throws Exception {
			logger = extent.startTest(result);
			//logger = extent.startTest(result.getMethod().getMethodName());
			//getresult(result);
			return logger;
		}
		
		public void extreporting(String info , String message , String status) throws Exception {
			
		    logger.log(LogStatus.INFO, info);
		     if(status.equalsIgnoreCase("Pass")) {
		     logger.log(LogStatus.PASS, message);
		     Log.info(message);
		     }
		     else if(status.equalsIgnoreCase("Fail")) {
		    	 logger.log(LogStatus.FAIL, message);
		    	 Log.info(message);
		     }
		}
	
}
