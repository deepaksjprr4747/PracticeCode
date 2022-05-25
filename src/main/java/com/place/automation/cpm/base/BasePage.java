package com.place.automation.cpm.base;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.BaseTestMethod;

import com.place.automation.utils.Constants;
import com.place.automation.utils.Log;

public class BasePage {

	public WebDriver driver;
	public WebElement element;
	
			

	public By lightningLauncher = By.xpath("//div/span[contains(.,'App Launcher')]");
	public By launcherSearchBar = By.xpath("//input[@placeholder='Search apps and items...']");
	public By appLauncher = By.xpath("//input[@placeholder='Search apps or items...']");
	public By categoriesOption = By.xpath("//span/p[contains(.,'Categories')]");
	public By newButtonOnPage = By.xpath("(//a[@title='New'])[1]");
	public By saveButtonOnPage = By.xpath("(//button/span[text()='Save'])[2]");
	public By glAccountTextbox = By.xpath("//label/span[contains(.,'GL Account')]/../following-sibling::div//input");
	public By searchBox = By.xpath("//input[contains(@placeholder,'Search')and @class='slds-input']");
	public By sideBar = By.xpath("//div[@class='slds-th__action']");
	public void switchTo_Lightning() throws Exception {

		boolean visibleStatus = driver.findElement(lightningLauncher).isDisplayed();
		if (visibleStatus) {
			System.out.println("Already on lightning");
		} else {
			System.out.println("Need to switch to lightning first");
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public WebElement findElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public WebElement findElements(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public void minWait() throws InterruptedException {
		Thread.sleep(4000);
	}

	public void maxWait() throws InterruptedException {
		Thread.sleep(10000);
	}
	public void maximumWait() throws InterruptedException {
		Thread.sleep(28000);
	}
	public void customWait(int durationInMiliSeconds) throws InterruptedException {
		Thread.sleep(durationInMiliSeconds);
	}

	public void waitTillInvisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout_Max);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	public void waitTillvisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout_Max);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void clickElement(WebDriver driver, By locator) throws InterruptedException {
		element = findElement(driver, locator);

		// Highlight the element to be clicked
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);

		// Scroll until element doesn't appear
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		if (element.isDisplayed() || element.isEnabled()) {
			js.executeScript("arguments[0].click();", element);
			WaitForCompleteLoad(driver);
			minWait();

		} else {
			System.out.println("element doesn't exist");
		}

	}
	
