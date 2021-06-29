package com.bookmyshow.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bookmyshow.base.BaseUI;
import com.bookmyshow.excel.DataProviderTest;
import com.bookmyshow.pages.HomePage;

@Listeners(com.bookmyshow.utils.ListenerUtils.class)
public class SigninWindowTests {

	HomePage objHomePage;

	// driver initialization
	public static WebDriver driver;

	@BeforeTest
	public void setup() throws IOException {
		System.out.println("********************************************************************");
		System.out.println("TESTS FOR SIGNIN ");
		System.out.println("********************************************************************");
		driver = BaseUI.invokeBrowser();
		driver.get(BaseUI.setUrl());
		objHomePage = new HomePage(driver);
		objHomePage.popup();
		objHomePage.selectArea("Chennai");
		objHomePage.signinButton();

	}

	@Test(priority = 0,dataProviderClass= DataProviderTest.class, dataProvider = "InvalidUser", groups = "Smoke")
	public void Test_Invalid_UserName( String user, String pswd)
			throws IOException, InterruptedException, Exception {

		try {
				objHomePage.selectContinueViaGoogle();
				objHomePage.invalidUserName(driver, user, pswd);
			
		} catch (IOException e) {

		}
	}

	@Test(priority = 1,dataProviderClass= DataProviderTest.class, dataProvider = "InvalidPassword", groups = "Smoke")
	public void Test_Invalid_Password( String user, String pswd)
			throws IOException, InterruptedException, Exception {

		try {
			
				objHomePage.selectContinueViaGoogle();

				objHomePage.invalidsignin(driver, user, pswd);
			

		} catch (IOException e) {

		}
	}

	@Test(priority = 2,dataProviderClass= DataProviderTest.class, dataProvider = "BlankUserName", groups = "Smoke")
	public void Test_Blank_UserName(String user, String pswd)
			throws IOException, InterruptedException, Exception {

		try {
			
				objHomePage.selectContinueViaGoogle();

				objHomePage.invalidUserName(driver, user, pswd);
			
		} catch (IOException e) {

		}
	}

	@Test(priority = 3,dataProviderClass= DataProviderTest.class, dataProvider = "BlankPassword", groups = "Smoke")
	public void Test_Blank_Password( String user, String pswd)
			throws IOException, InterruptedException, Exception {

		
			objHomePage.selectContinueViaGoogle();

			objHomePage.blankPassword(driver, user, pswd);
		
	}

	@Test(priority = 4,dataProviderClass= DataProviderTest.class, dataProvider = "CorretCredentials", groups = "Smoke")
	public void Test_Signing_In_Appears_Correctly(String user, String pswd)
			throws IOException, InterruptedException, Exception {

		try {
			
				objHomePage.selectContinueViaGoogle();

				objHomePage.validsignin(driver, user, pswd);
			
		} catch (IOException e) {

		}
	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
