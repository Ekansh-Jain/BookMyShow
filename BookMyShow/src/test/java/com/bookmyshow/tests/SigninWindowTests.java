package com.bookmyshow.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bookmyshow.base.BaseUI;
import com.bookmyshow.excel.ExcelImport;
import com.bookmyshow.pages.HomePage;
@Listeners(com.bookmyshow.utils.ListenerUtils.class)
public class SigninWindowTests {

	ActualValues objmainpage;
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

	@Test(priority = 0, dataProvider = "Authentication", groups = "Smoke")
	public void Test_Invalid_UserName(String testc,String user, String pswd) throws IOException, InterruptedException, Exception {

		try {
			if(testc.equalsIgnoreCase("Test_Invalid_UserName")) 
			{
				objHomePage.selectContinueViaGoogle();
				objHomePage.invalidUserName(driver,user, pswd);
			}

		} catch (IOException e) {

		}
	}

	@Test(priority = 1, dataProvider = "Authentication", groups = "Smoke")
	public void Test_Invalid_Password(String testc,String user, String pswd) throws IOException, InterruptedException, Exception {

		try {
			if(testc.equalsIgnoreCase("Test_Invalid_Password")) {
				objHomePage.selectContinueViaGoogle();
			
				objHomePage.invalidsignin(driver, user, pswd);
			}

		} catch (IOException e) {

		}
	}

	@Test(priority = 2, dataProvider = "Authentication", groups = "Smoke")
	public void Test_Blank_UserName(String testc,String user, String pswd) throws IOException, InterruptedException, Exception {

		try {
			if(testc.equalsIgnoreCase("Test_Blank_UserName")) {
				objHomePage.selectContinueViaGoogle();
		
				objHomePage.invalidUserName(driver,user, pswd);
			}
		} catch (IOException e) {

		}
	}

	@Test(priority = 3, dataProvider = "Authentication", groups = "Smoke")
	public void Test_Blank_Password(String testc,String user, String pswd) throws IOException, InterruptedException, Exception {
		
		if(testc.equalsIgnoreCase("Test_Blank_Password")) {
			objHomePage.selectContinueViaGoogle();
		
			objHomePage.blankPassword(driver, user, pswd);
		}
	}

	@Test(priority = 4, dataProvider = "Authentication", groups = "Smoke")
	public void Test_Signing_In_Appears_Correctly(String testc,String user, String pswd)
			throws IOException, InterruptedException, Exception {

		try {
			if(testc.equalsIgnoreCase("Test_Signing_In_Appears_Correctly")) {
				objHomePage.selectContinueViaGoogle();
			
				objHomePage.validsignin(driver,user, pswd);
			}
		} catch (IOException e) {

		}
	}

	@AfterTest
	public void close() {
		driver.quit();
	}

	@DataProvider(name = "Authentication")
	public String[][] getData() throws IOException {
		
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx";
		ExcelImport ex=new ExcelImport(path);
		int r=ex.getRowCount("Sheet1");
		int c=ex.getCellCount("Sheet1", 1);
		
		String[][] signInData=new String[r][c];
		
		for(int i=1;i<=r;i++) {
			for(int j=0;j<c;j++) {
				signInData[i-1][j]=ex.getCellData("Sheet1", i, j);
			}
		}
		return signInData;
	}
}
