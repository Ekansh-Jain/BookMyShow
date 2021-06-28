package com.bookmyshow.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookmyshow.utils.FileIO;
import com.google.common.base.Function;

public class HomePage {

	public WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;
	// initialize the elements of the Page Object or instantiate the Page Objects

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
		prop = FileIO.initProperties();
	}

	// get url of the current page
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	// clicking the required location. xpath is taken from the properties file.
	public void selectArea(String city) throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> cityList = driver.findElements(By.xpath(prop.getProperty("citylist")));
		for (WebElement w : cityList) {
			if (w.getText().equalsIgnoreCase(city)) {
				w.click();
				break;
			}
		}

	}

	// clicking "not now" in the popup. xpath is taken from the properties file.
	public void popup() {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);

			WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					List<WebElement> ele = driver.findElements(By.xpath(prop.getProperty("notnow")));
					if (ele.size() != 0) {
						for (WebElement w : ele) {
							w.click();
							return w;
						}
					}
					return null;
				}
			});
		} catch (Exception e) {
			System.out.println("Popup not exist");
		}

	}

	// clicking the signin button. xpath is taken from the properties file.
	public void signinButton() throws IOException {
		WebElement element = driver.findElement(By.xpath(prop.getProperty("signin")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}

	// clicking the continue-via-google button. xpath is taken from the properties
	// file.
	public void selectContinueViaGoogle() {
		driver.switchTo().activeElement();
		driver.findElement(By.xpath(prop.getProperty("continueviagoogle"))).click();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	}

	// clicking the continue-via-email button. xpath is taken from the properties
	// file.
	public void selectContinueViaEmail() throws IOException {
		WebElement element = driver.findElement(By.xpath(prop.getProperty("continueviaemail")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}

	// signing in to bookmyshow
	public void validsignin(WebDriver driver, String strUserName, String strPassword)
			throws IOException, InterruptedException {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}

		this.setUserName(strUserName);

		this.clicknext();

		this.setPassword(strPassword);

		this.clicknext();

		driver.switchTo().window(parentWindow);

	}

	public void invalidsignin(WebDriver driver, String strUserName, String strPassword)
			throws IOException, InterruptedException {

		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}

		this.setUserName(strUserName);

		this.clicknext();

		this.setPassword(strPassword);

		this.clicknext();

		WebElement element = driver.findElement(By.xpath(prop.getProperty("errorpassword")));

		String errormessage = element.getText();
		System.out.println("********************************************************************");
		System.out.println(errormessage);
		System.out.println("********************************************************************");

		driver.close();

		driver.switchTo().window(parentWindow);

	}

	public void invalidUserName(WebDriver driver, String strUserName, String strPassword)
			throws IOException, InterruptedException {

		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}

		this.setUserName(strUserName);

		this.clicknext();

		WebElement element = driver.findElement(By.xpath(prop.getProperty("errorusername")));

		String errormessage = element.getText();

		System.out.println("********************************************************************");
		System.out.println(errormessage);
		System.out.println("********************************************************************");

		driver.close();

		driver.switchTo().window(parentWindow);

	}

	public void blankPassword(WebDriver driver, String strUserName, String strPassword)
			throws IOException, InterruptedException {

		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows) {
			if (!parentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}

		this.setUserName(strUserName);

		this.clicknext();
		this.setPassword(strPassword);
		this.clicknext();
		
		WebElement element = driver.findElement(By.xpath(prop.getProperty("errorblankpassword")));

		String errormessage = element.getText();

		System.out.println("********************************************************************");
		System.out.println(errormessage);
		System.out.println("********************************************************************");

		driver.close();

		driver.switchTo().window(parentWindow);

	}

	// entering the username using sendkeys. xpath is taken from the properties
	// file.
	public void setUserName(String strUserName) throws IOException {
		WebElement emailid = driver.findElement(By.xpath(prop.getProperty("emailid")));
		emailid.click();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		emailid.clear();
		emailid.sendKeys(strUserName);
	}

	// clicking next after entering the username. xpath is taken from the properties
	// file.
	public void clicknext() throws IOException {
		driver.findElement(By.xpath(prop.getProperty("next"))).click();
		wait = new WebDriverWait(driver, 20);
	}

	// entering the password using sendkeys. xpath is taken from the properties
	// file.
	public void setPassword(String strPassword) throws IOException {

		WebElement password = driver.findElement(By.xpath(prop.getProperty("passwordenter")));
		password.click();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		password.clear();
		password.sendKeys(strPassword);
	}

}