	public void clickElement(WebElement webElement) {


		// Highlight the element to be clicked
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", webElement);

		// Scroll until element doesn't appear
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);

		
			js.executeScript("arguments[0].click();", webElement);
			WaitForCompleteLoad(driver);

		

	}

	public void enterText(WebDriver driver, By locator, String text) throws InterruptedException {
		element = findElement(driver, locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
		WebDriverWait wait = new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

		if (element.isDisplayed()) {
			element.clear();
		
			element.sendKeys(text);
			minWait();
			//element.sendKeys(Keys.ENTER);
			//minWait();
			Log.info("entered the text " + text + " successfully");
		}

	}

	public void Scroll_ByBottomofpage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// This will scroll the web page till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Log.info("scrolled till bottom successfully");
	}

	public void doubleClickElement(WebDriver driver, By locator) {
		Actions action = new Actions(driver);

		element = findElement(driver, locator);
		if (element.isDisplayed() || element.isEnabled()) {
			action.doubleClick(element).perform();
			WaitForCompleteLoad(driver);
		}

	}

	public void hoverOnElement(WebDriver driver, By locator) throws InterruptedException {
		Actions action = new Actions(driver);

		element = findElement(driver, locator);

		if (element.isDisplayed() || element.isEnabled()) {
			action.moveToElement(element).perform();

			// action.contextClick(element).perform();
			System.out.println("Hovered successfully");
			minWait();
			// action.doubleClick(element).perform();
			WaitForCompleteLoad(driver);
		}

	}

	public String getText(By locator) {
		String actualValue = driver.findElement(locator).getText();
		System.out.println("Actual value is " + actualValue);
		return actualValue;
	}

	public Timestamp getTimeStampRandomNumber() {
		// 2019-04-18 00:18:45.346
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		return timestamp;
	}

	public boolean verifyText(String actualValue, String expectedTextKey) {
		if (actualValue.equals(expectedTextKey))
			return true;
		else
			return false;

	}

	public String deeptakescreenshot(WebDriver driver) throws IOException {
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String d = System.getProperty("user.dir") + "/FailedTestScreenshots/" + "screenshot_" + date + ".png";
		Log.info("value of string destination is: " + d);
		File destination = new File(d);
		FileUtils.copyFile(source, destination);
		return d;
	}

	public void WaitForCompleteLoad(WebDriver driver) {
		new WebDriverWait(driver, Constants.PAGE_LOAD_Timeout).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollTop)");
		Log.info("scrolled to top successfully");
	}

	public void scrollLarge() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,-12000)");
		js.executeScript("window.scrollBy(0,36000)");
		Log.info("scrolled down by 12000 pixel vertical");
	}

	public void scrollLeft(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(-30000, 0)");
		Log.info("Scrolled to left");
	}

	public void scrollAbit() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // This  will scroll down the page by  900 pixel vertical		
        js.executeScript("window.scrollBy(0,900)");
	}

	public void scrollBelow(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

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
	      // wait until the file is downloaded
	      Long percentage = (long) 0;
	      while ( percentage!= 100) {
	          try {
	              percentage = (Long) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value");
	              //System.out.println(percentage);
	          }catch (Exception e) {
	            // Nothing to do just wait
	        }
	          Thread.sleep(1000);
	      }
	     // get the latest downloaded file name
	      String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
	     // get the latest downloaded file url
	      String sourceURL = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').href");
	      // file downloaded location
	      String donwloadedAt = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div.is-active.focus-row-active #file-icon-wrapper img').src");
	      System.out.println("Download deatils");
	      System.out.println("File Name :-" + fileName);
	      System.out.println("Donwloaded path :- " + donwloadedAt);
	      System.out.println("Downloaded from url :- " + sourceURL);
	     // print the details
	      System.out.println(fileName);
	      System.out.println(sourceURL);
	     // close the downloads tab2
	      driver.close();
	     // switch back to main window
	      driver.switchTo().window(mainWindow);
	      return fileName;
	  }
	
	public void sendKeys(WebDriver driver,By locator, String value ) {
	 driver.findElement(locator).sendKeys(value);	
		
	}
	public void clearText(WebDriver driver, By locator) {
		driver.findElement(locator).clear();
	}
	
	public void click(WebDriver driver, By locator) {
		driver.findElement(locator).click();
	}
	
	public void scrollByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // This  will scroll down the page by  900 pixel vertical		
        js.executeScript("window.scrollBy(0,900)");
	}
	public void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // This  will scroll up the page by  100 pixel vertical		
        js.executeScript("window.scrollBy(0,-1000)");
	}
	public String screenshotCap(WebDriver driver) throws IOException {
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String d = System.getProperty("user.dir") + "/FailedTestScreenshots/" + "screenshot_" + date + ".png";
		System.out.println("value of string destination is: " + d);
		File destination = new File(d);
		FileUtils.copyFile(source, destination);
		return d;
	}
	
	public void scrollover() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1080)");
		Log.info("Scrolled successfully");
	}
	public boolean verifyPresence(By locator) {
		try {
	driver.findElement(locator).isDisplayed();
	return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void scrollToElement(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	
	public void scrollDown() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
	}
	
public void scrollDown(int i, By locator) throws InterruptedException {
		
		List<WebElement> scrollinglist =  driver.findElements(locator);
		
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",scrollinglist.get(i));
		
		minWait();
	}
public void scrollRight() {
	
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;     
	jse.executeScript("document.querySelector('table th:last-child').scrollIntoView();");
	
		
}
public void horizontalScroll() {
	WebElement scrollArea = driver.findElement(By.id("mainComponent"));

	// Scroll to div's most right:
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
}
public void findRecord(String searchText ) throws InterruptedException {
	minWait();
	driver.navigate().refresh();
	minWait();
	enterText(driver, searchBox, searchText);
	click(driver, sideBar);
	maxWait();
	clickElement(driver, By.xpath("//a[text()='"+searchText+"']"));
	maxWait();
	
	
}
public void scrollingup() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    Log.info("Scrolled the screen up");
}
public void waitFortheElementToBeInvisible(By locator) {
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600)).pollingEvery(Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	
}

}
