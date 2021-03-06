package com.bookmyshow.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {

	private static WebDriver driver;

	/********* Invoke Chrome Driver **********/
	public static WebDriver getChromeDriver() {
		String userDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userDir
				+ BaseUI.prop.getProperty("chromeDriver"));
		ChromeOptions co = new ChromeOptions();
		
		co.addArguments("--disable-infobars");
		co.addArguments("--disable-gpu");
		 co.addArguments("--disable-web-security");
        co.addArguments("--allow-running-insecure-content");
		co.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		return driver;
	}

	/********* Invoke Firefox Driver **********/
	public static WebDriver getFirefoxDriver() {
		String userDir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", userDir
				+ BaseUI.prop.getProperty("firefoxDriver"));
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--disable-infobars");
		fo.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
		driver = new FirefoxDriver(fo);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		return driver;
	}

	/********* Invoke MSEdge Driver **********/
	public static WebDriver getMSEdgeDriver() {
		String userDir = System.getProperty("user.dir");
		EdgeOptions ed = new EdgeOptions();
		ed.setCapability("browserstack.ie.enablePopups", true);
		System.setProperty("webdriver.edge.driver", userDir
				+ BaseUI.prop.getProperty("msedgeDriver"));
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		return driver;
	}

}
